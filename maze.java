import java.util.Random;

public class MazeGenerator {
    private int[][] maze;
    private int rows, cols;
    private Random random = new Random();

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        maze = new int[rows][cols];
        generateMaze(0, 0);
    }

    // Generates the maze using a depth-first search algorithm
    private void generateMaze(int row, int col) {
        maze[row][col] = 1; // Mark the current cell as visited

        // Directions: up, right, down, left
        int[] directions = {0, 1, 0, -1, 1, 0, -1, 0};
        for (int i = 0; i < 4; i++) {
            int newRow = row + directions[2 * i];
            int newCol = col + directions[2 * i + 1];

            // Check if the new cell is within the maze and is not visited
            if (isValid(newRow, newCol) && maze[newRow][newCol] == 0) {
                // Remove the wall between the current cell and the new cell
                maze[(row + newRow) / 2][(col + newCol) / 2] = 1;
                generateMaze(newRow, newCol);
            }
        }
    }

    // Checks if a cell is within the bounds of the maze
    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Prints the maze to the console
    public void printMaze() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] == 1 ? "#" : " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(10, 10);
        mazeGenerator.printMaze();
    }
}
