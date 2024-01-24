
// here source i.e 0 is represented by s and destination is represented by 'd'
// '*' is represents the another index present int Array.
// '8' is a minimum cost to traverse from 0 to 24

import java.util.*;

class element {
int row;
int col;
int dist;
public element(int row, int col, int dist)
{
	this.row = row;
	this.col = col;
	this.dist = dist;
}
}

public class Problem7 {
private static int minDistance(char[][] grid)
{
	element source = new element(0, 0, 0);

	firstLoop:
	for (int i = 0; i < grid.length; i++) {
	for (int j = 0; j < grid[i].length; j++) 
	{

		if (grid[i][j] == 's') {
		source.row = i;
		source.col = j;
		break firstLoop;
		}
	}
	}

	Queue<element> queue = new LinkedList<>();
	queue.add(new element(source.row, source.col, 0));

	boolean[][] visited
	= new boolean[grid.length][grid[0].length];
	visited[source.row][source.col] = true;

	while (queue.isEmpty() == false) {
	element p = queue.remove();

	if (grid[p.row][p.col] == 'd')
		return p.dist;

	if (isValid(p.row - 1, p.col, grid, visited)) {
		queue.add(new element(p.row - 1, p.col,
							p.dist + 1));
		visited[p.row - 1][p.col] = true;
	}

	if (isValid(p.row + 1, p.col, grid, visited)) {
		queue.add(new element(p.row + 1, p.col,
							p.dist + 1));
		visited[p.row + 1][p.col] = true;
	}

	if (isValid(p.row, p.col - 1, grid, visited)) {
		queue.add(new element(p.row, p.col - 1,
							p.dist + 1));
		visited[p.row][p.col - 1] = true;
	}

	if (isValid(p.row, p.col + 1, grid,
				visited)) {
		queue.add(new element(p.row, p.col + 1,
							p.dist + 1));
		visited[p.row][p.col + 1] = true;
	}
	}
	return -1;
}


private static boolean isValid(int x, int y,
								char[][] grid,
								boolean[][] visited)
{
	if (x >= 0 && y >= 0 && x < grid.length
		&& y < grid[0].length && grid[x][y] != '0'
		&& visited[x][y] == false) {
	return true;
	}
	return false;
}

public static void main(String[] args)
{
	char[][] grid = { { 's', '*', '*', '*', '*' },
					  { '*', '*', '*', '*', '*' },
					  { '*', '*', '*', '*', '*' },
					  { '*', '*', '*', '*', '*' },
					  { '*', '*', '*', '*', 'd'}};

	System.out.println(minDistance(grid));
}
}
