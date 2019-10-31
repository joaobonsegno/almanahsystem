package main;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.dao.ProdutoDAO;

public class InativarProduto extends javax.swing.JDialog {

    public InativarProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        lblId.setText(Integer.toString(GerenciadorProdutos.prodSelecionado.getIdProduto()));
        lblNome.setText(GerenciadorProdutos.prodSelecionado.getNome());
        lblQtd.setText(GerenciadorProdutos.prodSelecionado.getQtdEstoque());
        try{
            if(Integer.parseInt(GerenciadorProdutos.prodSelecionado.getQtdEstoque()) == 0){
                lblErro.setText("DESEJA REALMENTE INATIVAR ESTE PRODUTO?");
            }else{
                lblErro.setText("NÃO É POSSÍVEL INATIVAR UM PRODUTO QUE ESTEJA EM ESTOQUE");
                btnInativar.setEnabled(false);
            }
        }catch(java.lang.NumberFormatException ex){
            lblErro.setText("DESEJA REALMENTE INATIVAR ESTE PRODUTO?");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStringInativar = new javax.swing.JLabel();
        linha = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));
        lblStringId = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblStringNome = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnInativar = new javax.swing.JButton();
        lblStringQtd = new javax.swing.JLabel();
        lblQtd = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblErro = new javax.swing.JLabel();
        linha1 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Inativar Produto");
        setMaximumSize(new java.awt.Dimension(500, 331));
        setMinimumSize(new java.awt.Dimension(500, 331));
        setResizable(false);

        lblStringInativar.setBackground(new java.awt.Color(0, 102, 204));
        lblStringInativar.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
        lblStringInativar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringInativar.setText("Inativar Produto");

        linha.setBackground(new java.awt.Color(0, 0, 0));
        linha.setOpaque(true);

        lblStringId.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        lblStringId.setText("ID do Produto");

        lblId.setFont(new java.awt.Font("Comic Sans MS", 0, 17)); // NOI18N
        lblId.setText("150,00");

        lblStringNome.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        lblStringNome.setText("Nome do Produto:");

        btnCancelar.setFont(new java.awt.Font("Comic Sans MS", 0, 17)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(new javax.swing.border.MatteBorder(null));
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnInativar.setFont(new java.awt.Font("Comic Sans MS", 0, 17)); // NOI18N
        btnInativar.setText("Inativar");
        btnInativar.setBorder(new javax.swing.border.MatteBorder(null));
        btnInativar.setBorderPainted(false);
        btnInativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInativarActionPerformed(evt);
            }
        });

        lblStringQtd.setFont(new java.awt.Font("Comic Sans MS", 0, 15)); // NOI18N
        lblStringQtd.setText("Quantidade em estoque:");

        lblQtd.setFont(new java.awt.Font("Comic Sans MS", 0, 17)); // NOI18N
        lblQtd.setText("150,00");

        lblNome.setFont(new java.awt.Font("Comic Sans MS", 0, 17)); // NOI18N
        lblNome.setText("150,00");

        lblErro.setFont(new java.awt.Font("Comic Sans MS", 0, 13)); // NOI18N
        lblErro.setForeground(new java.awt.Color(255, 0, 0));
        lblErro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblErro.setText("DESEJA REALMENTE INATIVAR ESTE PRODUTO?");

        linha1.setBackground(new java.awt.Color(0, 0, 0));
        linha1.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblStringInativar)
                .addGap(171, 171, 171))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStringNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStringId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStringQtd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblErro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(linha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(linha1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblStringInativar)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringId)
                    .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringNome)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringQtd)
                    .addComponent(lblQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInativar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(275, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(linha1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(317, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new GerenciadorProdutos().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnInativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInativarActionPerformed
        ProdutoDAO pDao = new ProdutoDAO();
        pDao.delete(GerenciadorProdutos.prodSelecionado);
        GerenciadorProdutos.listaProdutos.remove(GerenciadorProdutos.prodSelecionado);
        JOptionPane.showMessageDialog(null, "Produto inativado com sucesso!");
        new GerenciadorProdutos().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnInativarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javaslblStringIdng/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InativarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InativarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InativarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InativarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InativarProduto dialog = new InativarProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnInativar;
    public static javax.swing.JLabel lblErro;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblQtd;
    private javax.swing.JLabel lblStringId;
    private javax.swing.JLabel lblStringInativar;
    private javax.swing.JLabel lblStringNome;
    private javax.swing.JLabel lblStringQtd;
    private javax.swing.Box.Filler linha;
    private javax.swing.Box.Filler linha1;
    // End of variables declaration//GEN-END:variables
}
