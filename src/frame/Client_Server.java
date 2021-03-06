package frame;

import soap.Answer;
import soap.ICommunicationWithClient;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 *
 * @author Пользователь
 */
public class Client_Server extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    String address = "";
    ICommunicationWithClient server;
    /**
     * Creates new form Client_Server
     */
    public Client_Server() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SOAP");
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java/soap/formula.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(102, 24, 257, 88);

        jButton1.setText("решить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(294, 139, 79, 23);

        jButton2.setText("очистить");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(294, 194, 79, 23);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(73, 140, 106, 20);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(73, 168, 106, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(73, 195, 106, 20);

        jLabel2.setText("x");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(49, 143, 6, 14);

        jLabel3.setText("a");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(49, 171, 6, 14);

        jLabel4.setText("b");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(49, 198, 6, 14);

        jLabel5.setText("ответ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(165, 252, 130, 14);

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jLabel5.setText("ответ");
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {
            String newAddress = "http://localhost:8195/mysoap/test";

            if (!address.equals(newAddress)) {
                address = newAddress;
                JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
                factoryBean.setServiceClass(ICommunicationWithClient.class);
                factoryBean.setAddress(address);
                server = (ICommunicationWithClient) factoryBean.create();
            }
            double x = Double.parseDouble(jTextField1.getText());
            double a = Double.parseDouble(jTextField2.getText());
            double b = Double.parseDouble(jTextField3.getText());
           
            Answer answer = server.example(x, a, b);
            if (answer != null) {
                
                
                jLabel5.setText(String.format("y = %.3f", answer.getY()));
            } else {
                jLabel5.setText("Ошибка");
                
            }
        } catch (NumberFormatException e) {
            jLabel5.setText("Ошибка");
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client_Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new Client_Server().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
