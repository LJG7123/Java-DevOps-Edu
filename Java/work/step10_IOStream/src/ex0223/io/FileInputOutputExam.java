package ex0223.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {

	public FileInputOutputExam() { // IO는 반드시 사용 후 close() 해야한다
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		// byte 단위 파일 읽기 (InputStream -> FileInputStream)
		try {
			fis = new FileInputStream("src/ex0223/io/test.txt");
			
			/*while (true) {
				int i = fis.read();
				if (i == -1) break;
				System.out.println(i + " = " + (char) i);
			}*/
			
			int len = fis.available();
			System.out.println("len = " + len);
			
			byte[] b = new byte[1024];
			int re = 0;
			
			while ((re = fis.read(b)) != -1) {
				System.out.println("re = " + re);
				
				String data = new String(b);
				System.out.println("data = " + data);
			}
			
			// 파일에 저장 (출력)
			fos = new FileOutputStream("src/ex0223/io/write.txt", true);
			fos.write(65);
			
			fos.write(13);
			fos.write(10);
			
			String str = "배고프다 뭐먹지?";
			fos.write(str.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileInputOutputExam();
	}

}
