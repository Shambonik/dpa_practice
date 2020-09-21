package com.shambonik;

import java.util.ArrayList;

public class QueueArray {
    private int maxLen;
    private ArrayList<Integer> queue;

    public QueueArray() {
        this.maxLen = Integer.MAX_VALUE;
        queue = new ArrayList<>();
    }

    public QueueArray(int maxLen) {
        this.maxLen = maxLen;
        queue = new ArrayList<>();
    }

    public void add(int k){
        if(!isFull()) {
            queue.add(0, k);
        }
    }

    public void delete(){
        if(!isEmpty()) {
            queue.remove(queue.size()-1);
        }
    }

    public int getElement(){
        return queue.get(queue.size()-1);
    }



    public boolean isEmpty(){
        return queue.size()==0;
    }

    public boolean isFull(){
        return queue.size()==maxLen;
    }
}
