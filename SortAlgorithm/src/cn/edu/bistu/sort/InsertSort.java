package cn.edu.bistu.sort;

/**
 * @Description:插入排序
 * @ClassName: InsertSort
 * @author Jia Zheng
 * @time 2017年6月13日 下午12:54:39
 */
public class InsertSort {
	public static void insertSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int target = arr[i];
			int j = i;
			while (j > 0 && arr[j-1] > target) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = target;
		}
	}
}
