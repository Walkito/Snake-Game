package snakeModel;

import java.util.ArrayList;

public class Snake {
	private static int x;
	private static int y;
	private static int largura;
	private static int altura;
	
	public static ArrayList<Integer> posX = new ArrayList<Integer>();
	public static ArrayList<Integer> posY = new ArrayList<Integer>();
	
	public Snake() {
		
	}
	
	public Snake(int x, int y, int largura, int altura) {
		this.x = x;
		this.y = y;
		this.largura = largura;
		this.altura = altura;
	}
	
	public int moverDireita() {
		this.x += 20;
		
		return this.x;
	}
	
	public int moverBaixo() {
		this.y+= 20;
		
		return this.y;
	}
	
	public int moverCima() {
		this.y -= 20;
		
		return this.y;
	}
	
	public int moverEsquerda() {
		this.x -= 20;
		
		return this.x;
	}
		
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
}
