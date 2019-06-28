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
@Table(name = "fev_transaction", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevTransaction.findAll", query = "SELECT f FROM FevTransaction f"),
		@NamedQuery(name = "FevTransaction.findById", query = "SELECT f FROM FevTransaction f WHERE f.id = :id"),
		@NamedQuery(name = "FevTransaction.findByContent", query = "SELECT f FROM FevTransaction f WHERE f.content = :content"),
		@NamedQuery(name = "FevTransaction.findByMoney", query = "SELECT f FROM FevTransaction f WHERE f.money = :money"),
		@NamedQuery(name = "FevTransaction.findByNote", query = "SELECT f FROM FevTransaction f WHERE f.note = :note"),
		@NamedQuery(name = "FevTransaction.findByCreatedbyUsername", query = "SELECT f FROM FevTransaction f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevTransaction.findByLastmodified", query = "SELECT f FROM FevTransaction f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevTransaction.findByLastmodifiedbyUsername", query = "SELECT f FROM FevTransaction f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevTransaction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "content", length = 50)
	private String content;
	@Column(name = "money")
	private Integer money;
	@Column(name = "note", length = 50)
	private String note;
	@Column(name = "createdby_username", length = 50)
	private String createdbyUsername;
	@Column(name = "lastmodified")
	@Temporal(TemporalType.DATE)
	private Date lastmodified;
	@Column(name = "lastmodifiedby_username", length = 50)
	private String lastmodifiedbyUsername;
	@JoinColumn(name = "event", referencedColumnName = "id")
	@JsonManagedReference
	@ManyToOne
	private FevEvent event;
	@JoinColumn(name = "burden", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevMember burden;
	@JoinColumn(name = "type", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevTransactionType type;

	public FevTransaction() {
	}

	public FevTransaction(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
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

	public FevEvent getEvent() {
		return event;
	}

	public void setEvent(FevEvent event) {
		this.event = event;
	}

	public FevMember getBurden() {
		return burden;
	}

	public void setBurden(FevMember burden) {
		this.burden = burden;
	}

	public FevTransactionType getType() {
		return type;
	}

	public void setType(FevTransactionType type) {
		this.type = type;
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
		if (!(object instanceof FevTransaction)) {
			return false;
		}
		FevTransaction other = (FevTransaction) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fev.management.entity.FevTransaction[ id=" + id + " ]";
	}

}
