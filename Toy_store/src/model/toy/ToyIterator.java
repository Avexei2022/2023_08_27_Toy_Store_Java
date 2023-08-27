package model.toy;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<E> implements Iterator<E> {
    private int index;
    private final List<E> toysList;
    public ToyIterator(List<E> toysList){
        this.toysList = toysList;
    }
    @Override
    public boolean hasNext(){
        return toysList.size() > index;
    }

    @Override
    public E next(){
        return toysList.get(index++);
    }
}
