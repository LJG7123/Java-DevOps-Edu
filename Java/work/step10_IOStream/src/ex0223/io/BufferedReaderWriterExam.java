package ex0223.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BufferedReaderWriterExam {

	public BufferedReaderWriterExam() {
		try (BufferedReader br = new BufferedReader(new FileReader("src/ex0223/io/test.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0223/io/test2.txt"))) {
			// 한 문자 읽기
			/*int i = 0;
			while ((i = br.read()) != -1) {
				System.out.print((char) i);
			}*/
			
			// 한 줄 읽기
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new BufferedReaderWriterExam();
	}

}
