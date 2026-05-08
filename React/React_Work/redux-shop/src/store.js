import { configureStore, createSlice } from "@reduxjs/toolkit";

const cart = createSlice({
	name: "cart",
	initialState: [
		{ id: 1, imgurl: "fruit1.jpg", name: "수박", count: 2 },
		{ id: 2, imgurl: "fruit2.jpg", name: "참외", count: 1 },
		{ id: 3, imgurl: "fruit3.jpg", name: "사과", count: 1 },
	],
	reducers: {
		addCount(state, action) {
			let num = state.findIndex((a) => {
				return a.id === action.payload;
			});

			console.log(num);
			console.log("내가 선택한 상품" + action.payload);
			console.log("내가 추가한 상품아이디는" + state[num].id);
			console.log("내가 추가한 상품갯수는" + state[num].count);

			state[num].count++;
		},
		decreaseCount(state, action) {
			let num = state.findIndex((a) => {
				return a.id === action.payload;
			});
			console.log(num);
			if (state[num].count > 0) {
				state[num].count--;
			} else if (state[num].count === 0) {
				alert("상품이 더 이상 없습니다.");
			}
		},
		addItem(state, action) {
			let num = state.findIndex((a) => a.id === action.payload.id);
			if (num !== -1) {
				state[num].count++;
			} else {
				state.push(action.payload);
			}
		},
		deleteItem(state, action) {
			let num = state.findIndex((a) => {
				return a.id === action.payload;
			});
			state.splice(num, 1);
		},
		sortName(state) {
			state.sort((a, b) => (a.name > b.name ? 1 : -1));
		},
	},
});

export const { addCount, decreaseCount, addItem, deleteItem, sortName } =
	cart.actions;

export default configureStore({
	reducer: { cart: cart.reducer },
});
