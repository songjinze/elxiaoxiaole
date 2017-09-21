package Frame;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Game.Pictures;
public class HelpFrame {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 4967359805050501362L;
	int count=0;
	JFrame help_frame;
	JPanel help_panel;
	JButton next_button;
	JButton return_button;
	JButton pic_button;
	ImageIcon Pic;
	
	int width=new PositionandSize().mainWidth;
	 int height=new PositionandSize().mainHeight;
	 int x=new PositionandSize().main_x;
	 int y=new PositionandSize().main_y;
	 
	 int width_panel=(int)(0.428*width);
	 int height_panel=(int)(0.4*height);
	 int x_panel=(int)(0.285*width);
	 int y_panel=(int)(0.2*height);
	 
	 int width_rb=(int)(0.1*width);
	 int height_rb=(int)(0.07*height);
	 
	 int width_label=(int)(0.114*width);
	 int height_label=(int)(0.06*height);
	 int x_lable=(int)(0.057*width);
	 int y_lable=(int)(0.1*height);
	 
	 int width_text=(int)(0.285*width);
	 int height_text=(int)(0.06*height);
	 int x_text=(int)(0.142*width);
	 int y_text=(int)(0.1*height);
	 
	 int width_np=(int)(0.142*width);
	 int height_np=(int)(0.08*height);
	 int x_np=(int)(0.15*width);
	 int y_np=(int)(0.2*height);
	
	public HelpFrame() {
		
		help_frame=new JFrame("Help");
		help_frame.setUndecorated(true);
		help_frame.setBounds(new PositionandSize().main_x, new PositionandSize().main_y, new PositionandSize().mainWidth, new PositionandSize().mainHeight);
		help_frame.setSize( new PositionandSize().mainWidth, new PositionandSize().mainHeight);
		help_frame.setLayout(null);
		
		ImageIcon backg=new ImageIcon(this.getClass().getResource("/Pictures/background1.jpg"));
		backg.setImage(backg.getImage().getScaledInstance( new PositionandSize().mainWidth, new PositionandSize().mainHeight, Image.SCALE_DEFAULT));
	    JLabel backlable=new JLabel(backg);
	    backlable.setBounds(0, 0, help_frame.getWidth(), help_frame.getHeight());
	    help_frame.getLayeredPane().add(backlable, new Integer(Integer.MIN_VALUE));
	    
	    JPanel imagePanel = (JPanel) help_frame.getContentPane();  
        imagePanel.setOpaque(false);  
		
		Container c=help_frame.getContentPane();
		c.setLayout(null);
		
		help_panel=new JPanel();
		help_panel.setOpaque(false);
		return_button=new JButton("");
		
		ImageIcon Return=Pictures.Return;
		Return.setImage(Return.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		return_button.setIcon(Return);
		
		help_panel.setLayout(null);
		help_panel.setBounds(x_panel, y_panel, width_panel, height_panel);
		return_button.setBounds(0, 0, width_rb, height_rb);
		
		next_button=new JButton();
		ImageIcon Next=Pictures.Next;
		Next.setImage(Next.getImage().getScaledInstance(2*width_rb, 2*height_rb, Image.SCALE_AREA_AVERAGING));
		next_button.setIcon(Next);
		next_button.setBounds(2*x_panel+150,2*y_panel,2*width_rb,2*height_rb);
		
		pic_button=new JButton();

		Pic=Pictures.three;
		pic_button.setIcon(Pic);
		pic_button.setBounds(x_panel,y_panel+100,Pic.getIconWidth(),Pic.getIconHeight());
		
		c.add(help_panel);
		c.add(return_button);
		c.add(next_button);
		c.add(pic_button);
		
		help_frame.setVisible(true);
		help_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				help_frame.dispose();
			}
			
		});
		
		next_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(count){
				
				case 0:
					
					Pic=Pictures.four;
					pic_button.setIcon(Pic);
					pic_button.setBounds(x_panel,y_panel+100,Pic.getIconWidth(),Pic.getIconHeight());
					break;
				case 1:
					Pic=Pictures.fiveline;
					pic_button.setIcon(Pic);
					pic_button.setBounds(x_panel,y_panel+100,Pic.getIconWidth(),Pic.getIconHeight());
					break;
				case 2:
					Pic=Pictures.five;
					pic_button.setIcon(Pic);
					pic_button.setBounds(x_panel,y_panel+100,Pic.getIconWidth(),Pic.getIconHeight());
					break;
				case 3:
					help_frame.dispose();
					JFrame help_frame2;
					JPanel help_panel2;
					JButton return_button2;
					help_frame2=new JFrame("Help");
					help_frame2.setUndecorated(true);
					
					help_frame2.setBounds(new PositionandSize().main_x, new PositionandSize().main_y, new PositionandSize().mainWidth, new PositionandSize().mainHeight);
					help_frame2.setSize( new PositionandSize().mainWidth, new PositionandSize().mainHeight);
					help_frame2.setLayout(null);
					ImageIcon back=Pictures.back;
					back.setImage(back.getImage().getScaledInstance( new PositionandSize().mainWidth, new PositionandSize().mainHeight, Image.SCALE_DEFAULT));
				    JLabel backlable=new JLabel(back);
				    backlable.setBounds(0, 0, help_frame2.getWidth(), help_frame2.getHeight());
				    help_frame2.getLayeredPane().add(backlable, new Integer(Integer.MIN_VALUE));
				    JPanel imagePanel = (JPanel) help_frame2.getContentPane();  
			        imagePanel.setOpaque(false);  
					
					Container c=help_frame2.getContentPane();
					c.setLayout(null);
					
					help_panel2=new JPanel();
					help_panel2.setOpaque(false);
					return_button2=new JButton("");
					
					ImageIcon Return=Pictures.Return;
					Return.setImage(Return.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
					return_button2.setIcon(Return);
					
					help_panel2.setLayout(null);
					help_panel2.setBounds(x_panel, y_panel, width_panel, height_panel);
					return_button2.setBounds(0, 0, width_rb, height_rb);
					
					
					
					c.add(help_panel2);
					c.add(return_button2);
					
					help_frame2.setVisible(true);
					
					return_button2.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							help_frame2.dispose();
						}
						
					});
				    break;
				}
					
			
				
				if(count==4){
					help_frame.dispose();
				}else{
				count++;
				}
			}
			
		});
		
	}
	
}
