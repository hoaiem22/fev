package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;

public class FEVInventoryStatus implements Serializable {
    private int id;
    private String status, note;
    private Collection<FEVInventory> fevInventoriesCollection;


    public FEVInventoryStatus() {
    }

    public FEVInventoryStatus(int id, String status, String note, Collection<FEVInventory> fevInventoriesCollection) {
        this.id = id;
        this.status = status;
        this.note = note;
        this.fevInventoriesCollection = fevInventoriesCollection;
    }

    public FEVInventoryStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<FEVInventory> getFevInventoriesCollection() {
        return fevInventoriesCollection;
    }

    public void setFevInventoriesCollection(Collection<FEVInventory> fevInventoriesCollection) {
        this.fevInventoriesCollection = fevInventoriesCollection;
    }

    @Override
    public String toString() {
        return "FEVInventoryStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", fevInventoriesCollection=" + fevInventoriesCollection +
                '}';
    }
}
