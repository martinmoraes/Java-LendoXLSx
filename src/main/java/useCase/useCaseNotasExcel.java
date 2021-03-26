package useCase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Nota;

public class useCaseNotasExcel {

	public void excute(String caminhoArquivo) throws IOException {

		FileInputStream arquivo = new FileInputStream(new File(caminhoArquivo));

//		HSSFWorkbook workbook = new HSSFWorkbook(arquivo);
//		HSSFSheet sheetAlunos = workbook.getSheetAt(0);

		XSSFWorkbook  workbook = new XSSFWorkbook(arquivo);
		XSSFSheet sheetAlunos = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheetAlunos.iterator();

		ArrayList<Nota> listaNotas = this.iteraLinhas(rowIterator);

		System.out.println(listaNotas);
		workbook.close();
		arquivo.close();
	}

	private ArrayList<Nota> iteraLinhas(Iterator<Row> rowIterator) {
		ArrayList<Nota> listaNotas = new ArrayList<Nota>();
		boolean temCabecalho = true;

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			if (temCabecalho) {
				temCabecalho = false;
				continue;
			}

			Iterator<Cell> cellIterator = row.cellIterator();
			Nota notas = this.iteraColunas(cellIterator);
			listaNotas.add(notas);
		}
		return listaNotas;
	}

	private Nota iteraColunas(Iterator<Cell> cellIterator) {
		Nota nota = new Nota();

		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();

			switch (cell.getColumnIndex()) {
			case 0:
				nota.setNome(cell.getStringCellValue());
				break;
			case 1:
				nota.setRA(String.valueOf(cell.getNumericCellValue()));
				break;
			case 2:
				nota.setNota01(cell.getNumericCellValue());
				break;
			case 3:
				nota.setNota02(cell.getNumericCellValue());
				break;
			case 4:
				nota.setMedia(cell.getNumericCellValue());
				break;

			}

		}
		return nota;
	}
}
