package produto;

public enum TipoTamanho {
    P ("Pequeno"), M ("Medio"), G("Grande");

    private String tamanho;

    TipoTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTamanho() {
        return  tamanho;
    }

}
