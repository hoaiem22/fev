package fev.management.dto;

public class TransactionCast {
    
    private Integer id;
    private String type;
    private String content;
    private Integer money;
    private String event;
    private String burden;
    private String note;
    
    public TransactionCast(Integer id, String type, String content, Integer money, String event, String burden,
            String note) {
        super();
        this.id = id;
        this.type = type;
        this.content = content;
        this.money = money;
        this.event = event;
        this.burden = burden;
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
    * Get value of type.
    * @return the type
    */
    public String getType() {
        return type;
    }

    /**
     * Set the value for type.
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
    * Get value of content.
    * @return the content
    */
    public String getContent() {
        return content;
    }

    /**
     * Set the value for content.
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
    * Get value of money.
    * @return the money
    */
    public Integer getMoney() {
        return money;
    }

    /**
     * Set the value for money.
     * @param money the money to set
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    /**
    * Get value of event.
    * @return the event
    */
    public String getEvent() {
        return event;
    }

    /**
     * Set the value for event.
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
    * Get value of burden.
    * @return the burden
    */
    public String getBurden() {
        return burden;
    }

    /**
     * Set the value for burden.
     * @param burden the burden to set
     */
    public void setBurden(String burden) {
        this.burden = burden;
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
    
    
        
}
