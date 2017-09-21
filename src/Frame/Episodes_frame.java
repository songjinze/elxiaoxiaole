package Frame;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Pictures;
import Sound.SoundConnector;

public class Episodes_frame {

	JFrame episode;
	JButton next_button=new JButton();
	JLabel label=new JLabel();
	int count=1;
	
	int width=new PositionandSize().mainWidth;
	int height=new PositionandSize().mainHeight;
	int x=new PositionandSize().main_x;
	int y=new PositionandSize().main_y;
	
	int width_rb=(int)(0.1*width);
	int height_rb=(int)(0.07*height);
	int x_button=(int)(0.9*width);
	int y_button=(int)(0.9*height);
	SoundConnector sound=new SoundConnector("episode1");
	
	public Episodes_frame() {
	 
		
		sound.a.loop();
		episode=new JFrame();
		episode.setUndecorated(true);
		episode.setBounds(x, y, width, height);
		
		ImageIcon e1=Pictures.episode_1_1;
		e1.setImage(e1.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
		label.setIcon(e1);
		label.setBounds(0, 0, width, height);
		episode.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel content=(JPanel)episode.getContentPane();
		content.setOpaque(false);
		
		Container c=episode.getContentPane();
		c.setLayout(null);
		c.add(next_button);
		next_button.setBounds(x_button, y_button, width_rb, height_rb);
		
		ImageIcon Next=Pictures.Next;
		Next.setImage(Next.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		next_button.setIcon(Next);
		
		
		
		episode.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		episode.setVisible(true);
		
		next_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(count==1){
					ImageIcon e2=Pictures.episode_1_2;
					e2.setImage(e2.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
					label.setIcon(e2);
					count++;
				}
				else if(count==2){
					ImageIcon e3=Pictures.episode_1_3;
					e3.setImage(e3.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
					label.setIcon(e3);
					SoundConnector sound1=new SoundConnector("Sound2");
					sound1.a.play();
					count++;
				}
				else if(count==3){
				    sound.a.stop();
					episode.dispose();
					
					new MainFrame("1");
				}
				
			}
		});
		
		// TODO 自动生成的构造函数存根
	}
	
}
