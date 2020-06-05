/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProdutoController;
import model.Produto;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danil
 */
public class ProdutoView extends javax.swing.JFrame {

    public Statement st;
    public Connection con;
    public ResultSet resultado;

    /**
     * Creates new form ProdutoView
     */
    public ProdutoView() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtEstoque = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtEditora = new javax.swing.JTextField();
        txtEdicao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnPesquisarProd = new javax.swing.JButton();
        jycAno = new com.toedter.calendar.JYearChooser();
        jPanel2 = new javax.swing.JPanel();
        btnAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblConsultarTitulo = new javax.swing.JLabel();
        txtNomeLivro = new javax.swing.JTextField();
        btnConsultarNome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProd = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("I D");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ano");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quantidade em Estoque");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Preço");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Título");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Autor");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Editora");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Edição");

        txtEstoque.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEstoqueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEstoqueFocusLost(evt);
            }
        });
        txtEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstoqueActionPerformed(evt);
            }
        });
        txtEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstoqueKeyTyped(evt);
            }
        });

        txtPreco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecoFocusLost(evt);
            }
        });
        txtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoActionPerformed(evt);
            }
        });
        txtPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecoKeyTyped(evt);
            }
        });

        txtTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTituloFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTituloFocusLost(evt);
            }
        });
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAutorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAutorFocusLost(evt);
            }
        });
        txtAutor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAutorKeyTyped(evt);
            }
        });

        txtEditora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEditoraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEditoraFocusLost(evt);
            }
        });

        txtEdicao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEdicaoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEdicaoFocusLost(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("* campo obrigatório");

        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("* campo obrigatório");

        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("* campo obrigatório");

        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setText("* campo obrigatório");

        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("* campo obrigatório");

        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("* campo obrigatório");

        jLabel15.setForeground(new java.awt.Color(255, 0, 0));
        jLabel15.setText("* campo obrigatório");

        btnPesquisarProd.setText("Pesquisar Produto");
        btnPesquisarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPesquisarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstoque)
                            .addComponent(txtPreco)
                            .addComponent(txtTitulo)
                            .addComponent(txtAutor)
                            .addComponent(txtEditora)
                            .addComponent(txtEdicao)
                            .addComponent(jycAno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtAutor, txtEdicao, txtEditora, txtEstoque, txtID, txtPreco, txtTitulo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jycAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtEdicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtAutor, txtEdicao, txtEditora, txtEstoque, txtID, txtPreco, txtTitulo});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15, jLabel9});

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar ");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(btnCadastrar)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAtualizar, btnCadastrar, btnExcluir});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAtualizar, btnCadastrar, btnExcluir});

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblConsultarTitulo.setText("Consultar por Título");

        btnConsultarNome.setText("Consultar");
        btnConsultarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarNomeActionPerformed(evt);
            }
        });

        tblProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ano", "Qtd Estoque", "Preço", "Título", "Autor", "Editora", "Edição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProd);
        if (tblProd.getColumnModel().getColumnCount() > 0) {
            tblProd.getColumnModel().getColumn(0).setResizable(false);
            tblProd.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblConsultarTitulo)
                        .addGap(83, 83, 83)
                        .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnConsultarNome, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConsultarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarNome))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnConsultarNome, lblConsultarTitulo, txtNomeLivro});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        int ano = jycAno.getYear();
        int qtd_estoque = Integer.parseInt(txtEstoque.getText());
        Double preco = Double.parseDouble(txtPreco.getText());
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String editora = txtEditora.getText();
        String edicao = txtEdicao.getText();

       boolean retorno = ProdutoController.Salvar(ano, qtd_estoque, preco, titulo, autor, editora, edicao);

        if (retorno) {
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
            jycAno.setYear(2020);
            txtEstoque.setText("");
            txtPreco.setText("");
            txtTitulo.setText("");
            txtAutor.setText("");
            txtEditora.setText("");
            txtEdicao.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Produto não cadastrado");
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnPesquisarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProdActionPerformed

        int id = Integer.parseInt(txtID.getText());

        ArrayList<Produto> listaProduto = ProdutoController.ConsultarId(id);

        DefaultTableModel pqProduto = new DefaultTableModel();
        pqProduto.addColumn("ID");
        pqProduto.addColumn("Ano");
        pqProduto.addColumn("Qtd Estoque");
        pqProduto.addColumn("Preço");
        pqProduto.addColumn("Título");
        pqProduto.addColumn("Autor");
        pqProduto.addColumn("Editora");
        pqProduto.addColumn("Edição");
        

        pqProduto.setRowCount(0);

         for (Produto p : listaProduto) {
            pqProduto.addRow(new Object[]{
                p.getId(),
                p.getAno(),
                p.getQtd_estoque(),
                p.getPreco(),
                p.getTitulo(),
                p.getAutor(),
                p.getEditora(),
                p.getEdicao()
            });
         }
        tblProd.setModel(pqProduto);



    }//GEN-LAST:event_btnPesquisarProdActionPerformed

    private void txtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoActionPerformed

    private void txtPrecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecoKeyTyped
        char c = evt.getKeyChar();
        //int x = evt.getKeyCode();

        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Campo preço não permite letras!");
        }
    }//GEN-LAST:event_txtPrecoKeyTyped

    private void txtEstoqueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstoqueKeyTyped
        String caracteres = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        caracteres.toLowerCase();
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();

            JOptionPane.showMessageDialog(this, "O campo Autor não permite números!");
        }
        //char c = evt.getKeyChar();
        //int x = evt.getKeyCode();

        //if (((c<'0')||(c>'9')) && (c!=KeyEvent.VK_BACKSPACE)) {
        // evt.consume();
        // JOptionPane.showMessageDialog(this,"Campo estoque não permite letras!");
        //}
    }//GEN-LAST:event_txtEstoqueKeyTyped

    private void txtAutorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAutorKeyTyped
        String caracteres = "0987654321";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();

            JOptionPane.showMessageDialog(this, "O campo Autor não permite números!");
        }

    }//GEN-LAST:event_txtAutorKeyTyped

    private void txtEstoqueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstoqueFocusGained
        txtEstoque.setBackground(Color.red);

    }//GEN-LAST:event_txtEstoqueFocusGained

    private void txtEstoqueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEstoqueFocusLost
        txtEstoque.setBackground(Color.white);
    }//GEN-LAST:event_txtEstoqueFocusLost

    private void txtPrecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusGained
        txtPreco.setBackground(Color.red);
    }//GEN-LAST:event_txtPrecoFocusGained

    private void txtPrecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecoFocusLost
        txtPreco.setBackground(Color.white);
    }//GEN-LAST:event_txtPrecoFocusLost

    private void txtTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusGained
        txtTitulo.setBackground(Color.red);
    }//GEN-LAST:event_txtTituloFocusGained

    private void txtTituloFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTituloFocusLost
        txtTitulo.setBackground(Color.white);
    }//GEN-LAST:event_txtTituloFocusLost

    private void txtAutorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutorFocusGained
        txtAutor.setBackground(Color.red);
    }//GEN-LAST:event_txtAutorFocusGained

    private void txtAutorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAutorFocusLost
        txtAutor.setBackground(Color.white);
    }//GEN-LAST:event_txtAutorFocusLost

    private void txtEditoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditoraFocusGained
        txtEditora.setBackground(Color.red);
    }//GEN-LAST:event_txtEditoraFocusGained

    private void txtEditoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEditoraFocusLost
        txtEditora.setBackground(Color.white);
    }//GEN-LAST:event_txtEditoraFocusLost

    private void txtEdicaoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdicaoFocusGained
        txtEdicao.setBackground(Color.red);
    }//GEN-LAST:event_txtEdicaoFocusGained

    private void txtEdicaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEdicaoFocusLost
        txtEdicao.setBackground(Color.white);
    }//GEN-LAST:event_txtEdicaoFocusLost

    private void btnConsultarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarNomeActionPerformed

        String titulo = txtTitulo.getText();

        ArrayList<Produto> listaProduto = ProdutoController.Consultar(titulo);

        DefaultTableModel pqProduto = new DefaultTableModel();
        pqProduto.addColumn("ID");
        pqProduto.addColumn("Ano");
        pqProduto.addColumn("Qtd Estoque");
        pqProduto.addColumn("Preço");
        pqProduto.addColumn("Título");
        pqProduto.addColumn("Autor");
        pqProduto.addColumn("Editora");
        pqProduto.addColumn("Edição");
        

        pqProduto.setRowCount(0);

         for (Produto p : listaProduto) {
            pqProduto.addRow(new Object[]{
                p.getId(),
                p.getAno(),
                p.getQtd_estoque(),
                p.getPreco(),
                p.getTitulo(),
                p.getAutor(),
                p.getEditora(),
                p.getEdicao()
            });
         }
        tblProd.setModel(pqProduto);
    }//GEN-LAST:event_btnConsultarNomeActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        if (tblProd.getRowCount() > 0) {
            int linha = tblProd.getSelectedRow();

            int id = Integer.parseInt(tblProd.getModel().getValueAt(linha, 0).toString());

            boolean retorno = ProdutoController.Excluir(id);
            if (retorno) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao excluir produto!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um produto da lista.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (tblProd.getSelectedRowCount() > 0) {
            int linha = tblProd.getSelectedRow();
            
            int id = Integer.parseInt(tblProd.getModel().getValueAt(linha, 0).toString());
            int ano = Integer.parseInt(tblProd.getModel().getValueAt(linha, 1).toString());
            int qtd_estoque = Integer.parseInt(tblProd.getModel().getValueAt(linha, 2).toString());
            Double preco = Double.parseDouble(tblProd.getModel().getValueAt(linha, 3).toString());
            String titulo = tblProd.getModel().getValueAt(linha, 4).toString();
            String autor = tblProd.getModel().getValueAt(linha, 5).toString();
            String editora = tblProd.getModel().getValueAt(linha, 6).toString();
            String edicao = tblProd.getModel().getValueAt(linha, 7).toString();

            boolean retorno = ProdutoController.Atualizar(
                    id,
                    ano,
                    qtd_estoque,
                    preco,
                    titulo,
                    autor,
                    editora,
                    edicao
            );

            if (retorno) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não foi atualizado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escolha um produto da lista");
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstoqueActionPerformed

    @Override
    public String toString() {
      return "ProdutoView{" + "txtAno=" + jycAno + ", txtAutor=" + txtAutor + ", txtEdicao=" + txtEdicao + ", txtEditora=" + txtEditora + ", txtEstoque=" + txtEstoque + ", txtID=" + txtID + ", txtPreco=" + txtPreco + ", txtTitulo=" + txtTitulo + '}';
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutoView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultarNome;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisarProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JYearChooser jycAno;
    private javax.swing.JLabel lblConsultarTitulo;
    private javax.swing.JTable tblProd;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEdicao;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNomeLivro;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
