package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

class LRUCacheImproved {

    Map<Integer,ListNode > store= new HashMap<>();
    DoublyLinkedList list= new DoublyLinkedList();
    int capacity =0;
    
    public LRUCacheImproved(int capacity) {
        this.capacity=capacity;        
    }
    
    public int get(int key) {
         ListNode val=store.getOrDefault(key, null);
         if(val!=null){
           list.remove(val);  
           list.addFirst(val);
             return val.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
          ListNode val=store.getOrDefault(key, null);

        if(val==null){
            if(store.size()==capacity){
            ListNode remove= list.removeLast();
            store.remove(remove.key);
        }
            ListNode e = new ListNode(key, value);
            store.put(key, e);
            list.addFirst(e);
        }
        else{
          val.value=value;
          store.put(key,val);  
          list.remove(val);
          list.addFirst(val);  
        }
    }
}

class ListNode {

    int key;
    int value;
    ListNode prev;
    ListNode next;
    
    public ListNode(int key, int value){
        this.key=key;
        this.value=value;
    }
    
    public String toString(){
        return this.key+" ---"+this.value;
    }
    
}

class DoublyLinkedList{
    ListNode head;
    ListNode tail;
    int size = 0;
    
    void addFirst(ListNode node){
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    void remove(ListNode node){
        if(node == head){
            head = head.next;
            if(head == null)
                tail = null;
            else
                head.prev = null;
        }else if(node == tail){
            tail = tail.prev;
            if(tail == null)
                head = null;
            else
                tail.next = null;
        }else{
            ListNode prev = node.prev;
            ListNode next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        size--;
    }

    ListNode removeLast(){
        ListNode lastNode = tail;
        this.remove(this.tail);
        return lastNode;
    }
    
    int size(){
        return size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */