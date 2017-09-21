package Game;

import java.util.ArrayList;
import java.util.Collections;

public class AutoCancel {
	
	public static void autoCancel(){
	     ArrayList<Button> buttons=new ArrayList<>();
	    
	     boolean isSame=false;
	    
	    	//纵排五个相同	 
	for(int x=0;x<AllSize.XBlockNum;x++){
	  for(int y=0;y<AllSize.YBlockNum-4;y++){	
		if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+3][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+4][x].PictureNum)){
			for(int i=0;i<5;i++){
				for(Button butt:buttons){
					if(Block.Buttons[y+i][x].equals(butt)){
						isSame=true;
						break;
					}
				}if(!isSame){
					buttons.add(Block.Buttons[y+i][x]);	
					isSame=false;
				}	
			}
		}
	}
	}
	//纵排四个相同
	for(int x=0;x<AllSize.XBlockNum;x++){
		  for(int y=0;y<AllSize.YBlockNum-3;y++){
			  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+3][x].PictureNum)){
				  for(int i=0;i<4;i++){
					  for(Button butt:buttons){
							if(Block.Buttons[y+i][x].equals(butt)){
								isSame=true;
								break;
							}
						}	if(!isSame){
							buttons.add(Block.Buttons[y+i][x]);	
							isSame=false;
						}	 
				  }
			  }
		  }
		  }
	//纵排三个相同
	for(int x=0;x<AllSize.XBlockNum;x++){
		  for(int y=0;y<AllSize.YBlockNum-2;y++){
			  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)){
				  for(int i=0;i<3;i++){
					  for(Button butt:buttons){
							if(Block.Buttons[y+i][x].equals(butt)){
								isSame=true;
								break;
							}
						}	if(!isSame){
							buttons.add(Block.Buttons[y+i][x]);	
							isSame=false;
						}	   
				  }
			  }
		  }
	}
	//横排五个相同
	for(int y=0;y<AllSize.XBlockNum;y++){
		  for(int x=0;x<AllSize.YBlockNum-4;x++){	
			if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+3].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+4].PictureNum)){
				for(int i=0;i<5;i++){
					 for(Button butt:buttons){
							if(Block.Buttons[y][x+i].equals(butt)){
								isSame=true;
								break;
							}
						}	if(!isSame){
							buttons.add(Block.Buttons[y][x+i]);	
							isSame=false;
						}	 
				}
			  }
		  }
	}
	//横排四个相同
	for(int y=0;y<AllSize.XBlockNum;y++){
		  for(int x=0;x<AllSize.YBlockNum-3;x++){
			  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+3].PictureNum)){
				  for(int i=0;i<4;i++){
					  for(Button butt:buttons){
							if(Block.Buttons[y][x+i].equals(butt)){
								isSame=true;
								break;
							}
						}	if(!isSame){
							buttons.add(Block.Buttons[y][x+i]);	
							isSame=false;
						}	 
				  }
			  }
		  }
		  }
	//横排三个相同
	for(int y=0;y<AllSize.XBlockNum;y++){
		  for(int x=0;x<AllSize.YBlockNum-2;x++){
			  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)){
				  for(int i=0;i<3;i++){
					  for(Button butt:buttons){
							if(Block.Buttons[y][x+i].equals(butt)){
								isSame=true;
								break;
							}
						}	if(!isSame){
							buttons.add(Block.Buttons[y][x+i]);		
							isSame=false;
						}	 
				  }
			  }
		  }
		  }
	Collections.sort(buttons);
	InitializeMap.ScoreNum+=buttons.size();
	Cancel.Buttons=buttons;
	
	}
	
	
	//判断是否有需要消除的
	 static boolean judge(){
		 boolean isAutoCancel=false;
		 for(int x=0;x<AllSize.XBlockNum;x++){
			  for(int y=0;y<AllSize.YBlockNum-4;y++){	
				if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+3][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+4][x].PictureNum)){
					isAutoCancel=true;
	 }
	 }
		 }
		 for(int x=0;x<AllSize.XBlockNum;x++){
			  for(int y=0;y<AllSize.YBlockNum-3;y++){
				  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+3][x].PictureNum)){
					  isAutoCancel=true;
	            }
			  }
		 }
		 for(int x=0;x<AllSize.XBlockNum;x++){
			  for(int y=0;y<AllSize.YBlockNum-2;y++){
				  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y+1][x].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y+2][x].PictureNum)){
					  isAutoCancel=true;
				  }
			  }
		 }
		 for(int y=0;y<AllSize.XBlockNum;y++){
			  for(int x=0;x<AllSize.YBlockNum-4;x++){	
				if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+3].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+4].PictureNum)){
			          isAutoCancel=true;
				}
			  }
		 }
		 for(int y=0;y<AllSize.XBlockNum;y++){
			  for(int x=0;x<AllSize.YBlockNum-3;x++){
				  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+3].PictureNum)){
					   isAutoCancel=true;
				  }
			  }
		 }
		 for(int y=0;y<AllSize.XBlockNum;y++){
			  for(int x=0;x<AllSize.YBlockNum-2;x++){
				  if((Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+1].PictureNum)&&(Block.Buttons[y][x].PictureNum==Block.Buttons[y][x+2].PictureNum)){
					  isAutoCancel=true;
				  }
			  }
		 }
		 return isAutoCancel;
}
}
	

