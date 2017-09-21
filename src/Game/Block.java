package Game;
import java.util.*;
public class Block {
	
	public static Button[][] Buttons;
	public static ArrayList<Button>ClickButton;
	public static int count;
	public Block(){
		Buttons=new Button[AllSize.YBlockNum][AllSize.XBlockNum];
		ClickButton=new ArrayList<>();
		ClickButton.add(new Button());
		ClickButton.add(new Button());
		count=0;
		
		for(int n=0;n<AllSize.YBlockNum;n++)
			for(int m=0;m<AllSize.XBlockNum;m++){
				Block.Buttons[n][m]=new Button();
		        Block.Buttons[n][m].setX=m;
		        Block.Buttons[n][m].setY=n;
			}
	}
}
