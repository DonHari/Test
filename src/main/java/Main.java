import org.apache.log4j.Logger;

import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    private static ResourceBundle bundle;
    private static CityTZ cityTZ;
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
//        log.setUseParentHandlers(false);

        Locale defaultLocale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("text", defaultLocale);

        if(args.length == 0){
            log.error("Startup parameters doesn't pass.");
            System.out.println(toUtf(bundle.getString("text.error")));
            System.exit(1);
        }

        cityTZ = new CityTZ(args[0], args.length >= 2 ? args[1] : "");

        displayGreetings();

        writeToLogFile();
        
    }

    public static void displayGreetings() throws UnsupportedEncodingException {
        long currentHour = Long.valueOf(cityTZ.getTime("HH"));
        String message = "";
        if(currentHour >= 6 && currentHour < 9){
            message += toUtf(bundle.getString("text.hello_m"));
        }
        else if(currentHour >= 9 && currentHour < 19){
            message += toUtf(bundle.getString("text.hello_d"));
        }
        else if(currentHour >= 19 && currentHour < 23) {
            message += toUtf(bundle.getString("text.hello_e"));
        }
        else{
            message += toUtf(bundle.getString("text.hello_n"));
        }

        message += ", " + cityTZ.getName();

        System.out.println(message);
    }

    public static String toUtf(String str) throws UnsupportedEncodingException {
        if(str == null)
            return null;
        return new String(str.getBytes("ISO8859-1"), "UTF-8");
    }

    public static void writeToLogFile() throws IOException {
        String message = "";
        message += "City: " + cityTZ.getName() + ";\t";
        message += "Time: " + cityTZ.getTime("HH:mm:ss z") + ";\t";
        if(cityTZ.getId() != null && cityTZ.getId().length() != 0){
            message += "Time zone id: " + cityTZ.getId() + ";";
        }
        log.info(message);
    }
}
