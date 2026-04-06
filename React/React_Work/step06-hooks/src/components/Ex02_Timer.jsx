import React, { useEffect } from "react";

function Ex02_Timer() {
	// 마운트가 되었을 때 1초마다 콘솔에 출력
	useEffect(() => {
		const timer = setInterval(() => {
			console.log("타이머 작동중..");
		}, 1000);

		return () => {
			console.log("자원 정리");
			clearInterval(timer);
		};
	});

	return (
		<>
			<span>타이머를 시작합니다. 콘솔을 확인해 주세요.</span>
		</>
	);
}

export default Ex02_Timer;
