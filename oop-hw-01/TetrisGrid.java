//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {

	boolean[][] grid;
	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}
	
	
	/**
	 * Does row-clearing on the grid (see handout).
	 */
	public void clearRows() {
		int param = grid.length;
		for (int c =0; c<grid[0].length; c++) {
			int curr = param;
			for(int r = 0; r<grid.length; r++) {
				if(grid[r][c]==true) {
					curr--;
				}
			}
			if(curr == 0) {
				deleteAndShift(c);
				c--;
			}
		}
	}
	public void deleteAndShift(int c) {

			for(int col = c; col < grid[0].length-1;col++) {
				for(int r =0; r < grid.length; r++) {
					grid[r][c] = grid[r][c + 1];

					if (col == grid[0].length - 2) {
						grid[r][c + 1] = false;
					}
				}
			}


	}
	/**
	 * Returns the internal 2d grid array.
	 * @return 2d grid array
	 */
	boolean[][] getGrid() {
		return grid; // YOUR CODE HERE
	}
}
