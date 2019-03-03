package cn.edu.bistu.sort;

/**
 * @Description: 希尔排序
 * @ClassName: ShellSort
 * @author Jia Zheng
 * @time 2017年8月22日 下午11:23:28
 */
public class ShellSort {
	public static void shellSort(int[] arr) {
		int gap = arr.length / 2;
		while (gap > 0) {
			for (int i = gap; i < arr.length; i++) {
				int temp = arr[i];
				int j;
				for (j = i - gap; j >= 0 && temp < arr[j]; j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
			gap /= 2;
		}
	}
}
