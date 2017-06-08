import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LittleCalendar {
    public static void main(String[] args){
      go();
    }
    public static void go(){
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))) {
            int[] offsets = {-3, 0, -3, -2, -3, -2, -3, -3, -2, -3, -2, -3};
            System.out.println("Enter the New Year day of week (1 is Monday, 7 is Sunday)");
            int day31 = Integer.parseInt(reader.readLine());
            System.out.println("Enter the day of month to find");
            int dayNumber = Integer.parseInt(reader.readLine());
            System.out.println("Enter the month in which to find( 1 is January, 12 is December)");
            int month = Integer.parseInt(reader.readLine());
            int day28 = offsetApply(day31, -3);
            for (int i = 11; i >= month; i--) {
                day28 = offsetApply(day28, offsets[i - 1]);
            }
            System.out.println(offsetApply(day28, dayNumber - 28));
        }catch (IOException e){
            System.out.println("Ooops! something going wrong");
        }
    }
    public static int offsetApply(int day,int offset){
        int result=(day+offset)%7;
        if(result==0)result=7;else if(result<0)result=7+result;
        return result;
    }
}
