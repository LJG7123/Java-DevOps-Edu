import React, { useEffect, useRef, useState, use } from "react";
import "./Editor.css";
import { TodoContext } from "../App";

function Editor() {
	//함수가 전달
	const [content, setContent] = useState("");
	const contentRef = useRef();
	const { onCreate } = use(TodoContext); // react 19
	// const { onCreate } = use(TodoContext); // react 18

	//마운트 되었을 때 커서놓기
	useEffect(() => {
		contentRef.current.focus(); //커서놓기
	}, []);

	const onSubmit = () => {
		if (content === "") {
			contentRef.current.focus(); //커서놓기
			return;
		}

		onCreate(content); //부모쪽 함수 호출!!! (입력한 내용을 전달한다.)
		setContent(""); //내용비우기
		contentRef.current.focus();
	}; //onSubmitEnd

	//키보드에 enter를 했을때 onSubmit을  호출해주기위한 이벤트 함수
	const onKeyDownEnter = (e) => {
		console.log(e.keyCode);

		if (e.keyCode === 13) onSubmit();
	};

	return (
		<div className="Editor">
			<input
				type="text"
				placeholder="새로운 todo"
				value={content}
				onChange={(e) => setContent(e.target.value)}
				ref={contentRef}
				onKeyDown={onKeyDownEnter}
			/>
			<button onClick={onSubmit}>추가</button>
		</div>
	);
}

export default Editor;
