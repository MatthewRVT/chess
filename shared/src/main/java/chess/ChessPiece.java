package chess;

import java.util.ArrayList;
import java.util.Collection;

import chess.ChessGame.TeamColor;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {
    private PieceType type;
    private ChessGame.TeamColor team;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType type) {
        this.type = type;
        this.team = pieceColor;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return this.team;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return this.type;
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        ChessPiece piece = board.board[myPosition.getRow()][myPosition.getColumn()];
        int teamMod = 1;
        int col = myPosition.getColumn();
        int row = myPosition.getColumn();
        type = piece.getPieceType();
        team = piece.getTeamColor();
        if (team == TeamColor.BLACK){
            teamMod = -1;
        }
        ArrayList<ChessMove> myMoves = new ArrayList<ChessMove>();
        switch (type) {
            case PAWN: {
                //NOTE did promotion wrong will need to fix
                //checks if there is a piece in the way otherwise moves 1 forward
                if (board.getPiece(new ChessPosition(row + teamMod, col)) == null) {
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), type));
                }
                // checks if you can move 2 and if there is someone in the way or not for fow 2
                if (row == 2) {
                    if (team == TeamColor.WHITE && board.getPiece(new ChessPosition(row + teamMod, col)) == null && board.getPiece(new ChessPosition(row + 2, col)) == null) {
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col), type));
                    }
                    else if (board.getPiece(new ChessPosition(row + teamMod, col)) == null){
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + -1, col), PieceType.ROOK));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + -1, col), PieceType.BISHOP));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + -1, col), PieceType.KNIGHT));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + -1, col), PieceType.QUEEN));
                    }
                }
                if (col == 7) {
                    if (team == TeamColor.BLACK && board.getPiece(new ChessPosition(row + teamMod, col)) == null && board.getPiece(new ChessPosition(row - 2, col)) == null) {
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col), type));
                    }
                    else if (board.getPiece(new ChessPosition(row + teamMod, col)) == null){
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), PieceType.ROOK));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), PieceType.BISHOP));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), PieceType.KNIGHT));
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), PieceType.QUEEN));
                    }
                }
                if (!(board.getPiece(new ChessPosition(row + teamMod, col + 1)) == null)) {
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(row + teamMod, col + 1), type));
                }
                if (!(board.getPiece(new ChessPosition(row + teamMod, col - 1)) == null)) {
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(row + teamMod, col - 1), type));
                }
                //will need to check if on the edges of the board for capturing
                return myMoves;

            }
            case ROOK: {
                // doesn't check if blocked at the moment
                for (int newCol = col; newCol < 7; newCol++){
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), type));
                }
                for (int newCol = col; newCol > 2 ; newCol--){
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(row, newCol), type));
                }
                for (int newRow = row; newRow < 7; newRow++){
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), type));
                }
                for (int newRow = row; newRow > 2; newRow--){
                    myMoves.add(new ChessMove(myPosition, new ChessPosition(newRow, col), type));
                }
                return myMoves;
            }
            case BISHOP: {
                return myMoves;
            }
            case QUEEN: {
                return myMoves;
            }
            case KNIGHT: {
                //doesn't yet check if the attempted captured piece is friendly nor if it would go off the board or if the spot is occupied

                myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col - 1), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 2, col - 1), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col - 1), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row - 2, col + 1), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 2), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 2), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col - 2), type));
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row - 1, col + 2), type));
                return myMoves;
            }
            case KING: {
                return myMoves;
            }
            default: {
                return myMoves;
            }

        }
    }
}
