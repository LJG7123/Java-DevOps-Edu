import "./Item.css";

function Item({ imgName, text, price, seq, no }) {
	console.log(seq);
	console.log(no);
	return (
		<div className="box">
			<img src={imgName} alt="" />
			<h5>{text}</h5>
			<span>{price}원</span>
		</div>
	);
}

export default Item;
