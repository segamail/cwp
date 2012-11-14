package net.clearwaterproject.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class WaterAddCommentTest extends AppEngineTestCase {

    private WaterAddComment model = new WaterAddComment();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
