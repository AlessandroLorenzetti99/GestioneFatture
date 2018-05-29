import java.io.Serializable;
import java.time.LocalDate;


public class Fattura implements Serializable
{
	private LocalDate data;
	//private ID id;  crea attributo anno e numero progressivo
	private int anno;
	private static int i = 0; //numero progressivo
	private String nomeEnte;
	private String descrizioneProdotto;
	private int importo;
	private boolean statoFattura;  // false = non pagata, true = Pagata
	private boolean fatturaErrata;
	
	
	public Fattura(LocalDate data, int anno, int i,String nomeEnte,String descrizioneProdotto, int importo,boolean statoFattura)
	{
		i++;
		setData(data);
		//setId(id);
		setI(i);
		setAnno(anno);
		setNomeEnte(nomeEnte);
		setDescrizioneProdotto(descrizioneProdotto);
		setImporto(importo);
		setStatoFattura(statoFattura);
	}
	
	public Fattura()
	{
		setData(null);
		setAnno(0);
		setDescrizioneProdotto(null);
		setImporto(0);
		setI(0);
		setStatoFattura(false);
		
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
	
	
	

	public boolean getStatoFattura()
	{
		return statoFattura;
	}
	

	public void setStatoFattura(boolean statoFattura)
	{
		this.statoFattura = statoFattura;
	}
	
	
	
	public String toString()
	{
		return "Fattura numero:" + getAnno() + "_" +getI()  +" " + isFatturaErrata() + '\n' + "DATA:" + getData() + '\n' + "NOME:" + getNomeEnte() + '\n' + "DESCRIZIONE:" + getDescrizioneProdotto() + '\n' + "IMPORTO" + getImporto() + '\n' +  "STATO:" + getStatoFattura();
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
	

	public boolean isFatturaErrata() 
	{
		return fatturaErrata;
	}
	

	public void setFatturaErrata(boolean fatturaErrata)
	{
		this.fatturaErrata = fatturaErrata;
	}
	
	

}
