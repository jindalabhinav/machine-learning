package main.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@Getter
@SuperBuilder
public abstract class Player {
    private GameSymbol symbol;
    public abstract BoardCell makeMove(Board board);
    // we could've also returned a Board here, but that means that the Bot/Human Player can make multiple
    // moves and return a filled Board. That is not what we want, we instead will return only the next move/cell.
}
