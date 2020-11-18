package com.shambonik;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        int max = 0;
        int num;
        for(int i = 0; i<n;i++){
            num = in.nextInt();
            array.add(num);
            if(num > max) max = num;
        }
        int itNum;
        for(itNum = 0; max > 0; itNum++) max /= 10;

        ArrayList<QueueList> queueArray = new ArrayList<>();
        for(int i = 0; i<10; i++) queueArray.add(new QueueList());

        for(int i = 0; i<itNum; i++){
            for(int k = 0; k<array.size(); k++){
                int digit = (array.get(k)/(int)Math.pow(10, i))%10;
                queueArray.get(digit).add(array.get(k));
            }
            array = new ArrayList<>();
            for(int k = 0; k<10; k++){
                while(!queueArray.get(k).isEmpty()){
                    array.add(queueArray.get(k).getElement());
                    queueArray.get(k).delete();
                }
            }
        }

        for(int i = 0; i<array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
    }
}
