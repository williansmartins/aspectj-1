package aspects.exercicio4;

public aspect TesteCallAspect
{

    pointcut callM( I i1, I i2 ) : TesteAspect.identificaI ( i1, i2 ) && call (void m());

    before( I i1, I i2 ) : callM ( i1, i2 ){
	TesteAspect.teste( i1, i2, thisJoinPoint );
    }
}
