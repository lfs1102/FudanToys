import javax.swing.*;
import java.awt.*;

/**
 * Created by 逢双 on 14-1-15.
 */
public class PokerPanel extends JPanel{

    private static int X;
    private static int Y;
    private static int WIDTH = 42;
    private static int HEIGHT = 60;
    private static int cardNumber;
    private static boolean printBackground = true;
    public static final int totalNumber = 54;
    static String PIC_FILE = "./pic/poker/";
    static ImageIcon POKER[] = new ImageIcon[totalNumber + 1];

    public PokerPanel(){
        loadPic();
        setBounds(0, 0, PokerGame.FRAME_WIDTH, PokerGame.FRAME_HEIGHT);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //super.paintComponent(g);
        if(cardNumber > 0 && cardNumber < totalNumber + 1){
            g.drawImage(POKER[cardNumber].getImage(), X, Y, WIDTH, HEIGHT, this);
        }
        if(printBackground){
            g.drawImage(new ImageIcon(PIC_FILE + "background.png").getImage(), 0, 0, PokerGame.FRAME_WIDTH, PokerGame.FRAME_HEIGHT, this);
            printBackground = false;
        }
    }


    public static void loadPic(){
        for(int i = 1; i <= totalNumber; i++){
            POKER[i] = new ImageIcon(PIC_FILE + i + ".jpg");
        }
    }


    public static int getCardNumber() {
        return cardNumber;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setX(int x) {
        X = x;
    }

    public static void setY(int y) {
        Y = y;
    }

    public static void setCardNumber(int cardNumber) {
        PokerPanel.cardNumber = cardNumber;
    }
}
