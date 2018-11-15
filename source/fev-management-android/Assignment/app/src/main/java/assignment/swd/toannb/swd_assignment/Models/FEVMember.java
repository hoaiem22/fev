package assignment.swd.toannb.swd_assignment.Models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class FEVMember implements Serializable {
    private int id, point;
    private String fullname, studentId,sex, address, phone, note;
    private Date birthDay;
    private Collection<FEVEventMember> fevEventMemberCollection;
    private FEVMemberPosition position;
    private FEVMemberStatus status;
    private Collection<FEVTransaction> fevTransactionCollection;
    private Collection<FEVEvent> fevEventCollection;
    private Collection<FEVInventory> fevInventoryCollection;

    public FEVMember() {
    }

    public FEVMember(int id, int point, String fullname, String studentId, String sex, String address,
                     String phone, String note, Date birthDay, Collection<FEVEventMember> fevEventMemberCollection,
                     FEVMemberPosition position, FEVMemberStatus status, Collection<FEVTransaction> fevTransactionCollection,
                     Collection<FEVEvent> fevEventCollection, Collection<FEVInventory> fevInventoryCollection) {
        this.id = id;
        this.point = point;
        this.fullname = fullname;
        this.studentId = studentId;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.note = note;
        this.birthDay = birthDay;
        this.fevEventMemberCollection = fevEventMemberCollection;
        this.position = position;
        this.status = status;
        this.fevTransactionCollection = fevTransactionCollection;
        this.fevEventCollection = fevEventCollection;
        this.fevInventoryCollection = fevInventoryCollection;
    }

    public FEVMember(int id, int point, String fullname, String studentId, String sex, String address, String phone, String note, Date birthDay) {
        this.id = id;
        this.point = point;
        this.fullname = fullname;
        this.studentId = studentId;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        if(note == null){
            this.note = " ";
        }else{
            this.note = note;
        }
        this.note = note;
        this.birthDay = birthDay;
    }



    public FEVMember(int id) {
        this.id = id;
    }

    public FEVMember(int id, int point, String studentId) {
        this.id = id;
        this.point = point;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Collection<FEVEventMember> getFevEventMemberCollection() {
        return fevEventMemberCollection;
    }

    public void setFevEventMemberCollection(Collection<FEVEventMember> fevEventMemberCollection) {
        this.fevEventMemberCollection = fevEventMemberCollection;
    }

    public FEVMemberPosition getPosition() {
        return position;
    }

    public void setPosition(FEVMemberPosition position) {
        this.position = position;
    }

    public FEVMemberStatus getStatus() {
        return status;
    }

    public void setStatus(FEVMemberStatus status) {
        this.status = status;
    }

    public Collection<FEVTransaction> getFevTransactionCollection() {
        return fevTransactionCollection;
    }

    public void setFevTransactionCollection(Collection<FEVTransaction> fevTransactionCollection) {
        this.fevTransactionCollection = fevTransactionCollection;
    }

    public Collection<FEVEvent> getFevEventCollection() {
        return fevEventCollection;
    }

    public void setFevEventCollection(Collection<FEVEvent> fevEventCollection) {
        this.fevEventCollection = fevEventCollection;
    }

    public Collection<FEVInventory> getFevInventoryCollection() {
        return fevInventoryCollection;
    }

    public void setFevInventoryCollection(Collection<FEVInventory> fevInventoryCollection) {
        this.fevInventoryCollection = fevInventoryCollection;
    }

    @Override
    public String toString() {
        return "FEVMember{" +
                "id=" + id +
                ", point=" + point +
                ", fullname='" + fullname + '\'' +
                ", studentId='" + studentId + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                ", birthDay=" + birthDay +
                ", fevEventMemberCollection=" + fevEventMemberCollection +
                ", position=" + position +
                ", status=" + status +
                ", fevTransactionCollection=" + fevTransactionCollection +
                ", fevEventCollection=" + fevEventCollection +
                ", fevInventoryCollection=" + fevInventoryCollection +
                '}';
    }
}
