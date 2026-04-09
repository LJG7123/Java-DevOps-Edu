import React, { memo } from "react";
import "./TodoItem.css";

function TodoItem({ id, isDone, content, date, onDelete, onUpdate }) {
	console.log("TodoItem()");
	const onChangeCheckbox = () => {
		//수정하기(checkbox 상태변경)
		onUpdate(id);
	};

	return (
		<div className="TodoItem">
			<input
				type="checkbox"
				checked={isDone}
				onChange={onChangeCheckbox}
			/>
			<div className="content">{content}</div>
			<div className="date">{new Date(date).toLocaleString()}</div>
			<button onClick={() => onDelete(id)}>삭제</button>
		</div>
	);
}

export default memo(TodoItem);
// export default memo(TodoItem, (prev, next) => {
// 	if (prev.id !== next.id) return false;
// 	if (prev.isDone !== next.isDone) return false;
// 	if (prev.content !== next.content) return false;
// 	if (prev.date !== next.date) return false;

// 	return true;
// });
