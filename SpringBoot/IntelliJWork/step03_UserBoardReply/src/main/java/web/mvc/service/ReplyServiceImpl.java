package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.Reply;
import web.mvc.repository.ReplyRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService {

	private final ReplyRepository replyRepository;

	@Override
	public void insert(Reply reply) {
		replyRepository.save(reply);
	}

	@Override
	public void delete(Long id) {
		replyRepository.deleteById(id);
	}
}
