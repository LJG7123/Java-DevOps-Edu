package ex0211.overriding.goods;

public enum InsertResult {
	/**
	 * 상품코드 중복되었을 때
	 */
	INSERT_DUPLICATE,
	/**
	 * 배열의 길이를 벗어났을 때
	 */
	INSERT_OUTINDEX,
	/**
	 * 등록에 성공했을 때
	 */
	INSERT_SUCCESS;
}
