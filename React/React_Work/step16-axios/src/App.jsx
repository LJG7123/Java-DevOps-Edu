import "./App.css";
import axios from "axios";

const serverIp = import.meta.env.VITE_API_SERVER_IP;

function App() {
	console.log(serverIp);

	const fetchAll = async () => {
		try {
			const result = await fetch(serverIp + "/users");
			const json = await result.json();

			json.forEach((user, index) => {
				console.log(
					index +
						" = " +
						user.id +
						" | " +
						user.name +
						" | " +
						user.email,
				);
			});
		} catch (e) {
			console.log(e);
		}
	};

	const selectAll = async () => {
		/*axios
			.get(serverIp)
			.then((result) => {
				console.log(result.data);
				result.data.forEach((user, index) => {
					console.log(
						index +
							" = " +
							user.id +
							" | " +
							user.name +
							" | " +
							user.email,
					);
				});
			})
			.catch((e) => console.log(e));*/
		try {
			const result = await axios.get(serverIp + "/users");
			result.data.forEach((user, index) => {
				console.log(
					index +
						" = " +
						user.id +
						" | " +
						user.name +
						" | " +
						user.email,
				);
			});
		} catch (e) {
			console.log(e);
		}
	};

	const selectById = async () => {
		// axios({
		// 	url: serverIp + "/5",
		// 	method: "get",
		// })
		// 	.then((re) => {
		// 		console.log(re.data);
		// 	})
		// 	.catch((e) => console.log(e));

		try {
			const re = await axios({
				url: serverIp + "/users/5",
				method: "GET",
			});
			console.log(re.data);
		} catch (e) {
			console.log(e);
		}
	};

	return (
		<>
			<h1>fetch Test</h1>
			<button onClick={fetchAll}>get - selectAll</button>

			<h1>Axios Test</h1>
			<button onClick={selectAll}>get - selectAll</button>
			<button onClick={selectById}>get - selectById</button>

			<h3> json-server 연동하기(CRUD)</h3>
			{/* <button onClick={insertUser}>post - user등록</button>
			<button onClick={deleteUser}>delete - user삭제</button>
			<button onClick={updateUser}>put - user수정</button>
			<button onClick={getbyId}>get - user 부분조회 </button>
			<button onClick={getUsers}>get - user전체조회</button> */}
		</>
	);
}

export default App;
