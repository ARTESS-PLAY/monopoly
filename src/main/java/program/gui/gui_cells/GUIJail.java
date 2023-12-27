package program.gui.gui_cells;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;
import program.logic.ceils.FreeParking;
import program.logic.ceils.GoToJail;
import program.logic.ceils.Jail;
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

public class GUIJail extends GUICell {
    private JPanel mainPanel;
    private Image picture;
    private JLabel picLabel;

    static {
        Function<Jail, GUIJail> function = c -> {
            try {
                return new GUIJail(c);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };
        GUICellFactory.registerType(Jail.class, function);
    }

    public GUIJail(Jail cell) throws IOException {
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(new BorderLayout());
        picture = ImageIO.read(new File("image\\76.png"));
        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void show(JPanel board, Player playerNow, PlayingField playingField){
        int skipping = playerNow.getSkipping();
        if (skipping == 3 || skipping == 2) {
            JOptionPane.showMessageDialog(board, " Вы пропускайте еще " + skipping + " хода ");
        } else if (skipping == 1) JOptionPane.showMessageDialog(board, " Вы пропускайте еще " + skipping + " ход ");
    }

    @Override
    public void setScaledInstance(int x, int y){
        mainPanel.setPreferredSize(new Dimension(x, y));
        picture = picture.getScaledInstance(x - 20, y - 20, Image.SCALE_SMOOTH);
        picLabel = new JLabel(new ImageIcon(picture));
        mainPanel.add(picLabel, BorderLayout.CENTER);
    }
    @Override
    public void update(){
    }
}
