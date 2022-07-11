package linkedList;

public class Node<T> {
   public  T data;
   public  Node<T> next;
    int position;
    public Node(T data){
        this.data=data;
        next=null;
    }
    public Node(T data,int position){
        this.data=data;
        next=null;
        this.position=position;
    }

}
