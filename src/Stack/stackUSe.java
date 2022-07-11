package Stack;

import java.util.Scanner;

public class stackUSe {

    public static boolean checkRedundant(String data) throws stackEmptyException {
        stackUsingLinkedList<Character> n=new stackUsingLinkedList<>();
        for(int i=0;i<data.length();i++){
            while(data.charAt(i)!=')') {
              n.push(data.charAt(i));
            }
        }

        while(!n.isEmpty()) {
            int pos=0;
            while(!n.isEmpty()) {
                while (n.top() != '(') {
                    n.pop();
                    pos++;
                }
                if (pos != 0) {
                    boolean a=false;
                    if (!n.isEmpty()) {
                        n.pop();
                    }
                }
                if (pos == 0) {
                    boolean a=true;
                    return a;
                }
            }
            }
        return false;
    }
    public static int[] stockSpan(int[] data,int size) throws stackEmptyException {
        int n=data.length;
        stackUsingLinkedList<Integer>a=new stackUsingLinkedList<>();
        int output[]=new int[size];
        output[0]=1;
        a.push(0);
        for(int i=1;i<n;i++){
            while(a.isEmpty()!=true && data[a.top()]<data[i]){
                a.pop();
            }
            if(!a.isEmpty()){
                output[i]=i-a.pop();
            }else{
                output[i]=i+1;
            }
            a.push(i);
        }
        return output;
    }
    public  static void main(String[] args) throws  stackEmptyException {
       /* stackUsingArray n=new stackUsingArray();
        n.push(2);
        n.push(3);
        n.push(40);
        System.out.println(n.pop());
        System.out.println(n.pop());;
        System.out.println(n.pop());
        System.out.println(n.isEmpty());
        System.out.println(n.size());
        */
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the days");
        int size=sc.nextInt();
        int data[]=new int[size];
        for(int i=0;i<data.length;i++){
            data[i]=sc.nextInt();
        }
        int output[]=stockSpan(data,size);
        for(int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }



}
