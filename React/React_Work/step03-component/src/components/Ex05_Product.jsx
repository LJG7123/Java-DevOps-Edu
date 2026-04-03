import "./Ex05_Product.css";
import a from "../assets/images/a.png";
import b from "../assets/images/b.jpg";
import c from "../assets/images/c.png";
import d from "../assets/images/d.jpg";
import Ex05_Item from "./Ex05_Item";

function Ex05_Product() {
	return (
		<div id="product">
			<h3>오늘의 상품</h3>
			<p>새로운 상품을 만나보세요</p>
			<Ex05_Item imgName={a} text={"당도선별 11brix"} price={"25,000"} />
			<Ex05_Item imgName={b} text={"국내산 프리미엄"} price={"35,000"} />
			<Ex05_Item
				imgName={c}
				text={"13brix 100%국내산"}
				price={"28,000"}
			/>
			<Ex05_Item imgName={d} text={"고당도 참박수박"} price={"20,000"} />
		</div>
	);
}

export default Ex05_Product;
