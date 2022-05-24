import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicToeTac implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel text_field = new JLabel();
    JButton[] buttons = new JButton[9];

    boolean player1_turn;


    TicToeTac(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,200,0));
        text_field.setFont(new Font("Ink Free", Font.BOLD,70));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("TicTacToe");
        text_field.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(text_field);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        first_turn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == buttons[i]) {
                if(player1_turn){
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1_turn=false;
                        text_field.setText("0 turn");
                        check();
                    }
                }
                else {
                    if(buttons[i].getText() == ""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("0");
                        player1_turn=true;
                        text_field.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void first_turn(){

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            player1_turn = true;
            text_field.setText("X turn");
        }
        else {
            player1_turn = false;
            text_field.setText("O turn");
        }
    }

    public void check() {
        // x win conditions
        if ( (buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X") ) {
            x_wins(0,1,2);
        }
        if ( (buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X") ) {
            x_wins(3,4,5);
        }
        if ( (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X") ) {
            x_wins(6,7,8);
        }
        if ( (buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X") ) {
            x_wins(0,3,6);
        }
        if ( (buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X") ) {
            x_wins(1,4,7);
        }
        if ( (buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X") ) {
            x_wins(2,5,8);
        }
        if ( (buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X") ) {
            x_wins(0,4,8);
        }
        if ( (buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X") ) {
            x_wins(2,4,6);
        }

        // 0 check win conditions
         if ( (buttons[0].getText()=="0") && (buttons[1].getText()=="0") && (buttons[2].getText()=="0") ) {
            y_wins(0,1,2);
        }
        if ( (buttons[3].getText()=="0") && (buttons[4].getText()=="0") && (buttons[5].getText()=="0") ) {
            y_wins(3,4,5);
        }
        if ( (buttons[6].getText()=="0") && (buttons[7].getText()=="0") && (buttons[8].getText()=="0") ) {
            y_wins(6,7,8);
        }
        if ( (buttons[0].getText()=="0") && (buttons[3].getText()=="0") && (buttons[6].getText()=="0") ) {
            y_wins(0,3,6);
        }
        if ( (buttons[1].getText()=="0") && (buttons[4].getText()=="0") && (buttons[7].getText()=="0") ) {
            y_wins(1,4,7);
        }
        if ( (buttons[2].getText()=="0") && (buttons[5].getText()=="0") && (buttons[8].getText()=="0") ) {
            y_wins(2,5,8);
        }
        if ( (buttons[0].getText()=="0") && (buttons[4].getText()=="0") && (buttons[8].getText()=="0") ) {
            y_wins(0,4,8);
        }
        if ( (buttons[2].getText()=="0") && (buttons[4].getText()=="0") && (buttons[6].getText()=="0") ) {
            y_wins(2,4,6);
        }

    }

    public void x_wins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("X wins");
    }

    public void y_wins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        text_field.setText("0 wins");
    }


}