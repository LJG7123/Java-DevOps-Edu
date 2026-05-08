import React, { useState } from "react";
import LabelText from "../../components/LabelText";

function JoinForm() {
	const [idCheckResult, setIdCheckResult] = useState("");
	const [isCheckResult, setIsCheckResult] = useState(false);
	const changeValue = (e) => {};

	const submitJoin = (e) => {};

	return (
		<>
			<h1 className="h1">회원가입</h1>
			<div className="idDuplicate">
				<LabelText
					text={"아이디"}
					name={"id"}
					changeValue={changeValue}
				/>
				<div
					className="idText"
					style={isCheckResult ? { color: "red" } : { color: "blue" }}
				>
					{idCheckResult}
				</div>
			</div>

			<LabelText text={"이름"} name={"name"} changeValue={changeValue} />
			<LabelText
				text={"비밀번호"}
				name={"pwd"}
				changeValue={changeValue}
			/>
			<LabelText
				text={"주소"}
				name={"address"}
				changeValue={changeValue}
			/>
		</>
	);
}

export default JoinForm;
