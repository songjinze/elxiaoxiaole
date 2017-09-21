package Game;
import javax.swing.*;
import java.awt.*;
public class Connector {
	
	public static JPanel ReturnPanel(String str){
		
		JPanel panel=new JPanel();
		
		panel.setPreferredSize(new Dimension(AllSize.PanelWidth,AllSize.PanelHeight));
		panel.add(new Module(str));
		panel.setVisible(true);
		
		return panel;
	}
}
