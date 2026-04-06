import React from "react";
import { useEffect } from "react";
import { useState } from "react";

function UseEffect_UseState() {
	const [count, setCount] = useState(0);
	const [renderCount, setRenderCount] = useState(1);

	useEffect(() => {
		console.log("렌더링");
		setRenderCount(renderCount + 1);
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

export default UseEffect_UseState;
