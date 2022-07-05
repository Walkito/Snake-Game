package threads;

import java.awt.Color;

import javax.swing.JPanel;

import telaJogo.Jogo;

public class RunnableSnakeGrow implements Runnable {
	
	public void run() {
		Jogo.tamanho += 1;
		
		JPanel parteCobra = new JPanel();
		parteCobra.setBackground(Color.GREEN);
		parteCobra.setBounds(0, 0, Jogo.cobra.getLargura(), Jogo.cobra.getAltura());
		Jogo.tamanhoCobra.add(parteCobra);
		System.out.println(Jogo.tamanhoCobra.size());
	}
}


