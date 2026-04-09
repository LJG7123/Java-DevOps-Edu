import { memo, use } from "react";
import "./TodoItem.css";
import { TodoDispatchContext } from "../App";

function TodoItem({ id, isDone, content, date }) {
	console.log("TodoItem()");
	const { onUpdate, onDelete } = use(TodoDispatchContext);

	return (
		<>
			<div className="TodoItem">
				<input
					type="checkbox"
					checked={isDone}
					onChange={() => onUpdate(id)}
				/>
				<div className="content">{content}</div>
				<div className="date">{new Date(date).toLocaleString()}</div>
				<button onClick={() => onDelete(id)}>삭제</button>
			</div>
		</>
	);
}

export default memo(TodoItem, (prev, next) => {
	if (prev.id !== next.id) return false;
	if (prev.isDone !== next.isDone) return false;
	if (prev.content !== next.content) return false;
	if (prev.date !== next.date) return false;

	return true;
});
