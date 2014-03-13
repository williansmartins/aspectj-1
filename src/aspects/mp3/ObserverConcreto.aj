package aspects.mp3;

public aspect ObserverConcreto extends PadraoObserver
{
    pointcut criarSujeito( Subject s ) : execution( MP3Player.new( ) ) && this( s );

    pointcut criarObservador( Observer o ) :
	    ( execution( Slider.new( ) ) || execution( TextLevel.new( ) ) ) && this( o );

    pointcut modificarsujeito() : execution(* MP3Player.setVolume(..) ) ;

    declare parents: MP3Player implements Subject;
    declare parents: Slider implements Observer;
    declare parents: TextLevel implements Observer;

    public void Slider.update( Subject s )
    {
	MP3Player p = (MP3Player) s;
	System.out.println( "foi informado Silder" );
    }

    public void TextLevel.update( Subject s )
    {
	MP3Player p = (MP3Player) s;
	System.out.println( "foi informado TextLevel" );
    }
}