package Sort;

public class Merge_Sort_ex {

	public static int[] src;
	public static int[] tmp;

	public static void main(String[] args) {

		src = new int[] { 1, 9, 8, 5, 4, 2, 3, 7, 6 };
		tmp = new int[src.length];//병합정렬된 배열

		printArray(src);
		mergeSort(0, src.length - 1);
		printArray(src);
	}

	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);// 첫번째 분할
			mergeSort(mid + 1, end);// 두번째 분할

			int p = start;
			int q = mid + 1;
			int idx = p;//채워넣을 배열의 인덱스

			while (p <= mid || q <= end) {
				if (q > end || (p <= mid && src[p] <= src[q])) {
					tmp[idx++] = src[p++];
				} else {
					tmp[idx++] = src[q++];
				}
			}
			for (int i = start; i <= end; i++) {
				src[i] = tmp[i];
			}
		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
}
