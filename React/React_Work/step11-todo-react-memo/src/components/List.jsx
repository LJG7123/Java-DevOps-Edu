import React from "react";
import TodoItem from "./TodoItem";
import "./List.css";
import { useState } from "react";
import { useMemo } from "react";
function List({ todos, onUpdate, onDelete }) {
	const [search, setSearch] = useState("");

	//검색어에 해당하는 todo정보 또는 모든 todo를 리턴하는 함수 작성
	const getFilterData = () => {
		if (search === "") return todos;
		else
			return todos.filter((todo) =>
				todo.content.toLowerCase().includes(search.toLowerCase()),
			);
	};

	const filterTodos = getFilterData();

	/*const getAnalyzedData = () => {
		console.log("getAnalyzedData()");

		const totalCount = todos.length;
		const doneCount = todos.filter((todo) => todo.isDone).length;
		const notDoneCount = totalCount - doneCount;

		return { totalCount, doneCount, notDoneCount };
	};

	const { totalCount, doneCount, notDoneCount } = getAnalyzedData();*/

	const { totalCount, doneCount, notDoneCount } = useMemo(() => {
		console.log("useMemo()");

		const totalCount = todos.length;
		const doneCount = todos.filter((todo) => todo.isDone).length;
		const notDoneCount = totalCount - doneCount;

		return { totalCount, doneCount, notDoneCount };
	}, [todos]);

	return (
		<div className="List">
			<h4>Todo List 🌱</h4>
			<div>
				<div>total: {totalCount}</div>
				<div>done: {doneCount}</div>
				<div>notDone: {notDoneCount}</div>
			</div>
			<input
				placeholder="검색어를 입력해주세요."
				value={search}
				onChange={(e) => setSearch(e.target.value)}
			/>

			<div className="todos_wrapper">
				{
					//todos.map((todo)=><TodoItem key={todo.id} {...todo} />)
					filterTodos.map((todo) => (
						<TodoItem
							key={todo.id}
							{...todo}
							onDelete={onDelete}
							onUpdate={onUpdate}
						/>
					))
				}
			</div>
		</div>
	);
}

export default List;
