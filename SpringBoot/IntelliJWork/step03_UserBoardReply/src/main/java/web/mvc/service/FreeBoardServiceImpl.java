package web.mvc.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import web.mvc.domain.FreeBoard;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.FreeBoardRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class FreeBoardServiceImpl implements FreeBoardService {

	private final FreeBoardRepository freeBoardRepository;

	@Override
	public List<FreeBoard> selectAll() {
		return freeBoardRepository.findAll();
	}

	@Override
	public Page<FreeBoard> selectAll(Pageable pageable) {
		return freeBoardRepository.findAll(pageable);
	}

	@Override
	public void insert(FreeBoard board) {
		freeBoardRepository.save(board);
	}

	@Override
	public FreeBoard selectBy(Long bno, boolean state) {
		FreeBoard board = freeBoardRepository.findById(bno)
				.orElseThrow(() -> new BasicException(ErrorCode.FAILED_DETAIL));
		if (state) board.setReadnum(board.getReadnum() + 1);

		return board;
	}

	@Override
	public FreeBoard update(FreeBoard board) {
		FreeBoard found = freeBoardRepository.findById(board.getBno()).orElseThrow(() -> new BasicException(ErrorCode.FAILED_UPDATE));

		if (!board.getPassword().equals(found.getPassword())) {
			throw new BasicException(ErrorCode.FAILED_UPDATE);
		}

		found.setSubject(board.getSubject());
		found.setContent(board.getContent());

		return found;
	}

	@Override
	public void delete(Long bno, String password) {
		FreeBoard board = freeBoardRepository.findById(bno).orElseThrow(() -> new BasicException(ErrorCode.FAILED_DELETE));

		if (!password.equals(board.getPassword())) throw new BasicException(ErrorCode.FAILED_DELETE);

		freeBoardRepository.delete(board);
	}
}
