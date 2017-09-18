import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

public class toUtfTest {

    @Test
    public void passingNotEmptyString() throws UnsupportedEncodingException {
        String result = Main.toUtf("Ð\u0094Ð¾Ð±Ñ\u0080Ð¾Ðµ Ñ\u0083Ñ\u0082Ñ\u0080Ð¾");
        assertEquals("Доброе утро", result);
    }

    @Test
    public void passingNullParam() throws UnsupportedEncodingException {
        String result = Main.toUtf(null);
        assertTrue(result == null);
    }

    @Test
    public void passingEmptyString() throws UnsupportedEncodingException {
        String result = Main.toUtf("");
        assertEquals("", result);
    }
}
