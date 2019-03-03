package cn.edu.bistu.sort;

/**
 * @Description: 计数排序
 * @ClassName: CountSort
 * @author Jia Zheng
 * @time 2017年8月16日  下午10:00:42
 */
public class CountSort {
	// k 为arr中数据的范围
	public static void countSort(int[] arr, int[] result, int k) {
		int[] counter = new int[k + 1];
		for (int i = 0; i < counter.length; i++) {
			counter[i] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			counter[arr[i]] ++;
		}
		for (int i = 1; i < counter.length; i++) {
			counter[i] = counter[i] + counter[i - 1];
		}
		for (int i = arr.length -1; i >= 0; i--) {
			int value = arr[i];
			int pos = counter[value] - 1;
			result[pos] = value;
			counter[value]--;
		}
	}
}
