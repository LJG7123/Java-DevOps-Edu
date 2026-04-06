import { useMemo, useState } from "react";

function Ex03_Memo() {
	const [list, setList] = useState([1, 2, 3, 4, 5]);
	const [str, setStr] = useState("합계");

	const getSumResult = () => {
		console.log("getSumResult called..");
		let sum = 0;
		list.forEach((no) => {
			sum += no;
		});
	};

	const memoRes = useMemo(() => {
		console.log("useMemo called..");
		let sum = 0;
		list.forEach((no) => {
			sum += no;
		});

		return sum;
	}, [list]);

	return (
		<>
			<h3>useMemo Test</h3>
			{list.map((no, i) => (
				<h5 key={i}>{no}</h5>
			))}
			{/* <h3>
				{str}: {getSumResult()}
			</h3> */}
			<h3>
				{str}: {memoRes}
			</h3>
			<button onClick={() => setList([10, ...list])}>추가</button>
			<button onClick={() => setStr("총계")}>str 값변경</button>
		</>
	);
}

export default Ex03_Memo;
