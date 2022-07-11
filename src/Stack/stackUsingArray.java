package Stack;
import java.util.Scanner.*;
import java.lang.reflect.Array;
public class stackUsingArray{
    private  int[] data;
    private int topIndex;
    public stackUsingArray(){
        topIndex=-1;
        int size=10;
        data =new int[size];
    }
    public boolean isEmpty(){
        return(topIndex==-1);
    }
    public  void  push(int  e) throws StackFullException {
        if(topIndex == data.length - 1){
            throw new StackFullException();
        }
        data[++topIndex]=e;
    }
    public int top(){

        return data[topIndex];
    }
    public int pop() throws stackEmptyException {
        if(topIndex==-1){
            throw new stackEmptyException();
        }
        int t=data[topIndex];
        topIndex--;
        return t;
    }
    public int size(){

        return topIndex;
    }
    // here when we doubled the size of array we didn't return the new address of data because here the call is by reference not by value
    // so when we call by call by reference address is passed and when data is assigned new address and when in main function data is called it is called for the new array
    // because the data variable which stores address started storing new address.
    public void doubleSize(){
        int []temp=data;
        data=new int[2*temp.length];
        for(int i=0;i<temp.length;i++){
            data[i]=temp[i];
        }
    }



}
