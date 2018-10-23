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
 * @author Admin
 */
@Entity
@Table(name = "fev_login", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FevLogin.findAll", query = "SELECT f FROM FevLogin f")
    , @NamedQuery(name = "FevLogin.findById", query = "SELECT f FROM FevLogin f WHERE f.id = :id")
    , @NamedQuery(name = "FevLogin.findByUsername", query = "SELECT f FROM FevLogin f WHERE f.username = :username")
    , @NamedQuery(name = "FevLogin.findByPassword", query = "SELECT f FROM FevLogin f WHERE f.password = :password")
    , @NamedQuery(name = "FevLogin.findByNote", query = "SELECT f FROM FevLogin f WHERE f.note = :note")})
public class FevLogin implements Serializable {

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
    @JoinColumn(name = "role", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private FevLoginRole role;

    public FevLogin() {
    }

    public FevLogin(Integer id) {
        this.id = id;
    }

    public FevLogin(Integer id, String username, String password) {
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

    public FevLoginRole getRole() {
        return role;
    }

    public void setRole(FevLoginRole role) {
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
        if (!(object instanceof FevLogin)) {
            return false;
        }
        FevLogin other = (FevLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fev.entity.FevLogin[ id=" + id + " ]";
    }
    
}
