package Game;
import javax.swing.*;
import java.awt.*;
public class Button extends JButton implements Comparable<Button>{

	/**
	 * 消消乐中按钮的图片、位置、颜色等。
	 */
	private static final long serialVersionUID = -1920604175552962458L;
	public int setY=0;
	public int setX=0;
	public int PictureNum=0;
	Button(){
		addActionListener(new ButtonActionListener());
		setPreferredSize(new Dimension(AllSize.BlockWidth,AllSize.BlockHeight));
		setBackground(Color.DARK_GRAY);
		setBorderPainted(false);
	}
	@Override
	public int compareTo(Button that) {
		// TODO 自动生成的方法存根
		if(this.setX>that.setX){
			return 1;
		}else if(this.setX<that.setX){
			return -1;
		}else if(this.setY>that.setY){
			return 1;
		}else if(this.setY<that.setY){
			return -1;
		}
		return 0;
	}
}
