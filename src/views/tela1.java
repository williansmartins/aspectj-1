package br.com.fiap.aop.view;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import br.com.fiap.aop.model.Compra;
import br.com.fiap.aop.model.Item;
import br.com.fiap.aop.model.Produto;


public class tela1 extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNroPedido;
	private JTextField txtQuantidade;
	private JTable tbProdutos;
	private Compra compra = new Compra();
	List<Produto> produtos = new ArrayList<Produto>();
	JComboBox<Produto> cbProduto = new JComboBox();
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela1 frame = new tela1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tela1() {
		cbProduto.setRenderer(new ListCellRenderer() {
		    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		        Produto p = new Produto();
		        p = (Produto) value;
		    	final JLabel renderer = new JLabel(p.getDescricao());
		        return renderer;
		    }
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNroPedido = new JTextField();
		txtNroPedido.setHorizontalAlignment(SwingConstants.CENTER);
		txtNroPedido.setText("1");
		txtNroPedido.setBounds(79, 26, 86, 20);
		contentPane.add(txtNroPedido);
		txtNroPedido.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nro. Pedido:");
		lblNewLabel.setBounds(10, 31, 68, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTipoCliente = new JLabel("Tipo Cliente:");
		lblTipoCliente.setBounds(10, 62, 68, 14);
		contentPane.add(lblTipoCliente);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 99, 68, 14);
		contentPane.add(lblCliente);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 134, 68, 14);
		contentPane.add(lblProduto);
		
		JComboBox cbTipoCliente = new JComboBox();
		cbTipoCliente.setModel(new DefaultComboBoxModel(new String[] {"F\u00EDsico", "Jur\u00EDdico"}));
		cbTipoCliente.setBounds(79, 57, 129, 22);
		contentPane.add(cbTipoCliente);
		
		JComboBox cbCliente = new JComboBox();
		cbCliente.setModel(new DefaultComboBoxModel(new String[] {"Willians Martins de Morais"}));
		cbCliente.setBounds(79, 95, 414, 22);
		contentPane.add(cbCliente);
		
		
		cbProduto.setBounds(79, 130, 414, 22);
		
		contentPane.add(cbProduto);
		
		JButton btnAdicionarProduto = new JButton("Adicionar produto");
		btnAdicionarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Produto produtoSelecionado = (Produto) cbProduto.getSelectedItem();
				System.out.println(">>" + produtoSelecionado.getDescricao());
				
				DefaultTableModel model = (DefaultTableModel) tbProdutos.getModel();
				//"Id produto", "Desc Produto", "Valor unit\u00E1rio", "QTD", "Desconto", "Total"
				model.addRow(new Object[]{produtoSelecionado.getCodigo(), produtoSelecionado.getDescricao(), produtoSelecionado.getPreco(), txtQuantidade.getText(), 0, produtoSelecionado.getPreco().doubleValue() * Double.parseDouble(txtQuantidade.getText() });
				
				
				if (hasProductInItem(compra.getItens(), produtoSelecionado)) {
					
				} else {					
					Item i = new Item();
					i.setProduto(produtoSelecionado);
					compra.getItens().add(i);	
				}
				
				
			}

			private boolean hasProductInItem(List<Item> itens, Produto p) {
				for(Item i : itens) {
					if (i.getProduto().getCodigo().equals(p.getCodigo())) {
						i.getQuantidade().add(new BigInteger("1"));
						return true;
					}
				}
				return false;
			}
			
		});
		btnAdicionarProduto.setBounds(10, 175, 178, 23);
		contentPane.add(btnAdicionarProduto);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantidade.setText("1");
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(576, 131, 28, 20);
		contentPane.add(txtQuantidade);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(501, 134, 68, 14);
		contentPane.add(lblQuantidade);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 625, 183);
		contentPane.add(scrollPane);
		
		tbProdutos = new JTable();
		scrollPane.setViewportView(tbProdutos);
		
		tbProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id produto", "Desc Produto", "Valor unit\u00E1rio", "QTD", "Desconto", "Total"
			}
		));
		
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		textField.setBounds(475, 198, 160, 20);
		contentPane.add(textField);
		
		JLabel lblTotal = new JLabel("TOTAL GERAL:");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(372, 201, 99, 14);
		contentPane.add(lblTotal);
		
		for (Integer i = 0; i < 10; i++) {
			Produto p = new Produto();
			p.setCodigo(new BigInteger( i.toString() ));
			p.setDescricao("Livro - " + i);
			p.setPreco(new BigDecimal( 45.5 ));
			produtos.add( p );
		}
		
		compra.setItens(new ArrayList<Item>());
		
		for (Produto p : produtos) {
			cbProduto.addItem( p );
		}
		
	}
}
