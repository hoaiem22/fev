/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fev.management.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_vote_term", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevVoteTerm.findAll", query = "SELECT f FROM FevVoteTerm f")
    , @NamedQuery(name = "FevVoteTerm.findById", query = "SELECT f FROM FevVoteTerm f WHERE f.id = :id")
    , @NamedQuery(name = "FevVoteTerm.findByTerm", query = "SELECT f FROM FevVoteTerm f WHERE f.term = :term")
    , @NamedQuery(name = "FevVoteTerm.findByYear", query = "SELECT f FROM FevVoteTerm f WHERE f.year = :year")
    , @NamedQuery(name = "FevVoteTerm.findByNote", query = "SELECT f FROM FevVoteTerm f WHERE f.note = :note")})
public class FevVoteTerm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "term", length = 50)
    private String term;
    @Column(name = "year", length = 10)
    private String year;
    @Column(name = "note", length = 250)
    private String note;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<FevVoteCandidate> fevVoteCandidateCollection;

    public FevVoteTerm() {
    }

    public FevVoteTerm(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        if (!(object instanceof FevVoteTerm)) {
            return false;
        }
        FevVoteTerm other = (FevVoteTerm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevVoteTerm[ id=" + id + " ]";
    }
    
}