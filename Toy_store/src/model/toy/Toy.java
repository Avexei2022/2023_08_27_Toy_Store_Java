package model.toy;

import java.io.Serializable;

public class Toy implements Serializable, ItemsList {

    private int id;
    private String name;
    private int weight;

    public Toy (String name, int weight){
        id = -1;
        this.name = name;
        this.weight = weight;
    }
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setWeight(int weight){
        this.weight = weight;

    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", Название: ");
        sb.append(getName());
        sb.append(", Вес для выпадения: ");
        sb.append(getWeight());
        return sb.toString();
    }

    public  boolean equals(Object obj){
        if (this == obj){
            return  true;
        }
        if (!(obj instanceof Toy toy)){
            return false;
        }
        return toy.getId() == getId();
    }

}
