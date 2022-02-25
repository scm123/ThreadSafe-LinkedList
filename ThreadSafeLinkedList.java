package threadSafeLinkedList;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.*;

public class ThreadSafeLinkedList {
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    ListNode head;

    ListNode front;
    ListNode tail;
    static int size=0;

    public ThreadSafeLinkedList(){
        // write your code
    }

    public void appendLeft(int element){
        // write your code
        // the element given to be append left
        lock.writeLock().lock();
        size++;
        ListNode newnode=new ListNode(element);
        newnode.setNext(front);
        front=newnode;
        if(size==1) tail=front;
        lock.writeLock().unlock();
    }

    public void appendRight(int element){
        // write your code
        // the element given to be append right
        lock.writeLock().lock();
        ListNode newnode=new ListNode(element);
        tail.setNext(newnode);
        tail=tail.getNext();
        lock.writeLock().unlock();
    }

    public ListNode getLinkedList(){
        // write your code
        // return the head of the linked list
        ListNode node;
        lock.readLock().lock();
        node = front;
        lock.readLock().unlock();
       return node;
    }
}
