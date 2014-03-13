package patterns.observer;
class HexObserver extends Observer
{

    public HexObserver( Subject s )
    {
	subj = s;
	subj.attach( this );
    }

    @Override
    public void update( )
    {
	System.out.println( "numero hexadecimal: " + Integer.toHexString( subj.getState() ) );
    }

}
