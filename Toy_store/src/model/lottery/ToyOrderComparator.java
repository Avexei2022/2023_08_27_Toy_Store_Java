package model.lottery;

import java.util.Comparator;

public class ToyOrderComparator<T extends ItemsOrder> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2){
        return Integer.compare(o1.getToy_num_order(), o2.getToy_num_order());
    }
}


