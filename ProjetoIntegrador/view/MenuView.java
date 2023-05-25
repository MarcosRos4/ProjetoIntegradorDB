package ContaCorrenteProjeto.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel t1;
    String txt = "";

    public MenuView(){
        setTitle("Menu");
        setSize(640,480);
        GridLayout gl = new GridLayout(4,1,5,5);
        getContentPane().setLayout(gl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        t1= criarRotulo("ESCOLHA QUEM DESEJA ACESSAR");
        b1 = criarBotao("EMPRESAS");
        b2 = criarBotao("FUNCIONARIOS");
        add(b1);
        add(b2);
        setVisible(true);
    }

    private JLabel criarRotulo(String texto) {
        JLabel rotulo = new JLabel(texto);
        rotulo.setFont(new Font("Times new Roman", Font.BOLD, 18));
        add(rotulo);
        return rotulo;
    }
    private JPanel criarPainel() {
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 2));
        return p1;
    }

    private JTextField criarCaixaTexto() {
        JTextField texto = new JTextField("Texto de Exemplo");
        texto.setFont(new Font("Times new Roman", Font.BOLD, 14));
        texto.addActionListener(this);
        add(texto);
        return texto;
    }

    private JTextArea criarAreaTexto(String texto) {
        JTextArea area = new JTextArea(texto);
        area.setFont(new Font("Times new Roman", Font.BOLD, 18));
        add(area);
        return area;
    }

    private JButton criarBotao(String texto) {
        JButton botao = new JButton(texto);
        botao.addActionListener(this);
        return botao;
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1){
            this.setVisible(false);
            FuncionarioView fv= new FuncionarioView();
        }
        else if (e.getSource() == b2){
            this.setVisible(false);
            FuncionarioView fv= new FuncionarioView();
        }
    }

}
