package net.clearwaterproject.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WaterInfoPictureTest extends AppEngineTestCase {

    private WaterInfoPicture model = new WaterInfoPicture();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
