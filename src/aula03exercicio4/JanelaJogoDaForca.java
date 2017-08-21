
package aula03exercicio4;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaJogoDaForca extends JFrame{
    private final JLabel etiqueta1;
    private final JLabel etiqueta2;
    private final JLabel etiqueta3;
    private final JPasswordField palavraSecreta;
    private final JTextField texto;
    private final JLabel etiqueta4;

    public JanelaJogoDaForca() throws HeadlessException {
        etiqueta1 = new JLabel("BEM VINDO AO JOGO DA FORCA!!");
        add(etiqueta1);

        String palavras[] = {"sistemas", "computacao", "interface","programacao"};
        palavraSecreta = new JPasswordField();
        palavraSecreta.setText( palavras[(int)(Math.random()*palavras.length)]); 
        
        etiqueta2 = new JLabel("Se você errar 5 vezes, perde o jogo.");
        add(etiqueta2);        
        
        etiqueta3 = new JLabel("Descubra a palavra: " + palavraSecreta);
        add(etiqueta3);
        etiqueta4 = new JLabel("Digite uma letra");
        add(etiqueta4);
        texto = new JTextField(2);
        add(texto);
    }
    
}
