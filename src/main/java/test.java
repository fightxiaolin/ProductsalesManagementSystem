import com.sun.xml.internal.ws.util.xml.CDATA;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        String startTime="2019-01-01 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(startTime);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
