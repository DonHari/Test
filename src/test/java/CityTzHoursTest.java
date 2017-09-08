import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
/**
 * Created by Стас on 08.09.2017.
 */
public class CityTzHoursTest {
    @Test
    public void testA(){
        CityTZ cityTZ = new CityTZ("", "");
        long result = cityTZ.getCurrentHours();

        TimeZone timezone = TimeZone.getTimeZone("");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        long expect = Long.valueOf(s.substring(0, 2));

        assertEquals(expect, result);
    }

    @Test
    public void testB(){
        CityTZ cityTZ = new CityTZ("Tbilisi", "");
        long result = cityTZ.getCurrentHours();

        TimeZone timezone = TimeZone.getTimeZone("Asia/Tbilisi");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        long expect = Long.valueOf(s.substring(0, 2));

        assertEquals(expect, result);
    }

    @Test
    public void testC(){
        CityTZ cityTZ = new CityTZ("", "Europe/Kiev");
        long result = cityTZ.getCurrentHours();

        TimeZone timezone = TimeZone.getTimeZone("Europe/Kiev");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        long expect = Long.valueOf(s.substring(0, 2));

        assertEquals(expect, result);
    }

    @Test
    public void testD(){
        CityTZ cityTZ = new CityTZ("New York", " America/New_York");
        long result = cityTZ.getCurrentHours();

        TimeZone timezone = TimeZone.getTimeZone(" America/New_York");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        long expect = Long.valueOf(s.substring(0, 2));

        assertEquals(expect, result);
    }

    //если город и часовой пояс не указаны, то выведет GMT+0
    @Test
    public void testE(){
        CityTZ cityTZ = new CityTZ(null, null);
        long result = cityTZ.getCurrentHours();

        TimeZone timezone = TimeZone.getTimeZone("");
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        long expect = Long.valueOf(s.substring(0, 2));

        assertEquals(expect, result);
    }
}
