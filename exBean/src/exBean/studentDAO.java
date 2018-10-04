package exBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class studentDAO {
 public void insertStudent(studentVO item) throws Exception {
  String no = item.getNo();
  String name = item.getName();

  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201730858","201730858");

  PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");
  pstmt.setString(1,no);
  pstmt.setString(2,name);
  pstmt.executeUpdate();

  pstmt.close();
  conn.close();
 }
 
 public List<studentVO> selectStudent() throws Exception { //List에 record set을 담아 넘겨 준다
	   List<studentVO> items = new ArrayList<studentVO>();

	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201730858","201730858"); // DB 접속
	   
	   PreparedStatement pstmt = conn.prepareStatement("select * from student");
	   ResultSet rs = pstmt.executeQuery();// SQL문 실행

	   while(rs.next()) {
		   studentVO item = new studentVO();
		   item.setNo(rs.getString("no"));
		   item.setName(rs.getString("name"));
		  // 가져온 레코드 값 리스트에 세트
		   items.add(item);
	   } 

	   pstmt.close();
	   rs.close();
	   conn.close();
	   return items;
	 }
}
 