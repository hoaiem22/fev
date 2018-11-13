package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVFeedBack implements Serializable {

    private int id;
    private String from, content, note;
    private FEVFeedBackStatus status;

    public FEVFeedBack() {
    }

    public FEVFeedBack(int id, String from, String content, String note, FEVFeedBackStatus status) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.note = note;
        this.status = status;
    }

    public FEVFeedBack(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FEVFeedBackStatus getStatus() {
        return status;
    }

    public void setStatus(FEVFeedBackStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FEVFeedBackStatus{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                '}';
    }

}
