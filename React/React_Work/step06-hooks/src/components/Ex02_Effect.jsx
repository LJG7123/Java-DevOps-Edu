import React from "react";
import Ex02_Timer from "./Ex02_Timer";
import { useState } from "react";

function Ex02_Effect() {
	const [showTimer, setShowTimer] = useState(false);
	return (
		<>
			<h3>useEffect의 cleanup 기능</h3>
			{showTimer && <Ex02_Timer />}
			<button
				onClick={() => {
					setShowTimer(!showTimer);
				}}
			>
				Toggle Timer
			</button>
		</>
	);
}

export default Ex02_Effect;
