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

import Game.AllSize;
import Game.Pictures;
import Sound.SoundConnector;

public class Success {
	JFrame success;
	JButton reButton;
	JLabel label1;
	Font bigfont=new Font("黑体", 5, 25);
	
	
	
	int width=new PositionandSize().mainWidth;
	int height=new PositionandSize().mainHeight;
	int x=new PositionandSize().main_x;
	int y=new PositionandSize().main_y;
	
	int width_rb=(int)(0.1*width);
	int height_rb=(int)(0.07*height);
	int x_button=(int)(0.9*width);
	int y_button=(int)(0.9*height);
	
	public Success() {
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
		if(count1==3&&count2==3&&count3==3&&count4==3){
		
			label1=new JLabel("全成就达成，so easy");
		}else{
			label1=new JLabel("下次老子不用道具");
		}
		
		success=new JFrame();
		success.setUndecorated(true);
		success.setLayout(null);
		success.setBounds(x, y, width, height);
		new SoundConnector("success").a.play();
		
		ImageIcon bc=Pictures.mainbc2;
		JLabel label=new JLabel(bc);
		label.setBounds(0, 0, width, height);
		success.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imagePanel = (JPanel)success.getContentPane();  
        imagePanel.setOpaque(false);  
        
        reButton=new JButton();
        Container c=success.getContentPane();
		c.setLayout(null);
		c.add(reButton);
	    reButton.setBounds(x_button, y_button, width_rb, height_rb);
	    c.add(label1);
	    label1.setBounds(600, 100, 3*width_rb, height_rb);
	    label1.setFont(bigfont);
		
		ImageIcon Next=Pictures.Return;
		Next.setImage(Next.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		reButton.setIcon(Next);
		
		reButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				SoundConnector.a.stop();
				success.dispose();
				new Enemy_choose_frame();
				
			}
		});
        
		success.setVisible(true);
		// TODO 自动生成的构造函数存根
	}
	
}
