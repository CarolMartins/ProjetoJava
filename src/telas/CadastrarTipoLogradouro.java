/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import Classes.TipoLogradouro;
import conexao.TipoLogradouroDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Carol
 */
public class CadastrarTipoLogradouro extends javax.swing.JInternalFrame {
    
    private String op = "";
    
    TipoLogradouroDAO logradouroDAO = new TipoLogradouroDAO();
    
    public CadastrarTipoLogradouro() {
        initComponents();
        desabilitar();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextSigla = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jBNovo = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jBEditar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLogradouro = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        setClosable(true);
        setIconifiable(true);
        setTitle("Logradouro");

        jPanel1.setBackground(new java.awt.Color(221, 231, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(435, 360));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("ID");

        jTextId.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Sigla");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Logradouro");

        jBNovo.setText("Novo");
        jBNovo.setPreferredSize(new java.awt.Dimension(75, 23));
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.setPreferredSize(new java.awt.Dimension(75, 23));
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBEditar.setText("Editar");
        jBEditar.setPreferredSize(new java.awt.Dimension(75, 23));
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.setPreferredSize(new java.awt.Dimension(75, 23));
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        jTableLogradouro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableLogradouro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Sigla", "Logradouro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLogradouro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLogradouroMouseClicked(evt);
            }
        });
        jTableLogradouro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableLogradouroKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableLogradouro);
        if (jTableLogradouro.getColumnModel().getColumnCount() > 0) {
            jTableLogradouro.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableLogradouro.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextId))
                            .addComponent(jTextSigla, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextNome)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextSigla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
        );

        setBounds(0, 0, 450, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        habilitar();
        op = "novo";
        limpar();
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        desabilitar();
        TipoLogradouro tipoLogradouro = new TipoLogradouro();
        tipoLogradouro.setSigla(jTextSigla.getText());
        tipoLogradouro.setNome(jTextNome.getText());
        TipoLogradouroDAO tipoLogradouroDAO = new TipoLogradouroDAO();
        
        if (op.equals("novo")){
           tipoLogradouroDAO.salvar(tipoLogradouro);
           jTextId.setText(tipoLogradouro.getId()+"");
        }
        else{
           tipoLogradouro.setId(Integer.parseInt(jTextId.getText()));
           tipoLogradouroDAO.editar(tipoLogradouro);
        }
        
        JOptionPane.showMessageDialog(null, "Gravado com Sucesso!");
        
        preencherTabela();
       
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        
        if (jTableLogradouro.getSelectedRow() !=-1){
            
            preencherTabela();
            
            op = "editar";
            
            habilitar();
       }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
       limpar();
       desabilitar();
       pegaLinhaSelecionada();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if((jTableLogradouro.getSelectedRow() !=-1)){
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir?", "Exclusão", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){

                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                TipoLogradouroDAO tipoLogradouroDAO = new TipoLogradouroDAO();

                tipoLogradouro.setId((int) jTableLogradouro.getValueAt(jTableLogradouro.getSelectedRow(), 0));

                tipoLogradouroDAO.excluir(tipoLogradouro);

                limpar();

                preencherTabela();

            
            } 
        }else{
            JOptionPane.showMessageDialog(this, "Selecione um item para excluir");
        }  
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTableLogradouroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableLogradouroKeyReleased
        pegaLinhaSelecionada();
    }//GEN-LAST:event_jTableLogradouroKeyReleased

    private void jTableLogradouroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLogradouroMouseClicked
        pegaLinhaSelecionada();
    }//GEN-LAST:event_jTableLogradouroMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEditar;
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableLogradouro;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNome;
    private javax.swing.JTextField jTextSigla;
    // End of variables declaration//GEN-END:variables

public void desabilitar(){
    jTextId.setEnabled(false);
    jTextSigla.setEnabled(false);
    jTextNome.setEnabled(false);
    jBNovo.setEnabled(true);
    jBEditar.setEnabled(true);
    jBSalvar.setEnabled(false);
    jBCancelar.setEnabled(false);
    jBExcluir.setEnabled(true);
    
}

public void habilitar(){
    jTextId.setEnabled(true);
    jTextSigla.setEnabled(true);
    jTextNome.setEnabled(true);
    jBNovo.setEnabled(false);
    jBEditar.setEnabled(false);
    jBSalvar.setEnabled(true);
    jBCancelar.setEnabled(true);
    jBExcluir.setEnabled(false);
    
}

public void preencherTabela(){
        DefaultTableModel model = (DefaultTableModel) jTableLogradouro.getModel();
        model.setNumRows(0);
        TipoLogradouroDAO logradouroDAO = new TipoLogradouroDAO();
        
        for (TipoLogradouro tl : logradouroDAO.listarTipoLogradouro()){
            model.addRow(new Object []{
              tl.getId(),
              tl.getSigla(),
              tl.getNome()
         });
        }      
    }

    public void pegaLinhaSelecionada(){
        if (jTableLogradouro.getSelectedRow() !=-1){
           jTextId.setText(jTableLogradouro.getValueAt(jTableLogradouro.getSelectedRow(), 0).toString());
           jTextSigla.setText(jTableLogradouro.getValueAt(jTableLogradouro.getSelectedRow(), 1).toString());
           jTextNome.setText(jTableLogradouro.getValueAt(jTableLogradouro.getSelectedRow(), 2).toString());
        }        
    }
    
    public void limpar(){
        jTextId.setText("");
        jTextSigla.setText("");
        jTextNome.setText("");
    }

}
