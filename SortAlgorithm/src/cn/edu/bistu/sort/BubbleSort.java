package cn.edu.bistu.sort;

/**
 * @Description:冒泡排序
 * @ClassName: BubbleSort
 * @author Jia Zheng
 * @time 2017年6月13日 下午12:19:56
 */
public class BubbleSort {
	public static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
//	public static void bubbleSort(int[] arr) {
//		Boolean mark = false;
//		for (int i = 0; i < arr.length; i++) {
//			mark = false;
//			for (int j = arr.length -1;j > i;j--){
//				if (arr[j] < arr[j-1]){
//					int temp = arr[j];
//					arr[j] = arr[j-1];
//					arr[j-1] = temp;
//					mark = true;
//				}
//			}
//			if (!mark)
//				break;
//		}
//	}
}
