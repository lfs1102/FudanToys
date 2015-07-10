import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 逢双 on 14-1-15.
 */
public class PokerMouseListener extends MouseAdapter{

    private static int cardNumber;

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);

        if(cardNumber <= PokerPanel.totalNumber){
            cardNumber++;
        }
        else {
            cardNumber = 1;
        }

        PokerTimerActionListener.getPokerList()[PokerTimerActionListener.getPokerNumber()] =
                new Poker(cardNumber,
                        (int)(e.getX() - PokerPanel.getWIDTH() / 2),
                        (int)(e.getY() - PokerPanel.getHEIGHT() / 2));
        PokerTimerActionListener.setPokerNumber(PokerTimerActionListener.getPokerNumber() + 1);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);

        if(cardNumber <= PokerPanel.totalNumber){
            cardNumber++;
        }
        else {
            cardNumber = 1;
        }

        PokerTimerActionListener.getPokerList()[PokerTimerActionListener.getPokerNumber()] =
                new Poker(cardNumber,
                        (int)(e.getX() - PokerPanel.getWIDTH() / 2),
                        (int)(e.getY() - PokerPanel.getHEIGHT() / 2));
        PokerTimerActionListener.setPokerNumber(PokerTimerActionListener.getPokerNumber() + 1);
    }


}
