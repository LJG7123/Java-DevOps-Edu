package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.util.DbManager;
import db.vo.Room;
import db.vo.Student;
import db.vo.Subject;
import db.vo.Teacher;

public class StudentTeacherDAOImpl implements StudentTeacherDAO {

	@Override
	public List<Student> getGenderByWomen() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from student where 수_주민등록번호 like '%-2%'";
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			con = DbManager.getConnection();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst, rs);
		}
		
		return students;
	}

	@Override
	public List<Teacher> getTeacherInfoByAddr(String gu) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from teacher where 주소 like ?";
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		try {
			con = DbManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + gu + "%");
			rs = pst.executeQuery();
			
			while (rs.next()) {
				teachers.add(new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst, rs);
		}
		
		return teachers;
	}

	@Override
	public Teacher getTeacherInfoBySubject(String subject) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from teacher where 수강코드 = (select 수강코드 from subject where upper(과목)=upper( ? ))";
		
		Teacher teacher = null;
		
		try {
			con = DbManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, subject);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				teacher = new Teacher(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst, rs);
		}
		
		return teacher;
	}

	@Override
	public Teacher getTeacherInfoByNo(int teacherNo) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from v_teacher  where 강사번호 = ?";
		
		Teacher teacher = null;
		
		try {
			con = DbManager.getConnection();
			pst = con.prepareStatement(sql);
			pst.setInt(1, teacherNo);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				// 강사번호 int 강사이름 varchar(12) 수강코드 varchar(5) 과목 varchar(20) 강의실번호 int 수용인원 int
				teacher = new Teacher(rs.getInt(1), rs.getString(2), null, null, null, null, rs.getString(3));
				teacher.setRoom(new Room(rs.getInt(5), rs.getInt(6)));
				teacher.setSubject(new Subject(rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst, rs);
		}
		
		return teacher;
	}

}
