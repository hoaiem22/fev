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
@Table(name = "fev_inventory", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevInventory.findAll", query = "SELECT f FROM FevInventory f"),
		@NamedQuery(name = "FevInventory.findById", query = "SELECT f FROM FevInventory f WHERE f.id = :id"),
		@NamedQuery(name = "FevInventory.findByQuantity", query = "SELECT f FROM FevInventory f WHERE f.quantity = :quantity"),
		@NamedQuery(name = "FevInventory.findByNote", query = "SELECT f FROM FevInventory f WHERE f.note = :note"),
		@NamedQuery(name = "FevInventory.findByCreatedbyUsername", query = "SELECT f FROM FevInventory f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevInventory.findByLastmodified", query = "SELECT f FROM FevInventory f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevInventory.findByLastmodifiedbyUsername", query = "SELECT f FROM FevInventory f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevInventory implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "note", length = 250)
	private String note;
	@Column(name = "createdby_username", length = 50)
	private String createdbyUsername;
	@Column(name = "lastmodified")
	@Temporal(TemporalType.DATE)
	private Date lastmodified;
	@Column(name = "lastmodifiedby_username", length = 50)
	private String lastmodifiedbyUsername;
	@JoinColumn(name = "holder", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevMember holder;
	@JoinColumn(name = "status", referencedColumnName = "id", nullable = false)
	@JsonManagedReference
	@ManyToOne(optional = false)
	private FevInventoryStatus status;
	@JoinColumn(name = "item", referencedColumnName = "id")
	@JsonManagedReference
	@ManyToOne
	private FevInventoryItem item;

	public FevInventory() {
	}

	public FevInventory(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public FevMember getHolder() {
		return holder;
	}

	public void setHolder(FevMember holder) {
		this.holder = holder;
	}

	public FevInventoryStatus getStatus() {
		return status;
	}

	public void setStatus(FevInventoryStatus status) {
		this.status = status;
	}

	public FevInventoryItem getItem() {
		return item;
	}

	public void setItem(FevInventoryItem item) {
		this.item = item;
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
		if (!(object instanceof FevInventory)) {
			return false;
		}
		FevInventory other = (FevInventory) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fev.management.entity.FevInventory[ id=" + id + " ]";
	}

}
