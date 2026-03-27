package ex0309.view;

import java.util.List;

import ex0309.db.dao.EmpDAO;
import ex0309.dto.Emp;

public class EmpView {

	public static void main(String[] args) {
		System.out.println("---------JDBC---------");
		
		EmpDAO dao = new EmpDAO();
//		dao.getNames();
		
//		dao.insert(new Emp(9001, "미미", 3000, null));
		dao.preparedInsert(new Emp(9000, "삼순", 3500, null));
		
		System.out.println("----전체 검색----");
		List<Emp> list = dao.selectAll();
		list.forEach(System.out::println);
		
		System.out.println("\n----사원번호 검색----");
		Emp emp = dao.selectByEmpno(9000);
		System.out.println(emp);
		
		System.out.println("\n----사원번호 삭제----");
		int re = dao.deleteByEmpno(9000);
		System.out.println("re = " + re);
		
		emp = dao.selectByEmpno(9000);
		System.out.println(emp);
		
		re = dao.deleteByEmpno(100000);
		System.out.println("re = " + re);
	}

}
