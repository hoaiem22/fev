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

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "fev_login_role", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevLoginRole.findAll", query = "SELECT f FROM FevLoginRole f")
    , @NamedQuery(name = "FevLoginRole.findById", query = "SELECT f FROM FevLoginRole f WHERE f.id = :id")
    , @NamedQuery(name = "FevLoginRole.findByRole", query = "SELECT f FROM FevLoginRole f WHERE f.role = :role")
    , @NamedQuery(name = "FevLoginRole.findByNote", query = "SELECT f FROM FevLoginRole f WHERE f.note = :note")})
public class FevLoginRole implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private Collection<FevLogin> fevLoginCollection;

    public FevLoginRole() {
    }

    public FevLoginRole(Integer id) {
        this.id = id;
    }

    public FevLoginRole(Integer id, String role) {
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

    @XmlTransient
    public Collection<FevLogin> getFevLoginCollection() {
        return fevLoginCollection;
    }

    public void setFevLoginCollection(Collection<FevLogin> fevLoginCollection) {
        this.fevLoginCollection = fevLoginCollection;
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
        if (!(object instanceof FevLoginRole)) {
            return false;
        }
        FevLoginRole other = (FevLoginRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.entity.FevLoginRole[ id=" + id + " ]";
    }
    
}
