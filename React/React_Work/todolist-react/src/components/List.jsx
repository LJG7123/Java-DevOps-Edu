import { use, useMemo, useState } from "react";
import "./List.css";
import TodoItem from "./TodoItem";
import { TodoStateContext } from "../App";

function List() {
	console.log("List()");
	const [search, setSearch] = useState("");
	const todos = use(TodoStateContext);
	const getFiltered = () => {
		if (search === "") return todos;

		return todos.filter((todo) =>
			todo.content.toLowerCase().includes(search.toLowerCase()),
		);
	};

	const filteredTodos = getFiltered();

	const { totalCount, doneCount, undoneCount } = useMemo(() => {
		const totalCount = todos.length;
		const doneCount = todos.filter((todo) => todo.isDone).length;
		const undoneCount = totalCount - doneCount;

		return { totalCount, doneCount, undoneCount };
	}, [todos]);

	return (
		<>
			<div className="List">
				<h4>Todo List 🚩</h4>
				<div>
					<div>total: {totalCount}</div>
					<div>doneCount: {doneCount}</div>
					<div>undoneCount: {undoneCount}</div>
				</div>
				<input
					type="text"
					placeholder="검색어를 입력해주세요."
					value={search}
					onChange={(e) => setSearch(e.target.value)}
				/>

				<div className="todos_wrapper">
					{filteredTodos.map((todo) => (
						<TodoItem key={todo.id} {...todo} />
					))}
				</div>
			</div>
		</>
	);
}

export default List;
