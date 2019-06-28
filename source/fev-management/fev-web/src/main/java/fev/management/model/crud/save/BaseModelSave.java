package fev.management.model.crud.save;

import java.util.List;

public class BaseModelSave<T> {

	private List<T> data;

	/** Store id of addresses marked deleting. */
	private List<Integer> deletedIds;

	/**
	 * Get value of header.
	 * 
	 * @return the header
	 */

	public BaseModelSave(List<T> data, List<Integer> deletedIds) {
		super();
		this.data = data;
		this.deletedIds = deletedIds;
	}

	public BaseModelSave() {
		super();
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public List<Integer> getDeletedIds() {
		return deletedIds;
	}

	public void setDeletedIds(List<Integer> deletedIds) {
		this.deletedIds = deletedIds;
	}

}
