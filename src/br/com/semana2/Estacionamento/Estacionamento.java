package br.com.semana2.Estacionamento;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
	List<Carro> carrosEstacionados = new ArrayList<Carro>();


    public void estacionar(Carro carro) {
    	if (carro.getMotorista() == null) {
    		throw new EstacionamentoException("O carro deve possuir um motorista");
    	}

    	if(carro.getMotorista().getIdade() < 18) {
    		throw new EstacionamentoException("O motorista deve ser maior de idade");
    	}

    	if(carro.getMotorista().getPontos() > 20) {
    		throw new EstacionamentoException("O motorista nao deve possuir carteira suspensa");
    	}

    	if (carrosEstacionados.size() < 10) {
    		carrosEstacionados.add(carro);
    	} else {

    		int i = 0;
        	while (i < 9 && carrosEstacionados.get(i).getMotorista().getIdade() > 55) {
        		i++;
        	}

        	if (i < 9) {
        		carrosEstacionados.remove(i);
        		carrosEstacionados.add(carro);

        	} else {
        		throw new EstacionamentoException("O estacionamento esta lotado");
        	}
    	}
    }

    public int carrosEstacionados() {
    	return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
    	return carrosEstacionados.indexOf(carro) > -1;
    }
}
