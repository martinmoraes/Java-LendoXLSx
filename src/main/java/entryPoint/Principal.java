package entryPoint;

import java.io.IOException;

import useCase.useCaseNotasExcel;

public class Principal {

	public static void main(String[] args) throws IOException {
		// https://www.devmedia.com.br/apache-poi-manipulando-documentos-em-java/31778
		
		String arquivo = System.getProperty("user.dir") + "\\data\\notas.xlsx";
		new useCaseNotasExcel().excute(arquivo);
		
	}

}
