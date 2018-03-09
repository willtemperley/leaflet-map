package io.temperley.leaflet.opts;

import io.temperley.leaflet.FitBoundsOptions;
import org.junit.Test;

public class OptionsTest {

    @Test
    public void testOptions() {

        FitBoundsOptions boundsOptions
                = new FitBoundsOptions().duration(5).animate(true).maxZoom(3);
    }
}
