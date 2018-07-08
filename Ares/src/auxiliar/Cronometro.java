package auxiliar;

public class Cronometro {
    private long inicioLogin, totalLogado, duracaoUltimoIntervalo;
    private long inicioIntervalo;

    public Cronometro() {
        inicioLogin = System.currentTimeMillis();
    }
    
    
    public long tempoLogado() {
        long tempoAtual = System.currentTimeMillis();
        atualizarTempoLogado();
        
        return totalLogado;
    }
    
    public  void iniciarIntervalo() {
        inicioIntervalo = System.currentTimeMillis();
    }
    
    public void finalizarIntervalo() {
        long tempoAtual = System.currentTimeMillis();
        duracaoUltimoIntervalo = tempoAtual - inicioIntervalo;
        atualizarTempoLogado();
        totalLogado = totalLogado - duracaoUltimoIntervalo;
    }
    
    private void atualizarTempoLogado() {
        long tempoAtual = System.currentTimeMillis();
        totalLogado = totalLogado + ((tempoAtual - inicioLogin)/1000);
    }
}
