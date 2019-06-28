package fev.management.model.crud.save;

import java.io.Serializable;
import java.util.Date;

public class FevMemberSave implements Serializable {
	private Integer id;
	private String fullname;
	private String studentID;
	private Date birthdate;
	private String k;
	private String email;
	private String facebook;
	private String img;
	private String sex;
	private String address;
	private String phone;
	private String position;
	private String group1;
	private String status;
	private Integer point;
	private String note;

	public FevMemberSave() {
	}

	public FevMemberSave(Integer id, String fullname, String studentID, Date birthdate, String k, String email,
			String facebook, String img, String sex, String address, String phone, String position, String group1,
			String status, Integer point, String note) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.studentID = studentID;
		this.birthdate = birthdate;
		this.k = k;
		this.email = email;
		this.facebook = facebook;
		this.img = img;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.position = position;
		this.group1 = group1;
		this.status = status;
		this.point = point;
		this.note = note;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGroup1() {
		return group1;
	}

	public void setGroup1(String group1) {
		this.group1 = group1;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean isValid() {
		return studentID != null && position != null && group1 != null && status != null;
	}

}
