package cn.edu.bistu.sort;

/**
 * @Description: 快速排序
 * @ClassName: QuickSort
 * @author Jia Zheng
 * @time 2017年8月22日 下午12:53:05
 */
public class QuickSort {
	public static void quickSort(int[] arr, int begin, int end) {
		if(begin > end)
			return;
		int x = arr[begin];
		int i = begin;
		int j = end;
		while (i != j) {
			while (i < j && arr[j] >= x) {
				j--;
			}
			while (i < j && arr[i] <= x) {
				i++;
			}
			if (i < j){
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		arr[begin] = arr[i];
		arr[i] = x;

		quickSort(arr, begin, i - 1);
		quickSort(arr, i + 1, end);
	}
}
