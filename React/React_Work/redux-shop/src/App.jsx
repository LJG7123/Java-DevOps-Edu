import { Button, Navbar, Container, Nav } from "react-bootstrap";
import { useState } from "react";
import { Routes, Route, Link, useNavigate, Outlet } from "react-router-dom";
import axios from "axios";
import Product from "./components/Product";
import Detail from "./components/Detail";
import data from "./db/fruit";
import data2 from "./db/veggie";
import Title from "./components/Title";
import Title2 from "./components/Title2";
import ComVeggie from "./components/ComVeggie";
import Footer from "./components/Footer";
import Cart from "./components/Cart";
import FruitBoard from "./components/FruitBoard";

function App() {
	const [fruit, setFruit] = useState(data);
	const [veggie, setVeggie] = useState(data2);
	const [count, setCount] = useState(1);
	const [input, setInput] = useState("");
	const navigate = useNavigate();

	const sortByName = () => {
		let sortedFruit = [...fruit].sort((a, b) =>
			a.title > b.title ? 1 : -1,
		);
		setFruit(sortedFruit);
		console.log(sortedFruit);
	};
	const sortByPriceLowToHigh = () => {
		let sortedFruit = [...fruit].sort((a, b) => a.price - b.price);
		setFruit(sortedFruit);
		console.log(sortedFruit);
	};
	const sortByPriceHighToLow = () => {
		let sortedFruit = [...fruit].sort((a, b) => b.price - a.price);
		setFruit(sortedFruit);
		console.log(sortedFruit);
	};

	return (
		<>
			<div className="App" style={{ textAlign: "center" }}>
				<Navbar bg="dark" variant="dark">
					<Container>
						<Navbar.Brand onClick={() => navigate("/")}>
							과일농장
						</Navbar.Brand>
						<Nav className="me-auto">
							<Nav.Link onClick={() => navigate("/")}>
								홈으로
							</Nav.Link>
							<Nav.Link onClick={() => navigate("/detail/1")}>
								상세페이지
							</Nav.Link>
							<Nav.Link onClick={() => navigate("/cart")}>
								장바구니
							</Nav.Link>
							<Nav.Link onClick={() => navigate("/about")}>
								회사소개
							</Nav.Link>
							<Nav.Link onClick={() => navigate("/board")}>
								게시판
							</Nav.Link>
						</Nav>
					</Container>
				</Navbar>
				<Routes>
					<Route
						path="/"
						element={
							<div>
								<div className="slider"></div>
								<Title />
								{/* <div className="container">
									<div className="row">
										<div style={{ textAlign: "center" }}>
											<Button
												variant="outline-primary"
												onClick={sortByName}
											>
												이름순 정렬
											</Button>{" "}
											<Button
												variant="outline-secondary"
												onClick={sortByPriceLowToHigh}
											>
												낮은가격순 정렬
											</Button>{" "}
											<Button
												variant="outline-success"
												onClick={sortByPriceHighToLow}
											>
												높은가격순 정렬
											</Button>{" "}
										</div>
									</div>
								</div> */}

								<div className="container">
									<div className="row">
										<div
											className="col-md-6"
											style={{ textAlign: "left" }}
										>
											<input
												placeholder="상품명을 입력하세요"
												onChange={(e) =>
													setInput(e.target.value)
												}
												value={input}
												style={{
													padding: "10px",
													marginLeft: "10px",
													borderRadius: "4px",
													border: "1px solid #ccc",
													width: "250px",
													marginRight: "10px",
												}}
											/>
										</div>
										<div
											className="col-md-6"
											style={{ textAlign: "right" }}
										>
											<select
												onChange={(e) => {
													if (
														e.target.value === "low"
													)
														sortByPriceLowToHigh();
													if (
														e.target.value ===
														"high"
													)
														sortByPriceHighToLow();
													if (
														e.target.value ===
														"name"
													)
														sortByName();
												}}
												style={{
													padding: "10px",
													marginLeft: "10px",
													borderRadius: "4px",
													border: "1px solid #ccc",
													width: "150px",
												}}
											>
												<option value="">
													정렬 선택
												</option>
												<option value="low">
													낮은 가격순
												</option>
												<option value="high">
													높은 가격순
												</option>
												<option value="name">
													이름순
												</option>
											</select>
										</div>
									</div>
								</div>

								{/* <div
									className="container"
									style={{ marginTop: "30px" }}
								>
									<div className="row">
										<div className="col-md-4">1</div>
										<div className="col-md-4">2</div>
										<div className="col-md-4">3</div>
									</div>
									<div className="row">
										{fruit.map((ele) => (
											<Product {...ele} key={ele.id} />
										))}
									</div>
								</div> */}

								<div
									className="container"
									style={{ marginTop: "30px" }}
								>
									<div className="row">
										{fruit
											.filter(
												(item) =>
													item.title
														.toLowerCase()
														.includes(
															input.toLowerCase(),
														), // 제목 검색
											)
											.map((ele) => (
												<Product
													{...ele}
													key={ele.id}
												/> // 필터링된 항목 출력
											))}
									</div>
								</div>
								<div className="container">
									<div className="row">
										<div style={{ textAlign: "center" }}>
											<Title2 />
											<Button
												variant="outline-success"
												count={count}
												onClick={() => {
													if (count == 1) {
														axios
															.get(
																"https://ljg7123.github.io/react-data/veggie2.json",
															)
															.then((result) => {
																let copy10 = [
																	...veggie,
																	...result.data,
																];
																setVeggie(
																	copy10,
																);
																setCount(
																	count + 1,
																);
															});
													} else if (count == 2) {
														axios
															.get(
																"https://ljg7123.github.io/react-data/veggie3.json",
															)
															.then((result) => {
																let copy11 = [
																	...veggie,
																	...result.data,
																];
																setVeggie(
																	copy11,
																);
																setCount(
																	count + 1,
																);
															});
													}
													if (count === 3) {
														alert(
															"더이상 상품이 없습니다.",
														);
													}
												}}
											>
												{" "}
												+ 3개 상품 더 보기{" "}
											</Button>{" "}
											<div
												className="container"
												style={{ marginTop: "30px" }}
											>
												<div className="row">
													{veggie.map((ele) => (
														<ComVeggie
															veggie={ele}
															key={ele.id}
														/>
													))}{" "}
												</div>
											</div>
										</div>
									</div>
								</div>
								<Footer />
							</div>
						}
					/>
					<Route
						path="detail/:paramId"
						element={<Detail fruit={fruit} />}
					/>
					<Route path="/cart" element={<Cart />} />
					<Route path="/about" element={<About />}>
						<Route path="/about/member" element={<Member />} />
						<Route path="/about/location" element={<Location />} />
					</Route>
					<Route path="/board" element={<FruitBoard />} />
					<Route path="*" element={<div>없는 페이지입니다.</div>} />
				</Routes>
			</div>
		</>
	);
}

function About() {
	return (
		<>
			<h4>회사정보</h4>
			<Outlet></Outlet>
		</>
	);
}

function Member() {
	return (
		<>
			<h4>Member</h4>
		</>
	);
}

function Location() {
	return (
		<>
			<h4>Location</h4>
		</>
	);
}

export default App;
