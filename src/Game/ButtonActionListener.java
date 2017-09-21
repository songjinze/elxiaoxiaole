package Game;
import java.awt.event.*;
import java.util.*;

import Frame.MainFrame;
public class ButtonActionListener implements ActionListener{

	Button BUTTON;
	private boolean isInterfacting;
	private Button ExchangedBlock1;
	private Button ExchangedBlock2;
	private int ExchangedBlock1Y;
	private int ExchangedBlock1X;
	private int ExchangedBlock2Y;
	private int ExchangedBlock2X;
	public static ArrayList<Button>CancelButtons=new ArrayList<>();
	public static int toolNum=0;
	
	public void actionPerformed(ActionEvent e){
		BUTTON=(Button)e.getSource();
		
		switch(toolNum){
		/*不是道具的一般情况
		 */
		case 0:{
		isInterfacting=false;
		BUTTON.setBorderPainted(true);
		
		switch(Block.count){	
		case 0:
			Block.ClickButton.set(0, BUTTON);
			Block.count++;
			break;
		case 1:
			Block.ClickButton.set(1, BUTTON);
			Block.ClickButton.get(0).setBorderPainted(false);
			
			IsInterfacting(Block.ClickButton);
			if(isInterfacting){
				BUTTON.setBorderPainted(false);
				Block.count=0;
				
				CancelButtons=new ArrayList<>();
				if(ToCancel(Block.ClickButton)){
					InitializeMap.stepNum++;
					InitializeMap.ScoreNum+=CancelButtons.size();
					
					Cancel.CancelOnce(CancelButtons);
				
					
				}
				
				Block.ClickButton.set(0, new Button());
				Block.ClickButton.set(1, new Button());
			}
			else{
				Block.ClickButton.set(0, BUTTON);
			    Block.ClickButton.set(1, new Button());
			}
		}
		}
		break;
		
		case 1:
			MainFrame.hammerUse++;
			if(Block.count==1){
				Block.count=0;
			    Block.ClickButton.get(0).setBorderPainted(false);
			    Block.ClickButton.set(0, new Button());
			    Block.ClickButton.set(1, new Button());
			}
			CancelButtons.add(BUTTON);
			int tempX=BUTTON.setX;
			int tempY=BUTTON.setY;
			if(tempX==0&&tempY!=0&&tempY!=AllSize.YBlockNum-1){
				CancelButtons.add(Block.Buttons[tempY][tempX+1]);
			    CancelButtons.add(Block.Buttons[tempY-1][tempX]);
			    CancelButtons.add(Block.Buttons[tempY+1][tempX]);
			}
			else if(tempX==AllSize.XBlockNum-1&&tempY!=0&&tempY!=AllSize.YBlockNum-1){
				CancelButtons.add(Block.Buttons[tempY][tempX-1]);
			    CancelButtons.add(Block.Buttons[tempY-1][tempX]);
			    CancelButtons.add(Block.Buttons[tempY+1][tempX]);
			}
			else if(tempY==0&&tempX!=0&&tempX!=AllSize.XBlockNum-1){
				CancelButtons.add(Block.Buttons[tempY][tempX+1]);
			    CancelButtons.add(Block.Buttons[tempY][tempX-1]);
			    CancelButtons.add(Block.Buttons[tempY+1][tempX]);
			}
			else if(tempY==AllSize.YBlockNum-1&&tempX!=0&&tempX!=AllSize.XBlockNum-1){
				CancelButtons.add(Block.Buttons[tempY][tempX+1]);
			    CancelButtons.add(Block.Buttons[tempY-1][tempX]);
			    CancelButtons.add(Block.Buttons[tempY][tempX-1]);
			}
			else if(tempY!=0&&tempY!=AllSize.YBlockNum-1&&tempX!=AllSize.XBlockNum-1&&tempX!=0){
				CancelButtons.add(Block.Buttons[tempY][tempX+1]);
				CancelButtons.add(Block.Buttons[tempY][tempX-1]);
				CancelButtons.add(Block.Buttons[tempY-1][tempX]);
				CancelButtons.add(Block.Buttons[tempY+1][tempX]);
			}
			Collections.sort(CancelButtons);
			InitializeMap.ScoreNum+=CancelButtons.size();
			Cancel.CancelOnce(CancelButtons);
			
			toolNum=0;
			break;
		
		case 3:
			MainFrame.sameUse++;
			if(Block.count==1){
				Block.count=0;
			    Block.ClickButton.get(0).setBorderPainted(false);
			    Block.ClickButton.set(0, new Button());
			    Block.ClickButton.set(1, new Button());
			}
			int tempPictureNum=BUTTON.PictureNum;
			for(int y=0;y<AllSize.YBlockNum;y++){
				for(int x=0;x<AllSize.XBlockNum;x++){
					Button tempButton=Block.Buttons[y][x];
					if(tempButton.PictureNum==tempPictureNum)
						CancelButtons.add(tempButton);
				}
			}
			
			Collections.sort(CancelButtons);
			InitializeMap.ScoreNum+=CancelButtons.size();
			Cancel.CancelOnce(CancelButtons);
			toolNum=0;
			break;
		}
	}
	public void IsInterfacting(ArrayList<Button> buttons){
		/*
		 * 点下的两个按钮是否为相邻，或者是相同
		 */
		ExchangedBlock1=buttons.get(0);
		ExchangedBlock2=buttons.get(1);
		ExchangedBlock1Y=ExchangedBlock1.setY;
		ExchangedBlock1X=ExchangedBlock1.setX;
		ExchangedBlock2Y=ExchangedBlock2.setY;
		ExchangedBlock2X=ExchangedBlock2.setX;
		if(ExchangedBlock1Y==ExchangedBlock2Y&&ExchangedBlock1X==ExchangedBlock2X){
		}else{
			boolean XInterfacting=(((ExchangedBlock1X-ExchangedBlock2X)==1)||((ExchangedBlock2X-ExchangedBlock1X)==1)&&(ExchangedBlock1Y==ExchangedBlock2Y));
		    boolean YInterfacting=(((ExchangedBlock1Y-ExchangedBlock2Y)==1)||((ExchangedBlock2Y-ExchangedBlock1Y)==1)&&(ExchangedBlock1X==ExchangedBlock2X));
		    if(XInterfacting||YInterfacting){
		    	isInterfacting=true;
		    }
		}
	}
	private boolean ToCancel(ArrayList<Button>buttons){
		/*
		 * 
		 */
		boolean CanCancel=false;
		ExchangedBlock1=buttons.get(0);
		ExchangedBlock2=buttons.get(1);
		ExchangedBlock1Y=ExchangedBlock1.setY;
		ExchangedBlock1X=ExchangedBlock1.setX;
		ExchangedBlock2Y=ExchangedBlock2.setY;
		ExchangedBlock2X=ExchangedBlock2.setX;
		

		int TempPictureNum1=Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X].PictureNum;
		int TempPictureNum2=Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X].PictureNum;
		Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X].PictureNum=TempPictureNum1;
		Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X].PictureNum=TempPictureNum2;
		
		
		ArrayList<Button>tempList;
		//判断第一个格子上下左右可消并保存
		{
			int count=1;
			int temp=1;
			tempList=new ArrayList<>();
			tempList.add(Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X]);
			while(ExchangedBlock1X-temp>=0&&Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X-temp].PictureNum==TempPictureNum1){
				count++;
				tempList.add(Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X-temp]);
				temp++;
			}
			temp=1;
			while(ExchangedBlock1X+temp<=AllSize.XBlockNum-1&&Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X+temp].PictureNum==TempPictureNum1){
				count++;
			    tempList.add(Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X+temp]);
			    temp++;
			}
			if(count>=3){
				for(Button b:tempList){
					CancelButtons.add(b);
				}
				CanCancel=true;
			}
		}
		{
			int count=1;
			int temp=1;
			tempList=new ArrayList<>();
			tempList.add(Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X]);
			while(ExchangedBlock1Y-temp>=0&&Block.Buttons[ExchangedBlock1Y-temp][ExchangedBlock1X].PictureNum==TempPictureNum1){
				count++;
				tempList.add(Block.Buttons[ExchangedBlock1Y-temp][ExchangedBlock1X]);
				temp++;
			}
			temp=1;
			while(ExchangedBlock1Y+temp<=AllSize.YBlockNum-1&&Block.Buttons[ExchangedBlock1Y+temp][ExchangedBlock1X].PictureNum==TempPictureNum1){
				count++;
			    tempList.add(Block.Buttons[ExchangedBlock1Y+temp][ExchangedBlock1X]);
			    temp++;
			}
			if(count>=3){
				for(Button b:tempList){
					CancelButtons.add(b);
				}
				CanCancel=true;
			}
		}
		//判断第二个格子上下左右可消并保存
		{
			int count=1;
			int temp=1;
			tempList=new ArrayList<>();
			tempList.add(Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X]);
			while(ExchangedBlock2X-temp>=0&&Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X-temp].PictureNum==TempPictureNum2){
				count++;
				tempList.add(Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X-temp]);
				temp++;
			}
			temp=1;
			while(ExchangedBlock2X+temp<=AllSize.XBlockNum-1&&Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X+temp].PictureNum==TempPictureNum2){
				count++;
			    tempList.add(Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X+temp]);
			    temp++;
			}
			if(count>=3){
				for(Button b:tempList){
					CancelButtons.add(b);
				}
				CanCancel=true;
			}
		}
		{
			int count=1;
			int temp=1;
			tempList=new ArrayList<>();
			tempList.add(Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X]);
			while(ExchangedBlock2Y-temp>=0&&Block.Buttons[ExchangedBlock2Y-temp][ExchangedBlock2X].PictureNum==TempPictureNum2){
				count++;
				tempList.add(Block.Buttons[ExchangedBlock2Y-temp][ExchangedBlock2X]);
				temp++;
			}
			temp=1;
			while(ExchangedBlock2Y+temp<=AllSize.YBlockNum-1&&Block.Buttons[ExchangedBlock2Y+temp][ExchangedBlock2X].PictureNum==TempPictureNum2){
				count++;
			    tempList.add(Block.Buttons[ExchangedBlock2Y+temp][ExchangedBlock2X]);
			    temp++;
			}
			if(count>=3){
				for(Button b:tempList){
					CancelButtons.add(b);
				}
				CanCancel=true;
			}
		}
		Collections.sort(CancelButtons);

		/*for(Button b:CancelButtons){
			System.out.println(b.setY+"  "+b.setX);
		}
		*/
		if(!CanCancel){
			Block.Buttons[ExchangedBlock1Y][ExchangedBlock1X].PictureNum=TempPictureNum2;
			Block.Buttons[ExchangedBlock2Y][ExchangedBlock2X].PictureNum=TempPictureNum1;
		}
		for(int y=0;y<AllSize.YBlockNum;y++)
			for(int x=0;x<AllSize.XBlockNum;x++){
				int pictureNum=Block.Buttons[y][x].PictureNum;
				/*
				 * 按钮中加入对应图片
				 */
				
				switch(pictureNum){
				case 1:
					Block.Buttons[y][x].setIcon(Pictures.icon1);
					break;
				case 2:
					Block.Buttons[y][x].setIcon(Pictures.icon2);
					break;
				case 3:
					Block.Buttons[y][x].setIcon(Pictures.icon3);
					break;
				case 4:
					Block.Buttons[y][x].setIcon(Pictures.icon4);
					break;
				case 5:
					Block.Buttons[y][x].setIcon(Pictures.icon5);
					break;
				case 6:
					Block.Buttons[y][x].setIcon(Pictures.icon6);
					break;
				}
			}
		return CanCancel;
	}
}
