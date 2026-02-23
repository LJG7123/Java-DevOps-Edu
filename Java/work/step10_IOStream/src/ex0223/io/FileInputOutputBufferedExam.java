package ex0223.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputBufferedExam {

	public FileInputOutputBufferedExam() { // IO는 반드시 사용 후 close() 해야한다
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		// byte 단위 파일 읽기 (InputStream -> FileInputStream -> BufferedInputStream)
		try {
			fis = new FileInputStream("src/ex0223/io/test.txt");
			bis = new BufferedInputStream(fis);
			
			int len = bis.available();
			System.out.println("len = " + len);
			
			byte[] b = new byte[1024];
			int re = 0;
			
			while ((re = bis.read(b)) != -1) {
				System.out.println("re = " + re);
				
				String data = new String(b);
				System.out.println("data = " + data);
			}
			
			// 파일에 저장 (출력)
			fos = new FileOutputStream("src/ex0223/io/write.txt", true);
			bos = new BufferedOutputStream(fos);
			
			bos.write(65);
			
			bos.write(13);
			bos.write(10);
			
			String str = "배고프다 뭐먹지?";
			bos.write(str.getBytes());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
				if (bos != null) bos.close();
				if (fis != null) fis.close();
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FileInputOutputBufferedExam();
	}

}
