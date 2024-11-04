import objetos.Carro;
import objetos.Reserva;
import objetos.Vaga;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public  static List<Vaga> vagas = new ArrayList<Vaga>();
    public  static List<Carro> carros = new ArrayList<Carro>();
    public static List<Reserva> reservas = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }

    static void menu(){
        int opcao=0;
        while(opcao!=5){
            System.out.println("Digite a opção que deseja: \n" +
                    " [1 Cadrastrar vaga ] \n" +
                    " [2 Reservar carro ] \n" +
                    " [3 Registrar carro na vaga] \n" +
                    " [4 Lista vagas Disponiveis] \n" +
                    " [5 Lista carros não estacionados ] \n" +
                    " [6 Historico de carros estacionados] \n" +
                    " [7 Lista carros estacionados no momento] \n" +
                    " [8 Check-out] \n" +
                    " [9 Sair] \n"  );
            opcao=scanner.nextInt();
            switch (opcao){
                case 1: cadrastroVaga();
                    break;
                case 2:cadrastarCarro();
                    break;
                case 3: registoEntrada();
                    break;
                case 4:  listarVagas(); menu();
                    break;
                case 5: listarCarros(); menu();
                    break;
                case 6:  carrosEstacionadosHistorico(); menu();
                    break;
                    case 7: listaOcupadoMomento(); menu();
                    break;
                case 8: checkout();
                break;
                case 9: System.out.println("Até mais!!");
                    System.exit(0);
                default:System.out.println("Opção inválida. Por favor, escolha uma opção válida.  \n " );
                    break;
            }
        }




    }

    static void cadrastroVaga(){
        String tamanhoVaga = "";
        System.out.println("Cadastro de Vaga");
        System.out.println("Digite o numero da vaga: ");
        int numeroVaga = scanner.nextInt();
        System.out.println("Selecione o tamanho da vaga [ 1 - Pequena, 2 - Média, 3 Grande ] ");
        int opcao0 = scanner.nextInt();
        switch (opcao0) {
            case 1:
                tamanhoVaga  = "Pequena";
                break;
            case 2:
                tamanhoVaga  = "Média";
                break;
            case 3:
                tamanhoVaga  = "Grande";
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida (1, 2, ou 3). \n");
                return;
        }
        String disponibilidade = " Disponivel ";

        Vaga vaga = new Vaga(numeroVaga, tamanhoVaga, disponibilidade);
        vagas.add(vaga);

        System.out.println("Vaga cadastrado com sucesso! \n");


    }

    static void cadrastarCarro(){
        String tamanhoCarro = "";
        System.out.println("Cadastrando carro");
        System.out.println("Digite a placa do carro: ");
        String placa = scanner.next();
        System.out.println("Digite o modelo do carro: ");
        String modelo = scanner.next();
        System.out.println("Selecione o tamanho do carro [ 1 - Pequeno, 2 - Médio, 3 Grande ] ");
        int opcaoC = scanner.nextInt();
        switch (opcaoC) {
            case 1:
                tamanhoCarro  = "Pequena";
                break;
            case 2:
                tamanhoCarro  = "Média";
                break;
            case 3:
                tamanhoCarro  = "Grande";
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida (1, 2, ou 3). \n");
                return;
        }
        System.out.println(" Digite a hora de entrada do carro: ");
        int horaEntrada = scanner.nextInt();
        System.out.println("Digite o dia de saida do carro: ");
        int horaSaida = scanner.nextInt();

        String estado = " Disponivel ";
        System.out.println("Carro cadastrado com sucesso! \n");
        Carro carro = new Carro(placa, modelo, tamanhoCarro, horaEntrada, horaSaida, estado);
        carros.add(carro);

    }

    static void listarVagas(){
        System.out.println("---- Vagas disponiveis ---- \n");
        for(Vaga v : vagas ){
            if(Objects.equals(v.disponivel, " Disponivel ")){
                System.out.println(v);
            }
        }
        System.out.println("\n--------------------------");
    }

    static void listarCarros(){
        System.out.println("---- Carros disponiveis ---- \n");
        for(Carro c : carros ){
            if(Objects.equals(c.estado, " Disponivel ")){
                System.out.println(c);
            }
        }
        System.out.println("\n--------------------------");
    }

    static void registoEntrada() {
        Carro carroSelecionado = null;
        Vaga vagaSelecionada = null;
        int numero =0;

        boolean selecionandoCarro = false;
        while (!selecionandoCarro) {
            System.out.println(" Selecione o veiculo que deseja atraves da placa: \n");
            listarCarros();
            String carroSele = scanner.next();
            for (Carro c : carros) {
                if (c.placa.equals(carroSele)) {
                    carroSelecionado = c;
                    c.estado = " Indisponivel ";
                    selecionandoCarro = true;
                }
            }
            if (carroSelecionado == null) {
                System.out.println(" Não foi encotrado nenhum carro com essa placa tente novamente \n");
                return;
            }
        }

        boolean selecionandoVaga = false;
        while (!selecionandoVaga){
            System.out.println(" Selecione a vaga que deseja atraves do numero: ");
            listarVagas();

            int vagaSele = scanner.nextInt();
            for (Vaga v : vagas) {
                if (v.numero == vagaSele && Objects.equals(v.tamanho, carroSelecionado.tamanho)) {
                    vagaSelecionada = v;
                    v.disponivel = " Indisponivel ";
                    selecionandoVaga = true;
                }
            }
            if ( vagaSelecionada == null) {
                System.out.println("\nNão foi encotrado nenhuma vaga com esse numero tente novamente  ou o tamanho não é adequado \n");
            }
        }

        Reserva reserva = new Reserva(numero,carroSelecionado,vagaSelecionada);
       reservas.add(reserva);

        System.out.println(" !Carro cadastrado com sucesso! \n");

  }


    static void carrosEstacionadosHistorico() {
        System.out.println("---- Carros estacionados ---- \n");

        for (Reserva r : reservas) {
            float horasEstacionados = 0;
            float valorPago = 0;

            horasEstacionados = r.carro.horaSaida - r.carro.horaEntrada;
            if (horasEstacionados <= 1) {
                valorPago = +5;
            } else if (horasEstacionados <= 3) {
                valorPago = +10;
            } else {
                valorPago = +15;
            }

            System.out.println(" Recebeu o veiculo com a placa: " + r.carro.placa + " entrou as  " + r.carro.horaEntrada + " e saiu as : " + r.carro.horaSaida + " e pagou " + valorPago +"\n");
        }
        System.out.println("\n---------------------------");

    }

    static void checkout(){
        float valorPagar = 0;
        int horasEstacionado = 0;
        System.out.println(" Selecione qual vaga quer pagar \n");

        System.out.println("---- Carros estacionados ---- \n");
       for(Reserva r : reservas){
           if(Objects.equals(r.vaga.disponivel, " Indisponivel ")){
               System.out.println(" Vaga numero:  " + r.vaga.numero + " Com carro do tamanho: " + r.carro.tamanho + " e placa : " + r.carro.placa + " \n");
           }
       }
        System.out.println("\n-------------------------- \n");
        int vagaSele = scanner.nextInt();

        for (Reserva r : reservas) {
            if (vagaSele == r.vaga.numero) {
                horasEstacionado = r.carro.horaSaida - r.carro.horaEntrada;
                if (horasEstacionado <= 1) {
                    valorPagar = +5;
                } else if (horasEstacionado <= 3) {
                    valorPagar = +10;
                } else {
                    valorPagar = +15;
                }
            }
        }if (valorPagar == 0) {
                System.out.println(" Nehuma vaga selecionada ou vaga incorreta! \n");
                return;
            }
        for (Reserva r : reservas) {
            System.out.println(" Você selecionou a vaga " + vagaSele + " com o carro da placa " + r.carro.placa + " permaneceu por " + horasEstacionado + " horas e irá pagar " + valorPagar + " \n");
            System.out.println(" Selecione [ 1 - para pagar, 2 - sair ] ");
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                System.out.println(" !Pagamento concluido volte sempre! ");
                for (Vaga v : vagas) {
                    if (vagaSele == v.numero) {
                        v.disponivel = " Disponivel ";
                    }

                }
                menu();
            } else {
                menu();
            }
        }

    }

    static void listaOcupadoMomento(){
        System.out.println("--- Carros estacionados --- \n");
        for(Reserva r : reservas){
            if(Objects.equals(r.vaga.disponivel, " Indisponivel ")){
                System.out.println(" Vaga numero:  " + r.vaga.numero + " Com carro do tamanho: " + r.carro.tamanho + " e placa : " + r.carro.placa);
            }
        }
        System.out.println("\n------------------------ \n");
    }


}

