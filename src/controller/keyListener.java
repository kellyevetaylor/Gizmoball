package controller;
import model.Model;
import java.awt.event.*;

public class keyListener implements KeyListener {

    private final int globalKeyTrigger = KeyEvent.VK_SPACE;

    private Model m;

    public keyListener(Model m){
        this.m = m;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == globalKeyTrigger) {
            System.out.println("PRESSED and FIRED");
            m.fireBall();
        }
    }

    @Override
    public void keyReleased(KeyEvent space) {
        m.fireBall();
    }
}