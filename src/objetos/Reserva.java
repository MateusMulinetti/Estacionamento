package objetos;

import com.sun.source.tree.BreakTree;

public class Reserva {
      public int numero;
      public Carro carro;
      public Vaga vaga;

      public Reserva(int numero, Carro carro, Vaga vaga) {
          this.numero = numero;
          this.carro = carro;
          this.vaga = vaga;
      }

}
