package objetos;

public class Vaga {

    public int numero;
    public String tamanho;
    public String disponivel;




    public Vaga(int numero, String tamanho, String disponivel) {
        this.numero = numero;
        this.tamanho = tamanho;
        this.disponivel = disponivel;
    }


    @Override
    public String toString() {
        return " A vaga [ numero " + numero + ", tamanho " + tamanho + " está " + disponivel + " ] ";
    }

}
