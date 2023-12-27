package program.gui;

import program.logic.Player;
import program.logic.PlayingField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public abstract class GUICell extends JPanel {

    public GUICell() {
        this.setLayout(new BorderLayout(0,0));
        this.setBorder(new LineBorder(Color.WHITE, 1));
    }

    public void show(JPanel board, Player playerNow, PlayingField playingField){
    }
    public void setScaledInstance(int x, int y){
    }
    public void update() {
    }
}
