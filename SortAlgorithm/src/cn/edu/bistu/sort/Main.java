package cn.edu.bistu.sort;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] arr = {55,34,36,31,64,43};
//		BubbleSort.bubbleSort(arr);
//		System.out.print("BubbleSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		SelectSort.selectSort(arr);
//		System.out.print("SelectSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		InsertSort.insertSort(arr);
//		System.out.print("InsertSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		MergetSort.mergetSort(arr, 0, arr.length-1);
//		System.out.print("MergetSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		HeapSort.heapSort(arr);
//		System.out.print("HeapSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		QuickSort.quickSort(arr, 0, arr.length-1);
//		System.out.print("QuickSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		ShellSort.shellSort(arr);
//		System.out.print("ShellSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(arr[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		int [] result = new int[6];
//		CountSort.countSort(arr, result, 70);
//		System.out.print("CountSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(result[i]);
//			System.out.print(" ");
//		}

//		int [] arr = {55,34,36,31,64,43};
//		int [] result = new int[6];
//		BucketSort.bucketSort(arr, result);
//		System.out.print("BucketSort:");
//		for(int i=0; i < arr.length; i++){
//			System.out.print(result[i]);
//			System.out.print(" ");
//		}

		int [] arr = {55,34,36,31,64,43};
		int [] result = new int[6];
		RadixSort.radixSort(arr, result);
		System.out.print("RadixSort:");
		for(int i=0; i < arr.length; i++){
			System.out.print(result[i]);
			System.out.print(" ");
		}
	}

}
