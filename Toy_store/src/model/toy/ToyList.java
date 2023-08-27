package model.toy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ToyList<E extends ItemsList> implements Serializable, Iterable<E> {

    private int toyId;
    private final List<E> toyListE;

    public ToyList(List<E> toyList){
        this.toyListE = toyList;
    }

    public ToyList(){
        this(new ArrayList<>());
    }

    public boolean addToToysList(E e){
        if (e == null) {
            return false;
        }
        if (!toyListE.contains(e)) {
            toyListE.add(e);
            e.setId(toyId++);
            return true;
        }
        return false;
    }

    public void printToyList(){
        toyListE.sort(new ToyComparatorById<>());
    }

    public boolean removeToy(E e) {
        if (e == null) {
            return false;
        }
        if (toyListE.contains(e)) {
            toyListE.remove(e);
            return true;
        }
        return false;
    }

    public E getById(int id) {
        for (E toy : toyListE) {
            if (toy.getId() == id) {
                return toy;
            }
        }
        return null;
    }

    public boolean checkIsId(int id) {
        for (E toy : toyListE) {
            if (toy.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String clearToyList() {
        this.toyListE.clear();
        return "\nСписок игрушек в розыгрыше очищен.\n";
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
       if (!toyListE.isEmpty()) {
           StringBuilder sb = new StringBuilder();
           sb.append("\nСписок игрушек в розыгрыше.\n");
           for (E toy : toyListE) {
               sb.append(toy);
               sb.append("\n");
           }
           return sb.toString();
       } else {
           return "\nСписок игрушек в розыгрыше пуст.\n";
       }
    }

    public int getSize() {
        int size = 0;
        if (!toyListE.isEmpty()) {
            size = toyListE.size();
        }
        return size;
    }
    public boolean checkIsEmpty(){
        return toyListE.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return new ToyIterator<>(toyListE);
    }



}
