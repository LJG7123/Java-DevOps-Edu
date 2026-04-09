import { memo } from "react";
import "./Header.css";

const days = ["일", "월", "화", "수", "목", "금", "토"];

function Header() {
	const now = new Date();
	const today = `${now.getFullYear()}년 ${now.getMonth() + 1}월 ${now.getDate()}일 ${days[now.getDay()]}요일`;

	return (
		<>
			<div className="Header">
				<h3>오늘의 Plan📗</h3>
				<h1>{today}</h1>
			</div>
		</>
	);
}

export default memo(Header);
