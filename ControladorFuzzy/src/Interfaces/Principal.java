/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Principal.java
 *
 * Created on 28/10/2012, 17:43:55
 */
package Interfaces;

import Quanser.ControleLRL;
import ControladorFuzzyLulu.ControladorFuzzy;
import ControladorFuzzyLulu.Entrada;
import ControladorFuzzyLulu.FuncaoPertinencia;
import ControladorFuzzyLulu.Fuzzy;
import ControladorFuzzyLulu.InterfaceEntSai;
import ControladorFuzzyLulu.Regras;
import ControladorFuzzyLulu.Saida;
import Graficos.GraficoSistema;
import algoritmogenetico.Genetico;
import br.ufrn.dca.controle.QuanserClient;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Luiz Bezerra
 */
public class Principal extends javax.swing.JFrame {

    QuanserClient qc;
    ConfigFuzzy configFuzzy = new ConfigFuzzy();
    public List<Entrada> entradas = new ArrayList<Entrada>();
    public List<Saida> saidas = new ArrayList<Saida>();
    private List<Regras> regras = new ArrayList<Regras>();
    public List<InterfaceEntSai> listaEntSai = new ArrayList<InterfaceEntSai>();
    private ControladorFuzzy controladorFuzzy;
    private GraficoSistema plot;
    private JFrame janelaArquivo;
    private JFileChooser fileChoose;

    /** Creates new form Principal */
    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    public void instanciarRegras() {
        //Instanciar entradas
        Entrada ent1 = new Entrada();
        Entrada ent2 = new Entrada();
        Saida saida = new Saida();

        entradas = new ArrayList<Entrada>();
        saidas = new ArrayList<Saida>();

        //Erro
        ent1.setId(1);
        ent1.setNome("E");
        ent1.setRangeInf(-30.0);
        ent1.setRangeSup(30.0);
        entradas.add(ent1);


        //Derivada erro
        ent2.setId(2);
        ent2.setNome("DE");
        ent2.setRangeInf(-2.0);
        ent2.setRangeSup(2.0);
        entradas.add(ent2);

        //Tensao de saida
        saida.setId(3);
        saida.setNome("V");
        saida.setRangeInf(-0.1);
        saida.setRangeSup(0.1);
        saidas.add(saida);

        //Instanciar pertinencias DERIVADA
        //DEGN
        FuncaoPertinencia p1 = new FuncaoPertinencia();
        p1.setEnt(ent2);
        p1.setId(1);
        p1.setIdEntrada(ent2.getId());
        p1.setNome("DEGN");
        p1.setTipo("trimf");
        p1.setParam1(-2.0);
        p1.setParam2(-2.0);
        p1.setParam3(-0.125);
        ent2.addPertinencia(p1);

        //DEPN
        FuncaoPertinencia p2 = new FuncaoPertinencia();
        p2.setEnt(ent2);
        p2.setId(2);
        p2.setIdEntrada(ent2.getId());
        p2.setNome("DEPN");
        p2.setTipo("trimf");
        p2.setParam1(-0.25);
        p2.setParam2(-0.125);
        p2.setParam3(-0.075);
        ent2.addPertinencia(p2);

        //DEZ
        FuncaoPertinencia p3 = new FuncaoPertinencia();
        p3.setEnt(ent2);
        p3.setId(3);
        p3.setIdEntrada(ent2.getId());
        p3.setNome("DEZ");
        p3.setTipo("trimf");
        p3.setParam1(-0.125);
        p3.setParam2(0.0);
        p3.setParam3(0.125);
        ent2.addPertinencia(p3);

        //DEPP
        FuncaoPertinencia p4 = new FuncaoPertinencia();
        p4.setEnt(ent2);
        p4.setId(4);
        p4.setIdEntrada(ent2.getId());
        p4.setNome("DEPP");
        p4.setTipo("trimf");
        p4.setParam1(0.075);
        p4.setParam2(0.125);
        p4.setParam3(0.25);
        ent2.addPertinencia(p4);

        //DEGP
        FuncaoPertinencia p5 = new FuncaoPertinencia();
        p5.setEnt(ent2);
        p5.setId(5);
        p5.setIdEntrada(ent2.getId());
        p5.setNome("DEGP");
        p5.setTipo("trimf");
        p5.setParam1(0.125);
        p5.setParam2(2.0);
        p5.setParam3(2.0);
        ent2.addPertinencia(p5);

        //Instanciar pertinencias ERRO
        //EGN
        FuncaoPertinencia p6 = new FuncaoPertinencia();
        p6.setEnt(ent1);
        p6.setId(6);
        p6.setIdEntrada(ent1.getId());
        p6.setNome("GN");
        p6.setTipo("trimf");
        p6.setParam1(-30.0);
        p6.setParam2(-30.0);
        p6.setParam3(-2.0);
        ent1.addPertinencia(p6);

        //EPN
        FuncaoPertinencia p7 = new FuncaoPertinencia();
        p7.setEnt(ent1);
        p7.setId(7);
        p7.setIdEntrada(ent1.getId());
        p7.setNome("EPN");
        p7.setTipo("trimf");
        p7.setParam1(-4.0);
        p7.setParam2(-2.5);
        p7.setParam3(-0.5);
        ent1.addPertinencia(p7);

        //EZ
        FuncaoPertinencia p8 = new FuncaoPertinencia();
        p8.setEnt(ent1);
        p8.setId(8);
        p8.setIdEntrada(ent1.getId());
        p8.setNome("EZ");
        p8.setTipo("trimf");
        p8.setParam1(-1.5);
        p8.setParam2(0.0);
        p8.setParam3(1.5);
        ent1.addPertinencia(p8);
        //EPP
        FuncaoPertinencia p9 = new FuncaoPertinencia();
        p9.setEnt(ent1);
        p9.setId(9);
        p9.setIdEntrada(ent1.getId());
        p9.setNome("EPP");
        p9.setTipo("trimf");
        p9.setParam1(0.5);
        p9.setParam2(2.5);
        p9.setParam3(4.0);
        ent1.addPertinencia(p9);

        //EGP
        FuncaoPertinencia p10 = new FuncaoPertinencia();
        p10.setEnt(ent1);
        p10.setId(10);
        p10.setIdEntrada(ent1.getId());
        p10.setNome("EGP");
        p10.setTipo("trimf");
        p10.setParam1(2.0);
        p10.setParam2(30.0);
        p10.setParam3(30.0);
        ent1.addPertinencia(p10);

        //Instanciar pertinencias Saida
        //IGN  [-0.081 -0.08 -0.079]
        FuncaoPertinencia p11 = new FuncaoPertinencia();
        p11.setSai(saida);
        p11.setId(11);
        p11.setIdEntrada(saida.getId());
        p11.setNome("IGN");
        p11.setTipo("trimf");
        p11.setParam1(-0.081);
        p11.setParam2(-0.08);
        p11.setParam3(-0.079);
        saida.addPertinencia(p11);

        //IMN  [-0.041 -0.04 -0.039]
        FuncaoPertinencia p12 = new FuncaoPertinencia();
        p12.setSai(saida);
        p12.setId(12);
        p12.setIdEntrada(saida.getId());
        p12.setNome("IMN");
        p12.setTipo("trimf");
        p12.setParam1(-0.041);
        p12.setParam2(-0.04);
        p12.setParam3(-0.039);
        saida.addPertinencia(p12);
        //IPN  [-0.005 -0.004 -0.003]
        FuncaoPertinencia p13 = new FuncaoPertinencia();
        p13.setSai(saida);
        p13.setId(13);
        p13.setIdEntrada(saida.getId());
        p13.setNome("IPN");
        p13.setTipo("trimf");
        p13.setParam1(-0.005);
        p13.setParam2(-0.004);
        p13.setParam3(-0.003);
        saida.addPertinencia(p13);

        //IZ [-0.001 0 0.001]
        FuncaoPertinencia p14 = new FuncaoPertinencia();
        p14.setSai(saida);
        p14.setId(14);
        p14.setIdEntrada(saida.getId());
        p14.setNome("IZ");
        p14.setTipo("trimf");
        p14.setParam1(0.001);
        p14.setParam2(0.0);
        p14.setParam3(0.001);
        saida.addPertinencia(p14);

        //IPP  [0.003 0.004 0.005]
        FuncaoPertinencia p15 = new FuncaoPertinencia();
        p15.setSai(saida);
        p15.setId(15);
        p15.setIdEntrada(saida.getId());
        p15.setNome("IPP");
        p15.setTipo("trimf");
        p15.setParam1(0.003);
        p15.setParam2(0.004);
        p15.setParam3(0.005);
        saida.addPertinencia(p15);

        //IMP  [0.039 0.04 0.041]
        FuncaoPertinencia p16 = new FuncaoPertinencia();
        p16.setSai(saida);
        p16.setId(16);
        p16.setIdEntrada(saida.getId());
        p16.setNome("IMP");
        p16.setTipo("trimf");
        p16.setParam1(0.039);
        p16.setParam2(0.04);
        p16.setParam3(0.041);
        saida.addPertinencia(p16);

        //IGP   [0.079 0.08 0.081]
        FuncaoPertinencia p17 = new FuncaoPertinencia();
        p17.setSai(saida);
        p17.setId(17);
        p17.setIdEntrada(saida.getId());
        p17.setNome("IGP");
        p17.setTipo("trimf");
        p17.setParam1(0.079);
        p17.setParam2(0.08);
        p17.setParam3(0.081);
        saida.addPertinencia(p17);

        //REGRAS
        Regras r1 = new Regras();
        r1.setId(18);
        r1.setConexao("AND");
        r1.setFpEntradas2(p1);
        r1.setFpEntradas1(p6);
        r1.setFpSaidas(p11);
        regras.add(r1);

        Regras r2 = new Regras();
        r2.setId(19);
        r2.setConexao("AND");
        r2.setFpEntradas2(p2);
        r2.setFpEntradas1(p6);
        r2.setFpSaidas(p12);
        regras.add(r2);

        Regras r3 = new Regras();
        r3.setId(20);
        r3.setConexao("AND");
        r3.setFpEntradas2(p3);
        r3.setFpEntradas1(p6);
        r3.setFpSaidas(p13);
        regras.add(r3);

        Regras r4 = new Regras();
        r4.setId(21);
        r4.setConexao("AND");
        r4.setFpEntradas2(p4);
        r4.setFpEntradas1(p6);
        r4.setFpSaidas(p16);
        regras.add(r4);

        Regras r5 = new Regras();
        r5.setId(22);
        r5.setConexao("AND");
        r5.setFpEntradas2(p5);
        r5.setFpEntradas1(p6);
        r5.setFpSaidas(p17);
        regras.add(r5);

        Regras r6 = new Regras();
        r6.setId(23);
        r6.setConexao("AND");
        r6.setFpEntradas2(p1);
        r6.setFpEntradas1(p7);
        r6.setFpSaidas(p12);
        regras.add(r6);

        Regras r7 = new Regras();
        r7.setId(24);
        r7.setConexao("AND");
        r7.setFpEntradas2(p2);
        r7.setFpEntradas1(p7);
        r7.setFpSaidas(p13);
        regras.add(r7);

        Regras r8 = new Regras();
        r8.setId(25);
        r8.setConexao("AND");
        r8.setFpEntradas2(p3);
        r8.setFpEntradas1(p7);
        r8.setFpSaidas(p13);
        regras.add(r8);

        Regras r9 = new Regras();
        r9.setId(26);
        r9.setConexao("AND");
        r9.setFpEntradas2(p4);
        r9.setFpEntradas1(p7);
        r9.setFpSaidas(p15);
        regras.add(r9);

        Regras r10 = new Regras();
        r10.setId(27);
        r10.setConexao("AND");
        r10.setFpEntradas2(p5);
        r10.setFpEntradas1(p7);
        r10.setFpSaidas(p16);
        regras.add(r10);

        Regras r11 = new Regras();
        r11.setId(28);
        r11.setConexao("AND");
        r11.setFpEntradas2(p1);
        r11.setFpEntradas1(p8);
        r11.setFpSaidas(p13);
        regras.add(r11);

        Regras r12 = new Regras();
        r12.setId(29);
        r12.setConexao("AND");
        r12.setFpEntradas2(p2);
        r12.setFpEntradas1(p8);
        r12.setFpSaidas(p13);
        regras.add(r12);

        Regras r13 = new Regras();
        r13.setId(30);
        r13.setConexao("AND");
        r13.setFpEntradas2(p3);
        r13.setFpEntradas1(p8);
        r13.setFpSaidas(p14);
        regras.add(r13);

        Regras r14 = new Regras();
        r14.setId(31);
        r14.setConexao("AND");
        r14.setFpEntradas2(p4);
        r14.setFpEntradas1(p8);
        r14.setFpSaidas(p15);
        regras.add(r14);

        Regras r15 = new Regras();
        r15.setId(32);
        r15.setConexao("AND");
        r15.setFpEntradas2(p5);
        r15.setFpEntradas1(p8);
        r15.setFpSaidas(p15);
        regras.add(r15);

        Regras r16 = new Regras();
        r16.setId(33);
        r16.setConexao("AND");
        r16.setFpEntradas2(p1);
        r16.setFpEntradas1(p9);
        r16.setFpSaidas(p16);
        regras.add(r16);

        Regras r17 = new Regras();
        r17.setId(34);
        r17.setConexao("AND");
        r17.setFpEntradas2(p2);
        r17.setFpEntradas1(p8);
        r17.setFpSaidas(p15);
        regras.add(r17);

        Regras r18 = new Regras();
        r18.setId(35);
        r18.setConexao("AND");
        r18.setFpEntradas2(p3);
        r18.setFpEntradas1(p9);
        r18.setFpSaidas(p15);
        regras.add(r18);

        Regras r19 = new Regras();
        r19.setId(36);
        r19.setConexao("AND");
        r19.setFpEntradas2(p4);
        r19.setFpEntradas1(p9);
        r19.setFpSaidas(p13);
        regras.add(r19);

        Regras r20 = new Regras();
        r20.setId(37);
        r20.setConexao("AND");
        r20.setFpEntradas2(p5);
        r20.setFpEntradas1(p9);
        r20.setFpSaidas(p12);
        regras.add(r20);

        Regras r21 = new Regras();
        r21.setId(38);
        r21.setConexao("AND");
        r21.setFpEntradas2(p1);
        r21.setFpEntradas1(p10);
        r21.setFpSaidas(p17);
        regras.add(r21);

        Regras r22 = new Regras();
        r22.setId(39);
        r22.setConexao("AND");
        r22.setFpEntradas2(p2);
        r22.setFpEntradas1(p10);
        r22.setFpSaidas(p16);
        regras.add(r22);

        Regras r23 = new Regras();
        r23.setId(40);
        r23.setConexao("AND");
        r23.setFpEntradas2(p3);
        r23.setFpEntradas1(p10);
        r23.setFpSaidas(p15);
        regras.add(r23);

        Regras r24 = new Regras();
        r24.setId(41);
        r24.setConexao("AND");
        r24.setFpEntradas2(p4);
        r24.setFpEntradas1(p10);
        r24.setFpSaidas(p12);
        regras.add(r24);

        Regras r25 = new Regras();
        r25.setId(42);
        r25.setConexao("AND");
        r25.setFpEntradas2(p5);
        r25.setFpEntradas1(p10);
        r25.setFpSaidas(p11);
        regras.add(r25);



        //Atualizar lista de entradas e saidas
        //configFuzzy.listaEntSai = new ArrayList<InterfaceEntSai>();
        configFuzzy.listaEntSai.addAll(entradas);
        configFuzzy.listaEntSai.addAll(saidas);
        configFuzzy.lista_EntSai.setListData(configFuzzy.listaEntSai.toArray());

        configFuzzy.lista_regras.setListData(regras.toArray());
        configFuzzy.listaRegrasEnt1.setListData(entradas.get(0).getListaFP().toArray());
        configFuzzy.listaRegrasEnt2.setListData(entradas.get(1).getListaFP().toArray());
        configFuzzy.listaRegrasSaidas.setListData(saidas.get(0).getListaFP().toArray());

        configFuzzy.setListaEntradas(entradas);
        configFuzzy.setListaSaidas(saidas);
        configFuzzy.setListaRegras(regras);
        configFuzzy.setListaEntSai(listaEntSai);

        configFuzzy.lista_entradas.setListData(entradas.toArray());
        configFuzzy.lista_saidas.setListData(saidas.toArray());
        configFuzzy.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        painel_grafico = new javax.swing.JPanel();
        painel_menuFuzzy = new javax.swing.JPanel();
        configContFuzzy = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        setPoint = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        atualizar = new javax.swing.JButton();
        carregarArquivo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        porta = new javax.swing.JTextField();
        conectar = new javax.swing.JButton();
        desconectar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        exemploMandani = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        mandani = new javax.swing.JRadioButton();
        sugeno = new javax.swing.JRadioButton();
        otimizarFuzzy = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jToolBar2 = new javax.swing.JToolBar();
        erro_label = new javax.swing.JLabel();
        de_label = new javax.swing.JLabel();
        tensao_label = new javax.swing.JLabel();
        nivelt1_label = new javax.swing.JLabel();
        nivelt2_label = new javax.swing.JLabel();
        sp_label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controlador Fuzzy");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        painel_grafico.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        painel_grafico.setToolTipText("");

        javax.swing.GroupLayout painel_graficoLayout = new javax.swing.GroupLayout(painel_grafico);
        painel_grafico.setLayout(painel_graficoLayout);
        painel_graficoLayout.setHorizontalGroup(
            painel_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        painel_graficoLayout.setVerticalGroup(
            painel_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );

        painel_menuFuzzy.setBorder(javax.swing.BorderFactory.createTitledBorder("Controlador Fuzzy"));

        configContFuzzy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/settings - 24.png"))); // NOI18N
        configContFuzzy.setText("Configurações");
        configContFuzzy.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        configContFuzzy.setIconTextGap(8);
        configContFuzzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configContFuzzyActionPerformed(evt);
            }
        });

        jLabel3.setText("Set-Point:");

        setPoint.setText("0");

        jLabel4.setText("cm");

        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh (1).png"))); // NOI18N
        atualizar.setText("Atualizar");
        atualizar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        atualizar.setIconTextGap(8);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        carregarArquivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load.png"))); // NOI18N
        carregarArquivo.setText("Carregar Arquivo");
        carregarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_menuFuzzyLayout = new javax.swing.GroupLayout(painel_menuFuzzy);
        painel_menuFuzzy.setLayout(painel_menuFuzzyLayout);
        painel_menuFuzzyLayout.setHorizontalGroup(
            painel_menuFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_menuFuzzyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_menuFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_menuFuzzyLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(setPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(carregarArquivo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(configContFuzzy, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                    .addComponent(atualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel_menuFuzzyLayout.setVerticalGroup(
            painel_menuFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_menuFuzzyLayout.createSequentialGroup()
                .addGroup(painel_menuFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(setPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(atualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carregarArquivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configContFuzzy)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Conexão Quanser"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("IP:");

        jLabel2.setText("Porta:");

        ip.setText("127.0.0.1");

        porta.setText("20081");

        conectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/enable_24.png"))); // NOI18N
        conectar.setText("Conectar");
        conectar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        conectar.setIconTextGap(8);
        conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarActionPerformed(evt);
            }
        });

        desconectar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disable_24.png"))); // NOI18N
        desconectar.setText("Desconectar");
        desconectar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        desconectar.setIconTextGap(8);
        desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desconectarActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        status.setFont(new java.awt.Font("Tahoma", 1, 11));
        status.setForeground(new java.awt.Color(255, 0, 0));
        status.setText("Desconectado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ip, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(porta, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(status, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                    .addComponent(conectar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(desconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(porta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(conectar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desconectar)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("TITULO"));

        exemploMandani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/load.png"))); // NOI18N
        exemploMandani.setText("Exemplo Mandani");
        exemploMandani.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        exemploMandani.setIconTextGap(8);
        exemploMandani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exemploMandaniActionPerformed(evt);
            }
        });

        jLabel8.setText("Fuzzy");

        buttonGroup1.add(mandani);
        mandani.setSelected(true);
        mandani.setText("Mandani");

        buttonGroup1.add(sugeno);
        sugeno.setText("Sugeno");

        otimizarFuzzy.setText("Otimizar Fuzzy (AG)");
        otimizarFuzzy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otimizarFuzzyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(otimizarFuzzy, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exemploMandani, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sugeno, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mandani, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(exemploMandani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(otimizarFuzzy, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mandani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sugeno)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        jToolBar1.setFloatable(false);
        jToolBar1.setOrientation(1);
        jToolBar1.setRollover(true);
        jToolBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel19.setText("Erro:");
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel19.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel19.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel19.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel19);

        jLabel20.setText("Deriv. Erro:");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel20.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel20.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel20.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel20);

        jLabel18.setText("Tensão:");
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel18.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel18.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel18.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel18);

        jLabel17.setText("Nível T1:");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel17.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel17.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel17.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel17.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel17);

        jLabel21.setText("Nível T2:");
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel21.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel21.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel21.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel21);

        jLabel15.setText("Set-Point:");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel15.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setMaximumSize(new java.awt.Dimension(80, 22));
        jLabel15.setMinimumSize(new java.awt.Dimension(100, 22));
        jLabel15.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar1.add(jLabel15);

        jToolBar2.setFloatable(false);
        jToolBar2.setOrientation(1);
        jToolBar2.setRollover(true);

        erro_label.setMaximumSize(new java.awt.Dimension(100, 22));
        erro_label.setMinimumSize(new java.awt.Dimension(100, 22));
        erro_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(erro_label);

        de_label.setMaximumSize(new java.awt.Dimension(100, 22));
        de_label.setMinimumSize(new java.awt.Dimension(100, 22));
        de_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(de_label);

        tensao_label.setMaximumSize(new java.awt.Dimension(100, 22));
        tensao_label.setMinimumSize(new java.awt.Dimension(100, 22));
        tensao_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(tensao_label);

        nivelt1_label.setMaximumSize(new java.awt.Dimension(100, 22));
        nivelt1_label.setMinimumSize(new java.awt.Dimension(100, 22));
        nivelt1_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(nivelt1_label);

        nivelt2_label.setMaximumSize(new java.awt.Dimension(100, 22));
        nivelt2_label.setMinimumSize(new java.awt.Dimension(100, 22));
        nivelt2_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(nivelt2_label);

        sp_label.setMaximumSize(new java.awt.Dimension(100, 22));
        sp_label.setMinimumSize(new java.awt.Dimension(100, 22));
        sp_label.setPreferredSize(new java.awt.Dimension(100, 22));
        jToolBar2.add(sp_label);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addContainerGap())
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(painel_grafico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painel_menuFuzzy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_menuFuzzy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configContFuzzyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configContFuzzyActionPerformed
        configFuzzy.setVisible(true);
    }//GEN-LAST:event_configContFuzzyActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        inicializarGrafico();
    }//GEN-LAST:event_formWindowActivated

    private void conectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarActionPerformed
        if (qc == null) {
            try {
                double SP = Double.parseDouble(setPoint.getText());
                qc = new QuanserClient(ip.getText(), Integer.parseInt(porta.getText()));
                status.setText("Conectado");
                status.setForeground(Color.GREEN);
            } catch (Exception excep) {
                JOptionPane.showMessageDialog(this, "Erro ao tentar conectar a planta da Quanser.", "Mensagem", JOptionPane.ERROR_MESSAGE);
                System.out.println(excep.getMessage());
            }
        } else {
            System.out.println("Já ativado.");
        }
    }//GEN-LAST:event_conectarActionPerformed

    private void desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desconectarActionPerformed
        try {
            if (controladorFuzzy != null) {
                controladorFuzzy.escreverQuanser(0, 0.0);
                controladorFuzzy.stop();
            }
            status.setText("Desconectado");
            status.setForeground(Color.red);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao tentar desconectar a planta da Quanser.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_desconectarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        try {
            double SP = Double.parseDouble(setPoint.getText());
            Fuzzy fuzzy = new Fuzzy(regras);
            controladorFuzzy = new ControladorFuzzy(fuzzy, SP, 100, plot, this);
            ControleLRL.getInstance().setEndereco(ip.getText());
            controladorFuzzy.start();


            //erro_label.setText(String.valueOf(controladorFuzzy.getErro()));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar controlador!", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_atualizarActionPerformed

    private void exemploMandaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exemploMandaniActionPerformed
        try {
            instanciarRegras();
            JOptionPane.showMessageDialog(this, "Exemplo Mandani carregado com sucesso.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar exemplo Mandani.", "Mensagem", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_exemploMandaniActionPerformed

    private void carregarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarArquivoActionPerformed
        selecionarArquivo();
    }//GEN-LAST:event_carregarArquivoActionPerformed

    private void otimizarFuzzyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otimizarFuzzyActionPerformed
        double SP = 10.0;
        Genetico g = new Genetico(100);
        g.criarPopulacao();
        g.algoritmoGenetico(10);
        Fuzzy fuzzy = new Fuzzy(regras);
        controladorFuzzy = new ControladorFuzzy(fuzzy, SP, 100, plot, this);
        ControleLRL.getInstance().setEndereco(ip.getText());
        controladorFuzzy.start();
    }//GEN-LAST:event_otimizarFuzzyActionPerformed
    private void selecionarArquivo() {
        janelaArquivo = new JFrame("Abrir Arquivo Fuzzy");
        janelaArquivo.setLocation(350, 150);

        if (fileChoose == null) {
            fileChoose = new JFileChooser();
            fileChoose.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (JFileChooser.APPROVE_SELECTION.equals(e.getActionCommand())) {
                        fileChoose.accept(fileChoose.getSelectedFile());
                        processarArquivo(fileChoose.getSelectedFile());
                        getJanelaArquivo().dispose();
                    } else if (JFileChooser.CANCEL_SELECTION.equals(e.getActionCommand())) {
                        getJanelaArquivo().dispose();
                    }
                }
            });
        }

        fileChoose.setVisible(true);
        janelaArquivo.add(fileChoose);
        janelaArquivo.setSize(new Dimension(640, 480));
        janelaArquivo.setVisible(true);
    }

    private void processarArquivo(File arquivo) {
        try {
            Scanner sc = new Scanner(arquivo);
            int index, indexInit = 0;
            String valor;
            int i = 0;
            Map<Integer, List<String>> arquivoMap = new HashMap<Integer, List<String>>();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                index = line.indexOf(" ");
                if (index >= 0) {
                    line += " ";
                    valor = line.substring(0, index);
                    arquivoMap.put(i, new ArrayList<String>());
                    arquivoMap.get(i).add(valor);
                    indexInit = index + 1;
                    index = line.indexOf(" ", indexInit);
                }

                while (index >= 0) {
                    valor = line.substring(indexInit, index);
                    arquivoMap.get(i).add(valor);
                    indexInit = index + 1;
                    index = line.indexOf(" ", indexInit);
                }

                i++;
            }

            int numLinha = 0;
            int numEntradas = Integer.parseInt(arquivoMap.get(numLinha).get(0));
            int numSaidas = Integer.parseInt(arquivoMap.get(numLinha).get(1));
            int numRegras = Integer.parseInt(arquivoMap.get(numLinha).get(2));

            int id = 1;
            // Entradas e suas funções de pertinencias
            entradas = new ArrayList<Entrada>();
            while (entradas.size() < numEntradas) {
                numLinha++;
                Entrada entrada = new Entrada();
                entrada.setId(id++);
                entrada.setNome(arquivoMap.get(numLinha).get(0));
                entrada.setRangeInf(Double.parseDouble((arquivoMap.get(numLinha).get(1))));
                entrada.setRangeSup(Double.parseDouble((arquivoMap.get(numLinha).get(2))));
                int numFuncoesPert = Integer.parseInt(arquivoMap.get(numLinha).get(3));
                while (entrada.getListaFP().size() < numFuncoesPert) {
                    numLinha++;
                    FuncaoPertinencia pertinencia = new FuncaoPertinencia();
                    pertinencia.setId(id++);
                    pertinencia.setEnt(entrada);
                    pertinencia.setIdEntrada(entrada.getId());
                    pertinencia.setNome(arquivoMap.get(numLinha).get(0));
                    pertinencia.setTipo(arquivoMap.get(numLinha).get(1));
                    pertinencia.setParam1(Double.parseDouble(arquivoMap.get(numLinha).get(2)));
                    pertinencia.setParam2(Double.parseDouble(arquivoMap.get(numLinha).get(3)));
                    pertinencia.setParam3(Double.parseDouble(arquivoMap.get(numLinha).get(4)));
                    entrada.addPertinencia(pertinencia);
                }
                entradas.add(entrada);
            }

            // Saidas e suas funções de pertinencias
            saidas = new ArrayList<Saida>();
            while (saidas.size() < numSaidas) {
                numLinha++;
                Saida saida = new Saida();
                saida.setId(id++);
                saida.setNome(arquivoMap.get(numLinha).get(0));
                saida.setRangeInf(Double.parseDouble((arquivoMap.get(numLinha).get(1))));
                saida.setRangeSup(Double.parseDouble((arquivoMap.get(numLinha).get(2))));
                int numFuncoesPert = Integer.parseInt(arquivoMap.get(numLinha).get(3));
                while (saida.getListaFP().size() < numFuncoesPert) {
                    numLinha++;
                    FuncaoPertinencia pertinencia = new FuncaoPertinencia();
                    pertinencia.setId(id++);
                    pertinencia.setSai(saida);
                    pertinencia.setIdEntrada(saida.getId());
                    pertinencia.setNome(arquivoMap.get(numLinha).get(0));
                    pertinencia.setTipo(arquivoMap.get(numLinha).get(1));
                    pertinencia.setParam1(Double.parseDouble(arquivoMap.get(numLinha).get(2)));
                    pertinencia.setParam2(Double.parseDouble(arquivoMap.get(numLinha).get(3)));
                    pertinencia.setParam3(Double.parseDouble(arquivoMap.get(numLinha).get(4)));
                    saida.addPertinencia(pertinencia);
                }
                saidas.add(saida);
            }

            //Regras
            regras = new ArrayList<Regras>();
            while (regras.size() < numRegras) {
                numLinha++;
                Regras regra = new Regras();
                regra.setId(id++);
                regra.setFpEntradas1(entradas.get(0).getPertinencia(arquivoMap.get(numLinha).get(0)));
                regra.setConexao(arquivoMap.get(numLinha).get(1));
                regra.setFpEntradas2(entradas.get(1).getPertinencia(arquivoMap.get(numLinha).get(2)));
                regra.setFpSaidas(saidas.get(0).getPertinencia(arquivoMap.get(numLinha).get(3)));
                regras.add(regra);
            }


            //Atualizar listas

            //Atualizar lista de entradas e saidas
            configFuzzy.listaEntSai.addAll(entradas);
            configFuzzy.listaEntSai.addAll(saidas);
            configFuzzy.lista_EntSai.setListData(configFuzzy.listaEntSai.toArray());

            configFuzzy.lista_regras.setListData(regras.toArray());
            configFuzzy.listaRegrasEnt1.setListData(entradas.get(0).getListaFP().toArray());
            configFuzzy.listaRegrasEnt2.setListData(entradas.get(1).getListaFP().toArray());
            configFuzzy.listaRegrasSaidas.setListData(saidas.get(0).getListaFP().toArray());


            configFuzzy.lista_entradas.setListData(entradas.toArray());
            configFuzzy.lista_saidas.setListData(saidas.toArray());
            configFuzzy.pack();

            System.out.println("ACABOU DE PROCESSAR O ARQUIVO!");
        } catch (FileNotFoundException ex) {
        }

    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public JFrame getJanelaArquivo() {
        return janelaArquivo;
    }

    public void setJanelaArquivo(JFrame janelaArquivo) {
        this.janelaArquivo = janelaArquivo;
    }

    public void inicializarGrafico() {
        plot = GraficoSistema.getInstance(painel_grafico.getWidth(), painel_grafico.getHeight());
        plot.pack();
        painel_grafico.add(plot.getContentPane());
    }

    public boolean getMandani() {
        return this.mandani.isSelected();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton carregarArquivo;
    private javax.swing.JButton conectar;
    private javax.swing.JButton configContFuzzy;
    public javax.swing.JLabel de_label;
    private javax.swing.JButton desconectar;
    public javax.swing.JLabel erro_label;
    private javax.swing.JButton exemploMandani;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToolBar jToolBar1;
    public javax.swing.JToolBar jToolBar2;
    private javax.swing.JRadioButton mandani;
    public javax.swing.JLabel nivelt1_label;
    public javax.swing.JLabel nivelt2_label;
    private javax.swing.JButton otimizarFuzzy;
    private javax.swing.JPanel painel_grafico;
    private javax.swing.JPanel painel_menuFuzzy;
    private javax.swing.JTextField porta;
    private javax.swing.JTextField setPoint;
    public javax.swing.JLabel sp_label;
    private javax.swing.JLabel status;
    private javax.swing.JRadioButton sugeno;
    public javax.swing.JLabel tensao_label;
    // End of variables declaration//GEN-END:variables
}
