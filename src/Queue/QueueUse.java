package Queue;

import com.sun.jdi.IntegerType;

import java.util.Scanner;

public class QueueUse {
    // function to reverse k element of a queue
    public static void reverseKqueue(int k,QueueUsingLinkedList<Integer>queue){
        if(k==0){
            return;
        }
        int a=queue.dequeue();
        k--;
        reverseKqueue(k,queue);
        queue.enqueue(a);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       /* int size=sc.nextInt();
        int arr[]=new int[size];
        QueueUsingArray<Integer> q1=new QueueUsingArray(Integer.class,size);
        for(int i=0;i<size;i++) {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<size;i++){
            q1.enqueue(arr[i]);
        }
        while(! q1.isEmpty()){
            System.out.print(q1.dequeue()+" ");
        }

        */
        QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<>();
        int arr[]=new int[5];
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }
        for(int i:arr){
            queue.enqueue(i);
        }

        while(!queue.isEmpty()){
            System.out.print(queue.dequeue()+" ");
        }
        queue.dequeue();
        System.out.println(queue.top());
    }


}
