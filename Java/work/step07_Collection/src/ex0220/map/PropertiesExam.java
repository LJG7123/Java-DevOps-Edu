package ex0220.map;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	Properties prop = new Properties();
	
	public PropertiesExam() {
		prop.setProperty("id", "jang");
		prop.setProperty("age", "10");
		prop.setProperty("addr", "서울");

		for (String key : prop.stringPropertyNames()) {
			String value = prop.getProperty(key);
			
			System.out.println(key + "=" + value);
		}
		
		System.out.println("-----------------------");
//		test01();
		test02();
	}
	
	/**
	 * 외부의 .properties 파일을 로딩하는 2가지 방법
	 * 1. IO를 이용한 방법
	 * 2. ResourceBundle을 이용한 방법
	 */
	
	// 1. IO를 이용한 방법
	public void test01() {
		prop.clear();
		
		try {
			// 2. 클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//			InputStream inputStream = PropertiesExam.class
//					.getResourceAsStream("info.properties");
//			
//			prop.load(inputStream);

			// 3.클래스 위치한 패키지 내에서 파일 로딩할때 - / 생략(상대경로)
//			 InputStream inpupStream =
//			 this.getClass().getResourceAsStream("info.properties");
//			 prop.load(inpupStream);

			// 4.ClassLoader의 모든 경로에서 파일 읽음. 보통 resources 폴더의 파일 읽을때 사용.
			InputStream inpupStream =
					 this.getClass().getClassLoader().getResourceAsStream("a.properties");
//					this.getClass().getClassLoader().getResourceAsStream("ex0220/map/info.properties");
			prop.load(inpupStream);

//			prop.load(new FileInputStream("src/ex0220/map/info.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (String key : prop.stringPropertyNames()) {
			String value = prop.getProperty(key);
			
			System.out.println(key + "=" + value);
		}
	}
	
	// 2. ResourceBundle을 이용한 방법
	public void test02() {
		// ResourceBundle은 .properties 파일을 로드하는 전용 클래스
		ResourceBundle rb = ResourceBundle.getBundle("a");
		for (String key : rb.keySet()) {
			String value = rb.getString(key);
			System.out.println(key + " = " + value);
		}
	}
	
	public static void main(String[] args) {
		new PropertiesExam();
	}

}
