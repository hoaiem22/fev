package fev.management.model.crud.save;

import java.io.Serializable;
import java.util.Date;

public class FevVoteTermSave implements Serializable {

	private int id;
	private String term;
	private String year;
	private String note;

	public FevVoteTermSave() {
		super();
	}

	public FevVoteTermSave(int id, String term, String year, String note) {
		super();
		this.id = id;
		this.term = term;
		this.year = year;
		this.note = note;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public boolean isValid() {
		return term != null && year != null;
	}

}
