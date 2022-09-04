package Graph;

public class GraphArray{
	   private int[][] array;

	   public GraphArray(int size){ // 행렬 그래프 생성 
	      array = new int[size+1][size+1];
	   }

	   public int[][] getArray(){//배열 가져오기
	      return array;
	   }

	   public boolean isEmpty() {//비어있는지 확인
			return array == null;
		}
	   public void addDirectedEdge(int x, int y) {//단방향
			array[x][y] = 1;
		}

		public void addCompleteEdge(int x, int y) {//양방향
			array[x][y] = 1;
			array[y][x] = 1;
		}
		public void deleteDirectedEdge(int x, int y) {//단방향 연결 끊기
			array[x][y] = 0;
		}

		public void deleteCompleteEdge(int x, int y) {//양방향 연결 끊기
			array[x][y] = 0;
			array[y][x] = 0;
		}
		public void printArray(){
			   for(int i=0; i<array.length; i++){
			      for(int j=0; j<array.length; j++){
			         System.out.print(array[i][j] + " ");
			      }
			      System.out.println();
			   }
			}
		
	}
