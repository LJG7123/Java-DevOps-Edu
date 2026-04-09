import { useReducer, useState } from "react";

const reducer = (state, action) => {
	switch (action.type) {
		case "plus":
			return state + action.data;
		case "minus":
			return state - action.data;
		default:
			return state;
	}
};

function Ex01_Count() {
	const [state, dispatch] = useReducer(reducer, 0);

	const minusClick = function () {
		// state 값 변경
		dispatch({ type: "minus", data: 1 });
	};

	const plusClick = function () {
		// state 값 변경
		dispatch({ type: "plus", data: 2 });
	};

	return (
		<div>
			<h2>숫자 증가 or 감소</h2>
			<button onClick={minusClick}>빼기</button>
			<span>state = {state}</span>
			<button onClick={plusClick}>더하기</button>
		</div>
	);
}

export default Ex01_Count;
