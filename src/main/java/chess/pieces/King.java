package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] v_temp = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);

        //above
        position.setValue(position.getRow() -1,  position.getColumn());
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //below
        position.setValue(position.getRow()+1, position.getColumn());
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //left
        position.setValue(position.getRow(), position.getColumn() -1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //right
        position.setValue(position.getRow(), position.getColumn()+1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //nw
        position.setValue(position.getRow() -1, position.getColumn() -1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //ne
        position.setValue(position.getRow() -1, position.getColumn() +1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //sw
        position.setValue(position.getRow() +1, position.getColumn() -1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //se
        position.setValue(position.getRow() +1, position.getColumn() +1);
        if (getBoard().positionExists(position) && canMove(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        return v_temp;
    }
}
