import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class TimeFormat{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        DateTimeFormatter in=DateTimeFormatter.ofPattern("hh:mm:ssa",Locale.ENGLISH);
        DateTimeFormatter out=DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time=LocalTime.parse(t,in);
        System.out.println(time.format(out));
    }
}