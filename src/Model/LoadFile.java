package Model;

import javax.swing.*;
import java.io.*;


public class LoadFile {

    private JFileChooser fc;
    private static final String FILE_PATH = System.getProperty("user.home") + "/Documents";
    private Model model;

    public LoadFile(Model model) {
        fc = new JFileChooser(FILE_PATH);
        this.model = model;
        try {
            getLoadFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    void getLoadFile() throws FileNotFoundException {
        int returnValue = fc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION){
            System.out.println("Success!");
            tokenizeFile(); }
        else if (returnValue == JFileChooser.CANCEL_OPTION){
            System.out.println("Cancelled");
        }
        else {
            System.out.println("Failed");
        }
    }

    private void tokenizeFile(){

        int x = 0, y = 0, x1, y1, x2, y2, kNo;
        double d, d1, d2, d3;
        String lineRead, gName, sConnect1, sConnect2, upDown;
        IGizmo gConnect1, gConnect2;

        try {
            FileReader fileReader = new FileReader(fc.getSelectedFile());
            BufferedReader buffReader = new BufferedReader(fileReader);

            lineRead = buffReader.readLine();
            while (lineRead != null) {
                String[] gizmoGroup = lineRead.split(" ");
                switch (gizmoGroup[0]) {
                    case "Square":
                        x = Integer.parseInt(gizmoGroup[2]);
                        y = Integer.parseInt(gizmoGroup[3]);
                        model.addGizmo(new Square(x, y));
                        break;
                    case "Circle":
                        x = Integer.parseInt(gizmoGroup[2]);
                        y = Integer.parseInt(gizmoGroup[3]);
                        model.addGizmo(new Circle(x, y));
                        break;
                    case "Triangle":
                        x = Integer.parseInt(gizmoGroup[2]);
                        y = Integer.parseInt(gizmoGroup[3]);
                        model.addGizmo(new Triangle(x, y, 0));
                        break;
                    case "RightFlipper":
                        x = Integer.parseInt(gizmoGroup[2]);
                        y = Integer.parseInt(gizmoGroup[3]);
                        model.addGizmo(new RightFlipper(x + 1, y ));
                        break;
                    case "LeftFlipper":
                        x = Integer.parseInt(gizmoGroup[2]);
                        y = Integer.parseInt(gizmoGroup[3]);
                        model.addGizmo(new LeftFlipper(x, y));
                        break;
                    case "Absorber":
                       //System.out.println("found");
                        gName = gizmoGroup[1];
                        x1 = Integer.parseInt(gizmoGroup[2]);
                        y1 = Integer.parseInt(gizmoGroup[3]);
                        x2 = Integer.parseInt(gizmoGroup[4]);
                        y2 = Integer.parseInt(gizmoGroup[5]);
                        model.addGizmo(new Absorber(x1, y1, x2-x1, y2-y1));
                        break;
                    case "Ball":
                        gName = gizmoGroup[1];
                        d = Double.parseDouble(gizmoGroup[2]);
                        d1 = Double.parseDouble(gizmoGroup[3]);
                        d2 = Double.parseDouble(gizmoGroup[4]);
                        d3 = Double.parseDouble(gizmoGroup[5]);
                        System.out.println("x = " + d);
                        System.out.println("y = " + d1);
                        System.out.println("vx = " + d2);
                        System.out.println("vy = " + d3);
                        model.addBall(d, d1, d2, d3); // without * 30 it wont scale to L
                        break;
                    case "Rotate":
                       // System.out.println("found Rotate");
                        gName = gizmoGroup[1];
                        model.rotateGizmo(model.getGizmo(x, y));
                        break;
                        /*
                        q 81    w 87    space 32

                         */
                    case "KeyConnect":
                        //System.out.println("found KeyConnect");
                        kNo = Integer.parseInt(gizmoGroup[2]);
                        upDown = gizmoGroup[3];
                        gConnect1 = model.getGizmos().get(model.getGizmos().size()-1);;
                        //System.out.println("Should connect key " + kNo + " to gizmo " + gConnect1.toString());
                        model.addKeyConnection(kNo, gConnect1);
                        break;
                    case "Connect":
                        System.out.println("found Connect");
                        sConnect1 = gizmoGroup[1];
                        sConnect2 = gizmoGroup[2];
                        break;

                }
                lineRead = buffReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
