package ex0309.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex0309.db.util.DbManager;

public class TransactionDAO {
  /**
   * 계좌이체 기능 구현
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {
		Connection con = null;
		
		try {
			con = DbManager.getConnection();
			con.setAutoCommit(false);
			
			int result = withdraw(con, outputAccount, money);
			if (result == 0) throw new SQLException("출금계좌 오류로 계좌이체 실패했습니다.");
			
			result = deposit(con, inputAccount, money);
			if (result == 0) throw new SQLException("입금계좌 오류로 계좌이체 실패했습니다.");
			
			if (balanceCheck(con, inputAccount)) {
				throw new SQLException("입금계좌 총 금액 초과로 계좌이체 실패했습니다.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DbManager.dbClose(con, null);
		}
	}
	
	// 출금
	public int withdraw(Connection con, String outputAccount, int money) throws SQLException {
		PreparedStatement pst = null;
		String sql = "update bank set balance = balance - ? where account = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, money);
			pst.setString(2, outputAccount);
			
			return pst.executeUpdate();
		} finally {
			DbManager.dbClose(null, pst);
		}
	}
	
	// 입금
	public int deposit(Connection con, String inputAccount, int money) throws SQLException {
		PreparedStatement pst = null;
		String sql = "update bank set balance = balance + ? where account = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, money);
			pst.setString(2, inputAccount);
			
			return pst.executeUpdate();
		} finally {
			DbManager.dbClose(null, pst);
		}
	}
	
	// 잔액확인
	public boolean balanceCheck(Connection con, String inputAccount) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select balance from bank where account = ?";
		
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, inputAccount);
			rs = pst.executeQuery();
			
			if (rs.next() && rs.getInt("balance") > 1000) return rs.getInt("balance") > 1000;
		} finally {
			DbManager.dbClose(null, pst, rs);
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		//dao.transfer("A02", "A05",200);//입금, 출금, 금액
		
		System.out.println("--2. 입금계좌 오류----");
		dao.transfer("A04", "A01",200);//입금, 출금, 금액
		
		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		//dao.transfer("A02", "A01",700);//입금, 출금, 금액
		
		System.out.println("--4. 성공----------");
//		dao.transfer("A02", "A01",100);//입금, 출금, 금액
	}
}

