package main;

import ArrumarString.Monetarios;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Carteira;
import model.bean.Comanda;
import model.bean.Forma;
import model.bean.LogCaixa;
import model.bean.Produto;
import model.bean.Venda;
import model.dao.AlertaDAO;
import model.dao.CaixaDAO;
import model.dao.CarteiraDAO;
import model.dao.ClienteDAO;
import model.dao.ComandaDAO;
import model.dao.FormaDAO;
import model.dao.ItemComandaDAO;
import manual.Manual;
import model.dao.ItemVendaDAO;
import model.dao.LogCaixaDAO;
import model.dao.ProdutoDAO;
import model.dao.VendaDAO;

public class FormaPagamento extends javax.swing.JDialog {
    Integer formaPag;
    public static String formaPagamento;
    public static Integer idForma;
    public static Double valorCobrado;
    private ArrayList<Integer> idsFormas = new ArrayList<>();
    
    public FormaPagamento(java.awt.Frame parent, boolean modal) {
        // Variáveis da tela
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);       
        jtPagamento.setRowHeight(30);
        getRootPane().setDefaultButton(btnConfirmar);
        txtValorASerCobrado.setDocument(new Monetarios(7,2));
        txtEntregue.setDocument(new Monetarios(7,2));
        btnConfirmar.setEnabled(false);
        jpTroco.setVisible(false);
        btnRemover.setEnabled(false);
        
        // Setando labels de valor R$
        lblValorTotal.setText("R$ "+GerenciadorComandas.valorMonetario(EncerrarComanda.venda.getTotal()));
        lblValorPendente.setText("R$ "+GerenciadorComandas.valorMonetario(EncerrarComanda.venda.getTotalPendente()));
        idForma = 0;
        
        // Seta as formas que a venda já tem na tabela
        for (Forma f : EncerrarComanda.venda.getFormasPagamento()){
            adicionarLinha(f, EncerrarComanda.venda);
        }
        txtValorASerCobrado.requestFocus();
    }
    
    public void panelDinheiro(){
        if (txtEntregue.isEnabled()){
            lblStringValorEntregue.setEnabled(false);
            lblStringTroco.setEnabled(false);
            lblTroco.setEnabled(false);
            txtEntregue.setEnabled(false);
            btnAdicionar.setEnabled(false);
           
        }else{
            lblStringValorEntregue.setEnabled(true);
            lblStringTroco.setEnabled(true);
            lblTroco.setEnabled(true);
            txtEntregue.setEnabled(true);
            btnAdicionar.setEnabled(true);
        }
    }
    
    public void adicionarLinha(Forma f, Venda v){
        DefaultTableModel dtmPagamentos = (DefaultTableModel) jtPagamento.getModel();

        String valor = GerenciadorComandas.valorMonetario(f.getValor());
        Object[] dados = {f.getFormaPagamento(), valor};
        dtmPagamentos.addRow(dados); 
        if (v.getTotalPendente() == 0){
            btnConfirmar.setEnabled(true);
            txtValorASerCobrado.setEnabled(false);
        }
    }
    
    public void limparSelecao(){
        btnRemover.setEnabled(false);
        jtPagamento.clearSelection();
    }
    
    public void adicionarFormaDePagamento(String formaDePagamento){
        Venda v = EncerrarComanda.venda;
        if (v.getTotalPendente() < valorCobrado){
            JOptionPane.showMessageDialog(null, "Insira um valor menor ou igual a R$ "+GerenciadorComandas.valorMonetario(v.getTotalPendente()));
        }else{
            boolean isCarteira = false;
            limparSelecao(); // Limpa a seleção da JTable (visual only) 
            formaPagamento = formaDePagamento; // Seta a forma de pagamento
            Forma forma = new Forma(valorCobrado, formaPagamento, v); // Instancia a nova forma de pagamento

            //Seta a forma de pagamento nova na venda - ESTE MÉTODO JÁ ATUALIZA O VALOR PENDENTE DA VENDA
            if (formaPagamento.equals("Carteira")){           
                forma.setCliente(InserirCliente.cliente);
            }
            v.setForma(forma);
            idForma += 1;
            idsFormas.add(idForma);

            // Seta as informações na tela
            lblValorPendente.setText("R$ "+GerenciadorComandas.valorMonetario(v.getTotalPendente())); // Seta o valor pendente novo no label
            adicionarLinha(forma, v); // Adiciona à tabela a nova forma de pagamento
            txtValorASerCobrado.setText("0,00"); // Reseta o campo de entrada de valor recebido
        }     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo1 = new javax.swing.ButtonGroup();
        lblStringNovoPrato = new javax.swing.JLabel();
        linha = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));
        jpFormas = new javax.swing.JPanel();
        lblStringValorCobrado = new javax.swing.JLabel();
        txtValorASerCobrado = new javax.swing.JTextField();
        btnDinheiro = new javax.swing.JButton();
        btnDebito = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();
        btnVoucher = new javax.swing.JButton();
        btnCarteira = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPagamento = new javax.swing.JTable();
        jpTroco = new javax.swing.JPanel();
        lblStringValorEntregue = new javax.swing.JLabel();
        txtEntregue = new javax.swing.JTextField();
        lblTroco = new javax.swing.JLabel();
        lblStringTroco = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jpValores = new javax.swing.JPanel();
        lblStringValorPendente = new javax.swing.JLabel();
        lblValorPendente = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        lblStringValorTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnConfirmar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        linha1 = new javax.swing.Box.Filler(new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 1), new java.awt.Dimension(2, 32767));
        lblManual = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Forma de Pagamento");
        setMinimumSize(new java.awt.Dimension(924, 644));
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lblStringNovoPrato.setBackground(new java.awt.Color(0, 102, 204));
        lblStringNovoPrato.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblStringNovoPrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringNovoPrato.setText("Forma de Pagamento");

        linha.setBackground(new java.awt.Color(0, 0, 0));
        linha.setOpaque(true);

        jpFormas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblStringValorCobrado.setBackground(new java.awt.Color(0, 102, 204));
        lblStringValorCobrado.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringValorCobrado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringValorCobrado.setText("Valor a ser cobrado: R$");

        txtValorASerCobrado.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtValorASerCobrado.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtValorASerCobrado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtValorASerCobradoFocusGained(evt);
            }
        });
        txtValorASerCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorASerCobradoActionPerformed(evt);
            }
        });
        txtValorASerCobrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorASerCobradoKeyReleased(evt);
            }
        });

        btnDinheiro.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnDinheiro.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\money.png")); // NOI18N
        btnDinheiro.setText("  Dinheiro");
        btnDinheiro.setBorder(new javax.swing.border.MatteBorder(null));
        btnDinheiro.setBorderPainted(false);
        btnDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinheiroActionPerformed(evt);
            }
        });

        btnDebito.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnDebito.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\debito.png")); // NOI18N
        btnDebito.setText("   Débito");
        btnDebito.setBorder(new javax.swing.border.MatteBorder(null));
        btnDebito.setBorderPainted(false);
        btnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebitoActionPerformed(evt);
            }
        });

        btnCredito.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnCredito.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\credito.png")); // NOI18N
        btnCredito.setText("  Crédito");
        btnCredito.setBorder(new javax.swing.border.MatteBorder(null));
        btnCredito.setBorderPainted(false);
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });

        btnVoucher.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnVoucher.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\voucher.png")); // NOI18N
        btnVoucher.setText("  Voucher");
        btnVoucher.setBorder(new javax.swing.border.MatteBorder(null));
        btnVoucher.setBorderPainted(false);
        btnVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoucherActionPerformed(evt);
            }
        });

        btnCarteira.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnCarteira.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\wallet (1).png")); // NOI18N
        btnCarteira.setText("  Carteira");
        btnCarteira.setBorder(new javax.swing.border.MatteBorder(null));
        btnCarteira.setBorderPainted(false);
        btnCarteira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarteiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFormasLayout = new javax.swing.GroupLayout(jpFormas);
        jpFormas.setLayout(jpFormasLayout);
        jpFormasLayout.setHorizontalGroup(
            jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFormasLayout.createSequentialGroup()
                .addGroup(jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFormasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpFormasLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(lblStringValorCobrado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorASerCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpFormasLayout.createSequentialGroup()
                                .addComponent(btnDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpFormasLayout.createSequentialGroup()
                                .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpFormasLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpFormasLayout.setVerticalGroup(
            jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFormasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringValorCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorASerCobrado, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpFormasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCarteira, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtPagamento.setBorder(new javax.swing.border.MatteBorder(null));
        jtPagamento.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jtPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de Pagamento", "Valor (R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtPagamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtPagamentoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtPagamentoFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jtPagamento);
        if (jtPagamento.getColumnModel().getColumnCount() > 0) {
            jtPagamento.getColumnModel().getColumn(0).setResizable(false);
        }

        jpTroco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblStringValorEntregue.setBackground(new java.awt.Color(0, 102, 204));
        lblStringValorEntregue.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        lblStringValorEntregue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringValorEntregue.setText("Valor entregue:  R$");

        txtEntregue.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        txtEntregue.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtEntregue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEntregueFocusGained(evt);
            }
        });
        txtEntregue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntregueActionPerformed(evt);
            }
        });
        txtEntregue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEntregueKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEntregueKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntregueKeyTyped(evt);
            }
        });

        lblTroco.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        lblTroco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTroco.setText("R$ 0,00");
        lblTroco.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        lblStringTroco.setBackground(new java.awt.Color(0, 102, 204));
        lblStringTroco.setFont(new java.awt.Font("Century Gothic", 1, 21)); // NOI18N
        lblStringTroco.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringTroco.setText("Troco");

        btnAdicionar.setBackground(new java.awt.Color(0, 204, 51));
        btnAdicionar.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        btnAdicionar.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\upload (1).png")); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAdicionarFocusGained(evt);
            }
        });
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTrocoLayout = new javax.swing.GroupLayout(jpTroco);
        jpTroco.setLayout(jpTrocoLayout);
        jpTrocoLayout.setHorizontalGroup(
            jpTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTrocoLayout.createSequentialGroup()
                .addGroup(jpTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTrocoLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblStringValorEntregue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(jpTrocoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jpTrocoLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(lblStringTroco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTrocoLayout.setVerticalGroup(
            jpTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTrocoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStringValorEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEntregue, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblStringTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTrocoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(lblTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        lblStringValorPendente.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringValorPendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStringValorPendente.setText("Valor Pendente");

        lblValorPendente.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblValorPendente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorPendente.setText("R$ 0,00");
        lblValorPendente.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        lblValorTotal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblValorTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorTotal.setText("R$ 0,00");
        lblValorTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        lblStringValorTotal.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblStringValorTotal.setText("Valor Total");

        javax.swing.GroupLayout jpValoresLayout = new javax.swing.GroupLayout(jpValores);
        jpValores.setLayout(jpValoresLayout);
        jpValoresLayout.setHorizontalGroup(
            jpValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpValoresLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblStringValorTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jpValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpValoresLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblValorPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblStringValorPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpValoresLayout.setVerticalGroup(
            jpValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpValoresLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpValoresLayout.createSequentialGroup()
                        .addComponent(lblStringValorPendente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorPendente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpValoresLayout.createSequentialGroup()
                        .addComponent(lblStringValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btnConfirmar.setBackground(new java.awt.Color(51, 153, 0));
        btnConfirmar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnConfirmar.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\negocio (1).png")); // NOI18N
        btnConfirmar.setText("  Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(153, 153, 0));
        btnVoltar.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\cancel.png")); // NOI18N
        btnVoltar.setText("    Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnRemover.setBackground(new java.awt.Color(255, 51, 51));
        btnRemover.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        btnRemover.setIcon(new javax.swing.ImageIcon("C:\\Projetos Netbeans\\AlmanahSystem\\images\\delete.png")); // NOI18N
        btnRemover.setText("  Remover");
        btnRemover.setBorder(new javax.swing.border.MatteBorder(null));
        btnRemover.setBorderPainted(false);
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        linha1.setBackground(new java.awt.Color(0, 0, 0));
        linha1.setOpaque(true);

        lblManual.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        lblManual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManual.setText("?");
        lblManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblManualMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jpValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpFormas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblManual)
                .addGap(4, 4, 4))
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(lblStringNovoPrato)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(linha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(linha1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblStringNovoPrato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpValores, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpFormas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblManual)
                            .addComponent(jpTroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(linha1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(620, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebitoActionPerformed
        try{
            String valor = txtValorASerCobrado.getText();
            if (valor.equals("0,00")){
                JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
            }else{
                valor = valor.replace(".", "");
                valor = valor.replace(",", ".");
                valorCobrado = Double.parseDouble(valor);
                adicionarFormaDePagamento("Débito");
            }            
        }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
        }
                
    }//GEN-LAST:event_btnDebitoActionPerformed

    private void btnDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinheiroActionPerformed
        limparSelecao();
        jpTroco.setVisible(true);
    }//GEN-LAST:event_btnDinheiroActionPerformed

    private void btnVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoucherActionPerformed
        try{
            String valor = txtValorASerCobrado.getText();
            if (valor.equals("0,00")){
                JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
            }else{
                valor = valor.replace(".", "");
                valor = valor.replace(",", ".");
                valorCobrado = Double.parseDouble(valor);
                adicionarFormaDePagamento("Voucher");
            }            
        }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
        }
    }//GEN-LAST:event_btnVoucherActionPerformed

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        try{
            String valor = txtValorASerCobrado.getText();
            if (valor.equals("0,00")){
                JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
            }else{
                valor = valor.replace(".", "");
                valor = valor.replace(",", ".");
                valorCobrado = Double.parseDouble(valor);
                adicionarFormaDePagamento("Crédito");
            }            
        }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
        }
    }//GEN-LAST:event_btnCreditoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    public void removerItemLista(int indice){
        
    }
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // Instancia todos os objetos de DAO
        LogCaixaDAO logDao = new LogCaixaDAO();
        VendaDAO vendaDao = new VendaDAO();
        FormaDAO formaDao = new FormaDAO();
        ComandaDAO comandaDao = new ComandaDAO();
        CaixaDAO caixaDao = new CaixaDAO();
        CarteiraDAO carteiraDao = new CarteiraDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        ProdutoDAO pDao = new ProdutoDAO();
        ItemVendaDAO itemDao = new ItemVendaDAO();
        
        // Instancia os objetos necessários para o encerramento da venda      
        ArrayList<Produto> itens = new ArrayList<>();
        ArrayList<String> qtd = new ArrayList<>();
        Venda v = EncerrarComanda.venda;
        v.setData(v.dataAtual());
        if (v.getCliente() != null){
            vendaDao.createComCliente(v);
        }else{
            vendaDao.create(v);
        } 
        // Após a criação da nova venda no banco, puxa o ID que foi criado e coloca dentro do objeto VENDA que está sendo trabalhado
        v.setIdBanco(vendaDao.readLast().getIdBanco());
        
        for (Forma f : v.getFormasPagamento()){
            // Atualiza o caixa caso a forma de pagamento seja em dinheiro
            if (!f.getFormaPagamento().equals("Carteira")){
                LogCaixa l = new LogCaixa(1); 
                l.setCategoria("Caixa");
                l.setData(l.dataAtual());
                l.setTipo("Crédito");
                l.setDescricao(Login.funcAtual.getNome()+" fez uma venda no valor de R$ "+GerenciadorComandas.valorMonetario(f.getValor()));
                l.setValor(f.getValor());
                Double dinheiroCaixa = Login.caixaAtual.getDinheiro();
                dinheiroCaixa += f.getValor();
                Login.caixaAtual.setDinheiro(dinheiroCaixa);
                l.setSaldo(dinheiroCaixa);
                logDao.create(l);
                caixaDao.update(Login.caixaAtual);
            }
            
            // Seta a venda que possui ID gerado no banco dentro da Forma
            f.setVenda(v);
            formaDao.create(f);
            
            // Atualiza os valores de TODOS OS CLIENTES que estão nas Formas criadas
            if (f.getCliente() != null){
                f.getCliente().aumentarSaldo(f.getValor());
                f.getCliente().aumentarSaldoPendente(f.getValor());
                clienteDao.updateSaldo(f.getCliente());
            }
        }
        
        // Cria todas as carteiras no banco
        for (Carteira c : InserirCliente.listaCarteiras){
            carteiraDao.create(c);
        }
        InserirCliente.listaCarteiras.removeAll(InserirCliente.listaCarteiras);
        
        // Cria no banco todos os itens que estão na Venda
        for (Double d : v.getPratos()){
            itemDao.create(d, v);
        }
        
        int qtdProdutos = v.getItens().size();
        for (int i = 0; i < qtdProdutos; i++){
            itemDao.create(v.getItens().get(i), Integer.parseInt(v.getQnt().get(i)), v);
        }
        
        for (Integer id : EncerrarComanda.listaIds){
            Comanda c = comandaDao.readForId(id);
            comandaDao.updateStatus(c);
        }
        
        // Remove da lista de comandas abertas as comandas que acabaram de ser fechadas
        ArrayList<Integer> indicesASeremRemovidos = new ArrayList<>();
        int indice = 0;
        for (Comanda c:GerenciadorComandas.comandasAbertas){
            for (Integer id : EncerrarComanda.listaIds){
                if (c.getId() == id){
                    indicesASeremRemovidos.add(indice);
                }
            }
            indice += 1;
        }
        
        int contador = 0;
        for (Integer i : indicesASeremRemovidos){
            GerenciadorComandas.comandasAbertas.remove(i-contador);
            contador += 1;
        }
        
        // Retorna ao estoque os produtos que foram removidos da venda
        int tamanho = EncerrarComanda.prodRemovido.size();
        for (int i = 0; i < tamanho; i++){
            if (!EncerrarComanda.prodRemovido.get(i).getQtdEstoque().equals("X")){
                Produto p = EncerrarComanda.prodRemovido.get(i);
                Integer qtdEstoqueAtual = Integer.parseInt(p.getQtdEstoque());
                Integer qtdParaRemover = Integer.parseInt(EncerrarComanda.qtdRemovida.get(i));
                qtdEstoqueAtual += qtdParaRemover;
                
                // TESTE DA REMOÇÃO DO ALARME

                    AlertaDAO aDao = new AlertaDAO();
                    aDao.delete(p.getIdProduto());
                
                //
                p.setQtdEstoque(qtdEstoqueAtual.toString());
                pDao.updateEstoque(p);
            }
        }
        
        // Zera a lista de ids da Venda
        EncerrarComanda.listaIds.removeAll(EncerrarComanda.listaIds);
 
        dispose();
        EncerrarComanda.flagVendaEncerrada = true;
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void jtPagamentoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPagamentoFocusGained
        btnRemover.setEnabled(true);
        jpTroco.setVisible(false);
    }//GEN-LAST:event_jtPagamentoFocusGained

    private void txtEntregueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntregueKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntregueKeyPressed

    private void txtEntregueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntregueKeyReleased
        String valorASerCobrado = txtValorASerCobrado.getText();
        String valorEntregue = txtEntregue.getText();
        valorASerCobrado = valorASerCobrado.replace("." , "");
        valorEntregue = valorEntregue.replace("." , "");
        Double troco = Double.parseDouble(GerenciadorComandas.tornarCompativel(valorASerCobrado)) - Double.parseDouble(GerenciadorComandas.tornarCompativel(valorEntregue));
        if (troco < 0){
            troco = Math.abs(troco);
            lblTroco.setText("R$ "+GerenciadorComandas.valorMonetario(troco));
        }else{
            lblTroco.setText("R$ 0,00");
        }
    }//GEN-LAST:event_txtEntregueKeyReleased

    private void txtEntregueKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntregueKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEntregueKeyTyped

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int indice = jtPagamento.getSelectedRow();
        if (jtPagamento.getSelectedRows().length > 1){
            JOptionPane.showMessageDialog(null, "Selecione somente uma forma de pagamento por vez para remover");
        }else{
            Venda v = EncerrarComanda.venda;
            DefaultTableModel dtm = (DefaultTableModel) jtPagamento.getModel();
            String formaString = (String)dtm.getValueAt(indice, 0);
            if (formaString.equals("Carteira")){
                int indiceCarteiraSelecionada = 0;
                for (int i = 0; i < indice; i++){
                    String a = (String)dtm.getValueAt(i, 0);
                    if (a.equals("Carteira")){
                        indiceCarteiraSelecionada += 1;
                    }
                }
                InserirCliente.listaCarteiras.remove(indiceCarteiraSelecionada);
            }
            v.removerForma(indice);
            dtm.removeRow(indice);

            // Ajustes na tela
            lblValorPendente.setText("R$ "+GerenciadorComandas.valorMonetario(v.getTotalPendente()));
            txtValorASerCobrado.setEnabled(true);
            btnConfirmar.setEnabled(false);
            btnRemover.setEnabled(false);            
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try{
            String valor = txtValorASerCobrado.getText();
            if (valor.equals("0,00")){
                JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
            }else{
                valor = valor.replace(".", "");
                valor = valor.replace(",", ".");
                valorCobrado = Double.parseDouble(valor);
                adicionarFormaDePagamento("Dinheiro");
                txtEntregue.setText("0,00");
                lblTroco.setText("R$ 0,00");
                jpTroco.setVisible(false);
            }            
        }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed
    private void jtPagamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPagamentoFocusLost
        
    }//GEN-LAST:event_jtPagamentoFocusLost

    private void txtValorASerCobradoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorASerCobradoKeyReleased
        Character entrada = evt.getKeyChar();
        if (entrada == 'f' || entrada == 'F'){
            txtValorASerCobrado.setText(GerenciadorComandas.valorMonetario(EncerrarComanda.venda.getTotalPendente()));
        }
    }//GEN-LAST:event_txtValorASerCobradoKeyReleased

    private void txtEntregueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEntregueFocusGained
        if (txtValorASerCobrado.getText().equals("") || txtValorASerCobrado.getText().equals("0,00")){
            txtEntregue.setEnabled(false);
        }
        limparSelecao();
    }//GEN-LAST:event_txtEntregueFocusGained

    private void txtValorASerCobradoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtValorASerCobradoFocusGained
        jpTroco.setVisible(false);
        txtEntregue.setEnabled(true);
        this.limparSelecao();
    }//GEN-LAST:event_txtValorASerCobradoFocusGained

    private void txtValorASerCobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorASerCobradoActionPerformed
        limparSelecao();
    }//GEN-LAST:event_txtValorASerCobradoActionPerformed

    private void txtEntregueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntregueActionPerformed
        limparSelecao();
    }//GEN-LAST:event_txtEntregueActionPerformed

    private void btnCarteiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarteiraActionPerformed
        try{
            String valor = txtValorASerCobrado.getText();
            if (valor.equals("0,00")){
                JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
            }else{
                valor = valor.replace(".", "");
                valor = valor.replace(",", ".");
                valorCobrado = Double.parseDouble(valor);
                InserirCliente cliente = new InserirCliente(new javax.swing.JFrame(), true);
                cliente.setVisible(true);
            }         
        }catch(java.lang.NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Insira o valor antes de selecionar a forma de pagamento");
        }
        
    }//GEN-LAST:event_btnCarteiraActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if (InserirCliente.flagCliente){
            adicionarFormaDePagamento("Carteira");
            InserirCliente.flagCliente = false;
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnAdicionarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAdicionarFocusGained
        limparSelecao();
    }//GEN-LAST:event_btnAdicionarFocusGained

    private void lblManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblManualMouseClicked
        Manual.abrirManual("formaPagamento");
    }//GEN-LAST:event_lblManualMouseClicked

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
            java.util.logging.Logger.getLogger(FormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormaPagamento dialog = new FormaPagamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCarteira;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnDebito;
    private javax.swing.JButton btnDinheiro;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoucher;
    private javax.swing.ButtonGroup grupo1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpFormas;
    private javax.swing.JPanel jpTroco;
    private javax.swing.JPanel jpValores;
    private static javax.swing.JTable jtPagamento;
    private javax.swing.JLabel lblManual;
    private javax.swing.JLabel lblStringNovoPrato;
    private javax.swing.JLabel lblStringTroco;
    private javax.swing.JLabel lblStringValorCobrado;
    private javax.swing.JLabel lblStringValorEntregue;
    private javax.swing.JLabel lblStringValorPendente;
    private javax.swing.JLabel lblStringValorTotal;
    private javax.swing.JLabel lblTroco;
    private javax.swing.JLabel lblValorPendente;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.Box.Filler linha;
    private javax.swing.Box.Filler linha1;
    private javax.swing.JTextField txtEntregue;
    private javax.swing.JTextField txtValorASerCobrado;
    // End of variables declaration//GEN-END:variables
}
