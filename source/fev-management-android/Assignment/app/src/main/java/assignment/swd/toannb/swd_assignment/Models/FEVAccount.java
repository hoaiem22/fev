package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVAccount implements Serializable {
    private int id;
    private String username, password, note;


    public FEVAccount() {
    }

    public FEVAccount(int id, String username, String password, String note) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "FEVAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
