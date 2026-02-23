package ex0223.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

public class FileCopyExam {

	public FileCopyExam(String readFile, String writeFile) {
		long start = System.nanoTime();
		
		FileInputStream bis = null;
		FileOutputStream bos = null;
		
		// readFile에 있는 내용을 읽어서 writeFile에 저장한다. (Buffered 사용)
		try {
			bis = new FileInputStream(readFile);
			bos = new FileOutputStream(writeFile);
			
			byte[] b = new byte[1024];
			
			while (bis.read(b) != -1) {
				bos.write(b);
			}
			
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null) bis.close();
				if (bos != null) bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		long end = System.nanoTime();
		
		System.out.println((end - start) + "ns");
	}
	
	public static void main(String[] args) {
		String readFile = JOptionPane.showInputDialog("읽을 파일명?");
		String writeFile = JOptionPane.showInputDialog("저장할 파일명?");
		
		new FileCopyExam(readFile, writeFile);
	}

}
