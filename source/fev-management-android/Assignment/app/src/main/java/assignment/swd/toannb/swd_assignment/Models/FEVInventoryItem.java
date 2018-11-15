package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;

public class FEVInventoryItem implements Serializable {
    private int id;
    private String name, address, price, note;
    private Collection<FEVInventory> fevInventoryCollection;

    public FEVInventoryItem() {
    }

    public FEVInventoryItem(int id, String name, String address, String price, String note, Collection<FEVInventory> fevInventoryCollection) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.note = note;
        this.fevInventoryCollection = fevInventoryCollection;
    }

    public FEVInventoryItem(int id, String name, String address, String price, String note) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.price = price;
        this.note = note;
    }

    public FEVInventoryItem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Collection<FEVInventory> getFevInventoryCollection() {
        return fevInventoryCollection;
    }

    public void setFevInventoryCollection(Collection<FEVInventory> fevInventoryCollection) {
        this.fevInventoryCollection = fevInventoryCollection;
    }

    @Override
    public String toString() {
        return "FEVInventoryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", price='" + price + '\'' +
                ", note='" + note + '\'' +
                ", fevInventoryCollection=" + fevInventoryCollection +
                '}';
    }
}
