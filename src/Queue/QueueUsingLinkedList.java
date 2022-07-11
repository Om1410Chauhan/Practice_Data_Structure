package Queue;
import linkedList.Node;
import java.util.Scanner;

public class QueueUsingLinkedList<T>{
    Scanner sc=new Scanner(System.in);
    private Node<T> head;
    private Node<T>tail;
    private int size;
    public QueueUsingLinkedList() {
        head=null;
        size=0;

    }
    // function to remove k elements of a queue
    public void reverseKQueue(int k){
        Node<T>tail=head;
        while(k>0){
            head=head.next;
            k--;
        }
        Node<T>temp=head;
        while(temp!=null){
            temp=temp.next;
        }
        temp.next=tail;

    }
    // function to reverse a queue
    public  void reverseQueue(){
        if(size()<1){
            return;
        }
        T front =dequeue();
        reverseQueue();
        enqueue(front);

    }
    public void enqueue(T e){
        Node<T>currentNode=new Node<>(e);
        if(head==null){
            head=currentNode;
            tail=currentNode;
            size++;
        }else {

            tail.next = currentNode;
            tail = currentNode;
            size++;
        }
    }
    public  boolean isEmpty(){

        return  size==0;
    }
    public int  size(){
        return size;
    }
    public T dequeue(){
        if(head==null){
            return null;
        }
        T temp=head.data;
        head=head.next;
        size--;
        return temp;
    }
    public T top(){
        if(head==null){
            return null;
        }
        return head.data;
    }


}
