import java.sql.*;
import java.util.*;
public class JDBCOutTest {

	public static void main(String[] args) throws SQLException {
		String url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=Asia/Taipei&useUnicode=true&characterEncoding=utf-8";
		String user="root";
		String password="1234";
        String sql="call classicmodels.GetEmpInOffice(?, ?)";
        Connection cn=DriverManager.getConnection(url, user, password);
        CallableStatement st=cn.prepareCall(sql);
        Scanner sc =new Scanner(System.in);
        System.out.print("city:");
        String city=sc.nextLine(); 
        st.setString(1, city);
        st.registerOutParameter(2, Types.INTEGER);
        st.executeUpdate();
        int value=st.getInt(2);
        System.out.println("rows:"+value);
        cn.close();
	}

}
