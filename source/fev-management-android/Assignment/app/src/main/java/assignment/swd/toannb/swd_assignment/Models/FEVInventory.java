package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVInventory implements Serializable{
    private int id, quantity;
    private String note;
    private FEVMember holder;
    private FEVInventoryStatus status;
    private FEVInventoryItem item;


    public FEVInventory() {
    }

    public FEVInventory(int id, int quantity, String note, FEVMember holder, FEVInventoryStatus status, FEVInventoryItem item) {
        this.id = id;
        this.quantity = quantity;
        this.note = note;
        this.holder = holder;
        this.status = status;
        this.item = item;
    }

    public FEVInventory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FEVMember getHolder() {
        return holder;
    }

    public void setHolder(FEVMember holder) {
        this.holder = holder;
    }

    public FEVInventoryStatus getStatus() {
        return status;
    }

    public void setStatus(FEVInventoryStatus status) {
        this.status = status;
    }

    public FEVInventoryItem getItem() {
        return item;
    }

    public void setItem(FEVInventoryItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "FEVInventory{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", holder=" + holder +
                ", status=" + status +
                ", item=" + item +
                '}';
    }
}
