package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BeakJoon_2751_Heap {

	static StringTokenizer st;
	static int[] heapSort;
	
	public static void main(String args[]) throws IOException {
		
		//선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());//수의 갯수
		heapSort = new int[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			heapSort[i] =input;//배열에 담음
		}
		buildMaxHeap();

		//출력
		for(int output: heapSort) {
			bw.write(String.valueOf(output));
			bw.newLine();
		}
		bw.flush();
	}

	private static void buildMaxHeap() {

		if(heapSort == null || heapSort.length < 1) {
			return;
		}//힙 정렬이 다 돌아가면 탈출
		
		for(int i=heapSort.length/2; i>=0; i--) {//힙정렬 인덱스
			heapify(heapSort , i , heapSort.length);
		}
		
		//오름차순 정렬
		for(int i=heapSort.length-1; i>=0; i--) {
			int temp = 0;
			
			temp = heapSort[0];
            heapSort[0] = heapSort[i];
            heapSort[i] = temp; //교환법칙
            
            heapify(heapSort, 0, i);
			
		}
		
	}

	//힙 만들기
	private static void heapify(int[] unsorted, int index , int heapSize) {

		int largest = index;
		int leftIndex = 2*index+1;
		int rightIndex =2*index+2;
		int temp = 0;
		
		if(leftIndex < heapSize && unsorted[leftIndex] >  unsorted[largest]) {
			largest = leftIndex;//무조건 힙 사이즈 보다는 작아야함
		}
		if(rightIndex < heapSize && unsorted[rightIndex] >  unsorted[largest]) {
			largest = rightIndex;
		}
		if(largest != index) {
			
			temp = heapSort[largest];
            heapSort[largest] = heapSort[index];
            heapSort[index] = temp; //교환법칙
            
            heapify(heapSort, largest, heapSize);//재귀
		}
		
	}
}