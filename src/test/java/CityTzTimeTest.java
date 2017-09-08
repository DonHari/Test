import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

/**
 * Created by Стас on 08.09.2017.
 */
public class CityTzTimeTest {
    @Test
    public void testA(){
        CityTZ cityTZ = new CityTZ("", "");
        String result = cityTZ.getTime();

        TimeZone timezone = TimeZone.getTimeZone("");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String expect = formatter.format(calendar.getTime());

        assertEquals(expect, result);
    }

    @Test
    public void testB(){
        CityTZ cityTZ = new CityTZ("Tbilisi", "");
        String result = cityTZ.getTime();

        TimeZone timezone = TimeZone.getTimeZone("Asia/Tbilisi");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String expect = formatter.format(calendar.getTime());

        assertEquals(expect, result);
    }

    @Test
    public void testC(){
        CityTZ cityTZ = new CityTZ("", "Europe/Kiev");
        String result = cityTZ.getTime();

        TimeZone timezone = TimeZone.getTimeZone("Europe/Kiev");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String expect = formatter.format(calendar.getTime());

        assertEquals(expect, result);
    }

    @Test
    public void testD(){
        CityTZ cityTZ = new CityTZ("New York", " America/New_York");
        String result = cityTZ.getTime();

        TimeZone timezone = TimeZone.getTimeZone(" America/New_York");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String expect = formatter.format(calendar.getTime());

        assertEquals(expect, result);
    }

    //если город и часовой пояс не указаны, то выведет GMT+0
    @Test
    public void testE(){
        CityTZ cityTZ = new CityTZ(null, null);
        String result = cityTZ.getTime();

        TimeZone timezone = TimeZone.getTimeZone("");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String expect = formatter.format(calendar.getTime());

        assertEquals(expect, result);
    }
}
