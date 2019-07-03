/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fev.management.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_account", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevAccount.findAll", query = "SELECT f FROM FevAccount f"),
		@NamedQuery(name = "FevAccount.findById", query = "SELECT f FROM FevAccount f WHERE f.id = :id"),
		@NamedQuery(name = "FevAccount.findByUsername", query = "SELECT f FROM FevAccount f WHERE f.username = :username"),
		@NamedQuery(name = "FevAccount.findByPassword", query = "SELECT f FROM FevAccount f WHERE f.password = :password"),
		@NamedQuery(name = "FevAccount.findByNote", query = "SELECT f FROM FevAccount f WHERE f.note = :note"),
		@NamedQuery(name = "FevAccount.findByCreatedbyUsername", query = "SELECT f FROM FevAccount f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevAccount.findByLastmodified", query = "SELECT f FROM FevAccount f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevAccount.findByLastmodifiedbyUsername", query = "SELECT f FROM FevAccount f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@Column(name = "username", nullable = false, length = 255)
	private String username;
	@Basic(optional = false)
	@Column(name = "password", nullable = false, length = 255)
	private String password;
	@Column(name = "note", length = 255)
	private String note;
	@Column(name = "created")
	@Temporal(TemporalType.TIMESTAMP)
	private Date created;
	@Column(name = "createdby_username", length = 50)
	private String createdbyUsername;
	@Column(name = "lastmodified")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastmodified;
	@Column(name = "lastmodifiedby_username", length = 50)
	private String lastmodifiedbyUsername;
	@JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevAccountRole role;

	public FevAccount() {
	}

	public FevAccount(Integer id) {
		this.id = id;
	}

	public FevAccount(Integer id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
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

	public FevAccountRole getRole() {
		return role;
	}

	public void setRole(FevAccountRole role) {
		this.role = role;
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
		if (!(object instanceof FevAccount)) {
			return false;
		}
		FevAccount other = (FevAccount) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fev.management.entity.FevAccount[ id=" + id + " ]";
	}
}
