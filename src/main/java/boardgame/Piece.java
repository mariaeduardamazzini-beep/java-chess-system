package boardgame;

public abstract class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }
    protected Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    public boolean isThereAnyPossibleMoves() {
        boolean[][] v = possibleMoves();
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                if (v[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
