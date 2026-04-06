import { useRef } from "react";
import { useState } from "react";

let letCount = 0;

function Ex06_Ref() {
	// 값이 변경될 때마다 re-rendering 된다.
	const [count, setCount] = useState(0);
	// 값이 변경되어도 re-rendering이 되지 않는다.
	const countRef = useRef(0);

	console.log("Ex06_Ref() callled.. letCount: " + letCount);

	return (
		<div>
			<h2>useState vs useRef vs let 차이</h2>
			<p>
				useState: {count}
				<button onClick={() => setCount(count + 1)}>state up</button>
			</p>
			<hr />
			<p>
				useRef: {countRef.current}
				<button onClick={() => (countRef.current += 1)}>ref up</button>
			</p>
			<hr />
			<p>
				letCount: {letCount}
				<button onClick={() => (letCount += 1)}>let up</button>
			</p>
		</div>
	);
}

export default Ex06_Ref;
