import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe rappresenta una fattura e accetta come parametri
 * una data in formato LocalDate
 * un contatore chiamato i
 * una stringa di tipo
 * @author Alessandro Lorenzetti
 *
 */
public class Fattura implements Serializable
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
	private boolean fatturaErrata;
	
	/**
	 * Costruttore principale
	 * 
	 * @param data Accetta parametro LocalData
	 * @param anno Accetta un intero e rappresenta l'anno delle fatture
	 * @param i Intero che rappresenta un contatore (Statico)
	 * @param nomeEnte Stringa che rappresenta il nome della società o dell'ente delle fatture 
	 * @param descrizioneProdotto Stringa che rappresenta descrizione del prodotto
	 * @param importo intero che rappresenta l'importo da pagare o già pagato della fattura 
	 * @param metodoPagamento Char che rapprsenta il meto di pagamento che il cliente / ente utlilizza
	 * @param statoFattura Char che rappresenta se una fattura è già stata pagata 
	 */
	public Fattura(LocalDate data, int anno, int i,String nomeEnte,String descrizioneProdotto, int importo,char metodoPagamento,char statoFattura)
	{
		i++;
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
	/**
	 * Cotruttore vuoto, pone tutti i campi della fattura a null;
	 */
	public Fattura()
	{
		setData(null);
		setAnno(0);
		setDescrizioneProdotto(null);
		setImporto(0);
		setI(0);
		setMetodoPagamento(' ');
		setStatoFattura(' ');
		
	}
	/**
	 * get data serve per restituire la data già inserita 
	 * @return data (LocalDate)
	 */
	public LocalDate getData() 
	{
		return data;
	}
	/**
	 * Set data serve per cambiare i parametri all'interno della data;
	 * @param data (LocalDate)
	 */
	public void setData(LocalDate data)
	{
		this.data = data;
	}
	
	/**
	 * getNomeEnte restituisce una stringa con il valore dell nome ente già inserito;
	 * @return
	 */

	public String getNomeEnte() 
	{
		return nomeEnte;
	}
	
	/**
	 * Set data serve per cambiare i parametri all'interno del campo nomeEnte;
	 * @param nomeEnte
	 */
	/**
	 */
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
	
	/**
	 * getDescrizioneProdotto restituisce una stringa in cui è presente
	 *  la descrizione di un prodotto
	 * @return
	 */
	public String getDescrizioneProdotto()
	{
		return descrizioneProdotto;
	}
	/**
	 * con setdesrizione si può agire sull'attributo  descrizioneProdotto
	 * @param descrizioneProdotto(Stringa)
	 */

	public void setDescrizioneProdotto(String descrizioneProdotto)
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}
	
	/**
	 * Con get inporto sarà possibile visualizzare l'importo della fattura; 
	 * @return
	 */

	public int getImporto()
	{
		return importo;
	}
	/**
	 * Con set imorto si andr a modificare il valore all'interno dell attributo importo.
	 * @param importo
	 */

	public void setImporto(int importo)
	{
		this.importo = importo;
	}
	
	/**
	 * restituisce un char che speciica il metodo di pagamento che il cliente utilizzerà
	 * @return
	 */

	public char getMetodoPagamento() 
	{
		return metodoPagamento;
	}
	/**
	 * Metodo che permette di modificare il metodo di pagameto che il cliente desidera utilizzare.
	 * @param metodoPagamento
	 */

	public void setMetodoPagamento(char metodoPagamento)
	{
		this.metodoPagamento = metodoPagamento;
	}
	/**
	 * retituisce un char che specifica se la fattura è stata pagata
	 * @return
	 */

	public char getStatoFattura()
	{
		return statoFattura;
	}
	/**
	 * permette di modificare lo stato della fattura.
	 * @param statoFattura
	 */

	public void setStatoFattura(char statoFattura)
	{
		this.statoFattura = statoFattura;
	}
	
	/**
	 * Restituisce una stringa con tutti i arametri della Fattura.
	 */
	
	public String toString()
	{
		return "Fattura numero:" + getAnno() + "_" +getI()  +" " + isFatturaErrata() + '\n' + "DATA:" + getData() + '\n' + "NOME:" + getNomeEnte() + '\n' + "DESCRIZIONE:" + getDescrizioneProdotto() + '\n' + "IMPORTO" + getImporto() + '\n' + "M.PAGAM. :" + getMetodoPagamento() + '\n' + "STATO:" + getStatoFattura();
	}
	/**
	 * Restituisce l'anno della fattura
	 * @return
	 */

	public int getAnno()
	{
		return anno;
	}
	/**
	 * permette di modificare lo stato della fattura
	 * @param anno
	 */

	public void setAnno(int anno)
	{
		this.anno = anno;
	}
	/**
	 * Restituisce il numero progressivo della fattura
	 * @return
	 */

	public static int getI()
	{
		return i;
	}
	/**
	 * Permette di modificare il contatore
	 * @param i
	 */

	public static void setI(int i) 
	{
		
		Fattura.i = i;
	}
	/**
	 * Restituisce true o false se la fattura è errata
	 * @return
	 */

	public boolean isFatturaErrata() 
	{
		return fatturaErrata;
	}
	/**
	 * Modifica se la fattura è sbagliata o meno.
	 */

	public void setFatturaErrata(boolean fatturaErrata)
	{
		this.fatturaErrata = fatturaErrata;
	}
	
	

}
