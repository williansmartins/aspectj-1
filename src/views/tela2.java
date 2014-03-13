package views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import aspects.exercicio5.model.Produto;

public class tela2 extends JFrame 
{

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JComboBox<Produto> cbProduto = new JComboBox<Produto>();

    public static void main( String[] args )
    {
	System.out.println("tela2");
	EventQueue.invokeLater( new Runnable()
	{
	    public void run( )
	    {
		try
		{
		    tela2 frame = new tela2();
		    frame.setVisible( true );
		    frame.setLocationRelativeTo( null );
		} catch ( Exception e )
		{
		    e.printStackTrace();
		}
	    }
	} );
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public tela2()
    {
	setLayout( new FlowLayout() );
	cbProduto.setRenderer( new ListCellRenderer()
	{
	    public Component getListCellRendererComponent( JList list, Object value, int index,
		    boolean isSelected, boolean cellHasFocus )
	    {
		Produto p = new Produto();
		p = (Produto) value;
		final JLabel renderer = new JLabel( p.getDescricao() );
		return renderer;
	    }
	} );

	getContentPane().add( cbProduto );

	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	setBounds( 100, 100, 673, 474 );
	contentPane = new JPanel();
	contentPane.setBackground( Color.GRAY );
	contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
	setContentPane( contentPane );
	contentPane.setLayout( null );
	cbProduto.setSize( 222, 27 );
	cbProduto.setLocation( 200, 200 );

	contentPane.add( cbProduto );
	List<Produto> produtos = new ArrayList<Produto>();

	for ( Integer i = 0; i < 10; i++ )
	{
	    Produto p = new Produto();
	    p.setCodigo( new BigInteger( i.toString() ) );
	    p.setDescricao( "livro X - " + i );
	    p.setPreco( new BigDecimal( Math.random() ) );
	    produtos.add( p );
	}

	for ( Produto p : produtos )
	{
	    cbProduto.addItem( p );
	}

    }

}
