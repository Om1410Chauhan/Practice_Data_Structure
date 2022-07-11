package Queue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class QueueUsingArray<T> {
    private   T data[];
    private int front;
    private int  rear;

    private int size;

    QueueUsingArray(T clazz,int size){
        front=-1;
        rear=-1;
        data=(T[]) Array.newInstance((Class<T>)clazz,size);
    }
    public void enqueue(T e) throws QueueFullException {
        if(data.length==size){
            throw new QueueFullException();
        }
        if(size==0) {
            front++;
        }
        //    rear++;
       // if(rear==data.length){
       //     rear=0;
       // }
        rear=(rear+1)% data.length;
        size++;
        data[rear] = e;
    }
    public T dequeue() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException();
        }
        T e=data[front];
        front++;
        size--;
        return e;
    }
    public T front() throws QueueEmptyException {
        if(size==0){
            throw new QueueEmptyException();
        }
        T e=data[front];
        return e;
    }
    public boolean isEmpty(){
        return front==-1;
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }
    }
    public int size(){
        return size;
    }




}
