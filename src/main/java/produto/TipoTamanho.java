package produto;

public enum TipoTamanho {
    P ("Pequeno"), M ("Medio"), G("Grande");

    private final String tamanho;

    //multiplicador
    public final double multiplicador(TipoTamanho tamanho) {
        if(tamanho == TipoTamanho.P) {
            return 1.0;
        } else if (tamanho == TipoTamanho.M) {
            return 2.0;
        } else {
            return 3.0;
        }
    }

    TipoTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {

        return  tamanho;
    }

}
