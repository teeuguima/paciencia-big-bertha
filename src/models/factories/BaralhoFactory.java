package models.factories;

import java.util.ArrayList;
import models.Baralho;
import models.Carta;

public class BaralhoFactory {
  private final String[] naipes = {"copas", "espadas", "ouros", "paus"};
  private final String[] simbolos = {"♥", "♠", "♦", "♣"};
  private final String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
  private final int[] pesos = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
  private int quantidadeDeBaralhos = 2;
  private Baralho baralho;
  
  public BaralhoFactory(){}
  
  /**
   * Gerar baralho x quantidade de baralhos (Default = 1)
   * @param quantidadeDeBaralhos
   */
  public BaralhoFactory(int quantidadeDeBaralhos) {
    this.quantidadeDeBaralhos = quantidadeDeBaralhos;
  }
  
  
  /** Gera uma instância de baralho
   * @param embaralhado true se você quer um baralho já embaralhado
   * @return Baralho
   */
  public Baralho gerarBaralho(boolean embaralhado){
    ArrayList<Carta> cartas = new ArrayList<Carta>();

    for(int i = 0; i < quantidadeDeBaralhos; i++){
        for(int j = 0; j < naipes.length; j++){
          String naipe = naipes[j];
          String simbolo = simbolos[j];
        

          String cor = "preto";
          String ansiCor = "\u001B[37m";

          if(naipe.equals("copas") || naipe.equals("ouros")){
            cor = "vermelho";
            ansiCor = "\u001B[31m";
           }

          String ansiReset = "\u001B[0m";

          for(int k = 0; k < valores.length; k++){
            String valor = valores[k];
            int peso = pesos[k];
            
            String[] ansiTerminalColor = {ansiCor , ansiReset};

            cartas.add(new Carta(naipe, valor, simbolo, cor, ansiTerminalColor,peso));

          }
        }
    }

    
    this.baralho = new Baralho(cartas);
    
    if(embaralhado){
      baralho.embaralhar();
    }

    return baralho;
  }
}
