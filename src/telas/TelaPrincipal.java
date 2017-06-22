package telas;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JInternalFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carol
 */
public class TelaPrincipal extends javax.swing.JFrame{
    
    CadastrarTipoLogradouro cadastrarTipoLogradouro;
    CadastroCliente cadastroCliente;
    CadastroFuncionario cadastroFuncionario;
    CadastroCargoFuncionario cargoFuncionario;
    CadastroFornecedor cadastroFornecedor;
    CadastrarProduto cadastrarProduto;
    Marca marca;
    TipoCategoria categoria;
    Venda venda;
    GrupoProdutos grupo;
    Pagamento pagamento;
    ConsultaVendas consultar;
    CadastrarEstoque cadastrarEstoque;
    
    

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(String usuarioLogado) {
        initComponents();
        jLabelSejaBemVindo.setText("Seja bem vindo "+usuarioLogado);
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
        jDesktopPane = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        jLabelSejaBemVindo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastrar = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuTipo = new javax.swing.JMenuItem();
        jProduto = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jalv Sistemas");
        setExtendedState(MAXIMIZED_BOTH);

        jPanel1.setBackground(new java.awt.Color(217, 233, 251));

        jDesktopPane.setBackground(new java.awt.Color(217, 233, 251));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LOGO2.png"))); // NOI18N

        jLabelSejaBemVindo.setBackground(new java.awt.Color(222, 252, 254));
        jLabelSejaBemVindo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSejaBemVindo.setForeground(new java.awt.Color(222, 252, 254));
        jLabelSejaBemVindo.setText("SEJA BEM-VINDO");

        jDesktopPane.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane.setLayer(jLabelSejaBemVindo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSejaBemVindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSejaBemVindo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 743, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane))
        );

        jMenuBar1.setBackground(new java.awt.Color(222, 252, 254));
        jMenuBar1.setBorder(null);
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuCadastrar.setBackground(new java.awt.Color(221, 231, 229));
        jMenuCadastrar.setText("Cadastrar");
        jMenuCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenu4.setText("Cliente");

        jMenuItem4.setText("Cadastrar Cliente");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem6.setText("Relatório do Cadastro");
        jMenu4.add(jMenuItem6);

        jMenuItem9.setText("Relatório Aniversariante do Mês");
        jMenu4.add(jMenuItem9);

        jMenuCadastrar.add(jMenu4);

        jMenu3.setText("Funcionário");

        jMenuItem3.setText("Cadastrar Funcionário");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem8.setText("Cargo");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem10.setText("Relatório do Cadastro");
        jMenu3.add(jMenuItem10);

        jMenuCadastrar.add(jMenu3);

        jMenu5.setText("Fornecedor");

        jMenuItem1.setText("Cadastrar Fornecedor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuItem7.setText("Relatório do Cadastro");
        jMenu5.add(jMenuItem7);

        jMenuCadastrar.add(jMenu5);

        jMenuTipo.setText("Tipo Logradouro");
        jMenuTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTipoActionPerformed(evt);
            }
        });
        jMenuCadastrar.add(jMenuTipo);

        jMenuBar1.add(jMenuCadastrar);

        jProduto.setText("Produto");
        jProduto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jProduto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem2.setText("Cadastrar Produto");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jProduto.add(jMenuItem2);

        jMenuItem5.setText("Marca");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jProduto.add(jMenuItem5);

        jMenuItem11.setText("Tipo/Categoria");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jProduto.add(jMenuItem11);

        jMenuItem13.setText("Grupo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jProduto.add(jMenuItem13);

        jMenuItem16.setText("Estoque");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jProduto.add(jMenuItem16);

        jMenuBar1.add(jProduto);

        jMenu1.setText("Venda");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jMenuItem14.setText("Venda de Produtos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem14);

        jMenuItem15.setText("Consulta de Vendas");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuItem17.setText("Pagamento");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);

        jMenu6.setText("Relatórios");

        jMenuItem12.setText("Relatórios Venda por Funcinário");
        jMenu6.add(jMenuItem12);

        jMenu1.add(jMenu6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sair");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(759, 464));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTipoActionPerformed
          
        if (cadastrarTipoLogradouro==null || !cadastrarTipoLogradouro.isVisible()){
            cadastrarTipoLogradouro = new CadastrarTipoLogradouro();
            cadastrarTipoLogradouro.setVisible(true);
            jDesktopPane.add(cadastrarTipoLogradouro);
            centralizar(cadastrarTipoLogradouro);
        }
    }//GEN-LAST:event_jMenuTipoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if (cadastroCliente==null || !cadastroCliente.isVisible()){
            cadastroCliente = new CadastroCliente();
            cadastroCliente.setVisible(true);
            jDesktopPane.add(cadastroCliente);
            centralizar(cadastroCliente);
            
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      if (cadastroFuncionario==null || !cadastroFuncionario.isVisible()){
        cadastroFuncionario = new CadastroFuncionario();
        cadastroFuncionario.setVisible(true);
        jDesktopPane.add(cadastroFuncionario);
        centralizar(cadastroFuncionario);
      }
      
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        if (cadastroFuncionario==null || !cadastroFuncionario.isVisible()){
            cargoFuncionario = new CadastroCargoFuncionario();
            cargoFuncionario.setVisible(true);
            jDesktopPane.add(cargoFuncionario);
            centralizar(cargoFuncionario);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (cadastroFornecedor==null || !cadastroFornecedor.isValid()){
            cadastroFornecedor = new CadastroFornecedor();
            cadastroFornecedor.setVisible(true);
            jDesktopPane.add(cadastroFornecedor);
            centralizar(cadastroFornecedor);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (cadastrarProduto==null || !cadastrarProduto.isVisible()){
            cadastrarProduto = new CadastrarProduto();
            cadastrarProduto.setVisible(true);
            jDesktopPane.add(cadastrarProduto);
            centralizar(cadastrarProduto);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if (marca==null || !marca.isVisible()){
            marca = new Marca();
            marca.setVisible(true);
            jDesktopPane.add(marca);
            centralizar(marca);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
       if (categoria==null || !categoria.isVisible()){
            categoria = new TipoCategoria();
            categoria.setVisible(true);
            jDesktopPane.add(categoria);
            centralizar(categoria);
       }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        if (venda==null || !venda.isVisible()){
            venda = new Venda();
            venda.setVisible(true);
            jDesktopPane.add(venda);
            centralizar(venda);
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        if (pagamento==null || !pagamento.isVisible()){
            pagamento = new Pagamento();
            pagamento.setVisible(true);
            jDesktopPane.add(pagamento);
            centralizar(pagamento);
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        if (grupo == null || !grupo.isVisible()){
            grupo = new GrupoProdutos();
            grupo.setVisible(true);
            jDesktopPane.add(grupo);
            centralizar(grupo);
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        if (consultar==null || !consultar.isVisible()){
            consultar = new ConsultaVendas();
            consultar.setVisible(true);
            jDesktopPane.add(consultar);
            centralizar(consultar);
        }
               
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
       
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
       System.exit(0);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
       if (cadastrarEstoque==null || !cadastrarEstoque.isVisible()){
            cadastrarEstoque = new CadastrarEstoque();
            cadastrarEstoque.setVisible(true);
            jDesktopPane.add(cadastrarEstoque);
            centralizar(cadastrarEstoque);
        } 
    }//GEN-LAST:event_jMenuItem16ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelSejaBemVindo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastrar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuTipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu jProduto;
    // End of variables declaration//GEN-END:variables

    
    public void centralizar(JInternalFrame frame){
        Dimension desktopSize = jDesktopPane.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
            (desktopSize.height- jInternalFrameSize.height)/2);     
        frame.toFront();
    }

}
