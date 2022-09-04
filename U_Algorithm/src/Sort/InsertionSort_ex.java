package Sort;

public class InsertionSort_ex {

	//삽입정렬  (오름차순)
	
	public static void main(String[] args) {
		int[]arr= {10,2,6,4,3,7,5};
		
		for(int i=1;i<arr.length;i++) { //주의할점은 삽입정렬은 두번째 인덱스부터 시작
			int standard = arr[i]; //기준
			int aux=i-1; //비교할 대상
			
			while(aux>=0 && standard < arr[aux]) {
				arr[aux + 1] = arr[aux];
				
				aux--;
			}
			arr[aux+1]=standard; //2가 아니라 표준값 인덱스의 위치를 오른쪽으로 이동
			
		}//for
		printArr(arr);
	}

	private static void printArr(int[] arr) {

		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
				
		
	}

}
