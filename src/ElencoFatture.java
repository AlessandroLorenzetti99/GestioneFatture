import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * La seguente classe rapprsenta una lista di Fatture
 * @author Alessandro Lorenzetti
 *
 */
public class ElencoFatture implements Serializable
{
	private Nodo head;
	private int elementi;
	/**
	 * ElencoFatture Crea una nuova Lista di fatture
	 */
	public ElencoFatture()
	{
		head=null;
		elementi=0;
	}
	/**
	 * Restituisce il numero di elementi inseriti
	 * @return
	 */
	public int getElementi()
	{
		return elementi;
	}
	/**
	 * Crea un nuovo Nodo
	 * @param fattura (Fattura)
	 * @param link (Nodo)
	 * @return (Nodo)
	 */
	private Nodo creaNodo(Fattura fattura, Nodo link)
	{
		Nodo nodo=new Nodo(fattura);
		nodo.setLink(link);
		return nodo;
	}
	/**
	 * Restituisce il Nodo dell'Elemento seguente
	 * @param posizione
	 * @return
	 * @throws ElencoFattureException
	 */
	private Nodo getLinkPosizione(int posizione) throws ElencoFattureException
	{
		if(posizione<1 || posizione>getElementi())
			throw new ElencoFattureException("posizione non valida");
		if(elementi==0)
			throw new ElencoFattureException("lista vuota");
		Nodo p;
		int n;
		p=head;
		n=1;
		while(p.getLink()!=null && n<posizione)
		{
			p=p.getLink();
			n++;
		}
		return p;
	}
	/**
	 * Inserisce una fattura in Testa allo Stack
	 * @param fattura
	 */
	public void inserisciInTesta(Fattura fattura)
	{
		Nodo p=creaNodo(fattura,head);
		head=p;
		elementi++;
	}
	/**
	 * Restituisce una stringa con uno schema dei vari nodi
	 */
	public String toString()
	{
		String risultato="Head";
		if (elementi==0)
			return risultato+"-->";
		
		Nodo p=head;
		while(p!=null)
		{
			risultato+="-->"+p.getInfo().toString();
			p=p.getLink();
		}
		return risultato;
	}
	/**
	 * Inserisce in coda allo stack una fattura
	 * @param fattura
	 * @throws ElencoFattureException
	 */
	public void inserisciInCoda(Fattura fattura) throws ElencoFattureException
	{
		if(elementi==0)
		{
			inserisciInTesta(fattura);
			return;
		}
		Nodo pn=creaNodo(fattura,null);
		Nodo p=getLinkPosizione(elementi);
		p.setLink(pn);
		elementi++;
	}
	/**
	 * Permette di inserire una fattura in una specifica posizione definita dall'utente
	 * @param posizione
	 * @param fattura
	 * @throws ElencoFattureException
	 */
	public void inserisciInPosizione(int posizione,Fattura fattura) throws ElencoFattureException
	{
		if(posizione<=1)
		{
			inserisciInTesta(fattura);
			return;
		}
		if(posizione>elementi)
		{
			inserisciInCoda(fattura);
			return;
		}
		Nodo precedente=getLinkPosizione(posizione-1);
		Nodo pn=creaNodo(fattura,getLinkPosizione(posizione));
		precedente.setLink(pn);
		elementi++;
	}
	/**
	 * Permette di eliminae una fattura(Non usata)
	 * @throws ElencoFattureException
	 */
	public void eliminaInTesta() throws ElencoFattureException
	{
		if(elementi==0)
			throw new ElencoFattureException("lista vuota");
		head=head.getLink();
		elementi--;
	}
	public void eliminaInCoda() throws ElencoFattureException
	{
		if(elementi==0)
			throw new ElencoFattureException("lista vuota");
		if(elementi==1)
		{
			eliminaInTesta();
			elementi--;
			return;
		}
		Nodo p=getLinkPosizione(elementi-1);
		p.setLink(null);
		elementi--;
	}
	
	public void eliminaInPosizione(int posizione) throws ElencoFattureException
	{
		if(posizione<=1 || posizione>elementi)
		{
			throw new ElencoFattureException("inserimento non valido");
		}
		if(elementi==0)
		{
			throw new ElencoFattureException("lista vuota");
		}
		if(posizione==1)
		{
			eliminaInTesta();
		}
		if(posizione==elementi)
		{
			eliminaInCoda();
		}
		Nodo p=getLinkPosizione(posizione);
		Nodo precedente=getLinkPosizione(posizione-1);
		precedente.setLink(p.getLink());
		elementi--;
	} 
	/**
	 * Visualizza la fattura in stringa in una determinata posizione
	 * @param posizione
	 * @return
	 * @throws ElencoFattureException
	 */
	public String visualizza(int posizione) throws ElencoFattureException
	{
		if(posizione<=0 || posizione>elementi)
			throw new ElencoFattureException("inserimento invalido");
		if(elementi==0)
			throw new ElencoFattureException("lista vuota");
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo().toString();
	}
	/**
	 * Restituisce una fattura in formato Oggetto(Fattura)
	 * @param posizione
	 * @return
	 * @throws ElencoFattureException
	 */
	public Fattura getFattura(int posizione) throws ElencoFattureException
	{
		if(posizione<=0 || posizione>elementi)
			throw new ElencoFattureException("inserimento invalido");
		if(elementi==0)
			throw new ElencoFattureException("lista vuota");
		Nodo p=getLinkPosizione(posizione);
		return p.getInfo();
	}
	/*
	public void esportaCSV(String nomeFile) throws FileException, IOException, ElencoFattureException
	{
		TextFile file=new TextFile(nomeFile,'W');;
		String personaCSV;
		Fattura persona;
		for (int i = 1; i <=getElementi(); i++) 
		{
			persona=getInvitato(i);
			personaCSV=persona.getNome()+";"+persona.getSesso()+";"+persona.getTelefono();
			file.toFile(personaCSV);
		}
		file.closeFile();
	}
	*/
	/*
	public ElencoFatture importaCSV(String nomeFile) throws IOException, FileException, ElencoFattureException
	{
		ElencoFatture festa=new ElencoFatture();
		TextFile file=new TextFile(nomeFile,'R');
		String rigaLetta;
		String[] elementiFattura;
		Fattura persona;
		try
		{
			while(true)
			{
				rigaLetta=file.fromFile();
				elementiFattura=rigaLetta.split(";");
				persona=new Fattura(elementiFattura[0],elementiFattura[1].charAt(0),elementiFattura[2]);
				festa.inserisciInCoda(persona);
			}
		}
		catch(FileException e)
		{
			if(e.toString().compareTo("End of file")==0)
				file.closeFile();
			else
				throw new FileException(e.toString());
		}
			
		return festa;
	}
	*/
	/**
	 * Permette di salvare Elenco Fatture
	 * @param nomeFile
	 * @throws IOException
	 */
	public void salvaElencoFatture(String nomeFile) throws IOException
	{
		FileOutputStream file=new FileOutputStream(nomeFile);
		ObjectOutputStream writer=new ObjectOutputStream(file);
		writer.writeObject(this);
		writer.flush();
		file.close();
	}
	/**
	 * Carica le fatture da un file binario(.bin)
	 * @param nomeFile
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public ElencoFatture caricaElencoFatture(String nomeFile) throws ClassNotFoundException, IOException
	{
		FileInputStream file=new FileInputStream(nomeFile);
		ObjectInputStream reader=new ObjectInputStream(file);
		ElencoFatture elenco;
		elenco = (ElencoFatture) reader.readObject();
		file.close();
		return elenco;
	}
	
	/*
	public void segnalaFatturaErrata(int posizione)
	{
		
	}
	*/
	
	/**
	 * Permette  di segnalare una fattura come Pagata
	 * @param posizione
	 * @throws ElencoFattureException
	 */
	public void segnalaFatturaPagata(int posizione) throws ElencoFattureException
	{
		Fattura f1 = new Fattura();
		f1 = getFattura(posizione);
		f1.setStatoFattura('P');
	}
}
