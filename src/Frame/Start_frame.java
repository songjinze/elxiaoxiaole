package Frame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Block;
import Game.Pictures;
import Sound.SoundConnector;
public class Start_frame {
	
	private JFrame Start;
	private Start_buttons Start_1=new Start_buttons("New Game",Color.magenta);
	private Start_buttons Read=new Start_buttons("Read",Color.BLACK);
	private Start_buttons Exit =new Start_buttons("Exit",Color.BLACK);
	private Start_buttons Help =new Start_buttons("Help",Color.BLACK);
	int width=new PositionandSize().mainWidth;
	int height=new PositionandSize().mainHeight;
	int x=new PositionandSize().main_x;
	int y=new PositionandSize().main_y;
	int width_panel=(int) (0.35*width);
	int height_panel=(int)(0.5*height);
	int x_panel=(int) (0.677*width);
	int y_panel=(int)(0.2*height);
	int width_button=(int)(0.35*width);
	int height_button=(int)(0.12*height);
	
	 Start_frame() {
		 
		new Block();
		new Pictures("1");
		Start= new JFrame();
		Start.setUndecorated(true);
		Start.setSize(width, height);
		Start.setLayout(null);
		Start.setBounds(x,y,width,height);
		
		ImageIcon backg=new ImageIcon(this.getClass().getResource("/Pictures/background1.jpg"));
		backg.setImage(backg.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	    JLabel backlable=new JLabel(backg);
	    backlable.setBounds(0, 0, Start.getWidth(), Start.getHeight());
		Start.getLayeredPane().add(backlable, new Integer(Integer.MIN_VALUE));
		
		
		JPanel imagePanel = (JPanel) Start.getContentPane();  
        imagePanel.setOpaque(false);  
        
		JPanel button_panel=new JPanel();
		button_panel.setOpaque(false);
		
		Start.getContentPane().add(button_panel);
		button_panel.setBounds(x_panel,y_panel,width_panel,height_panel);
		button_panel.setLayout(null);
		
		Start_1.setBounds(0, 0, width_button, height_button);
		Read.setBounds(0, height_button+1, width_button, height_button);
		Exit.setBounds(0, 2*height_button+2, width_button, height_button);
		Help.setBounds(0, height_button+1, width_button, height_button);
		
		ImageIcon Newgame=Pictures.NewGame;
		Newgame.setImage(Newgame.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		Start_1.setIcon(Newgame);
		
		ImageIcon Read_image=Pictures.Read;
		Read_image.setImage(Read_image.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		Read.setIcon(Read_image);
		
		ImageIcon Exit_image=Pictures.Exit;
		Exit_image.setImage(Exit_image.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		Exit.setIcon(Exit_image);
		
		ImageIcon Help_image=Pictures.Help;
		Help_image.setImage(Help_image.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
	    Help.setIcon(Help_image);
		
		
		Addaction(Start_1);
		Addaction(Read);
		Addaction(Exit);
		Addaction(Help);
		
		button_panel.add(Start_1);
		
		button_panel.add(Exit);
		button_panel.add(Help);
		
		new SoundConnector("a");
		SoundConnector.a.loop();
		
		Start.setVisible(true);
	}
	public static void main(String[] args) {
		new Start_frame();
		
	}
	
	private void Addaction(Start_buttons button){
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String cmd=e.getActionCommand();
				switch (cmd) {
				case "New Game":
					Start();
					break;
				case "Help":
					Help();
					break;
				case "Exit":
					Exit();
					break;
				
				default:
					break;
				}
			}
		});
	}
	//Start
	private void Start(){
		SoundConnector.a.stop();
		Start.dispose();
		new Choose_frame("qinliu");
	}
	//Exit
	private void Exit(){
		SoundConnector.a.stop();
		Start.dispose();
		System.exit(0);
	}
	//Help
	private void Help(){
		new HelpFrame();
	}
}
