package io.temperley.leaflet.codegen;

import edu.princeton.cs.algorithms.BreadthFirstDirectedPaths;
import edu.princeton.cs.algorithms.Digraph;
import io.temperley.leaflet.options.TakesServerOptions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class Gen {

    public static void main(String[] args) throws IOException, URISyntaxException {

        List<TagInfo> tagsFromFile = getTagInfo();

        for (TagInfo tagInfo : tagsFromFile) {
            if (tagInfo.fileExists()) {
                GenMethods.genMethods(tagInfo);
                GenHtml.genHtml(tagInfo);
            }
            tagInfo.setIsOptions(true);
            if (tagInfo.fileExists()) {
                GenOptions.genOptions(tagInfo);
            }
        }

    }

//    private static List<TagInfo> getTagsFromFile(String fileName) throws IOException, URISyntaxException {
//
//        Stream<String> lines = getFile(fileName);
//
//        List<String> collect = lines.collect(Collectors.toList());
//
//        Stream<TagInfo> stream = lines
//                .filter(f -> !f.startsWith("#"))
//                .map(f -> f.split("\t"))
//                .map(f -> {
//                    if (f.length == 3) {
//                        //fixme
//                        return new TagInfo(f[0], f[1], new TagInfo(f[2], f[1]));
//                    }
//                    return new TagInfo(f[0], f[1]);
//                });
//
//        return stream.collect(Collectors.toList());
//    }

    public static List<TagInfo> getTagInfo() throws IOException, URISyntaxException {

        Stream<String> lines = getFile("tags.tsv");

        //build nodes
        Stream<String[]> stream = lines
                .filter(f -> !f.startsWith("#"))
                .map(f -> f.split("\t"));

        List<String[]> table = stream.collect(Collectors.toList());

        Set<String> classes = table.stream()
                .map(f -> new String[] {f[0], f[2]})
                .flatMap(Arrays::stream).collect(Collectors.toSet());

        int N = classes.size();
        String[] strings = classes.toArray(new String[N]);

        java.util.Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            map.put(strings[i], i);
        }

        java.util.Map<String, String> classNameToPackage = new HashMap<>();
        // build graph
        Digraph G = new Digraph(N);
        for (String[] row : table) {
            String s0 = row[0];
            String s1 = row[2];

            Integer v0 = map.get(s0);
            Integer v1 = map.get(s1);
            G.addEdge(v1, v0);

            classNameToPackage.put(s0, row[1]);
        }

        Integer object = map.get("object");
        BreadthFirstDirectedPaths breadthFirstDirectedPaths = new BreadthFirstDirectedPaths(G, object);

        List<TagInfo> tagInfos = new ArrayList<>();
        for (String[] row : table) {
            String c = row[0];
            String p = row[1];
            String s = row[2];

            int i = map.get(c);
            LinkedList<String> linkedList = new LinkedList<>();
            Iterable<Integer> integers = breadthFirstDirectedPaths.pathTo(i);
            for (Integer integer : integers) {
                linkedList.add(strings[integer]);
            }

            String className = linkedList.getLast();
            linkedList.removeLast();
            String superClassName = linkedList.getLast();
            TagInfo tagInfoSuper = new TagInfo(superClassName, classNameToPackage.get(superClassName));
            TagInfo tagInfo = new TagInfo(className, row[1], tagInfoSuper);
        }

        return tagInfos;
    }
}
