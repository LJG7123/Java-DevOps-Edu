import React from "react";
import "./Ex03_ButtonImg.css";

function Ex03_ButtonImg({ imgSrc, text, btnClick }) {
	// console.log(no, name, age, addr);
	return (
		<div className="divBtn">
			<img src={imgSrc} alt="" />
			<button onClick={btnClick}>{text}</button>
		</div>
	);
}

export default Ex03_ButtonImg;
