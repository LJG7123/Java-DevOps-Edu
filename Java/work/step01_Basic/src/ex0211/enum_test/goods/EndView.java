package ex0211.enum_test.goods;
/**
  요청 결과를 출력할 view
*/
public class EndView{
   /**
     성공여부 메시지를 출력하는 메소드 
   */
   public static void printMessage(String message){
      System.out.println(message+"\n");
   }

   /**
     전체검색 결과를 출력하는 메소드
   */
   public static void printSelectAll(Goods [] arr){//service에 있는 주소가 전달되었다.
	   for (int i = 0 ; i < GoodsService.count; i++) {
		   Goods g = arr[i];
		   System.out.printf("%s | %s | %d | %s\n", g.getCode(), g.getName(), g.getPrice(), g.getExplain());
	   }
	   System.out.println();
   }

   /**
     상품코드에 해당하는 상세정보 출력하는 메소드 
   */
   public static void printSelectByCode(Goods goods){
	   System.out.println("*****" + goods.getCode() + "의 상세보기*****");
	   System.out.printf("%s | %d | %s\n", goods.getName(), goods.getPrice(), goods.getExplain());
   }


}