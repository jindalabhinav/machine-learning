import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Player {
    private GameSymbol symbol;

    public abstract BoardCell makeMove(Board board);
    }
}
