import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class CityTZ {
    String name;
    String id;

    public String getTime(){
        TimeZone timezone;
        if(this.id == null || this.id.length() == 0){
            String[] ids = TimeZone.getAvailableIDs();
            String finalID = "";
            if(name != null) {
                String buffer = name.replace(' ', '_');
                for (String id : ids) {
                    if ( id.contains(buffer) ) {
                        finalID = id;
                        break;
                    }
                }
            }
            //если не найдено, то выведет время GMT+0
            timezone = TimeZone.getTimeZone(finalID);
        }
        else{
            timezone = TimeZone.getTimeZone(id);
        }

        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss z");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        return formatter.format(calendar.getTime());
    }

    public long getCurrentHours(){
        TimeZone timezone;
        if(this.id == null || this.id.length() == 0){
            String[] ids = TimeZone.getAvailableIDs();
            String finalID = "";
            if(name != null) {
                String buffer = name.replace(' ', '_');
                for (String id : ids) {
                    if ( id.contains(buffer) ) {
                        finalID = id;
                        break;
                    }
                }
            }
            //если не найдено, то выведет время GMT+0
            timezone = TimeZone.getTimeZone(finalID);
        }
        else{
            timezone = TimeZone.getTimeZone(id);
        }

        Calendar calendar = Calendar.getInstance(timezone);
        DateFormat formatter = new SimpleDateFormat("HH");
        formatter.setCalendar(calendar);
        formatter.setTimeZone(timezone);
        String s = formatter.format(calendar.getTime());
        return Long.valueOf(s.substring(0, 2));
    }

    public CityTZ(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
