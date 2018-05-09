
public class Ordinatore 
{
	/**
	 * La Funzione scambia due valori all'interno di un Array Numerico 
	 * @param array
	 * @param pos1
	 * @param pos2
	 * @return 0 Se eseguito correttamente
	 */
	public static int scambia (int[] array, int pos1, int pos2)
	{
		int s;
		if (pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}			
	}
	/**
	 * La Funzione scambia due posizioni all'interno di un array di stringhe
	 * @param array
	 * @param pos1
	 * @param pos2
	 * @return 0
	 */
	public static int scambia (String[] array, int pos1, int pos2)
	{
		String s;
		if (pos1<0 || pos2<0 || pos1>=array.length || pos2>=array.length)
			return -1;
		else
		{
			s=array[pos1];
			array[pos1]=array[pos2];
			array[pos2]=s;
			return 0;
		}			
	}
	/**
	 * crea la Copia di un array in cui si andr� 
	 * a Ordinare i valori.
	 * @param array
	 * @return arrayCopia
	 */
	private static int[] copiaArray(int[] array)
	{
		int[] arrayCopia=new int[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	/**
	 * crea una copia di un array si Stringhe
	 * @param array
	 * @return arrayCopia
	 */
	private static String[] copiaArray(String[] array)
	{
		String[] arrayCopia=new String[array.length];
		for (int i = 0; i < arrayCopia.length; i++) 
			arrayCopia[i]=array[i];
		return arrayCopia;
	}
	/**
	 * Ordina i valori dell'array di copia  in Ordine Decrescente
	 * Va utilizzato: Array=Ordinatore.selectionSortDecrescente(arrayDaOrdinare) 
	 * @param array
	 * @return arrayCopia
	 */
	public static int[] selectionSortDecrescente(int[] array)
	{
		int[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i]<arrayCopia[j])
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	/**
	 *  Ordina i valori dell'array di copia  in Ordine crescente
	 * Va utilizzato: Array=Ordinatore.selectionSortCrescente(arrayDaOrdinare) 
	 * @param array
	 * @return arrayCopia
	 */
	public static int[] selectionSortCrescente(int[] array)
	{
		int[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i]>arrayCopia[j])
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	
/**
 *  Ordina i valori dell'array di copia  in Ordine Decrescente (Si utilizza Per Le stringhe
	 * Va utilizzato: Array=Ordinatore.selectionSortDecrescente(arrayDaOrdinare) 
 * @param array
 * @return arrayCopia
 */
	public static String[] selectionSortDecrescente(String[] array)
	{
		String[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i].compareToIgnoreCase(arrayCopia[j])<0)
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	
	/**
	 *  Ordina i valori dell'array di copia  in Ordine Crescente (utilizzato per stringhe)
	 * Va utilizzato: Array=Ordinatore.selectionSortCrescente(arrayDaOrdinare) 
	 * @param array
	 * @return arrayCopia
	 */
	public static String[] selectionSortCrescente(String[] array)
	{
		String[] arrayCopia=copiaArray(array);
		
		for (int i = 0; i < arrayCopia.length-1; i++) 
		{
			
			for (int j = i+1; j < arrayCopia.length; j++) 
			{
				if (arrayCopia[i].compareToIgnoreCase(arrayCopia[j])>0)
					scambia(arrayCopia,i,j);
			}
		}
		return arrayCopia;
	
	}
	
}
