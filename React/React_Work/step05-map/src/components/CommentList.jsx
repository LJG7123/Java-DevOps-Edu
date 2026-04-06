import Comment from "./Comment";

function CommentList() {
	const comments = [
		{
			name: "장희정",
			comment: "안녕하세요, Best Programmer입니다.",
		},
		{
			name: "이가현",
			comment: "리액트 재미있어요~!",
		},
		{
			name: "이찬범",
			comment: "저도 리액트 배워보고 싶어요!!",
		},
	];
	return (
		<>
			{comments.map((comment) => (
				<Comment {...comment}></Comment>
			))}
		</>
	);
}

export default CommentList;
