package day02;
import java.sql.*;
import java.util.*;

public class MemberInsert2 {

		
		public static void main(String[] args) throws Exception{
			Scanner sc=new Scanner(System.in);
			System.out.println("::회원 정보 등록::");
			System.out.println("이름=>");
			String name=sc.nextLine();
			System.out.println("ID=>");
			String id=sc.nextLine();
			System.out.println("Password=>");
			String pw=sc.nextLine();
			System.out.println("연락처=>");
			String tel=sc.nextLine();
			System.out.println(name+", "+id+", "+pw+", "+tel+" 정보를 저장할게요!");
			
			
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 연결ok");
			//2. db연결
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="scott", pwd="1234";
			
			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB연결 완료..");
			
			
//3. sql문 작성-insert문
String sql="INSERT INTO JAVA_MEMBER (no,userid,name,userpw,tel)";
 	sql+=" values(java_member_SEQ.NEXTVAL,'"+id+"','"+name+"','"+pw+"','"+tel+"')";
 	System.out.println(sql);
 	
			 	
			 	System.out.println(sql);
		 	//4. Statement 얻기
				Statement stmt= con.createStatement();
			//5. execute()로 실행시키기
				boolean isSel=stmt.execute(sql);
			 	System.out.println("isSel: "+isSel);
				System.out.println("Scott계정에 java_member테이블 \n"
						+ "				회원가입 정보 insert 성공!");
				
			//6. 연결자원 반납
				stmt.close();
				
				con.close();
	}

}
