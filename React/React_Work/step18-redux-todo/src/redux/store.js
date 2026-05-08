import { configureStore, createSlice } from "@reduxjs/toolkit";

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

const todoSlice = createSlice({
	name: "todo",
	initialState: mockData,
	reducers: {
		createTodo(state, action) {
			state.unshift(action.payload); // 앞에 추가
			// state.push(action.payload); // 끝에 추가
		},
		updateTodo(state, action) {
			let targetIndex = state.findIndex(
				(data) => data.id === action.payload,
			);
			state.at(targetIndex).isDone = !state.at(targetIndex).isDone;
		},
		deleteTodo(state, action) {
			let targetIndex = state.findIndex(
				(data) => data.id === action.payload,
			);
			state.splice(targetIndex, 1);
		},
	},
});

export const { createTodo, updateTodo, deleteTodo } = todoSlice.actions;

export default configureStore({
	reducer: {
		todo: todoSlice.reducer,
	},
});
