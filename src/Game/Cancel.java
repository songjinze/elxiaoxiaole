package Game;

import java.util.ArrayList;


public class Cancel{

	public static ArrayList<Button>Buttons;

	public static void CancelOnce(ArrayList<Button> buttons){
	    Buttons=buttons;
	    
	    new Thread(){
	    	
	    public void run(){
	    do{
	    	ArrayList<Button>listForCancel=new ArrayList<>();
	    	ArrayList<Integer>listForCancelNum=new ArrayList<>();
		boolean[] containerX=new boolean[AllSize.XBlockNum];
		for(int n=0;n<AllSize.XBlockNum;n++){
			containerX[n]=false;
		}
		for(Button b:Buttons){
			containerX[b.setX]=true;
		}
		
		for(int n=0;n<AllSize.XBlockNum;n++){
			if(containerX[n]){
				ArrayList<Integer>buttonNumCancelForLine=new ArrayList<>();
				ArrayList<Button>buttonsCancelForLine1=new ArrayList<>();
				ArrayList<String>buttonsCancelForLine2=new ArrayList<>();
				for(Button b:Buttons){
					if(b.setX==n){
						listForCancel.add(b);
						listForCancelNum.add(b.PictureNum);
						buttonNumCancelForLine.add(b.setY);
					}
					if(b.setX>n)
						break;
				}
				int tempCount=0;
				for(int m=0;m<AllSize.YBlockNum;m++){
					buttonsCancelForLine1.add(Block.Buttons[m][n]);
					buttonsCancelForLine2.add(Block.Buttons[m][n].PictureNum+"");
				}
				int removeCount=0;
				int[]arrayForMove=new int[AllSize.YBlockNum];
				for(int m=0;m<AllSize.YBlockNum;m++){
					tempCount=0;
					boolean isCanceled=false;
					
					for(int i:buttonNumCancelForLine){
						if(buttonsCancelForLine1.get(m).setY<i){
							tempCount++;
						}
					    if(buttonsCancelForLine1.get(m).setY==i){
					    	isCanceled=true;
					    }
					}
					if(tempCount!=0&&!isCanceled){
					    arrayForMove[m]=tempCount;
					}
					else if(isCanceled){
						buttonsCancelForLine2.remove(m-removeCount);
						removeCount++;
					}
				}
				for(int i=0;i<buttonNumCancelForLine.size();i++){
					buttonsCancelForLine2.add(0,(int)(Math.random()*6)+1+"");
				}
				for(int i=0;i<AllSize.YBlockNum;i++){
					Block.Buttons[i][n].PictureNum=Integer.parseInt(buttonsCancelForLine2.get(i));
				}
				
			}
		}
		
					for(int i=0;i<listForCancel.size();i++){
						switch(listForCancelNum.get(i)){
						case 1:listForCancel.get(i).setIcon(Pictures.Special1);break;
						case 2:listForCancel.get(i).setIcon(Pictures.Special2);break;
						case 3:listForCancel.get(i).setIcon(Pictures.Special3);break;
						case 4:listForCancel.get(i).setIcon(Pictures.Special4);break;
						case 5:listForCancel.get(i).setIcon(Pictures.Special5);break;
						case 6:listForCancel.get(i).setIcon(Pictures.Special6);break;
						}
					}
					
				try{	
					Thread.sleep(400);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}

				
				for(int y=0;y<AllSize.YBlockNum;y++){
					for(int x=0;x<AllSize.XBlockNum;x++){
						int pictureNum=Block.Buttons[y][x].PictureNum;
						/*
						 * 鎸夐挳涓姞鍏ュ搴斿浘鐗?					 */
						
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
				}
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Buttons.clear();
		AutoCancel.autoCancel();
		
	    }while(AutoCancel.judge());
	    ButtonActionListener.CancelButtons.clear();
	    }
	    }.start();
	}
}