import React from "react";
import { useDispatch, useSelector, shallowEqual } from "react-redux";
import { addCount, decreaseCount, deleteItem, sortName } from "../store.js";
import { Table, Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function Cart() {
	const cart = useSelector((state) => state.cart, shallowEqual);
	const dispatch = useDispatch();
	const smallProdcuctStyle = {
		border: "1px solid #ddd",
		width: "100px",
		height: "80px",
		cursor: "pointer",
	};
	let textverticalAlign = { verticalAlign: "middle", textAlign: "center" };

	return (
		<>
			<div className="container">
				<div className="row">
					<div className="col-sm-12" style={{ textAlign: "center" }}>
						<h5 style={{ padding: "50px" }}>장바구니</h5>
						<Table>
							<thead>
								<tr>
									<th>id</th>
									<th>상품이미지</th>
									<th>상품명</th>
									<th>수량</th>
									<th>변경하기</th>
								</tr>
							</thead>
							<tbody>
								{cart.map(({ id, imgurl, name, count }, i) => (
									<tr key={i}>
										<td style={textverticalAlign}>{id}</td>
										<td>
											<Link to={`/detail/${id}`}>
												<img
													src={`img/${imgurl}`}
													style={smallProdcuctStyle}
												/>
											</Link>
										</td>
										<td style={textverticalAlign}>
											{name}
										</td>
										<td style={textverticalAlign}>
											{count}
										</td>
										<td style={textverticalAlign}>
											<Button
												onClick={() => {
													dispatch(addCount(id));
												}}
												variant="outline-success"
												style={{ marginRight: "10px" }}
											>
												+
											</Button>
											<Button
												onClick={() => {
													dispatch(decreaseCount(id));
												}}
												variant="outline-warning"
												style={{ marginRight: "10px" }}
											>
												-
											</Button>
											<Button
												onClick={() => {
													dispatch(deleteItem(id));
												}}
												variant="outline-danger"
											>
												상품삭제
											</Button>
										</td>
									</tr>
								))}
							</tbody>
						</Table>
						<Button
							variant="outline-primary"
							onClick={() => {
								dispatch(sortName());
							}}
						>
							이름순정렬
						</Button>
					</div>
				</div>
			</div>
		</>
	);
}

export default Cart;
