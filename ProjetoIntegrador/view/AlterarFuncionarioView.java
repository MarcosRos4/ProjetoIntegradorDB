package ProjetoIntegrador.view;

import ProjetoIntegrador.model.dao.FuncionariosDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarFuncionarioView extends JFrame implements ActionListener {
    JButton b1, b2;
    JLabel t1;
    JTextField cpf, nome, rg, id_empresa,id;
    JMenuItem menuMain,empresa,funcionario,sair;

    static String CPF, NOME, RG, ID_EMPRESA,ID;

    static FuncionariosDao funcionariosDao = new FuncionariosDao();

    public AlterarFuncionarioView() {
        setVisible(true);
        setSize(640, 480);
        setTitle("Atualização de funcionarios");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menu= new JMenuBar();
        JMenu menus=new JMenu("Menus");
        menus.setMnemonic('M');
        menu.add(menus);
        menuMain= new JMenuItem("menu");
        empresa= new JMenuItem("empresas");
        funcionario= new JMenuItem("funcionarios");
        sair= new JMenuItem("sair");
        menus.add(menuMain);
        menus.add(empresa);
        menus.add(funcionario);
        menus.add(sair);
        setJMenuBar(menu);
        menuMain.addActionListener(this);
        empresa.addActionListener(this);
        funcionario.addActionListener(this);
        sair.addActionListener(this);

        //Remove o layout padrão
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));


        b1 = criarJButton("Atualizar", 'G', 150, 240);
        b2 = criarJButton("Voltar", 'C', 350, 240);
        newJLabel("ID DO FUNCIONARIO:", 5, 20, 120, 20);
        id = newJTextField("",150, 20, 170, 30);
        newJLabel("NOVO CPF:", 5, 60, 80, 20);
        cpf = newJTextField("000.000.000-00",100, 60, 170, 30);
        newJLabel("NOVO RG:", 300, 60, 80, 20);
        rg = newJTextField("000000000",380, 60, 170, 30);

        newJLabel("NOVO NOME:", 5, 120, 100, 20);
        nome = newJTextField("",150, 120, 200, 30);

        newJLabel("NOVO ID DA EMPRESA:", 5, 180, 150, 20);
        id_empresa = newJTextField("",200, 180, 200, 30);

    }

    private JTextField newJTextField(String texto,int x, int y, int w, int h) {
        JTextField textField = new JTextField();

        textField.setToolTipText("Any text here...");
        textField.setText(texto);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setLocation(x, y);
        textField.setOpaque(false);
        textField.setSize(w, h);

        add(textField);

        return textField;
    }

    private void newJLabel(String text, int x, int y, int w, int h) {
        JLabel label = new JLabel();

        label.setText(text);
        label.setLocation(x, y);
        label.setSize(w, h);

        label.setOpaque(true);
        label.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(0, 0, 0));
        label.setFont(new Font("Courrier new", Font.BOLD, 12));
        label.setToolTipText("JLabel example");
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);

        add(label);
    }

    private JButton criarJButton(String texto, char atalho, int e, int t) {
        JButton b1 = new JButton();
        b1.setText(texto);
        b1.setBounds(e, t, 100, 30);
        b1.setBackground(new Color(0, 0, 170));
        b1.setForeground(Color.YELLOW);
        b1.setFont(new Font("Helvetica", Font.BOLD, 12));
        b1.setToolTipText("Botao b1");
        b1.setHorizontalAlignment(SwingConstants.CENTER);
        b1.setVerticalAlignment(SwingConstants.CENTER);
        b1.setEnabled(true);
        b1.setMnemonic(atalho);
        b1.addActionListener(this);
        add(b1);
        return b1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            CPF = cpf.getText();
            RG = rg.getText();
            NOME = nome.getText();
            ID_EMPRESA = id_empresa.getText();
            ID= id.getText();

            funcionariosDao.atualizarFuncionario(NOME, CPF, RG, ID_EMPRESA,ID);

        } else if (e.getSource() == b2) {
            this.setVisible(false);
            FuncionarioView fv = new FuncionarioView();
        }

        if(e.getSource()== empresa){
            this.setVisible(false);
            EmpresaView ev= new EmpresaView();
        }
        else if (e.getSource() == funcionario){
            this.setVisible(false);
            FuncionarioView fv= new FuncionarioView();
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
