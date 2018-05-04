
public class Fattura 
{
	private Data data;
	private ID id;
	private String nomeEnte;
	private String descrizioneProdotto;
	private int importo;
	private char metodoPagamento;
	private char statoFattura;
	
	public Fattura(Data data,ID id,String nomeEnte,String descrizioneProdotto, int importo,char metodoPagamento,char statoFattura)
	{
		setData(data);
		setId(id);
		setNomeEnte(nomeEnte);
		setDescrizioneProdotto(descrizioneProdotto);
		setImporto(importo);
		setMetodoPagamento(metodoPagamento);
		setStatoFattura(statoFattura);
	}

	public Data getData() 
	{
		return data;
	}

	public void setData(Data data)
{
		this.data = data;
	}

	public String getNomeEnte() 
	{
		return nomeEnte;
	}

	public void setNomeEnte(String nomeEnte)
	{
		this.nomeEnte = nomeEnte;
	}

	public ID getId()
	{
		return id;
	}

	public void setId(ID id)
	{
		this.id = id;
	}

	public String getDescrizioneProdotto()
	{
		return descrizioneProdotto;
	}

	public void setDescrizioneProdotto(String descrizioneProdotto)
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}

	public int getImporto()
	{
		return importo;
	}

	public void setImporto(int importo)
	{
		this.importo = importo;
	}

	public char getMetodoPagamento() 
	{
		return metodoPagamento;
	}

	public void setMetodoPagamento(char metodoPagamento)
	{
		this.metodoPagamento = metodoPagamento;
	}

	public char getStatoFattura()
	{
		return statoFattura;
	}

	public void setStatoFattura(char statoFattura)
	{
		this.statoFattura = statoFattura;
	}
	
	

}
