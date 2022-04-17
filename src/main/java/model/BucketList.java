package model;

public class BucketList {

	private int listId;
	private String listType;
	private String description;
	private int priority;
	
	public BucketList(int listId, String listType, String description, int priority) {
		super();
		this.listId = listId;
		this.listType = listType;
		this.description = description;
		this.priority = priority;
	}
	
	public BucketList(String listType) {
		// TODO Auto-generated constructor stub
		this.listType = listType;
	}

	public int getListId() {
		return listId;
	}
	public String getListType() {
		return listType;
	}
	public String getDescription() {
		return description;
	}
	public int getPriority() {
		return priority;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "bL [listId=" + listId + ", listType=" + listType + ", description=" + description + ", priority="
				+ priority + "]";
	}
}
