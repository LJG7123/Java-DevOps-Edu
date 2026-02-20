package ex0220.map;

import java.util.Map;
import java.util.TreeMap;

public class MapExam {
//	Map<Integer, String> map = new HashMap<Integer, String>();
	Map<Integer, String> map = new TreeMap<Integer, String>();
	
	public MapExam() {
		// map에 추가
		map.put(20, "희정");
		map.put(10, "나영");
		map.put(40, "미미");
		map.put(20, "효리");
		map.put(10, "상순");
		
		System.out.println("저장된 개수 = " + map.size());
		System.out.println(map);
		
//		Set<Integer> keys = map.keySet();
//		Iterator<Integer> iter = keys.iterator();
//		
//		while (iter.hasNext()) {
//			int key = iter.next();
//			String value = map.get(key);
//			System.out.println(key + " = " + value);
//		}
		
		for (var entry : map.entrySet()) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
		
		map.remove(20);
		System.out.println(map);
	}
	
	public static void main(String[] args) {
		new MapExam();
	}
}
