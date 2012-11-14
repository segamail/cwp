package net.clearwaterproject.model;

import net.clearwaterproject.model.UserPicture;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class UserPictureTest extends AppEngineTestCase {

    private UserPicture model = new UserPicture();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
