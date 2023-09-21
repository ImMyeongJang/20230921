package day02;
import java.sql.*;
/*
 * java_member 테이블에 레코드를 삽입해보자
 * 
 * 1 홍길동 hong 123 010-1111-2222

---시퀀스 생성문------------------------
CREATE SEQUENCE JAVA_MEMBER_SEQ
START WITH 3
INCREMENT BY 1
NOCACHE;
-----------------------------------
 * */
public class MemberInsert {

	public static void main(String[] args) throws Exception {
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. db연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB연결 성공!!");
		
		//3. sql문 작성-insert문
		String sql="INSERT INTO java_member(no,name,userid,userpw,tel)";
			   sql+=" VALUES(JAVA_MEMBER_SEQ.NEXTVAL,'김길동','kim'||JAVA_MEMBER_SEQ.CURRVAL,'abc','010-4111-5222')";
		System.out.println(sql);	   
		
		//4. Statement 얻기
		Statement stmt=con.createStatement();
		
		//5. execute()로 실행시키기
		boolean isSel=stmt.execute(sql);
		System.out.println("isSel: "+isSel);
		System.out.println("1개의 레코드 삽입 완료!!");
		//6. 연결자원 반납
		stmt.close();
		con.close();
	}

}
















