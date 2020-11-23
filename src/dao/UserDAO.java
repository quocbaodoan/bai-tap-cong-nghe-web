package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;
import util.MySQLConnection;

public class UserDAO {

	public static User getUser(String username, String password) throws SQLException {

		Connection conn = MySQLConnection.connect();
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * FROM user WHERE username = ? AND password = ?");
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		User user = new User();

		while (rs.next()) {
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
		}
		return user;
	}
	
	public static ArrayList<User> getAllUser() throws SQLException {

		Connection conn = MySQLConnection.connect();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user");
		ResultSet rs = ps.executeQuery();
		ArrayList<User> list = new ArrayList<User>();

		while (rs.next()) {
			User Student = new User();
			Student.setID(rs.getString("id"));
			Student.setUsername(rs.getString("username"));
			Student.setPassword(rs.getString("password"));
			Student.setFirstname(rs.getString("firstname"));
			Student.setLastname(rs.getString("lastname"));

			list.add(Student);
		}

		return list;
	}

	public static ArrayList<User> getSearchUser(String search) throws SQLException {

		Connection conn = MySQLConnection.connect();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username LIKE '%"+search+"%' OR lastname LIKE '%"+search+"%' OR firstname LIKE '%"+search+"%'");
		ResultSet rs = ps.executeQuery();
		ArrayList<User> list = new ArrayList<User>();

		while (rs.next()) {
			User Student = new User();
			Student.setID(rs.getString("id"));
			Student.setUsername(rs.getString("username"));
			Student.setPassword(rs.getString("password"));
			Student.setFirstname(rs.getString("firstname"));
			Student.setLastname(rs.getString("lastname"));

			list.add(Student);
		}

		return list;
	}
	
	public static void delete(String username) throws SQLException {
		
		Connection conn2 = MySQLConnection.connect();
		PreparedStatement ps2 = conn2.prepareStatement("DELETE FROM user WHERE username=?");
		ps2.setString(1, username);
		ps2.executeUpdate();
	}
	
	
	public static void update(User student) throws SQLException {
		
		Connection conn = MySQLConnection.connect();
		PreparedStatement ps = conn.prepareStatement("UPDATE user SET username=?,password=?,firstname=?,lastname=? WHERE id=?");
		ps.setString(1, student.getUsername());
		ps.setString(2, student.getPassword());
		ps.setString(3, student.getFirstname());
		ps.setString(4, student.getLastname());
		ps.setString(5, student.getID());

		ps.executeUpdate();
	}
	
	public static User getUserByID(String id) throws SQLException {

		Connection conn = MySQLConnection.connect();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE id = '" + id + "' ");
		ResultSet rs = ps.executeQuery();
		User Student = new User();

		while (rs.next()) {
			Student.setID(rs.getString("id"));
			Student.setUsername(rs.getString("username"));
			Student.setPassword(rs.getString("password"));
			Student.setFirstname(rs.getString("firstname"));
			Student.setLastname(rs.getString("lastname"));
		}

		return Student;
	}

}
