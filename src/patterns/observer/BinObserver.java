package patterns.observer;
class BinObserver extends Observer
{

    public BinObserver( Subject s )
    {
	subj = s;
	subj.attach( this );
    }

    @Override
    public void update( )
    {
	System.out.println( "numero Binário: " + Integer.toBinaryString( subj.getState() ) );
    }
}
