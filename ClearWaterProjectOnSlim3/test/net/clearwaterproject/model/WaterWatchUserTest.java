package net.clearwaterproject.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WaterWatchUserTest extends AppEngineTestCase {

    private WaterWatchUser model = new WaterWatchUser();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
