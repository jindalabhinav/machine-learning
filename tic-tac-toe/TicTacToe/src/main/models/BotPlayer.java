package main.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;
import strategies.playing.PlayingStrategy;

@SuperBuilder
public class BotPlayer extends Player {
    private GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(GameSymbol symbol, GameLevel level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }


    @Override
    public BoardCell makeMove(Board board) {
        BoardCell boardCell = playingStrategy.makeMove(board);
        boardCell.setSymbol(getSymbol());

        return boardCell;
    }
}
