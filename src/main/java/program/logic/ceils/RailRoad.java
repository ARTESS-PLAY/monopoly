package program.logic.ceils;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;

import java.util.ArrayList;
import java.util.List;

public class RailRoad extends Cell {
    private String name;
    private int cost;
    private int income;
    private Player owner;

    public RailRoad(String name, int cost) {
        this.name = name;
        this.cost = cost;
        income = cost/4;
        owner = null;
    }

    @Override
    public void action(Player player, PlayingField playingField, ArrayList<Player> players) {
        if (player.getSkipping() == 0) {
            if (owner != null) {
                player.setLiberalValues(player.getLiberalValues() - income);
                owner.setLiberalValues(owner.getLiberalValues() + income);
            }
        }
    }

    public void deleteOwner() {
        owner = null;
        income = cost/4;
    }

    public Player getOwner() {
        return owner;
    }

    public void action2(Player player, PlayingField playingField) {
        if (owner == null) buyRailRoad(player, playingField);
    }

    private int numberRailRoad(Player player, PlayingField playingField) {
        List<RailRoad> railRoads = playingField.getAllRailRoads();
        int cost = 0;
        for (RailRoad railRoad : railRoads) {
            if (railRoad.getOwner() != null && railRoad.getOwner().equals(player)) cost++;
        }
        return cost;
    }

    private void buyRailRoad(Player player, PlayingField playingField) {
        owner = player;
        player.setLiberalValues(player.getLiberalValues() - cost);
        List<RailRoad> railRoads = playingField.getAllRailRoads();
        for (RailRoad railRoad : railRoads) {
            if (railRoad.getOwner() != null && railRoad.getOwner().equals(player)) {
                railRoad.setIncome(railRoad.getCost() / 4 + railRoad.getCost() * numberRailRoad(player, playingField) / 8);
            }
        }
    }

    public  String getName() {return name;}
    public int getCost() {return cost;}
    public int getIncome() {return income;}
    public void setIncome(int income) {
        this.income = income;
    }
}
