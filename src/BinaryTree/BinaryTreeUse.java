package BinaryTree;
import Queue.*;
import java.util.Scanner;
public class BinaryTreeUse{
    // function to find hdiameter of binary tree having time complexity as order of height
    public static int diameter(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int option1=height(root.left)+height(root.right);
        int option2=diameter(root.left);
        int option3=diameter(root.right);
        return Math.max(option1,Math.max(option2,option3));
    }
    // function to check whether tree is balanced or not by using a class and this time time complexity is n
    // here the height is calculated  in the function and also checked whether it is balanced or not
    // but it is done only once which decreases the time complexity
    public static BinaryTreeReturn isBalancedR(BinaryTreeNode<Integer>root){
        if(root==null){
            boolean isBal=true;
            int height=0;
            BinaryTreeReturn tree=new BinaryTreeReturn();
            tree.height=height;
            tree.isBalanced=isBal;
            return tree;
        }
        boolean isBal=true;
        BinaryTreeReturn left=isBalancedR(root.left);
        BinaryTreeReturn right=isBalancedR(root.right);
        int height=Math.max(left.height,right.height)+1;
        if(Math.abs(left.height-right.height)>1){
            isBal=false;
        }
        if(!left.isBalanced && !right.isBalanced){
            isBal=false;
        }
        BinaryTreeReturn ans=new BinaryTreeReturn();
        ans.isBalanced=isBal;
        ans.height=height;
        return ans;
    }

    // function to check whether the tree is balanced or not but it is a function of order of n square time complexity
    public static boolean isBalanced(BinaryTreeNode<Integer>root){
        if(root==null){
            return true;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        boolean ans;
        if(Math.abs(leftHeight-rightHeight)>1){
             return false;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        return left && right;
    }

    // function to mirror a tree
    public static void mirrorTree(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        mirrorTree(root.left);
        mirrorTree(root.right);
        if(root.left!=null && root.right!=null){
            BinaryTreeNode<Integer> temp=root.left;
            root.left=root.right;
            root.right=temp;
        }
    }
   // function to remove leaf
    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
        if(root==null){
            return null;
        }
        if(root.left==null && root.right==null){
            return null;
        }
        root.left=removeLeaf(root.left);
        root.right=removeLeaf(root.right);
        return root;
    }


    // helper function
    public static void dataWithDepthR(BinaryTreeNode<Integer>root, int depth){
        if(root==null){
            return ;
        }
        root.setData(depth);
        dataWithDepthR(root.left,depth++);
        dataWithDepthR(root.right,depth++);
    }
    // function to change data of node with its depth
    public static void dataWithDepth(BinaryTreeNode<Integer>root){
        dataWithDepthR(root,0);
    }
    // function to print Nodes at depth k
    public static void printKDepth(BinaryTreeNode<Integer>root,int k){
        if(root==null){
            return;
        }
        if(k<0){
            return ;
        }
        if(k==0){
            System.out.println(root.getData());
        }
        printKDepth(root.left,k-1);
        printKDepth(root.right,k-1);
    }
    // function to find number of leaf nodes
    public static int leafNodes(BinaryTreeNode<Integer> root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
           return 1 ;
        }
       // int left=leafNodes(root.left);
       // int right=leafNodes(root.right);
        return leafNodes(root.left)+leafNodes(root.right);
    }
    // function to find the height of a binary tree
    public static int height(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return 1+Math.max(leftHeight,rightHeight);
    }
    // function to find number of nodes greater than given x
    public static int largerThanX(BinaryTreeNode<Integer>root,int x){
        if(root==null){
            return 0;
        }
        if(x<1){
            return -1;
        }
        int y=0;
        if(root.getData() >x){
            y++;
        }
        int left=largerThanX(root.left,x);
        int right=largerThanX(root.right,x);
        return left+right+y;
    }

    // function to find node with largest data
    public static int largest(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int leftLargest=largest(root.left);
        int rightLargest=largest(root.right);
        return Math.max(root.getData(),Math.max(leftLargest,rightLargest));
    }
    // function to print tree in in-order
    // in this tree goes to left root right
    public static void inOrder(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.getData());
        inOrder(root.right);

    }
    // function to print binary tree in post-order
    // in post order tree goes from left right root
    public static void postOrder(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.getData());
    }
    // code to print binary tree in pre-order
    //in pre-order tree goes from root left right
    public static void preOrder(BinaryTreeNode<Integer>root){
        if(root==null){
            return;
        }
        System.out.println(root.getData());
        preOrder(root.left);
        preOrder(root.right);
    }
    // code to find sum of all nodes in binary tree
    public static int sum(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int leftSum=sum(root.left);
        int rightSum=sum(root.right);
        return root.getData() +leftSum+rightSum;

    }
    // code to find number of nodes in a binary tree
    public static int numberOfNodes(BinaryTreeNode<Integer>root){
        if(root==null){
            return 0;
        }
        int leftNode=numberOfNodes(root.left);
        int rightNode=numberOfNodes(root.right);
        return 1+leftNode+rightNode;
    }
    // more precised way to take input of a binary tree
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

    // function to take input in pre-order or first way
    public static BinaryTreeNode<Integer>takeInput(){
        System.out.println("enter the root data");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==-1){
            return null;
        }
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(n);
        BinaryTreeNode<Integer> leftNode=takeInput();
        BinaryTreeNode<Integer> rightNode=takeInput();
        root.left=leftNode;
        root.right=rightNode;
        return root;
    }


    // function to take input of a binary tree inspiring from code of tree input function level wise
    public static BinaryTreeNode<Integer> takeInputL(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root data");
        int data=sc.nextInt();
        BinaryTreeNode<Integer> root=new BinaryTreeNode<>(data);
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q1=new QueueUsingLinkedList<>();
        q1.enqueue(root);
        while(!q1.isEmpty()){
            BinaryTreeNode<Integer> childNode=q1.dequeue();
                System.out.println("enter the left child of " + childNode.getData());
                int n=sc.nextInt();
                if(n!=-1) {
                    BinaryTreeNode<Integer> rootData = new BinaryTreeNode<>(n);
                    q1.enqueue(rootData);
                    childNode.left = rootData;
                }
            System.out.println("Enter the right child of"+ childNode.getData());
            int a = sc.nextInt();
                if(a!=-1) {

                    BinaryTreeNode<Integer> rootDatat = new BinaryTreeNode<>(a);
                    q1.enqueue(rootDatat);
                    childNode.right = rootDatat;
                }
        }
        return root;

    }


    // function to print a binary tree
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
       // BinaryTreeNode<Float>rootLeft=new BinaryTreeNode<>(2.5f);
       // BinaryTreeNode<Float>rootRight=new BinaryTreeNode<>(3.5f);
       // root.left=rootLeft;
       // root.right=rootRight;
       // BinaryTreeNode<Float> twoRight=new BinaryTreeNode<>(4.5f);
       // BinaryTreeNode<Float>threeLeft=new BinaryTreeNode<>(5.5f);
       // rootLeft.left=twoRight;
       // rootRight.left=threeLeft;
        BinaryTreeNode<Integer> root=input(true,true,0);
      //  mirrorTree(root);
      //  print(root);
        System.out.println(isBalanced(root));

    }
}
