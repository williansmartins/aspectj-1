package aspects.pattern;

import java.util.HashMap;

import org.aspectj.lang.ProceedingJoinPoint;

public aspect Singleton
{
    HashMap<Class<?>, Object> singletons = new HashMap<Class<?>, Object>();

    pointcut tratarObjetosSingleton( ) : call ( aspects.pattern.*.new(..)) ;

    Object around( ) : tratarObjetosSingleton()
    {
	Class<?> singletonClass = thisJoinPoint.getSignature().getDeclaringType();
	Object singletonObject = this.singletons.get( singletonClass );

	if ( singletonObject == null )
	{
	    System.out.println( "Uma nova instancia será criada e armazenada em chache "
		    + singletonClass.getName() );
	    singletonObject = proceed();
	    this.singletons.put( singletonClass, singletonObject );
	} else
	{
	    System.out.println( "Um objeto singleton foi recuperado ->" + singletonClass.getName() );
	}

	return singletonObject;

    }
}
