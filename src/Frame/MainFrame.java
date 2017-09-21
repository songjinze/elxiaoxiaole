package Frame;
import Game.*;
import Sound.SoundConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.DoubleConsumer;

public class MainFrame extends JFrame{

	/**
	 * 消消乐游戏界面
	 * 
	 */
	private static final long serialVersionUID = 3468402452021408007L;
	    
	private  int chaserX=(AllSize.mainFrameWidth-AllSize.PanelWidth)/2;
	public  int runnerX=AllSize.mainFrameWidth/3;
	public  int chaserY=AllSize.mainFrameHeight-AllSize.PanelHeight-3*AllSize.BlockHeight;
	public  int runnerY=AllSize.mainFrameHeight-AllSize.PanelHeight-3*AllSize.BlockHeight;
	public  double temp=0;
	public String str;
	public int fastCount=0;
	public boolean isFast=false;
	public boolean cheerUpFinish=false;
	public boolean Finished=false;
	DrawPanel drawPanel;
	private String chapterString;
	
	public static int hammerUse=0;
	private int reconstructUse=0;
	public static int sameUse=0;
	
	public MainFrame(String str){
		
		chapterString=str;
		setUndecorated(true);
		this.str=str;
		setLayout(null);
		
		
		ImageIcon bc=Pictures.mainbc;
		bc.setImage(bc.getImage().getScaledInstance(AllSize.mainFrameWidth, 640, Image.SCALE_AREA_AVERAGING));
		JLabel label=new JLabel(bc);
		label.setBounds(0, 160, AllSize.mainFrameWidth, 640);
		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel imagePanel = (JPanel)getContentPane();  
        imagePanel.setOpaque(false);  
		
		JPanel tools=new JPanel();
		tools.setPreferredSize(new Dimension(100,600));
		tools.setBounds(0, 160, 100, 600);
		getContentPane().add(tools);
		tools.setLayout(new GridLayout(3, 1));
		tools.setOpaque(false);
		JButton  hammer=new JButton();
		JButton  reconstruct=new JButton();
		JButton  same=new JButton();
		
		hammer.addActionListener(new ClickHammer());
		reconstruct.addActionListener(new ClickReconstruct());
		same.addActionListener(new ClickSame());
	
		
		tools.add(hammer);
		tools.add(reconstruct);
		tools.add(same);
		
		ImageIcon hammer_=Pictures.hammer;
		hammer_.setImage(hammer_.getImage().getScaledInstance(100, 200,Image.SCALE_AREA_AVERAGING));
		
		hammer.setIcon(hammer_);
		
		ImageIcon same_=Pictures.same;
		same_.setImage(same_.getImage().getScaledInstance(100, 200,Image.SCALE_AREA_AVERAGING));
		
		same.setIcon(same_);
		
		
		ImageIcon reconsreuct_=Pictures.reconstruct;
		reconsreuct_.setImage(reconsreuct_.getImage().getScaledInstance(100, 200,Image.SCALE_AREA_AVERAGING));
		reconstruct.setIcon(reconsreuct_);
		
	
		
		JPanel controls=new JPanel();
		controls.setPreferredSize(new Dimension(200,303));
		controls.setBounds(800, 160, 200, 300);
		getContentPane().add(controls);
		controls.setOpaque(false);
		
		controls.setLayout(null);
		JButton  return_b=new JButton();
		JButton  first=new JButton();
		JButton  restart=new JButton();
		
		return_b.addActionListener(new ClickToBackMenu());
		first.addActionListener(new ClickBackMenu());
		restart.addActionListener(new ClickRestartMenu());
		
		return_b.setBounds(0, 0, 200, 80);
		first.setBounds(0, 101, 200, 80);
		restart.setBounds(0, 202, 200, 80);
		
		ImageIcon restart__=Pictures.Restart;
		restart__.setImage(restart__.getImage().getScaledInstance(200, 80, Image.SCALE_AREA_AVERAGING));
		restart.setIcon(restart__);
		
		ImageIcon return__=Pictures.Return;
		return__.setImage(return__.getImage().getScaledInstance(200, 80, Image.SCALE_AREA_AVERAGING));
		return_b.setIcon(return__);
		
		ImageIcon first_=Pictures.Exit;
		first_.setImage(first_.getImage().getScaledInstance(200, 80, Image.SCALE_AREA_AVERAGING));
		first.setIcon(first_);
		
		controls.add(restart);
		controls.add(first);
		controls.add(return_b);
		
		
		drawPanel=new DrawPanel();
		drawPanel.setPreferredSize(new Dimension(AllSize.mainFrameWidth,160));
		drawPanel.setBounds(0, 0, AllSize.mainFrameWidth, 160);
		getContentPane().add( drawPanel);
		
		switch(str){
		case "1":new SoundConnector("Sound1");break;
		case "2":new SoundConnector("Gentleman");break;
		case "3":new SoundConnector("missyou");break;
		case "4":new SoundConnector("GALA");break;
		}
		
		SoundConnector.a.loop();
		
		JPanel return_panel=Connector.ReturnPanel(str);
		return_panel.setBounds(150, 160, 600, 603);
		return_panel.setOpaque(false);
		getContentPane().add(return_panel);
		setSize(AllSize.mainFrameWidth,AllSize.mainFrameHeight);
		setBounds(400,70,AllSize.mainFrameWidth,AllSize.mainFrameHeight);
		
		
		setVisible(true);
		
		
		new Thread(){
			public void run(){
				goTimeLimit();
				if(runnerX<=chaserX){
					SoundConnector.a.stop();
					dispose();
					new catched_frame(str);
				}else if(runnerX>=AllSize.mainFrameWidth-3*AllSize.BlockWidth)
				{
					SoundConnector.a.stop();
					switch(str){
					case "1":
						dispose();
						if(hammerUse+reconstructUse+sameUse<10){
							if(hammerUse==0){
								PositionandSize.hammerReword1=true;
							}
							if(reconstructUse==0){
								PositionandSize.reconstructReword1=true;
							}
							if(sameUse==0){
								PositionandSize.sameReword1=true;
							}
						}
						
						
						new Episodes2();
						break;
					case "2":
						dispose();
						if(hammerUse+reconstructUse+sameUse<10){
							if(hammerUse==0){
								PositionandSize.hammerReword2=true;
							}
							if(reconstructUse==0){
								PositionandSize.reconstructReword2=true;
							}
							if(sameUse==0){
								PositionandSize.sameReword2=true;
							}
						}
						
						
						
						
						new episode3();
						break;
					case "3":
						dispose();
						if(hammerUse+reconstructUse+sameUse<10){
							if(hammerUse==0){
								PositionandSize.hammerReword3=true;
							}
							if(reconstructUse==0){
								PositionandSize.reconstructReword3=true;
							}
							if(sameUse==0){
								PositionandSize.sameReword3=true;
							}
						}
						
					
						new episode4();
						break;
					case "4":
						dispose();
						if(hammerUse+reconstructUse+sameUse<10){
							if(hammerUse==0){
								PositionandSize.hammerReword4=true;
							}
							if(reconstructUse==0){
								PositionandSize.reconstructReword4=true;
							}
							if(sameUse==0){
								PositionandSize.sameReword4=true;
							}
						}
						
						
						
						
						new Success();
						break;
					}
					hammerUse=0;
					reconstructUse=0;
					sameUse=0;
					
				}
			}
		}.start();
		
	}
	
	
	
	class ClickRestartMenu implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
			Finished=true;
			SoundConnector.a.stop();
			InitializeMap.isFirstInitialize=true;
			
			new MainFrame(str);
		}
	}
	class ClickBackMenu implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
			Finished=true;
			SoundConnector.a.stop();
			new Start_frame();
		}
	}
	class ClickToBackMenu implements ActionListener{
		public void actionPerformed(ActionEvent e){
			dispose();
			Finished=true;
			SoundConnector.a.stop();
			new Enemy_choose_frame();
		}
	}
	class ClickHammer implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
			ButtonActionListener.toolNum=1;
				
			
		  
		}
	}
	class ClickReconstruct implements ActionListener{
		public void actionPerformed(ActionEvent e){
			reconstructUse++;
			InitializeMap.ScoreNum+=5;
			isFast=true;
				
			
		}
	}
	class ClickSame implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
				ButtonActionListener.toolNum=3;
			
		}
	}
	
	
	class DrawPanel extends JPanel{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -8809429384726052950L;
		DrawPanel(){
			
			setPreferredSize(new Dimension(AllSize.mainFrameWidth,AllSize.mainFrameHeight-AllSize.PanelHeight));
			setVisible(true);
		}
		public void paintComponent(Graphics g){
			Image image1;
			if(isFast&&fastCount<20){
				image1=Pictures.fastRunning.getImage();
				fastCount++;
			}else{
				image1=Pictures.running.getImage();
				fastCount=0;
				isFast=false;
			}
			Image image2;
			switch(chapterString){
			case "1":image2=Pictures.chaser1.getImage();break;
			case "2":image2=Pictures.chaser2.getImage();break;
			case "3":image2=Pictures.death.getImage();break;
			default:image2=Pictures.chaser3.getImage();break;
			}
			
			
			
			Image image3=Pictures.scene1.getImage();
			
			g.drawImage(image3, 0, 0, this);
			g.drawImage(image1, runnerX, runnerY, this);
			g.drawImage(image2, chaserX, chaserY, this);
		}
	}
	
	private void goTimeLimit(){
			while(runnerX>chaserX&&runnerX<AllSize.mainFrameWidth-3*AllSize.BlockWidth&&!Finished){
				runnerX=InitializeMap.ScoreNum+AllSize.mainFrameWidth/3;
				temp+=0.2;
				if(temp>1){
					chaserX++;
					temp--;
				}
				if(runnerX-chaserX<AllSize.BlockWidth&&!cheerUpFinish){
					SoundConnector s1=new SoundConnector("cheerUp");
					s1.b.play();
					cheerUpFinish=true;
				}
				if(runnerX-chaserX>AllSize.BlockWidth*4){
					cheerUpFinish=false;
				}
				drawPanel.setBackground(Color.white);
				drawPanel.repaint();
				try{
					Thread.sleep(50);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
	}
	
}
