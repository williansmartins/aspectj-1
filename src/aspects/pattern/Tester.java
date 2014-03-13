package aspects.pattern;

public class Tester
{
    public static void main( String[] args )
    {
	Fornecedor marcos = new Fornecedor();
	marcos.setNome( "Marcos" );
	System.out.println( marcos.getNome() );

	Cliente willians = new Cliente();
	willians.setNome( "Willians" );
	System.out.println( willians.getNome() );
	

	System.out.println( "Novamente objeto::marcos" + marcos.getNome() );
	System.out.println( "Novamente objeto::willians" + willians.getNome() );
	
	Cliente will1 = new Cliente();
	Cliente will2 = new Cliente();
	Cliente will3 = new Cliente();
	Cliente will4 = new Cliente();
	Cliente will5 = new Cliente();
	
	if ( will1 == will2 )
	{
	    System.out.println( "os objetos são iguais" );
	}else{
	    System.out.println( "os objetos são diferentes" );
	}
    }
}
