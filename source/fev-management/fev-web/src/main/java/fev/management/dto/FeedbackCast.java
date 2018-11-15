package fev.management.dto;

public class FeedbackCast {

    private Integer id;
    private String sender;
    private String content;
    private String status;
    private String note;
    public FeedbackCast(Integer id, String sender, String content, String status, String note) {
        super();
        this.id = id;
        this.sender = sender;
        this.content = content;
        this.status = status;
        this.note = note;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
    
   

}
