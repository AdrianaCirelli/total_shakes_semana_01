package produto;

public enum TipoTamanho {
    P ("Pequeno"), M ("Medio"), G("Grande");

    private final String tamanho;

    //multiplicador
    public final double multiplicador(TipoTamanho tamanho) {
        if(tamanho == TipoTamanho.P) {
            return 1.0;
        } else if (tamanho == TipoTamanho.M) {
            return 1.30;
        } else {
            return 1.50;
        }
    }

    TipoTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {

        return  tamanho;
    }

}
