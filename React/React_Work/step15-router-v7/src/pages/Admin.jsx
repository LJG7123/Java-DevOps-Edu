import React from "react";
import { useSearchParams } from "react-router-dom";

function Admin() {
	const [params] = useSearchParams();
	console.log(params.get("name"));
	return (
		<>
			<h1>관리자 전용입니다.</h1>
		</>
	);
}

export default Admin;
