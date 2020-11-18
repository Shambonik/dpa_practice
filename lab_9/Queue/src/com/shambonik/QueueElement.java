package com.shambonik;

public class QueueElement {
    private int k;
    private QueueElement next;

    public QueueElement(int k, QueueElement next) {
        this.k = k;
        this.next = next;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public QueueElement getNext() {
        return next;
    }

    public void setNext(QueueElement next) {
        this.next = next;
    }
}
