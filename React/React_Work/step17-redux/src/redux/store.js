import { configureStore, createSlice } from "@reduxjs/toolkit";

// 작은 단위(slice)의 형태로 state 정보를 정의한다.
const countSlice = createSlice({
	name: "count",
	initialState: { no: 0 },
	reducers: {
		up(state) {
			// console.log("up.. state = " + state);
			state.no += 1;
		},
		down(state) {
			// console.log("down.. state = " + state);
			state.no -= 1;
		},
		incrementByNo(state, action) {
			// console.log(
			// 	"increment.. state = " + state + ", action = " + action,
			// );
			console.log(action);
			state.no += action.payload;
		},
	},
});

// Cart 정보
const cartSlice = createSlice({
	name: "cart",
	initialState: [
		{ id: 1, name: "수박", count: 3 },
		{ id: 2, name: "딸기", count: 2 },
		{ id: 3, name: "포도", count: 1 },
	],
	reducers: {
		addCount(state, action) {
			let index = state.findIndex((item) => item.id === action.payload);
			state[index].count++;
		},
		addItem(state, action) {
			state.push(action.payload);
		},
		sortByName(state) {
			state.sort((a, b) => a.name.localeCompare(b.name));
		},
	},
});

// 위 reducers에 정의된 함수를 외부에서 호출해서 사용할 수 있도록 export
export const { up, down, incrementByNo } = countSlice.actions;
export const { addItem, addCount, sortByName } = cartSlice.actions;

// 여러 slice들을 reducer에 등록하는 작업이 필요함
export default configureStore({
	reducer: {
		count: countSlice.reducer,
		cart: cartSlice.reducer,
	},
});
