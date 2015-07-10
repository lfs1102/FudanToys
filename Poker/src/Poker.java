/**
 * Created by 逢双 on 14-1-15.
 */
public class Poker {

    private int number;
    private double X;
    private double Y;
    private int speedX;
    private int speedY;
    private final int g = 20;
    private final double RATE = 0.7;
    private boolean exist;
    private int SPECIAL;

    public Poker(int number, int X, int Y){
        this.number = number;
        this.X = X;
        this.Y = Y;
        exist = true;
        speedX = (int)(Math.random() * 800 - 400);
        if(speedX > 0) speedX += 150;
        else speedX -= 150;
        speedY = (int)(Math.random() * 600);
    }

    /*move poker*/
    public void move(){

        speedY -= g;
//        System.out.print(speedX+"\n");
        /*judge whether poker has gone out of range*/
        if(X <= 0 - PokerPanel.getWIDTH() || X >= PokerGame.FRAME_WIDTH){
            exist = false;
        }

        else {
            /*change X*/
            X -= speedX * PokerGame.TIMER_DELAY / PokerGame.ONE_SECOND;

            /*change Y*/
            if((Y + PokerPanel.getHEIGHT()) >= PokerGame.FRAME_HEIGHT && SPECIAL > 3){
                speedY = (int)((-speedY) * RATE);
                SPECIAL = 0;

            }
            Y -= speedY * PokerGame.TIMER_DELAY / PokerGame.ONE_SECOND;
        }

        SPECIAL++;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public int getNumber() {
        return number;
    }

    public boolean isExist() {
        return exist;
    }
}
