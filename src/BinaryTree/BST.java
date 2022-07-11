package BinaryTree;
import java.util.ArrayList;
import java.util.Scanner;
class isBstReturn {
    int max;
    int min;
    boolean isBst;

    public isBstReturn(int min, int max, boolean isBst) {
        this.min = min;
        this.max = max;
        this.isBst = isBst;
    }
}
    public class BST {
    // function to check is bst with time complexity of order of n
    public static isBstReturn isBstR(BinaryTreeNode<Integer> root){
        if(root==null){
            isBstReturn object=new isBstReturn(Integer.MAX_VALUE,Integer.MIN_VALUE,true);
            return object;
        }
        isBstReturn left=isBstR(root.left);
        isBstReturn right=isBstR(root.right);
        int min=Math.min(root.getData(),Math.min(left.min,right.min));
        int max=Math.max(root.getData(),Math.max(left.max,right.max));
        boolean isBst=true;
        if(root.getData() >left.max){
            isBst=false;
        }
        if(root.getData() >right.min){
            isBst=false;
        }
        if(!left.isBst){
            isBst=false;
        }
        if(!right.isBst){
            isBst=false;
        }
        isBstReturn data=new isBstReturn(min,max,isBst);
        return data;

    }

    // function to amje a bst from sorted array
    public static BinaryTreeNode<Integer> bstFromSortedArray(int []sortedArray){
        BinaryTreeNode<Integer>root=bstFromSortedArrayHelper(sortedArray,0,sortedArray.length-1);
        return root;
    }
    public static BinaryTreeNode<Integer> bstFromSortedArrayHelper(int []sortedArray,int start,int end){
        if(start>end){
            return null;
        }
        int mid=start+(end-start)/2;
        BinaryTreeNode<Integer>root=new BinaryTreeNode<>(mid);
        root.left=bstFromSortedArrayHelper(sortedArray,start,mid-1);
        root.right=bstFromSortedArrayHelper(sortedArray, mid+1, end);
        return root;
    }
    // function to print elements between k1 and k2
    public static void elementsK1K2(BinaryTreeNode<Integer>root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.getData() >=k1 && root.getData() <=k2){
            elementsK1K2(root.left,k1,k2);
            System.out.println(root.getData());
            elementsK1K2(root.right,k1,k2);
        }
        else  if(root.getData() >k2){
            elementsK1K2(root.left,k1,k2);
        }
        else if(root.getData() <k1){
            elementsK1K2(root.right,k1,k2);
        }
    }
    public static ArrayList<Integer> exsist(BinaryTreeNode<Integer> root,int x){

        if(root==null){
            return null;
        }
        if(root.getData() ==x){
            ArrayList<Integer> path=new ArrayList<>();
            path.add(root.getData());
            return path;
        }
        if(x< root.getData()){
            ArrayList<Integer>pathr=exsist(root.left,x);
            if(pathr!=null) {
                pathr.add(root.getData());
                return pathr;
            }
        }
        if(root.getData() <x){
            ArrayList<Integer>patha=exsist(root.right,x);
            if(patha!=null) {
                patha.add(root.getData());
                return patha;
            }
        }
        return null ;

    }
    public static int largest(BinaryTreeNode<Integer>root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int left=largest(root.left);
        int right=largest(root.right);
        return Math.max(root.getData(),Math.max(left,right));
    }
    public static int min(BinaryTreeNode<Integer>root){
        if(root==null){
            return Integer.MAX_VALUE;
        }
        int left=min(root.left);
        int right=min(root.right);
        return Math.min(root.getData(),Math.min(left,right));
    }
    public static boolean isBst(BinaryTreeNode<Integer>root){
        if(root==null){
            return true;
        }
        int max=largest(root.left);
        if(max> root.getData()){
            return false;
        }
        int min=min(root.right);
        if(root.getData() >min){
            return false;
        }
        boolean right=isBst(root.right);
        boolean left=isBst(root.left);

        return left&&right;
    }
    public static BinaryTreeNode<Integer> input(boolean isRoot,boolean isLeft,int parentData){
        if(isRoot){
            System.out.println("enter the root data");
        }else{
            if(isLeft){
                System.out.println("Enter data of left node of"+parentData);
            }else{
                System.out.println("Enter data of right node of "+parentData);
            }
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // base case of recursion
        if(n==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(n);
        BinaryTreeNode<Integer> leftNode=input(false,true,n);
        BinaryTreeNode<Integer> rightNode=input(false,false,n);
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }
    public static void print(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        String s= root.getData() +":";
        if(root.left!=null){
            s=s+"L"+ root.left.getData() +" ";
        }
        if(root.right!=null){
            s=s+"R"+ root.right.getData();
        }
        System.out.println(s);
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
     //   BinaryTreeNode<Integer>root=input(true,true,0);
      //  ArrayList<Integer>path=exsist(root,2);
      //  for(int i=0;i<path.size();i++){
      //      System.out.println(path.get(i));
      //  }
     //   int data[]={1,2,3,4,5,6,7};
     //   BinaryTreeNode<Integer>rootR=bstFromSortedArray(data);
    //    isBstReturn data=isBstR(root);
      //  System.out.println("min value ="+data.min+" max value ="+data.max+" and we checked whether it is bst or not so the answer is ="+data.isBst);
        BinarySearchTree object=new BinarySearchTree();
        object.insert(4);
        object.insert(2);
        object.insert(1);
        object.insert(3);
        object.insert(6);
        object.insert(50);
        object.insert(7);
        object.remove(6);
        object.print();
    }
}
