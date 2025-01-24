package chess;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    // private ChessPosition[][] board;
    public ChessPiece[][] board = new ChessPiece[8][8];

    void Setup() {
        GenerateOthers(ChessGame.TeamColor.WHITE, 0);
        GeneratePawns(ChessGame.TeamColor.WHITE, 1);
        GenerateOthers(ChessGame.TeamColor.BLACK, 7);
        GeneratePawns(ChessGame.TeamColor.BLACK, 6);
    }

    void GeneratePawns(ChessGame.TeamColor pieceColor, int row) {
        for (int i = 0; i < 8; i++) {
            board[row][i] = new ChessPiece(pieceColor, ChessPiece.PieceType.PAWN);
        }
    }

    void GenerateOthers(ChessGame.TeamColor pieceColor, int row) {
        board[row][0] = new ChessPiece(pieceColor, ChessPiece.PieceType.ROOK);
        board[row][1] = new ChessPiece(pieceColor, ChessPiece.PieceType.KNIGHT);
        board[row][2] = new ChessPiece(pieceColor, ChessPiece.PieceType.BISHOP);
        board[row][3] = new ChessPiece(pieceColor, ChessPiece.PieceType.QUEEN);
        board[row][4] = new ChessPiece(pieceColor, ChessPiece.PieceType.KING);
        board[row][5] = new ChessPiece(pieceColor, ChessPiece.PieceType.BISHOP);
        board[row][6] = new ChessPiece(pieceColor, ChessPiece.PieceType.KNIGHT);
        board[row][7] = new ChessPiece(pieceColor, ChessPiece.PieceType.ROOK);
    }

    public ChessBoard() {
        Setup();

    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        board[position.getRow()][position.getColumn()] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        return board[position.getRow()][position.getColumn()];
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        board = new ChessPiece[8][8];
        Setup();
        //also add a for loop to wipe all the middle tiles to null I think
    }
}
