/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fev.management.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_member", catalog = "fptueventclub", schema = "", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "studentID" }) })
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevMember.findAll", query = "SELECT f FROM FevMember f"),
		@NamedQuery(name = "FevMember.findById", query = "SELECT f FROM FevMember f WHERE f.id = :id"),
		@NamedQuery(name = "FevMember.findByFullname", query = "SELECT f FROM FevMember f WHERE f.fullname = :fullname"),
		@NamedQuery(name = "FevMember.findByStudentID", query = "SELECT f FROM FevMember f WHERE f.studentID = :studentID"),
		@NamedQuery(name = "FevMember.findByBirthdate", query = "SELECT f FROM FevMember f WHERE f.birthdate = :birthdate"),
		@NamedQuery(name = "FevMember.findByK", query = "SELECT f FROM FevMember f WHERE f.k = :k"),
		@NamedQuery(name = "FevMember.findByEmail", query = "SELECT f FROM FevMember f WHERE f.email = :email"),
		@NamedQuery(name = "FevMember.findByFacebook", query = "SELECT f FROM FevMember f WHERE f.facebook = :facebook"),
		@NamedQuery(name = "FevMember.findByImg", query = "SELECT f FROM FevMember f WHERE f.img = :img"),
		@NamedQuery(name = "FevMember.findBySex", query = "SELECT f FROM FevMember f WHERE f.sex = :sex"),
		@NamedQuery(name = "FevMember.findByAddress", query = "SELECT f FROM FevMember f WHERE f.address = :address"),
		@NamedQuery(name = "FevMember.findByPhone", query = "SELECT f FROM FevMember f WHERE f.phone = :phone"),
		@NamedQuery(name = "FevMember.findByPoint", query = "SELECT f FROM FevMember f WHERE f.point = :point"),
		@NamedQuery(name = "FevMember.findByNote", query = "SELECT f FROM FevMember f WHERE f.note = :note"),
		@NamedQuery(name = "FevMember.findByCreatedbyUsername", query = "SELECT f FROM FevMember f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevMember.findByLastmodified", query = "SELECT f FROM FevMember f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevMember.findByLastmodifiedbyUsername", query = "SELECT f FROM FevMember f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevMember implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "fullname", length = 50)
	private String fullname;
	@Basic(optional = false)
	@Column(name = "studentID", nullable = false, length = 50)
	private String studentID;
	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	@Column(name = "k", length = 50)
	private String k;
	@Column(name = "email", length = 250)
	private String email;
	@Column(name = "facebook", length = 250)
	private String facebook;
	@Column(name = "img", length = 5000)
	private String img;
	@Column(name = "sex", length = 10)
	private String sex;
	@Column(name = "address", length = 50)
	private String address;
	@Column(name = "phone", length = 50)
	private String phone;
	@Column(name = "point")
	private Integer point;
	@Column(name = "note", length = 255)
	private String note;
	@Column(name = "createdby_username", length = 50)
	private String createdbyUsername;
	@Column(name = "lastmodified")
	@Temporal(TemporalType.DATE)
	private Date lastmodified;
	@Column(name = "lastmodifiedby_username", length = 50)
	private String lastmodifiedbyUsername;
	@JsonBackReference
	@OneToMany(mappedBy = "member1")
	private Collection<FevEventMember> fevEventMemberCollection;
	@JoinColumn(name = "position", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevMemberPosition position;
	@JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevMemberStatus status;
	@JoinColumn(name = "`group`", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevMemberGroup group1;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "burden")
	private Collection<FevTransaction> fevTransactionCollection;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "candidate")
	private Collection<FevVote> fevVoteCollection;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "leader")
	private Collection<FevEvent> fevEventCollection;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "holder")
	private Collection<FevInventory> fevInventoryCollection;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member1")
	private Collection<FevVoteCandidate> fevVoteCandidateCollection;

	public FevMember() {
	}

	public FevMember(Integer id) {
		this.id = id;
	}

	public FevMember(Integer id, String studentID) {
		this.id = id;
		this.studentID = studentID;
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

	public String getCreatedbyUsername() {
		return createdbyUsername;
	}

	public void setCreatedbyUsername(String createdbyUsername) {
		this.createdbyUsername = createdbyUsername;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public String getLastmodifiedbyUsername() {
		return lastmodifiedbyUsername;
	}

	public void setLastmodifiedbyUsername(String lastmodifiedbyUsername) {
		this.lastmodifiedbyUsername = lastmodifiedbyUsername;
	}

	@XmlTransient
	public Collection<FevEventMember> getFevEventMemberCollection() {
		return fevEventMemberCollection;
	}

	public void setFevEventMemberCollection(Collection<FevEventMember> fevEventMemberCollection) {
		this.fevEventMemberCollection = fevEventMemberCollection;
	}

	public FevMemberPosition getPosition() {
		return position;
	}

	public void setPosition(FevMemberPosition position) {
		this.position = position;
	}

	public FevMemberStatus getStatus() {
		return status;
	}

	public void setStatus(FevMemberStatus status) {
		this.status = status;
	}

	public FevMemberGroup getGroup1() {
		return group1;
	}

	public void setGroup1(FevMemberGroup group1) {
		this.group1 = group1;
	}

	@XmlTransient
	public Collection<FevTransaction> getFevTransactionCollection() {
		return fevTransactionCollection;
	}

	public void setFevTransactionCollection(Collection<FevTransaction> fevTransactionCollection) {
		this.fevTransactionCollection = fevTransactionCollection;
	}

	@XmlTransient
	public Collection<FevVote> getFevVoteCollection() {
		return fevVoteCollection;
	}

	public void setFevVoteCollection(Collection<FevVote> fevVoteCollection) {
		this.fevVoteCollection = fevVoteCollection;
	}

	@XmlTransient
	public Collection<FevEvent> getFevEventCollection() {
		return fevEventCollection;
	}

	public void setFevEventCollection(Collection<FevEvent> fevEventCollection) {
		this.fevEventCollection = fevEventCollection;
	}

	@XmlTransient
	public Collection<FevInventory> getFevInventoryCollection() {
		return fevInventoryCollection;
	}

	public void setFevInventoryCollection(Collection<FevInventory> fevInventoryCollection) {
		this.fevInventoryCollection = fevInventoryCollection;
	}

	@XmlTransient
	public Collection<FevVoteCandidate> getFevVoteCandidateCollection() {
		return fevVoteCandidateCollection;
	}

	public void setFevVoteCandidateCollection(Collection<FevVoteCandidate> fevVoteCandidateCollection) {
		this.fevVoteCandidateCollection = fevVoteCandidateCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FevMember)) {
			return false;
		}
		FevMember other = (FevMember) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fev.management.entity.FevMember[ id=" + id + " ]";
	}

}
