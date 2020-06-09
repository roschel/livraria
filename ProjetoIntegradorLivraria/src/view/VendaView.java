/*//GEN-FIRST:event_tbClientesMouseReleased
 * To change this license header, choose License Headers in Project Properties.//GEN-LAST:event_tbClientesMouseReleased
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DetalheVendaController;
import controller.VendaController;
import dao.ProdutoDAO;
import java.sql.Date;
import utils.JTableController;

/**
 *
 * @author Sillas
 */
public class VendaView extends javax.swing.JFrame {

    /**
     * Creates new form VendaView
     */
    public VendaView() {
        initComponents();

        JTableController.carregarClientes(tbClientes, "");
        JTableController.carregarProdutos(tbLivros, "id_livro", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        venda = new javax.swing.JPanel();
        cliente = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFiltrarCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        cboCampoCliente = new javax.swing.JComboBox<>();
        livro = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboCampoLivro = new javax.swing.JComboBox<>();
        txtFiltrarLivro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLivros = new javax.swing.JTable();
        efetuarVenda = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnEfetuarVenda = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbVenda = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jdcDtVenda = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendas");

        venda.setBorder(javax.swing.BorderFactory.createTitledBorder("Venda"));

        jLabel1.setText("Filtrar por:");

        txtFiltrarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarClienteKeyReleased(evt);
            }
        });

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbClientes.setToolTipText("adicionar cliente");
        tbClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbClientesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        cboCampoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "Nome" }));

        javax.swing.GroupLayout clienteLayout = new javax.swing.GroupLayout(cliente);
        cliente.setLayout(clienteLayout);
        clienteLayout.setHorizontalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(clienteLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cboCampoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFiltrarCliente))
                .addContainerGap())
        );
        clienteLayout.setVerticalGroup(
            clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboCampoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel2.setText("Filtrar por:");

        cboCampoLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Título", "Quantidade", "Preço" }));

        txtFiltrarLivro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltrarLivroKeyReleased(evt);
            }
        });

        tbLivros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Quantidade", "Preço Un."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbLivros.setToolTipText("adicionar produto");
        tbLivros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbLivros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbLivros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbLivrosMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbLivros);

        javax.swing.GroupLayout livroLayout = new javax.swing.GroupLayout(livro);
        livro.setLayout(livroLayout);
        livroLayout.setHorizontalGroup(
            livroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(livroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(livroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(txtFiltrarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(livroLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cboCampoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        livroLayout.setVerticalGroup(
            livroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(livroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(livroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCampoLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFiltrarLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setText("Livros:");

        jLabel3.setText("Cliente:");

        btnEfetuarVenda.setText("Efetuar Venda");
        btnEfetuarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEfetuarVendaActionPerformed(evt);
            }
        });

        lblCliente.setText("-");

        tbVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbVenda.setToolTipText("remover produto");
        tbVenda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVendaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbVenda);

        jLabel5.setText("Total:");

        lblTotal.setText("0.00");
        lblTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jdcDtVenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout efetuarVendaLayout = new javax.swing.GroupLayout(efetuarVenda);
        efetuarVenda.setLayout(efetuarVendaLayout);
        efetuarVendaLayout.setHorizontalGroup(
            efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(efetuarVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(btnEfetuarVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(efetuarVendaLayout.createSequentialGroup()
                        .addGroup(efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(efetuarVendaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCliente))
                            .addComponent(jdcDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, efetuarVendaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal)
                        .addGap(57, 57, 57)))
                .addContainerGap())
        );
        efetuarVendaLayout.setVerticalGroup(
            efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(efetuarVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jdcDtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(efetuarVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblTotal))
                .addGap(18, 18, 18)
                .addComponent(btnEfetuarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout vendaLayout = new javax.swing.GroupLayout(venda);
        venda.setLayout(vendaLayout);
        vendaLayout.setHorizontalGroup(
            vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(efetuarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        vendaLayout.setVerticalGroup(
            vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(efetuarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(vendaLayout.createSequentialGroup()
                        .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(livro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void txtFiltrarClienteKeyReleased(java.awt.event.KeyEvent evt) {                                              
        // TODO add your handling code here:
        String campo = "";

        switch (cboCampoCliente.getSelectedIndex()) {
            case 0:
                campo = "cpf";
                break;
            case 1:
                campo = "nome";
                break;
        }

        JTableController.carregarClientes(tbClientes, txtFiltrarCliente.getText());
    }                                             

    private void txtFiltrarLivroKeyReleased(java.awt.event.KeyEvent evt) {                                            
        // TODO add your handling code here:
        String campo = "";

        switch (cboCampoLivro.getSelectedIndex()) {
            case 0:
                campo = "id_livro";
                break;
            case 1:
                campo = "titulo";
                break;
            case 2:
                campo = "qtd_estoque";
                break;
            case 3:
                campo = "preco";
                break;
        }

        JTableController.carregarProdutos(tbLivros, campo, txtFiltrarLivro.getText());
    }                                           

    private void tbClientesMouseReleased(java.awt.event.MouseEvent evt) {                                         
        // TODO add your handling code here:
        JTableController.getNome(tbClientes, lblCliente);
    }                                        

    private void tbLivrosMouseReleased(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
        JTableController.adicionarProduto(tbLivros, tbVenda, lblTotal);
    }                                      

    private void btnEfetuarVendaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        Date dtVenda = new Date (jdcDtVenda.getDate().getTime());
        double total = Double.parseDouble(lblTotal.getText());
        String cpf = JTableController.getInfo(tbClientes, tbClientes.getSelectedRow(), 0).toString();
        
        
        int idVenda = VendaController.inserirVenda(dtVenda, total, cpf);

        for (int i = 0; i < tbVenda.getRowCount(); i++) {
            int idLivro = (int) JTableController.getInfo(tbVenda, i, 0);
            int qtdLivro = (int) JTableController.getInfo(tbVenda, i, 2);
     
            
            DetalheVendaController.inserirDetalheVenda(qtdLivro, idLivro, idVenda);
            
            String id_livro = String.valueOf(idLivro);
            int qtdEstoque=ProdutoDAO.ConsultarId_string(id_livro);
            

            ProdutoDAO.Atualizar(idLivro, qtdEstoque - qtdLivro);
        }
        this.dispose();
        VendaView telaVenda = new VendaView();
        telaVenda.setVisible(true);
        
    }                                               

    private void tbVendaMouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        JTableController.removerProduto(tbVenda, lblTotal);
    }                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnEfetuarVenda;
    private javax.swing.JComboBox<String> cboCampoCliente;
    private javax.swing.JComboBox<String> cboCampoLivro;
    private javax.swing.JPanel cliente;
    private javax.swing.JPanel efetuarVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jdcDtVenda;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel livro;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbLivros;
    private javax.swing.JTable tbVenda;
    private javax.swing.JTextField txtFiltrarCliente;
    private javax.swing.JTextField txtFiltrarLivro;
    private javax.swing.JPanel venda;
    // End of variables declaration                   
}
