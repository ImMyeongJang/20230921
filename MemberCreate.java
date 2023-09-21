package day02;
import java.sql.*;
/*
 * jdbc 를 이용해서 oracle db에 member 테이블을 생성해 보자
 *   ----테이블명: java_member---------------------
 *         회원번호: number(4)  primary key
 *         아이디: varchar2(20) unique
 *         이름  : varchar2(30) not null
 *         비밀번호: varchar2(16) not null
 *         연락처: varchar2(13)
 *   ----------------------------------------      
 *   create문
 * */

public class MemberCreate {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");//ojdbc6.jar안에 있음
		System.out.println("Driver Loading Success!!");
		
		//2. db 연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		Connection con=DriverManager.getConnection(url,user,pwd);
		System.out.println("DB Connected...");
		
		//3. query문-sql문 작성
		String sql="CREATE TABLE java_member (";
			   sql+=" no number(4) primary key,"; //PK: not null + unique
			   sql+=" userid varchar2(20) unique not null,"; //unique: 널 허용 + unique
			   sql+=" name varchar2(30) not null,";
			   sql+=" userpw varchar2(16) not null,";
			   sql+=" tel varchar2(13)";
			   sql+=")";
		
		System.out.println(sql);
		
		
		//4. query문을 실행시키기 위한 Statement객체 얻어오기 => Connection을 통해 얻어온다
		Statement stmt = con.createStatement();
		
		//5. Statement 의 execute()/executeUpdate()/executeQuery() 를 이용해 쿼리문을 실행시킨다
		
		//boolean execute(String sql)==> sql문이 select문이면 true를 반환, 그 외의 문장이면 false를 반환한다
		boolean isSel=stmt.execute(sql);//sql문을 실행시킨다
		
		
		System.out.println("isSel: "+isSel);
		System.out.println("scott계정에 java_member테이블 생성 성공!!");
		//6. DB 연결자원 반납
		stmt.close();
		con.close();
	}

}













