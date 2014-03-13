package patterns.observer;
import java.util.Scanner;

public class Tester
{
    public static void main( String[] args )
    {
	Subject sub = new Subject();

	new BinObserver( sub );
	new OctObserver( sub );
	new HexObserver( sub );

	Scanner scan = new Scanner( System.in );

	while ( true )
	{
	    System.out.println( "\nDigite um número: " );
	    sub.setState( scan.nextInt() );
	}
    }
}
