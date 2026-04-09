import React from "react";
import { useParams } from "react-router-dom";

function User() {
	const params = useParams();
	console.log(params);
	return (
		<>
			<h1>{params.id} User페이지 입니다.</h1>
		</>
	);
}

export default User;
