# Sorting Algorithms

查找和排序算法是算法的入门知识，其经典思想可以用于很多算法当中。因为其实现代码较短，应用较常见，所以在面试中经常会问到排序算法及其相关的问题。但万变不离其宗，只要熟悉了思想，灵活运用也不是难事。**一般在面试中最常考的是快速排序和归并排序**，并且经常有面试官要求现场写出这两种排序的代码，对这两种排序的代码一定要信手拈来才行。还有**插入排序、冒泡排序、堆排序、基数排序、桶排序**等，面试官对于这些排序可能会要求比较各自的优劣、各种算法的思想及其使用场景，并分析算法的时间和空间复杂度。通常查找和排序算法的考察是面试的开始，如果这些问题回答不好，估计面试官都没有继续面试下去的兴趣都没了，所以想开个好头就要把常见的排序算法思想及其特点要熟练掌握，有必要时要熟练写出代码。
  
- Common Sorting Algorithms
  - [BubbleSort 冒泡排序](#bubblesort)
  - [SelectSort 选择排序](#selectsort)  
  - [InsertSort 插入排序](#insertsort)
  - [MergetSort 归并排序](#mergetsort)
  - [HeapSort 堆排序](#heapsort)
  - [QuickSort 快速排序](#quicksort)
  - [ShellSort 希尔排序](#shellsort)
  - [CountSort 计数排序](#countsort)
  - [BucketSort 桶排序](#bucketsort)
  - [RadixSort 基数排序](#radixsort)
- [算法性能分析](algorithmperformance)
  
<a name="bubblesort"></a>
  
### 冒泡排序
  
冒泡排序是最简单的排序之一了，其大体思想就是**通过与相邻元素的比较和交换来把小的数交换到最前面**。这个过程类似于水泡向上升一样，因此而得名。
  
举个例子，对5,3,8,6,4这个无序序列进行冒泡排序。首先从后向前冒泡，4和6比较，把4交换到前面，序列变成5,3,8,4,6。同理4和8交换，变成5,3,4,8,6，3和4无需交换，5和3交换，变成3,5,4,8,6,3。这样一次冒泡就完了，把最小的数3排到最前面了。对剩下的序列依次冒泡就会得到一个有序序列。冒泡排序的时间复杂度为\(O(n^2)\)。

**实现代码：**
```java
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
```

  
<a name="selectsort"></a>
  
### 选择排序
  
选择排序的思想其实和冒泡排序有点类似，都是在一次排序后把最小的元素放到最前面，但是过程不同，**冒泡排序是通过相邻的比较和交换，而选择排序是通过对整体的选择**。
  
举个例子，对5,3,8,6,4这个无序序列进行简单选择排序，首先要选择5以外的最小数来和5交换，也就是选择3和5交换，一次排序后就变成了3,5,8,6,4。对剩下的序列一次进行选择和交换，最终就会得到一个有序序列。其实选择排序可以看成冒泡排序的优化，因为其目的相同，只是选择排序只有在确定了最小数的前提下才进行交换，大大减少了交换的次数。选择排序的时间复杂度为\(O(n^2)\)。

**实现代码：**
```java
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
```

<a name="insertsort"></a>
  
### 插入排序
  
**插入排序不是通过交换位置而是通过比较找到合适的位置插入元素来达到排序的目的的**。相信大家都有过打扑克牌的经历，特别是牌数较大的，在分牌时可能要整理自己的牌，牌多的时候怎么整理呢？就是拿到一张牌，找到一个合适的位置插入，这个原理其实和插入排序是一样的。
  
举个例子，对5,3,8,6,4这个无序序列进行简单插入排序，首先假设第一个数的位置时正确的，想一下在拿到第一张牌的时候，没必要整理，然后3要插到5前面，把5后移一位，变成3,5,8,6,4，然后8不用动，6插在8前面，8后移一位，4插在5前面，从5开始都向后移一位。注意在插入一个数的时候要保证这个数前面的数已经有序。简单插入排序的时间复杂度也是\(O(n^2)\)。

**实现代码：**
```java
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
```

<a name="mergetsort"></a>
  
### 归并排序
  
**归并排序是一种分治的思想**，一个数组的排序可以看作数组前面排好序的一部分和后面排好序的一部分进行合并，对于前面的一部分，我们又可以划分为两个部分分别排序，依次递归，直至划分为一个元素为止。归并排序的时间复杂度为\(O(nlog n)\)。

举例：输入数组5,2,4,7,1,3,2,6

归并排序的步骤如下如所示：
![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110801.png)

**代码实现：**
```java
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
```

<a name="heapsort"></a>
  
### 堆排序
  
堆排序主要是将待排序的数组组织成为一种成为“堆”的数据结构（注意，这里说的堆一般是指二叉堆），利用堆的性质进行排序，堆分为最大堆和最小堆，最大堆的性质是父母节点的值都大于孩子节点的值，最小堆则相反。堆排序的过程主要包括堆的构建和堆的调整两部分，其时间复杂度为\(O(nlog n)\)。

**代码实现：**
```java
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
```

<a name="quicksort"></a>
  
### 快速排序
  
开始排序也是一种分治的思想，其思路是按照数组中某一元素，将数组分为两部分，一部分所有元素都小于该元素，一部分是所有元素都大于该元素，然后递归调用，分别计算两部分。其时间复杂度为\(O(nlog n)\)。

举例：输入数组6, 1, 2, 7, 9, 3, 4, 5, 10, 8

第一轮的分解图示如下：
  
<img width="370" height="130" src="https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110802.jpg"/>

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110803.jpg)

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110804.jpg)

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110805.jpg)

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110806.jpg)


**代码实现：**
```java
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
```

<a name="shellsort"></a>
  
### 希尔排序
  
该方法的基本思想是：先将整个待排元素序列分割成若干个子序列（由相隔某个“增量”的元素组成的）分别进行直接插入排序，然后依次缩减增量再进行排序，待整个序列中的元素基本有序（增量足够小）时，再对全体元素进行一次直接插入排序。因为直接插入排序在元素基本有序的情况下（接近最好情况），效率是很高的，因此希尔排序在时间效率上比前两种方法有较大提高。其时间复杂度为\(O(nlog n)\)。

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110807.png)

**代码实现：**
```java
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
```

<a name="countsort"></a>
  
### 计数排序
  
计数排序使用一个额外的数组\(C\)，其中第\(i\)个元素是待排序数组\(A\)中值等于\(i\)的元素的个数。然后根据数组\(C\)来将\(A\)中的元素排到正确的位置。它只能对整数进行排序。算法的步骤如下：

1、找出待排序的数组中最大和最小的元素

2、统计数组中每个值为\(i\)的元素出现的次数，存入数组\(C\)的第\(i\)项

3、对所有的计数累加（从\(C\)中的第一个元素开始，每一项和前一项相加）

4、反向填充目标数组：将每个元素\(i\)放在新数组的第\(C(i)\)项，每放一个元素就将\(C(i)\)减去1

当输入的元素是\(n\)个0到\(k\)之间的整数时，它的运行时间复杂度是 \(O(n+k)\)。

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110808.png)


**实现代码：**
```java
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
```

<a name="bucketsort"></a>
  
### 桶排序
  
桶排序假设输入数据服从均匀分布，然后将输入数据均匀地分配到有限数量的桶中，然后对每个桶使用插入排序算法，最后将每个桶中的数据有序的组合起来。桶排序则是假设输入是由一个随机过程生成，该过程将元素均匀的分布在一个区间\([a,b]\)上。由于桶排序和计数排序一样均对输入的数据进行了某些假设限制，因此比一般的基于比较的排序算法复杂度低，其时间复杂度是 \(O(n+k)\)

桶排序过程:

1.初始化装入连续区间元素的\(n\)个桶，每个桶用来装一段区间中的元素。

2.遍历待排序的数据，将其映射到对应的桶中，保证每个桶中的元素都在同一个区间范围中。

3.对每个桶进行排序，最终将所有桶中排好序的元素连起来。

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110901.png)

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110809.png)

**代码实现：**
```java
/**
 * @Description: 桶排序
 * @ClassName: BucketSort
 * @author Jia Zheng
 * @time 2017年8月16日 下午10:17:56
 */
public class BucketSort {
	//桶的映射函数
	private static int hash(int value) {
		return value / 10;
	}
	@SuppressWarnings("null")
	public static void bucketSort(int arr[], int result[]) {
		Node[] bucket = new Node[10];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new Node();
		}
		for (int i = 0; i < arr.length; i++) {
			int indexBucket = hash(arr[i]);
			Node node = new Node(arr[i]);
			Node pNode = bucket[indexBucket];
			if(pNode == null){
				pNode.next = node;
			}
			else {
				while (pNode.next!=null && pNode.next.data <= node.data) {
					pNode = pNode.next;
				}
				node.next = pNode.next;
				pNode.next = node;
			}
		}
		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			Node node = bucket[i].next;
			while (node != null) {
				result[j++] = node.data;
				node = node.next;
			}
		}
	}
}
//链表的节点类
class Node {
	Node next; //指针域
	Integer data;//数据域

	public Node(int data) {
		this.data = data;
	}

	public Node() {
		this.data = null;
	}
}
```

<a name="radixsort"></a>
  
### 基数排序

基数是根据关键字中各位的值，通过对排序的N个元素进行若干趟“分配”与“收集”来实现排序的。时间复杂度是 \(O(nk)\)。

直接通过一个具体的实例来展示一下，基数排序是如何进行的。

设有一个初始序列为: R {50, 123, 543, 187, 49, 30, 0, 2, 11, 100}。

由于任何一个阿拉伯数，它的各个位数上的基数都是以0~9来表示的，我们把0~9视为10个桶。

先根据序列的个位数的数字来进行分类，将其分到指定的桶中。例如：R[0] = 50，个位数上是0，将这个数存入编号为0的桶中。

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110902.png)


分类后，我们在从各个桶中，将这些数按照从编号0到编号9的顺序依次将所有数取出来。

这时，得到的序列就是个位数上呈递增趋势的序列。

按照个位数排序结构为： {50, 30, 0, 100, 11, 2, 123, 543, 187, 49}。

接下来，可以对十位数、百位数也按照这种方法进行排序，最后就能得到排序完成的序列。

**代码实现：**
```java
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
```
  
<a name="algorithmperformance"></a>
  
### 算法性能分析
  
**稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面
**不稳定**：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面

**内排序**：所有排序操作都在内存中完成
**外排序**：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行

**时间复杂度**: 算法执行所耗费的时间
**空间复杂度**: 算法执行所耗费的内存的大小

![](https://raw.githubusercontent.com/jia-zh/Common-Sorting-Algorithms/master/images/2017110903.png)
