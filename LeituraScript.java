/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.leiturascript;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author srdes
 */
public class LeituraScript {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\srdes\\Downloads\\hello.txt"); // caso queira testar outro arquivo professor,
                                                                        // apenas cole o caminho até ele aqui
        Scanner leitura = null; // criação do scanner para leitura

        // utilizei do bloco try para lançar uma exceção na leitura do arquivo
        try {
            int contagem = 0;
            leitura = new Scanner(file);
            Map<String, Integer> contagemPalavra = new HashMap<>();// Cria um mapa para armazenar a contagem de palavras
            String ProcurarPalavra = "futuro";
            int primeiraPosicao = -1;
            int contagemPalavraProcurada = 0;
            // ESSE WHILE FICOU RESPONSAVEL POR REALIZAR A REPETIÇÃO DA LEITURA LINHA POR
            // LINHA
            while (leitura.hasNextLine()) {

                String line = leitura.nextLine();
                System.out.println(line);

                String[] palavras = line.split("[\\s.,;!?]+"); // Divide a linha em palavras usando espaços em branco
                                                               // como delimitadores
                int posicao = 0;

                for (String palavra : palavras) {
                    palavra = palavra.toLowerCase().trim();// fiz a convercao da palavra que eu quero encontrar para
                                                           // minusculo para não dar erro caso ela seja maiuscula
                    if (palavra.equals(ProcurarPalavra)) {
                        contagem++;
                        if (primeiraPosicao == -1) {
                            primeiraPosicao = line.indexOf(palavra, posicao);// utlizei para encontrar a primeira
                                                                             // aparição da palavra desejada
                        }
                    }

                    posicao += palavra.length() + 1;
                }

            }

            if (contagemPalavra.containsKey(ProcurarPalavra)) {
                contagemPalavraProcurada = contagemPalavra.get(ProcurarPalavra);
            }
            System.out.println("\n Palavra procurada: " + ProcurarPalavra);
            System.out.println("\n Quantidade de Vezes: " + contagem);
            System.out.println("\n posição inicial: " + primeiraPosicao);

        }

        // PARA LIDAR COM A EXCEÇÃO CASO TENHA ALGUM ERRO NA HORA DE TENTAR LER O
        // ARQUIVO
        catch (IOException Excecao) { // utilizei o ioExceptions pois ele serve para a maioria dos tipos de excecao
            System.out.println(Excecao.getMessage());
        }
        // NESSE BLOCO O FINALLY TEM A FUNCAO DE GARANTIR QUE A LEITURA SEJA FINALIZA
        // COM SUCESSO
        finally {
            if (leitura != null) {
                leitura.close();
            }

        }

    }
}
