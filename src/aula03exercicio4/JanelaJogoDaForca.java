package aula03exercicio4;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JanelaJogoDaForca extends JFrame {

    private final JLabel etiqueta1;
    private final JLabel etiqueta2;
    private int contadorErro = 0;
    //private final JLabel etiqueta3;
    private final JPasswordField palavraSecreta;
    private final JTextField texto;
    private final JLabel etiqueta4;
    private final JButton btnEnvia = new JButton("Aperte para enviar a letra");
    char[] interrogacao;

    public JanelaJogoDaForca() throws HeadlessException {
        super("Jogo da Forca");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        etiqueta1 = new JLabel("BEM VINDO AO JOGO DA FORCA!! Se você errar 5 vezes, perde o jogo.");
        add(etiqueta1);

        String palavras[] = {"sistemas", "computacao", "interface", "programacao", "computador", "programa", "ponteiro", "pilha", "fila", "arvore", "splaytree"};
        palavraSecreta = new JPasswordField();
        palavraSecreta.setText(palavras[(int) (Math.random() * palavras.length)]);
        interrogacao = new char[palavraSecreta.getPassword().length];
        for (int i = 0; i < palavraSecreta.getPassword().length; i++) {
            interrogacao[i] = '?';
        }
        etiqueta2 = new JLabel("Palavra: " + Arrays.toString(interrogacao));

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

            char[] test = texto.getText().toCharArray();
            //char[] palavra = palavraSecreta.getPassword();
            int i = 0;
            String pala = new String(palavraSecreta.getPassword());
            System.out.println(pala);
            System.out.println(test);

            if (pala.indexOf(test[0]) != -1) {
                while (i < pala.length()) {
                    if (pala.charAt(i) == test[0]) {
                        interrogacao[i] = test[0];
                        etiqueta2.setText(Arrays.toString(interrogacao));
                    }
                    i++;
                }
                JOptionPane.showMessageDialog(null, "Boa, você acertou a letra " + test[0]);
                texto.setText("");
                texto.requestFocus();
                if (Arrays.equals(interrogacao, palavraSecreta.getPassword())) {
                    JOptionPane.showConfirmDialog(null, "PARABÉNS!!! VOCÊ CONCLUIU O JOGO!");
                }
            } else {
                contadorErro++;
                if (contadorErro < 5) {
                    JOptionPane.showMessageDialog(null, "Você já ainda tem " + (5 - contadorErro) + " tentativas. Escolha com sabedoria");
                    texto.setText("");
                    texto.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Você já esgotou as suas chances. Tente novamente.");

                }
            }
        }
    }
}
