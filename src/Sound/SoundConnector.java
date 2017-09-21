package Sound;
import java.net.*;

import javax.sound.sampled.AudioInputStream;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.*;
public class SoundConnector{
	String str;
	public static AudioClip a;
	public static AudioClip b;
	public SoundConnector(String str){
		switch(str){
		case "a":new PlayLoopSound();break;
		case "Sound1":new PlaySound1();break;
		case "Sound2":new PlaySound2();break;
		case "gua" : new PlaySound3();break;
		case "episode1" : new PlayLoopSound4();break;
		case "episode2": new PlayLoopSound5();break;
		case "episode3": new PlayLoopSound6();break;
		case "episode4": new PlayLoopSound7();break;
		case "cheerUp": new PlaySound8();break;
		case "fail" :new PlaySound10();break;
		case "success": new PlaySound9();break;
		case "GALA": new PlaySound11();break;
		case "missyou":new PlaySound12();break;
		case "Gentleman":new PlaySound13();break;
		}
	}
	
	
}
class PlayLoopSound {
	
	PlayLoopSound(){
	try{
	
		URL url1=getClass().getResource("/Sound/开头.wav");
		SoundConnector.a=Applet.newAudioClip(url1);
       
	}catch(Exception e){
		e.printStackTrace();
	}
	
}	
}
class PlaySound1{
	PlaySound1(){
		try{
			
			URL url1=getClass().getResource("/Sound/episode5.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

class PlaySound2{
	PlaySound2(){
		try{
			
			URL url1=getClass().getResource("/Sound/尖叫.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
class PlaySound3{
	PlaySound3(){
		try{
		
			URL url1=getClass().getResource("/Sound/呱.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	        
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
class PlayLoopSound4 {
	
	PlayLoopSound4(){
	try{
	
		URL url1=getClass().getResource("/Sound/episode1.wav");
		SoundConnector.a=Applet.newAudioClip(url1);
       
	}catch(Exception e){
		e.printStackTrace();
	}
	
}	
}
class PlayLoopSound5 {
	
	PlayLoopSound5(){
	try{
	
		URL url1=getClass().getResource("/Sound/episode2.wav");
		SoundConnector.a=Applet.newAudioClip(url1);
       
	}catch(Exception e){
		e.printStackTrace();
	}
	
}	
}
class PlayLoopSound6 {
	
	PlayLoopSound6(){
	try{
	
		URL url1=getClass().getResource("/Sound/episode3.wav");
		SoundConnector.a=Applet.newAudioClip(url1);
       
	}catch(Exception e){
		e.printStackTrace();
	}
	
}	
}
class PlayLoopSound7 {
	
	PlayLoopSound7(){
	try{
	
		URL url1=getClass().getResource("/Sound/episode4.wav");
		SoundConnector.a=Applet.newAudioClip(url1);
       
	}catch(Exception e){
		e.printStackTrace();
	}
	
}	
}
class PlaySound8{
	PlaySound8(){
		try{
			
			URL url1=getClass().getResource("/Sound/cheerUp.wav");
			SoundConnector.b=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}
class PlaySound9{
	PlaySound9(){
		try{
		
			URL url1=getClass().getResource("/Sound/Applause.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}
class PlaySound10{
	PlaySound10(){
		try{
		
			URL url1=getClass().getResource("/Sound/Oh-No.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}
class PlaySound11{
	PlaySound11(){
		try{
			URL url1=getClass().getResource("/Sound/GALA.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}
class PlaySound12{
	PlaySound12(){
		try{
			URL url1=getClass().getResource("/Sound/Gentleman.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}
class PlaySound13{
	PlaySound13(){
		try{
			URL url1=getClass().getResource("/Sound/好想你.wav");
			SoundConnector.a=Applet.newAudioClip(url1);
	       
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}	
	}