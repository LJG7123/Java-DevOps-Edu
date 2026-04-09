import { memo, use, useEffect, useRef, useState } from "react";
import "./Editor.css";
import { TodoDispatchContext } from "../App";

function Editor() {
	console.log("Editor()");
	const [content, setContent] = useState("");
	const contentRef = useRef();
	const { onCreate } = use(TodoDispatchContext);

	useEffect(() => contentRef.current.focus(), []); // 처음 마운트 될 때 focus

	const onSubmit = () => {
		if (content === "") {
			contentRef.current.focus();
			return;
		}

		onCreate(content);
		setContent("");
	};

	const onKeyDown = (e) => {
		if (e.keyCode === 13) {
			onSubmit();
		}
	};

	return (
		<>
			<div className="Editor">
				<input
					type="text"
					placeholder="새로운 todo"
					value={content}
					onChange={(e) => setContent(e.target.value)}
					ref={contentRef}
					onKeyDown={onKeyDown}
				/>
				<button onClick={onSubmit}>추가</button>
			</div>
		</>
	);
}

export default memo(Editor);
