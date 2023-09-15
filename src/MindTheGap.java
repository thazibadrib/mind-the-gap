import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MindTheGap implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[16];
	boolean player1_turn;
	
	MindTheGap(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(new Color(255,255,255));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setBackground(new Color(200,200,200));
		textfield.setForeground(new Color(0,0,0));
		textfield.setFont(new Font("Ink Free", Font.BOLD,50));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Mind The Gap");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,600,50);
		
		button_panel.setLayout(new GridLayout(4,4));
		button_panel.setBackground(new Color(255,255,255));
		
		for (int i=0; i<16;i++) {
			buttons[i]=new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD,100));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn(); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<16;i++) {
			if(e.getSource()==buttons[i]) {
				if(player1_turn) {
					if (buttons[i].getText()=="") {
						buttons[i].setBackground(new Color(255,0,0));
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("1");
						player1_turn=false;
						textfield.setText("Player 2's turn");
						check();
						
					}
				}
				
				else {
					if (buttons[i].getText()=="") {
						buttons[i].setText("2");
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setBackground(new Color(0,0,255));
						player1_turn=true;
						textfield.setText("Player 1's turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void firstTurn() {
		
		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		if (random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("Player 1's turn");
		}
		else {
			player1_turn=false;
			textfield.setText("Player 2's turn");
		}
		
	}
	
	public void check() {
		//checks one win conditions
		
		//R1
		if((buttons[0].getText()=="2")&&
			buttons[1].getText()=="2")
		{
			oneWins(0,1);
		}
		if((buttons[1].getText()=="2")&&
				buttons[2].getText()=="2")
			{
				oneWins(1,2);
			}
		if((buttons[2].getText()=="2")&&
				buttons[3].getText()=="2")
			{
				oneWins(2,3);
			}
		//R2
		if((buttons[4].getText()=="2")&&
				buttons[5].getText()=="2")
			{
				oneWins(4,5);
			}
		if((buttons[5].getText()=="2")&&
				buttons[6].getText()=="2")
			{
				oneWins(5,6);
			}
		if((buttons[6].getText()=="2")&&
				buttons[7].getText()=="2")
			{
				oneWins(6,7);
			}
		
		//R3
		
		if((buttons[8].getText()=="2")&&
				buttons[9].getText()=="2")
			{
				oneWins(8,9);
			}
		if((buttons[9].getText()=="2")&&
				buttons[10].getText()=="2")
			{
				oneWins(9,10);
			}
		if((buttons[10].getText()=="2")&&
				buttons[11].getText()=="2")
			{
				oneWins(10,11);
			}
		
		//R4
		
		if((buttons[12].getText()=="2")&&
				buttons[13].getText()=="2")
			{
				oneWins(12,13);
			}
		if((buttons[13].getText()=="2")&&
				buttons[14].getText()=="2")
			{
				oneWins(13,14);
			}
		if((buttons[14].getText()=="2")&&
				buttons[15].getText()=="2")
			{
				oneWins(14,15);
			}
		
		//columns
		
		
		//C1
		
		if((buttons[0].getText()=="2")&&
				buttons[4].getText()=="2")
			{
				oneWins(0,4);
			}
		if((buttons[4].getText()=="2")&&
				buttons[8].getText()=="2")
			{
				oneWins(4,8);
			}
		if((buttons[8].getText()=="2")&&
				buttons[12].getText()=="2")
			{
				oneWins(8,12);
			}
		
		//C2
		
		if((buttons[1].getText()=="2")&&
				buttons[5].getText()=="2")
			{
				oneWins(1,5);
			}
		if((buttons[5].getText()=="2")&&
				buttons[9].getText()=="2")
			{
				oneWins(5,9);
			}
		if((buttons[9].getText()=="2")&&
				buttons[13].getText()=="2")
			{
				oneWins(9,13);
			}
		
		//C3
		
		if((buttons[2].getText()=="2")&&
				buttons[6].getText()=="2")
			{
				oneWins(2,6);
			}
		if((buttons[6].getText()=="2")&&
				buttons[10].getText()=="2")
			{
				oneWins(6,10);
			}
		if((buttons[10].getText()=="2")&&
				buttons[14].getText()=="2")
			{
				oneWins(10,14);
			}
		
		//C4
		
		if((buttons[3].getText()=="2")&&
				buttons[7].getText()=="2")
			{
				oneWins(11,15);
			}
		if((buttons[7].getText()=="2")&&
				buttons[11].getText()=="2")
			{
				oneWins(7,11);
			}
		if((buttons[11].getText()=="2")&&
				buttons[15].getText()=="2")
			{
				oneWins(11,15);
			}
		
		//diagonal L-R
		if((buttons[8].getText()=="2")&&
				buttons[13].getText()=="2")
			{
				oneWins(8,13);
			}
		if((buttons[0].getText()=="2")&&
				buttons[1].getText()=="2")
			{
				oneWins(0,1);
			}
		if((buttons[4].getText()=="2")&&
				buttons[9].getText()=="2")
			{
				oneWins(4,9);
			}
		if((buttons[9].getText()=="2")&&
				buttons[14].getText()=="2")
			{
				oneWins(9,14);
			}
		if((buttons[0].getText()=="2")&&
				buttons[5].getText()=="2")
			{
				oneWins(0,5);
			}
		if((buttons[5].getText()=="2")&&
				buttons[10].getText()=="2")
			{
				oneWins(5,10);
			}
		if((buttons[10].getText()=="2")&&
				buttons[15].getText()=="2")
			{
				oneWins(10,15);
			}
		if((buttons[1].getText()=="2")&&
				buttons[6].getText()=="2")
			{
				oneWins(1,6);
			}
		if((buttons[6].getText()=="2")&&
				buttons[11].getText()=="2")
			{
				oneWins(6,11);
			}
		if((buttons[2].getText()=="2")&&
				buttons[7].getText()=="2")
			{
				oneWins(2,7);
			}
		
		
		//diagonal R-L
		
		if((buttons[11].getText()=="2")&&
				buttons[14].getText()=="2")
			{
				oneWins(11,14);
			}
		if((buttons[7].getText()=="2")&&
				buttons[10].getText()=="2")
			{
				oneWins(7,10);
			}
		if((buttons[10].getText()=="2")&&
				buttons[13].getText()=="2")
			{
				oneWins(10,13);
			}
		if((buttons[3].getText()=="2")&&
				buttons[6].getText()=="2")
			{
				oneWins(3,6);
			}
		if((buttons[6].getText()=="2")&&
				buttons[9].getText()=="2")
			{
				oneWins(6,9);
			}
		if((buttons[9].getText()=="2")&&
				buttons[12].getText()=="2")
			{
				oneWins(9,12);
			}
		if((buttons[2].getText()=="2")&&
				buttons[5].getText()=="2")
			{
				oneWins(2,5);
			}
		if((buttons[5].getText()=="2")&&
				buttons[8].getText()=="2")
			{
				oneWins(5,8);
			}
		if((buttons[1].getText()=="2")&&
				buttons[4].getText()=="2")
			{
				oneWins(1,4);
			}
		
		
		//check two win conditions
		
		//R1
				if((buttons[0].getText()=="1")&&
					buttons[1].getText()=="1")
				{
					twoWins(0,1);
				}
				if((buttons[1].getText()=="1")&&
						buttons[2].getText()=="1")
					{
						twoWins(1,2);
					}
				if((buttons[2].getText()=="1")&&
						buttons[3].getText()=="1")
					{
						twoWins(2,3);
					}
				//R2
				if((buttons[4].getText()=="1")&&
						buttons[5].getText()=="1")
					{
						twoWins(4,5);
					}
				if((buttons[5].getText()=="1")&&
						buttons[6].getText()=="1")
					{
						twoWins(5,6);
					}
				if((buttons[6].getText()=="1")&&
						buttons[7].getText()=="1")
					{
						twoWins(6,7);
					}
				
				//R3
				
				if((buttons[8].getText()=="1")&&
						buttons[9].getText()=="1")
					{
						twoWins(8,9);
					}
				if((buttons[9].getText()=="1")&&
						buttons[10].getText()=="1")
					{
						twoWins(9,10);
					}
				if((buttons[10].getText()=="1")&&
						buttons[11].getText()=="1")
					{
						twoWins(10,11);
					}
				
				//R4
				
				if((buttons[12].getText()=="1")&&
						buttons[13].getText()=="1")
					{
						twoWins(12,13);
					}
				if((buttons[13].getText()=="1")&&
						buttons[14].getText()=="1")
					{
						twoWins(13,14);
					}
				if((buttons[14].getText()=="1")&&
						buttons[15].getText()=="1")
					{
						twoWins(14,15);
					}
				
				//columns
				
				
				//C1
				
				if((buttons[0].getText()=="1")&&
						buttons[4].getText()=="1")
					{
						twoWins(0,4);
					}
				if((buttons[4].getText()=="1")&&
						buttons[8].getText()=="1")
					{
						twoWins(4,8);
					}
				if((buttons[8].getText()=="1")&&
						buttons[12].getText()=="1")
					{
						twoWins(8,12);
					}
				
				//C2
				
				if((buttons[1].getText()=="1")&&
						buttons[5].getText()=="1")
					{
						twoWins(1,5);
					}
				if((buttons[5].getText()=="1")&&
						buttons[9].getText()=="1")
					{
						twoWins(5,9);
					}
				if((buttons[9].getText()=="1")&&
						buttons[13].getText()=="1")
					{
						twoWins(9,13);
					}
				
				//C3
				
				if((buttons[2].getText()=="1")&&
						buttons[6].getText()=="1")
					{
						twoWins(2,6);
					}
				if((buttons[6].getText()=="1")&&
						buttons[10].getText()=="1")
					{
						twoWins(6,10);
					}
				if((buttons[10].getText()=="1")&&
						buttons[14].getText()=="1")
					{
						twoWins(10,14);
					}
				
				//C4
				
				if((buttons[3].getText()=="1")&&
						buttons[7].getText()=="1")
					{
						twoWins(11,15);
					}
				if((buttons[7].getText()=="1")&&
						buttons[11].getText()=="1")
					{
						twoWins(7,11);
					}
				if((buttons[11].getText()=="1")&&
						buttons[15].getText()=="1")
					{
						twoWins(11,15);
					}
				
				//diagonal L-R
				if((buttons[8].getText()=="1")&&
						buttons[13].getText()=="1")
					{
						twoWins(8,13);
					}
				if((buttons[0].getText()=="1")&&
						buttons[1].getText()=="1")
					{
						twoWins(0,1);
					}
				if((buttons[4].getText()=="1")&&
						buttons[9].getText()=="1")
					{
						twoWins(4,9);
					}
				if((buttons[9].getText()=="1")&&
						buttons[14].getText()=="1")
					{
						twoWins(9,14);
					}
				if((buttons[0].getText()=="1")&&
						buttons[5].getText()=="1")
					{
						twoWins(0,5);
					}
				if((buttons[5].getText()=="1")&&
						buttons[10].getText()=="1")
					{
						twoWins(5,10);
					}
				if((buttons[10].getText()=="1")&&
						buttons[15].getText()=="1")
					{
						twoWins(10,15);
					}
				if((buttons[1].getText()=="1")&&
						buttons[6].getText()=="1")
					{
						twoWins(1,6);
					}
				if((buttons[6].getText()=="1")&&
						buttons[11].getText()=="1")
					{
						twoWins(6,11);
					}
				if((buttons[2].getText()=="1")&&
						buttons[7].getText()=="1")
					{
						twoWins(2,7);
					}
				
				
				//diagonal R-L
				
				if((buttons[11].getText()=="1")&&
						buttons[14].getText()=="1")
					{
						twoWins(11,14);
					}
				if((buttons[7].getText()=="1")&&
						buttons[10].getText()=="1")
					{
						twoWins(7,10);
					}
				if((buttons[10].getText()=="1")&&
						buttons[13].getText()=="1")
					{
						twoWins(10,13);
					}
				if((buttons[3].getText()=="1")&&
						buttons[6].getText()=="1")
					{
						twoWins(3,6);
					}
				if((buttons[6].getText()=="1")&&
						buttons[9].getText()=="1")
					{
						twoWins(6,9);
					}
				if((buttons[9].getText()=="1")&&
						buttons[12].getText()=="1")
					{
						twoWins(9,12);
					}
				if((buttons[2].getText()=="1")&&
						buttons[5].getText()=="1")
					{
						twoWins(2,5);
					}
				if((buttons[5].getText()=="1")&&
						buttons[8].getText()=="1")
					{
						twoWins(5,8);
					}
				if((buttons[1].getText()=="1")&&
						buttons[4].getText()=="1")
					{
						twoWins(1,4);
					}
		
		
	}
	
	public void oneWins(int a, int b) {
		for(int i=0;i<16;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Player 1 wins");
		
	}
	
	public void twoWins(int a, int b) {
		for(int i=0;i<16;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("Player 2 wins");
	}
}
