import React from "react";
import { useState } from "react";

function Ex04_Login() {
	const [isLogin, setLogin] = useState(false);
	return (
		<>
			<h3>상태에 따른 렌더링 Test</h3>
			<button onClick={() => setLogin(!isLogin)}>
				{isLogin ? "로그아웃" : "로그인"}
			</button>
		</>
	);
}

export default Ex04_Login;
