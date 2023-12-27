package program.gui.gui_cells;

import program.logic.Cell;
import program.logic.Player;
import program.logic.PlayingField;
import program.logic.ceils.StartCell;
import program.logic.ceils.Street;
import program.logic.ceils.Tax;
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

public class GUITax extends GUICell {
    private JPanel mainPanel;
    private Image picture;
    private JLabel picLabel;
    private Tax tax;

    static {
        Function<Tax, GUITax> function = c -> {
            try {
                return new GUITax(c);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        };
        GUICellFactory.registerType(Tax.class, function);
    }


    public GUITax(Tax tax) throws IOException {
        this.tax = tax;
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        picture = ImageIO.read(new File("image\\74-10.png"));

        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void show(JPanel board, Player playerNow, PlayingField playingField){
        JOptionPane.showMessageDialog(board, " Вы заплатили налог в размере " + tax.getCost());
    }

    @Override
    public void setScaledInstance(int x, int y){
        mainPanel.setPreferredSize(new Dimension(x, y));
        picture = picture.getScaledInstance(x - 20, y - 20, Image.SCALE_SMOOTH);
        picLabel = new JLabel(new ImageIcon(picture));
        mainPanel.add(picLabel);
    }
    @Override
    public void update(){
    }
}
