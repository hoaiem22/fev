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
@Table(name = "fev_member_position", catalog = "fptueventclub", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FevMemberPosition.findAll", query = "SELECT f FROM FevMemberPosition f"),
		@NamedQuery(name = "FevMemberPosition.findById", query = "SELECT f FROM FevMemberPosition f WHERE f.id = :id"),
		@NamedQuery(name = "FevMemberPosition.findByPosition", query = "SELECT f FROM FevMemberPosition f WHERE f.position = :position"),
		@NamedQuery(name = "FevMemberPosition.findByNote", query = "SELECT f FROM FevMemberPosition f WHERE f.note = :note"),
		@NamedQuery(name = "FevMemberPosition.findByCreatedbyUsername", query = "SELECT f FROM FevMemberPosition f WHERE f.createdbyUsername = :createdbyUsername"),
		@NamedQuery(name = "FevMemberPosition.findByLastmodified", query = "SELECT f FROM FevMemberPosition f WHERE f.lastmodified = :lastmodified"),
		@NamedQuery(name = "FevMemberPosition.findByLastmodifiedbyUsername", query = "SELECT f FROM FevMemberPosition f WHERE f.lastmodifiedbyUsername = :lastmodifiedbyUsername") })
public class FevMemberPosition implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	private Integer id;
	@Basic(optional = false)
	@Column(name = "position", nullable = false, length = 255)
	private String position;
	@Column(name = "note", length = 255)
	private String note;
	@Column(name = "createdby_username", length = 50)
	private String createdbyUsername;
	@Column(name = "lastmodified")
	@Temporal(TemporalType.DATE)
	private Date lastmodified;
	@Column(name = "lastmodifiedby_username", length = 50)
	private String lastmodifiedbyUsername;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
	private Collection<FevMember> fevMemberCollection;
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
	private Collection<FevVoteCandidate> fevVoteCandidateCollection;

	public FevMemberPosition() {
	}

	public FevMemberPosition(Integer id) {
		this.id = id;
	}

	public FevMemberPosition(Integer id, String position) {
		this.id = id;
		this.position = position;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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
	public Collection<FevMember> getFevMemberCollection() {
		return fevMemberCollection;
	}

	public void setFevMemberCollection(Collection<FevMember> fevMemberCollection) {
		this.fevMemberCollection = fevMemberCollection;
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
		if (!(object instanceof FevMemberPosition)) {
			return false;
		}
		FevMemberPosition other = (FevMemberPosition) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "fev.management.entity.FevMemberPosition[ id=" + id + " ]";
	}

}
