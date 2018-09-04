import java.util.*;

public class TrainTicketMachine{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int i,j,k = 0;
		boolean exit = false;
		
		// Create DB
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
		
		//Create dictionary
		List<String> dict = new ArrayList<String>();
		dict.add("A");
		dict.add("B");
		dict.add("C");
		dict.add("D");
		dict.add("E");
		dict.add("");
		dict.add("");
		dict.add("F");
		dict.add("G");
		dict.add("H");
		dict.add("I");
		dict.add("J");
		dict.add("");
		dict.add("");
		dict.add("K");
		dict.add("L");
		dict.add("M");
		dict.add("N");
		dict.add("O");
		dict.add("");
		dict.add("");
		dict.add("P");
		dict.add("Q");
		dict.add("R");
		dict.add("S");
		dict.add("T");
		dict.add("");
		dict.add("");
		dict.add("U");
		dict.add("V");
		dict.add("W");
		dict.add("X");
		dict.add("Y");
		dict.add("");
		dict.add("");
		dict.add("Z");
		dict.add("");
		dict.add("");
		dict.add("");
		dict.add("");
		dict.add("");
		dict.add("");
		
		//Create the limited table. Solution not expansible.
		String[][] table = new String[6][7];
		
		for(i=0;i<6;i++){
			for(j=0;j<7;j++){
				table[i][j] = dict.get(k);
				k++;
			}
		}
		
		while(exit == false){
			
			System.out.println("	':q' to exit!	");	
			System.out.print("Input: ");
			
			//read Input
			String name = in.nextLine();
			
			//exit validation
			if(name.equals(":q")){
				exit = true;
				break;
			}
			
			//check if there are valid stations, updating the table with suggestions and highlithed letters (with '')
			stationValid(name, station_list, table);
			
			printTable(table);
			
			//clean table for new search
			formatTable(table, dict);
			
		}
	}
	
    	public static void stationValid(String name, List<String> station_list, String[][] table){
    		int i,j,k = 0;
    		int matches = 0;
    		
    		// tabela[x][6] -> coluna das sugestões
    		for (i=0; i < station_list.size(); i++){
    			j = 0;
    			if(name.length()<=station_list.get(i).length()){
				if (name.toUpperCase().equals(station_list.get(i).substring(0,name.length()))){
					while(j < 6){
						if(table[j][6].equals("")){
							table[j][6] = station_list.get(i);
							matches += 1; //incrementador para limpar no fim da pesquisa
							j = 6;
						}
						else{
							j++;
						}						
					}
					// If input = station, no letters are suggested
					if(name.length() != station_list.get(i).length()){
						String letter = String.valueOf(station_list.get(i).charAt(name.length()));
						updateTableLetter(table, letter);
					}
				}
			}
		}

    	}
    	
    	public static void updateTableLetter(String[][] table, String letter){
    		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				if(letter.equals(table[i][j]))
					table[i][j] = "'"+letter+"'";
			}
		}
    	}
    	
	public static void printTable(String[][] table) {
        	for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				System.out.print(table[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
        System.out.println();
    	}
	
    	public static void formatTable(String[][] table, List<String> dict){
    		int k = 0;
    		for(int i=0;i<6;i++){
			for(int j=0;j<7;j++){
				table[i][j] = dict.get(k);
				k++;
			}
		}
    	}
}
