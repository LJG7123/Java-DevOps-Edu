import React, { memo } from "react";
import "./TodoItem.css";
import { useDispatch } from "react-redux";
import { deleteTodo, updateTodo } from "../redux/store";

function TodoItem({ id, isDone, content, date }) {
	console.log("TodoItem()");
	const dispatch = useDispatch();
	const onUpdate = (targetId) => {
		dispatch(updateTodo(targetId));
	};
	const onDelete = (targetId) => {
		dispatch(deleteTodo(targetId));
	};
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
