package linkedList;

import java.util.Scanner;

public class LinkedListUse<T>{
    static Scanner sc=new Scanner(System.in);
    public static Node<Integer> input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the value");
        int n=sc.nextInt();
        int position=0;
        Node<Integer> head=null,tail=null;
        while(n!=-1){
            Node<Integer> currentNode=new Node<>(n,position);
            if(head==null){
                head=currentNode;
                tail=currentNode;
            }
            else{
                tail.next=currentNode;
                tail=currentNode;
            }
            n=sc.nextInt();
            position++;
        }
        return head;
    }
    public static void print(Node<Integer> head){
        if(head==null){
            System.out.println("empty node");
        }
        Node<Integer>temp=head;
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
    }
    public static Node<Integer> add(Node<Integer> head){
        System.out.println("enter the value to be added and at which position");
        int a=sc.nextInt();
        int b=sc.nextInt();
        Node<Integer>newNode=new Node<>(a);
        Node<Integer> temp=head;
        if(b==0){
            newNode.next=head;
            head=newNode;
            return head;
        }
        int currentPosition=-1;
        while(temp!=null && currentPosition<b-1){
            currentPosition++;
            temp=temp.next;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        return head;
    }
    public static Node<Integer> delete(Node<Integer> head){
        System.out.println("Enter the position at which you want to delete a node");
        int n=sc.nextInt();
        Node<Integer>temp=head;
        if(n==0){
            head=head.next;
            return head;
        }
        if(n<0){
            return null;
        }
        int current=0;
        while(temp!=null&& current<n-1){
            temp=temp.next;
            current++;
        }
        temp.next=temp.next.next;
        return head;
    }
    public static int midpoint(Node<Integer> head){
        Node<Integer>slow=head;
        Node<Integer> fast=head;
        Node<Integer>temp=head;
        while(fast.next.next!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }
    // function to merge two sorted Linked List
    public static Node<Integer> merge(Node<Integer>t1,Node<Integer>t2){
        if(t1==null){
            return t2;
        }
        if(t2==null){
            return t1;
        }
        Node<Integer>head=null,tail=null;
        if(t1.data<t2.data){
            head=t1;
            tail=t1;
            t1=t1.next;
        }else {
            head=t2;
            tail=t2;
            t2=t2.next;
        }
        while(t1!=null && t2!=null){
            if(t1.data<t2.data){
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }else {
                tail.next=t2;
                tail=t2;
                t2=t2.next;
            }
        }
        if(t1==null){
            tail.next=t2;
        }
        if(t2==null){
            tail.next=t1;
        }
        return head;
    }
    // function to sort unsorted linked list
    public static void sort(Node<Integer>head) {
        Node<Integer> current = head;
        while (current != null) {
            Node<Integer> temp = current.next;
            while (temp != null) {
                if (current.data > temp.data) {
                    int t = 0;
                    t = current.data;
                    current.data = temp.data;
                    temp.data = t;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }
    public static int length(Node<Integer>head){
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }

    /*public static int find(Node<Integer>head,int n){
        int index = -1;
        while(head!=null){
            if(head.data == n){
                index++;
                return index;
            }
            else{
                head=head.next;
                index++;
            }
        }
        return -1;
    }*/
    // uncompleted
    public static Node<Integer> append(Node<Integer>head,int n){
        Node<Integer> tail=head;
        while(tail!=null){
            tail=tail.next;
        }
        Node<Integer>temp=head;
        for(int i=0;i<length(temp)-n;i++){
            temp=temp.next;
        }

        return head;
    }
    public static Node<Integer> duplicate(Node<Integer>head){
        if(head==null){
            return null;
        }
        Node<Integer>temp=head;
        // here we .next because we compare data of two consecutive nodes and hence if we didn't take temp.next than it will throw an exception of .next==null.
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
    public static void printR(Node<Integer>head){
        if(head==null){
            return;
        }
        printR(head.next);
        System.out.print(head.data+" ");
    }
    // most important function.
    public static  Node<Integer> reverse(Node<Integer>head) {
      if(head==null || head.next==null){
          return head;
      }
      Node<Integer>r=reverse(head.next);
      head.next.next=head;
      head.next=null;
      return r;
    }
    public static boolean palindrome(Node<Integer> head){
        Node<Integer>slow=head;
        Node<Integer>fast=head;
        Node<Integer>temp=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node<Integer>t1=head;
        Node<Integer>t2=reverse(slow.next);
        int l1=length(head);
        int l2=length(t2);
        int l=Math.min(l1,l2);
        for(int i=0;i<l;i++) {
            if(t1.data==t2.data){
                t1=t1.next;
                t2=t2.next;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static int find(Node<Integer>head,int n){
        Node<Integer>temp=head;
        if(head==null){
            return -1;
        }
        if(head.data==n){
            return head.position;
        }
        int position=find(head.next,n);

        return position;
    }
    public static Node<Integer>evenAfterOdd(Node<Integer>head){
        if(head==null){
            return null;
        }
        Node<Integer>oddTail=null,oddHead=null,evenTail=null,evenHead=null;
        while(head!=null){
            if(head.data%2==0){
                if(evenHead==null){
                    evenHead=head;
                    evenTail=head;
                }else{
                    evenTail.next=head;
                    evenTail=evenTail.next;
                }
            }else {
                if(oddHead==null){
                    oddHead=head;
                    oddTail=head;
                }else{
                    oddTail.next=head;
                    oddTail=oddTail.next;
                }
            }
            head=head.next;
        }
        if(oddHead==null){
            return evenHead;
        }else{
            oddTail.next=evenHead;
        }
        if(evenHead!=null){
            evenTail.next=null;
        }
        return oddHead;
    }
    // to delete n nodes after travelling m nodes.
     public static Node<Integer> traverse(Node<Integer>head,int m,int n){
        if(head==null || m==0){
            return null;
        }
        if(n==0){
            return head;
        }
        Node<Integer>temp=null;
        Node<Integer>currentNode=head;

        while(currentNode !=null) {
            int pos=0;
            int posr=0;
            while (currentNode != null && pos < m) {
                if(temp == null) {
                    temp = currentNode;
                } else {
                    temp.next = currentNode;
                    temp = currentNode;
                }
                currentNode = currentNode.next;
                pos++;
            }
            while (currentNode != null && posr < n) {
                currentNode=currentNode.next;
                posr++;
            }
        }
        if(temp!=null){
            temp.next=null;
        }
        return head;
     }
    public static void main(String[] args) {
        Node<Integer>head=input();
       // boolean b=palindrome(head);
     //   System.out.println("Enter the value to be searched");
      //  int n=sc.nextInt();
       // int pos=find(head,n);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Node<Integer>temp=traverse(head,n,m);
        print(temp);

    }

}
