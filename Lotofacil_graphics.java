import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JPanel;

public class Main extends JFrame implements ActionListener {
    private JButton aposta1, aposta2, aposta3;
    private JTextField textField;
    private JLabel label;
    private JLabel label2;
    private Random random;
    private int NumeroAposta = -1;

    public Main() {
        setTitle("Lotofácil ");
        setSize(650, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.setBackground(new Color(133, 133, 133));
        
        aposta1 = new JButton("Apostar de 0 a 100");
        aposta2 = new JButton("Apostar de A à Z");
        aposta3 = new JButton("Apostar em Par ou Ímpar");
        textField = new JTextField(16);
        label2 = new JLabel();
        label2.setText("Aposte Aqui!");
        label = new JLabel();
        label.setText("Digite o número ou letra aqui: ");

        aposta1.addActionListener(this);
        aposta2.addActionListener(this);
        aposta3.addActionListener(this);

        panel.add(label2);
        panel.add(aposta1);
        panel.add(aposta2);
        panel.add(aposta3);
        panel.add(label);
        panel.add(textField);

        add(panel);
        random = new Random();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aposta1) {
            int numeroAleatorio = random.nextInt(101);
            try {
                int numeroDigitado = Integer.parseInt(textField.getText());
                if (numeroDigitado < 0 || numeroDigitado > 100) {
                    label.setText("Aposta inválida.");
                } else {
                    if (numeroDigitado == numeroAleatorio) {
                        label.setText("Parabéns! Você ganhou R$ 1.000.000,00 reais.");
                        centralizarJanela();
                    } else {
                        label.setText("Infelizmente você errou, o número certo era: " + numeroAleatorio);
                    }
                }
            } catch (NumberFormatException ex) {
                label.setText("Digite um número válido.");
            }
        } else if (e.getSource() == aposta2) {
            String letraDigitada = textField.getText().toUpperCase();
            if (letraDigitada.length() != 1 || !Character.isLetter(letraDigitada.charAt(0))) {
                label.setText("Aposta inválida.");
            } else {
                char letraPremiada = 'P';
                if (letraDigitada.charAt(0) == letraPremiada) {
                    label.setText("Parabéns! Você ganhou R$ 1.000,00 reais.");
                    centralizarJanela();
                } else {
                    label.setText("Infelizmente você errou, a letra sorteada foi: " + letraPremiada);
                }
            }
        } else if (e.getSource() == aposta3) {
            try {
                int numeroDigitado = Integer.parseInt(textField.getText());
                if (numeroDigitado % 2 == 0) {
                    label.setText("Parabéns! Você ganhou R$ 500,00 reais.");
                    centralizarJanela();
                } else {
                    label.setText("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                }
            } catch (NumberFormatException ex) {
                label.setText("Digite um número válido.");
            }
        }
    }

    private void centralizarJanela() {
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Main lotofacil = new Main();
        lotofacil.setVisible(true);
    }
}
