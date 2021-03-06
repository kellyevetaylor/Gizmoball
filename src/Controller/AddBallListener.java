package Controller;

import Model.Model;

import View.GameBoard;

import javax.swing.event.MouseInputListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import View.BuildView;

public class AddBallListener implements ActionListener {

    private Model model;
    private int x,y,x1,y1;
    private GameBoard gameBoard;
    private MouseInputListener mouseInputListener;
    double vx, vy;
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
                vx = buildView.getBallxv();
                vy = buildView.getBallxy();

                if(vx > -1000 && vx < 1000 && vy > -1000 && vx < 1000) {
                    x = e.getX();
                    y = e.getY();
                    if (model.checkIfValidBallSpawn(x/30, y/30) && x < 600 && x > 0 && y < 600 && y > 0) {
                        model.addBall(x, y, vx, vy);
                    } else if(!(model.checkIfValidBallSpawn(x/30, y/30)))
                        buildView.occupiedSpaceAlert();
                    else {
                        if (!(model.checkIfValidBallSpawn(x/30, y/30) && x < 600 && x > 0 && y < 600 && y > 0));
                        buildView.ballOutsideGridZoneAlert();
                    }
                }else{
                    buildView.invalidVelocityAlert();
                }
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

