package aula03exercicio4;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaJogoDaForca extends JFrame {

    private final JLabel etiqueta1;
    private final JLabel etiqueta2;
    //private final JLabel etiqueta3;
    private final JPasswordField palavraSecreta;
    private final JTextField texto;
    private final JLabel etiqueta4;
    private final JButton btnEnvia = new JButton("Aperte para enviar a letra");
    String interrogacao = " ";

    public JanelaJogoDaForca() throws HeadlessException {
        super("Jogo da Forca");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        etiqueta1 = new JLabel("BEM VINDO AO JOGO DA FORCA!! Se você errar 5 vezes, perde o jogo.");
        add(etiqueta1);

        String palavras[] = {"sistemas", "computacao", "interface", "programacao"};
        palavraSecreta = new JPasswordField();
        palavraSecreta.setText(palavras[(int) (Math.random() * palavras.length)]);

        for (int i = 0; i < palavraSecreta.getPassword().length; i++) {
            interrogacao += " ?";
        }
        etiqueta2 = new JLabel("Palavra: " + interrogacao);

        etiqueta4 = new JLabel("Digite uma letra:");
        texto = new JTextField(2);
        add(etiqueta4);
        add(texto);
        add(etiqueta2);
        add(btnEnvia);
        btnEnvia.addActionListener(new BotaoEnvia());
    }

    private class BotaoEnvia implements ActionListener {

        public BotaoEnvia() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int contador = 0;
            int contador2 = 0;
            char[] mudanca = interrogacao.toCharArray();
            char[] test = texto.getText().toCharArray();
            String palavra = palavraSecreta.toString();
            System.out.println(mudanca);
            System.out.println(palavra);
            while (contador < 5) {
                for (int i = 0; i < palavraSecreta.getPassword().length; i++) {
                    if (test[0] == palavra.charAt(i)) {
                        mudanca[i] = test[0];
                        contador2++;
                    }
                }
                interrogacao = mudanca.toString();
                System.out.println();
                contador++;
                if (contador < 5) {
                    JOptionPane.showMessageDialog(null, "Você já ainda tem " + (5 - contador) + " tentativas. Escolha com sabedoria");
                } else {
                    JOptionPane.showMessageDialog(null, "Você já esgotou as suas chances.");
                }
            }
        }
    }
}
