package fev.management.dto;

import java.util.Date;

public class MemberCast {

    private Integer id;
    private String fullname;
    private String studentID;
    private Date birthdate;
    private String sex;
    private String address;
    private String phone;
    private int point;
    private String note;
    private String position;
    private String status;
    
    public MemberCast(Integer id, String fullname, String studentID, Date birthdate, String sex, String address,
            String phone, int point, String note, String position, String status) {
        super();
        this.id = id;
        this.fullname = fullname;
        this.studentID = studentID;
        this.birthdate = birthdate;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
        this.point = point;
        this.note = note;
        this.position = position;
        this.status = status;
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
    * Get value of fullname.
    * @return the fullname
    */
    public String getFullname() {
        return fullname;
    }

    /**
     * Set the value for fullname.
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
    * Get value of studentID.
    * @return the studentID
    */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Set the value for studentID.
     * @param studentID the studentID to set
     */
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    /**
    * Get value of birthdate.
    * @return the birthdate
    */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Set the value for birthdate.
     * @param birthdate the birthdate to set
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
    * Get value of sex.
    * @return the sex
    */
    public String getSex() {
        return sex;
    }

    /**
     * Set the value for sex.
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
    * Get value of address.
    * @return the address
    */
    public String getAddress() {
        return address;
    }

    /**
     * Set the value for address.
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
    * Get value of phone.
    * @return the phone
    */
    public String getPhone() {
        return phone;
    }

    /**
     * Set the value for phone.
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
    * Get value of point.
    * @return the point
    */
    public int getPoint() {
        return point;
    }

    /**
     * Set the value for point.
     * @param point the point to set
     */
    public void setPoint(int point) {
        this.point = point;
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
    * Get value of position.
    * @return the position
    */
    public String getPosition() {
        return position;
    }

    /**
     * Set the value for position.
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
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
    
    
    
}
