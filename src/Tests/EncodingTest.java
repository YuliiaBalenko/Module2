package Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task3_1_2.RunLengthEncoding;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class EncodingTest {
    private RunLengthEncoding rle = new RunLengthEncoding();
    private String expected;
    private String value;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{{"4A3a6B\\\\\\1\\2","AAAAaaaBBBBBB\\12"},{"1A3a2B\\\\\\\\\\2","AaaaBB\\\\2"}, {"1A3a2B\\2","AaaaBB2"}});
    }
    public EncodingTest(String expected, String value) {

        this.expected = expected;
        this.value = value;
    }

    @Test
    public void encode() {
        assertEquals(expected, rle.encode(value));

    }
}