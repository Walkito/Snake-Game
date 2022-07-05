package threads;

import snakeModel.Snake;
import telaJogo.Jogo;

public class RunnableSnakeMove implements Runnable {
	Snake conexaoSnake = new Snake();
	
	public static String direcao = "direita";
	
	boolean moveu = false;
	
	public void run() {
		while(true) {				
			for (int i = Jogo.tamanhoCobra.size() - 1; i >= 0; i--) {
				
				if(i == 0) {
					mover();
					moveu = true;
				} else {
				int xAnterior = Jogo.tamanhoCobra.get(i-1).getX();
				int yAnterior = Jogo.tamanhoCobra.get(i-1).getY();
				Jogo.tamanhoCobra.get(i).setBounds(xAnterior, yAnterior, Jogo.cobra.getLargura(), Jogo.cobra.getAltura());
				Jogo.campo.add(Jogo.tamanhoCobra.get(i));
				Jogo.campo.repaint();
				}
			}
			
			if (moveu == false) {				
				mover();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public void mover() {
		switch (direcao) {
			case "direita":
			conexaoSnake.moverDireita();
			break;
			case "esquerda":
			conexaoSnake.moverEsquerda();
			break;
			case "cima":
			conexaoSnake.moverCima();
			break;
			case "baixo":
			conexaoSnake.moverBaixo();
			break;
		}
	}
}