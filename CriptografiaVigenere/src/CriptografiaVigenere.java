public class CriptografiaVigenere {
	// Propriedades da classe
	
	// Métodos da classe
	public static String encriptar(String texto, String senha) {
		String criptograma = "";
		
		for (int i = 0 ; i < texto.length() ; i++) {
			int caractereTexto = texto.charAt(i);
			int caractereSenha = senha.charAt(i % senha.length());
			int caractereCriptograma = (caractereTexto ^ caractereSenha);
			
			String temp = Integer.toHexString(caractereCriptograma);
			temp = (((temp.length() == 2) ? "" : "0") + temp);
			criptograma += (temp);
		}
		
		return criptograma;
	}
	
	public static String decriptar(String criptograma, String senha) {
		String texto = "";
		
		for (int i = 0 ; i < criptograma.length() ; i+=2) {
			int caractereCriptograma =
					Integer.parseInt(criptograma.substring(i, i + 2), 16); 
			int caractereSenha = senha.charAt((i/2) % senha.length());
			int caractereTexto = (caractereCriptograma ^ caractereSenha);
			
			texto += ((char) caractereTexto);
		}
		
		return texto;
	}
}