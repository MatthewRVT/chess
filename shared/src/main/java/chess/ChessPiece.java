package chess;

import java.util.ArrayList;
import java.util.Collection;

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
        int col = myPosition.getColumn();
        int row = myPosition.getColumn();
        type = piece.getPieceType();
        switch (type){
            case PAWN: {
                ArrayList<ChessMove> myMoves = new ArrayList<ChessMove>();
                myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col), type));
                if (!(col == 1)){
                    if (!(board.getPiece(new ChessPosition(row + 1, col + 1)) == null)) {
                        myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col + 1), type));
                        if (!(board.getPiece(new ChessPosition(row + 1, col - 1)) == null)) {
                            myMoves.add(new ChessMove(myPosition, new ChessPosition(row + 1, col - 1), type));
                    }
                }
                if ()
                //will need to check if on the edges of the board for capturing

            }

        }
    }
}
