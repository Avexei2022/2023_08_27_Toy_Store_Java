package model.lottery;

import model.toy.Toy;

public class ToyOrder extends ToyOrderComparator<ToyOrder> implements ItemsOrder, Comparable {

    private int toy_num_order;
    private Toy toy;

    public ToyOrder(int toy_num_order, Toy toy) {
        this.toy_num_order = toy_num_order;
        this.toy = toy;
    }

    public int getToy_num_order() {
        return toy_num_order;
    }

    public Toy getToy() {
        return toy;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
