# 15-Puzzle-using-java

This is a console-based 15 Puzzle game created in Java using a 2D integer array.

## Description

The 15 Puzzle Game is a sliding puzzle where the player aims to arrange numbered tiles in ascending order within a 4x4 grid by moving tiles into an empty space. The game uses randomization to shuffle the tiles initially and requires the player to rearrange them to win.

## How to Play

1. Run the `Puzzle15.java` file to start the game.
2. You will be presented with a 4x4 grid containing numbers from 1 to 15 in a randomized order.
3. Provide row and column indices to move tiles adjacent to the empty space.4
4. Rearrange the tiles by strategically moving them until they are in ascending order from 1 to 15.
5. You win the game once all tiles are arranged correctly.

## Features

- Random shuffling of the board at the beginning of the game.
- Validation of user inputs to ensure moves are within the bounds of the grid.
- Display of possible moves for the player's convenience.
- Checking for game completion when tiles are arranged in the correct order.

## Code Structure

- `fillboard`: Randomly fills the board with numbers from 0 to 15.
- `print`: Prints the current state of the board.
- `startGame`: Manages the game flow by taking user inputs, validating moves, and checking game completion.
- `swapTheNumber`: Swaps the empty space with the user-provided number.
- `checkUserInputOnList`: Validates if the user's input is a possible move.
- `checkIfAllElementAreInPlace`: Checks if all elements are in the correct order for game completion.
- `getInputFromUser`: Takes user input for row and column indices.
- `findPossibleMoves`: Finds possible moves around the empty space.
- `findZero`: Finds the position of the empty space (0) on the board.

## How to Run

1. Ensure you have Java installed on your system.
2. Compile the `Puzzle15.java` file using `javac Puzzle15.java`.
3. Run the compiled file using `java Puzzle15`.

Have fun playing the 15 Puzzle Game!
