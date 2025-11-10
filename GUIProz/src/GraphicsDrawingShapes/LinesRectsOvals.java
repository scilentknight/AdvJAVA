package GraphicsDrawingShapes;


import javax.swing.JFrame;

public class LinesRectsOvals{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        LinesRectsOvalsJPanel lro = new LinesRectsOvalsJPanel();
        frame.add(lro);
        frame.setVisible(true);
    }


}
