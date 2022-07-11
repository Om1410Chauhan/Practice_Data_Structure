package recursion;
import java.util.Scanner;
public class ReturnSubsequence {
    public static String[] returnSubSequence(String s){
        if(s.length()==0){
            String data[]=new String[1];
            data[0]=
                    " ";
            return data;
        }
        String s2[]=returnSubSequence(s.substring(1));
        String temp[]=s2;
        s2=new String[2* temp.length];
        for(int i=0;i< temp.length;i++){
            s2[i]=temp[i];
        }
        for(int i=0;i<temp.length;i++){
            s2[i+ temp.length]=s.charAt(0)+temp[i];
        }
        return s2;

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string to find its subsequences");
        String s=sc.nextLine();
        String data[]=returnSubSequence(s);
        for(int i=0;i< data.length;i++){
            System.out.println(data[i]);
        }
    }
}
