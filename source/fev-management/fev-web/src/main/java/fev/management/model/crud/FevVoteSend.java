package fev.management.model.crud;

import java.util.List;

public class FevVoteSend {

	private String key;
	private int priority;
	private List<Integer> candidateIDs;
	
	public FevVoteSend() {
		super();
	}

	public FevVoteSend(String key, int priority, List<Integer> candidateIDs) {
		super();
		this.key = key;
		this.priority = priority;
		this.candidateIDs = candidateIDs;
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

	public List<Integer> getCandidateIDs() {
		return candidateIDs;
	}

	public void setCandidateIDs(List<Integer> candidateIDs) {
		this.candidateIDs = candidateIDs;
	}
	
	
}
