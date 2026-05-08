import { Link } from "react-router-dom";
import "./BoardItem.css";

function BoardItem({ title, writer }) {
	return (
		<div className="BoardItem">
			<div className="title_writer">
				제목: {title} / 작성자: {writer}
			</div>
			<div className="detailLink">
				<Link to={"/board/1"}>상세보기</Link>
			</div>
		</div>
	);
}

export default BoardItem;
