package io.temperley.leaflet.codegen;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class ResourceUtils {

    public static Stream<String> getFile(String name) throws IOException, URISyntaxException {

        URL resource = getResource(name);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());

        return Files.lines(path);
    }

    public static boolean exists(String name) {

        URL resource = getResource(name);

        return resource != null;
    }

    public static URL getResource(String name) {
        return ResourceUtils.class.getClassLoader()
                .getResource(name);
    }
}
