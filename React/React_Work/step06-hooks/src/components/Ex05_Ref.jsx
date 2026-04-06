import { useRef } from "react";
import { useState } from "react";

function Ex05_Ref() {
	console.log("Ex05_Ref() callled..");

	// 값이 변경될 때마다 re-rendering 된다.
	const [count, setCount] = useState(0);
	// 값이 변경되어도 re-rendering이 되지 않는다.
	const countRef = useRef(0);

	return (
		<div>
			<h2>useState vs useRef 차이</h2>
			<p>
				useState: {count}
				<button onClick={() => setCount(count + 1)}>state up</button>
			</p>
			<hr />
			<p>
				useRef: {countRef.current}
				<button onClick={() => (countRef.current += 1)}>ref up</button>
			</p>
		</div>
	);
}

export default Ex05_Ref;
