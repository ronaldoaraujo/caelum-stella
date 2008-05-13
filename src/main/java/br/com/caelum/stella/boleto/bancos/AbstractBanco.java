package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;

abstract class AbstractBanco implements Banco {
	
	public String getNumeroFormatado() {
		return String.format("%03d", this.getNumero());
	}

	protected int geraDVCodigoDeBarras(String codigoDeBarras) {
		int soma = 0;
		for (int i = codigoDeBarras.length() - 1, multiplicador = 2; i >= 0; i--, multiplicador++) {
			if (i == 4) // pula posição 5
				i--;
			if (multiplicador == 10) // volta pro 2
				multiplicador = 2;
			soma += Integer.parseInt(String.valueOf(codigoDeBarras.charAt(i)))
					* multiplicador;
		}

		soma *= 10;

		int resto = soma % 11;

		if (resto == 10 || resto == 0)
			return 1;
		else
			return resto;
	}

	protected int geraDVLinhaDigitavel(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo
					.charAt(i)))
					* multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}

		int resto = soma % 10;
		return (10 - resto) % 10;
	}

	public java.net.URL getImage() {
		return AbstractBanco.class.getResource(String
				.format("/br/com/caelum/stella/boleto/img/%s.png",
						getNumeroFormatado()));
	}
}
