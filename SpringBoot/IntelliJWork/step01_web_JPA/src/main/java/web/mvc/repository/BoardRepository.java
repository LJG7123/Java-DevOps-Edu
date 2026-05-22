package web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import web.mvc.entity.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long>, QuerydslPredicateExecutor<Board> {
	/**
	 * 쿼리 메소드 정의
	 * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
	 */

	/**
	 1. 전달된 글번호보다 큰 레코드 검색
	 * 검색은 findByXxx로 시작한다
	 */
	List<Board> findByBnoGreaterThan(Long bno);

	/**
	 2. 전달된 글번호, 작성자 기준..
	 * 검색은 findByXxx로 시작한다
	 */
	List<Board> findByBnoLessThanEqualOrTitle(Long bno, String title);

	/**
	 * 글번호를 인수로 받아서 인수보다 큰 레코드 삭제
	 * JPQL문법을 사용할 때 DML문장은 @Modifying 필수
	 */
	@Query("delete from Board b where b.bno > ?1")
	@Modifying
	void deleteByBnoGreaterThan(Long bno);

	/**
	 * 글번호 or 제목을 인수로 전달받아 검색
	 * nativeQuery = true 옵션은 RDBMS문법에 맞춰 쿼리 생성
	 */
	@Query(value = "select * from board where bno = ?1 or title like ?2", nativeQuery = true)
	List<Board> findBnoTitle(Long bno, String title);

	/**
	 * 글번호, 제목, 작성자 인수로 전달받아 검색
	 */
	@Query("select b from Board b where b.bno = :#{#bo.bno} or b.title = :#{#bo.title} or b.writer = :#{#bo.writer}")
	List<Board> findByWhere(Board bo);

}
