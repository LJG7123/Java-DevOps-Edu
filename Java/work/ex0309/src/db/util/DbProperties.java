package db.util;

/**
 * db 설정 정보를 상수로 관리하는 인터페이스
 */
public interface DbProperties {
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/exam";
	String USER_ID = "ljg";
	String USER_PW = "1234";
}
