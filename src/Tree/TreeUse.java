package Tree;
import Queue.QueueUsingLinkedList;
import com.sun.source.tree.Tree;

import java.util.Scanner;

public class TreeUse {
    Scanner sc=new Scanner(System.in);
    // function to find print data at k depth
    public static void printK(TreeNode<Integer>root,int k){
        if(k<0){
            return;
        }
        if(k==0){
            System.out.println(root.data);
        }
        for(int i=0;i<root.children.size();i++){
            printK(root.children.get(i),k-1);
        }
    }
    // function to calculate Number of Nodes
    public static int numberOfNode(TreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int count=1;
        for(int i=0;i<root.children.size();i++){
            count+=numberOfNode(root.children.get(i));
        }
        return count;
    }

   // function to take input level wise
    public static TreeNode<Integer> takeInputLevelWise(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the root data");
        int rootData=sc.nextInt();
        TreeNode<Integer>root=new TreeNode<Integer>(rootData);
        QueueUsingLinkedList<TreeNode<Integer>> q=new QueueUsingLinkedList<>();
        q.enqueue(root);
        while(!q.isEmpty()) {
           TreeNode<Integer> frontNode=q.dequeue();
            System.out.println("Enter the number of children of"+" "+frontNode.data);
            int n= sc.nextInt();
            for(int i=0;i<n;i++){
                System.out.println("Enter the"+" " +(i+1)+"th child of"+frontNode.data);
                int child= sc.nextInt();
                TreeNode<Integer>children=new TreeNode<>(child);
                q.enqueue(children);
                frontNode.children.add(children);
            }
        }
        return root;
    }
    // function to find  largest node in a tree
    public static int largestNode(TreeNode<Integer>root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int largest=root.data;
        for(int i=0;i<root.children.size();i++){
            int  childLargest=largestNode(root.children.get(i));
            if(childLargest>largest){
                 largest=childLargest;
            }
        }
        return largest;
    }
    // function to take a tree input from the user
    public static TreeNode<Integer>input(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the next node data");
        int n=sc.nextInt();
        TreeNode<Integer>root=new TreeNode<>(n);
        System.out.println("enter the number of children for "+" "+n);
        int numberOfChild=sc.nextInt();
        for(int i=0;i<numberOfChild;i++){
            TreeNode<Integer>child=input();
            root.children.add(child);
        }
        return root;

    }
    public static void print(TreeNode<Integer> root){
        String s=root.data+ ":";
                for(int i=0;i<root.children.size();i++){
                    s=s+root.children.get(i).data+" ";
                }
            System.out.println(s);
                for(int i=0;i<root.children.size();i++) {
                    print(root.children.get(i));
                }
    }
    public static void main(String[] args) {
        TreeNode<Integer>root=takeInputLevelWise();
        print(root);
    }
}