package ex0212.final_abstract;
//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{ // 상속불가, 생성가능
	final int i = -999999; // 반드시 초기화, 값 변경 불가
}


abstract class AbstractClassExam{ // 상속가능, 생성불가
    abstract String abstractMethodExam(int i,String s); // 재정의 위한 메소드   
    final int finalMethodExam(int i, int j){ // 재정의 불가
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	/*int finalMethodExam(int i, int j){ // 부모 클래스에서 해당 메소드에 final 키워드가 있기 때문에 재정의 불가
		return i*j;
	}*/
	
}

//class Sample02 extends FinalClassExam{  } // final class 이기 때문에 상속 불가


 
 class Sample03 extends AbstractClassExam{
	 String abstractMethodExam(int i,String s){
		return s+i;
	 }
	 // 상속받는 클래스가 추상 클래스가 아니기 때문에 abstract 메소드가 존재할 수 없음
	//abstract String abstractMethodExam(int i,String s);    

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
    	// 추상 클래스는 인스턴스 생성 불가
		//AbstractClassExam ace = new AbstractClassExam(); 
		FinalClassExam fce = new FinalClassExam();
		// i 는 final 필드이기 때문에 값 변경 불가
		//fce.i=100000;
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		// acsS01은 추상 클래스 타입으로 선언했지만, 실제론 Sample01 타입이기 때문에 재정의한 메소드를 사용 가능
		aceS01.abstractMethodExam(700,"_999");
	}
}
