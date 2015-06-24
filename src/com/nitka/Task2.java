package com.nitka;

import java.util.*;

public class Task2 {
    private LinkedList<Integer> list;
    private Map<Integer, Integer> counter = new HashMap<Integer, Integer>();

    public Task2(LinkedList<Integer> list){
        this.list = list;
    }

    public List<Integer> remove(){
        for(Integer i : list){
            if(counter.containsKey(i))
                counter.put(i, counter.get(i)+1);
            else
                counter.put(i, 1);
        }
        LinkedList<Integer> clone_list = (LinkedList<Integer>)list.clone();
        for(Integer i : clone_list){
            if(counter.get(i)>2)
                list.remove(i);
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 20; i++) {
            list.add(new Random().nextInt(10));
        }
        Task2 task = new Task2(list);
        System.out.println(list);
        System.out.println(task.remove());
    }
}
