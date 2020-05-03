package Tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import task3_1_2.RunLengthEncoding;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DecodingTest {
    private RunLengthEncoding rle = new RunLengthEncoding();
    private String expected;
    private String value;
    private String wrongValue;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"AAAAaaaBBBBBB\\12", "4A3a6B\\\\\\1\\2", "4A3a6B\\\\\\1\\45"},
                {"AaaaBB\\\\2", "1A3a2B\\\\\\\\\\2", "1A3a2B\\\\\\\\\\66"},
                {"AaaaBB2", "1A3a2B\\2", "1A3a2B\\89"}});
    }

    public DecodingTest(String expected, String value, String wrongValue) {

        this.expected = expected;
        this.value = value;
        this.wrongValue = wrongValue;
    }

    @Test
    public void decode() {
        assertEquals(expected, rle.decode(value));
    }

    @Test(expected = RuntimeException.class)
    public void decodingException() {
        rle.decode(wrongValue);

    }

}