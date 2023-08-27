package model.toy;

import java.io.Serializable;

public interface ItemsList extends Serializable {
    int getId();
    String getName();
    int getWeight();
    void setId(int id);
    void setWeight(int weight);
}
