import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NodOfFour {
    public static void main(String[] args)throws IOException {
            go();
    }
    public static int[]consoleHelper(){
        int[] array = null;
        try(BufferedReader reader=new BufferedReader(new InputStreamReader(System.in))){
                System.out.println("Enter quantity of numbers, please");
                array=new int[Integer.parseInt(reader.readLine())];
                System.out.println(String.format("Now enter all those %d numbers,please", array.length));
                for(int i=0;i<array.length;i++){
                    array[i]=Integer.parseInt(reader.readLine());
            }
        }catch (IOException e){
            System.out.println("Something going wrong");
        }
        return array;
    }
    public static void go(){
        int[]array=consoleHelper();
        int result=nodOfTwo(array[0],array[1]);
        for(int i=2;i< array.length;i++){
            result=nodOfTwo(result,array[i]);
        }
        System.out.println(result);
    }

/*Euclid's algorithm implementation
* */
    public static int nodOfTwo(int first,int second){
        int remainder=0,min=0,oldRemainder=0;
        if(first==second){return first;}
        if(first>second){
            remainder=first%second;
            min=second;
        }else{remainder=second%first;
              min=first;}
        if(remainder==0)return min;
        while(remainder!=0){
            oldRemainder=remainder;
            remainder=min%remainder;
            min=oldRemainder;
            }
        if(oldRemainder<remainder)return 1;
       return oldRemainder;
    }
}
