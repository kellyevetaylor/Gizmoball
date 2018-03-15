package Controller;

import Model.Model;
import Model.Ball;
import View.GameBoard;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import View.BuildView;

public class AddBallListener implements ActionListener {

    private Model model;
    private int x,y;
    private GameBoard gameBoard;
    private MouseInputListener mouseInputListener;
    double xv,xy;
    BuildView buildView;

    public AddBallListener(Model model, GameBoard gameBoard, BuildView bv){
        this.model = model;
        this.gameBoard = gameBoard;
        this.buildView = bv;

        mouseInputListener = new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                buildView.ballVelocityAlert();
                xv = buildView.getBallxv();
                xy = buildView.getBallxy();
                System.out.println(xv);
                System.out.println(xy);
                x = e.getX();
                y = e.getY();
                model.addBall(x,y,xv,xy);
                e.consume();
                gameBoard.removeMouseListener(this);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameBoard.addMouseListener(mouseInputListener);
    }
}

