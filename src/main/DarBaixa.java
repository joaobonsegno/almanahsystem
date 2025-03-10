package main;

import ArrumarString.SoNumeros;
import javax.swing.JOptionPane;
import model.bean.Alerta;
import model.bean.Log;
import model.bean.Produto;
import model.dao.AlertaDAO;
import model.dao.LogDAO;
import java.math.BigDecimal;
import java.math.MathContext;
import model.dao.ProdutoDAO;

public class DarBaixa extends javax.swing.JDialog {

    private static Integer idSelecionado;
    ProdutoDAO pDao = new ProdutoDAO();
    //ArrayList<Produto> prods = new ArrayList<>();
    private Produto prod;

    public DarBaixa(java.awt.Frame parent, boolean modal, Integer id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnConfirmar);
        idSelecionado = id;
        encontraProd();
        if (!prod.getUnidadeDeMedida().equals("Kg")) {
            txtEntrada.setDocument(new SoNumeros());
        }
    }

    private void encontraProd() {
        for (Produto p : pDao.read()) {
            if (p.getIdProduto().equals(idSelecionado)) {
                prod = p;
            }
        }
        arrumarLabels();
    }

    public void arrumarLabels() {
        lblId.setText(" " + Integer.toString(prod.getIdProduto()));
        lblNome.setText(" " + prod.getNome());
        if (!prod.getUnidadeDeMedida().equals("Unidade")) {
            lblUnidade.setText(prod.getUnidadeDeMedida());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        lblStringNovoPrato = new javax.swing.JLabel();
        linha = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));
        lblStringQuantidade = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        lblStringId = new javax.swing.JLabel();
        lblStringNome = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        linha1 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));
        lblUnidade = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Baixa no Estoque");
        setMaximumSize(new java.awt.Dimension(487, 306));
        setMinimumSize(new java.awt.Dimension(487, 306));
        setResizable(false);

        lblStringNovoPrato.setBackground(new java.awt.Color(0, 102, 204));
        lblStringNovoPrato.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblStringNovoPrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringNovoPrato.setText("Dar Baixa");

        linha.setBackground(new java.awt.Color(0, 0, 0));
        linha.setOpaque(true);

        lblStringQuantidade.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringQuantidade.setText("Quantidade a ser retirada:");

        txtEntrada.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEntradaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 0));
        btnCancelar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\cancel.png")); // NOI18N
        btnCancelar.setText(" Cancelar");
        btnCancelar.setBorder(new javax.swing.border.MatteBorder(null));
        btnCancelar.setBorderPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(0, 153, 0));
        btnConfirmar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnConfirmar.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\confirm.png")); // NOI18N
        btnConfirmar.setText(" Confirmar");
        btnConfirmar.setBorder(new javax.swing.border.MatteBorder(null));
        btnConfirmar.setBorderPainted(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblStringId.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringId.setText("ID:");

        lblStringNome.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringNome.setText("Nome:");

        lblId.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblId.setText("ID:");
        lblId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNome.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblNome.setText("ID:");
        lblNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        linha1.setBackground(new java.awt.Color(0, 0, 0));
        linha1.setOpaque(true);

        lblUnidade.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblUnidade.setText("unid.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lblStringNovoPrato, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStringId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblStringNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStringQuantidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(linha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(linha1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblStringNovoPrato)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringId)
                    .addComponent(lblStringNome)
                    .addComponent(lblId)
                    .addComponent(lblNome))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringQuantidade)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidade))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(linha1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(284, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        new GerenciadorEstoque().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            boolean flagProsseguir = true;
            boolean criarAlerta = false;
            LogDAO logDao = new LogDAO();
            Log l = new Log();
            l.setCategoria("Estoque");
            l.setData(l.dataAtual());

            String qtdAtualS = prod.getQtdEstoque();
            String qtdRetiradaS = txtEntrada.getText();

            if (prod.getUnidadeDeMedida().equals("Kg")) {
                // Preparando os valores Double e BigDecimal pra fazer a subtração
                qtdRetiradaS = qtdRetiradaS.replace(",", ".");
                Double qtdAtual = Double.parseDouble(qtdAtualS);
                Double qtdAdicionada = Double.parseDouble(qtdRetiradaS);
                BigDecimal atual = new BigDecimal(qtdAtual);
                BigDecimal adicionada = new BigDecimal(qtdAdicionada);
                BigDecimal fim = atual.subtract(adicionada, MathContext.DECIMAL32);
                qtdAtual = fim.doubleValue();
                if (qtdAtual <= Double.parseDouble(prod.getQtdMinima())){
                    criarAlerta = true;
                }
                if (qtdAtual < 0) {
                    JOptionPane.showMessageDialog(null, "Não foi possível dar baixa, pois a quantidade\n inserida é maior do que o estoque atual");
                    flagProsseguir = false;
                } else {
                    qtdAtualS = Double.toString(qtdAtual);
                }
            } else {
                Integer qtdAtual = Integer.parseInt(qtdAtualS);
                Integer qtdAdicionada = Integer.parseInt(qtdRetiradaS);
                qtdAtual -= qtdAdicionada;
                if (qtdAtual <= Integer.parseInt(prod.getQtdMinima())){
                    criarAlerta = true;
                }
                if (qtdAtual < 0) {
                    JOptionPane.showMessageDialog(null, "Não foi possível dar baixa, pois a quantidade\n inserida é maior do que o estoque atual");
                    flagProsseguir = false;
                } else {
                    qtdAtualS = Integer.toString(qtdAtual);
                }
            }
            
            if (flagProsseguir) {
                l.setDescricao(Login.funcAtual.getNome() + " retirou " + qtdRetiradaS + " de \"" + prod.getNome() + "\" do estoque");
                prod.setQtdEstoque(qtdAtualS);
                pDao.updateEstoque(prod);
                
                if (criarAlerta){
                    AlertaDAO aDao = new AlertaDAO();
                    Alerta a = aDao.readForProduto(prod.getIdProduto());
                    if (a.getMensagem() == null){
                        a.setMensagem("O produto \""+prod.getNome()+"\" está com estoque baixo");
                        a.setProduto(prod);
                        aDao.create(a);
                    }                
                }
                logDao.create(l);
                new GerenciadorEstoque().setVisible(true);
                dispose();
            }
        } catch (java.lang.AbstractMethodError ex) {
            JOptionPane.showMessageDialog(null, "Insira um valor válido");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntradaActionPerformed

    private void txtEntradaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyReleased
        
    }//GEN-LAST:event_txtEntradaKeyReleased

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyTyped
        Character c = evt.getKeyChar();
        if (c.isSpaceChar(c) || c.isAlphabetic(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtEntradaKeyTyped

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
            java.util.logging.Logger.getLogger(DarBaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DarBaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DarBaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DarBaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DarBaixa dialog = new DarBaixa(new javax.swing.JFrame(), true, idSelecionado);
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
    private javax.swing.JButton btnConfirmar;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblStringId;
    private javax.swing.JLabel lblStringNome;
    private javax.swing.JLabel lblStringNovoPrato;
    private javax.swing.JLabel lblStringQuantidade;
    private javax.swing.JLabel lblUnidade;
    private javax.swing.Box.Filler linha;
    private javax.swing.Box.Filler linha1;
    private javax.swing.JTextField txtEntrada;
    // End of variables declaration//GEN-END:variables
}
