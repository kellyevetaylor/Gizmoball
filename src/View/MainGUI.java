package View;

import Controller.MainGUIListener;
import Model.Model;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class MainGUI extends JFrame {
    private Model model;
    private MainGUIListener controller;
    private JPanel viewMode;

    public MainGUI(Model model){
        this.model = model;
        controller = new MainGUIListener(this);
        init();
    }

    private void init() {
        makeMenuBar();
        viewMode = new RunView(model);
        setContentPane(viewMode);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void makeMenuBar() {
        setTitle("GizmoBall - Run Mode");
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem open = new JMenuItem("Load");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        file.add(open);
        file.add(save);
        file.add(exit);
        menuBar.add(file);
        exit.addActionListener((ActionEvent event) -> System.exit(0));

        ButtonGroup modeGroup = new ButtonGroup();
        JMenu modeMenu = new JMenu("Mode");
        JRadioButtonMenuItem buildMode = new JRadioButtonMenuItem("Build Mode");
        JRadioButtonMenuItem runMode = new JRadioButtonMenuItem("Run Mode");
        modeMenu.add(buildMode);
        modeMenu.add(runMode);
        runMode.setSelected(true);

        buildMode.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("....switching to build mode....");
                setTitle("GizmoBall - Build Mode");
                viewMode.setVisible(false);
                viewMode = new BuildView(model);
                viewMode.setVisible(true);
                setContentPane(viewMode);
            }
        });
        runMode.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                System.out.println("....switching to run mode....");
                setTitle("GizmoBall - Run Mode");
                viewMode.setVisible(false);
                viewMode = new RunView(model);
                viewMode.setVisible(true);
                setContentPane(viewMode);
            }
        });

        modeGroup.add(buildMode);
        modeGroup.add(runMode);
        menuBar.add(modeMenu);
        setJMenuBar(menuBar);
    }
}