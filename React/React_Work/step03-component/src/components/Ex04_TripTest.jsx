import React from "react";
import Ex04_Header from "./Ex04_Header";
import Ex04_Nav from "./Ex04_Nav";
import Ex04_Article from "./Ex04_Article";
import "./Ex04_TripTest.css";

function Ex04_TripTest() {
	return (
		<>
			<Ex04_Header title="Trip" />
			<Ex04_Nav />
			<Ex04_Article
				title="태어난 김에 세계일주"
				body="올 여름 최고의 찬스"
			/>
		</>
	);
}

export default Ex04_TripTest;
