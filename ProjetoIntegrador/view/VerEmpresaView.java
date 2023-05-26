package ContaCorrenteProjeto.view;

import ContaCorrenteProjeto.model.dao.EmpresaDao;
import ContaCorrenteProjeto.model.dao.FuncionariosDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerEmpresaView extends JFrame implements ActionListener {

    JButton b1, b2;

    JTextField t1;

    JLabel j1;

    static EmpresaDao empresaDao= new EmpresaDao();
    public VerEmpresaView(){
        setVisible(true);
        setSize(640,480);
        setTitle("Ver empresa");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Remove o layout padrão
        getContentPane().setLayout(null);
        getContentPane().setBackground(new Color(255,255,255));

        newJLabel("ID DA EMPRESA:",225,5,150,20);
        t1=newJTextField(225,25,170,30);

        j1=newJLabel("",150,150,500,200);


        b1= criarJButton("Ver",'G',150,400);
        b2= criarJButton("Voltar",'C',350,400);



    }

    private JTextField newJTextField(int x, int y, int w, int h) {
        JTextField textField = new JTextField();

        textField.setToolTipText("Any text here...");
        textField.setText("");
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setLocation(x, y);
        textField.setOpaque(false);
        textField.setSize(w, h);

        add(textField);

        return textField;
    }

    private JLabel newJLabel(String text,int x, int y,int w,int h) {
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
        return label;
    }

    private JButton criarJButton(String texto, char atalho, int e, int t){
        JButton b1= new JButton();
        b1.setText(texto);
        b1.setBounds(e,t,100,30);
        b1.setBackground(new Color(0,0,170));
        b1.setForeground(Color.YELLOW);
        b1.setFont(new Font("Helvetica",Font.BOLD,12));
        b1.setToolTipText("Botao b1");
        b1.setHorizontalAlignment(SwingConstants.CENTER);
        b1.setVerticalAlignment(SwingConstants.CENTER);
        b1.setEnabled(true);
        b1.setMnemonic(atalho);
        b1.addActionListener(this);
        add(b1);
        return b1;
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == b1){

            String id= t1.getText();
            j1.setText(empresaDao.getEmpresa(id));

        }
        else if (e.getSource() == b2){
            this.setVisible(false);
            FuncionarioView fv= new FuncionarioView();
        }
    }
}
