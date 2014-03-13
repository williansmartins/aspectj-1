package aspects.exercicio4;

public aspect TesteAspect
{
    public void I.o( )
    {
	System.out.println( "Método o de I" );
    }

    pointcut identificaI( I i1, I i2 ) : this ( i1 ) && target( i2 );

    static void teste( I i1, I i2, Object o )
    {
	System.out.println( "--------------------" );
	System.out.println( o );
	System.out.println( i1 );
	System.out.println( i2 );
	System.out.println( "--------------------" );
    }

    public static void main( String[] args )
    {
	I i = new A( new B() );
	i.m();
	i.o();
    }
}
