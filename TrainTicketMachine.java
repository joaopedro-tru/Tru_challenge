import java.util.*;

public class TrainTicketMachine{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int i,j,k = 0;
		boolean exit = false;
		
		List<String> station_list = new ArrayList<String>();
		station_list.add("DARTFORD");
		station_list.add("DARTMOUTH");
		station_list.add("TOWER HILL");
		station_list.add("DERBY");
		station_list.add("LIVERPOOL");
		station_list.add("LIVERPOOL LIME STREET");
		station_list.add("PADDINGTON");
		station_list.add("EUSTON");
		station_list.add("LONDON BRIDGE");
		station_list.add("VICTORIA");
		
		List<String> table = new ArrayList<String>();
		
		table.add("A");
		table.add("B");
		table.add("C");
		table.add("D");
		table.add("E");
		table.add("");
		table.add("");
		table.add("F");
		table.add("G");
		table.add("H");
		table.add("I");
		table.add("J");
		table.add("");
		table.add("");
		table.add("K");
		table.add("L");
		table.add("M");
		table.add("N");
		table.add("O");
		table.add("");
		table.add("");
		table.add("P");
		table.add("Q");
		table.add("R");
		table.add("S");
		table.add("T");
		table.add("");
		table.add("");
		table.add("U");
		table.add("V");
		table.add("W");
		table.add("X");
		table.add("Y");
		table.add("");
		table.add("");
		table.add("Z");
		table.add("");
		table.add("");
		table.add("");
		table.add("");
		table.add("");
		table.add("");
		
		String[][] tabela = new String[6][7];
		
		for(i=0;i<6;i++){
			for(j=0;j<7;j++){
				tabela[i][j] = table.get(k);
				k++;
			}
		}
		
		while(exit == false){
			
			formatTable(tabela, table);
			
			System.out.println("	':q' to exit!	");	
			System.out.print("Input: ");
			
			String name = in.nextLine();
			if(name.equals(":q")){
				exit = true;
				break;
			}
			
			stationValid(name, station_list, tabela);
		
			
		}
	}
	
	public static void printTable(String[][] tabela) {
        	for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				System.out.print(tabela[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
        System.out.println();
    	}
    	
    	
    	public static void stationValid(String name, List<String> station_list, String[][] tabela){
    		int i,j,k = 0;
    		int matches = 0;
    		
    		// tabela[x][6] -> coluna das sugestões
    		for (i=0; i < station_list.size(); i++){
    			j = 0;
			if (name.toUpperCase().equals(station_list.get(i).substring(0,name.length()))){
				while(j < 6){
					if(tabela[j][6].equals("")){
						tabela[j][6] = station_list.get(i);
						matches += 1; //incrementador para limpar no fim da pesquisa
						j = 6;
					}
					else{
						j++;
					}						
				}
				String letter = String.valueOf(station_list.get(i).charAt(name.length()));
				updateTableLetter(tabela, letter);
			}
		}
		//Imprimir tabela updated
		printTable(tabela);

    	}
    	
    	public static void updateTableLetter(String[][] tabela, String letter){
    		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(letter.equals(tabela[i][j]))
					tabela[i][j] = "'"+letter+"'";
			}
		}
    	}
    	
    	public static void formatTable(String[][] tabela, List<String> table){
    		int k = 0;
    		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				tabela[i][j] = table.get(k);
				k++;
			}
		}
    	}
}
