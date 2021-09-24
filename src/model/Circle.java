package model;

import processing.core.PApplet;

public class Circle  {


	private int posX,posY,r,g,b;
    PApplet app;   
    int velocidad=20;
    float ease = 0.5f;
    public Circle(PApplet app,int posX,int posY){
    	this.app=app;
        this.posX=posX;
        this.posY = posY;
        this.r=255;
        this.g=255;
        this.b=255;
    }
    
    public void Move(int direction) {
    	
    	switch (direction) {
		case 1:
		//derecha
			this.posX+=velocidad;
			break;

		case -1:
			//izquierda
			this.posX-=velocidad;
			break;
			
		case 2:
			//arriba
			this.posY-=velocidad;
			break;
			
		case -2:
			// abajo
			this.posY+=velocidad;
			break;
		}
    	
    }
    
    public void Draw() {
		// TODO Auto-generated method stub
    	app.fill(this.r,this.g,this.b);
		app.ellipse(posX, posY, 80, 80);

	}

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
    
    

	
}
