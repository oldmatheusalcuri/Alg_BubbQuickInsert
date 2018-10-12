package $Menu_Dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeituraExcel {
	@SuppressWarnings({ "resource", "deprecation" })
	public int[] capturaExcel(){
		double soma = 0;
		int[] vetExcel = null; //Cria um vetor
		FileInputStream fisPlanilha = null; //Cria um objeto da classe FileInputStream
	
	    try 
	    {
	    	File file = new File("Dados aleat�rios 10k.xlsx"); //Busca o arquivo (que est� salvo na pasta do projeto, afim de facilitar o trabalho)
	        fisPlanilha = new FileInputStream(file); //Atribui valor ao objeto de inputstream
	
	        XSSFWorkbook workbook = new XSSFWorkbook(fisPlanilha);	//Cria um workbook para verificar se o arquivo � mesmo um excel
	
	        XSSFSheet sheet = workbook.getSheetAt(0); //Seleciona a planilha que ser� lida. Note que a argumenta��o � de "Menu.planilha", a vari�vel classe
	        													  //que foi passada de Menu para c�, ela carrega a planilha referente ao g�s escolhido pelo usu�rio
	
	        Iterator<Row> rowIterator = sheet.iterator(); //Cria um iterator para as linhas
	        
	        int cont = sheet.getPhysicalNumberOfRows(); //Seleciona o n�mero que ser� o tamanho do vetor
	        
	        vetExcel = new int[cont]; //Denomina esse tamanho
	        
	        int aux = 0; //Uma vari�vel auxiliar que servir� para atribui��o de valores ao vetor em si
	        	
	        while (rowIterator.hasNext()) //Loop respons�vel pela leitura e por salvar os valores num�ricos das c�lulas no vetor
	        {
	        	Row row = rowIterator.next();
	
	            Iterator<Cell> cellIterator = row.iterator();
	
	            while (cellIterator.hasNext()) 
	            {
	            	Cell cell = cellIterator.next();
	                
	                switch (cell.getCellType()) //Entende qual o tipo do elemento da c�lula analisada e caso seja num�rico, salva no vetor
	                {
	                    case Cell.CELL_TYPE_NUMERIC:                      
	                        soma = soma + cell.getNumericCellValue();
	                        vetExcel[aux] = (int) cell.getNumericCellValue(); //Lhe � dado esse valor e salvo
	                        aux ++;
	                        break;    
	                }
	            }
	        }
	    }        
	    
	    //Tratamento de erros como n�o achar o arquivo, n�mero incorreto de planilha e demais poss�veis erros. Finally fecha a planilha (h� tratamento caso d� errado tamb�m)
	    catch (FileNotFoundException error1) 
	    {
	       
	        System.out.println("Erro na importa��o do local do arquivo. Por favor verifique se o caminho est� correto!\nErro: " +error1);
	        System.exit(0);
	    } 
	    catch (IOException error2) 
	    {
	        
	        System.out.println("Erro! " +error2);
	        System.exit(0);
	    }
		catch (IllegalArgumentException error3)
		{
			System.out.println("Erro na importa��o das planilhas do arquivo. Por favor verifique se sua formata��o est� correto!\nErro: " +error3);
			System.exit(0);
		}
	    finally 
	    {
	    	try 
	    	{
	    		fisPlanilha.close();
	        } 
	        catch (IOException error3) 
	    	{
	        	
	        	System.out.println("Erro ao fechar o programa!" + error3);
	        	System.exit(0);
	        }
	    }
	    return vetExcel; //Retorna o valor desse vetor para poder ser utilizado na classe Menu
	}
}
