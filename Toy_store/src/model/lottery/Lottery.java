package model.lottery;

import java.util.ArrayList;

import java.util.PriorityQueue;


public class Lottery<E extends ItemsOrder>{
    private final PriorityQueue<E> lotteryE;
    public Lottery(PriorityQueue<E> lottery){
        this.lotteryE = lottery;
    }

    public Lottery(){
        this(new PriorityQueue<>());
    }

    public void addToLottery(E e){
        lotteryE.add(e);
    }

    public E getItem(){
        return lotteryE.poll();
    }
    public int getSize(){
        int size = 0;
        if (!lotteryE.isEmpty()) {
            size = lotteryE.size();
        }
        return size;
    }

    public boolean checkIsEmpty(){
        return lotteryE.isEmpty();
    }

    public void setAll(ArrayList<E> arrayList){
        lotteryE.addAll(arrayList);
    }
    public void clearAll(){
        lotteryE.clear();
    }

}





