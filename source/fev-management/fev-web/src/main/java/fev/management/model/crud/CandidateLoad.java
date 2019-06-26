package fev.management.model.crud;

public class CandidateLoad {

	private int id;
	private int member;
	private String group;
	private String position;
	private int total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public CandidateLoad(int id, int member, String group, String position, int total) {
		super();
		this.id = id;
		this.member = member;
		this.group = group;
		this.position = position;
		this.total = total;
	}
	
}
