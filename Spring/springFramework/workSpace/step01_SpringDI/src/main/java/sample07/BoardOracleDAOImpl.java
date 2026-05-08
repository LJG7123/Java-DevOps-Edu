package sample07;

import org.springframework.stereotype.Repository;

@Repository("boardOracleDao") //생성 <bean class="BoardOracleDAOImpl" id="boardOracleDao" /> 동일
public class BoardOracleDAOImpl implements BoardDAO {
	
	public BoardOracleDAOImpl() {
		System.out.println("BoardOracleDAOImpl 생성자 ");
	}

	@Override
	public void select() {
		System.out.println("BoardOracleDAOImpl select 호출됨..");

	}

}
