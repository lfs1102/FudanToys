import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 逢双 on 14-1-15.
 */
public class PokerTimerActionListener implements ActionListener{

    private static Poker pokerList[] = new Poker[10000];
    private static int pokerNumber = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(pokerNumber < 10000){
            for(int i = 0; i < pokerNumber; i++){
                pokerList[i].move();
                PokerPanel.setX((int) pokerList[i].getX());
                PokerPanel.setY((int) pokerList[i].getY());
                PokerPanel.setCardNumber(pokerList[i].getNumber());
                PokerGame.panel.paintComponent(PokerGame.panel.getGraphics());
            }
        }

    }

    public static Poker[] getPokerList() {
        return pokerList;
    }

    public static int getPokerNumber() {
        return pokerNumber;
    }

    public static void setPokerList(Poker[] pokerList) {
        PokerTimerActionListener.pokerList = pokerList;
    }

    public static void setPokerNumber(int pokerNumber) {
        PokerTimerActionListener.pokerNumber = pokerNumber;
    }
}
