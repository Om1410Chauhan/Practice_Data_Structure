package recursion;
import java.util.*;
public class CheckAb {
    public static boolean checkAb(String s){
        if(s.length()==0){
            return true;
        }
        if(s.charAt(0)=='a'){
            if(s.substring(1).length()>1 && s.substring(1,3).equals("bb")){
               return checkAb(s.substring(3));
            }
            else{
                return checkAb(s.substring(1));
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string containing only a and b");
        String s=sc.next();
        System.out.println(checkAb(s));
    }
}
