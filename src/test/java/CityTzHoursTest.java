import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CityTzHoursTest {

    private long getExpectedTime(String timeZone){
        TimeZone timezone = TimeZone.getTimeZone(timeZone);
        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        return Long.valueOf(s);
    }

    @Test
    public void passingEmptyParam(){
        CityTZ cityTZ = new CityTZ("", "");
        long result = Long.valueOf(cityTZ.getTime("HH"));

        long expect = getExpectedTime("");

        assertEquals(expect, result);
    }

    @Test
    public void passingCity(){
        CityTZ cityTZ = new CityTZ("Tbilisi", "");
        long result = Long.valueOf(cityTZ.getTime("HH"));

        long expect = getExpectedTime("Asia/Tbilisi");

        assertEquals(expect, result);
    }

    @Test
    public void passingTZ(){
        CityTZ cityTZ = new CityTZ("", "Europe/Kiev");
        long result = Long.valueOf(cityTZ.getTime("HH"));

        long expect = getExpectedTime("Europe/Kiev");

        assertEquals(expect, result);
    }

    @Test
    public void passingAllParam(){
        CityTZ cityTZ = new CityTZ("New York", "America/New_York");
        long result = Long.valueOf(cityTZ.getTime("HH"));

        long expect = getExpectedTime("America/New_York");

        assertEquals(expect, result);
    }

    @Test
    public void passingNullParam(){
        CityTZ cityTZ = new CityTZ(null, null);
        long result = Long.valueOf(cityTZ.getTime("HH"));

        long expect = getExpectedTime("");

        assertEquals(expect, result);
    }
}
