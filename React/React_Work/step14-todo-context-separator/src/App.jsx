import { useMemo, useReducer, useRef, createContext } from "react";
import "./App.css";
import Editor from "./components/Editor";
import Header from "./components/Header";
import List from "./components/List";

//랜더링이 될때 다시 실행되지 않아도 되기에 함수 밖에 선언한다.
const mockData = [
	{
		id: 0,
		isDone: false,
		content: "React study",
		date: new Date().getTime(),
	},
	{ id: 1, isDone: false, content: "친구만나기", date: new Date().getTime() },
	{ id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
];

function reducer(state, action) {
	switch (action.type) {
		case "create":
			return [action.data, ...state];
		case "update":
			return state.map((todo) =>
				todo.id === action.targetId
					? { ...todo, isDone: !todo.isDone }
					: todo,
			);
		case "delete":
			return state.filter((todo) => todo.id !== action.targetId);
		default:
	}
}

export const TodoStateContext = createContext();
export const TodoDispatchContext = createContext();

function App() {
	const [todos, dispatch] = useReducer(reducer, mockData);
	const idRef = useRef(3);

	//등록하기
	const onCreate = (content) => {
		//console.log(content);
		dispatch({
			type: "create",
			data: {
				id: idRef.current++,
				isDone: false,
				content: content,
				date: new Date().getTime(),
			},
		});
	};
	//수정하기
	const onUpdate = (targetId) => {
		dispatch({ type: "update", targetId });
	};

	//삭제하기
	const onDelete = (targetId) => {
		dispatch({ type: "delete", targetId });
	};

	const memoizedDispatch = useMemo(
		() => ({ onCreate, onUpdate, onDelete }),
		[],
	);

	return (
		<div className="App">
			<Header />
			<TodoStateContext value={{ todos }}>
				<TodoDispatchContext value={memoizedDispatch}>
					<Editor />
					<List />
				</TodoDispatchContext>
			</TodoStateContext>
			{/* <List {...todos} onUpdate={onUpdate} onDelete={onDelete}/> */}
			{/* <List obj={{todos:todos,onUpdate:onUpdate,onDelete:onDelete}}/> */}
		</div>
	);
}

export default App;
