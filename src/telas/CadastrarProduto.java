/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Classes.Fornecedor;
import Classes.GrupoProduto;
import Classes.Icms;
import Classes.MarcaProduto;
import Classes.Produto;
import Classes.TipoCategoriaProduto;
import conexao.FornecedorDAO;
import conexao.GrupoProdutoDAO;
import conexao.MarcaDAO;
import conexao.ProdutoDAO;
import conexao.TipoCategoriaDAO;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carol
 */
public class CadastrarProduto extends javax.swing.JInternalFrame {

    String op = "";
    ProdutoDAO pDAO = new ProdutoDAO();
    
    public CadastrarProduto() {
        initComponents();
        desabilitarCampos();
        carregarFornecedor();
        carregarGrupo();
        carregarMarca();
        carregartipoCategoria();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jRadioAtivado = new javax.swing.JRadioButton();
        jRadioDesativado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextCodigoBarras = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextDescricao = new javax.swing.JTextField();
        jComboCategoria = new javax.swing.JComboBox<>();
        jComboGrupo = new javax.swing.JComboBox<>();
        jComboMarca = new javax.swing.JComboBox<>();
        jComboFornecedor = new javax.swing.JComboBox<>();
        jTextPesoUni = new javax.swing.JTextField();
        jTextPrecoCusto = new javax.swing.JTextField();
        jTextMargemCusto = new javax.swing.JTextField();
        jTextPrecoVenda = new javax.swing.JTextField();
        jtfEstoque = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEdtar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Produto");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 231, 229));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(221, 231, 229));

        jPanel6.setBackground(new java.awt.Color(221, 231, 229));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(23, 23, 127), null), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), java.awt.SystemColor.activeCaptionBorder), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)); // NOI18N

        jRadioAtivado.setBackground(new java.awt.Color(217, 233, 251));
        buttonGroup1.add(jRadioAtivado);
        jRadioAtivado.setText("Ativado");

        jRadioDesativado.setBackground(new java.awt.Color(217, 233, 251));
        buttonGroup1.add(jRadioDesativado);
        jRadioDesativado.setText("Desativado");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jRadioAtivado)
                .addGap(18, 18, 18)
                .addComponent(jRadioDesativado)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioAtivado)
                    .addComponent(jRadioDesativado))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(372, 14, 210, 64);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Código");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 37, 15);

        jTextCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(jTextCodigo);
        jTextCodigo.setBounds(20, 40, 69, 28);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código de Barra");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 20, 86, 15);
        jPanel1.add(jTextCodigoBarras);
        jTextCodigoBarras.setBounds(100, 40, 240, 28);

        jPanel3.setBackground(new java.awt.Color(221, 231, 229));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Margem de Lucro");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Preço de Venda");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Preço de Custo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Peso Unitário");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Estoque Atual");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Grupo");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Marca ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descrição do Produto ");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Fornecedor");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Categoria/Tipo");

        jComboCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCategoriaActionPerformed(evt);
            }
        });

        jComboGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboGrupoActionPerformed(evt);
            }
        });

        jComboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboMarcaActionPerformed(evt);
            }
        });

        jTextPrecoCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextPrecoCustoFocusLost(evt);
            }
        });
        jTextPrecoCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecoCustoActionPerformed(evt);
            }
        });

        jTextMargemCusto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextMargemCustoFocusLost(evt);
            }
        });
        jTextMargemCusto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMargemCustoActionPerformed(evt);
            }
        });

        jTextPrecoVenda.setEditable(false);
        jTextPrecoVenda.setBackground(new java.awt.Color(187, 187, 187));
        jTextPrecoVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextPrecoVendaFocusLost(evt);
            }
        });
        jTextPrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecoVendaActionPerformed(evt);
            }
        });

        jtfEstoque.setEditable(false);
        jtfEstoque.setBackground(new java.awt.Color(187, 187, 187));

        jButtonNovo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonNovo.setText("NOVO");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSalvar.setText("SALVAR");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEdtar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEdtar.setText("EDITAR");
        jButtonEdtar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEdtarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonExcluir.setText("EXCLUIR");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonPesquisar.setText("PESQUISAR");
        jButtonPesquisar.setPreferredSize(new java.awt.Dimension(63, 23));
        jButtonPesquisar.setRequestFocusEnabled(false);
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(232, 232, 232)
                        .addComponent(jComboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonEdtar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(113, 113, 113)
                                .addComponent(jLabel11)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel15))
                            .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextPesoUni, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextPrecoCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel10))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextMargemCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextPesoUni)
                            .addComponent(jTextPrecoCusto)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextMargemCusto)
                                .addComponent(jTextPrecoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(jtfEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonEdtar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 90, 660, 240);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 310));

        setBounds(0, 0, 676, 342);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCodigoActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

     if (JOptionPane.showConfirmDialog(this, "Deseja excluir?", "ExclusÃ£o", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
         
         Produto produto = new Produto();
         ProdutoDAO produtoDAO = new ProdutoDAO();
         
         produto.setIdProduto(Integer.parseInt(jTextCodigo.getText()));
         produtoDAO.excluir(produto);
         
         limpar();
         desabilitarCampos();
     }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        limpar();
        desabilitarCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEdtarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEdtarActionPerformed
             habilitarCampos();
             op = "editar";
    }//GEN-LAST:event_jButtonEdtarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        Produto p = new Produto();
        p.setCodigoBarra(jTextCodigoBarras.getText());
        p.setDescricaoProduto(jTextDescricao.getText());
        if(jRadioAtivado.isSelected())
        p.setStatusProduto(true);
        else if (jRadioDesativado.isSelected())
        p.setStatusProduto(false);
        p.setTipoCategoria((TipoCategoriaProduto) jComboCategoria.getSelectedItem());
        p.setFornecedor((Fornecedor) jComboFornecedor.getSelectedItem());
        p.setGrupo((GrupoProduto) jComboGrupo.getSelectedItem());
        p.setMarca((MarcaProduto) jComboMarca.getSelectedItem());
        p.setPeso(Double.parseDouble(jTextPesoUni.getText()));
        p.setPrecoCusto(Double.parseDouble(jTextPrecoCusto.getText()));
        p.setPrecoVenda(Double.parseDouble(jTextPrecoVenda.getText()));
        //p.setEstoqueAtual(Integer.parseInt(jtfEstoque.getText()));
        p.setMargemLucro(Double.parseDouble(jTextMargemCusto.getText()));
        
        ProdutoDAO pDAO = new ProdutoDAO();
         if(op.equals("novo")){
             pDAO.salvar(p);
             jTextCodigo.setText(p.getIdProduto()+"");
         }
         else{
             p.setIdProduto(Integer.parseInt(jTextCodigo.getText()));
             pDAO.editar(p);
         }
         
        desabilitarCampos(); 
        JOptionPane.showMessageDialog(this, "Produto Gravado com sucesso!"); 
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
            habilitarCampos();
            op = "novo";
            limpar();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTextPrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecoVendaActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        PesquisarProduto pesquisar = new PesquisarProduto(null, true);
        pesquisar.setVisible(true);
        ProdutoDAO pDAO = new ProdutoDAO();
        Produto produto = (Produto) pDAO.buscarPorId(pesquisar.getCodSelecionado());
        if (produto!=null){
            preencherTela(produto);
            desabilitarCampos();
        }
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jComboCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCategoriaActionPerformed
        
    }//GEN-LAST:event_jComboCategoriaActionPerformed
    private void jComboGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboGrupoActionPerformed
        
    }//GEN-LAST:event_jComboGrupoActionPerformed

    private void jComboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboMarcaActionPerformed
      
    }//GEN-LAST:event_jComboMarcaActionPerformed

    private void jTextMargemCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMargemCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextMargemCustoActionPerformed

    private void jTextPrecoCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecoCustoFocusLost
        calculaPrecoVenda();
    }//GEN-LAST:event_jTextPrecoCustoFocusLost

    private void jTextPrecoVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextPrecoVendaFocusLost
    }//GEN-LAST:event_jTextPrecoVendaFocusLost

    private void jTextPrecoCustoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecoCustoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextPrecoCustoActionPerformed

    private void jTextMargemCustoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextMargemCustoFocusLost
        calculaPrecoVenda();
    }//GEN-LAST:event_jTextMargemCustoFocusLost

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEdtar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboCategoria;
    private javax.swing.JComboBox<String> jComboFornecedor;
    private javax.swing.JComboBox<String> jComboGrupo;
    private javax.swing.JComboBox<String> jComboMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRadioAtivado;
    private javax.swing.JRadioButton jRadioDesativado;
    private javax.swing.JTextField jTextCodigo;
    private javax.swing.JTextField jTextCodigoBarras;
    private javax.swing.JTextField jTextDescricao;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextMargemCusto;
    private javax.swing.JTextField jTextPesoUni;
    private javax.swing.JTextField jTextPrecoCusto;
    private javax.swing.JTextField jTextPrecoVenda;
    private javax.swing.JTextField jtfEstoque;
    // End of variables declaration//GEN-END:variables

    public void habilitarCampos(){
       jTextCodigo.setEnabled(false);
        jTextCodigoBarras.setEnabled(true);
        jTextDescricao.setEnabled(true);
        jRadioAtivado.setEnabled(true);
        jRadioDesativado.setEnabled(true);
        jTextPesoUni.setEnabled(true);
        jTextPrecoCusto.setEnabled(true);
        jTextMargemCusto.setEnabled(true);
        jtfEstoque.setEnabled(true);
        jTextPrecoVenda.setEnabled(true);
        jComboCategoria.setEnabled(true);
        jComboFornecedor.setEnabled(true);
        jComboGrupo.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonEdtar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        jComboMarca.setEnabled(true);
    }
    
    public void desabilitarCampos(){
        jTextCodigo.setEnabled(false);
        jTextCodigoBarras.setEnabled(false);
        jTextDescricao.setEnabled(false);
        jRadioAtivado.setEnabled(false);
        jRadioDesativado.setEnabled(false);
        jTextPesoUni.setEnabled(false);
        jTextPrecoCusto.setEnabled(false);
        jTextMargemCusto.setEnabled(false);
        jtfEstoque.setEnabled(false);
        jTextPrecoVenda.setEnabled(false);
        jComboCategoria.setEnabled(false);
        jComboFornecedor.setEnabled(false);
        jComboGrupo.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        if (jTextCodigo.getText().equals(""))
            jButtonEdtar.setEnabled(false);
        else
            jButtonEdtar.setEnabled(true);

        if(jTextCodigo.getText().equals(""))
            jButtonExcluir.setEnabled(false);
        else
            jButtonExcluir.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jComboMarca.setEnabled(false);

    }
    
    public void limpar(){
        jTextCodigo.setText("");
        jTextCodigoBarras.setText("");
        jTextDescricao.setText("");
        jTextPesoUni.setText("");
        jTextMargemCusto.setText("");
        jTextPesoUni.setText("");
        jTextPrecoCusto.setText("");
        jTextPrecoVenda.setText("");
        jtfEstoque.setText("");
        jComboCategoria.setSelectedItem(null);
        jComboFornecedor.setSelectedItem(null);
        jComboGrupo.setSelectedItem(null);  
        jComboMarca.setSelectedItem(null);
    }
    public void carregartipoCategoria(){
       TipoCategoriaDAO categoriaDAO = new TipoCategoriaDAO();
       List <TipoCategoriaProduto> itens = categoriaDAO.listarTipoCategoria();
       //adiciona o primeiro vazio
       itens.add(0, null);
       jComboCategoria.setModel(new DefaultComboBoxModel(itens.toArray()));
    }
    public void carregarFornecedor(){
        FornecedorDAO fdao = new FornecedorDAO();
        List<Fornecedor> itens = fdao.listarFornecedor();
        itens.add(0, null);
        jComboFornecedor.setModel(new DefaultComboBoxModel(itens.toArray()));
        
    }
    
    public void carregarGrupo(){
        GrupoProdutoDAO grupoDAO = new GrupoProdutoDAO();
        List<GrupoProduto> itens =  grupoDAO.listarGrupo();
        //adiciona o primeiro vazio
        itens.add(0, null);
        jComboGrupo.setModel(new DefaultComboBoxModel(itens.toArray()));
    }
    
    public void carregarMarca(){
        MarcaDAO mDAO = new MarcaDAO();
        List<MarcaProduto> itens =  mDAO.listarMarca();
        itens.add(0, null);
        jComboMarca.setModel(new DefaultComboBoxModel(itens.toArray()));    
    }
    public void preencherTela(Produto p){
         jTextCodigo.setText(p.getIdProduto()+ "");
         jTextDescricao.setText(p.getDescricaoProduto());
         jTextPrecoVenda.setText(p.getPrecoVenda() + "");
         jTextCodigoBarras.setText(p.getCodigoBarra()+"");
         jTextPesoUni.setText(p.getPeso()+"");
         jTextPrecoCusto.setText(p.getPrecoCusto()+"");
         jTextMargemCusto.setText(p.getMargemLucro()+"");
         jTextPrecoVenda.setText(p.getPrecoVenda()+"");
         jtfEstoque.setText(p.getEstoqueAtual()+"");
         jComboCategoria.getModel().setSelectedItem(p.getTipoCategoria());
         jComboMarca.getModel().setSelectedItem(p.getMarca());
         jComboGrupo.getModel().setSelectedItem(p.getGrupo());
         jComboFornecedor.getModel().setSelectedItem(p.getFornecedor());
         if (p.getStatusProduto() == true)
             jRadioAtivado.setSelected(true);
         else 
             jRadioDesativado.setSelected(false);
     }
    
    public void calculaPrecoVenda(){
        if (!jTextPrecoCusto.getText().equals("") && (!jTextMargemCusto.getText().equals(""))){
            double precocusto = Double.parseDouble(jTextPrecoCusto.getText());
            double margemlucro = Double.parseDouble(jTextMargemCusto.getText());
            double precovenda = (precocusto*margemlucro)+precocusto;
            jTextPrecoVenda.setText(precovenda+"");
        }else{
            jTextPrecoVenda.setText("");
        }
    }
    
    
}
