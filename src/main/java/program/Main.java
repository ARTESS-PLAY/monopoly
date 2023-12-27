package program;

import program.gui.StartFrame;

import java.util.Locale;


public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);
        java.awt.EventQueue.invokeLater(() -> {
            new StartFrame().setVisible(true);
        });
    }
}
