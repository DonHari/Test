import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static ResourceBundle bundle;
    private static CityTZ cityTZ;

    public static void main(String[] args) throws Exception {
        if(args.length == 0){
            System.exit(1);
        }

        cityTZ = new CityTZ(args[0], args.length >= 2 ? args[1] : "");

        Locale defaultLocale = Locale.getDefault();
        bundle = ResourceBundle.getBundle("text", defaultLocale);

        displayGreetings();

        writeToLogFile();
    }

    public static void displayGreetings() throws UnsupportedEncodingException {
        long currentHour = cityTZ.getCurrentHours();
        String message = "";
        if(currentHour >= 6 && currentHour < 9){
            message += IsoToUtf(bundle.getString("text.hello_m"));
        }
        else if(currentHour >= 9 && currentHour < 19){
            message += IsoToUtf(bundle.getString("text.hello_d"));
        }
        else if(currentHour >= 19 && currentHour < 23) {
            message += IsoToUtf(bundle.getString("text.hello_e"));
        }
        else{
            message += IsoToUtf(bundle.getString("text.hello_n"));
        }

        message += ", " + cityTZ.getName();

        System.out.println(message);
    }

    public static String IsoToUtf(String str) throws UnsupportedEncodingException {
        if(str == null)
            return null;
        return new String(str.getBytes("ISO8859-1"), "UTF-8");
    }

    public static void writeToLogFile() throws IOException {
        //лог-файл будет возле jar-файла
        String appPath = new File(".").getAbsolutePath();

        String message = "";
        message += "City: " + cityTZ.getName() + ";\t";
        message += "Time: " + cityTZ.getTime() + ";\t";
        if(cityTZ.getId() != null && cityTZ.getId().length() != 0){
            message += "Time zone id: " + cityTZ.getId() + ";";
        }
        Logger logger = Logger.getLogger("MyLog");
        logger.setUseParentHandlers(false);
        FileHandler fh;
        fh = new FileHandler(appPath + "/log.txt");
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.info(message);
    }
}
