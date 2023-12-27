package program.gui.gui_cells;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;
import program.logic.ceils.Chance;
import program.logic.ceils.FreeParking;
import program.logic.ceils.GoToJail;
import program.gui.GUICell;
import program.gui.GUICellFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

public class GUIGoToJail extends GUICell {
    private JPanel mainPanel;
    private Image picture;
    private JLabel picLabel;

    static {
        Function<GoToJail, GUIGoToJail> function = c -> {
            try {
                return new GUIGoToJail(c);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };
        GUICellFactory.registerType(GoToJail.class, function);
    }

    public GUIGoToJail(GoToJail cell) throws IOException {


        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);

        picture = ImageIO.read(new File("image/go_to_jail_icon.png"));
        picLabel = new JLabel(new ImageIcon(picture));

        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void show(JPanel board, Player playerNow, PlayingField playingField){
    }

    @Override
    public void setScaledInstance(int x, int y){
        mainPanel.setPreferredSize(new Dimension(x, y));
        //mainPanel.setBackground(Color.BLACK);
        picture = picture.getScaledInstance(x - 10, y - 10, Image.SCALE_SMOOTH);
        picLabel = new JLabel(new ImageIcon(picture));
        mainPanel.add(picLabel);
    }
    @Override
    public void update(){
    }
}
