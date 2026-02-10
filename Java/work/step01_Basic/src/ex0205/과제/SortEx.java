package ex0205.과제;

import java.util.Arrays;
/**
 * 주제: 정수 배열을 3가지 정렬 알고리즘을 통해 정렬하여 출력
 * 작성일: 260205
 * 작성자: 이정건
 *  
 * */
public class SortEx {

	public static void main(String[] args) {
		int arr[] = {5, 7, 1, 2, 4, 3, 8, 9, 6, 10};
		int selectionSorted[] = selectionSort(arr);
		int bubbleSorted[] = bubbleSort(arr);
		int insertionSorted[] = insertionSort(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(selectionSorted));
		System.out.println(Arrays.toString(bubbleSorted));
		System.out.println(Arrays.toString(insertionSorted));
	}
	
	public static int[] selectionSort(int[] arr) {
		int sorted[] = arr.clone();
		int n = sorted.length;
		
		for (int i = 0; i < n; i++) {
			int mini = i;
			
			for (int j = i; j < n; j++) {
				if (sorted[j] < sorted[mini]) mini = j;
			}
			
			int tmp = sorted[i];
			sorted[i] = sorted[mini];
			sorted[mini] = tmp;
		}
		
		return sorted;
	}

	public static int[] bubbleSort(int[] arr) {
		int sorted[] = arr.clone();
		int n = sorted.length;
		
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (sorted[j] > sorted[j + 1]) {
					int tmp = sorted[j];
					sorted[j] = sorted[j + 1];
					sorted[j + 1] = tmp;
				}
			}
		}
		
		return sorted;
	}
	
	public static int[] insertionSort(int[] arr) {
		int sorted[] = arr.clone();
		int n = sorted.length;
		
		for (int i = 1; i < n; i++) {
			int num = sorted[i];
			int j;
			
			for (j = i - 1; j >= 0; j--) {
				if (sorted[j] > num) {
					sorted[j + 1] = sorted[j];
				} else {
					break;
				}
			}
			sorted[j + 1] = num;
		}
		
		return sorted;
	}
}
