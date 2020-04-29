/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;

/**
 *
 * @author joaom
 */
public class Clientes extends javax.swing.JFrame {

    public Connection con;
    public Statement st;
    public ResultSet resultado;

    /**
     * Creates new form Telas
     */
    public Clientes() {
        initComponents();
        lblObrigatorioNome.setVisible(false);
        lblObrigatorioCPF.setVisible(false);
        lblObrigatorioEmail.setVisible(false);
        lblObrigatorioEndereco.setVisible(false);
        lblObrigatorioSexo.setVisible(false);
        jrdMasculino.setActionCommand("M");
        jrdFeminino.setActionCommand("F");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupSexo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblCPF = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jrdMasculino = new javax.swing.JRadioButton();
        jrdFeminino = new javax.swing.JRadioButton();
        lblEstadoCivil = new javax.swing.JLabel();
        cboEstadoCivil = new javax.swing.JComboBox<>();
        lblDataNascimento = new javax.swing.JLabel();
        lblObrigatorioNome = new javax.swing.JLabel();
        lblObrigatorioEndereco = new javax.swing.JLabel();
        lblObrigatorioSexo = new javax.swing.JLabel();
        lblObrigatorioCPF = new javax.swing.JLabel();
        lblObrigatorioEmail = new javax.swing.JLabel();
        fmtNascimento = new javax.swing.JFormattedTextField();
        btnCadastrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCPF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de clientes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 426));

        lblNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNome.setText("Nome:");
        lblNome.setNextFocusableComponent(txtNome);

        lblEndereco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEndereco.setText("Endereço:");

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEmail.setText("E-mail:");
        lblEmail.setNextFocusableComponent(txtEmail);

        lblTelefone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTelefone.setText("Telefone:");

        lblSexo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSexo.setText("Sexo:");

        lblCPF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCPF.setText("CPF:");

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNome.setNextFocusableComponent(lblEmail);
        txtNome.setPreferredSize(new java.awt.Dimension(20, 18));
        txtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomeFocusLost(evt);
            }
        });

        txtEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEndereco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEnderecoFocusLost(evt);
            }
        });

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        GroupSexo.add(jrdMasculino);
        jrdMasculino.setText("Masculino");
        jrdMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdMasculinoActionPerformed(evt);
            }
        });

        GroupSexo.add(jrdFeminino);
        jrdFeminino.setText("Feminino");
        jrdFeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrdFemininoActionPerformed(evt);
            }
        });

        lblEstadoCivil.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstadoCivil.setText("Estado Civil:");

        cboEstadoCivil.setEditable(true);
        cboEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Solteiro(a)", "Casado(a)", "Divrciado(a)", "Viuvo(a)" }));
        cboEstadoCivil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblDataNascimento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDataNascimento.setText("Data de Nascimento:");

        lblObrigatorioNome.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorioNome.setText("*campo obrigatório");

        lblObrigatorioEndereco.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorioEndereco.setText("*campo obrigatório");

        lblObrigatorioSexo.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorioSexo.setText("*campo obrigatório");

        lblObrigatorioCPF.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorioCPF.setText("*campo obrigatório");

        lblObrigatorioEmail.setForeground(new java.awt.Color(255, 0, 0));
        lblObrigatorioEmail.setText("*campo obrigatório");

        fmtNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            fmtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnCadastrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCadastrarMousePressed(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCPF.setNextFocusableComponent(lblNome);
        txtCPF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCPFFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPFFocusLost(evt);
            }
        });
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPFKeyTyped(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Email", "Estado Civil", "Data Nascimento", "Endereço", "Telefone", "Sexo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblDataNascimento)
                                .addComponent(lblEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblCPF, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(lblTelefone)
                            .addComponent(lblSexo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addGap(55, 55, 55)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jrdMasculino)
                                        .addGap(18, 18, 18)
                                        .addComponent(jrdFeminino)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtEndereco)
                                        .addGap(2, 2, 2)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblObrigatorioEmail)
                                    .addComponent(lblObrigatorioNome)
                                    .addComponent(lblObrigatorioEndereco)
                                    .addComponent(lblObrigatorioSexo)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cboEstadoCivil, javax.swing.GroupLayout.Alignment.LEADING, 0, 200, Short.MAX_VALUE)
                                .addComponent(fmtNascimento, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(txtEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObrigatorioCPF)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPF)
                    .addComponent(lblObrigatorioCPF)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObrigatorioNome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObrigatorioEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObrigatorioEndereco))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSexo)
                    .addComponent(jrdMasculino)
                    .addComponent(jrdFeminino)
                    .addComponent(lblObrigatorioSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnCancelar))
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, 456, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        txtEmail.setText("");
        lblObrigatorioEmail.setVisible(false);

        txtNome.setText("");
        lblObrigatorioNome.setVisible(false);

        txtCPF.setText("");
        lblObrigatorioCPF.setVisible(false);

        txtEndereco.setText("");
        lblObrigatorioEndereco.setVisible(false);

        txtTelefone.setText("");
        jrdFeminino.setSelected(false);
        jrdMasculino.setSelected(false);

        fmtNascimento.setText("");
        
        cboEstadoCivil.setSelectedIndex(0);
        
        jrdFeminino.setSelected(false);
        jrdMasculino.setSelected(false);

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        try {
            con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/BGWCjVSysg", "BGWCjVSysg", "SB3wuvNLYv");
            st = (Statement) con.createStatement();
            String linhaSql = "insert into cliente (cpf,nome,email,estado_civil,dt_nascimento,endereco,telefone,sexo) "
                    + " values ("
                    + "'" + txtCPF.getText() + "'"
                    + ",'" + txtNome.getText() + "'"
                    + ",'" + txtEmail.getText().toLowerCase() + "'"
                    + ",'" + cboEstadoCivil.getSelectedItem().toString() + "'"
                    + ",'" + fmtNascimento.getText() + "'"
                    + ",'" + txtEndereco.getText() + "'"
                    + ",'" + txtTelefone.getText() + "'"
                    + ",'" + GroupSexo.getSelection().getActionCommand().toString() + "')";
            st.executeUpdate(linhaSql);
            st.close();
            JOptionPane.showMessageDialog(this, "Registro gravado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Falha no registro\n" + e.getMessage());
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtCPFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusLost
        // TODO add your handling code here:

        Models.Cliente novoCliente = new Cliente();
        boolean eValido;

        if (txtCPF.getText().length() != 11 || txtCPF.getText().trim().equals("")) {
            txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            lblObrigatorioCPF.setVisible(true);
            JOptionPane.showMessageDialog(this, "Campo CPF é obrigatório e possui 11 números");
            txtCPF.requestFocus(true);
        } else {
            try {
                con = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/BGWCjVSysg", "BGWCjVSysg", "SB3wuvNLYv");
                st = (Statement) con.createStatement();

                String linhaPesq = "select * from cliente where cpf = " + txtCPF.getText();
                resultado = st.executeQuery(linhaPesq);

                if (resultado.next()) {
                    JOptionPane.showMessageDialog(this, "Clinete já cadastrado");
                    txtNome.setText(resultado.getString("nome"));
                    fmtNascimento.setText(resultado.getString("dt_nascimento").replace("-", "/"));
                    if (resultado.getString("sexo").equals("M")) {
                        jrdMasculino.setSelected(true);
                    } else {
                        jrdFeminino.setSelected(true);
                    }
                    cboEstadoCivil.setSelectedItem(resultado.getString("estado_civil"));
                    txtTelefone.setText(resultado.getString("telefone"));
                    txtEndereco.setText(resultado.getString("endereco"));
                    txtEmail.setText(resultado.getString("email"));
                }
                st.close();
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }

        eValido = novoCliente.isValid(txtCPF.getText());

        if (!eValido) {
            JOptionPane.showMessageDialog(this, "CPF inválido!");
        }

    }//GEN-LAST:event_txtCPFFocusLost

    private void txtCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();

        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCPFKeyTyped

    private void txtCPFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPFFocusGained
        // TODO add your handling code here:
        txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblObrigatorioCPF.setVisible(false);
    }//GEN-LAST:event_txtCPFFocusGained

    private void txtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusLost
        // TODO add your handling code here:

        if (txtNome.getText().trim().equals("")) {
            txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            lblObrigatorioNome.setVisible(true);
            JOptionPane.showMessageDialog(this, "Campo NOME é obrigatório");
            txtNome.requestFocus(true);
        }
    }//GEN-LAST:event_txtNomeFocusLost

    private void txtNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomeFocusGained
        // TODO add your handling code here:
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblObrigatorioNome.setVisible(false);
    }//GEN-LAST:event_txtNomeFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:

        String user = txtEmail.getText().substring(0, txtEmail.getText().indexOf("@") + 1);
        String domain = txtEmail.getText().substring(txtEmail.getText().indexOf("@") + 1, txtEmail.getText().length());

        if (txtEmail.getText().trim().equals("")) {
            txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            lblObrigatorioEmail.setVisible(true);
            JOptionPane.showMessageDialog(this, "Campo EMAIL é obrigatório");
            txtEmail.requestFocus(true);
        } else if (!(user.contains("@")) && !(domain.contains("."))) {
            txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            lblObrigatorioEmail.setVisible(true);
            JOptionPane.showMessageDialog(this, "Email inválido.\n Seu e-mail deve conter '@yourdomain.com'");
            txtEmail.requestFocus(true);
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblObrigatorioEmail.setVisible(false);
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEnderecoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusLost
        // TODO add your handling code here:
        if (txtEndereco.getText().trim().equals("")) {
            txtEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
            lblObrigatorioEndereco.setVisible(true);
            JOptionPane.showMessageDialog(this, "Campo ENDEREÇO é obrigatório");
            txtEndereco.requestFocus(true);
        }
    }//GEN-LAST:event_txtEnderecoFocusLost

    private void txtEnderecoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEnderecoFocusGained
        // TODO add your handling code here:
        txtEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblObrigatorioEndereco.setVisible(false);
    }//GEN-LAST:event_txtEnderecoFocusGained

    private void btnCadastrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMousePressed
        // TODO add your handling code here:
        try {
            String radioButtons = GroupSexo.getSelection().getActionCommand();
        } catch (Exception e) {
            lblObrigatorioSexo.setVisible(true);
            JOptionPane.showMessageDialog(this, "É necessário escolher um SEXO.");
        }
    }//GEN-LAST:event_btnCadastrarMousePressed

    private void jrdMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdMasculinoActionPerformed
        // TODO add your handling code here:
        lblObrigatorioSexo.setVisible(false);
    }//GEN-LAST:event_jrdMasculinoActionPerformed

    private void jrdFemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrdFemininoActionPerformed
        // TODO add your handling code here:
        lblObrigatorioSexo.setVisible(false);
    }//GEN-LAST:event_jrdFemininoActionPerformed

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
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Clientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupSexo;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cboEstadoCivil;
    private javax.swing.JFormattedTextField fmtNascimento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton jrdFeminino;
    private javax.swing.JRadioButton jrdMasculino;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblObrigatorioCPF;
    private javax.swing.JLabel lblObrigatorioEmail;
    private javax.swing.JLabel lblObrigatorioEndereco;
    private javax.swing.JLabel lblObrigatorioNome;
    private javax.swing.JLabel lblObrigatorioSexo;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
