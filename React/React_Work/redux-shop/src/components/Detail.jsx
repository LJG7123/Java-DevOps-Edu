import React from "react";
import { useState, useEffect } from "react";
import { Nav } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { addItem } from "../store.js";
import { useDispatch } from "react-redux";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function Detail(props) {
	const { paramId } = useParams();
	console.log(paramId);
	const [tap, setTap] = useState(0);
	const [fade2, setFade2] = useState("");
	const dispatch = useDispatch();

	useEffect(() => {
		setFade2("end");
		return () => {
			setFade2("");
		};
	}, []);

	let selproduct = props.fruit.find((x) => x.id === Number(paramId));
	if (!selproduct) {
		return <div>해당 상품이 존재하지 않습니다.</div>;
	}
	const { id, imgUrl, title, content, price } = selproduct;
	console.log("내가 선택한 상품은: " + id + " " + title);

	return (
		<div className={"container start " + fade2}>
			<div className="row">
				<div className="col-md-6">
					<img src={"/" + imgUrl} width="100%" alt={title} />
				</div>
				<div className="col-md-6">
					<h4 className="pt-5">{title}</h4>
					<p>{content}</p>
					<p>{price}</p>
					<Button
						variant="primary"
						onClick={() => {
							// dispatch(addItem( {id : 1, imgurl : 'fruit1.jpg', name : 'Grey Yordan', count : 1}))
							dispatch(
								addItem({
									id: id,
									imgurl: imgUrl.replace("img/", ""),
									name: title,
									count: 1,
								}),
							);
						}}
						style={{ marginRight: "10px" }}
					>
						주문하기
					</Button>
					<Link to="/cart">
						<Button variant="outline-success">
							{" "}
							주문상품 확인하기{" "}
						</Button>
					</Link>
				</div>
			</div>

			<Nav
				variant="tabs"
				defaultActiveKey="link0"
				style={{ marginTop: "50px" }}
			>
				<Nav.Item>
					<Nav.Link
						onClick={() => {
							setTap(0);
						}}
						eventKey="link0"
					>
						버튼0
					</Nav.Link>
				</Nav.Item>
				<Nav.Item>
					<Nav.Link
						onClick={() => {
							setTap(1);
						}}
						eventKey="link1"
					>
						버튼1
					</Nav.Link>
				</Nav.Item>
				<Nav.Item>
					<Nav.Link
						onClick={() => {
							setTap(2);
						}}
						eventKey="link2"
					>
						버튼2
					</Nav.Link>
				</Nav.Item>
			</Nav>
			<TabContent tap={tap} />
		</div>
	);
}

function TabContent({ tap }) {
	let [fade, setFade] = useState("");
	useEffect(() => {
		setTimeout(() => {
			setFade("end");
		}, 10);
		return () => {
			setFade("");
		};
	}, [tap]);
	return (
		<div className={"start " + fade}>
			{[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tap]}
		</div>
	);
}
export default Detail;
