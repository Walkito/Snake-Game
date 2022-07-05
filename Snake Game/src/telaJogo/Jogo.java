package telaJogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import snakeModel.Snake;
import threads.RunnableSnakeGrow;
import threads.RunnableSnakeMove;

@SuppressWarnings("serial")
public class Jogo extends JFrame implements KeyListener{
	
	public static ArrayList<JPanel> tamanhoCobra = new ArrayList<JPanel>();
	
	Random random = new Random();
	
	JPanel bordas = new JPanel();
	public static JPanel campo = new JPanel();
	JPanel snake = new JPanel();
	JPanel comida = new JPanel();
	static JLabel pontuacao = new JLabel("0");
	
	public static int tamanho = 0;
	public static int xAnterior;
	public static int yAnterior;
	
	public static Snake cobra = new Snake(10, 10, 15, 15);
	
	boolean ligado = true;
	
	Thread snakeMove = new Thread(new RunnableSnakeMove());
	
	public Jogo() {
		editarFrame();
		editarComponentes();
		tamanhoCobra.add(snake);
		snakeMove.start();
		
		while(ligado == true) {
			pontuacao.setText(String.valueOf(tamanho));
			
			tamanhoCobra.get(0).setBounds(cobra.getX(), cobra.getY(), cobra.getLargura(), cobra.getAltura());
					
			Rectangle retanguloCobra = tamanhoCobra.get(0).getBounds();
			Rectangle retanguloComida = comida.getBounds();
			
			if(retanguloCobra.intersects(retanguloComida) == true) {
				Thread snakeGrow = new Thread(new RunnableSnakeGrow());
				snakeGrow.start();
				comida.setLocation(random.nextInt(630), random.nextInt(430));
				
				for(int i = 0; i < tamanhoCobra.size(); i++) {
					if(retanguloComida.intersects(tamanhoCobra.get(i).getBounds())) {
						comida.setLocation(random.nextInt(630), random.nextInt(430));
					}	
				}
			}
						
			if(tamanhoCobra.size() >= 5) {
				for(int i = 2; i < tamanhoCobra.size(); i++) {
					if(retanguloCobra.intersects(tamanhoCobra.get(i).getBounds())) {
						snakeMove.stop();
						JOptionPane.showMessageDialog(null, "Game Over. Sua pontuação foi de " + tamanho);
						
						if(JOptionPane.OK_OPTION == 0) {
							this.dispose();
						}
						
						ligado = false;
					}	
				}
			}
			
			if(cobra.getX() <= -10 || cobra.getX() >= 770) {
				snakeMove.stop();
				JOptionPane.showMessageDialog(null, "Game Over. Sua pontuação foi de " + tamanho);
				
				if(JOptionPane.OK_OPTION == 0) {
					this.dispose();
					ligado = false;
				}
			}
			
			if(cobra.getY() <= -10 || cobra.getY() >= 550) {
				snakeMove.stop();
				JOptionPane.showMessageDialog(null, "Game Over. Sua pontuação foi de " + tamanho);
				
				if(JOptionPane.OK_OPTION == 0) {
					this.dispose();
					ligado = false;
				}
			}
			
		}
	}
	
	public Jogo(String nome) {
		
	}
		
	public void editarFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(350, 100);
		setSize(800, 600);
		setResizable(false);
		setTitle("Snake Game");
		setVisible(true);
		this.addKeyListener(this);
	}
	
	public void editarComponentes() {
		this.add(bordas);
		bordas.setLayout(null);
		bordas.setBackground(Color.BLACK);
		
		bordas.add(campo);
		campo.setBackground(Color.LIGHT_GRAY);
		campo.setBounds(10, 10, 765, 540);
		campo.setLayout(null);
		campo.add(snake);
		campo.add(comida);
		campo.add(pontuacao);
		
		snake.setBackground(new Color(0, 128, 0));
		
		comida.setBackground(Color.BLACK);
		comida.setBounds(random.nextInt(630), random.nextInt(430), 15, 15);
		
		pontuacao.setBounds(20, -80, 100, 200);
		pontuacao.setFont(new Font("Arial", Font.BOLD, 32));
		
	}
		
	public void keyPressed(KeyEvent e) {
		int codigo = e.getKeyCode();
		
		switch (codigo) {
			case 37:
			RunnableSnakeMove.direcao = "esquerda";
			break;
			case 38:
			RunnableSnakeMove.direcao = "cima";
			break;
			case 39:
			RunnableSnakeMove.direcao = "direita";
			break;
			case 40: 
			RunnableSnakeMove.direcao = "baixo";
			break;
		}
		
	}
		
	public static void main(String[] args) {
		new Jogo();
	}

	public void keyTyped(KeyEvent e) {
		
	}


	
	public void keyReleased(KeyEvent e) {
		
		
	}
}
