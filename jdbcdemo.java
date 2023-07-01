package srii;
import java.sql.*;
public class jdbcdemo {
	public static void read() throws SQLException {
		String url="jdbc:mysql://localhost:3306/srii";
		String name="root";
		String pas="Sri@1234";
		String query="select * from employe";
       Connection con=DriverManager.getConnection(url,name,pas);
       Statement s=con.createStatement();
       ResultSet rs=s.executeQuery(query);
       
       while(rs.next()) {
       System.out.println("id "+rs.getInt(1));
       System.out.println("name "+rs.getString(2));
       System.out.println("sal   "+rs.getInt(3));
       con.close();
	}
	}
	public static void insert() throws SQLException {
		String url="jdbc:mysql://localhost:3306/srii";
		String name="root";
		String pas="Sri@1234";
		String query="insert into employe values (2,'vidya',1234)";
       Connection con=DriverManager.getConnection(url,name,pas);
       Statement s=con.createStatement();
       int r=s.executeUpdate(query);
       
  
       con.close();
	}
	public static void insertpst() throws SQLException {
		String url="jdbc:mysql://localhost:3306/srii";
		String name="root";
		String pas="Sri@1234";
		
		int id=3;
		String ename="sv";
		int sal=1233;
		
		String query="insert into employe values (?,?,?);";
	    Connection con=DriverManager.getConnection(url,name,pas);
	     PreparedStatement pst=con.prepareStatement(query);
	     pst.setInt(1, id);
	     pst.setString(2,ename);
	     pst.setInt(3, sal);

	       int r=pst.executeUpdate();
		System.out.println("insert "+r);
		con.close();
	}
	public static void delete() throws SQLException {
		String url="jdbc:mysql://localhost:3306/srii";
		String name="root";
		String pas="Sri@1234";
		
		int id=3;
	
		String query="delete from employe where e_id="+id+";";
	    Connection con=DriverManager.getConnection(url,name,pas);
	     PreparedStatement pst=con.prepareStatement(query);
	       int r=pst.executeUpdate(query);
		System.out.println("delete "+r);
		con.close();
	}
	public static void update() throws SQLException {
		String url="jdbc:mysql://localhost:3306/srii";
		String name="root";
		String pas="Sri@1234";

		String query="update employ set sal=534 where e_id=1";
	    Connection con=DriverManager.getConnection(url,name,pas);
	 
	    Statement s=con.createStatement();
        int r=s.executeUpdate(query);
		System.out.println("update "+r);
		con.close();
	}
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//insertpst();
		//delete();
		update();
	
	}
}
