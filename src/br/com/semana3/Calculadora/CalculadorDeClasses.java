package br.com.semana3.Calculadora;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal Somar(Object objeto) {
        BigDecimal soma = BigDecimal.ZERO;
        Field[] fields = objeto.getClass().getDeclaredFields();
        
        for(Field f : fields){
            if(f.isAnnotationPresent(Somar.class) && f.getType().isAssignableFrom(BigDecimal.class)){
                try {

                    f.setAccessible(true);
                    BigDecimal value = (BigDecimal) f.get(objeto);
                    if(value != null)
                        soma = soma.add(value);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return soma;
	}

	@Override
	public BigDecimal Subtrair(Object objeto) {
        BigDecimal subtracao = BigDecimal.ZERO;
        Field[] fields = objeto.getClass().getDeclaredFields();
        
        for(Field f : fields){
            if(f.isAnnotationPresent(Subtrair.class) && f.getType().isAssignableFrom(BigDecimal.class)){
                try {

                    f.setAccessible(true);
                    BigDecimal value = (BigDecimal) f.get(objeto);
                    if(value != null)
                    	subtracao = subtracao.add(value);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();

                }
            }
        }

        return subtracao;
	}

	@Override
	public BigDecimal Totalizar(Object objeto) {
		
        BigDecimal soma = Somar(objeto);
        BigDecimal subtracao = Subtrair(objeto);

        if(soma != null && subtracao != null) {
            BigDecimal res = soma.subtract(subtracao);
            return res;

            }else{
                return BigDecimal.ZERO;

        }
	}
}
