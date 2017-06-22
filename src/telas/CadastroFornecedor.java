package telas;

import Classes.Cargo;
import javax.swing.JOptionPane;
import Classes.Cidade;
import Classes.Estado;
import Classes.Fornecedor;
import Classes.Funcionario;
import Classes.Pessoa;
import Classes.TipoLogradouro;
import conexao.CargoDAO;
import conexao.CidadeDAO;
import conexao.EstadoDAO;
import conexao.FornecedorDAO;
import conexao.FuncionarioDAO;
import conexao.TipoLogradouroDAO;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carol
 */
public class CadastroFornecedor extends javax.swing.JInternalFrame {

    Pessoa p = new Pessoa() {};
    private String op;
    
    public CadastroFornecedor() {
        initComponents();
        desabilitarCampos();
        carregartipoLogradouro();
        carregarEstado();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSexo = new javax.swing.ButtonGroup();
        buttonSituacao = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextRazaoSocial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jFCep = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextLogradouro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextComplemento = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jComboTipoLogradouro = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jTextBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jComboCidade = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox<>();
        jDataCadastro = new com.toedter.calendar.JDateChooser();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEdtar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jBPesquisar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jRadioAtivo = new javax.swing.JRadioButton();
        jRadioBloqueado = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextObservacao = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextNomeFantasia = new javax.swing.JTextField();
        jFCnpj = new javax.swing.JFormattedTextField();
        jTextIe = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jFTelefone2 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jFTelefone1 = new javax.swing.JFormattedTextField();
        jTextEmail = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro Fornecedor");

        jPanel1.setBackground(new java.awt.Color(221, 231, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Data Cadastro");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(483, 25, 76, 15);
        jPanel1.add(jTextRazaoSocial);
        jTextRazaoSocial.setBounds(104, 66, 620, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("CNPJ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(444, 106, 40, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("I.E.");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(584, 106, 30, 15);

        jPanel2.setBackground(new java.awt.Color(221, 231, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel14.setText("CEP");

        try {
            jFCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Logradouro");

        jTextLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextLogradouroActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Número");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Complemento");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Tipo");

        jComboTipoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTipoLogradouroActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Bairro");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Cidade");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Estado");

        jComboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboEstadoItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(31, 31, 31)
                        .addComponent(jFCep, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(0, 311, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jComboTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextLogradouro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jTextComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jFCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboTipoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(14, 230, 730, 180);
        jPanel1.add(jDataCadastro);
        jDataCadastro.setBounds(563, 20, 161, 28);

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovo);
        jButtonNovo.setBounds(20, 500, 95, 34);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(320, 500, 95, 34);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvar);
        jButtonSalvar.setBounds(120, 500, 95, 34);

        jButtonEdtar.setText("Editar");
        jButtonEdtar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdtarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEdtar);
        jButtonEdtar.setBounds(220, 500, 93, 34);

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExcluir);
        jButtonExcluir.setBounds(420, 500, 95, 34);

        jBPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBPesquisar.setText("Pesquisar");
        jBPesquisar.setPreferredSize(new java.awt.Dimension(63, 23));
        jBPesquisar.setRequestFocusEnabled(false);
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(jBPesquisar);
        jBPesquisar.setBounds(520, 500, 95, 34);

        jPanel3.setBackground(new java.awt.Color(221, 231, 229));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Situação do Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jRadioAtivo.setBackground(new java.awt.Color(221, 231, 229));
        buttonSituacao.add(jRadioAtivo);
        jRadioAtivo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioAtivo.setText("Ativo");

        jRadioBloqueado.setBackground(new java.awt.Color(221, 231, 229));
        buttonSituacao.add(jRadioBloqueado);
        jRadioBloqueado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioBloqueado.setText("Bloqueado");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioAtivo)
                .addGap(35, 35, 35)
                .addComponent(jRadioBloqueado)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioAtivo)
                    .addComponent(jRadioBloqueado))
                .addGap(15, 15, 15))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 420, 220, 80);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Observações:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(250, 420, 80, 15);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jTextObservacao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(jTextObservacao);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(250, 440, 490, 50);

        jPanel4.setBackground(new java.awt.Color(221, 231, 229));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Razão Social");

        jTextId.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("ID");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Nome Fantasia");

        try {
            jFCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("E-Mail");

        try {
            jFTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## - ##### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Telefone Contato 2");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Telefone Contato");

        try {
            jFTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## - #### ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3))
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextIe, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 730, 210);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        setBounds(0, 0, 764, 578);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja excluir?", "Exclusão", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                Fornecedor fornecedor = new Fornecedor();
                FornecedorDAO fornecedorDAO = new FornecedorDAO();

                fornecedor.setId(Integer.parseInt(jTextId.getText()));

                fornecedorDAO.excluir(fornecedor);

                limpar();
                
                desabilitarCampos();

            
            }       
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonEdtarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdtarActionPerformed
        habilitarCampos();
        op = "editar";
    }//GEN-LAST:event_jButtonEdtarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setRazaoSocial(jTextRazaoSocial.getText());
        fornecedor.setNomeFantasia(jTextNomeFantasia.getText());
        fornecedor.setCnpj(jFCnpj.getText());
        fornecedor.setIe(jTextIe.getText());
        fornecedor.setTelefoneContato1(jFTelefone1.getText());
        fornecedor.setTelefoneContato2(jFTelefone2.getText());
        fornecedor.setEmail(jTextEmail.getText());
        fornecedor.setCep(jFCep.getText());
        fornecedor.setTipoLogradouro((TipoLogradouro)jComboTipoLogradouro.getSelectedItem());
        fornecedor.setLogradouro(jTextLogradouro.getText());
        fornecedor.setNumero(Integer.parseInt(jTextNumero.getText()));
        fornecedor.setComplemento(jTextComplemento.getText());
        fornecedor.setBairro(jTextBairro.getText());
        
        fornecedor.setEstado((Estado)jComboEstado.getSelectedItem());
        fornecedor.setCidade((Cidade)jComboCidade.getSelectedItem());
        
        fornecedor.setDataCadastro(jDataCadastro.getDate());
        
        fornecedor.setObservacoes(jTextObservacao.getText());
        if (jRadioAtivo.isSelected())
            fornecedor.setSituacaoFornecedor(true);
        else if (jRadioBloqueado.isSelected())
            fornecedor.setSituacaoFornecedor(false);
        
        if (op.equals("novo")){
            fornecedorDAO.salvar(fornecedor);
            jTextId.setText(fornecedor.getId()+"");
        }else{
            fornecedor.setId(Integer.parseInt(jTextId.getText()));
            fornecedorDAO.editar(fornecedor);
        }
        
        desabilitarCampos();
        
        JOptionPane.showMessageDialog(this, "Fornecedor Gravado com sucesso!");
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpar();
        desabilitarCampos();        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        limpar();
        jDataCadastro.setDate(new Date());
        habilitarCampos();
        op = "novo";
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        PesquisarFornecedor pesquisar = new PesquisarFornecedor(null, true);
        pesquisar.setVisible(true);
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDAO.buscarPorId(pesquisar.getCodSelecionado());
        if (fornecedor!=null){
            preencherTela(fornecedor);
            desabilitarCampos();
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jComboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboEstadoItemStateChanged
        Estado estado = (Estado) jComboEstado.getSelectedItem();
        if(estado != null)
        carregarCidade(estado.getId());
    }//GEN-LAST:event_jComboEstadoItemStateChanged

    private void jTextLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextLogradouroActionPerformed

    private void jComboTipoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTipoLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTipoLogradouroActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonSexo;
    private javax.swing.ButtonGroup buttonSituacao;
    private javax.swing.JButton jBPesquisar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEdtar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboCidade;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JComboBox<String> jComboTipoLogradouro;
    private com.toedter.calendar.JDateChooser jDataCadastro;
    private javax.swing.JFormattedTextField jFCep;
    private javax.swing.JFormattedTextField jFCnpj;
    private javax.swing.JFormattedTextField jFTelefone1;
    private javax.swing.JFormattedTextField jFTelefone2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioAtivo;
    private javax.swing.JRadioButton jRadioBloqueado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextBairro;
    private javax.swing.JTextField jTextComplemento;
    private javax.swing.JTextField jTextEmail;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextIe;
    private javax.swing.JTextField jTextLogradouro;
    private javax.swing.JTextField jTextNomeFantasia;
    private javax.swing.JTextField jTextNumero;
    private javax.swing.JTextPane jTextObservacao;
    private javax.swing.JTextField jTextRazaoSocial;
    // End of variables declaration//GEN-END:variables

public void limpar(){
        jTextId.setText("");
        jTextRazaoSocial.setText("");
        jFCnpj.setText("");
        jTextIe.setText("");
        jFTelefone1.setText("");
        jFTelefone2.setText("");
        jTextEmail.setText("");
        jFCep.setText("");
        jComboTipoLogradouro.setSelectedItem(null);
        jTextLogradouro.setText("");
        jTextNumero.setText("");
        jTextComplemento.setText("");
        jTextBairro.setText("");
        jComboCidade.setSelectedItem(null);
        jDataCadastro.setDate(null);
        jTextNomeFantasia.setText("");
        jComboEstado.setSelectedItem(null);
        jTextObservacao.setText("");
    }
    
    public void habilitarCampos(){
        jTextId.setEnabled(true);
        jTextRazaoSocial.setEnabled(true);
        jTextNomeFantasia.setEnabled(true);
        jFCnpj.setEnabled(true);
        jTextIe.setEnabled(true);
        jFTelefone1.setEnabled(true);
        jFTelefone2.setEnabled(true);
        jTextEmail.setEnabled(true);
        jFCep.setEnabled(true);
        jComboTipoLogradouro.setEnabled(true);
        jTextLogradouro.setEnabled(true);
        jTextNumero.setEnabled(true);
        jTextComplemento.setEnabled(true);
        jTextBairro.setEnabled(true);
        jComboCidade.setEnabled(true);
        jComboEstado.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonEdtar.setEnabled(false);
        jButtonExcluir.setEnabled(true);
        jDataCadastro.setEnabled(true);
        jTextObservacao.setEnabled(true);
        jRadioAtivo.setEnabled(true);
        jRadioBloqueado.setEnabled(true);

    }

    public void desabilitarCampos(){
        jTextId.setEnabled(false);
        jTextRazaoSocial.setEnabled(false);
        jTextNomeFantasia.setEnabled(false);
        jFCnpj.setEnabled(false);
        jTextIe.setEnabled(false);
        jFTelefone1.setEnabled(false);
        jFTelefone2.setEnabled(false);
        jTextEmail.setEnabled(false);
        jFCep.setEnabled(false);
        jComboTipoLogradouro.setEnabled(false);
        jTextLogradouro.setEnabled(false);
        jTextNumero.setEnabled(false);
        jTextComplemento.setEnabled(false);
        jTextBairro.setEnabled(false);
        jComboCidade.setEnabled(false);
        jComboEstado.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        if (jTextId.getText().equals(""))
            jButtonEdtar.setEnabled(false);
        else
            jButtonEdtar.setEnabled(true);
        if(jTextId.getText().equals(""))
            jButtonExcluir.setEnabled(false);
        else
            jButtonExcluir.setEnabled(true);
        jDataCadastro.setEnabled(false);
        jTextObservacao.setEnabled(false);
        jRadioAtivo.setEnabled(false);
        jRadioBloqueado.setEnabled(false);

    }
    
    public void carregartipoLogradouro(){
       TipoLogradouroDAO logradouroDAO = new TipoLogradouroDAO();
       List <TipoLogradouro> itens = logradouroDAO.listarTipoLogradouro();
       //adiciona o primeiro vazio
       itens.add(0, null);
       jComboTipoLogradouro.setModel(new DefaultComboBoxModel(itens.toArray()));
    }
    
    public void carregarEstado(){
       EstadoDAO estadoDAO = new EstadoDAO();
       List <Estado> itens = estadoDAO.listarEstado();
       //adiciona o primeiro vazio
       itens.add(0, null);
       jComboEstado.setModel(new DefaultComboBoxModel(itens.toArray()));
    }
     
     public void carregarCidade(int idEstado){
       CidadeDAO cidadeDAO = new CidadeDAO();
       List <Cidade> itens = cidadeDAO.listarCidade(idEstado);
       //adiciona o primeiro vazio
       itens.add(0, null);
       jComboCidade.setModel(new DefaultComboBoxModel(itens.toArray()));
    }
     
     public void preencherTela(Fornecedor f){
         jTextId.setText(f.getId()+"");
         jTextRazaoSocial.setText(f.getRazaoSocial());
         jTextNomeFantasia.setText(f.getNomeFantasia());
         jDataCadastro.setDate(f.getDataCadastro());
         jFCnpj.setText(f.getCnpj());
         jTextIe.setText(f.getIe());
         jFTelefone1.setText(f.getTelefoneContato1());
         jFTelefone2.setText(f.getTelefoneContato2());
         jTextEmail.setText(f.getEmail());
         jFCep.setText(f.getCep());
         jComboTipoLogradouro.getModel().setSelectedItem(f.getTipoLogradouro());
         jTextLogradouro.setText(f.getLogradouro());
         jTextNumero.setText(f.getNumero()+"");
         jTextComplemento.setText(f.getComplemento());
         jTextBairro.setText(f.getBairro());
         jComboEstado.getModel().setSelectedItem(f.getEstado());
         jComboCidade.getModel().setSelectedItem(f.getCidade());
         jTextObservacao.setText(f.getObservacoes());
         if (f.getSituacaoFornecedor()== false)
             jRadioBloqueado.setSelected(false);
         else if (f.getSituacaoFornecedor()== true)
             jRadioAtivo.setSelected(true);
         
             
     }
}


    



