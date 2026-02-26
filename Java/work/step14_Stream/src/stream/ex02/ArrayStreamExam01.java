package stream.ex02;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String[] args) {
		System.out.println("1.String Array Stream ------------");
		String [] strArr = {"희정","현준","정화","민지","경찬"};
		/*for(String s:strArr) { //자료구조의 Iterator를 이용한 방식
			System.out.println(s);
		}*/
		
		//Stream을 이용해서  출력해보자
		 //1) 람다식
		Stream<String> stream1 = Arrays.stream(strArr);
		stream1.forEach((s) -> System.out.println(s));
		System.out.println("------------------");
		//2) 메소드 참조
		Stream<String> stream2 = Stream.of(strArr);
		stream2.forEach(System.out::println);
		//3) 한번 사용한 Stream을 다시 사용해보자(사용불가x)
//		stream1.forEach(System.out::println);
		
		System.out.println("2.int Array Stream ------------");
		int [] intArr = {1,2,3,4,5,6,7,8,9};
		Arrays.stream(intArr)
			.filter(i -> i % 2 == 0)
			.forEach(System.out::println);
		
		System.out.println("3.range()  vs rangeClosed() ------------");
		System.out.println(IntStream.range(0, 10).sum());
		System.out.println(IntStream.rangeClosed(0, 10).sum());
		
	}

}






