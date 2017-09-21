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

public class Enemy_choose_frame {

	JFrame Enemy_chhoose;
	
	JButton e1=new JButton();
	JButton e2=new JButton();
	JButton e3=new JButton();
	JButton e4=new JButton();
    JButton return_button=new JButton();
    JPanel button_panel=new JPanel();
    
	int x=new PositionandSize().main_x;
	int y=new PositionandSize().main_y;
	int width=new PositionandSize().mainWidth;
	int height=new PositionandSize().mainHeight;
	
	int width_button=(int)(0.355*width);
	int height_button=(int)(0.255*height);
	
	int width_panel=(int)(0.714*width);
	int height_panel=(int)(0.51*height);
	
	int x_panel=(int)(0.142*width);
	int y_panel=(int)(0.25*height);
	
	int x1=0;
	int y1=0;
	
	int x2=(int)(0.5*width_panel);
	int y2=0;
	
	int x3=0;
	int y3=(int)(0.505*height_panel);
	
	int x4=(int)(0.5*width_panel);
	int y4=(int)(0.505*height_panel);
	
	int width_rb=(int)(0.1*width);
	int height_rb=(int)(0.07*height);
	
	
	public Enemy_choose_frame() {
		
		Enemy_chhoose=new JFrame("选择一个剧情吧！");
		Enemy_chhoose.setUndecorated(true);
		Enemy_chhoose.setBounds(x, y, width, height);
		Enemy_chhoose.setLayout(null);
		
		ImageIcon e_bk=Pictures.e_bk;
		e_bk.setImage(e_bk.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
		JLabel label=new JLabel();
		label.setIcon(e_bk);
		label.setBounds(0, 0, width, height);
		Enemy_chhoose.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel content=(JPanel)Enemy_chhoose.getContentPane();
		content.setOpaque(false);
		
		Container c=Enemy_chhoose.getContentPane();
		button_panel.setBounds(x_panel, y_panel,width_panel, height_panel);
		button_panel.setLayout(null);
		button_panel.setOpaque(false);	
		
		
		
		e1.setBounds(x1, y1, width_button, height_button);
		e2.setBounds(x2, y2, width_button, height_button);
		e3.setBounds(x3, y3, width_button, height_button);
		e4.setBounds(x4, y4, width_button, height_button);
		return_button.setBounds(0, 0, width_rb, height_rb);
		
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		if(PositionandSize.hammerReword1){count1++;}
		if(PositionandSize.reconstructReword1){count1++;}
		if(PositionandSize.sameReword1){count1++;}
		if(PositionandSize.hammerReword2){count2++;}
		if(PositionandSize.reconstructReword2){count2++;}
		if(PositionandSize.sameReword2){count2++;}
		if(PositionandSize.hammerReword3){count3++;}
		if(PositionandSize.reconstructReword3){count3++;}
		if(PositionandSize.sameReword3){count3++;}
		if(PositionandSize.hammerReword4){count4++;}
		if(PositionandSize.reconstructReword4){count4++;}
		if(PositionandSize.sameReword4){count4++;}
		ImageIcon e_1;
		switch(count1){
		case 0:e_1=Pictures.e1;break;
		case 1:e_1=Pictures.e1_1;break;
		case 2:e_1=Pictures.e1_2;break;
		default:e_1=Pictures.e1_3;break;
		}
		e_1.setImage(e_1.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		e1.setIcon(e_1);
		
		ImageIcon e_4;
		switch(count4){
		case 0:e_4=Pictures.e4;break;
		case 1:e_4=Pictures.e4_1;break;
		case 2:e_4=Pictures.e4_2;break;
		default:e_4=Pictures.e4_3;break;
		}
		e_4.setImage(e_4.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		e4.setIcon(e_4);
		
		ImageIcon e_2;
		switch(count2){
		case 0:e_2=Pictures.e2;break;
		case 1:e_2=Pictures.e2_1;break;
		case 2:e_2=Pictures.e2_2;break;
		default:e_2=Pictures.e2_3;break;
		}
		e_2.setImage(e_2.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		e2.setIcon(e_2);
		
		
		
		ImageIcon e_3;
		
		switch(count3){
		case 0:e_3=Pictures.e3;break;
		case 1:e_3=Pictures.e3_1;break;
		case 2:e_3=Pictures.e3_2;break;
		default:e_3=Pictures.e3_3;break;
		}
		e_3.setImage(e_3.getImage().getScaledInstance(width_button, height_button, Image.SCALE_AREA_AVERAGING));
		e3.setIcon(e_3);
		
		 ImageIcon Return=Pictures.Return;
		 Return.setImage(Return.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		 return_button.setIcon(Return);
		
		 c.add(button_panel);		 
		 button_panel.add(e1);
		 button_panel.add(e2);
		 button_panel.add(e3);
		 button_panel.add(e4);
		 c.add(return_button);
			
		Enemy_chhoose.setVisible(true);
		
		return_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Start_frame();
				Enemy_chhoose.dispose();
			}
		});
		e1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Enemy_chhoose.dispose();
				new Episodes_frame();
				
			}
		});
		e2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Enemy_chhoose.dispose();
				new Episodes2();
				
			}
		});
		e3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Enemy_chhoose.dispose();
				new episode3();
				
			}
		});
		e4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				Enemy_chhoose.dispose();
				new episode4();
			}
		});
		// TODO 自动生成的构造函数存根
	}
	
	
}
