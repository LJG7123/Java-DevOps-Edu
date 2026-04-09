import Editor from "./components/Editor";
import Header from "./components/Header";
import List from "./components/List";
import "./App.css";
import {
	createContext,
	useCallback,
	useMemo,
	useReducer,
	useRef,
	useState,
} from "react";

export const TodoStateContext = createContext();
export const TodoDispatchContext = createContext();

const mockData = [
	{
		id: 0,
		isDone: false,
		content: "React Study",
		date: new Date().getTime(),
	},
	{ id: 1, isDone: true, content: "친구만나기", date: new Date().getTime() },
	{ id: 2, isDone: false, content: "낮잠자기", date: new Date().getTime() },
];

function reducer(state, action) {
	switch (action.type) {
		case "CREATE":
			return [action.data, ...state];
		case "UPDATE":
			return state.map((todo) =>
				todo.id === action.targetId
					? { ...todo, isDone: !todo.isDone }
					: todo,
			);
		case "DELETE":
			return state.filter((todo) => todo.id !== action.targetId);
		default:
			return state;
	}
}

function App() {
	// const [todos, setTodos] = useState(mockData);
	const [todos, dispatch] = useReducer(reducer, mockData);
	const idRef = useRef(todos.length);

	const onCreate = useCallback((content) => {
		dispatch({
			type: "CREATE",
			data: {
				id: idRef.current++,
				isDone: false,
				content: content,
				date: new Date().getTime(),
			},
		});
		// const newTodo = {
		// 	id: ++idRef.current,
		// 	isDone: false,
		// 	content: content,
		// 	date: new Date().getTime(),
		// };

		// setTodos([newTodo, ...todos]);
	}, []);

	const onUpdate = useCallback((targetId) => {
		dispatch({
			type: "UPDATE",
			targetId,
		});
		// const updated = todos.map((todo) =>
		// 	todo.id === targetId ? { ...todo, isDone: !todo.isDone } : todo,
		// );

		// setTodos(updated);
	}, []);

	const onDelete = useCallback((targetId) => {
		dispatch({
			type: "DELETE",
			targetId,
		});
		// const updated = todos.filter((todo) => todo.id !== targetId);

		// setTodos(updated);
	}, []);

	const memoizedDispatch = useMemo(() => {
		return { onCreate, onUpdate, onDelete };
	}, [onCreate, onUpdate, onDelete]);

	return (
		<>
			<div className="App">
				<Header />
				<TodoStateContext value={todos}>
					<TodoDispatchContext value={memoizedDispatch}>
						<Editor />
						<List />
					</TodoDispatchContext>
				</TodoStateContext>
			</div>
		</>
	);
}

export default App;
