package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;


public class FEVTransactionType implements Serializable {
    private int id;
    private String type, note;
    private Collection<FEVTransaction> fevTransactionCollection;

    public FEVTransactionType() {

    }

    public FEVTransactionType(int id, String type, String note, Collection<FEVTransaction> fevTransactionCollection) {
        this.id = id;
        this.type = type;
        this.note = note;
        this.fevTransactionCollection = fevTransactionCollection;
    }

    public FEVTransactionType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<FEVTransaction> getFevTransactionCollection() {
        return fevTransactionCollection;
    }

    public void setFevTransactionCollection(Collection<FEVTransaction> fevTransactionCollection) {
        this.fevTransactionCollection = fevTransactionCollection;
    }


    @Override
    public String toString() {
        return "FEVTransactionType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                ", fevTransactionCollection=" + fevTransactionCollection +
                '}';
    }
}
