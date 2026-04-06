import "./App.css";
import Ex01_Effect from "./components/Ex01_Effect";
import Ex02_Effect from "./components/Ex02_Effect";
import Ex03_Memo from "./components/Ex03_Memo";
import Ex04_Ref from "./components/Ex04_Ref";
import Ex05_Ref from "./components/Ex05_Ref";
import Ex06_Ref from "./components/Ex06_Ref";
import UseEffect_UseRef from "./components/UseEffect_UseRef";
import UseEffect_UseState from "./components/UseEffect_UseState";

function App() {
	return (
		<>
			<h1>Hooks 연습하기</h1>
			{/* 1. useEffect 연습하기 */}
			{/* <Ex01_Effect /> */}

			{/* 2. useEffect 자원 정리(return ~) 연습하기 */}
			{/* <Ex02_Effect /> */}

			{/* 3. useMemo 연습 */}
			{/* <Ex03_Memo /> */}

			{/* 4. useRef DOM 접근 Test */}
			{/* <Ex04_Ref /> */}

			{/* 5. useRef 와 useState 차이 */}
			{/* <Ex05_Ref /> */}

			{/* 6. useRef 와 let의 차이 */}
			{/* <Ex06_Ref />
			<h5>
				=================================================================================
			</h5>
			<Ex06_Ref /> */}

			{/* <UseEffect_UseState /> */}
			<UseEffect_UseRef />
		</>
	);
}

export default App;
