package Frame;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Game.Pictures;
import Sound.SoundConnector;

public class catched_frame {

	public JFrame catch_frame;
	public JButton Rrturn;
	public JButton Retart;
	public JPanel buttons;
	
	int x=new PositionandSize().main_x;
	int y=new PositionandSize().main_y;
	int width=new PositionandSize().mainWidth;
	int height=new PositionandSize().mainHeight;
	
	int width_rb=(int)(0.1*width);
	int height_rb=(int)(0.07*height);
	int x_button=(int)(0.9*width);
	int y_button=(int)(0.9*height);
	
	public catched_frame(String str) {
		catch_frame=new JFrame();
		catch_frame.setUndecorated(true);
		catch_frame.setBounds(x, y, width, height);
		catch_frame.setLayout(null);
		
		new SoundConnector("fail").a.play();
		
		ImageIcon e_bk=Pictures.catch_;
		e_bk.setImage(e_bk.getImage().getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING));
		JLabel label=new JLabel();
		label.setIcon(e_bk);
		label.setBounds(0, 0, width, height);
		catch_frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel content=(JPanel)catch_frame.getContentPane();
		content.setOpaque(false);
		
		
		
		
		
		Retart=new JButton();
		Container c=catch_frame.getContentPane();
		c.add(Retart);
		Retart.setBounds(x_button, y_button, width_rb, height_rb);
		
		
		ImageIcon Next=Pictures.Restart;
		Next.setImage(Next.getImage().getScaledInstance(width_rb, height_rb, Image.SCALE_AREA_AVERAGING));
		Retart.setIcon(Next);
		Retart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
				//main聽浼犱竴涓弬鏁拌繘鏉ワ紒
				SoundConnector.a.stop();
				catch_frame.dispose();
				
				new MainFrame(str);
				
			}
		});
		
		
		catch_frame.setVisible(true);
		
		
		// TODO 鑷姩鐢熸垚鐨勬瀯閫犲嚱鏁板瓨鏍�
	}
	
}
