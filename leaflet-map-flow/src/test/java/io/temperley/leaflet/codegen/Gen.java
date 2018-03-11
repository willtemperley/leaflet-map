package io.temperley.leaflet.codegen;

import io.temperley.leaflet.options.TakesServerOptions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.temperley.leaflet.codegen.ResourceUtils.getFile;

public class Gen {

    public static void main(String[] args) throws IOException, URISyntaxException {


        List<TagInfo> tagsFromFile = getTagsFromFile("tags.tsv");

        for (TagInfo tagInfo : tagsFromFile) {
            GenOptions.genOptions(tagInfo);
            String fileName = tagInfo.getFileName(false);
            if (ResourceUtils.exists(fileName)) {
                GenMethods.genMethods(tagInfo, TakesServerOptions.class);
                GenHtml.genHtml(tagInfo);
            }
        }

    }


    private static List<TagInfo> getTagsFromFile(String fileName) throws IOException, URISyntaxException {

        Stream<String> lines = getFile(fileName);

        Stream<TagInfo> stream = lines
                .filter(f -> !f.startsWith("#"))
                .map(f -> f.split("\t"))
                .map(f -> {
                    if (f.length == 3) {
                        return new TagInfo(f[0], f[1], f[2]);
                    }
                    return new TagInfo(f[0], f[1]);
                });

        return stream.collect(Collectors.toList());
    }
}
