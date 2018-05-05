import java.time.LocalDate;

public class Fattura 
{
	private LocalDate data;
	//private ID id;  crea attributo anno e numero progressivo
	private int anno;
	private static int i = 0; //numero progressivo
	private String nomeEnte;
	private String descrizioneProdotto;
	private int importo;
	private char metodoPagamento;
	private char statoFattura;
	
	public Fattura(LocalDate data, int anno, int i,String nomeEnte,String descrizioneProdotto, int importo,char metodoPagamento,char statoFattura)
	{
		setData(data);
		//setId(id);
		setI(i);
		setAnno(anno);
		setNomeEnte(nomeEnte);
		setDescrizioneProdotto(descrizioneProdotto);
		setImporto(importo);
		setMetodoPagamento(metodoPagamento);
		setStatoFattura(statoFattura);
	}

	public LocalDate getData() 
	{
		return data;
	}

	public void setData(LocalDate data)
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

	/*public ID getId()
	{
		return id;
	}

	public void setId(ID id)
	{
		this.id = id;
	}
	*/

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
	
	
	
	public String toString()
	{
		return "Fattura numero:" + getAnno() + " " +getI()  + '\n' + "DATA:" + getData() + '\n' + "NOME:" + getNomeEnte() + '\n' + "DESCRIZIONE:" + getDescrizioneProdotto() + '\n' + "IMPORTO" + getImporto() + '\n' + "M.PAGAM. :" + getMetodoPagamento() + '\n' + "STATO:" + getStatoFattura();
	}

	public int getAnno()
	{
		return anno;
	}

	public void setAnno(int anno)
	{
		this.anno = anno;
	}

	public static int getI()
	{
		return i;
	}

	public static void setI(int i) 
	{
		Fattura.i = i;
	}

}
