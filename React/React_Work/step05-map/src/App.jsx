import "./App.css";
import Ex01_Map from "./components/Ex01_Map";
import Ex02_Map from "./components/Ex02_Map";
import Ex03_Product from "./components/Ex03_Product";
import CommentList from "./components/CommentList";
import Ex04_MapKeyTest01 from "./components/EX04_MapKeyTest01";
import Ex05_MapkeyTest02 from "./components/Ex05_MapkeyTest02";

function App() {
	return (
		<>
			<h1>map 함수 연습하기</h1>
			{/* 1. 기본값 배열 map 사용하기 */}
			{/* <Ex01_Map /> */}

			{/* 2. Object 배열 map 사용하기 */}
			{/* <Ex02_Map /> */}

			{/* 3. Item 배열 map 사용하기 */}
			{/* <Ex03_Product /> */}

			{/* 4. Form요소 map활용 */}
			{/* <Ex04_MapKeyTest01 /> */}
			{/* <Ex05_MapkeyTest02 /> */}

			<CommentList />
		</>
	);
}

export default App;
