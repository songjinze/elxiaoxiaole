package Game;
/*
 * 此方法用于初始化地图
 */
public class InitializeMap {

	public static boolean isFirstInitialize=true;
	public static int stepNum=0;
	public static int stepLimit=0;
	public static int TimeLimit=0;
	public static int TimeNum=0;
	public static int ScoreNum=0;
	
	public static void Initialize(String str){
		InitializePictureNum();
		if(isFirstInitialize=true){
			stepNum=0;
			stepLimit=30;
			ScoreNum=0;
			InitializeMap.isFirstInitialize=false;
		}
		boolean isXLine=isXLine();
		boolean isYLine=isYLine();
		boolean CannotCancel=!CanCancel();
		
		while(isXLine||isYLine||CannotCancel){
			InitializePictureNum();
			
			isXLine=isXLine();
			isYLine=isYLine();
			CannotCancel=(!CanCancel());
		}
			InitializePicture(str);
	}
	private static void InitializePictureNum(){
		/*
		 * 初始化地图中图片对应的数字
		 */
		for(int y=0;y<AllSize.YBlockNum;y++)
			for(int x=0;x<AllSize.XBlockNum;x++){
				int pictureNum=(int)(Math.random()*6)+1;
				Block.Buttons[y][x].PictureNum=pictureNum;
			}
	}
	private static void InitializePicture(String str){
		/*
		 * 根据初始化的数字，对地图中按钮填充对应的图片
		 */
		for(int y=0;y<AllSize.YBlockNum;y++)
			for(int x=0;x<AllSize.XBlockNum;x++){
				int pictureNum=Block.Buttons[y][x].PictureNum;
				/*
				 * 按钮中加入对应图片
				 */
				new Pictures(str);
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
	private static boolean isXLine(){
		/*
		 * 判断是否纵排有不符合条件，可以消除的方块。若没有，则返回false。
		 */
		boolean isXLine=false;
		int Ycount=0;
		int Xcount=0;
		/*
		 * isXLine为第一种相同情况，即坐标为(x,y),(x,y+1),(x,y+2)三个方块颜色相同，则为true。
		 */
		for(Xcount=0;Xcount<AllSize.XBlockNum;Xcount++){
			for(Ycount=0;Ycount<AllSize.YBlockNum-2;Ycount++){
				int y=Ycount;
				int yPlus1=Ycount+1;
				int yPlus2=Ycount+2;
				boolean FirstEqual=(Block.Buttons[y][Xcount].PictureNum==Block.Buttons[yPlus1][Xcount].PictureNum);
				boolean SecondEqual=(Block.Buttons[yPlus1][Xcount].PictureNum==Block.Buttons[yPlus2][Xcount].PictureNum);
				if(FirstEqual&&SecondEqual){
					isXLine=true;
				}
			}
		}
		return isXLine;
	}
	private static boolean isYLine(){
		/*
		 * 判断是否横排有不符合条件的可以消除的方块。若没有，则返回false。
		 */
		boolean isYLine=false;
		int Ycount=0;
		int Xcount=0;
		/*
		 * isYLine为第二种相同情况，即坐标为(x,y),(x+1,y),(x+2,y)三个方块颜色相同，则为true。
		 */
		for(Ycount=0;Ycount<AllSize.YBlockNum;Ycount++){
			for(Xcount=0;Xcount<AllSize.XBlockNum-2;Xcount++){
				int x=Xcount;
				int xPlus1=Xcount+1;
				int xPlus2=Xcount+2;
				boolean FirstEqual=(Block.Buttons[Ycount][x].PictureNum==Block.Buttons[Ycount][xPlus1].PictureNum);
				boolean SecondEqual=(Block.Buttons[Ycount][xPlus1].PictureNum==Block.Buttons[Ycount][xPlus2].PictureNum);
				if(FirstEqual&&SecondEqual){
					isYLine=true;
				}
			}
		}
		return isYLine;
	}
	private static boolean CanCancel(){
		/*
		 * 判断是否可消，若整图都不可消，则返回false
		 * 
		 * 取出一个点(x,y)
		 * 判断可消可以分成六种情况：
		 * 情况1：(x,y+1)颜色相同，(x-1,y-1)(x+1,y-1)(x-1,y+2)(x+1,y+2)中有一个相同，则满足可消条件。
		 * 情况2：(x+1,y)相同，(x-1,y-1)(x-1,y+1)(x+2,y-1)(x+2,y+1)有一个相同
		 * 情况3：(x-1,y-1)和(x+1,y-1)
		 * 情况4：(x+1,y-1)(x+1,y+1)
		 * 情况5：(x+1,y+1)(x-1,y+1)
		 * 情况6：(x-1,y+1)(x-1.y-1)
		 */
		boolean CanCancel=false;
		int XYPictureNum=0;
		boolean Condition1=false;
		boolean Condition2=false;
		boolean Condition3=false;
		boolean Condition4=false;
		boolean Condition5=false;
		boolean Condition6=false;
		
		
		for(int y=0;y<AllSize.YBlockNum;y++)
			for(int x=0;x<AllSize.XBlockNum;x++){
				XYPictureNum=Block.Buttons[y][x].PictureNum;
			
				/*
				 * Condition1
				 * 情况1：(x,y+1)颜色相同，(x-1,y-1)(x+1,y-1)(x-1,y+2)(x+1,y+2)中有一个相同，则满足可消条件。
				 */
				{
					if(y!=AllSize.YBlockNum-1){
						int XYPlus1PictureNum=Block.Buttons[y+1][x].PictureNum;
						if(XYPlus1PictureNum==XYPictureNum){
							if(x==0&&y==0){
								//左上顶点
								int XPlus1YPlus2PictureNum=Block.Buttons[y+2][x+1].PictureNum;						    	
								if(XPlus1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(x==AllSize.XBlockNum-1&&y==0){
								//右上顶点
								int XSub1YPlus2PictureNum=Block.Buttons[y+2][x-1].PictureNum;
								if(XSub1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(y==0&&x!=AllSize.XBlockNum-1&&x!=0){
								//上边除顶点
								int XPlus1YPlus2PictureNum=Block.Buttons[y+2][x+1].PictureNum;	
								int XSub1YPlus2PictureNum=Block.Buttons[y+2][x-1].PictureNum;
								if(XPlus1YPlus2PictureNum==XYPictureNum||XSub1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(x==0&&y!=0&&y!=AllSize.YBlockNum-2){
								//左边除顶点
								int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
								int XPlus1YPlus2PictureNum=Block.Buttons[y+2][x+1].PictureNum;
								if(XPlus1YSub1PictureNum==XYPictureNum||XPlus1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(x==AllSize.XBlockNum-1&&y!=0&&y!=AllSize.YBlockNum-2){
								//右边除顶点
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								int XSub1YPlus2PictureNum=Block.Buttons[y+2][x-1].PictureNum;
								if(XSub1YSub1PictureNum==XYPictureNum||XSub1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(y==AllSize.YBlockNum-2&&x==0){
								//左下边界
								int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
								if(XPlus1YSub1PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(y==AllSize.YBlockNum-2&&x==AllSize.XBlockNum-1){
								//右下边界
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								if(XSub1YSub1PictureNum==XYPictureNum)
									Condition1=true;
							}
							else if(y==AllSize.YBlockNum-2&&x!=AllSize.XBlockNum-1&&x!=0){
								//下边界除顶点
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
								if(XSub1YSub1PictureNum==XYPictureNum||XPlus1YSub1PictureNum==XYPictureNum){
									Condition1=true;
								}
							}
							else{
								//不是边界的一般情况
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
								int XSub1YPlus2PictureNum=Block.Buttons[y+2][x-1].PictureNum;
								int XPlus1YPlus2PictureNum=Block.Buttons[y+2][x+1].PictureNum;
								if(XSub1YSub1PictureNum==XYPictureNum||XPlus1YSub1PictureNum==XYPictureNum||XSub1YPlus2PictureNum==XYPictureNum||XPlus1YPlus2PictureNum==XYPictureNum)
									Condition1=true;
							}
						}	
					}	
				}
					
				 /*
				  * Condition2
				  * 情况2：(x+1,y)相同，(x-1,y-1)(x-1,y+1)(x+2,y-1)(x+2,y+1)有一个相同
				  */
				 {
					  if(x!=AllSize.XBlockNum-1){
						  int XPlus1YPictureNum=Block.Buttons[y][x+1].PictureNum;
						  if(XPlus1YPictureNum==XYPictureNum){
							 if(x==0&&y==0){
								//左上顶点
								int XPlus2YPlus1PictureNum=Block.Buttons[y+1][x+2].PictureNum;
								if(XYPictureNum==XPlus2YPlus1PictureNum)
									Condition2=true;
							}
							 else if(x==0&&y==AllSize.YBlockNum-1){
								//左下顶点
								int XPlus2YSub1PictureNum=Block.Buttons[y-1][x+2].PictureNum;
								if(XYPictureNum==XPlus2YSub1PictureNum)
									Condition2=true;
							}
							else if(x==0&&y!=0&&y!=AllSize.YBlockNum-1){
								//左边除顶点
								int XPlus2YPlus1PictureNum=Block.Buttons[y+1][x+2].PictureNum;
								int XPlus2YSub1PictureNum=Block.Buttons[y-1][x+2].PictureNum;
								if(XPlus2YPlus1PictureNum==XYPictureNum||XPlus2YSub1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else if(x!=0&&y==0&&x!=AllSize.XBlockNum-2){
								//上边除顶点
								int XPlus2YPlus1PictureNum=Block.Buttons[y+1][x+2].PictureNum;
								int XSub1YPlus1PictureNum=Block.Buttons[y+1][x-1].PictureNum;
								if(XPlus2YPlus1PictureNum==XYPictureNum||XSub1YPlus1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else if(x!=0&&y==AllSize.YBlockNum-1&&x!=AllSize.XBlockNum-2){
								//下边除顶点
								int XPlus2YSub1PictureNum=Block.Buttons[y-1][x+2].PictureNum;
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								if(XPlus2YSub1PictureNum==XYPictureNum||XSub1YSub1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else if(x==AllSize.XBlockNum-2&&y==0){
								//右上顶点
								int XSub1YPlus1PictureNum=Block.Buttons[y+1][x-1].PictureNum;
								if(XSub1YPlus1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else if(x==AllSize.XBlockNum-2&&y==AllSize.YBlockNum-1){
								//右下顶点
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								if(XSub1YSub1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else if(x==AllSize.XBlockNum-2&&y!=0&&y!=AllSize.YBlockNum-1){
								//右边除顶点
								int XSub1YPlus1PictureNum=Block.Buttons[y+1][x-1].PictureNum;
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								if(XSub1YPlus1PictureNum==XYPictureNum||XSub1YSub1PictureNum==XYPictureNum)
									Condition2=true;
							}
							else{
								//一般情况
								int XSub1YPlus1PictureNum=Block.Buttons[y+1][x-1].PictureNum;
								int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
								int XPlus2YPlus1PictureNum=Block.Buttons[y+1][x+2].PictureNum;
								int XPlus2YSub1PictureNum=Block.Buttons[y-1][x+2].PictureNum;
								if(XSub1YPlus1PictureNum==XYPictureNum||XSub1YSub1PictureNum==XYPictureNum||XPlus2YPlus1PictureNum==XYPictureNum||XPlus2YSub1PictureNum==XYPictureNum)
									Condition2=true;
							}
						}
					  }
				 }
				   
				 /*
				  * Condition3
				  * 情况3：(x-1,y-1)和(x+1,y-1)
		          */
				 {
				     if(x!=0&&x!=AllSize.XBlockNum-1&&y!=0){
				    	 int XSub1YSub1PictureNum=Block.Buttons[y-1][x-1].PictureNum;
				         int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
				         if(XSub1YSub1PictureNum==XYPictureNum&&XPlus1YSub1PictureNum==XYPictureNum)
				        	 Condition3=true;
				     }
				 }
				    
			     /*
				  * Condition4
				  * 情况4：(x+1,y-1)(x+1,y+1)
				  */
				 {
					 if(x!=AllSize.XBlockNum-1&&y!=0&&y!=AllSize.YBlockNum-1){
						 int XPlus1YSub1PictureNum=Block.Buttons[y-1][x+1].PictureNum;
						 int XPlus1YPlus1PictureNum=Block.Buttons[y+1][x+1].PictureNum;
						 if(XPlus1YSub1PictureNum==XYPictureNum&&XPlus1YPlus1PictureNum==XYPictureNum)
							 Condition4=true;
					 }
				 }
				     
				 /*
				  * Condition5
				  * 情况5：(x+1,y+1)(x-1,y+1)
				  */
				 {
					 if(x!=AllSize.XBlockNum-1&&x!=0&&y!=AllSize.YBlockNum-1){
						 int XPlus1YPlus1PictureNum=Block.Buttons[x+1][y+1].PictureNum;
						 int XSub1YPlus1PictureNum=Block.Buttons[x-1][y+1].PictureNum;
						 if(XPlus1YPlus1PictureNum==XYPictureNum&&XSub1YPlus1PictureNum==XYPictureNum)
							 Condition5=true;
					 }
				 }
				      
				 /*
				  * Condition6
				  * 情况6：(x-1,y+1)(x-1.y-1)
				  */
				 {
					 if(x!=0&&y!=0&&y!=AllSize.YBlockNum-1){
						 int XSub1YPlus1PictureNum=Block.Buttons[x-1][y+1].PictureNum;
						 int XSub1YSub1PictureNum=Block.Buttons[x-1][y-1].PictureNum;
						 if(XSub1YPlus1PictureNum==XYPictureNum&&XSub1YSub1PictureNum==XYPictureNum)
							 Condition6=true;
					 }  
				 }
			}
		CanCancel=Condition1||Condition2||Condition3||Condition4||Condition5||Condition6;
		return CanCancel;
	}
}
