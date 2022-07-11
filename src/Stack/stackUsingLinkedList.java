package Stack;
import linkedList.Node;
public class stackUsingLinkedList<T> {
    private Node<T> head;
    private int size;
    stackUsingLinkedList(){
        head=null;
        size=0;
    }
    public void push(T e){
        Node<T>currentNode =new Node<T>(e);
        currentNode.next=head;
        head=currentNode;
        size++;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public T pop() throws stackEmptyException {
        if(head==null){
            throw new stackEmptyException();
        }
        T data=head.data;
        head=head.next;
        size--;
        return data;
    }
    public T top() throws stackEmptyException {
        if(size==0 ||head==null){
            throw new stackEmptyException();
        }
        return head.data;
    }





}
