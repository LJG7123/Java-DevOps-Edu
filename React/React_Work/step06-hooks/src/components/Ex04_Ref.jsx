import React from "react";
import { useEffect } from "react";
import { useRef } from "react";

function Ex04_Ref() {
	console.log("Ex04_Ref 실행됨");
	const inputRef = useRef();

	useEffect(() => {
		console.log(inputRef);

		inputRef.current.focus();
	});

	const clickCheck = () => {
		alert(`${inputRef.current.value}님 클릭하셨습니다.`);
		inputRef.current.value = "";
		inputRef.current.focus();
	};

	return (
		<>
			<h3>useRef로 DOM 접근하기</h3>
			<input type="text" ref={inputRef} />
			<button onClick={clickCheck}>클릭하세요</button>
		</>
	);
}

export default Ex04_Ref;
