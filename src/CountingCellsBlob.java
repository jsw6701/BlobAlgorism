public class CountingCellsBlob {

    private static int BACKGROUND_COLOR = 0; //아무것도 칠해져있지 않은 곳
    private static int IMAGE_COLOR = 1; // 칠해져 있는 곳
    private static int ALREADY_COLOR = 2; // 지나온 곳 중복되지 않게 다르게 칠한 곳
    private static int N = 8;
    private static int[][] grid = {
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 1}
    };

    public static int countCells(int x, int y){
        if(x<0 || y<0 || x>=N || y>=N)
            return 0; //범위밖
        else if(grid[x][y] != IMAGE_COLOR){
            return 0; // 처음 들른 칠해진 곳 아니면 0
        }
        else{
            grid[x][y] = ALREADY_COLOR; //중복되지 않게 표시해줌
            return 1 + countCells(x, y + 1) + countCells(x + 1, y + 1)
                    + countCells(x + 1, y) + countCells(x + 1, y - 1)
                    + countCells(x, y - 1) + countCells(x - 1, y - 1)
                    + countCells(x - 1, y) + countCells(x - 1, y + 1);
        }
    }

    public static void printGrid(){
        for (int x = 0; x < N; x++) {
            System.out.print("[");
            for (int y = 0; y < N; y++)
                System.out.print(grid[x][y] + ", ");
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        printGrid();
        int blobCount = countCells(7, 1);
        System.out.println();
        System.out.println("blobCount : " + blobCount);
        printGrid();
    }
}
