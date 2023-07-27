package jdbc;
import java.sql.*;
import java.util.*;
public class jdbc_mysql {
	public static void main(String[] args) throws Exception{
//		writable();
//		writableui();
//		delete();
		readable();
	}
	public static void writable() throws Exception{
		String url = "jdbc:mysql://localhost:3306/dbs";
		String un="root";
		String pass = "root";
		String qu= "insert into employee values(2016,'sabari',300000)";
		Connection con = DriverManager.getConnection(url, un, pass);
		Statement s= con.createStatement();
		int a=s.executeUpdate(qu);
		System.out.println("No of rows attached: "+ a);
		con.close();
	}
	
	//write by user input
	
	public static void writableui() throws Exception{
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();s.nextLine();
		String name=s.nextLine();
		int sal=s.nextInt();
		String url = "jdbc:mysql://localhost:3306/dbs";
		String un = "root";
		String pass = "root";
		String qu = "insert into employee values(?,?,?);";
		Connection con = DriverManager.getConnection(url, un, pass);
		PreparedStatement pst = con.prepareStatement(qu);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setInt(3, sal);
		int a=pst.executeUpdate();
		System.out.println("1 row affected");
	}
	//delete
	
	public static void delete() throws Exception{
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		String url = "jdbc:mysql://localhost:3306/dbs";
		String un = "root";
		String pass = "root";
		String qu = "delete from employee where id=?";
		Connection con = DriverManager.getConnection(url, un, pass);
		PreparedStatement pst = con.prepareStatement(qu);
		pst.setInt(1, id);
		int l = pst.executeUpdate();
		System.out.println(l+" has affected");
	}
	
	public static void readable()  throws Exception{
		
			String url = "jdbc:mysql://localhost:3306/dbs";
			String un = "root";
			String pass = "root";
			String qu = "select * from employee";
			Connection con = DriverManager.getConnection(url, un, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qu);
//			rs.next();
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1));
				System.out.println("name: " + rs.getString(2));
				System.out.println("salary: " + rs.getInt(3));
			}
			con.close();
	}
}
