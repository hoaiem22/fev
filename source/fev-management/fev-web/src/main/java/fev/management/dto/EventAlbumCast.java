package fev.management.dto;

public class EventAlbumCast {

    private Integer id;
    private String event;
    private String img;

    public EventAlbumCast(Integer id, String event, String img) {
        super();
        this.id = id;
        this.event = event;
        this.img = img;
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
     * Get value of img.
     * @return the img
     */
    public String getImg() {
        return img;
    }
    /**
     * Set the value for img.
     * @param img the img to set
     */
    public void setImg(String img) {
        this.img = img;
    }

}
