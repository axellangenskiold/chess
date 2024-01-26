# chess
- A chess game in java using the java.swing GUI.
- Implemented with a observer/observable model (unfortunately deprecated but thought it looked the nicest)
-
- The gui uses JButtons for the squares/tiles and image icons that represents the pictures
- The gui board is a JPanel with a gridlayout
- 
- The board in the model is represented by a matrix of "Squares"
- The squares have a variable "piece" of type "Piece" that is either a Chess Piece or an EmptyPiece
- All pieces inherit the abstract class "Piece". "Piece" what seperates the pieces are the available moves.
- All pieces have a list of moves that they can make (even if they aren't legal moves)
- If a player wants to move a piece from square a to square b, the move(Pos from, Pos to) - method 
- in board checks if that move is legal. If the move is out of bounds, takes it's own piece or puts the king
- in check, the move is not allowed
- 
- 
- 
# specs
- Run the program with "gradle run" or with "./gradlew"
- 
- Source code can be found in "/chess/app/src/main/java/chess"
- Images can be found in "/chess/app/src/main/resources



