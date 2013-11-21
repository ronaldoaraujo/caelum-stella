package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

public class Itau implements Banco {

    private static final String NUMERO_ITAU = "341";

    private final GeradorDeDigitoDeBoleto dvGenerator = new GeradorDeDigitoDeBoleto();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(getNumeroFormatado());
        codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
        codigoDeBarras.append(boleto.getFatorVencimento());
        codigoDeBarras.append(boleto.getValorFormatado());
        Emissor emissor = boleto.getEmissor();
        codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
        codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
        codigoDeBarras.append(dvGenerator.geraDigitoMod10((new StringBuilder(String.valueOf(emissor.getAgenciaFormatado()))).append(getContaCorrenteDoEmissorFormatado(emissor)).append(getCarteiraDoEmissorFormatado(emissor)).append(getNossoNumeroDoEmissorFormatado(emissor)).toString()));
        codigoDeBarras.append(emissor.getAgenciaFormatado());
        codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
        codigoDeBarras.append(dvGenerator.geraDigitoMod10((new StringBuilder(String.valueOf(emissor.getAgenciaFormatado()))).append(getContaCorrenteDoEmissorFormatado(emissor)).toString()));
        codigoDeBarras.append("000");
        codigoDeBarras.insert(4, dvGenerator.geraDigitoMod11(codigoDeBarras.toString()));
        String result = codigoDeBarras.toString();
        if (result.length() != 44) {
            throw new CriacaoBoletoException(
                    "Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
        }

        return result;
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
        return String.format("%03d", emissor.getCarteira());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
        return String.format("%05d", emissor.getContaCorrente());
    }

    public URL getImage() {
        return getClass().getResource(
                String.format("/br/com/caelum/stella/boleto/img/%s.png",
                        getNumeroFormatado()));
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
        return String.format("%08d", emissor.getNossoNumero());
    }

    public String getNumeroFormatado() {
        return NUMERO_ITAU;
    }

}
