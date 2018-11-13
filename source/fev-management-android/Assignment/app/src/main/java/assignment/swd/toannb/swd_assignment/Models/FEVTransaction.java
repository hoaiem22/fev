package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;

public class FEVTransaction implements Serializable {
    private int id, money;
    private String content, note;
    private FEVEvent fevEvent;
    private FEVMember fevMember;
    private FEVTransactionType transactionType;

    public FEVTransaction() {
    }

    public FEVTransaction(int id) {
        this.id = id;
    }

    public FEVTransaction(int id, int money, String content, String note, FEVEvent fevEvent, FEVMember fevMember, FEVTransactionType transactionType) {
        this.id = id;
        this.money = money;
        this.content = content;
        this.note = note;
        this.fevEvent = fevEvent;
        this.fevMember = fevMember;
        this.transactionType = transactionType;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public FEVEvent getFevEvent() {
        return fevEvent;
    }

    public void setFevEvent(FEVEvent fevEvent) {
        this.fevEvent = fevEvent;
    }

    public FEVMember getFevMember() {
        return fevMember;
    }

    public void setFevMember(FEVMember fevMember) {
        this.fevMember = fevMember;
    }

    public FEVTransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(FEVTransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "FEVTransaction{" +
                "id=" + id +
                ", money=" + money +
                ", content='" + content + '\'' +
                ", note='" + note + '\'' +
                ", fevEvent=" + fevEvent +
                ", fevMember=" + fevMember +
                ", transactionType=" + transactionType +
                '}';
    }
}
