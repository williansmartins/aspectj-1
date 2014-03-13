package aspects.mp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract aspect PadraoObserver
{
    protected interface Subject
    {
    };

    protected interface Observer
    {
	void update( );
    };

    Subject sujeito;

    List<Observer> observadores = new ArrayList<Observer>();

    abstract pointcut criarSujeito( Subject s );

    abstract pointcut criarObservador( Observer o );

    abstract pointcut modificarSujeito( );

    after( Subject s ) : criarSujeito(s){
	if ( sujeito == null )
	{
	    System.out.println( "Foi criado um sujeito: " + s.getClass().getName() );
	    sujeito = s;
	}
    }

    after( Observer o ) : criarObservador(o){
	if ( sujeito == null )
	{
	    System.out.println( "Foi criado um observador: " + o.getClass().getName() );
	    observadores.add( o );
	}
    }

    after( ) : modificarSujeito(){
	Iterator<Observer> i = observadores.iterator();

	while ( i.hasNext() )
	{
	    Observer o = (Observer) i.next();
	    System.out.println( "Foi executado o metodo update() do observador: "
		    + o.getClass().getName() );
	    o.update();
	}
    }

}
