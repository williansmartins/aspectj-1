package patterns.observer;
class OctObserver extends Observer
{

    public OctObserver( Subject s )
    {
	subj = s;
	subj.attach( this );
    }

    @Override
    public void update( )
    {
	System.out.println( "numero octal: " + Integer.toOctalString( subj.getState() ) );
    }
}
