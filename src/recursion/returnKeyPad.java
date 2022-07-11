package recursion;
import java.util.Scanner;
public class returnKeyPad {
    public static String[] helper(int num){
        if(num<=1 || num>10){
            System.exit(0);
        }
        switch(num){
            case 2:{
                String alphabet[]={"a","b","c"};
                return alphabet;
            }
            case 3:{
                String alphabet[]={"d","e","f"};
                return alphabet;
            }
            case 4:{
                String alphabet[]={"g","h","i"};
                return alphabet;
            }
            case 5:{
                String alphabet[]={"j","k","l"};
            }
            case 6:{
                String alphabet[]={"m","n","o"};
                return alphabet;
            }
            case 7:{
                String alphabet[]={"P","Q","r","s"};
                return alphabet;
            }
            case 8:{
                String alphabet[]={"T","u","v"};
                return alphabet;
            }
            case 9:{
                String alphabet[]={"w","x","y","z"};
            }
        }
        return null;
    }
    public static String[] returnKeyPad(int n){
        if(n==0){
            return new String[]{" "};
        }
        int num1=n%10;
        int num2=n/10;
        String data1[]=helper(num1);
        String data2[]=returnKeyPad(num2);
        String combination[]=new String[data1.length* data2.length];
        int k=0;
        for(int i=0;i< data1.length;i++){
            for(int j=0;j< data2.length;j++){
                combination[k]=data1[i]+data2[j];
                k++;
            }
        }
        return  combination;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        String combinations[]=returnKeyPad(n);
        for(int i=0;i<combinations.length;i++){
            System.out.print(combinations[i]+" ");
        }
    }
}
