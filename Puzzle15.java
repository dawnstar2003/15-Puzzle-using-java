package FifteenPuzzle;

import java.util.*;

public class Puzzle15 {
	
	//Fill The board with 0 to 15 Randomly using random function
	private static void fillboard(int[][] board) {
		Random random = new Random();
		for (int i = 0; i < 16; i++) {
			int row = random.nextInt(4);
			int col = random.nextInt(4);

			while (board[row][col] != 0) {
				row = random.nextInt(4);
				col = random.nextInt(4);
			}
			board[row][col] = i;
		}
		print(board);
	}

	//Print the board
	private static void print(int[][] board) {
		System.out.println("      0     1     2     3");
		System.out.print("   -------------------------");
		System.out.println();
		for (int i = 0; i < 4; i++) {
			// System.out.print("|");
			for (int j = 0; j < 4; j++) {
				if (j == 0)
					System.out.print(" " + i + " |");
				if (board[i][j] == 0)
					System.out.print("     |");
				else if (board[i][j] <= 9)
					System.out.print("  " + board[i][j] + "  |");
				else
					System.out.print(" " + board[i][j] + "  |");
			}
			System.out.println();
			System.out.print("   -------------------------");
			System.out.println();
		}
	}
 
	//Manages game flow
	private static void startGame(int[][] board) {
		int userRow = 0, userCol = 0;
		int zero[] = new int[2];
		List<List<Integer>> possibleMove = new ArrayList<>();
		zero = findZero(board, zero);
		int zeroRow = zero[0];
		int zeroCol = zero[1];

		boolean gameOver = checkIfAllElementAreInPlace(board);
		while (!gameOver) {
			System.out.println(findPossibleMoves(board, zeroRow, zeroCol, possibleMove));
			userRow = getInputFromUser(1);
			userCol = getInputFromUser(2);

			boolean isUserInputOnList = checkUserInputOnList(possibleMove, userRow, userCol);

			while (!isUserInputOnList) {
				userRow = getInputFromUser(1);
				userCol = getInputFromUser(2);
				isUserInputOnList = checkUserInputOnList(possibleMove, userRow, userCol);
			}

			zero = swapTheNumber(board, zeroRow, zeroCol, userRow, userCol);
			possibleMove.clear();
			zeroRow = zero[0];
			zeroCol = zero[1];

			print(board);
			gameOver = checkIfAllElementAreInPlace(board);
		}

		System.out.println("YOU WON THE GAME ヾ(￣▽￣) Bye~Bye~");
	}

	//swap the empty space with the number given by user
	private static int[] swapTheNumber(int[][] board, int zeroRow, int zeroCol, int userRow, int userCol) {
		int zero[] = new int[2];
		int temp = board[userRow][userCol];
		board[userRow][userCol] = board[zeroRow][zeroCol];
		board[zeroRow][zeroCol] = temp;
		zero[0] = userRow;
		zero[1] = userCol;
		return zero;
	}

	//user whether the userinput is a possible move or not
	private static boolean checkUserInputOnList(List<List<Integer>> possibleMove, int userRow, int userCol) {
		for (List<Integer> move : possibleMove) {
			int targetRow = move.get(0);
			int targetCol = move.get(1);
			if (targetRow == userRow && targetCol == userCol) {
				return true;
			}
		}
		return false;
	}

	//check whether all the element are in correct position, if it true the game completes
	private static boolean checkIfAllElementAreInPlace(int[][] board) {
		int num = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] != num) {
					return false;
				}
				num++;
			}
		}
		return true;
	}

	//get input from the user and check if the number is valid or not
	private static int getInputFromUser(int n) {
		Scanner sc = new Scanner(System.in);
		if (n == 1)
			System.out.println("Enter the row :");
		else
			System.out.println("Enter the Column : ");

		int num = sc.nextInt();

		while (num < 0 || num > 3) {
			System.out.println("Index does not exists, Enter the number between 0 to 3");
			num = sc.nextInt();
		}
		return num;
	}

	//find the possible next move 
	private static List<List<Integer>> findPossibleMoves(int[][] board, int row, int col,
			List<List<Integer>> possibleMove) {
		if (row - 1 >= 0)
			possibleMove.add(List.of(row - 1, col));
		if (col - 1 >= 0)
			possibleMove.add(List.of(row, col - 1));
		if (col + 1 <= 3)
			possibleMove.add(List.of(row, col + 1));
		if (row + 1 <= 3)
			possibleMove.add(List.of(row + 1, col));
		return possibleMove;
	}

	//find the zero's position
	private static int[] findZero(int[][] board, int[] zero) {
		outerloop: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == 0) {
					zero[0] = i;
					zero[1] = j;
					break outerloop;
				}
			}
		}
		return zero;
	}

	
	public static void main(String agrs[]) {
		System.out.println("Welcome to 15 Puzzle Game : ");
		int board[][] = new int[4][4];
		fillboard(board);
		startGame(board);
	}

}
