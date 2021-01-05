import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class two_zero_four_eight {



    class getTheHellOutOfHere implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            frame = null;
            test();
            randomTile();

        }
        
    }

    class new_horizons extends Frame implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
           //cunt
            if (gameOn && !gameover()) {
                
                switch (e.getKeyCode()) {
                    case 37://left
                    checkLeft(e.getKeyCode());
                        break;
                    
                    case 38://up
                    checkUp(e.getKeyCode());
                        break;
                    
                    case 39://right
                    checkRight(e.getKeyCode());                      
                        break;
                    
                    case 40://down
                    checkDown(e.getKeyCode());
                        break;
                    
                    default:
                        break;
                }
            }
            else if(gameOn && gameover()){
                    
                    endMotheFucka();//Sorry for that its 1 in the morning
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            
            randomTile();
            System.out.println(String.valueOf(e.getKeyCode()));
        }

    }
          
    public void checkLeft(int code){
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                check_empty_at_position(j, i, code);
            }
        }
    }

    public void checkUp(int code){
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                check_empty_at_position(i, j, code);
            }
        }
    }

    public void checkRight(int code){
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                check_empty_at_position(j, i, code);
            }
        }
    }

    public void checkDown(int code){
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <=3; j++) {
                check_empty_at_position(i, j, code);
            }
        }
    }
    
    public void check_empty_at_position(int row, int cell,int code){

        if (!board[row][cell].getText().isEmpty()) {
            switch (code) {
            case 37://left
            moveLeft(row,cell,Integer.parseInt(board[row][cell].getText()));
                break;
            
            case 38://up
            moveUp(row,cell,Integer.parseInt(board[row][cell].getText()));
                break;
            
            case 39://right
            moveRight(row,cell,Integer.parseInt(board[row][cell].getText()));
                break;
            
            case 40://down
            moveDown(row,cell,Integer.parseInt(board[row][cell].getText()));
                break;
            
            default:
                break;
        }
        }

        
    }


    



    public void moveLeft(int row,int cell,int tileValue){
        for (int c = 0; c <= cell; c++){
            if (board[row][c].getText().isEmpty()) {
                moveTile(row, c, tileValue);
                resetTile(row, cell);
                break;
            }
            else if(!board[row][c].getText().isEmpty() && !board[row][c].equals(board[row][cell]) && board[row][cell].getText().equals(board[row][c].getText())){
                updateTile(row, c, tileValue);  
                resetTile(row, cell);
                break;
            }
        }
    }

    public void moveRight(int row,int cell,int tileValue){
        for (int c = 3; c >= cell; c--) {
            if (board[row][c].getText().isEmpty()) {
                moveTile(row, c, tileValue);
                resetTile(row, cell);
                break;
            }
            else if(!board[row][c].getText().isEmpty() && !board[row][c].equals(board[row][cell]) && board[row][cell].getText().equals(board[row][c].getText())){
                updateTile(row, c, tileValue);  
                resetTile(row, cell);
                break;
            }
            
        }
    }

    public void moveUp(int row,int cell,int tileValue){
        for (int r = 0; r <= row; r++) {
            if (board[r][cell].getText().isEmpty()) {
                moveTile(r, cell, tileValue);
                resetTile(row, cell);
                break;
            }
            else if(!board[r][cell].getText().isEmpty() && !board[r][cell].equals(board[row][cell]) && board[row][cell].getText().equals(board[r][cell].getText())){
                updateTile(r, cell, tileValue);  
                resetTile(row, cell);
                break;
            }
            
        }
    }

    public void moveDown(int row,int cell,int tileValue){
        for (int r = 3; r >= row; r--) {
            if (board[r][cell].getText().isEmpty()) {
                moveTile(r, cell, tileValue);
                resetTile(row, cell);
                break;
            }
            else if(!board[r][cell].getText().isEmpty() && !board[r][cell].equals(board[row][cell]) && board[row][cell].getText().equals(board[r][cell].getText())){
                updateTile(r, cell, tileValue);  
                resetTile(row, cell);
                break;
            }
            
        }
    }

   

    //Variables
    JLabel [][] board = new JLabel[4][4];
    Color color [] = {
        new Color(217, 200, 180),
        new Color(209, 179, 142),
        new Color(245,183,49),
        new Color(219,111,68),
        new Color(219,91,68),
        new Color(214,63,36),
        new Color(255,189,66),
        new Color(255,201,102),
        new Color(255,189,66),
        new Color(255,195,54),
        new Color(242,183,44)
    };
    



    Random random = new Random();
    private boolean gameOn = false;
    public static void main(String[] args) {
        two_zero_four_eight game = new two_zero_four_eight();
        game.test();
        game.randomTile();
       
    }

    JFrame frame;

    public void randomTile(){
        int i = random.nextInt(4);
        int j = random.nextInt(4);
        if (board[i][j].getText().isEmpty()) {
            board[i][j].setBackground(color[1]);
        board[i][j].setText("2");
        }
        else{
            randomTile();
        }

        }
        
    
    

    public void test(){
        gameOn = true;
        frame = new JFrame("2048");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setResizable(false);
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new JLabel();
                
                board[i][j].setBackground(Color.GRAY);
                board[i][j].setOpaque(true);
                board[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                board[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
                frame.add(board[i][j]);
            }
        }
        frame.setLayout(new GridLayout(4,4));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new new_horizons());
        frame.pack();
        frame.setVisible(true);
        
    }

    //Make reset mathod
    public void resetTile(int row,int cell){
        board[row][cell].setText("");
        board[row][cell].setBackground(Color.GRAY);
    }
    
    public void moveTile(int row,int cell,int tileToBeMovedText){
        int count = 0;
        board[row][cell].setText(String.valueOf(tileToBeMovedText));
        for (int i = 2; i < 2048; i+=i) {
            if (board[row][cell].getText().equals(String.valueOf(i))) {
                board[row][cell].setBackground(color[count]);
            }
            count ++;
        }
    }

    public void updateTile(int row,int cell,int oldTileValue){
        int count = 0;
        board[row][cell].setText(String.valueOf(oldTileValue*2));
        for (int i = 2; i < 2048; i+=i) {
            if (board[row][cell].getText().equals(String.valueOf(i))) {
                board[row][cell].setBackground(color[count]);
            }
            count ++;
        }
        
    }

    public boolean gameover(){
        boolean result = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].getText().equals("2048")) {
                        result = true;
                    }
                }
            }
            return result;
    }

    public void endMotheFucka(){
        gameOn = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j].setVisible(false);
                frame.remove(board[i][j]);
            }
        }
        JLabel l = new JLabel();
        JButton btn = new JButton("Replay");
        l.setText("Out Of Moves! Game Over!");
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setLocation(200,50);
        btn.setLocation(200,150);
        btn.setHorizontalAlignment(SwingConstants.CENTER);
        btn.setMinimumSize(new Dimension(100,100));
        btn.addActionListener(new getTheHellOutOfHere());
        frame.add(l);
        frame.add(btn);
        frame.pack();
    }
    
}
