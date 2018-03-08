package io.temperley.leaflet.codegen;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Utils {
    static Stream<String> getFile(String name) throws IOException, URISyntaxException {

        URL resource = GenOptions.class.getClassLoader()
                .getResource(name);
        Path path = Paths.get(Objects.requireNonNull(resource).toURI());

        return Files.lines(path);

    }
}
