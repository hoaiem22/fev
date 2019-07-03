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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_account_role", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevAccountRole.findAll", query = "SELECT f FROM FevAccountRole f"),
		@NamedQuery(name = "FevAccountRole.findById", query = "SELECT f FROM FevAccountRole f WHERE f.id = :id"),
		@NamedQuery(name = "FevAccountRole.findByRole", query = "SELECT f FROM FevAccountRole f WHERE f.role = :role"),
		@NamedQuery(name = "FevAccountRole.findByNote", query = "SELECT f FROM FevAccountRole f WHERE f.note = :note"),
		@NamedQuery(name = "FevAccountRole.findByCreatedbyUsername", query = "SELECT f FROM FevAccountRole f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevAccountRole.findByLastmodified", query = "SELECT f FROM FevAccountRole f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevAccountRole.findByLastmodifiedbyUsername", query = "SELECT f FROM FevAccountRole f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevAccountRole implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@Column(name = "role", nullable = false, length = 255)
	private String role;
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
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
	private Collection<FevAccount> fevAccountCollection;

	public FevAccountRole() {
    }

    public FevAccountRole(Integer id) {
        this.id = id;
    }

    public FevAccountRole(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @XmlTransient
    public Collection<FevAccount> getFevAccountCollection() {
        return fevAccountCollection;
    }

    public void setFevAccountCollection(Collection<FevAccount> fevAccountCollection) {
        this.fevAccountCollection = fevAccountCollection;
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
        if (!(object instanceof FevAccountRole)) {
            return false;
        }
        FevAccountRole other = (FevAccountRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevAccountRole[ id=" + id + " ]";
    }

}
