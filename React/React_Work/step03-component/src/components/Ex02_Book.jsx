/*export default function Ex02_Book(props) {
	console.log(props);
	return (
		<>
			<h2>이 책은 {props.title} 책입니다.</h2>
			<h3>이 책의 총 페이지 수는 {props.page} 페이지로 이뤄져 있습니다.</h3>
		</>
	);
}*/

export default function Ex02_Book({ title = "Java", page, author }) {
	return (
		<>
			<h2>이 책은 {title} 책입니다.</h2>
			<h3>이 책의 총 페이지 수는 {page} 페이지로 이뤄져 있습니다.</h3>
			<h4>
				지은이: {author.name} / {author.age} / {author.addr}
			</h4>
		</>
	);
}
