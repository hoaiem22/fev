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

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_feedback_status", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevFeedbackStatus.findAll", query = "SELECT f FROM FevFeedbackStatus f")
    , @NamedQuery(name = "FevFeedbackStatus.findById", query = "SELECT f FROM FevFeedbackStatus f WHERE f.id = :id")
    , @NamedQuery(name = "FevFeedbackStatus.findByStatus", query = "SELECT f FROM FevFeedbackStatus f WHERE f.status = :status")
    , @NamedQuery(name = "FevFeedbackStatus.findByNote", query = "SELECT f FROM FevFeedbackStatus f WHERE f.note = :note")
    , @NamedQuery(name = "FevFeedbackStatus.findByCreatedbyUsername", query = "SELECT f FROM FevFeedbackStatus f WHERE f.createdbyUsername = :createdbyUsername")
    , @NamedQuery(name = "FevFeedbackStatus.findByLastmodified", query = "SELECT f FROM FevFeedbackStatus f WHERE f.lastmodified = :lastmodified")
    , @NamedQuery(name = "FevFeedbackStatus.findByLastmodifiedbyUsername", query = "SELECT f FROM FevFeedbackStatus f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername")})
public class FevFeedbackStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 250)
    private String status;
    @Column(name = "note", length = 250)
    private String note;
    @Column(name = "createdby_username", length = 50)
    private String createdbyUsername;
    @Column(name = "lastmodified")
    @Temporal(TemporalType.DATE)
    private Date lastmodified;
    @Column(name = "lastmodifiedby_username", length = 50)
    private String lastmodifiedbyUsername;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "status")
    private Collection<FevFeedback> fevFeedbackCollection;

    public FevFeedbackStatus() {
    }

    public FevFeedbackStatus(Integer id) {
        this.id = id;
    }

    public FevFeedbackStatus(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    public Collection<FevFeedback> getFevFeedbackCollection() {
        return fevFeedbackCollection;
    }

    public void setFevFeedbackCollection(Collection<FevFeedback> fevFeedbackCollection) {
        this.fevFeedbackCollection = fevFeedbackCollection;
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
        if (!(object instanceof FevFeedbackStatus)) {
            return false;
        }
        FevFeedbackStatus other = (FevFeedbackStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevFeedbackStatus[ id=" + id + " ]";
    }
    
}
