package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estacionamento {

	private static final int NUMERO_DE_VAGAS = 10;
	private static final Integer IDADE_MOTORISTA_SENIOR = 55;	
	private List<Carro> carrosEstacionados = new ArrayList<>();

    public void estacionar(Carro carro) {
    	validarMotorista(carro.getMotorista());
    	
    	if (haVagasDisponiveis()) {    		
    		carrosEstacionados.add(carro);
    		return;
    	}
    	
		Optional<Carro> passivelDeRemocao = carrosEstacionados.stream()
			.filter(this::podeRemover)
			.findFirst();
		Carro carroARemover = passivelDeRemocao.orElseThrow(() -> new EstacionamentoException("Não é possível retirar nenhum carro"));
		carrosEstacionados.remove(carroARemover);
		carrosEstacionados.add(carro);
    }

	private boolean haVagasDisponiveis() {
		return NUMERO_DE_VAGAS > carrosEstacionados.size();
	}

    private void validarMotorista(Motorista motorista) {
    	if (motorista == null)
    		throw new EstacionamentoException("");
    	if (motorista.getIdade() < 18)
    		throw new EstacionamentoException("");
    	if (motorista.getPontos() > 20)
    		throw new EstacionamentoException("");
	}

	public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return carrosEstacionados.contains(carro);
    }
    
    private boolean podeRemover(Carro carro) {
    	return carro.getMotorista().getIdade() <= IDADE_MOTORISTA_SENIOR;
    }
}
