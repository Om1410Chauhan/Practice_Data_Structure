package BinaryTree;

public class BinarySearchTree{
    private BinaryTreeNode<Integer> root;
       public void insert(int data){
        root=insert(data,root);
    }
    public int largest(BinaryTreeNode<Integer>root){
           if(root==null){
               return Integer.MIN_VALUE;
           }
           int leftLargest=largest(root.left);
           int rightLargest=largest(root.right);
           return Math.max(root.data,Math.max(rightLargest,leftLargest));
    }
    private BinaryTreeNode<Integer>insert(int data,BinaryTreeNode<Integer>root) {
        if (root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
            return newNode;
        }
        if (root.data < data) {
            root.right = insert(data, root.right);
        } else {
            root.left = insert(data, root.left);
        }
        return root;
    }
    public void remove(int data){
           root=remove(data,root);
    }
    private BinaryTreeNode<Integer>remove(int data,BinaryTreeNode<Integer>root){
           if(root==null){
               return null;
           }
           if(root.data<data) {
               root.right = remove(data, root.right);
               return root;
           }else if(root.data>data){
                   root.left = remove(data, root.left);
                   return root;
           }
           if(root.left==null && root.right==null){
               return null;
           }
           else if (root.left==null){
               return root.right;
           }else if (root.right==null){
               return root.left;
           }else{
               int rightLargest=largest(root.right);
               root.data=rightLargest;
               BinaryTreeNode<Integer> n=remove(rightLargest,root.right);
               root.right=n;
           }
           return root;
    }
    public void print(){
           print(root);
    }
    private void print(BinaryTreeNode<Integer>root){
           if(root==null){
               return;
           }
           System.out.print(root.data+":");
           if(root.left!=null){
               System.out.print("L:"+root.left.data+",");
           }
        if (root.right != null){
            System.out.print("R:"+root.right.data+"; ");
        }
        System.out.println();
        print(root.left);
        print(root.right);
    }


}
