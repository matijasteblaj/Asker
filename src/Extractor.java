
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Extractor {
	
	public HashMap<String, List<String>> slovar;
	public ArrayList<String> seznamSklopov;

	public Extractor(String path) {
		this.seznamSklopov = new ArrayList<String>();
		this.slovar = extract(path);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<String, List<String>> extract(String path) {
		HashMap<String, List<String>> slovar = new HashMap<String, List<String>>();
		String sklop = "Default";
		ArrayList<String> seznam = new ArrayList<String>();
		BufferedReader vhod;
		try {
			vhod = new BufferedReader(new FileReader(path + "/Vprasanja.txt"));
			while (vhod.ready()){
				 String vrstica = vhod.readLine();
				 if (!vrstica.startsWith("-")) {
					 if (vrstica.equals("")) {
						 continue;
					 }
					 if (!seznam.isEmpty()) {
						 slovar.put(sklop, (List<String>) seznam.clone());
					 }
					 sklop = vrstica;
					 seznamSklopov.add(sklop);
					 seznam.clear();
				 } else {
					 seznam.add(vrstica.substring(1));
				 }
			}
			vhod.close();
			slovar.put(sklop, (List<String>) seznam.clone());
		} catch (FileNotFoundException e1) {
			System.out.println("Nisem nasel datoteke");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return slovar;		
	}
	
	public ArrayList<String> returnAll() {
		ArrayList<String> vsaVprasanja = new ArrayList<String>();
		for (List<String> seznamVprasanj : slovar.values()) {
			for (String vprasanje : seznamVprasanj) {
				vsaVprasanja.add(vprasanje);
			}
		}
		return vsaVprasanja;
	}

}
