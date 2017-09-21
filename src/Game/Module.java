package Game;
import javax.swing.*;
import java.awt.*;
public class Module extends JPanel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1318805022009969187L;

	Module(String str){
		
		InitializeMap.Initialize(str);
		
		for(int n=0;n<AllSize.YBlockNum;n++)
			for(int m=0;m<AllSize.XBlockNum;m++){
				add(Block.Buttons[n][m]);
			}
    	setLayout(new GridLayout(AllSize.YBlockNum,AllSize.XBlockNum));
    	setBackground(Color.DARK_GRAY);
    	
    	setPreferredSize(new Dimension(AllSize.PanelWidth,AllSize.PanelHeight));
    	setVisible(true);
    }
}
