package cn.edu.bistu.sort;

/**
 * @Description: 堆排序
 * @ClassName: HeapSort
 * @author Jia Zheng
 * @time 2017年8月22日 上午9:14:07
 */
public class HeapSort {
	public static void heapSort(int[] arr) {
		int n = arr.length;
		buildMaxHeap(arr, n);
		for (int i = arr.length - 1; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[0];
			arr[0] = temp;
			maxHeapify(arr, 0, i);
		}
	}

	public static void buildMaxHeap(int[] arr, int n) {
		for (int i = (int) n/2; i >= 0; i--) {
			maxHeapify(arr, i, arr.length);
		}
	}

	public static void maxHeapify(int[] arr, int i, int n) {
		int lchild = 2 * i + 1;
		int rchild = lchild + 1;
		int largest = i;
		if (lchild < n && arr[lchild] > arr[i]) {
			largest = lchild;
		}
		if (rchild < n && arr[rchild] > arr[largest]) {
			largest = rchild;
		}
		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			maxHeapify(arr, largest, n);
		}
	}
}
