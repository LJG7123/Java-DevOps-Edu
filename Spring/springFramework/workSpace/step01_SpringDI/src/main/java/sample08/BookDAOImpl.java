package sample08;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository // 생성 <bean class="BookDAOImpl" id="bookDAOImpl" /> 
@RequiredArgsConstructor
public class BookDAOImpl implements BookDAO {
    
	private final DbUtil dbUtil; // 주입
	
	@Autowired
	private List<BookDTO> list; // BookDTO정보를 db처럼 사용하기 위한 collection
    
	@PostConstruct
	public void init() {
		System.out.println(list);
	}
	
	@Override
	public void save(EmailSender emailSender, MessageSender messageSender, BookDTO book1, BookDTO book2) {
		System.out.println(emailSender);
		System.out.println(messageSender);
		System.out.println(book1);
		System.out.println(book2);
		System.out.println(dbUtil);

	}

}
