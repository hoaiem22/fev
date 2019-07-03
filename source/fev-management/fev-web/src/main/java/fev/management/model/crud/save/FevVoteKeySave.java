package fev.management.model.crud.save;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FevVoteKeySave implements Serializable {

	private String id;
	private String key;
	private int priority;
	// To match with json, add @JsonProperty
	// or edit getter and setter to getIsActive() and setIsActive()
	@JsonProperty
	private boolean isActive;
	private String note;
	private Date created;
	private String createdbyUsername;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public FevVoteKeySave(String id, String key, int priority, boolean isActive, String note, Date created,
			String createdbyUsername) {
		super();
		this.id = id;
		this.key = key;
		this.priority = priority;
		this.isActive = isActive;
		this.note = note;
		this.created = created;
		this.createdbyUsername = createdbyUsername;
	}

	public FevVoteKeySave() {
		super();
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

	public boolean isValid() {
		return key != null && priority > 0;
	}

}
