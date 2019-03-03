package cn.edu.bistu.sort;

/**
 * @Description: 归并排序
 * @ClassName: MergetSort
 * @author Jia Zheng
 * @time 2017年8月16日 上午12:03:51
 */
public class MergetSort {
	public static void mergetSort(int[] arr, int begin, int end) {
		if(begin < end){
			int mid = (begin + end)/2;
			mergetSort(arr, begin, mid);
			mergetSort(arr, mid+1, end);
			merge(arr, begin, mid, end);
		}
	}

	public static void merge(int[] arr, int begin, int mid, int end) {
		int nLeft = mid - begin + 1;
		int nRight = end - mid;
		int[] arrLeft = new int[nLeft + 1];
		int[] arrRight = new int[nRight + 1];
		for (int i = 0; i < nLeft; i++) {
			arrLeft[i] = arr[begin + i];
		}
		for (int i = 0; i < nRight; i++) {
			arrRight[i] = arr[mid + i + 1];
		}
		arrLeft[nLeft] = Integer.MAX_VALUE;
		arrRight[nRight] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = begin; k <= end;k++){
			if(arrLeft[i] < arrRight[j]){
				arr[k] = arrLeft[i];
				i++;
			}
			else{
				arr[k] = arrRight[j];
				j++;
			}
		}
	}
}
