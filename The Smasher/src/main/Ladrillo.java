package main;

import java.awt.Image;

import es.techtalents.ttgdl.gui.MainWindow;
import es.techtalents.ttgdl.gui.window.Window;
import es.techtalents.ttgdl.image.ImageLoader;
import es.techtalents.ttgdl.sprite.Sprite;

public class Ladrillo extends Sprite{
	int nivel = 1;
	private Window w;
	int vida = 3; 
	int numX = 10;
	int numY = 4;
	int width = MainWindow.WIDTH/numX;
	int height = (MainWindow.HEIGHT/3)/numY;
	Image ladrilloNv1 = ImageLoader.loadImage("Ladrillos/RaquetaNv1.png");
	Image ladrilloNv2 = ImageLoader.loadImage("Ladrillos/RaquetaNv2.png");
	Image ladrilloNv3 = ImageLoader.loadImage("Ladrillos/RaquetaNv3.png");


	public Ladrillo(Window w){
		this.w = w;
		ladrilloNv1 = ImageLoader.loadImage("Ladrillos/RaquetaNv1.png").getScaledInstance(ladrilloNv1.getWidth(null) - 10, ladrilloNv1.getHeight(null), Image.SCALE_SMOOTH);
		ladrilloNv2 = ImageLoader.loadImage("Ladrillos/RaquetaNv2.png").getScaledInstance(ladrilloNv2.getWidth(null) - 10, ladrilloNv2.getHeight(null), Image.SCALE_SMOOTH);
		ladrilloNv3 = ImageLoader.loadImage("Ladrillos/RaquetaNv3.png").getScaledInstance(ladrilloNv3.getWidth(null) - 10, ladrilloNv3.getHeight(null), Image.SCALE_SMOOTH);
		setImage(ladrilloNv1);

	}


	@Override
	public void act() {
		

	}
	
	public boolean isDead(){
		return vida < 0;
	}
	
	@Override
	public void onColision(Sprite arg0) {
		if(arg0 instanceof Pelota){
			vida--;
		}
			
		if(vida == 3){
			setImage(ladrilloNv1);
		}
		else if(vida == 2){
			setImage(ladrilloNv2);
		}
		else if(vida == 1){
			setImage(ladrilloNv3);
		}else if(vida == 0){
			w.removeSprite(this);
		}
		
	}



}
