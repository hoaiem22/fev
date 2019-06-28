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
@Table(name = "fev_vote_key", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevVoteKey.findAll", query = "SELECT f FROM FevVoteKey f")
    , @NamedQuery(name = "FevVoteKey.findById", query = "SELECT f FROM FevVoteKey f WHERE f.id = :id")
    , @NamedQuery(name = "FevVoteKey.findByKey", query = "SELECT f FROM FevVoteKey f WHERE f.key = :key")
    , @NamedQuery(name = "FevVoteKey.findByPriority", query = "SELECT f FROM FevVoteKey f WHERE f.priority = :priority")
    , @NamedQuery(name = "FevVoteKey.findByIsActive", query = "SELECT f FROM FevVoteKey f WHERE f.isActive = :isActive")
    , @NamedQuery(name = "FevVoteKey.findByNote", query = "SELECT f FROM FevVoteKey f WHERE f.note = :note")
    , @NamedQuery(name = "FevVoteKey.findByCreatedbyUsername", query = "SELECT f FROM FevVoteKey f WHERE f.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "FevVoteKey.findByLastmodified", query = "SELECT f FROM FevVoteKey f WHERE f.lastmodified = :lastmodified")
    , @NamedQuery(name = "FevVoteKey.findByLastmodifiedbyUsername", query = "SELECT f FROM FevVoteKey f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class FevVoteKey implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "`key`", nullable = false, length = 250)
    private String key;
    @Basic(optional = false)
    @Column(name = "priority", nullable = false)
    private int priority;
    @Basic(optional = false)
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Column(name = "note", length = 250)
    private String note;
    @Column(name = "createdby_username", length = 50)
    private String createdbyUsername;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.DATE)
    private Date lastmodified;
    @Column(name = "lastmodifiedby_username", length = 50)
    private String lastmodifiedbyUsername;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "key")
    private Collection<FevVote> fevVoteCollection;

    public FevVoteKey() {
    }

    public FevVoteKey(Integer id) {
        this.id = id;
    }

    public FevVoteKey(Integer id, String key, int priority, boolean isActive) {
        this.id = id;
        this.key = key;
        this.priority = priority;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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
    public Collection<FevVote> getFevVoteCollection() {
        return fevVoteCollection;
    }

    public void setFevVoteCollection(Collection<FevVote> fevVoteCollection) {
        this.fevVoteCollection = fevVoteCollection;
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
        if (!(object instanceof FevVoteKey)) {
            return false;
        }
        FevVoteKey other = (FevVoteKey) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevVoteKey[ id=" + id + " ]";
    }
    
}
