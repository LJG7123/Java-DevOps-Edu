import React from "react";
import { Link, useNavigate } from "react-router-dom";

function Header() {
	const nav = useNavigate();

	const btn1 = function () {
		nav("/");
	};
	const btn2 = function () {
		nav("/user/11");
	};
	const btn3 = function () {
		nav("/admin");
	};
	return (
		<div style={{ border: "1px red solid" }}>
			<h1>Header영역입니다.</h1>
			<Link to={"/"}>HOME</Link> &nbsp;&nbsp;&nbsp;
			<Link to={"/user/lee"}>USER</Link> &nbsp;&nbsp;&nbsp;
			<Link to={"/admin"}>ADMIN</Link> &nbsp;&nbsp;&nbsp;
			<hr />
			<a href="/">HOME</a> &nbsp;&nbsp;&nbsp;
			<a href="/user/lee">USER</a> &nbsp;&nbsp;&nbsp;
			<a href="/admin">ADMIN</a> &nbsp;&nbsp;&nbsp;
			<hr />
			<button onClick={btn1}>클릭 1</button>
			<button onClick={btn2}>클릭 2</button>
			<button onClick={btn3}>클릭 3</button>
		</div>
	);
}

export default Header;
