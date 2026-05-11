package kosta.test;

public class VideoImpl implements Player {

	@Override
	public void start(int volume) {
		System.out.println("VideoImpl start() 호출");
	}

	@Override
	public String pause() {
		System.out.println("VideoImpl pause() 호출");
		return "VideoImpl 리턴값";
	}

	@Override
	public void stop() {
		System.out.println("VideoImpl stop() 호출");
	}

}
