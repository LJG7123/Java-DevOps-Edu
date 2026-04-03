import React from "react";
import "./Ex05_Item.css";

function Ex05_Item({ imgName, text, price }) {
	return (
		<div className="box">
			<img src={imgName} alt="" />
			<h5>{text}</h5>
			<span>{price}원</span>
		</div>
	);
}

export default Ex05_Item;
