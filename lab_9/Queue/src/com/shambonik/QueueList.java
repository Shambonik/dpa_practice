package com.shambonik;

public class QueueList {
    private QueueElement first;
    private QueueElement last;
    private int size;
    private int maxLen;

    public QueueList() {
        this.maxLen = Integer.MAX_VALUE;
        size = 0;
        first = null;
    }

    public QueueList(int maxLen) {
        this.maxLen = maxLen;
        size = 0;
        first = null;
    }

    public void add(int k){
        if(!isFull()) {
            first = new QueueElement(k, first);
            if(last==null)last = first;
            size++;
        }
    }

    public void delete(){
        if(!isEmpty()) {
            QueueElement el = first;
            if (size > 1) {
                while (el.getNext() != last) el = el.getNext();
                el.setNext(null);
                last = el;
            }
            else {
                first = null;
                last = null;
            }
            size--;
        }
    }

    public int getElement(){
        return last.getK();
    }

    public boolean isEmpty(){
        return first==null;
    }

    public boolean isFull(){
        return size==maxLen;
    }
}
