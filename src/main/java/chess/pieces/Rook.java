package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] v_temp = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position position = new Position(0,0);

        //above
        position.setValue(position.getRow() - 1 , position.getColumn());
        while(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() - 1);
        } if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //left
        position.setValue(position.getRow(), position.getColumn() -1);
        while(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() - 1);
        } if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //right
        position.setValue(position.getRow(), position.getColumn() -1);
        while(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
            position.setColumn(position.getColumn() + 1);
        } if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        //below
        position.setValue(position.getRow() - 1 , position.getColumn());
        while(getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
            position.setRow(position.getRow() + 1);
        } if(getBoard().positionExists(position) && isThereOpponentPiece(position)) {
            v_temp[position.getRow()][position.getColumn()] = true;
        }

        return v_temp;
    }
}
