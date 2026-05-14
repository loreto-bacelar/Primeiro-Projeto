package com.mycompany.jogo_da_forca;

import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {
    private static int controlador = 6;
    private static String aux = new String();
    
    //Este método troca cada char da String por um '*'.
    public static String ocultarPalavra(String palavra){
        String palavraOculta="";
        for (int i = 0; i < palavra.length(); i++){
            palavraOculta+="*";
        }
        return palavraOculta;
    }
    
/*  Este método verifica se o caractere digitado pelo jogador está presente na palavra secreta. 
    O console exibirá para o jogador quantas vezes a letra ocorre na palavra secreta.
    Se acertar, os '*' da String aux serão substituídos pela letra digitada pelo jogador.
*/
    public static String verificaLetra(char c, String palavra){
        int cont = 0;
        //O uso de um StringBuilder se dá pela possibilidade de trocar um caractere da palavra por outro.
        StringBuilder sb = new StringBuilder(aux);
        
        //percorre a string e verifica se o caractere digitado pelo usuário está presente na palavra secreta.
        for (int i = 0; i < palavra.length(); i++){
            if (palavra.charAt(i) == c){
                sb.setCharAt(i, c);
                cont++;
            }
        }
        
        if (cont>0){
            System.out.println("\nA letra " + c + " aparece " + cont + " vez(es) na palavra secreta. ");
        } else{
            System.out.println("\nA palavra secreta nao contem a letra " + c);
            controlador--;
        }
        
    return sb.toString(); //retorna a palavra com as letras reveladas.
    }
    
    public static void main(String[] args) {
        //String que vai receber a palavra escolhida dentro do vetor de palavras.
        String palavra = new String();

        //Cria um vetor com os animais da jogo da forca
        String[] palavras = {"CAVALO", "PORCO", "CACHORRO", "GATO", "GALINHA", "ELEFANTE", "LEBRE", "COELHO", "PAPAGAIO", "PINTO", "VACA", "BOI","SAPO", "GORILA", "COBRA"};
        
        //Leitor de dados via teclado.
        Scanner input = new Scanner(System.in);
        
        //Objeto rand serve para aleatorizar a escolha de palavras do vetor de palavras.
        Random rand = new Random();
        
        //variável 'c' irá armazenar os palpites do jogador.
        char c;
        
        //A variavel i recebera o indice da palavra que sera escolhida ao acaso dentro do vetor de palavras.
        int i = rand.nextInt(palavras.length);
        
        // a String palavra ira receber a palavra esolhida ao acaso da lista de palavras.
        palavra = palavras[i];
        
        //cada caractere da palavra escolhida no vetor sera trocado por um asterisco.
        aux = ocultarPalavra(palavra);
        
        System.out.println("Este e o jogo da forca de tematica animal. Voce tem 6 tentativas para acertar a palavra secreta.\nCaso voce acerte uma letra, voce nao perde chances. Caso erre 6 vezes, o jogo acaba. ");
        
        System.out.println("\nSua palavra tem "+palavra.length()+" letras: "+aux);
        
        //Verifica se o jogador ainda tem chances restantes para dar palpites.
        while (controlador>0){
            System.out.print("\nChute uma letra (maiuscula): ");
            c = input.next().charAt(0);
            
            //este laço serve para validar a resposta do jogador (precisa ser um caracetere maiúsculo).
            while (!(c>=65 && c<=90)){
                System.out.print("\nVoce nao digitou um caractere valido! Tente novamente: ");
                c = input.next().charAt(0);
            }
        
            //As letras da palavra secreta vão sendo reveladas a cada acerto do jogador, substituindo os '*' pelos caracteres corretos digitados no console.
            aux = verificaLetra(c, palavra);
            
            //Se o jogador acertar a palavra, o laço while é interrompido e é exibida a mensagem de vitória.
            if (aux.equalsIgnoreCase(palavra)){
                System.out.println("\n\nParabens! Voce venceu! A palavra secreta era " +palavra+ "!");
                break;
            }
        
            System.out.println(aux);
            System.out.println("Erros restantes: "+controlador);
        }      
        
        // Este trecho do código será executado caso o jogador erre 6 vezes, perdendo o jogo.
        if (controlador == 0){
            System.out.println("\n\nVoce nao conseguiu adivinhar a palavra! A resposta certa era: " +palavra+ ".");
        }
 
    }           
}
