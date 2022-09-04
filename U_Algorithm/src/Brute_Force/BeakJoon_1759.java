package Brute_Force;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BeakJoon_1759 {
	static StringBuilder sb = new StringBuilder();
	static int N , M ;
	static String[]words,selected;
	static int[]rec;
	
	
	public static void main(String[] args) {
		try {
			input();
			rec_func(1);
			System.out.println(sb.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}//main
	


	private static void rec_func(int k) {

		if(k==N+1) {
			if(isValid()){
                for(int i=1; i<=N; i++) sb.append(selected[i]);
                sb.append("\n");
            }
		}else {
			for(int cand=rec[k-1]+1; cand<=M; cand++) {
				selected[k] = words[cand]; rec[k] = cand;
				rec_func(k+1);
				selected[k] = " "; rec[k]=0;
			}
		}
	}


	private static boolean isValid() {
		int ja = 0, mo=0;
		
		for(int i=1;i<=N;i++) {
			if(selected[i].equals("a") || selected[i].equals("e") || selected[i].equals("i") || selected[i].equals("o") || selected[i].equals("u")) {
				mo++;
			}
			if(mo+2>N)
				return false;
		}if(mo == 0)
			return false;
		
		else return true;
	}



	static void input() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        
        selected = new String[N+1]; 
        words = new String[M+1]; 
        rec = new int[N+1];
        
        split = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
        	words[i+1] = split[i];
        }
        	words[0] = "a"; 
            Arrays.sort(words); 	 
            words[0] = null;
    }
	
}
