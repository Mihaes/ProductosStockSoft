import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductosStock {
    private JPanel mainPanel;
    private JTextField textProducto;
    private JTextField textCodi;
    private JTextField textIndex;
    private JButton guardarButton;
    private JButton btnAtras;
    private JButton btnAdelante;
    private JTextField textPrecio;
    private JTextField textStock;
    private JTextField textOnline;
    private JTextField textCat;
    private JButton buscarButton;
    private JButton borrarBtn;


    // Variables :

    String [] producto = new String[10];
    String[]precio = new String[10];
    String[] stock = new String[10];
    String[] online = new String[10];
    String[]codigo = new String[10];
    String[] categoria = new String[10];


    // Excepcion for empty String

    public int validaInt(String number){
        int result = 0; //Valor default.
        try{
            if(number != null){
                result = Integer.parseInt(number);
            }
        }catch(NumberFormatException nfe){
            //*No es numerico!
        }
        return result;
    }





    // Eventos Botones  :


    public ProductosStock() {


        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            mostrarCampoAtras();

            }
        });

        btnAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


               mostrarCampoAdelante();





            }

        });


        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

           guardarCampos();
            limpiarCampos();




            }



        });



        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String buscar = JOptionPane.showInputDialog("Introducir producto");

                for (int i = 0; i < producto.length; i++) {

                    if (buscar.equals(producto[i])) {
                        textIndex.setText(String.valueOf(i));

                        textProducto.setText(producto[i]);
                        textPrecio.setText(precio[i]);
                        textStock.setText(stock[i]);
                        textOnline.setText(online[i]);
                        textCodi.setText(codigo[i]);
                        textCat.setText(categoria[i]);
                    }


                }

            }
        });






        borrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarCampos();
            }
        });



    }






    // Métodos

    public  void limpiarCampos(){

        textIndex.setText("");
        textProducto.setText("");
        textPrecio.setText("");
        textStock.setText("");
        textOnline.setText("");
        textCodi.setText("");
        textCat.setText("");

    }


    // New metodo guardar :

    public void guardarCampos(){
        int index = validaInt(textIndex.getText());
        producto[index]=textProducto.getText();
        precio[index]=textPrecio.getText();
        stock[index]= textStock.getText();
        online[index]= textOnline.getText();
        codigo[index]= textCodi.getText();
        categoria[index]= textCat.getText();

    }

    // New método mostrar :
    public void mostrarCampoAdelante() {


        int index = validaInt(textIndex.getText());

        if (index < 9) {

            index = index + 1;
            textIndex.setText(String.valueOf(index));
            textProducto.setText(producto[index]);
            textPrecio.setText(precio[index]);
            textStock.setText(stock[index]);
            textOnline.setText(online[index]);
            textCodi.setText(codigo[index]);
            textCat.setText(categoria[index]);

        }
    }

        public void mostrarCampoAtras () {


            int index = validaInt(textIndex.getText());

            if (index > 0 ) {

                index = index - 1;
                textIndex.setText(String.valueOf(index));


                // Mostramos datos :

                textProducto.setText(producto[index]);
                textPrecio.setText(precio[index]);
                textStock.setText(stock[index]);
                textOnline.setText(online[index]);
                textCodi.setText(codigo[index]);
                textCat.setText(categoria[index]);


            }
        }


    // Método main :



    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductosStock");
        frame.setContentPane(new ProductosStock().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setSize(900 ,400);
    }
}



