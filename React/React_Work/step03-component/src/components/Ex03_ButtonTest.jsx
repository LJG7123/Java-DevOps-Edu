import React from "react";
import Ex03_ButtonImg from "./Ex03_ButtonImg";
import mail from "../assets/images/mail.png";
import location from "../assets/images/location.png";
import search from "../assets/images/search.png";
import emotion1 from "../assets/images/emotion1.png";

function Ex03_ButtonTest() {
	const btnClick = (e) => {
		console.log(e.target.innerText + "버튼 클릭됨");
	};

	const obj = {
		no: 1,
		name: "lee",
		age: 20,
		addr: "서울",
	};

	// assets 폴더 안에 있는 이미지는 import해서 사용한다
	return (
		<div style={{ display: "flex", gap: "24px" }}>
			<Ex03_ButtonImg
				imgSrc={mail}
				text="메일"
				btnClick={btnClick}
				{...obj}
			/>
			<Ex03_ButtonImg
				imgSrc={location}
				text="위치"
				btnClick={btnClick}
				obj={obj}
			/>
			<Ex03_ButtonImg imgSrc={search} text="검색" btnClick={btnClick} />
			<hr />
			<img src="emotion1.png" alt="" /> <br />
			<img src={emotion1} alt="" /> <br />
			<img src="../assets/images/emotion1.png" alt="" /> <br />
		</div>
	);
}

export default Ex03_ButtonTest;
