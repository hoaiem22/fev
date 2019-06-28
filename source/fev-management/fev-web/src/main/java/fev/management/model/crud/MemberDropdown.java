package fev.management.model.crud;

import java.util.List;

public class MemberDropdown {

	List<String> group;
	List<String> position;
	List<String> status;
	public MemberDropdown(List<String> group, List<String> position, List<String> status) {
		super();
		this.group = group;
		this.position = position;
		this.status = status;
	}
	public MemberDropdown() {
		super();
	}
	public List<String> getGroup() {
		return group;
	}
	public void setGroup(List<String> group) {
		this.group = group;
	}
	public List<String> getPosition() {
		return position;
	}
	public void setPosition(List<String> position) {
		this.position = position;
	}
	public List<String> getStatus() {
		return status;
	}
	public void setStatus(List<String> status) {
		this.status = status;
	}
	
	
}
