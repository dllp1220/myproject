import java.sql.*;
import java.util.*;
public class JDBCDemo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/classicmodels?useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="1234";
		String sql="UPDATE classicmodels.employees"
				+ " SET "
				+ " extension = ? ,"
				+ " officeCode = ?,"
				+ " reportsTo = ?,"
				+ " jobTitle = ? "
				+ " WHERE employeeNumber = ?;";
		Connection cn=DriverManager.getConnection(url, user, password);
		cn.setAutoCommit(false);
		PreparedStatement st= cn.prepareStatement(sql);
		st.setString(1,"0x2382");
		st.setString(2,"3");
		st.setInt(3,1076);
		st.setString(4,"Marketing");
		st.setInt(5,1802);
		int r=st.executeUpdate();
		Scanner sc=new Scanner(System.in);
		System.out.print("確認修改:1(Yes)/0:(No) ");
		int n=sc.nextInt();
		if(n==1)
			cn.commit();
		else
			cn.rollback();
		cn.setAutoCommit(true);
		cn.close();

	}

}
