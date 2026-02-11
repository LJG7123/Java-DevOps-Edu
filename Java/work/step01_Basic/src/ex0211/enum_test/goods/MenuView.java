package ex0211.enum_test.goods;
import java.util.Scanner;
/**
 키보드 입력을 받아 각 기능을 호출해줄 View
*/
public class MenuView{

 private Scanner sc = new Scanner(System.in);
 private GoodsService service; //전역변수 초기화

 	public MenuView(String[][] data) {
 		service = new GoodsService(data);
 	}
  /**
    전체 메뉴를 출력하는 메소드 
  */
  public void printMenu(){

	  while(true){
         System.out.println("----------------------------------------------------------------------------");
		 System.out.println("1.등록    2.전체검색    3.상품코드검색    4.수정하기    5.삭제하기    9.종료");
		 System.out.println("----------------------------------------------------------------------------");

         System.out.print("메뉴 선택 > ");
		 int menuChoice = Integer.parseInt( sc.nextLine());

		 switch(menuChoice){
             case 1 : 
				 this.inputInsert(); break;
			 case 2 : 
				 this.inputSelectAll(); break;
			 case 3 : 
				 this.inputSelectByCode(); break;
			 case 4 : 
				 this.inputUpdate(); break;
			 case 5 :
				 inputDelete();	break;
			 case 9 : 
				 System.out.println("다음에 또 이용해ㅜㅈ세요. 프로그램 종료합니다.");
				 System.exit(0); 
			 break;
			 default: System.out.println("메뉴는 1~4 or 9 만 입력해주세요.");

		 }//switch문

	  }//while문

  } //printMenu끝

  /**
     등록관련 키보드 입력
  */
  	public void inputInsert(){
		// 키보드입력 4개 받기
		System.out.print("상품코드 > ");
		String code = sc.nextLine();

		System.out.print("상품이름 > ");
		String name = sc.nextLine();

		System.out.print("상품가격 > ");
		int price = Integer.parseInt(sc.nextLine());

		System.out.print("상품설명 > ");
		String explain = sc.nextLine();

		// 생성자를 추가하여 값을 전달하자(데이터 초기화)
		Goods goods = new Goods(code, name, price, explain);

		InsertResult result = service.insert(goods);

		/*
		 * if(result==InsertResult.INSERT_OUTINDEX)
		 * EndView.printMessage("더이상 등록할 수 없습니다."); else
		 * if(result==InsertResult.INSERT_DUPLICATE)
		 * EndView.printMessage(code+"는 중복이므로 등록할수 없습니다."); else
		 * EndView.printMessage("상품이 등록되었습니다.");
		 */

		switch (result) {
		case INSERT_DUPLICATE:
			EndView.printMessage("더이상 등록할 수 없습니다.");
			break;
		case INSERT_OUTINDEX:
			EndView.printMessage(code + "는 중복이므로 등록할 수 없습니다.");
			break;
		case INSERT_SUCCESS:
			EndView.printMessage("상품이 등록되었습니다.");
			break;
		}
  }
  
  public void inputSelectAll() {
	  Goods [] goodsArr = service.selectAll(); 
	  EndView.printSelectAll(goodsArr);
  }

  /**
    상품코드 검색 키보드 입력
  */
  public void inputSelectByCode(){
       System.out.print("검색하려는 상품코드 > ");
	   String code = sc.nextLine();

	  Goods goods = service.selectByCode( code );
	  if(goods==null){
          EndView.printMessage(code+"는 잘못되어 검색할수 없습니다.");
	  }else{
          EndView.printSelectByCode(goods);
	  }
  }

  /**
    수정하기 키보드 입력 
  */
  public void inputUpdate(){
       //키보드입력 4개 받기 
	   System.out.print("수정하려는 상품코드 > ");
	   String code = sc.nextLine();

	   System.out.print("변경 상품가격 > ");
	   int price = Integer.parseInt(sc.nextLine());

	   System.out.print("변경 상품설명 > ");
	   String explain = sc.nextLine();

	   //위 3개의 정보를 하나의 Goods객체로 만든다.
	   Goods updated = new Goods(code, price, explain);

	   if(service.update(updated) ){
          EndView.printMessage("상품이 수정되었습니다.");
	   }else{
          EndView.printMessage("상품이 수정되지않았습니다.");
	   }


  }//메소드끝
  
  public void inputDelete() {
	  System.out.print("삭제하려는 상품코드 > ");
	  String code = sc.nextLine();
	  
	  boolean response = service.delete(code);
	  
	  if (response) {
		  System.out.println(code + "상품이 삭제되었습니다.");
	  } else {
		  System.out.println("삭제 실패하였습니다.");
	  }
  }



}//클래스끝