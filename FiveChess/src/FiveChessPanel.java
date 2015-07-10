import javax.swing.*;
import java.awt.*;

/**
 * Created by 逢双 on 14-1-17.
 */
public class FiveChessPanel extends JPanel{

    static int width;
    static int height;
    static boolean turn;//true:white, false:black
    static final int FRAME_WIDTH = FiveChess.FRAME_WIDTH;
    static final int FRAME_HEIGHT = FiveChess.FRAME_HEIGHT;
    static final int MARGIN_WIDTH = 19;
    static final int MARGIN_HEIGHT = 19;
    static final int GRID_WIDTH = 34;
    static final int GRID_HEIGHT = 34;
    static final int GRID_ROW_NUMBER = 15;
    static final int GRID_COLUMN_NUMBER = 15;
    static final int TOTAL_NUMBER = GRID_COLUMN_NUMBER * GRID_ROW_NUMBER;
    static final int NEARBY = 20;
    static final int EMPTY = 0;
    static final int BLACK_ONE = 1;
    static final int BLACK_BLANK = 2;
    static final int WHITE_ONE = -1;
    static final int WHITE_BLANK = -2;
    static int[][] exist = new int[GRID_ROW_NUMBER][GRID_COLUMN_NUMBER];//-1:white, 0:empty, 1:black, 2:mouse location

    static final String PIC_FILE = "./pic/";
    static final String CHESSBOARD = "chessboard.png";
    static final String BLACK_ICON = "black.png";
    static final String WHITE_ICON = "white.png";
    static final String BLANK_BLACK_ICON = "blank_black.png";
    static final String BLANK_WHITE_ICON = "blank_white.png";
    static final String EMPTY_ICON = "empty.png";
    static final ImageIcon chessBoard = new ImageIcon(PIC_FILE + CHESSBOARD);
    static final ImageIcon blackIcon = new ImageIcon(PIC_FILE + BLACK_ICON);
    static final ImageIcon whiteIcon = new ImageIcon(PIC_FILE + WHITE_ICON);
    static final ImageIcon blankBlackIcon = new ImageIcon(PIC_FILE+ BLANK_BLACK_ICON);
    static final ImageIcon blankWhiteIcon = new ImageIcon(PIC_FILE+ BLANK_WHITE_ICON);
    static final ImageIcon emptyIcon = new ImageIcon(PIC_FILE+ EMPTY_ICON);

    public FiveChessPanel(){
        setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        setLayout(null);
    }
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        System.out.println("paint");
        repaint();
        g.drawImage(chessBoard.getImage(), 0, 0, this);
        for (int i = 0; i < GRID_ROW_NUMBER; i++) {
            for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                width = MARGIN_WIDTH + i * GRID_WIDTH - GRID_WIDTH / 2;
                height = MARGIN_HEIGHT + j * GRID_HEIGHT - GRID_HEIGHT / 2;
                switch (exist[i][j]){
                    case WHITE_BLANK : g.drawImage(blankWhiteIcon.getImage(), width, height, this);break;
                    case WHITE_ONE : g.drawImage(whiteIcon.getImage(), width, height,this);break;
                    case EMPTY : g.drawImage(emptyIcon.getImage(), width, height,this);break;
                    case BLACK_ONE : g.drawImage(blackIcon.getImage(), width, height, this);break;
                    case BLACK_BLANK : g.drawImage(blankBlackIcon.getImage(), width, height, this);break;
                    default:
                        System.out.println("case error");
                }
            }
        }
    }
}
