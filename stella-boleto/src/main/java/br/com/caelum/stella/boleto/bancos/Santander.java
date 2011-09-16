package br.com.caelum.stella.boleto.bancos;

import java.net.URL;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

public class Santander implements Banco {

    private static final String NUMERO_SANTANDER = "033";

    private final GeradorDeDigitoDeBoleto dvGenerator = new GeradorDeDigitoDeBoleto();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        StringBuilder codigoDeBarras = new StringBuilder();
        
        codigoDeBarras.append(getNumeroFormatado());
        codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
        // Digito Verificador sera inserido aqui.

        codigoDeBarras.append(boleto.getFatorVencimento());
        codigoDeBarras.append(boleto.getValorFormatado());
        
        codigoDeBarras.append("9"); 

        Emissor emissor = boleto.getEmissor();

        codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
        codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));       
        codigoDeBarras.append("0");
        codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));

        codigoDeBarras.insert(4, this.dvGenerator.geraDigitoMod11(codigoDeBarras.toString()));

        String result = codigoDeBarras.toString();

        if (result.length() != 44) {
            throw new CriacaoBoletoException(
                    "Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
        }

        return result;
    }

    public String getValorFormatado(Boleto boleto) {
        return String.format("%010.2f", boleto.getValorBoleto()).replaceAll("[^0-9]",
                "");
    }
    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
        return String.format("%03d", emissor.getCarteira());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
        return String.format("%07d",emissor.getCodigoFornecidoPelaAgencia());
    }

    public URL getImage() {
        return getClass().getResource(
                String.format("/br/com/caelum/stella/boleto/img/%s.png",
                        getNumeroFormatado()));
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
        return String.format("%013d", emissor.getNossoNumero());
    }

    public String getNumeroFormatado() {
        return NUMERO_SANTANDER;
    }
}
