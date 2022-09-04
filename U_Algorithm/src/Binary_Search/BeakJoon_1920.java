package Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeakJoon_1920 {

	public static int[] arr;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//배열을 정렬시키기
		Arrays.sort(arr);
		
		
		//비교할 값
		int M= Integer.parseInt(br.readLine()); 
		st = new StringTokenizer(br.readLine()," ");
		
		StringBuilder sb = new StringBuilder();
		
		//출력하기
		for(int i=0;i<M;i++) {
			if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1).append('\n');
			}else {
				sb.append(0).append('\n');
			}
		}
		System.out.println(sb);
	}

	//이분탐색
	private static int binarySearch(int key) {

		int low=0;
		int high=arr.length-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			
			if(key < arr[mid]) {
				high = mid-1;
			}
			else if(key > arr[mid]) {
				low = mid+1;
			}
			else { //키값이랑 같을경우
				return mid;
			}
		}
		return -1;
	}

}
