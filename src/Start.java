/**
 * La classe start Permette di stampare a video un titolo con delle decorazioni
 * @author Alessandro Lorenzetti.
 * @version 1.0
 *
 */
public class Start
{
	
	private char logo;
	private int lunghezza;
	private String titolo;
	/**
	 * Accetta i seguenti parametri:
	 * @param logo = Valore di tipo char che verrà stampato "lunghezza" volte
	 * @param lunghezza = int che stabilisce quante volte stampare video il char nel parametro "logo".
	 * @param titolo = String che verrà stampato tra il logo.
	 */
	public Start(char logo,int lunghezza,String titolo)
	{
		setLogo(logo);
		setLunghezza(lunghezza);
		setTitolo(titolo);
	}
	/**
	 * Ritorna il logo inerito.
	 * @return char logo
	 */
	public char getLogo()
	{
		return logo;
	}
	/**
	 * Serve per modificare il valore logo.
	 * @param logo
	 */
	public void setLogo(char logo)
	{
		this.logo = logo;
	}
	/**
	 * Ritorna il valore int della lunghezza che dovrà avere il logo del titolo.
	 * @return
	 */
	public int getLunghezza()
	{
		return lunghezza;
	}
	/**
	 * permette di modificare la lunghezza del logo.
	 * @param lunghezza
	 */
	public void setLunghezza(int lunghezza)
	{
		this.lunghezza = lunghezza;
	}
	
	/**
	 * Ritorna il titolo.
	 * @return
	 */
	public String getTitolo()
	{
		return titolo;
	}
	/**
	 * Ritorna il valore all'interno del titolo.
	 * @param titolo
	 */
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}
	/**
	 * assembla il titolo con i parametri inseriti.
	 */
	public void visualizza()
	{
		for (int i = 0; i < lunghezza; i++)
		{
			System.out.print(getLogo());;
		}
		
		System.out.println();
		
		System.out.println(getTitolo());
		
		for (int i = 0; i < lunghezza; i++)
		{
			System.out.print(getLogo());
		}
		
		// A capo
		for (int i = 0; i < 2; i++)
		{
			System.out.println();
		}
		
		
		
	}

	
	

}
