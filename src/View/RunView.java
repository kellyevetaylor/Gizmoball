package View;

import Model.LeftFlipper;
import Model.Model;
import Model.RightFlipper;
import org.omg.CORBA.BAD_INV_ORDER;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

class RunView extends JPanel {
    private Model model;
    private JLabel statusbar;

    RunView(Model model) {
        this.model = model;
        model.addGizmo(new LeftFlipper(100, 100)); // hard-coding for testing
        model.addGizmo(new RightFlipper(277, 100));
        System.out.println("now in the runview content pane");
        init();
    }

     private void init() {

        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(10, 1, 5, 5));
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));
        makeButtons(buttonPanel);
        add(buttonPanel, BorderLayout.EAST);

        JPanel board = new JPanel(new GridLayout(20,20));
        board.setBorder(BorderFactory.createLineBorder(Color.black,1));
        add(board, BorderLayout.CENTER);

        statusbar = new JLabel("Run Mode");
        statusbar.setBorder(BorderFactory.createEtchedBorder());
        add(statusbar, BorderLayout.SOUTH);

        //add(new GameBoard(model));

    }

    private void makeButtons(JPanel panel) {
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        JButton startB = new JButton("Start");
        JButton stopB = new JButton("Stop");
        JButton tickB = new JButton("Tick");
        panel.add(startB);
        panel.add(stopB);
        panel.add(tickB);
    }

}
