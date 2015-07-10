import javax.swing.*;

/**
 * Created by 逢双 on 14-1-16.
 */
public class FiveChess {

    static final int FRAME_WIDTH = 514;
    static final int FRAME_HEIGHT = 514;

    static final JFrame frame = new JFrame("Five Chess");

    public static void main(String[] arg){
        setFrame();
    }

    private static void setFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        FiveChessMouseListener listener = new FiveChessMouseListener();
        frame.addMouseListener(listener);
        frame.addMouseMotionListener(listener);
        frame.add(new FiveChessPanel());
        frame.setVisible(true);
    }
}
