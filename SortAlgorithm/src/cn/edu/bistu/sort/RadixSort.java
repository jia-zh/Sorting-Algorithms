package cn.edu.bistu.sort;

/**
 * @Description: 基数排序
 * @ClassName: RadixSort
 * @author Jia Zheng
 * @time 2017年8月22日 下午7:36:20
 */
public class RadixSort {
	//获取最大数位
	public static int getMaxDigit(int arr[]) {
		int digit = 0;
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max = arr[i];
		}
		int temp = 1;
		while (max / temp !=0) {
			digit ++;
			temp *= 10;
		}
		return (int) Math.pow(10, digit);
	}

	public static void radixSort(int arr[], int result[]) {
		int digit = getMaxDigit(arr);
		int digitPos = 1; //当前排序的数位
		int bucketNum = 10; //桶的个数
		int bucket[][] = new int[bucketNum][arr.length];
		int bucketCount[] = new int[bucketNum];
		while (digitPos < digit) {
			//将每个数据放置到相应的桶中
			for(int num : arr){
				int digitNum = (num / digitPos) % 10;
				bucket[digitNum][bucketCount[digitNum]] = num;
				bucketCount[digitNum] ++;
			}
			//将桶中排序的数据放回至源数组中
			int k = 0;
			for (int i = 0; i < bucketNum; i++) {
				if(bucketCount[i] != 0){
					for (int j = 0; j < bucketCount[i]; j++) {
						arr[k] = bucket[i][j];
						k ++;
					}
				}
				bucketCount[i] = 0;
			}
			digitPos *= 10;
		}
		for (int i = 0; i < arr.length; i++) {
			result[i] = arr[i];
		}
	}
}
