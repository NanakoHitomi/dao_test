package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.DBConnection;
import model.bean.PostBean;

public class PostDAO {
	
	//ポスト新規登録
	public int newPost(String title, String comment) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "INSERT INTO posts (title, comment) VALUES (?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, comment);
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
	
	//全ポストの情報取得
	public List <PostBean> getAllPostList() throws ClassNotFoundException, SQLException {
		List<PostBean> list = new ArrayList<PostBean>();
		String sql = "SELECT * FROM posts";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int post_id = res.getInt("post_id");
				String title = res.getString("title");
				String comment = res.getString("comment");
				Date post_date = res.getDate("post_date");
				int user_id = res.getInt("user_id");
				
				list.add(new PostBean(post_id, title, comment, post_date, user_id));
			}
		}
		return list;
	}
	
	//ポスト詳細
	public List<PostBean> getPostDetail(int postId) throws ClassNotFoundException, SQLException {
		List<PostBean> postList = new ArrayList<PostBean>();
		String sql = "SELECT * FROM posts WHERE post_id = ?";
		
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, postId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int post_id = res.getInt("post_id");
				String title = res.getString("title");
				String comment = res.getString("comment");
				Date post_date = res.getDate("post_date");
				int user_id = res.getInt("user_id");
				
				PostBean postLists = new PostBean(post_id, title, comment, post_date, user_id);
				
				postLists.setPostId(post_id);
				postLists.setTitle(title);
				postLists.setComment(comment);
				postLists.setPostDate(post_date);
				postLists.setUserId(user_id);
				
				postList.add(postLists);
			}
		}
		return postList;
	}
	//ポスト削除
	public int deletePost(int postId) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "DELETE FROM posts WHERE post_id = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, postId);
			pstmt.executeUpdate();
			processingNum = pstmt.executeUpdate();
			
		}
		return processingNum;
	}
	//ポスト更新
	public int postUpdate (String title, String comment, int postId) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "UPDATE posts SET title = ?, comment = ? WHERE  post_id = ?";
		try (Connection con = DBConnection.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, comment);
			pstmt.setInt(3, postId);
			
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
	//投稿ユーザーのポストのみ表示
	public List <PostBean> getUserPost(int userId) throws ClassNotFoundException, SQLException {
		List<PostBean> userPost = new ArrayList<PostBean>();
		String sql = "SELECT * FROM posts WHERE user_id = ?";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int post_id = res.getInt("post_id");
				String title = res.getString("title");
				String comment = res.getString("comment");
				Date post_date = res.getDate("post_date");
				int user_id = res.getInt("user_id");
				
				userPost.add(new PostBean(post_id, title, comment, post_date, user_id));
			}
		}
		return userPost;
	}
	//ニューポスト
	public int newPosts(String title, String comment, int userId) throws ClassNotFoundException, SQLException {
		int processingNum = 0;
		String sql = "INSERT INTO posts (title, comment, user_id) VALUES (?, ?, ?)";
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, title);
			pstmt.setString(2, comment);
			pstmt.setInt(3, userId);
			processingNum = pstmt.executeUpdate();
		}
		return processingNum;
	}
}
