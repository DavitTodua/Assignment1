// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 *
	 * @param grid
	 */
	public CharGrid(char[][] grid) {

		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 *
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		return 0;
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 *
	 * @return number of + in grid
	 */
	public int countPlus() {
		int curr = 0;
		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(testForPlus(grid[i][j],i,j)) {
					curr++;
				}
			}
		}
		return curr;
	}

	public boolean testForPlus(char c, int i, int j) {
		int up = 0;
		int j2 = j;
		int j1 = j;
		int i1 = i;
		int i2 = i;
		// UP
		while (i1 > 0) {
			i1--;
			if (grid[i1][j] == c) {
				up++;
			} else {
				break;
			}
		}
		//DOWN
		int down = 0;
		while (i2 < grid.length-1) {
			System.out.println(grid.length+"vot");
			i2++;
			if (grid[i2][j] == c) {
				down++;
			} else {
				break;
			}
		}
		if (down != up) {
			return false;
		}
		//LEFT
		int left = 0;
		while (j1 > 0) {
			j1--;
			if (grid[i][j1] == c) {
				left++;
			} else {
				break;
			}
		}
		if (left != down) {
			return false;
		}
		//RIGHT
		int right = 0;
		while (j2 < grid[i].length-1) {
			j2++;
			System.out.println(j2);
			System.out.println(grid[i].length + "es iuris sigrdze");
			if (grid[i][j2] == c) {
				right++;
			} else {
				break;
			}
		}
		if (right != left) {
			return false;
		}
		if(right ==0 || left ==0 || up ==0 || down ==0) {
			return false;
		}

		return true;
	}
}