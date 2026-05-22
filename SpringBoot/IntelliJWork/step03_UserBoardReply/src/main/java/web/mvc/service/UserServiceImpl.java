package web.mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.mvc.domain.User;
import web.mvc.exception.BasicException;
import web.mvc.exception.ErrorCode;
import web.mvc.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	@Override
	public User loginCheck(User user) {
		User found = userRepository.findById(user.getUserId())
				.orElseThrow(() -> new BasicException(ErrorCode.NOTFOUND_ID));

		if (!user.getPwd().equals(found.getPwd())) {
			throw new BasicException(ErrorCode.WRONG_PASS);
		}

		return found;
	}
}
