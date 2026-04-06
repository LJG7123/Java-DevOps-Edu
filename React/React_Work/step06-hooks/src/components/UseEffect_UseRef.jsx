import React from "react";
import { useRef } from "react";
import { useEffect } from "react";
import { useState } from "react";

function UseEffect_UseRef() {
	const [count, setCount] = useState(0);
	const renderRef = useRef(0);

	useEffect(() => {
		console.log("렌더링");
		renderRef.current += 1;
		console.log("renderRef.current = " + renderRef.current);
	});

	return (
		<>
			<p>
				Count: {count} :{" "}
				<button
					onClick={() => {
						setCount(count + 1);
					}}
				>
					UP
				</button>
			</p>
		</>
	);
}

export default UseEffect_UseRef;
