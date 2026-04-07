import { memo } from "react";
import "./Header.css";

function Header() {
	// const today = `${new Date().getFullYear()}년 ${}월 ${}일 ${}요일`;

	return (
		<>
			<div className="Header">
				<h3>오늘의 Plan📗</h3>
				<h1>{new Date().toLocaleString()}</h1>
			</div>
		</>
	);
}

export default memo(Header);
