package aspects.exercicio4;

public aspect TesteExecutionAspect
{
    pointcut executionM( I i1, I i2 ) : TesteAspect.identificaI ( i1, i2 ) && execution (void m());

    before( I i1, I i2 ) : executionM ( i1, i2 ){
	TesteAspect.teste( i1, i2, thisJoinPoint );
    }
}
