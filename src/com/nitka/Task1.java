package com.nitka;

import java.util.ArrayList;
import java.util.Random;

public class Task1 {
    private ArrayList<Integer> list;


    public Task1(ArrayList<Integer> list){
        this.list = list;
    }

    public ArrayList<Integer> remove(){
        int counter = 1;
        Integer element = list.get(0);
        for(int i = 1; i < list.size(); i++){
            if(element.equals(list.get(i)))
                    counter++;
            if(counter>2){
                while (counter>0) {
                    list.remove(i);
                    counter--;
                    i--;
                }
                if(i>0)
                    i--;
                if(i<0)
                    i=0;
            }
            if(!element.equals(list.get(i)))
                counter=1;
            element = list.get(i);
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(3));
        }
        Task1 task = new Task1(list);
        System.out.println(list);
        System.out.println(task.remove());
    }
}
