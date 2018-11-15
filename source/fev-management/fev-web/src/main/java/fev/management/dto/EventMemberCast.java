package fev.management.dto;

public class EventMemberCast {
    
    private Integer id;
    private String event;
    private String member1;
    private String note;
    public EventMemberCast(Integer id, String event, String member1, String note) {
        super();
        this.id = id;
        this.event = event;
        this.member1 = member1;
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
    * Get value of member1.
    * @return the member1
    */
    public String getMember1() {
        return member1;
    }
    /**
     * Set the value for member1.
     * @param member1 the member1 to set
     */
    public void setMember1(String member1) {
        this.member1 = member1;
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
