import javax.swing.*;
import java.awt.*;

/**
 * Created by 逢双 on 14-1-15.
 */
public class PokerGame {

    static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
    static final int FRAME_WIDTH = dm.width;
    static final int FRAME_HEIGHT = dm.height;
    static JFrame frame = new JFrame("Poker");
    static PokerPanel panel = new PokerPanel();
    static final int TIMER_DELAY = 12;
    static final int ONE_SECOND = 1000;
    static PokerTimer timer = new PokerTimer(TIMER_DELAY, new PokerTimerActionListener());

    public static void main(String arg[]){
        setFrame();
    }



    public static void setFrame(){
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

        frame.add(panel);
        frame.addMouseListener(new PokerMouseListener());
        frame.addMouseMotionListener(new PokerMouseListener());
    }



}
