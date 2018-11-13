package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;

public class FEVEvent implements Serializable {

    private int id;
    private String name, place, note,startTime,endTime,time;

    private Collection<FEVEventMember> fevEventMemberCollection;
    private Collection<FEVTransaction> fevTransactionCollection;
    private Collection<FEVEventAlbum> fevEventAlbumCollection;
    private FEVMember leader;

    public FEVEvent() {
    }


    public FEVEvent(int id, String name, String place, String note, String startTime, String endTime, String time,
                    Collection<FEVEventMember> fevEventMemberCollection, Collection<FEVTransaction> fevTransactionCollection,
                    Collection<FEVEventAlbum> fevEventAlbumCollection, FEVMember leader) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.note = note;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
        this.fevEventMemberCollection = fevEventMemberCollection;
        this.fevTransactionCollection = fevTransactionCollection;
        this.fevEventAlbumCollection = fevEventAlbumCollection;
        this.leader = leader;
    }

    public FEVEvent(int id, String name, String place, String note, String startTime, String endTime, String time) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.note = note;
        this.startTime = startTime;
        this.endTime = endTime;
        this.time = time;
    }

    public FEVEvent(int id) {
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Collection<FEVEventMember> getFevEventMemberCollection() {
        return fevEventMemberCollection;
    }

    public void setFevEventMemberCollection(Collection<FEVEventMember> fevEventMemberCollection) {
        this.fevEventMemberCollection = fevEventMemberCollection;
    }

    public Collection<FEVTransaction> getFevTransactionCollection() {
        return fevTransactionCollection;
    }

    public void setFevTransactionCollection(Collection<FEVTransaction> fevTransactionCollection) {
        this.fevTransactionCollection = fevTransactionCollection;
    }

    public Collection<FEVEventAlbum> getFevEventAlbumCollection() {
        return fevEventAlbumCollection;
    }

    public void setFevEventAlbumCollection(Collection<FEVEventAlbum> fevEventAlbumCollection) {
        this.fevEventAlbumCollection = fevEventAlbumCollection;
    }

    public FEVMember getLeader() {
        return leader;
    }

    public void setLeader(FEVMember leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "FEVEvent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", place='" + place + '\'' +
                ", note='" + note + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", time=" + time +
                ", fevEventMemberCollection=" + fevEventMemberCollection +
                ", fevTransactionCollection=" + fevTransactionCollection +
                ", fevEventAlbumCollection=" + fevEventAlbumCollection +
                ", leader=" + leader +
                '}';
    }
}
