/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fev.management.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EmVH <hoaiem.heli22@gmail.com>
 */
@Entity
@Table(name = "fev_vote_candidate", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevVoteCandidate.findAll", query = "SELECT f FROM FevVoteCandidate f")
    , @NamedQuery(name = "FevVoteCandidate.findById", query = "SELECT f FROM FevVoteCandidate f WHERE f.id = :id")
    , @NamedQuery(name = "FevVoteCandidate.findByTotal", query = "SELECT f FROM FevVoteCandidate f WHERE f.total = :total")
    , @NamedQuery(name = "FevVoteCandidate.findByQuote", query = "SELECT f FROM FevVoteCandidate f WHERE f.quote = :quote")
    , @NamedQuery(name = "FevVoteCandidate.findByNote", query = "SELECT f FROM FevVoteCandidate f WHERE f.note = :note")})
public class FevVoteCandidate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "total")
    private Integer total;
    @Column(name = "quote", length = 5000)
    private String quote;
    @Column(name = "note", length = 250)
    private String note;
    @JoinColumn(name = "member", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevMember member1;
    @JoinColumn(name = "position", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevMemberPosition position;
    @JoinColumn(name = "group", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevMemberGroup group1;
    @JoinColumn(name = "term", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevVoteTerm term;

    public FevVoteCandidate() {
    }

    public FevVoteCandidate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public FevMember getMember1() {
        return member1;
    }

    public void setMember1(FevMember member1) {
        this.member1 = member1;
    }

    public FevMemberPosition getPosition() {
        return position;
    }

    public void setPosition(FevMemberPosition position) {
        this.position = position;
    }

    public FevMemberGroup getGroup1() {
        return group1;
    }

    public void setGroup1(FevMemberGroup group1) {
        this.group1 = group1;
    }

    public FevVoteTerm getTerm() {
        return term;
    }

    public void setTerm(FevVoteTerm term) {
        this.term = term;
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
        if (!(object instanceof FevVoteCandidate)) {
            return false;
        }
        FevVoteCandidate other = (FevVoteCandidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.management.entity.FevVoteCandidate[ id=" + id + " ]";
    }
    
}
