import java.io.Serializable;
import java.time.LocalDate;

/**
 * La classe Fattura rapresenta una fattura , accetta i seguenti parametri:
 * data(LocalDate) anno (int) NomeEnte (String) descrizioneProdotto (int) importo (boolean)statoFattura (boolean)fatturaErrata
 * @author Alessandro Lorenzetti.
 * @version 1.0
 */
 
public class Fattura implements Serializable
{
	private LocalDate data;
	private int anno;
	private static int i; //numero progressivo
	private String nomeEnte;
	private String descrizioneProdotto;
	private int importo;
	private boolean statoFattura = false;  // false = non pagata, true = Pagata inizialmente false
	private boolean fatturaErrata;
	
	/**
	 * Fattura è uno dei costruttori principali e permette la creazione da parte dell'utente di una nuova fattura
	 * specificando direttamente i parametri
	 * @param data = Elemento di Tipo LocalData, rappresenta la data e viene impostato automaticamente con la data corrente.
	 * @param anno = Elemento che va a richiedere all'utente di inserire l'anno in cui è stata creata la fattura.
	 * @param i = Contatore che si incrementa ogni volta che viene settato.
	 * @param nomeEnte = Elemento che richiede all'utente di inserire il nome da stampare sulla fattura
	 * @param descrizioneProdotto = in questo elemento va inserita una descrizione sui prodotti comprati dall'utente
	 * @param importo = Elemento che accetta un intero, in cui si scrive l'importo che il cliente dve all'azienda.
	 * @param statoFattura = Paramero che accetta un valore booleano se settato su false significa che la fattura non è stata pagata, NB codesto parametro viene automaticamente settato a false.
	 */
	public Fattura(LocalDate data, int anno, int i,String nomeEnte,String descrizioneProdotto, int importo,boolean statoFattura)
	{
		//i++; 
		setData(data);
		//setId(id);
		setI(i);
		setAnno(anno);
		setNomeEnte(nomeEnte);
		setDescrizioneProdotto(descrizioneProdotto);
		setImporto(importo);
		setStatoFattura(statoFattura);
	}
	/**
	 * Il cstruttore Fattura() crea una fattura vuota:
	 * - data = null
	 * - anno = 0
	 * - descrizioneProdotto = null
	 * - importo = 0
	 * - i = i
	 * -statoFattura = false
	 * 
	 */
	public Fattura()
	{
		//i++;//contatore incremento
		setData(null);
		setAnno(0);
		setDescrizioneProdotto(null);
		setImporto(0);
		setI(i); 
		setStatoFattura(false);
		
	}
	/**
	 * Ritorna la data della fattura 
	 * @return data = Valore di tipo LocalDate
	 */
	public LocalDate getData() 
	{
		return data;
	}
	/**
	 * Serve per modificare il valore della Data della fattura.
	 * @param data
	 */
	public void setData(LocalDate data)
	{
		this.data = data;
	}
	
	
	/**
	 * Ritorna il nome dell'ente della fattura
	 * @return String nomeEnte
	 */
	public String getNomeEnte() 
	{
		return nomeEnte;
	}
	
	/**
	 * Serve per modificare il numeEnte della Fattura 
	 * @param nomeEnte
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
	 * Ritorna la descrizione del'prodotto 
	 * @return String descrizioneProdotto
	 */
	public String getDescrizioneProdotto()
	{
		return descrizioneProdotto;
	}
	
	/**
	 * Permette di modificare il valore all'interno del paramero descrizioneProdotto
	 * @param descrizioneProdotto
	 */
	public void setDescrizioneProdotto(String descrizioneProdotto)
	{
		this.descrizioneProdotto = descrizioneProdotto;
	}
	
	
	/**
	 * restituisce il valore di tipo int con il valore dell'importo della fttura.
	 * @return int importo
	 */
	public int getImporto()
	{
		return importo;
	}
	
	/**
	 * permette di modificare il valore dell'importo della fattura.
	 * @param importo
	 */
	public void setImporto(int importo)
	{
		this.importo = importo;
	}
	
	
	
	/**
	 * Restituisce il valore booleano che rappresenta lo stato fattura. 
	 * @return
	 */
	public boolean getStatoFattura()
	{
		return statoFattura;
	}
	
	/**
	 * Permette di modificare il valore booleano della fattura.
	 * @param statoFattura
	 */
	public void setStatoFattura(boolean statoFattura)
	{
		this.statoFattura = statoFattura;
	}
	
	
	/**
	 * toString permette di stampare a video i valori presenti all'interno della fattura.
	 */
	public String toString()
	{
		return "Fattura numero:" + getAnno() + "_" +getI()  +" " + isFatturaErrata() + '\n' + "DATA:" + getData() + '\n' + "NOME:" + getNomeEnte() + '\n' + "DESCRIZIONE:" + getDescrizioneProdotto() + '\n' + "IMPORTO" + getImporto() + '\n' +  "STATO:" + getStatoFattura();
	}
	
	/**
	 * Restituisce il valore dall'anno della fattura.
	 * @return int anno
	 */
	public int getAnno()
	{
		return anno;
	}
	/**
	 * Permette di modificare il valore dell'anno.
	 * @param anno
	 */
	public void setAnno(int anno)
	{
		this.anno = anno;
	}
	
	/**
	 * Ritorna il valore dell'contatore i.
	 * @return int i
	 */
	public static int getI()
	{
		return i;
	}
	
	/**
	 * Modifica e autoincrementa il valore all'inerno del contatore i
	 * @param i
	 */
	public static void setI(int i) 
	{
		i++;
		Fattura.i = i;
	}
	
	/**
	 * Ritorna il valore booleano all'interno della fattura.
	 * @return bool fatturaErrata
	 */
	public boolean isFatturaErrata() 
	{
		return fatturaErrata;
	}
	
	/**
	 * Permette di modificare il valore all'iterno della fattura 
	 * @param fatturaErrata
	 */
	public void setFatturaErrata(boolean fatturaErrata)
	{
		this.fatturaErrata = fatturaErrata;
	}
	
	

}
