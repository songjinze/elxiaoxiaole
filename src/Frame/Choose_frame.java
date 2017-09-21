package Frame;

import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Pictures;

public class Choose_frame {
	 public JFrame choose_frame;
	 public JButton return_button;
	 public JButton Man_button;
	 public JButton Women_button;
	 public JLabel to_be_continued;
	 Font Bigfont=new Font("黑体",Font.BOLD,15);
	 
	 int width=new PositionandSize().mainWidth;
	 int height=new PositionandSize().mainHeight;
	 int x=new PositionandSize().main_x;
	 int y=new PositionandSize().main_y;
	 
	 int width_rb=(int)(0.1*width);
	 int height_rb=(int)(0.07*height);
	 
	 int x_man=(int)(0.214*width);
	 int y_man=(int)(0.2*height);
	 int width_character=(int)(0.2857*width);
	 int height_character=(int)(0.6*height);
	 int x_women=(int)(0.5*width);
	 int y_women=(int)(0.2*height);
	 
	 int x_label=(int)(0.53*width);
	 int y_label=(int)(0.46*height);
	 int width_label=(int)(0.30*width);
	
	 ImageIcon Man=Pictures.ManIcon;
	 ImageIcon Woman=Pictures.WomanIcon;
	 ImageIcon choose=Pictures.choose_Icon;
	 
	 public Choose_frame(String Username) {
		 choose_frame=new JFrame(Username+",选择一个角色吧！");
		 choose_frame.setUndecorated(true);
		 choose_frame.setLayout(null);
		 choose_frame.setBounds(x, y, width, height);
		 
		 to_be_continued=new JLabel("更多角色敬请期待！");
		 to_be_continued.setFont(Bigfont);
		 
		 choose.setImage(choose.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		 JLabel backLable=new JLabel(choose);
		 backLable.setBounds(0, 0, choose_frame.getWidth(),choose_frame.getHeight());
		 choose_frame.getLayeredPane().add(backLable, new Integer(Integer.MIN_VALUE));
		 JPanel content=(JPanel)choose_frame.getContentPane();
		 content.setOpaque(false);
		 
		 return_button=new JButton("");
		 Man_button=new JButton();
		 Women_button=new JButton();
		 return_button.setFont(Bigfont);
		 
		
		 
		 Container c=choose_frame.getContentPane();
		
		 c.add(return_button);
		 c.add(Man_button);
		 c.add(to_be_continued);
		 
		 return_button.setBounds(0, 0, width_rb, height_rb);
		 Man_button.setBounds(x_man, y_man, width_character, height_character);
		 Women_button.setBounds(x_women, y_women, width_character, height_character);
		 to_be_continued.setBounds(x_label,y_label , width_label,height_rb);
		 
		 Man.setImage(Man.getImage().getScaledInstance(width_character, height_character, Image.SCALE_DEFAULT));
		 Woman.setImage(Woman.getImage().getScaledInstance(width_character, height_character, Image.SCALE_DEFAULT));
		 Man_button.setIcon(Man);
		 Women_button.setIcon(Woman);
		
		 ImageIcon Return=Pictures.Return;
		 Return.setImage(Return.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		 return_button.setIcon(Return);
		 
		 choose_frame.setVisible(true);
		 choose_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 
		 
		 return_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Start_frame();
				choose_frame.dispose();
			}
		});
		 
		 Man_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Enemy_choose_frame();
				choose_frame.dispose();
				// TODO 自动生成的方法存根
				
			}
		});
		 // TODO 自动生成的构造函数存根
	}
}
