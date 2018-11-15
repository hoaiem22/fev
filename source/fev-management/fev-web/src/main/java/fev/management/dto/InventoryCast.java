package fev.management.dto;

public class InventoryCast {
    
    private Integer id;
    private String item;
    private Integer quantity;
    private String holder;
    private String status;
    private String note;
    
    public InventoryCast(Integer id, String item, Integer quantity, String holder, String status, String note) {
        super();
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.holder = holder;
        this.status = status;
        this.note = note;
    }
    /**
    * Get value of id.
    * @return the id
    */
    public Integer getId() {
        return id;
    }
    /**
     * Set the value for id.
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
    * Get value of quantity.
    * @return the quantity
    */
    public Integer getQuantity() {
        return quantity;
    }
    /**
     * Set the value for quantity.
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    /**
    * Get value of note.
    * @return the note
    */
    public String getNote() {
        return note;
    }
    /**
     * Set the value for note.
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
    * Get value of holder.
    * @return the holder
    */
    public String getHolder() {
        return holder;
    }
    /**
     * Set the value for holder.
     * @param holder the holder to set
     */
    public void setHolder(String holder) {
        this.holder = holder;
    }
    /**
    * Get value of status.
    * @return the status
    */
    public String getStatus() {
        return status;
    }
    /**
     * Set the value for status.
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
    * Get value of item.
    * @return the item
    */
    public String getItem() {
        return item;
    }
    /**
     * Set the value for item.
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }
    
    
}
