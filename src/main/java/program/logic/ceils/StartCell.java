package program.logic.ceils;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;

import java.util.ArrayList;

public class StartCell extends Cell {
    private int prize;

    public StartCell(int prize) {
        this.prize = prize;
    }
    @Override
    public void action(Player player, PlayingField playingField, ArrayList<Player> players){
        player.setLiberalValues(player.getLiberalValues() + prize);
    }

    public int getPrize() {
        return this.prize;
    }
}
