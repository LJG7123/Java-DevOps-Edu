import { useEffect } from "react";
import axiosInstance from "./api/axiosInstance";
import "./App.css";

function App02() {
	useEffect(() => {
		// axios
		// 	.get("http://localhost:4000/posts/2")
		// 	.then((res) => console.log(res.data));
		// axios.post("http://localhost:4000/posts", {
		// 	title: "Post Test",
		// });
	}, []);

	// axiosInstance 사용해보기
	const selectAll = async () => {
		try {
			const result = await axiosInstance.get("users");
			result.data.forEach((user, index) => {
				console.log(
					`${index} = ${user.id} | ${user.name} | ${user.email}`,
				);
			});
		} catch (e) {
			console.log(e);
		}
	};

	const selectById = async () => {
		try {
			const result = await axiosInstance({
				url: "users/5",
				method: "GET",
			});
			console.log(result.data);
		} catch (e) {
			console.log(e);
		}
	};

	const insertUser = async () => {
		try {
			const result = await axiosInstance.post("users", {
				name: "new user",
				email: "new@test.com",
				age: 20,
			});
			console.log(result.data);
		} catch (e) {
			console.log(e);
		}
	};

	const deleteUser = async () => {
		try {
			const result = await axiosInstance.delete("users/2");
			console.log(result);
		} catch (e) {
			console.log(e);
		}
	};

	const updateUser = async () => {
		try {
			const result = await axiosInstance.put("users/2", {
				name: "새이름",
				age: 22,
				addr: "new addr",
			});
			console.log(result.data);
		} catch (e) {
			console.log(e);
		}
	};

	const getById = async () => {
		try {
			const result = await axiosInstance.get("users/1");
			console.log(result.data);
		} catch (e) {
			console.log(e);
		}
	};

	const getUsers = async () => {
		try {
			const result = await axiosInstance.get("users");
			console.log(result.data);
		} catch (e) {
			console.log(e);
		}
	};

	return (
		<>
			<h1>Axios Test</h1>
			<button onClick={selectAll}>get - selectAll</button>
			<button onClick={selectById}>get - selectById</button>
			<h3> json-server 연동하기(CRUD)</h3>
			<button onClick={insertUser}>post - user등록</button>
			<button onClick={deleteUser}>delete - user삭제</button>
			<button onClick={updateUser}>put - user수정</button>
			<button onClick={getById}>get - user 부분조회 </button>
			<button onClick={getUsers}>get - user전체조회</button>
		</>
	);
}

export default App02;
