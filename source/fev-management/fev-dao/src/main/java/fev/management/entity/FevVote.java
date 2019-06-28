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

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_vote", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevVote.findAll", query = "SELECT f FROM FevVote f")
    , @NamedQuery(name = "FevVote.findById", query = "SELECT f FROM FevVote f WHERE f.id = :id")
    , @NamedQuery(name = "FevVote.findByNote", query = "SELECT f FROM FevVote f WHERE f.note = :note")
    , @NamedQuery(name = "FevVote.findByCreatedbyUsername", query = "SELECT f FROM FevVote f WHERE f.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "FevVote.findByLastmodified", query = "SELECT f FROM FevVote f WHERE f.lastmodified = :lastmodified")
    , @NamedQuery(name = "FevVote.findByLastmodifiedbyUsername", query = "SELECT f FROM FevVote f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class FevVote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "note", length = 250)
    private String note;
    @Column(name = "createdby_username", length = 50)
    private String createdbyUsername;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.DATE)
    private Date lastmodified;
    @Column(name = "lastmodifiedby_username", length = 50)
    private String lastmodifiedbyUsername;
    @JoinColumn(name = "candidate", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevMember candidate;
    @JoinColumn(name = "key", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevVoteKey key;

    public FevVote() {
    }

    public FevVote(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FevMember getCandidate() {
        return candidate;
    }

    public void setCandidate(FevMember candidate) {
        this.candidate = candidate;
    }

    public FevVoteKey getKey() {
        return key;
    }

    public void setKey(FevVoteKey key) {
        this.key = key;
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
        if (!(object instanceof FevVote)) {
            return false;
        }
        FevVote other = (FevVote) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevVote[ id=" + id + " ]";
    }
    
}
