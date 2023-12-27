package program.logic.ceils;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;

import java.util.ArrayList;

public class Tax extends Cell {
    private int cost;

    public Tax(int cost){
        this.cost = cost;
    }

    @Override
    public void action(Player player, PlayingField playingField, ArrayList<Player> players) {
        player.setLiberalValues(player.getLiberalValues() - 500);
    }

    public int getCost() {
        return cost;
    }
}
