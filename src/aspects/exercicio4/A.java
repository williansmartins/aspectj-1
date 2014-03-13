package aspects.exercicio4;

public class A implements I
{

    private I i;
    
    
    public A( I i )
    {
	this.i = i;
    }

    @Override
    public void m( )
    {
	System.out.println( "Executando  metodo m de A" );
	i.m();
    }

}
