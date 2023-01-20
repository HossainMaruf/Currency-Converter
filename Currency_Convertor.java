import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import java.util.*;
import javax.swing.*;

public class Currency_Convertor extends JFrame {
    
    private Container c;
    private JLabel l1,l2,l3,l4,l5,l6;
    private JButton bcalculate,b2,bCon1,bCon2;
    private JTextField t1,t2;
    private JTextArea ta1;
    private JLabel tfrom, tto;

    private ArrayList<String> countries, currencies, values;

    private ImageIcon icon;
    private String fileName = "Currency_Name.txt";
     
      
    Currency_Convertor() {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setBounds(100,200,700,500);
       this.setTitle("Currency Convertor");
       
       c= this.getContentPane();
       c.setLayout(null);
       c.setBackground(Color.black);
       
       // icon = new ImageIcon(getClass().getResource("NC.png"));
       // this.setIconImage(icon.getImage());

    /** [Get the file data] */

        try {
            countries = new ArrayList<String>();
            currencies = new ArrayList<String>();
            values = new ArrayList<String>();

            File f = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String c = br.readLine();
            int i = 0;
            while (c != null) {
                String[] s=c.split(" , ");
                // System.out.println(++i + " " + s[0] + " " + s[1] + " " + s[2]);
                countries.add(s[0]);
                currencies.add(s[1]);
                values.add(s[2]);
                c = br.readLine();
             }
            br.close();
            // tfrom.setText(t.get(tfrom.getText()));
            // currency=tfrom.getText();
            }
            catch (FileNotFoundException e1) {
             e1.printStackTrace();
            }
            catch (IOException e1) {
             e1.printStackTrace();
            }

            // ArrayList to String Array
            int len = countries.size();
            String[] country_arr = new String[len];
            String[] currency_arr = new String[len];
            String[] value_arr = new String[len];
            for (int i = 0; i < len; i++) {
               country_arr[i] = countries.get(i);
               currency_arr[i] = currencies.get(i);
               value_arr[i] = values.get(i);
            }

    /** [Head Label start] */

       l1 = new JLabel("Currency Convertor");
       l1.setFont(new Font("Verdana", Font.PLAIN, 15));
       l1.setBounds(245,0,350,100);
       l1.setForeground(Color.white);
       c.add(l1);
       
       l2 = new JLabel("Select country");
       l2.setBounds(80,50,300,100);
       l2.setForeground(Color.white);
       c.add(l2);

    /** [Head label end] */

    /** [Start of From section] */

       l5 = new JLabel("From");
       l5.setBounds(250,50,300,100);
       l5.setForeground(Color.white);
       c.add(l5);
           
       tfrom = new JLabel(currency_arr[0]);
       tfrom.setBounds(290,85,120,30);
       tfrom.setForeground(Color.BLUE);
       c.add(tfrom);

       JComboBox<String> country_list_from = new JComboBox<String>(country_arr);
       country_list_from.setBounds(250,131,170,30);
       country_list_from.setBackground(Color.white);
       c.add(country_list_from);
       // System.out.println(country_list_from.getSelectedItem());

      country_list_from.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    JComboBox<String> cb = (JComboBox<String>) e.getSource();
                    String from_country = (String) cb.getSelectedItem();
                    // System.out.println(from_country);

                    // Update currency
                    int index = Arrays.asList(country_arr).indexOf(from_country);
                    tfrom.setText(currency_arr[index]);
                }
            }
        }
    }); 

    /** [End of From section] */

    /** [Start of To section] */

       l6 = new JLabel("To");
       l6.setBounds(430,50,300,100);
       l6.setForeground(Color.white);
       c.add(l6);

       tto = new JLabel(currency_arr[0]);
       tto.setBounds(470,85,120,30);
       tto.setForeground(Color.BLUE);
       c.add(tto);

       JComboBox<String> country_list_to = new JComboBox<String>(country_arr);
       country_list_to.setBounds(450,131,170,30);
       country_list_to.setBackground(Color.white);
       c.add(country_list_to);

        country_list_to.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getID() == ItemEvent.ITEM_STATE_CHANGED) {
                    if(e.getStateChange() == ItemEvent.SELECTED) {
                        JComboBox<String> cb = (JComboBox<String>) e.getSource();
                        String to_country = (String) cb.getSelectedItem();
                        // System.out.println(to_country);

                        // Update currency
                        int index = Arrays.asList(country_arr).indexOf(to_country);
                        tto.setText(currency_arr[index]);
                    }
                }
            }
        }); 

    /** [End of To section] */

    /** [Input area start] */

       l3 = new JLabel("Enter the amount ");
       l3.setBounds(80,150,300,100);
       l3.setForeground(Color.white);
       c.add(l3);
       
       t1 = new JTextField("");
       t1.setBounds(250,180,300,30);
       t1.setForeground(Color.black);
       c.add(t1);
       
    /** [Input area end] */

    /** [Result area start] */
       
       l4 = new JLabel("Results ");
       l4.setBounds(80,200,300,100);
       l4.setForeground(Color.white);
       c.add(l4);
          
       ta1 = new JTextArea("");
       ta1.setBounds(250,230,300,100);
       ta1.setForeground(Color.black);
       c.add(ta1);
       
    /** [Result area end] */


    /** [Calculation button area start] */
       
       bcalculate = new JButton("Calculate ");
       bcalculate.setBounds(170,351,100,30);
       bcalculate.setBackground(Color.white);
       c.add(bcalculate);
       
       b2 = new JButton("Clear");
       b2.setBounds(290,351,100,30);
       b2.setBackground(Color.white);
       c.add(b2);

    /** [Calculation button area end] */
   
           
   // This bcalculate button will perform calculation
   bcalculate.addActionListener(new ActionListener() {
        @Override
         public void actionPerformed(ActionEvent e) {
            int index_1 = Arrays.asList(country_arr).indexOf(country_list_from.getSelectedItem());
            int index_2 = Arrays.asList(country_arr).indexOf(country_list_to.getSelectedItem());
            // System.out.println(value_arr[index_1]);
            // System.out.println(value_arr[index_2]);
            double f_value = Double.valueOf(value_arr[index_1]);
            double t_value = Double.valueOf(value_arr[index_2]);

            if(!t1.getText().equals("")) {
                double input_amount = Double.valueOf(t1.getText());
                double result = (f_value / t_value) * input_amount;
                ta1.setText(Double.toString(result));
            }
           }
        });   

    b2.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            t1.setText("");
            ta1.setText("");
            }
        });
    }

    /** Main method */

    public static void main(String... args) throws Exception {
        Currency_Convertor ccc = new Currency_Convertor();
        ccc.setVisible(true);
        ccc.setResizable(false);
    }
}