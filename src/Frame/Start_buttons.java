package Frame;

import java.awt.*;
import javax.swing.JButton;

public class Start_buttons extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8759973306753308276L;
	public Start_buttons(String name,Color c) {
		Font Bigfont=new Font("Monaco",Font.BOLD,12);
		this.setFont(Bigfont);
		this.setText(name);	
		this.setBorderPainted(false);
		this.setForeground(Color.BLACK);
		this.setBackground(c);
	}
}
