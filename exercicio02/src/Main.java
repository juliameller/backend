public class Main {
    public static void main(String[] args) throws Exception {
        
            JogadorGerador.realizarRequisicoes();
            Jogador jogador = JogadorGerador.gerarJogador();
            System.out.println(jogador.getDescricao());
        
        }
    }

