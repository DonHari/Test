import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.UnsupportedEncodingException;

public class IsoToUtfTest {

    @Test
    public void IsoToUtfTestA() throws UnsupportedEncodingException {
        String result = Main.IsoToUtf("Ð\u0094Ð¾Ð±Ñ\u0080Ð¾Ðµ Ñ\u0083Ñ\u0082Ñ\u0080Ð¾");
        assertEquals("Доброе утро", result);
    }

    @Test
    public void IsoToUtfTestB() throws UnsupportedEncodingException {
        String result = Main.IsoToUtf(null);
        assertEquals(null, null);
    }

    @Test
    public void IsoToUtfTestC() throws UnsupportedEncodingException {
        String result = Main.IsoToUtf("");
        assertEquals("", "");
    }
}
