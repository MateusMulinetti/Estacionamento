package objetos;

public class Carro {
    public String placa;
    public String modelo;
    public String tamanho;
    public int horaEntrada;
    public int horaSaida;
    public String estado;

    public Carro() {

    }

    public Carro(String placa, String modelo, String tamanho, int horaEntrada, int horaSaida,  String estado) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.estado =  " Disponivel ";

    }

    @Override
    public String toString() {
        return " Carro da placa " + placa + " modelo " + modelo + " do tamanho " + tamanho + " entrou no estacionamanto as " + horaEntrada + " e irá sair as " + horaSaida;
    }
}
