import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Visao extends JFrame {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTexto = new JLabel("Texto");
	private JTextArea txtTexto = new JTextArea();
	private JScrollPane jspTexto = new JScrollPane(txtTexto);
	
	private JLabel lblSenha = new JLabel("Senha");
	private JTextField txtSenha = new JTextField();
	
	private JLabel lblCriptograma = new JLabel("Criptograma");
	private JTextArea txtCriptograma = new JTextArea();
	private JScrollPane jspCriptograma = new JScrollPane(txtCriptograma);
	
	private JButton btnEncriptar = new JButton("Encriptar");
	private JButton btnDecriptar = new JButton("Decriptar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new Visao().setVisible(true);
	}
	
	// Método construtor da classe
	public Visao() {
		// Configuração da janela
		setTitle("Criptografia de Vigenere");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		// Texto
		lblTexto.setBounds(10, 10, 200, 20);
		add(lblTexto);
		jspTexto.setBounds(10, 30, 760, 150);
		add(jspTexto);
		txtTexto.setLineWrap(true);
		
		// Senha
		lblSenha.setBounds(10, 190, 200, 20);
		add(lblSenha);
		txtSenha.setBounds(10, 210, 200, 20);
		add(txtSenha);
		
		// Criptograma
		lblCriptograma.setBounds(10, 240, 200, 20);
		add(lblCriptograma);
		jspCriptograma.setBounds(10, 260, 760, 150);
		add(jspCriptograma);
		txtCriptograma.setLineWrap(true);
		
		// Botões
		btnEncriptar.setBounds(310, 420, 100, 30);
		add(btnEncriptar);
		btnEncriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCriptograma.setText(
				CriptografiaVigenere.encriptar(txtTexto.getText(),
											   txtSenha.getText()));
			}
		});
		
		btnDecriptar.setBounds(430, 420, 100, 30);
		add(btnDecriptar);
		btnDecriptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTexto.setText(
				CriptografiaVigenere.decriptar(txtCriptograma.getText(),
											   txtSenha.getText()));
			}
		});
		
		btnLimpar.setBounds(550, 420, 100, 30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTexto.setText("");
				txtSenha.setText("");
				txtCriptograma.setText("");
			}
		});
		
		btnSair.setBounds(670, 420, 100, 30);
		add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}