package cn.edu.bistu.sort;

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
