/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmogenetico;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import ControladorFuzzyLulu.*;
import Interfaces.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Genetico {

    int tamanhoPopulacao;
    public Vector populacao;
    public Entrada entrada;
    public Saida saida;
    public Regras regras;
    public FuncaoPertinencia fp;
    public ControladorFuzzy controlador;
    private Principal principal;

    public Genetico(int tamanhoPopulacao) {
        populacao = new Vector();
        this.tamanhoPopulacao = tamanhoPopulacao;

    }

    public Vector criarPopulacao() { //LEMBRAR QUE DEPOIS Q FOR FAZER PRO FUZZY, ORDENAR OS ELEMENTOS DE CADA INDIVIDUO
        //erros de -30 a 30
        //derivada do erro de -5 a 5(AXO QUE É -2 A 2 NÃO? TA NO RELATORIO)         //UTILIZAR ESSES VALORES QUANDO FOR FAZER PRO GENETICO DO FUZZY
        //-0.1 a 0.1
        for (int i = 0; i < tamanhoPopulacao; i++) {
            Individuo individuo = new Individuo();
            for (int z = 0; z < 11; z++) { //esse lop adicionará os 9 elementos do vetor de erros do primeiro individuo
                individuo.genesErro.add((-30) + (30 - (-30)) * Math.random());
                //a quantidade de genes será definido aqui com a quantidade de Math.random(LEMBRAR QUE TEM QUE SER NUMERO PAR PQ SENÃO VAI DA PAW NO MEU PROGRAMA)
                Collections.sort(individuo.genesErro); //ordenando o vetor!
            }

            for (int j = 0; j < 11; j++) { //esse lop adicionará os 9 elementos do vetor de DERIVADAS DO ERRO do primeiro individuo
                individuo.genesDerivadaErro.add((-2) + (5 - (-2)) * Math.random());
                //a quantidade de genes será definido aqui com a quantidade de Math.random(LEMBRAR QUE TEM QUE SER NUMERO PAR PQ SENÃO VAI DA PAW NO MEU PROGRAMA)
                Collections.sort(individuo.genesDerivadaErro);
            }

            for (int w = 0; w < 7; w++) { //esse lop adicionará os 9 elementos do vetor de TENSOES do primeiro individuo
                individuo.genesTensao.add((-0.1) + (0.1 - (-0.1)) * Math.random());
                //a quantidade de genes será definido aqui com a quantidade de Math.random(LEMBRAR QUE TEM QUE SER NUMERO PAR PQ SENÃO VAI DA PAW NO MEU PROGRAMA)
                Collections.sort(individuo.genesTensao);
            }



            populacao.add(individuo); // adicionando um Individuo da classe Individuo

        }
        return populacao; // vetor de Individuos
    }

    public double funcaoAvaliacao(Individuo individuo) {
        //AQUI DEPENDE DE COMO TA O PROGRAMA DE LULU,VO PEGAR UM INDIVIDUO, E TESTAR NA PLANTA, E IR PEGANDO OS VALORES DOS ERROS E DERIVADA DO ERRO PRA TESTAR NA FUNCAO DE AVALIACAO

        Object nomeE = "ERRO";
        Object nomeDE = "DERRO";
        Object nomeTENSAO = "TENSAO";
        //Entrada principal.entradas.get(0) = (Entrada) nomeE;
        //Entrada principal.entrada.get(1) = (Entrada) nomeDE;
        //Saida principal.saidas.get(0) = (Saida) nomeTENSAO;

        


        //SO FAÇO ORDENAR ANTES DE JOGAR NO DE LUIZ
        Collections.sort(individuo.genesErro);
        Collections.sort(individuo.genesDerivadaErro);
        Collections.sort(individuo.genesTensao);

        principal.entradas.get(0).getListaFP().get(0).setParam1(-31);
        principal.entradas.get(0).getListaFP().get(0).setParam2(-30);
        principal.entradas.get(0).getListaFP().get(1).setParam1((Double) individuo.genesErro.get(0));
        principal.entradas.get(0).getListaFP().get(1).setParam2((Double) individuo.genesErro.get(1));
        principal.entradas.get(0).getListaFP().get(0).setParam3((Double) individuo.genesErro.get(2));
        principal.entradas.get(0).getListaFP().get(2).setParam1((Double) individuo.genesErro.get(3));
        principal.entradas.get(0).getListaFP().get(1).setParam3((Double) individuo.genesErro.get(4));
        principal.entradas.get(0).getListaFP().get(2).setParam2((Double) individuo.genesErro.get(5));
        principal.entradas.get(0).getListaFP().get(3).setParam1((Double) individuo.genesErro.get(6));
        principal.entradas.get(0).getListaFP().get(2).setParam3((Double) individuo.genesErro.get(7));
        principal.entradas.get(0).getListaFP().get(4).setParam1((Double) individuo.genesErro.get(8));
        principal.entradas.get(0).getListaFP().get(3).setParam2((Double) individuo.genesErro.get(9));
        principal.entradas.get(0).getListaFP().get(3).setParam3((Double) individuo.genesErro.get(10));
        principal.entradas.get(0).getListaFP().get(4).setParam2(30);
        principal.entradas.get(0).getListaFP().get(4).setParam3(31);


        principal.entradas.get(1).getListaFP().get(0).setParam1(-3);//TIRAR DUVIDA SOBRE ISSO
        principal.entradas.get(1).getListaFP().get(0).setParam2(-2);
        principal.entradas.get(1).getListaFP().get(1).setParam1((Double) individuo.genesDerivadaErro.get(0));
        principal.entradas.get(1).getListaFP().get(1).setParam2((Double) individuo.genesDerivadaErro.get(1));
        principal.entradas.get(1).getListaFP().get(0).setParam3((Double) individuo.genesDerivadaErro.get(2));
        principal.entradas.get(1).getListaFP().get(2).setParam1((Double) individuo.genesDerivadaErro.get(3));
        principal.entradas.get(1).getListaFP().get(1).setParam3((Double) individuo.genesDerivadaErro.get(4));
        principal.entradas.get(1).getListaFP().get(2).setParam2((Double) individuo.genesDerivadaErro.get(5));
        principal.entradas.get(1).getListaFP().get(3).setParam1((Double) individuo.genesDerivadaErro.get(6));
        principal.entradas.get(1).getListaFP().get(2).setParam3((Double) individuo.genesDerivadaErro.get(7));
        principal.entradas.get(1).getListaFP().get(4).setParam1((Double) individuo.genesDerivadaErro.get(8));
        principal.entradas.get(1).getListaFP().get(3).setParam2((Double) individuo.genesDerivadaErro.get(9));
        principal.entradas.get(1).getListaFP().get(3).setParam3((Double) individuo.genesDerivadaErro.get(10));
        principal.entradas.get(1).getListaFP().get(4).setParam2(2);
        principal.entradas.get(1).getListaFP().get(4).setParam3(3); //TIRAR DUVIDA SOBRE ISSO


        //TIRAR DUVIDA SOBRE AS TENSÔES, PQ É DIFERENTE!
        principal.saidas.get(0).getListaFP().get(0).setParam1((Double) individuo.genesTensao.get(0) - 0.05);
        principal.saidas.get(0).getListaFP().get(0).setParam2((Double) individuo.genesTensao.get(0));
        principal.saidas.get(0).getListaFP().get(0).setParam3((Double) individuo.genesTensao.get(0) + 0.05);

        principal.saidas.get(0).getListaFP().get(1).setParam1((Double) individuo.genesTensao.get(1) - 0.05);
        principal.saidas.get(0).getListaFP().get(1).setParam2((Double) individuo.genesTensao.get(1));
        principal.saidas.get(0).getListaFP().get(1).setParam3((Double) individuo.genesTensao.get(1) + 0.05);

        principal.saidas.get(0).getListaFP().get(2).setParam1((Double) individuo.genesTensao.get(2) - 0.05);
        principal.saidas.get(0).getListaFP().get(2).setParam2((Double) individuo.genesTensao.get(2));
        principal.saidas.get(0).getListaFP().get(2).setParam3((Double) individuo.genesTensao.get(2) + 0.05);

        principal.saidas.get(0).getListaFP().get(3).setParam1((Double) individuo.genesTensao.get(3) - 0.05);
        principal.saidas.get(0).getListaFP().get(3).setParam2((Double) individuo.genesTensao.get(3));
        principal.saidas.get(0).getListaFP().get(3).setParam3((Double) individuo.genesTensao.get(3) + 0.05);

        principal.saidas.get(0).getListaFP().get(4).setParam1((Double) individuo.genesTensao.get(4) - 0.05);
        principal.saidas.get(0).getListaFP().get(4).setParam2((Double) individuo.genesTensao.get(4));
        principal.saidas.get(0).getListaFP().get(4).setParam3((Double) individuo.genesTensao.get(4) + 0.05);

        principal.saidas.get(0).getListaFP().get(5).setParam1((Double) individuo.genesTensao.get(5) - 0.05);
        principal.saidas.get(0).getListaFP().get(5).setParam2((Double) individuo.genesTensao.get(5));
        principal.saidas.get(0).getListaFP().get(5).setParam3((Double) individuo.genesTensao.get(5) + 0.05);

        principal.saidas.get(0).getListaFP().get(6).setParam1((Double) individuo.genesTensao.get(6) - 0.05);
        principal.saidas.get(0).getListaFP().get(6).setParam2((Double) individuo.genesTensao.get(6));
        principal.saidas.get(0).getListaFP().get(6).setParam3((Double) individuo.genesTensao.get(6) + 0.05);

        controlador.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Genetico.class.getName()).log(Level.SEVERE, null, ex);
        }
        controlador.getDerivErroMedio();
        controlador.getErroMedio();

        double erroMedio = 0, numeroAmostras = 0, derivadaErroMedio = 0;
        double resultado = 0.83 * (Math.pow(erroMedio, 2) / numeroAmostras) + 0.17 * (Math.pow(derivadaErroMedio, 2) / numeroAmostras);

        return resultado;

    }

    public void avaliacaoIndividuos(Vector populacao) { //SETA OS VALORES DE ADAPTABILIDADE E AVALIACAO!
        double somatorioAdaptabilidades = 0;

        for (int i = 0; i < populacao.size(); i++) {

            ((Individuo) populacao.get(i)).setAvaliacao(funcaoAvaliacao((Individuo) populacao.get(i)));//CHAMO A FUNCAO AVALIACAO PRA O PRIMEIRO INDIVIDUO, E DEPOIS JA SETO A AVALIACAO DELE
            ((Individuo) populacao.get(i)).setAdaptabilidade(1 / ((Individuo) populacao.get(i)).getAvaliacao());  //adatpabilidade é o inverso da avaliacao

            somatorioAdaptabilidades = somatorioAdaptabilidades + ((Individuo) populacao.get(i)).getAdaptabilidade();
        }

        for (int i = 0; i < populacao.size(); i++) {

            ((Individuo) populacao.get(i)).setAdaptabilidadeRelativa(((Individuo) populacao.get(i)).getAdaptabilidade() / somatorioAdaptabilidades);
        }
    }

    public Individuo roleta() {

        Collections.sort(populacao, new ComparadorDeIndividuos()); //ordena o vetor populacao de acordo com as aptidoes relativas(em ordem crescente)
        Collections.reverse(populacao); //ja que meu algoritmo trabalhara de forma decrescente, invertendo aqui a ordem!

        int i;
        double aux = 0;
        double limite = Math.random(); //roleta girará aqui, no random, de 0 a 1 que é o máximo(soma das adaptabilidades relativas)

        for (i = 0; (i < populacao.size()) && (aux < limite); i++) {
            aux = aux + ((Individuo) populacao.get(i)).getAdaptabilidadeRelativa();
        }
        // System.out.println(limite);
        i--;
        return (Individuo) populacao.get(i);
    }

    //essa taxa de mutacao eh ideal ser 0.13
    public Individuo mutacao(Individuo individuo, double taxaMutacao) { //pro primeiro exemplo vo ter tamanho 2 (x,y)
        //aqui eu faço mutacoes individualmente pra cada vetor do individuo!
        int randomErro = (int) (Math.random() * 11);
        individuo.genesErro.set(randomErro, (Double) individuo.genesErro.get(randomErro) + taxaMutacao);

        int randomDerivadaErro = (int) (Math.random() * 11);
        individuo.genesDerivadaErro.set(randomDerivadaErro, (Double) individuo.genesDerivadaErro.get(randomDerivadaErro) + taxaMutacao);

        int randomTensao = (int) (Math.random() * 7);
        individuo.genesTensao.set(randomTensao, (Double) individuo.genesTensao.get(randomTensao) + taxaMutacao);


        return individuo;
    }

    //meu crossover vai dividir os pais no meio, QUEM SABE, colocar parametro de escolha desse corte!
    //LEMBRANDO, A CADA 2 PAIS, SÃO GERADOS 2 FILHOS!
    public Vector crossover(Individuo pai1, Individuo pai2) {
        int taxaCrossover = pai1.genesErro.size() / 2; //dividir na metade!
        Vector novosFilhos = new Vector();
        Individuo filho1 = new Individuo();
        Individuo filho2 = new Individuo();
        //AQUI OS VETORES FILHOS VÃO COPIAR OS PAIS, E POSTERIORMENTE, SO SERÃO MUDADOS A PARTE DA FRENTE DO CROMOSSOMO!
        filho1.genesErro.addAll(pai1.genesErro);
        filho2.genesErro.addAll(pai2.genesErro);

        for (int i = 0; i < taxaCrossover; i++) {
            filho1.genesErro.set(i, (Double) pai2.genesErro.get(i));
            filho2.genesErro.set(i, (Double) pai1.genesErro.get(i));
        }
//---------------------------------------mesmo processo agora para o vetor genesDerivadaERRO------------------------
        int taxaCrossover2 = pai1.genesDerivadaErro.size() / 2; //dividir na metade!

        //AQUI OS VETORES FILHOS VÃO COPIAR OS PAIS, E POSTERIORMENTE, SO SERÃO MUDADOS A PARTE DA FRENTE DO CROMOSSOMO!
        filho1.genesDerivadaErro.addAll(pai1.genesDerivadaErro);
        filho2.genesDerivadaErro.addAll(pai2.genesDerivadaErro);

        for (int i = 0; i < taxaCrossover2; i++) {
            filho1.genesDerivadaErro.set(i, (Double) pai2.genesDerivadaErro.get(i));
            filho2.genesDerivadaErro.set(i, (Double) pai1.genesDerivadaErro.get(i));
        }

//-----------------------------------MESMO PROCESSO PARA O VETOR TENSÔES-----------------------------
        int taxaCrossover3 = pai1.genesTensao.size() / 2; //dividir na metade!

        //AQUI OS VETORES FILHOS VÃO COPIAR OS PAIS, E POSTERIORMENTE, SO SERÃO MUDADOS A PARTE DA FRENTE DO CROMOSSOMO!
        filho1.genesTensao.addAll(pai1.genesTensao);
        filho2.genesTensao.addAll(pai2.genesTensao);

        for (int i = 0; i < taxaCrossover3; i++) {
            filho1.genesTensao.set(i, (Double) pai2.genesTensao.get(i));
            filho2.genesTensao.set(i, (Double) pai1.genesTensao.get(i));
        }


        //ADICIONANDO EM UM VETOR, OS NOVOS FILHOS, Q SERÃO ADICIONADOS NA NOVA POPULAÇÃO!
        novosFilhos.add(filho1);
        novosFilhos.add(filho2);

        return novosFilhos;
    }

    public Vector crossoverComMutacao(Individuo pai1, Individuo pai2) {
        int taxaCrossover = pai1.genesErro.size() / 2; //dividir na metade!
        Vector novosFilhos = new Vector();
        Individuo filho1 = new Individuo();
        Individuo filho2 = new Individuo();

        for (int i = 0; i < pai1.genesErro.size(); i++) {
            filho1.genesErro.add(pai1.genesErro.get(i));
            filho2.genesErro.add(pai2.genesErro.get(i));

        }

        for (int i = 0; i < taxaCrossover; i++) {
            filho1.genesErro.set(i, (Double) pai2.genesErro.get(i));
            filho2.genesErro.set(i, (Double) pai1.genesErro.get(i));
        }

//------------------------------------------------------CROSSOVER PARA OS GENESDERIVADAERRO--------------------------
        int taxaCrossover2 = pai1.genesDerivadaErro.size() / 2; //dividir na metade!


        for (int i = 0; i < pai1.genesDerivadaErro.size(); i++) {
            filho1.genesDerivadaErro.add(pai1.genesDerivadaErro.get(i));
            filho2.genesDerivadaErro.add(pai2.genesDerivadaErro.get(i));

        }

        for (int i = 0; i < taxaCrossover2; i++) {
            filho1.genesDerivadaErro.set(i, (Double) pai2.genesDerivadaErro.get(i));
            filho2.genesDerivadaErro.set(i, (Double) pai1.genesDerivadaErro.get(i));
        }
//------------------------------------------------TENSOES------------------------------------------------
        int taxaCrossover3 = pai1.genesTensao.size() / 2; //dividir na metade!


        for (int i = 0; i < pai1.genesTensao.size(); i++) {
            filho1.genesTensao.add(pai1.genesTensao.get(i));
            filho2.genesTensao.add(pai2.genesTensao.get(i));

        }

        for (int i = 0; i < taxaCrossover3; i++) {
            filho1.genesTensao.set(i, (Double) pai2.genesTensao.get(i));
            filho2.genesTensao.set(i, (Double) pai1.genesTensao.get(i));
        }

        //ADICIONANDO EM UM VETOR, OS NOVOS FILHOS, Q SERÃO ADICIONADOS NA NOVA POPULAÇÃO! JA COM MUTACAO!
        novosFilhos.add(mutacao(filho1, 0.13));
        novosFilhos.add(mutacao(filho2, 0.13));
        //    novosFilhos.add(mutacao(filho1, 2, 0.13));
        //    novosFilhos.add(mutacao(filho1, 2, 0.13));

        return novosFilhos;
    }

    public Individuo algoritmoGenetico(int numeroGeracoes) {
        int iterador = 0;
        criarPopulacao(); //50 individuos!
        Vector novaPopulacao = new Vector();
        avaliacaoIndividuos(populacao);

        while (iterador < numeroGeracoes) {

            for (int j = 0; j < 40; j++) { //ISSO SO VAI DA CERTO SE A POPULACAO FOR DE 100 INDIVIDUOS

                novaPopulacao.addAll(crossover(roleta(), roleta())); //o valor de filhos criados aqui, vai ser o valor ali em cima x 2
            }

            //foram adicionados 80 individuos por crossover, 18 por crossover com mutacao, e 2 por roleta direta!

            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.addAll(crossoverComMutacao(roleta(), roleta()));
            novaPopulacao.add(roleta());
            novaPopulacao.add(roleta());

            // populacao.removeAllElements();
            // populacao.addAll(novaPopulacao); //apaguei a populacao antiga, e setei para a nova!
            populacao = (Vector) novaPopulacao.clone();
            novaPopulacao.removeAllElements(); //apaguei toda a NovaPopulacao para começar tudo de novo
    /*        System.out.println("SEGUNDA GERACAO");
            System.out.println(((Individuo)populacao.get(0)).genes.get(0)+" "+((Individuo)populacao.get(0)).genes.get(1));
            System.out.println(((Individuo)populacao.get(1)).genes.get(0)+" "+((Individuo)populacao.get(1)).genes.get(1));
            System.out.println(((Individuo)populacao.get(2)).genes.get(0)+" "+((Individuo)populacao.get(2)).genes.get(1));
            System.out.println(((Individuo)populacao.get(3)).genes.get(0)+" "+((Individuo)populacao.get(3)).genes.get(1));
            System.out.println(((Individuo)populacao.get(4)).genes.get(0)+" "+((Individuo)populacao.get(4)).genes.get(1));
             */
            avaliacaoIndividuos(populacao); //FAZ NOVAMENTE A AVALIACAO!!!!

            for (int j = 0; j < populacao.size(); j++) {
                double avaliacao = ((Individuo) populacao.get(j)).getAvaliacao();
                if (avaliacao < 0.5) {
                    System.out.println("ATINGI O LIMIAR MINIMO EXIGIDO");
                    System.out.println((Individuo) populacao.get(j));
                    return ((Individuo) populacao.get(j));
                }
            }

            iterador++;
        }
        Collections.sort(populacao, new ComparadorDeIndividuosAvaliacao()); //ordena o vetor populacao de acordo com as aptidoes relativas(em ordem crescente)
        System.out.println((Individuo) populacao.get(0));
        return (Individuo) populacao.get(0);
    }
}
