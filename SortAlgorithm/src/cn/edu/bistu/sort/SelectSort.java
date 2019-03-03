package cn.edu.bistu.sort;

/**
 * @Description:选择排序
 * @ClassName: SelectSort
 * @author Jia Zheng
 * @time 2017年6月13日 下午12:32:29
 */
public class SelectSort {
	public static void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			if (minIndex !=i){
				int temp = arr[minIndex];
				arr[minIndex] = arr[i];
				arr[i] = temp;
			}
		}
	}
}
