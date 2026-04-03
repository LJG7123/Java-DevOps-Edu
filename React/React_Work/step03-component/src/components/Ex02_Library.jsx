import Ex02_Book from "./Ex02_Book";

export default function Ex02_Library() {
	const author = { name: "hee", age: 30, addr: "서울" };

	return (
		<>
			<Ex02_Book title="Spring" page={200} author={author} />
			<Ex02_Book
				title="HTML"
				page={150}
				author={{ name: "lee", age: 22, addr: "대구" }}
			/>
			<Ex02_Book page={300} author={author} />
		</>
	);
}
