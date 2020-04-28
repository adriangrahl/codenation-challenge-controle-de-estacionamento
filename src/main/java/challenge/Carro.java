package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
    	
    	validaCampoObrigatorio(placa);
    	validaCampoObrigatorio(cor);
    	
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }
    
    private void validaCampoObrigatorio(String campo) {
		if (Objects.isNull(campo) || campo.isBlank())
        	throw new NullPointerException();
	}
    
    private void validaCampoObrigatorio(Cor cor) {
    	if (cor == null)
    		throw new NullPointerException();
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            return new Carro(motorista, placa, cor);
        }
    }
}
