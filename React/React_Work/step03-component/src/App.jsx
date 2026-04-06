import "./App.css";
import A, { Ex01_Export2, num } from "./components/Ex01_Export";
import Ex02_Library from "./components/Ex02_Library";
import Ex03_ButtonTest from "./components/Ex03_ButtonTest";
import Ex04_Article from "./components/Ex04_Article";
import Ex04_Header from "./components/Ex04_Header";
import Ex04_Nav from "./components/Ex04_Nav";
import Ex04_TripTest from "./components/Ex04_TripTest";
import Ex05_Product from "./components/Ex05_Product";

// 컴포넌트 작성
// 선언적
function Header() {
	return (
		<>
			<h3>여기는 Header 영역입니다. : {num}</h3>
		</>
	);
}

// 함수 표현식
const Footer = function () {
	return (
		<>
			<h3>여기는 Footer 입니다.</h3>
		</>
	);
};

function App() {
	return (
		<>
			{/* <h1>Component 실습하기</h1> */}
			{/* <Header /> */}
			{/* <Footer /> */}

			{/* 외부의 ~.jsx 컴포넌트 사용하기 */}
			{/* <A /> */}
			{/* <Ex01_Export2 /> */}

			{/* 2. Library 연습하기 */}
			{/* <Ex02_Library /> */}

			{/* 3. Button 연습 - img처리 */}
			{/* <Ex03_ButtonTest /> */}

			<Ex04_TripTest />
			<hr />
			<Ex05_Product />
		</>
	);
}

export default App;
