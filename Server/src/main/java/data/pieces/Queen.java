package data.pieces;

import data.ChessBoard;
import data.ChessPieceVisitor;
import data.PieceVisitor;
import data.Space;

public class Queen extends ChessPiece implements PieceVisitor{

	public Queen(Space positionIn, ChessBoard chessBoardIn, boolean colorIn){
		pieceType="queen";
		position=positionIn;
		color=colorIn;
		isMoved=false;
		movement=new int[]{10,01,11};//Movement pattern for bishop
		this.chessBoard=chessBoardIn;//Reference copy of chess board
	}
	

	@Override
	public void getMoves() {
		for(int change:movement)
		{
			startRecursiveGetMoves(change);
		}
	}

	@Override
	public String accept(ChessPieceVisitor v){
		return v.visit(this);
	}
}
