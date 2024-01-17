package model.bean;

import java.io.Serializable;
import java.sql.Date;

public class PostBean implements Serializable {
	
	private int postId;
	private String title;
	private String comment;
	private Date postDate;
	private int userId;
	
	public PostBean() {
		
	}

	public PostBean(int postId, String title, String comment, Date postDate, int userId) {
		super();
		this.postId = postId;
		this.title = title;
		this.comment = comment;
		this.postDate = postDate;
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
