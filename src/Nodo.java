import java.io.Serializable;

public class Nodo implements Serializable
{
	private Fattura info;
	private Nodo link;
	public Nodo(Fattura fattura)
	{
		setLink(null);
		setInfo(fattura);
	}
	public Fattura getInfo() {
		return info;
	}
	public void setInfo(Fattura info) 
	{
		this.info = info;
	}
	public Nodo getLink() 
	{
		return link;
	}
	public void setLink(Nodo link)
	{
		this.link = link;
	}
}
