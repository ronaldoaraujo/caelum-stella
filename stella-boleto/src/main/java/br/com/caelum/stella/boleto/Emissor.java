package br.com.caelum.stella.boleto;

/**
 * Bean que representa os dados do emissor de um Boleto.
 * 
 * @author Paulo Silveira
 * @author Caue Guerra
 * @author David Paniz
 * 
 */
public class Emissor {
	private int agencia;
	private int digitoAgencia;
	private long contaCorrente;
	private int carteira;
	private long numeroConvenio;
	private long nossoNumero;
	private String cedente;
	private String enderecoCedente;
	private int digitoContaCorrente;
	private int digitoNossoNumero;
	private int codigoOperacao;
	private int codigoFornecidoPelaAgencia;

	private Emissor() {
	}

	/**
	 * Cria novo emissor
	 * 
	 * @return
	 */
	public static Emissor newEmissor() {
		return new Emissor();
	}

	/**
	 * Devolve o número da agencia sem o digito
	 * 
	 */
	public int getAgencia() {
		return this.agencia;
	}

	/**
	 * Associa uma agencia, SEM o dígito verificador, ao emissor
	 * 
	 * @param agencia
	 */
	public Emissor withAgencia(int agencia) {
		this.agencia = agencia;
		return this;
	}

	/**
	 * Devolve o número da conta corrente sem o digito
	 * 
	 */
	public long getContaCorrente() {
		return this.contaCorrente;
	}

	/**
	 * Associa uma conta corrente, SEM o dígito verificador, ao emissor
	 * 
	 * @param contaCorrente
	 */
	public Emissor withContaCorrente(long contaCorrente) {
		this.contaCorrente = contaCorrente;
		return this;
	}

	/**
	 * Devolve a carteira<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 */
	public int getCarteira() {
		return this.carteira;
	}

	/**
	 * Associa uma carteira ao emissor<br/>
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 * @param carteira
	 */
	public Emissor withCarteira(int carteira) {
		this.carteira = carteira;
		return this;
	}

	/**
	 * @deprecated
	 * @see Emissor#getNumeroConvenio()
	 */
	@Deprecated
	public long getNumConvenio() {
		return getNumeroConvenio();
	}

	/**
	 * Devolve o número do convênio<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 */
	public long getNumeroConvenio() {
		return this.numeroConvenio;
	}

	/**
	 * @deprecated
	 * @see Emissor#withNumeroConvenio(long)
	 */
	@Deprecated
	public Emissor withNumConvenio(long numConvenio) {
		return withNumeroConvenio(numConvenio);
	}

	/**
	 * Associa um número de convênio ao emissor<br/>
	 * Valor que identifica um emissor junto ao seu banco para associar seus
	 * boletos<br/>
	 * Valor informado pelo banco
	 * 
	 * @param numConvenio
	 */
	public Emissor withNumeroConvenio(long numConvenio) {
		this.numeroConvenio = numConvenio;
		return this;
	}

	/**
	 * Devolve o nosso número<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 */
	public long getNossoNumero() {
		return this.nossoNumero;
	}

	/**
	 * Associa o nosso número ao emissor<br/>
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse
	 * valor serve para o cedente identificar quais boletos foram pagos ou não.
	 * Recomenda-se o uso de números sequenciais, na geração de diversos
	 * boletos, para facilitar a identificação dos boletos pagos
	 * 
	 * @param nossoNumero
	 */
	public Emissor withNossoNumero(long nossoNumero) {
		this.nossoNumero = nossoNumero;
		return this;
	}

	/**
	 * Devolve o cedente. (nome do emissor)
	 * 
	 */
	public String getCedente() {
		return this.cedente;
	}

	/**
	 * Associa um cedente (nome) ao emissor
	 * 
	 * @param cedente
	 */
	public Emissor withCedente(String cedente) {
		this.cedente = cedente;
		return this;
	}

	/**
	 * @deprecated
	 * @see Emissor#getDigitoContaCorrente()
	 */
	@Deprecated
	public int getDvContaCorrente() {
		return getDigitoContaCorrente();
	}

	/**
	 * Devolve o digito verificador (DV) da conta corrente
	 * 
	 * @return
	 */
	public int getDigitoContaCorrente() {
		return this.digitoContaCorrente;
	}

	/**
	 * @deprecated
	 * @see Emissor#withDigitoContaCorrente(char)
	 */
	@Deprecated
	public Emissor withDvContaCorrente(int dv) {
		return withDigitoContaCorrente(dv);
	}

	/**
	 * Associa um digito verificador (DV) da conta corrente ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor withDigitoContaCorrente(int dv) {
		this.digitoContaCorrente = dv;
		return this;
	}

	/**
	 * @deprecated
	 * @see Emissor#getDigitoAgencia()
	 */
	@Deprecated
	public int getDvAgencia() {
		return getDigitoAgencia();
	}

	/**
	 * Devolve o digito verificador (DV) da agencia
	 * 
	 * @return
	 */
	public int getDigitoAgencia() {
		return this.digitoAgencia;
	}

	/**
	 * @deprecated
	 * @see Emissor#withDigitoAgencia(char)
	 */
	@Deprecated
	public Emissor withDvAgencia(int dv) {
		return withDigitoAgencia(dv);
	}

	/**
	 * Associa um digito verificador (DV) da agencia ao emissor
	 * 
	 * @param dv
	 * @return
	 */
	public Emissor withDigitoAgencia(int dv) {
		this.digitoAgencia = dv;
		return this;
	}

	/**
	 * Devolve a agencia formatada (com 4 digitos)
	 * 
	 * @return
	 */
	public String getAgenciaFormatado() {
		return String.format("%04d", this.agencia);
	}

	/**
	 * @deprecated
	 * @see Emissor#getCodigoOperacao()
	 */
	@Deprecated
	public int getCodOperacao() {
		return getCodigoOperacao();
	}

	/**
	 * Devolve o código de operação do emissor.
	 * 
	 * @return
	 */
	public int getCodigoOperacao() {
		return this.codigoOperacao;
	}

	/**
	 * @deprecated
	 * @see Emissor#withCodigoOperacao(int)
	 */
	@Deprecated
	public Emissor withCodOperacao(int codOperacao) {
		return withCodigoOperacao(codOperacao);
	}

	/**
	 * Associa um código de operação ao emissor.
	 * 
	 * @param codOperacao
	 * @return
	 */
	public Emissor withCodigoOperacao(int codOperacao) {
		this.codigoOperacao = codOperacao;
		return this;
	}

	/**
	 * @deprecated
	 * @see Emissor#getCodigoFornecidoPelaAgencia()
	 */
	@Deprecated
	public int getCodFornecidoPelaAgencia() {
		return getCodigoFornecidoPelaAgencia();
	}

	/**
	 * Devolve o código fornecido pela agência do emissor.
	 * 
	 * @return
	 */
	public int getCodigoFornecidoPelaAgencia() {
		return this.codigoFornecidoPelaAgencia;
	}

	/**
	 * @deprecated
	 * @see Emissor#withCodigoFornecidoPelaAgencia(int)
	 */
	@Deprecated
	public Emissor withCodFornecidoPelaAgencia(int codFornecidoPelaAgencia) {
		return withCodigoFornecidoPelaAgencia(codFornecidoPelaAgencia);
	}

	/**
	 * Associa um código fornecido pela agência ao emissor.
	 * 
	 * @param codFornecidoPelaAgencia
	 * @return
	 */
	public Emissor withCodigoFornecidoPelaAgencia(int codFornecidoPelaAgencia) {
		this.codigoFornecidoPelaAgencia = codFornecidoPelaAgencia;
		return this;
	}

	/**
	 * @deprecated
	 * @see Emissor#withDigitoNossoNumero(char)
	 */
	@Deprecated
	public Emissor withDvNossoNumero(int dvNossoNumero) {
		return withDigitoNossoNumero(dvNossoNumero);
	}

	/**
	 * Associa o DV do nosso número ao emissor
	 * 
	 * @param dvNossoNumero
	 */
	public Emissor withDigitoNossoNumero(int dvNossoNumero) {
		this.digitoNossoNumero = dvNossoNumero;
		return this;
	}

	public Emissor withEnderecoCedente(String enderecoCedente) {
		this.enderecoCedente = enderecoCedente;
		return this;
	}
	
	/**
	 * @deprecated
	 * @see Emissor#getDigitoNossoNumero()
	 */
	@Deprecated
	public int getDvNossoNumero() {
		return getDigitoNossoNumero();
	}

	/**
	 * Devolve o DV no nosso número associado ao emissor
	 * 
	 * @return
	 */
	public int getDigitoNossoNumero() {
		return this.digitoNossoNumero;
	}
	/**
	 * Devolve o Endereço do Cedente
	 * 
	 * @return
	 */
	public String getEnderecoCedente() {
		return enderecoCedente;
	}

}
