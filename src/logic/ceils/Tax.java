package logic.ceils;

import logic.Cell;
import logic.Player;
import logic.PlayingField;

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
}
