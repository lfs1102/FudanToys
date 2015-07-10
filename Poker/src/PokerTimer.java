import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by 逢双 on 14-1-15.
 */
public class PokerTimer extends Timer{

    public PokerTimer(int delay, ActionListener listener) {
        super(delay, listener);
        this.start();
    }
}
