import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class Estudiantes {

    private JPanel rootPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JCheckBox rojoCheckBox;
    private JCheckBox verdeCheckBox;
    private JCheckBox ningunoCheckBox;
    private JRadioButton siRadioButton;
    private JRadioButton noRadioButton;
    private JButton Guardar;
    private JButton Cargar;
    private JButton Siguiente;
    private JButton Atras;

    public Estudiantes() {
        String filePath = "datos.dat";
        Guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MiClase miObjeto = new MiClase("Jorge", "175180808099", "David", "Vallejo", "Acuario");
                miObjeto.setCodigo(textField1.getText());
                miObjeto.setCedula(textField2.getText());
                miObjeto.setNombres(textField3.getText());
                miObjeto.setApellido(textField4.getText());
                comboBox1.setSelectedItem(comboBox1.getSelectedItem());
                /*int edadA = Integer.parseInt(textField3.getText());
                miObjeto.setEdad(edadA);*/
                try (FileOutputStream fileOut = new FileOutputStream(filePath);
                     ObjectOutputStream obOut = new ObjectOutputStream(fileOut);
                ) {
                    obOut.writeObject(miObjeto);
                    System.out.println("Archivo escrito correctamente");
                } catch (IOException d) {
                    throw new RuntimeException(d);
                }
            }
        });
        Cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        FileInputStream fileIn = new FileInputStream(filePath);
                        ObjectInputStream objIn = new ObjectInputStream(fileIn);
                ){
                    MiClase readObject = (MiClase) objIn.readObject();
                    textField1.setText(textField1.getText() + readObject.getCodigo());
                    textField2.setText(textField2.getText() + readObject.getCedula());
                    textField3.setText(textField3.getText() + readObject.getNombres());
                    textField4.setText(textField4.getText() + readObject.getApellido());
                    String variable = (String) comboBox1.getSelectedItem();
                    comboBox1.setSelectedItem(variable + readObject.getSigno());
                }catch (IOException a){
                    throw new RuntimeException();
                }catch (ClassNotFoundException a){
                    throw new RuntimeException(a);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Estudiantes");
        frame.setContentPane(new Estudiantes().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.setVisible(true);
    }
}