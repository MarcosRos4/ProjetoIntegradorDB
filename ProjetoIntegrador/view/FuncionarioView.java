package ContaCorrenteProjeto.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioView  extends JFrame implements ActionListener {
    JButton b1, b2,b3,b4,b5;
    JLabel t1;
    JMenuItem menuMain,empresa,sair;


    public FuncionarioView(){
        setTitle("Menu Funcionario");
        setSize(640,480);
        GridLayout gl = new GridLayout(6,1,5,5);
        getContentPane().setLayout(gl);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menu= new JMenuBar();
        JMenu menus=new JMenu("Menus");
        menus.setMnemonic('M');
        menu.add(menus);
        menuMain= new JMenuItem("menu");
        empresa= new JMenuItem("empresas");
        sair= new JMenuItem("sair");
        menus.add(menuMain);
        menus.add(empresa);
        menus.add(sair);
        setJMenuBar(menu);
        menuMain.addActionListener(this);
        empresa.addActionListener(this);
        sair.addActionListener(this);

        setLocationRelativeTo(null);
        t1= criarRotulo("ESCOLHA O QUE DESEJA FAZER");
        b1 = criarBotao("ADICIONAR FUNCIONARIO(A)");
        b2= criarBotao("VER FUNCIONARIO(A)");
        b3= criarBotao("ATUALIZAR FUNCIONARIO(A)");
        b4= criarBotao("EXCLUIR FUNCIONARIO(A)");
        b5 = criarBotao("VOLTAR");

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
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
            CriarFuncionarioVIew cfv=new CriarFuncionarioVIew();

        }
        else if (e.getSource() == b2){
            this.setVisible(false);
            VerFuncionarioView vfv= new VerFuncionarioView();

        }
        else if (e.getSource() == b3){
            this.setVisible(false);
            AlterarFuncionarioView afv= new AlterarFuncionarioView();

        }
        else if (e.getSource() == b4){
            this.setVisible(false);
            ExcluirFuncionarioView efv= new ExcluirFuncionarioView();
        }

        else if (e.getSource() == b5){
            this.setVisible(false);
            MenuView mv= new MenuView();
        }

        if(e.getSource()== empresa){
            this.setVisible(false);
            EmpresaView ev= new EmpresaView();
        }
        else if (e.getSource() == menuMain){
            this.setVisible(false);
            MenuView mv= new MenuView();
        }
        else if (e.getSource() == sair){
            this.setVisible(false);
            System.exit(0);
        }
    }

}
