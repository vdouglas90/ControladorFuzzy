/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfigFuzzy.java
 *
 * Created on 28/10/2012, 18:00:11
 */
package Interfaces;

import ControladorFuzzyLulu.Entrada;
import ControladorFuzzyLulu.FuncaoPertinencia;
import ControladorFuzzyLulu.InterfaceEntSai;
import ControladorFuzzyLulu.Regras;
import ControladorFuzzyLulu.Saida;
import Graficos.GraficoFP;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import algoritmogenetico.*;
import java.util.Vector;


/**
 *
 * @author Luiz Bezerra
 */
public class ConfigFuzzy extends javax.swing.JFrame {

    public List<InterfaceEntSai> listaEntSai = new ArrayList<InterfaceEntSai>();
    public List<Entrada> listaEntradas = new ArrayList<Entrada>();
    public List<Saida> listaSaidas = new ArrayList<Saida>();
    public List<FuncaoPertinencia> listaFuncoesPertinencias = new ArrayList<FuncaoPertinencia>();
    public List<Regras> listaRegras = new ArrayList<Regras>();
    private DefaultListModel model_listaEntrada = new DefaultListModel();
    private GraficoFP plotFP;
    private FuncaoPertinencia fp;
    private Regras regras;
    private Individuo individuo;

    /** Creates new form ConfigFuzzy */
    public ConfigFuzzy() {
        initComponents();
        this.setLocationRelativeTo(null);
        //inicializarGraficoFP();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_controlador = new javax.swing.ButtonGroup();
        painel_abas = new javax.swing.JTabbedPane();
        painel_configGeral = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        remover_entrada = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        campo_nomeEntrada = new javax.swing.JTextField();
        add_entrada = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista_entradas = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista_saidas = new javax.swing.JList();
        jLabel4 = new javax.swing.JLabel();
        campo_nomeSaida = new javax.swing.JTextField();
        add_saida = new javax.swing.JButton();
        remover_saida = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        radio_mamdani = new javax.swing.JRadioButton();
        radio_sugeno = new javax.swing.JRadioButton();
        painel_fuzzy_desfuzzy = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        metodoE = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        metodoOU = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        implicacao = new javax.swing.JComboBox();
        agregacao = new javax.swing.JComboBox();
        desfuzzyficacao = new javax.swing.JComboBox();
        painel_funcPertinencia = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista_EntSai = new javax.swing.JList();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lista_fp = new javax.swing.JList();
        jLabel12 = new javax.swing.JLabel();
        painel_fp = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        nome_fp = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tipo_EntSai = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        campo_nomeFP = new javax.swing.JTextField();
        tipo_fp = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        p2 = new javax.swing.JSpinner();
        p4 = new javax.swing.JSpinner();
        p1 = new javax.swing.JSpinner();
        p3 = new javax.swing.JSpinner();
        addFP = new javax.swing.JButton();
        removerFP = new javax.swing.JButton();
        rangeMin = new javax.swing.JTextField();
        rangeMax = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        painel_plotFP = new javax.swing.JPanel();
        painelCamada = new javax.swing.JLayeredPane();
        painel_base_regras = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaRegrasEnt1 = new javax.swing.JList();
        jLabel18 = new javax.swing.JLabel();
        label_entrada1 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listaRegrasEnt2 = new javax.swing.JList();
        label_condicao = new javax.swing.JLabel();
        label_entrada2 = new javax.swing.JLabel();
        label_entao = new javax.swing.JLabel();
        label_saida = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaRegrasSaidas = new javax.swing.JList();
        addRegras = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        removerRegras = new javax.swing.JButton();
        combo_E_OU = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        lista_regras = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ok = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurações do Controlador Fuzzy");

        painel_abas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                painel_abasFocusGained(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Entradas"));

        remover_entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove (1).png"))); // NOI18N
        remover_entrada.setText("Remover");
        remover_entrada.setIconTextGap(8);
        remover_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover_entradaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome:");

        campo_nomeEntrada.setText("entrada");

        add_entrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        add_entrada.setText("Adicionar");
        add_entrada.setIconTextGap(8);
        add_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_entradaActionPerformed(evt);
            }
        });

        lista_entradas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_entradas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_entradasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista_entradas);

        jLabel2.setText("Lista de Entradas:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(remover_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campo_nomeEntrada)
                    .addComponent(add_entrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campo_nomeEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(add_entrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remover_entrada))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Saídas"));

        jLabel3.setText("Lista de Saídas:");

        lista_saidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_saidas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_saidasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lista_saidas);

        jLabel4.setText("Nome:");

        campo_nomeSaida.setText("saída");

        add_saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        add_saida.setText("Adicionar");
        add_saida.setIconTextGap(8);
        add_saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_saidaActionPerformed(evt);
            }
        });

        remover_saida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove (1).png"))); // NOI18N
        remover_saida.setText("Remover");
        remover_saida.setIconTextGap(8);
        remover_saida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remover_saidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(remover_saida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add_saida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(campo_nomeSaida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campo_nomeSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(add_saida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(remover_saida))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setText("Tipo:");

        tipo_controlador.add(radio_mamdani);
        radio_mamdani.setSelected(true);
        radio_mamdani.setText("Mamdani");
        radio_mamdani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_mamdaniActionPerformed(evt);
            }
        });

        tipo_controlador.add(radio_sugeno);
        radio_sugeno.setText("Sugeno");
        radio_sugeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_sugenoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_configGeralLayout = new javax.swing.GroupLayout(painel_configGeral);
        painel_configGeral.setLayout(painel_configGeralLayout);
        painel_configGeralLayout.setHorizontalGroup(
            painel_configGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_configGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_configGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radio_sugeno)
                    .addGroup(painel_configGeralLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(radio_mamdani))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        painel_configGeralLayout.setVerticalGroup(
            painel_configGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_configGeralLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(painel_configGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_configGeralLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_mamdani)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radio_sugeno)))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        painel_abas.addTab("Geral", painel_configGeral);

        jLabel6.setText("Método E:");

        metodoE.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "min", "prod" }));

        jLabel7.setText("Método OU:");

        metodoOU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "max", "probor" }));

        jLabel8.setText("Implicação:");

        jLabel9.setText("Agregação:");

        jLabel10.setText("Desfuzzyficação:");

        implicacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "min", "prod" }));

        agregacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "max", "sum", "probor" }));

        desfuzzyficacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "centroid" }));

        javax.swing.GroupLayout painel_fuzzy_desfuzzyLayout = new javax.swing.GroupLayout(painel_fuzzy_desfuzzy);
        painel_fuzzy_desfuzzy.setLayout(painel_fuzzy_desfuzzyLayout);
        painel_fuzzy_desfuzzyLayout.setHorizontalGroup(
            painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fuzzy_desfuzzyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(metodoOU, 0, 95, Short.MAX_VALUE)
                        .addComponent(implicacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(desfuzzyficacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(metodoE, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(693, Short.MAX_VALUE))
        );
        painel_fuzzy_desfuzzyLayout.setVerticalGroup(
            painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fuzzy_desfuzzyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metodoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(metodoOU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(implicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fuzzy_desfuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(desfuzzyficacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(237, Short.MAX_VALUE))
        );

        painel_abas.addTab("Fuzzyficação / Desfuzzyficação", painel_fuzzy_desfuzzy);

        lista_EntSai.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_EntSai.setToolTipText("");
        lista_EntSai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_EntSaiMouseClicked(evt);
            }
        });
        lista_EntSai.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_EntSaiValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lista_EntSai);

        jLabel11.setText("Entradas / Saídas:");

        lista_fp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lista_fp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lista_fpMouseClicked(evt);
            }
        });
        lista_fp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lista_fpValueChanged(evt);
            }
        });
        lista_fp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lista_fpFocusGained(evt);
            }
        });
        jScrollPane4.setViewportView(lista_fp);

        jLabel12.setText("Funções de Pertinência:");

        painel_fp.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes E/S"));

        jLabel13.setText("Nome:");

        jLabel14.setText("Tipo:");

        javax.swing.GroupLayout painel_fpLayout = new javax.swing.GroupLayout(painel_fp);
        painel_fp.setLayout(painel_fpLayout);
        painel_fpLayout.setHorizontalGroup(
            painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tipo_EntSai, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(nome_fp, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel_fpLayout.setVerticalGroup(
            painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_fpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(nome_fp, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_fpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(tipo_EntSai, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Função de Pertinência"));

        jLabel15.setText("Nome:");

        jLabel16.setText("Tipo:");

        tipo_fp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Triangular", "Trapezoidal" }));

        jLabel17.setText("Params:");

        p2.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));
        p2.setMaximumSize(new java.awt.Dimension(50, 20));
        p2.setMinimumSize(new java.awt.Dimension(50, 20));
        p2.setPreferredSize(new java.awt.Dimension(50, 20));

        p4.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));
        p4.setMaximumSize(new java.awt.Dimension(50, 20));
        p4.setMinimumSize(new java.awt.Dimension(50, 20));
        p4.setPreferredSize(new java.awt.Dimension(50, 20));

        p1.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));
        p1.setMaximumSize(new java.awt.Dimension(50, 20));
        p1.setMinimumSize(new java.awt.Dimension(50, 20));
        p1.setPreferredSize(new java.awt.Dimension(50, 20));

        p3.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(0.0d), null, null, Double.valueOf(0.1d)));
        p3.setMaximumSize(new java.awt.Dimension(50, 20));
        p3.setMinimumSize(new java.awt.Dimension(50, 20));
        p3.setPreferredSize(new java.awt.Dimension(50, 20));

        addFP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addFP.setText("Adicionar");
        addFP.setIconTextGap(8);
        addFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFPActionPerformed(evt);
            }
        });

        removerFP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove (1).png"))); // NOI18N
        removerFP.setText("Remover");
        removerFP.setIconTextGap(8);
        removerFP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerFPActionPerformed(evt);
            }
        });

        rangeMin.setText("0");

        rangeMax.setText("10");

        jLabel19.setText("Range:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rangeMin, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                                    .addComponent(p3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rangeMax)
                                    .addComponent(p4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(campo_nomeFP, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tipo_fp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                    .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(removerFP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(addFP, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(campo_nomeFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tipo_fp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(p3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rangeMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rangeMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(11, 11, 11)
                .addComponent(addFP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removerFP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        painel_plotFP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painel_plotFP.setToolTipText("Plot das Funções de Pertinência");

        javax.swing.GroupLayout painel_plotFPLayout = new javax.swing.GroupLayout(painel_plotFP);
        painel_plotFP.setLayout(painel_plotFPLayout);
        painel_plotFPLayout.setHorizontalGroup(
            painel_plotFPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCamada, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );
        painel_plotFPLayout.setVerticalGroup(
            painel_plotFPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCamada, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painel_funcPertinenciaLayout = new javax.swing.GroupLayout(painel_funcPertinencia);
        painel_funcPertinencia.setLayout(painel_funcPertinenciaLayout);
        painel_funcPertinenciaLayout.setHorizontalGroup(
            painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_funcPertinenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, 0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_fp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(painel_plotFP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painel_funcPertinenciaLayout.setVerticalGroup(
            painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_funcPertinenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_funcPertinenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painel_plotFP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_funcPertinenciaLayout.createSequentialGroup()
                        .addComponent(painel_fp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painel_funcPertinenciaLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
                    .addGroup(painel_funcPertinenciaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)))
                .addContainerGap())
        );

        painel_abas.addTab("Funções de Pertinência", painel_funcPertinencia);

        listaRegrasEnt1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(listaRegrasEnt1);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel18.setText("Se");

        label_entrada1.setText("Entrada01");

        listaRegrasEnt2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(listaRegrasEnt2);

        label_condicao.setFont(new java.awt.Font("Tahoma", 1, 11));
        label_condicao.setText("E");

        label_entrada2.setText("Entrada02");

        label_entao.setFont(new java.awt.Font("Tahoma", 1, 11));
        label_entao.setText("Então");

        label_saida.setText("Saída");

        listaRegrasSaidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(listaRegrasSaidas);

        addRegras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addRegras.setText("Adicionar");
        addRegras.setIconTextGap(8);
        addRegras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRegrasActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh (1).png"))); // NOI18N
        jButton2.setText("Atualizar");
        jButton2.setIconTextGap(8);

        removerRegras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove (1).png"))); // NOI18N
        removerRegras.setText("Remover");
        removerRegras.setIconTextGap(8);
        removerRegras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRegrasActionPerformed(evt);
            }
        });

        combo_E_OU.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "E", "OU" }));
        combo_E_OU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_E_OUActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(lista_regras);

        javax.swing.GroupLayout painel_base_regrasLayout = new javax.swing.GroupLayout(painel_base_regras);
        painel_base_regras.setLayout(painel_base_regrasLayout);
        painel_base_regrasLayout.setHorizontalGroup(
            painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_base_regrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
                    .addGroup(painel_base_regrasLayout.createSequentialGroup()
                        .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painel_base_regrasLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_base_regrasLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(label_entrada1)
                                .addGap(18, 18, 18)
                                .addComponent(label_condicao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_entrada2)))
                        .addGap(18, 18, 18)
                        .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painel_base_regrasLayout.createSequentialGroup()
                                .addComponent(label_entao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_saida))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(addRegras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_E_OU, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(removerRegras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        painel_base_regrasLayout.setVerticalGroup(
            painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_base_regrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_E_OU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(label_entrada1)
                    .addComponent(label_condicao)
                    .addComponent(label_entrada2)
                    .addComponent(label_entao)
                    .addComponent(label_saida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_base_regrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_base_regrasLayout.createSequentialGroup()
                        .addComponent(addRegras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removerRegras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        painel_abas.addTab("Base de Regras", painel_base_regras);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(333, 333, 333)
                .addComponent(jButton1)
                .addContainerGap(484, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jButton1)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        painel_abas.addTab("tab5", jPanel5);

        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/ok.png"))); // NOI18N
        ok.setText("OK");
        ok.setIconTextGap(8);
        ok.setMaximumSize(new java.awt.Dimension(103, 33));
        ok.setMinimumSize(new java.awt.Dimension(103, 33));
        ok.setPreferredSize(new java.awt.Dimension(103, 33));
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/button_cancel.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setIconTextGap(8);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(665, 665, 665)
                .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelar)
                    .addComponent(ok, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painel_abas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painel_abas, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_okActionPerformed

    private void combo_E_OUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_E_OUActionPerformed
        if (combo_E_OU.getSelectedIndex() == 0) {
            label_condicao.setText("E");
        } else {
            label_condicao.setText("OU");
        }
    }//GEN-LAST:event_combo_E_OUActionPerformed
    public boolean VerificaRepeticaoNaLista(String s, List<String> listaEntradas) {
        boolean b = false;
        for (int i = 0; i < listaEntradas.size(); i++) {
            if (listaEntradas.get(i).equals(s)) {
                b = true;
            }
        }
        return b;
    }
    private void add_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_entradaActionPerformed
        String s = campo_nomeEntrada.getText();
        try {
            Entrada e = new Entrada(s);
            if (listaEntradas.contains(e)) {
                throw new Exceptions();
            }
            listaEntradas.add(e);
            lista_entradas.setListData(listaEntradas.toArray());
        } catch (Exceptions e) {
            JOptionPane.showMessageDialog(this, "Já existe a entrada '" + s + "'.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        atualizarListaEntSai();
    }//GEN-LAST:event_add_entradaActionPerformed

    private void remover_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_entradaActionPerformed
        Entrada entrada = new Entrada(campo_nomeEntrada.getText());
        listaEntradas.remove(entrada);
        lista_entradas.setListData(listaEntradas.toArray());
        atualizarListaEntSai();
    }//GEN-LAST:event_remover_entradaActionPerformed

    private void lista_entradasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_entradasValueChanged
        try {
            campo_nomeEntrada.setText(lista_entradas.getSelectedValue().toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lista_entradasValueChanged

    private void add_saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_saidaActionPerformed
        String s = campo_nomeSaida.getText();
        Saida saida = new Saida(s);
        try {
            if (listaSaidas.contains(saida)) {
                throw new Exceptions();
            }
            listaSaidas.add(saida);
            lista_saidas.setListData(listaSaidas.toArray());

        } catch (Exceptions e) {
            JOptionPane.showMessageDialog(this, "Já existe a saída '" + s + "'.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        atualizarListaEntSai();
    }//GEN-LAST:event_add_saidaActionPerformed

    private void remover_saidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remover_saidaActionPerformed
        Saida saida = new Saida(campo_nomeSaida.getText());
        listaSaidas.remove(saida);
        lista_saidas.setListData(listaSaidas.toArray());
        atualizarListaEntSai();
    }//GEN-LAST:event_remover_saidaActionPerformed

    private void lista_saidasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_saidasValueChanged
        try {
            campo_nomeSaida.setText(lista_saidas.getSelectedValue().toString());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_lista_saidasValueChanged

    private void painel_abasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_painel_abasFocusGained
        /*   listaEntSai = new ArrayList<InterfaceEntSai>();
        listaEntSai.addAll(listaEntradas);
        listaEntSai.addAll(listaSaidas);
        lista_EntSai.setListData(listaEntSai.toArray());
        
        if (listaEntradas.size() >= 2) {
        listaRegrasEnt1.setListData(listaEntradas.get(0).getListaFP().toArray());
        listaRegrasEnt2.setListData(listaEntradas.get(1).getListaFP().toArray());
        }
        if (listaSaidas.size() == 1) {
        listaRegrasSaidas.setListData(listaSaidas.get(0).getListaFP().toArray());
        }*/
    }//GEN-LAST:event_painel_abasFocusGained

    public void atualizarListaEntSai() {
        listaEntSai = new ArrayList<InterfaceEntSai>();
        listaEntSai.addAll(listaEntradas);
        listaEntSai.addAll(listaSaidas);
        lista_EntSai.setListData(listaEntSai.toArray());

        if (listaEntradas.size() >= 2) {
            listaRegrasEnt1.setListData(listaEntradas.get(0).getListaFP().toArray());
            listaRegrasEnt2.setListData(listaEntradas.get(1).getListaFP().toArray());
        }
        if (listaSaidas.size() == 1) {
            listaRegrasSaidas.setListData(listaSaidas.get(0).getListaFP().toArray());
        }
    }

    private void lista_EntSaiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_EntSaiValueChanged
        try {
            nome_fp.setText(lista_EntSai.getSelectedValue().toString());
            Object select = lista_EntSai.getSelectedValue();
            if (select instanceof Entrada) {
                tipo_EntSai.setText("Entrada");
                Entrada entrada = (Entrada) select;
                lista_fp.setListData(entrada.getListaFP().toArray());
                p1.setValue(entrada.getListaFP().get(0).getParam1());
                p2.setValue(entrada.getListaFP().get(0).getParam2());
                p3.setValue(entrada.getListaFP().get(0).getParam3());
                rangeMax.setText(String.valueOf(entrada.getListaFP().get(0).getRangeMax()));
                rangeMin.setText(String.valueOf(entrada.getListaFP().get(0).getRangeMin()));
            } else {
                tipo_EntSai.setText("Saída");
                Saida saida = (Saida) select;
                lista_fp.setListData(saida.getListaFP().toArray());
                p1.setValue(saida.getListaFP().get(0).getParam1());
                p2.setValue(saida.getListaFP().get(0).getParam2());
                p3.setValue(saida.getListaFP().get(0).getParam3());
                rangeMax.setText(String.valueOf(saida.getListaFP().get(0).getRangeMax()));
                rangeMin.setText(String.valueOf(saida.getListaFP().get(0).getRangeMin()));
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_lista_EntSaiValueChanged

    private void addFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFPActionPerformed
        double a = Double.parseDouble(p1.getValue().toString());
        double b = Double.parseDouble(p2.getValue().toString());
        double c = Double.parseDouble(p3.getValue().toString());
        double d = Double.parseDouble(p4.getValue().toString());
        double rangeMin = Double.parseDouble(this.rangeMin.getText());
        double rangeMax = Double.parseDouble(this.rangeMax.getText());
        String tipo = tipo_fp.getSelectedItem().toString();
        String nomefp = campo_nomeFP.getText();

        try {
            FuncaoPertinencia fp = new FuncaoPertinencia(a, b, c, d, rangeMin, rangeMax, tipo, nomefp);

            if (tipo_EntSai.getText().equals("Entrada")) {
                Entrada entrada = (Entrada) lista_EntSai.getSelectedValue();
                if (entrada.getListaFP().contains(fp)) {
                    throw new Exceptions();
                }
                entrada.getListaFP().add(fp);
                lista_fp.setListData(entrada.getListaFP().toArray());
            } else {
                if (tipo_EntSai.getText().equals("Saída")) {
                    Saida saida = (Saida) lista_EntSai.getSelectedValue();
                    if (saida.getListaFP().contains(fp)) {
                        throw new Exceptions();
                    }
                    saida.getListaFP().add(fp);
                    lista_fp.setListData(saida.getListaFP().toArray());
                }
            }

            lista_fp.setSelectedValue(fp, false);
            try {
                ChartPanel chartPanel = fp.gerarGrafico();
                chartPanel.setSize(painel_plotFP.getSize());
                this.pack();
                painelCamada.add(chartPanel);
                painelCamada.repaint();
                painel_plotFP.repaint();
            } catch (Exception e) {
                //silenciando exceção para menega
            }

            //if (fp.getTipo() == "Triangular") {
            //    plotFP.funcTriangular(fp.getSeries(), fp.getParam1(), fp.getParam2(), fp.getParam3());
            //} else if (fp.getTipo() == "Trapezoidal") {
            //    plotFP.funcTrapezoidal(fp.getSeries(), fp.getParam1(), fp.getParam2(), fp.getParam3(), fp.getParam4());
            //}

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Já existe a função de pertinência '" + nomefp + "'.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
        atualizarListaEntSai();
    }//GEN-LAST:event_addFPActionPerformed

    private void radio_sugenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_sugenoActionPerformed
        if (radio_sugeno.isSelected()) {
            painel_abas.setEnabledAt(1, false);
        }
    }//GEN-LAST:event_radio_sugenoActionPerformed

    private void removerFPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerFPActionPerformed
        FuncaoPertinencia fp = (FuncaoPertinencia) lista_fp.getSelectedValue();
        if (fp != null) {
            if (tipo_EntSai.getText().equals("Entrada")) {
                Entrada entrada = (Entrada) lista_EntSai.getSelectedValue();
                entrada.getListaFP().remove(fp);
                lista_fp.setListData(entrada.getListaFP().toArray());
            } else {
                Saida saida = (Saida) lista_EntSai.getSelectedValue();
                saida.getListaFP().remove(fp);
                lista_fp.setListData(saida.getListaFP().toArray());
            }
        }
        atualizarListaEntSai();
    }//GEN-LAST:event_removerFPActionPerformed

    private void lista_fpValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lista_fpValueChanged
        try {
            FuncaoPertinencia fp = (FuncaoPertinencia) lista_fp.getSelectedValue();
            if (fp != null) {
                System.out.println(fp.getRangeMax());
                try {
                    ChartPanel chartPanel = fp.gerarGrafico();
                    chartPanel.setSize(painel_plotFP.getSize());
                    this.pack();
                    painelCamada.add(chartPanel);
                    painelCamada.repaint();
                    painel_plotFP.repaint();
                } catch (Exception e) {
                    //silenciando exceção para menega
                }
            }
        } catch (Exception e) {
            System.out.println("DEU PAW NA LISTA_FPVALUECHANGED! = " + e);
        }

    }//GEN-LAST:event_lista_fpValueChanged

    private void addRegrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRegrasActionPerformed
        try {
            if (listaRegrasSaidas.isSelectionEmpty() || listaRegrasEnt1.isSelectionEmpty() || listaRegrasEnt2.isSelectionEmpty()) {
                throw new Exception();
            }

            regras = new Regras(combo_E_OU.getSelectedIndex() + 1,
                    (FuncaoPertinencia) listaRegrasEnt1.getSelectedValue(),
                    (FuncaoPertinencia) listaRegrasEnt2.getSelectedValue(),
                    (FuncaoPertinencia) listaRegrasSaidas.getSelectedValue());
            listaRegras.add(regras);
            lista_regras.setListData(listaRegras.toArray());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "A seleção das lista de entradas e saídas está incompleta.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addRegrasActionPerformed

    private void removerRegrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRegrasActionPerformed
        listaRegras.remove(lista_regras.getSelectedValue());
        lista_regras.setListData(listaRegras.toArray());
    }//GEN-LAST:event_removerRegrasActionPerformed

    private void radio_mamdaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_mamdaniActionPerformed
        if (radio_mamdani.isSelected()) {
            painel_abas.setEnabledAt(1, true);
        }
    }//GEN-LAST:event_radio_mamdaniActionPerformed

    private void lista_EntSaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_EntSaiMouseClicked
        //lista_EntSaiValueChanged(null);
    }//GEN-LAST:event_lista_EntSaiMouseClicked

    private void lista_fpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lista_fpMouseClicked
        //lista_fpValueChanged(null);
    }//GEN-LAST:event_lista_fpMouseClicked

    private void lista_fpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lista_fpFocusGained
        //lista_fpValueChanged(null);
    }//GEN-LAST:event_lista_fpFocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        Vector erro = individuo.genesErro;
//        Vector derivadaErro = individuo.genesDerivadaErro;
//        Vector tensao = individuo.genesTensao;
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public List<String> concatenarListas(List<String> primeiraLista, List<String> segundaLista) {
        List<String> novaLista = new ArrayList<String>(primeiraLista);
        novaLista.addAll(segundaLista);
        return novaLista;
    }

    public void atualizarGrafico(GraficoFP plotFP) {
        try {
            ChartPanel chartPanel = plotFP.getChartPanel();
            chartPanel.setSize(painel_plotFP.getSize());
            painelCamada.add(chartPanel);
            painelCamada.repaint();
            painel_plotFP.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarGrafico2() {
        painel_plotFP.repaint();
        //painel_plotFP.add(plotFP.getContentPane());
    }

    public List<InterfaceEntSai> getListaEntSai() {
        return listaEntSai;
    }

    public void setListaEntSai(List<InterfaceEntSai> listaEntSai) {
        this.listaEntSai = listaEntSai;
    }

    public List<Entrada> getListaEntradas() {
        return listaEntradas;
    }

    public void setListaEntradas(List<Entrada> listaEntradas) {
        this.listaEntradas = listaEntradas;
    }

    public List<FuncaoPertinencia> getListaFuncoesPertinencias() {
        return listaFuncoesPertinencias;
    }

    public void setListaFuncoesPertinencias(List<FuncaoPertinencia> listaFuncoesPertinencias) {
        this.listaFuncoesPertinencias = listaFuncoesPertinencias;
    }

    public List<Regras> getListaRegras() {
        return listaRegras;
    }

    public void setListaRegras(List<Regras> listaRegras) {
        this.listaRegras = listaRegras;
    }

    public List<Saida> getListaSaidas() {
        return listaSaidas;
    }

    public void setListaSaidas(List<Saida> listaSaidas) {
        this.listaSaidas = listaSaidas;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigFuzzy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigFuzzy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigFuzzy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigFuzzy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ConfigFuzzy().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addFP;
    private javax.swing.JButton addRegras;
    private javax.swing.JButton add_entrada;
    private javax.swing.JButton add_saida;
    private javax.swing.JComboBox agregacao;
    private javax.swing.JTextField campo_nomeEntrada;
    private javax.swing.JTextField campo_nomeFP;
    private javax.swing.JTextField campo_nomeSaida;
    private javax.swing.JButton cancelar;
    private javax.swing.JComboBox combo_E_OU;
    private javax.swing.JComboBox desfuzzyficacao;
    private javax.swing.JComboBox implicacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel label_condicao;
    private javax.swing.JLabel label_entao;
    private javax.swing.JLabel label_entrada1;
    private javax.swing.JLabel label_entrada2;
    private javax.swing.JLabel label_saida;
    public javax.swing.JList listaRegrasEnt1;
    public javax.swing.JList listaRegrasEnt2;
    public javax.swing.JList listaRegrasSaidas;
    public javax.swing.JList lista_EntSai;
    public javax.swing.JList lista_entradas;
    private javax.swing.JList lista_fp;
    public javax.swing.JList lista_regras;
    public javax.swing.JList lista_saidas;
    private javax.swing.JComboBox metodoE;
    private javax.swing.JComboBox metodoOU;
    private javax.swing.JLabel nome_fp;
    private javax.swing.JButton ok;
    private javax.swing.JSpinner p1;
    private javax.swing.JSpinner p2;
    private javax.swing.JSpinner p3;
    private javax.swing.JSpinner p4;
    private javax.swing.JLayeredPane painelCamada;
    private javax.swing.JTabbedPane painel_abas;
    private javax.swing.JPanel painel_base_regras;
    private javax.swing.JPanel painel_configGeral;
    private javax.swing.JPanel painel_fp;
    private javax.swing.JPanel painel_funcPertinencia;
    private javax.swing.JPanel painel_fuzzy_desfuzzy;
    private javax.swing.JPanel painel_plotFP;
    public javax.swing.JRadioButton radio_mamdani;
    public javax.swing.JRadioButton radio_sugeno;
    private javax.swing.JTextField rangeMax;
    private javax.swing.JTextField rangeMin;
    private javax.swing.JButton removerFP;
    private javax.swing.JButton removerRegras;
    private javax.swing.JButton remover_entrada;
    private javax.swing.JButton remover_saida;
    private javax.swing.JLabel tipo_EntSai;
    private javax.swing.ButtonGroup tipo_controlador;
    private javax.swing.JComboBox tipo_fp;
    // End of variables declaration//GEN-END:variables
}
