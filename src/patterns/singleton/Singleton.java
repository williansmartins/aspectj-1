package patterns.singleton;

public class Singleton
{
    private String dados;
    private static Singleton instancia = null;

    public static synchronized Singleton getInstancia( )
    {
	if ( instancia == null )
	{
	    instancia = new Singleton();
	}
	return instancia;
    }

    public String getDados( )
    {
	return dados;
    }

    public void setDados( String dados )
    {
	this.dados = dados;
    }

    public static void setInstancia( Singleton instancia )
    {
	Singleton.instancia = instancia;
    }

    public static void main( String[] args )
    {
	Singleton a = Singleton.getInstancia();
	Singleton b = Singleton.getInstancia();

	if ( a == b )
	{
	    System.out.println( "os objetos são iguais" );
	}

    }

}
