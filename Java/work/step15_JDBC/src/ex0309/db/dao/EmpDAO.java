package ex0309.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ex0309.db.util.DbManager;
import ex0309.dto.Emp;

public class EmpDAO {
	// 모든 사원의 이름 검색
	public void getNames() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DbManager.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("select ename from emp");
			
			while (rs.next()) {
				String ename = rs.getString(1);
				System.out.println(ename);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st, rs);
		}
	}
	
	// 사원 등록
	public void insert(Emp emp) {
		Connection con = null;
		Statement st = null;
		String sql = "insert into emp(empno, ename, sal, hiredate) "
				+ "values("+emp.getEmpno()+", '"+emp.getEname()+"',"+emp.getSal()+", now())";
		
		try {
			con = DbManager.getConnection();
			
			st = con.createStatement();
			
			int re = st.executeUpdate(sql);
			System.out.println(re);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, st);
		}
	}
	
	// PreparedStatement방식으로 insert
	public void preparedInsert(Emp emp) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into emp(empno, ename, sal, hiredate) values(?, ?, ?, now())";
		
		try {
			con = DbManager.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, emp.getEmpno());
			pst.setString(2, emp.getEname());
			pst.setInt(3, emp.getSal());
			
			int re = pst.executeUpdate();
			
			System.out.println(re);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst);
		}
	}
	
	// 사원 전체 검색
	// select empno, ename, sal, hiredate from emp
	public List<Emp> selectAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select empno, ename, sal, hiredate from emp";
		
		List<Emp> list = new ArrayList<>();
		
		try {
			con = DbManager.getConnection();
			
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				
				list.add(new Emp(empno, ename, sal, hiredate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst);
		}
		
		return list;
	}
	
	// 사원번호에 해당하는 사원정보 검색
	// select empno, ename, sal, hiredate from emp where empno = ?
	public Emp selectByEmpno(int no) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select empno, ename, sal, hiredate from emp where empno = ?";
		
		Emp emp = null;
		
		try {
			con = DbManager.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, no);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				String hiredate = rs.getString("hiredate");
				
				emp = new Emp(empno, ename, sal, hiredate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst, rs);
		}
		
		return emp;
	}
	
	// 사원번호에 해당하는 사원 삭제
	// delete from emp where empno = ?
	public int deleteByEmpno(int empno) {
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "delete from emp where empno = ?";
		
		int re = 0;
		
		try {
			con = DbManager.getConnection();
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, empno);
			
			re = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbManager.dbClose(con, pst);
		}
		
		return re;
	}
}
