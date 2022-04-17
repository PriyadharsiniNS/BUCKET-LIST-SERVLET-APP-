package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BucketList;
import utility.ConnectionManager;

public class BucketListDAO {

	private static final String ADD_LIST = "INSERT INTO bucketlist(list_id, list_type, desp, pri) VALUES (?,?,?,?);"; 
	private static final String EDIT_LIST = "UPDATE bucketlist SET pri = ? WHERE list_id = ?;";
	private static final String VIEW_LIST = "SELECT * FROM bucketlist;";
	private static final String VIEW_LIST_BY_TYPE = "SELECT * FROM bucketlist GROUP BY list_type";
	private static final String DELETE_LIST = "DELETE FROM bucketlist where list_type = ?;";

		public void loadDriver()
		{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		ConnectionManager con = new ConnectionManager();
		Connection c = con.getConnection();
		
		public void addList(BucketList b) throws SQLException
		{
		loadDriver();
		PreparedStatement p = c.prepareStatement(ADD_LIST);
		p.setInt(1, b.getListId());
		p.setString(2, b.getListType());
		p.setString(3, b.getDescription());
		p.setInt(4, b.getPriority());
		p.executeUpdate();
		}
		
		public boolean editList(BucketList b) throws SQLException
		{
		loadDriver();
		boolean updatedRow;
		PreparedStatement g = c.prepareStatement(EDIT_LIST);
		g.setInt(1, b.getPriority());
		g.setInt(2, b.getListId());
		updatedRow = g.executeUpdate() > 0;
		return updatedRow;
		}
		
		public List<BucketList> viewList() throws SQLException
		{
		loadDriver();
		List<BucketList> todos = new ArrayList<BucketList>();
		PreparedStatement m = c.prepareStatement(VIEW_LIST);
		ResultSet r = m.executeQuery();
		while(r.next())
		{
			int lid = r.getInt("list_id");
			String ltype = r.getString("list_type");
			String ldes = r.getString("desp");
			int lp = r.getInt("pri");
			todos.add(new BucketList(lid, ltype, ldes, lp));
		}
		return todos;
		}
		
		public List<BucketList> viewListByType() throws SQLException
		{
		loadDriver();
		List<BucketList> todos_by_type = new ArrayList<BucketList>();
		PreparedStatement k = c.prepareStatement(VIEW_LIST_BY_TYPE);
		ResultSet s = k.executeQuery();
		while(s.next())
		{
			int lid = s.getInt("list_id");
			String ltype = s.getString("list_type");
			String ldes = s.getString("desp");
			int lp = s.getInt("pri");
			todos_by_type.add(new BucketList(lid, ltype, ldes, lp));
		}
		return todos_by_type;
		}
		
		public String deleteList(BucketList b) throws SQLException
		{
		loadDriver();
		String result = null;
		PreparedStatement v = c.prepareStatement(DELETE_LIST);
		v.setString(1, b.getListType());
		if(v.executeUpdate()>0)
			result = "Todo deleted succesfully";
		else
			result = "Deletion not succesfull";
		return result;
		}
}
