package GUI;

import javax.swing.*;
import TDA.Almacenar;
import TDA.Tda;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;*/

public class Gui extends JFrame implements ActionListener{
    
    private Almacenar lista;
    private Container contenedor;
    private JTextField textfield1, textfield2;
    private JLabel label1, label2, label3, label4, label5;
    private JButton button1, button2, button3, button4;
    private JList listaAsistentes;
    private DefaultListModel modelo;
    private JScrollPane scrollLista;
    private JCheckBox jCheck1, jCheck2;//
    private JRadioButton rButton1, rButton2, rButton3, rButton4;//, sexoh, sexom;
    private ButtonGroup grupoEC;//, grupoS;
    private JComboBox grupoS;
    private char sexor;
    private String estadoCivil;
    
    public Gui(){
        lista = new Almacenar();
        inicio();
        setTitle("Captura Datos");
        setSize(350, 450);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void inicio(){
        contenedor = getContentPane();
        contenedor.setLayout(null);
        
        label1 = new JLabel("Nombre: ");
        label1.setBounds(10, 10, 100, 30);
        contenedor.add(label1);
        
        textfield1 = new JTextField("Nombre: ");
        textfield1.setBounds(70, 10, 150, 30);
        contenedor.add(textfield1);
        
        label2 = new JLabel("Edad: ");
        label2.setBounds(10, 50, 150, 30);
        contenedor.add(label2);
        
        textfield2 = new JTextField("Edad: ");
        textfield2.setBounds(70, 50, 150, 30);
        contenedor.add(textfield2);
        
        label3 = new JLabel("Sexo: ");
        label3.setBounds(10, 90, 150, 30);
        contenedor.add(label3);
        
        jCheck1 = new JCheckBox("Hombre");
        jCheck1.setBounds(70, 90, 75, 30);
        jCheck1.addActionListener(this);
        contenedor.add(jCheck1);
        
        jCheck2 = new JCheckBox("Mujer");
        jCheck2.setBounds(150, 90, 75, 30);
        jCheck2.addActionListener(this);
        contenedor.add(jCheck2);
        
        grupoS = new JComboBox();
        grupoS.add(jCheck1);
        grupoS.add(jCheck2);
        //*****************************************************
         String[] options = {"Hombre", "Mujer"};

        // Crear un nuevo JComboBox con las opciones
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Agregar el JComboBox a un panel
        JPanel panel = new JPanel();
        panel.add(comboBox);
        //*******************************************************
        label4 = new JLabel("Estado Civil: ");
        label4.setBounds(10, 130, 100, 30);
        contenedor.add(label4);
        
        label5 = new JLabel("No. Registros: ");
        label5.setBounds(140, 380, 135, 23);
        contenedor.add(label5);
        
        rButton1 = new JRadioButton("Solter@");
        rButton1.setBounds(100, 130, 75, 30);
        rButton1.addActionListener(this);
        contenedor.add(rButton1);
        
        rButton2 = new JRadioButton("Casad@");
        rButton2.setBounds(100, 160, 75, 30);
        rButton2.addActionListener(this);
        contenedor.add(rButton2);
        
        rButton3 = new JRadioButton("Viud@");
        rButton3.setBounds(100, 190, 75, 30);
        rButton3.addActionListener(this);
        contenedor.add(rButton3);
        
        rButton4 = new JRadioButton("Divorsiad@");
        rButton4.setBounds(100, 220, 105, 30);
        contenedor.add(rButton4);
        rButton4.addActionListener(this);
        
        grupoEC = new ButtonGroup();
        grupoEC.add(rButton1);
        grupoEC.add(rButton2);
        grupoEC.add(rButton3);
        grupoEC.add(rButton4);
        
        button1 = new JButton("Añadir");
        button1.setBounds(50, 380, 80, 23);
        button1.addActionListener(this);
        contenedor.add(button1);
        
        listaAsistentes = new JList();
        listaAsistentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        modelo = new DefaultListModel();
        
        scrollLista = new JScrollPane();
        scrollLista.setBounds(10, 260, 280, 100);
        scrollLista.setViewportView(listaAsistentes);
        contenedor.add(scrollLista);
        
        contenedor.add(jCheck1);
        contenedor.add(jCheck2);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        if(evento.getSource() == jCheck1){
            sexor = 'H';
        }
        if(evento.getSource() == jCheck2){
            sexor = 'M';
        }
        if(evento.getSource() == rButton1){
            estadoCivil = "Solter@";
        }
        if(evento.getSource() == rButton2){
            estadoCivil = "Casad@";
        }
        if(evento.getSource() == rButton3){
            estadoCivil = "Viudo@";
        }
        if(evento.getSource() == rButton4){
            estadoCivil = "Divorciad@";
        }
        if(evento.getSource() == button1){
            añadirAsistente();
        }
    }
    
    private void añadirAsistente(){
        Tda p = new Tda(textfield1.getText(), sexor, (Byte.parseByte(textfield2.getText())), estadoCivil);
        String cad = textfield1.getText() + " " + sexor + " " + textfield2.getText() + " " + estadoCivil;
        lista.añadir(p);
        modelo.addElement(cad);
        listaAsistentes.setModel(modelo);
        int x = modelo.getSize();
        label5.setText("No. Registro: " + x);
        textfield1.setText("");
        textfield2.setText("");
        grupoEC.clearSelection();
        jCheck1.setSelected(false);
        jCheck2.setSelected(false);
    }
}
