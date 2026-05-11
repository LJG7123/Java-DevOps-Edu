package kosta.test;

import org.springframework.stereotype.Service;

@Service
public class AudioImpl implements Player {

	@Override
	public void start(int volume) {
		System.out.println("AudioImpl start() 호출");
	}

	@Override
	public String pause() {
		System.out.println("AudioImpl pause() 호출");
		return "AudioImpl 리턴값";
	}
	
	@Override
	public void stop() {
		System.out.println("AudioImpl stop() 호출");
	}

}
