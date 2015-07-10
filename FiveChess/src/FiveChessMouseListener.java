import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by 逢双 on 14-1-16.
 */
public class FiveChessMouseListener extends MouseAdapter{

    private int X;
    private int Y;
    private int row;
    private int column;
    private int nearX;
    private int nearY;
    private boolean show;
    private boolean blackWin = false;
    private boolean whiteWin = false;

    static int total = 0;
    static final int FIVE = 5;
    static final int MARGIN_WIDTH = FiveChessPanel.MARGIN_WIDTH;
    static final int MARGIN_HEIGHT = FiveChessPanel.MARGIN_HEIGHT;
    static final int GRID_WIDTH = FiveChessPanel.GRID_WIDTH;
    static final int GRID_HEIGHT = FiveChessPanel.GRID_HEIGHT;
    static final int GRID_ROW_NUMBER = FiveChessPanel.GRID_ROW_NUMBER;
    static final int GRID_COLUMN_NUMBER = FiveChessPanel.GRID_COLUMN_NUMBER;
    static final int NEARBY = FiveChessPanel.NEARBY;
    static final int EMPTY = FiveChessPanel.EMPTY;
    static final int BLACK_ONE = FiveChessPanel.BLACK_ONE;
    static final int BLACK_BLANK = FiveChessPanel.BLACK_BLANK;
    static final int WHITE_ONE = FiveChessPanel.WHITE_ONE;
    static final int WHITE_BLANK = FiveChessPanel.WHITE_BLANK;
    static int[][] exist = FiveChessPanel.exist;
    static int[][][] record = new int[FiveChessPanel.TOTAL_NUMBER][GRID_ROW_NUMBER][GRID_COLUMN_NUMBER];

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        location(e);
        if(e.getButton() == e.BUTTON1){
            record();
            if(blackWin || whiteWin){
                blackWin = false;
                whiteWin = false;
                FiveChessPanel.turn = false;
                for (int i = 0; i < GRID_ROW_NUMBER; i++) {
                    for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                        exist[i][j] = EMPTY;
                    }
                }
            }
            else {
                if(exist[row][column] != WHITE_ONE && exist[row][column] != BLACK_ONE){
                    if(FiveChessPanel.turn){
                /*white*/
                        FiveChessPanel.turn = false;
                        exist[row][column] = WHITE_ONE;
                    }
                    else{
                /*black*/
                        FiveChessPanel.turn = true;
                        exist[row][column] = BLACK_ONE;
                    }
                    judge();

                }
            }
        }
        else if(e.getButton() == e.BUTTON3 &&  total > 0 && !whiteWin && !blackWin){
            for (int i = 0; i < GRID_ROW_NUMBER; i++) {
                for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                    exist[i][j] = record[total - 1][i][j];
                }
            }
            FiveChessPanel.turn = !FiveChessPanel.turn;
            total--;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);

        location(e);

        if(!blackWin && !whiteWin){
            if(Math.abs(nearX) <= NEARBY && Math.abs(nearY) <= NEARBY){
                show = true;
            }
            else {
                show = false;
            }

            for (int i = 0; i < GRID_ROW_NUMBER; i++) {
                for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                    if(exist[i][j] == BLACK_BLANK || exist[i][j] == WHITE_BLANK)exist[i][j] = EMPTY;
                }
            }
            if(show && exist[row][column] != WHITE_ONE && exist[row][column] != BLACK_ONE){
                if(FiveChessPanel.turn)exist[row][column] = WHITE_BLANK;
                else exist[row][column] = BLACK_BLANK;
            }
        }

    }

    public void location(MouseEvent e){
        X = e.getX();
        Y = e.getY();
        row = (X - MARGIN_WIDTH / BLACK_BLANK) / GRID_WIDTH;
        column = (Y - MARGIN_HEIGHT / BLACK_BLANK) / GRID_HEIGHT;
        nearX = (X - MARGIN_WIDTH / BLACK_BLANK) % GRID_WIDTH;
        nearY = (Y - MARGIN_HEIGHT / BLACK_BLANK) % GRID_HEIGHT;
    }

    public void judge(){

        int[][] judge = new int[GRID_ROW_NUMBER + 8][GRID_COLUMN_NUMBER + 8];
        for (int i = 0; i < GRID_ROW_NUMBER; i++) {
            for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                judge[i + 4][j + 4] = exist[i][j];
            }
        }
        for (int i = FIVE - 1; i < GRID_ROW_NUMBER + FIVE - 1; i++) {
            for (int j = FIVE - 1; j < GRID_COLUMN_NUMBER + FIVE - 1; j++) {
                if(judge[i][j] == 1 && judge[i-1][j] == 1 && judge[i-2][j] == 1 && judge[i-3][j] == 1 && judge[i-4][j] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i+1][j] == 1 && judge[i+2][j] == 1 && judge[i+3][j] == 1 && judge[i+4][j] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i][j-1] == 1 && judge[i][j-2] == 1 && judge[i][j-3] == 1 && judge[i][j-4] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i][j+1] == 1 && judge[i][j+2] == 1 && judge[i][j+3] == 1 && judge[i][j+4] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i-1][j-1] == 1 && judge[i-2][j-2] == 1 && judge[i-3][j-3] == 1 && judge[i-4][j-4] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i+1][j+1] == 1 && judge[i+2][j+2] == 1 && judge[i+3][j+3] == 1 && judge[i+4][j+4] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i+1][j-1] == 1 && judge[i+2][j-2] == 1 && judge[i+3][j-3] == 1 && judge[i+4][j-4] == 1)blackWin = true;
                if(judge[i][j] == 1 && judge[i-1][j+1] == 1 && judge[i-2][j+2] == 1 && judge[i-3][j+3] == 1 && judge[i-4][j+4] == 1)blackWin = true;
            }
        }
        if(blackWin)JOptionPane.showMessageDialog(null, "Black Win!");

        for (int i = FIVE - 1; i < GRID_ROW_NUMBER + FIVE -1; i++) {
            for (int j = FIVE - 1; j < GRID_COLUMN_NUMBER + FIVE -1; j++) {
                if(judge[i][j] == -1 && judge[i-1][j] == -1 && judge[i-2][j] == -1 && judge[i-3][j] == -1 && judge[i-4][j] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i+1][j] == -1 && judge[i+2][j] == -1 && judge[i+3][j] == -1 && judge[i+4][j] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i][j-1] == -1 && judge[i][j-2] == -1 && judge[i][j-3] == -1 && judge[i][j-4] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i][j+1] == -1 && judge[i][j+2] == -1 && judge[i][j+3] == -1 && judge[i][j+4] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i-1][j-1] == -1 && judge[i-2][j-2] == -1 && judge[i-3][j-3] == -1 && judge[i-4][j-4] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i+1][j+1] == -1 && judge[i+2][j+2] == -1 && judge[i+3][j+3] == -1 && judge[i+4][j+4] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i+1][j-1] == -1 && judge[i+2][j-2] == -1 && judge[i+3][j-3] == -1 && judge[i+4][j-4] == -1)whiteWin = true;
                if(judge[i][j] == -1 && judge[i-1][j+1] == -1 && judge[i-2][j+2] == -1 && judge[i-3][j+3] == -1 && judge[i-4][j+4] == -1)whiteWin = true;
            }
        }
        if(whiteWin)JOptionPane.showMessageDialog(null, "White Win!");
        
        boolean tie = true;
        for (int i = 0; i < GRID_ROW_NUMBER; i++) {
            for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                if(exist[i][j] != BLACK_ONE && exist[i][j] != WHITE_ONE){
                    tie = false;
                }
            }
        }
        if(tie && !blackWin && !whiteWin){
            JOptionPane.showMessageDialog(null, "Tie!");
        }
    }

    public void record(){
        for (int i = 0; i < GRID_ROW_NUMBER; i++) {
            for (int j = 0; j < GRID_COLUMN_NUMBER; j++) {
                record[total][i][j] = exist[i][j];
            }
        }
        total++;
    }
}