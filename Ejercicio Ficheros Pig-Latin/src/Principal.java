import java.io.*;
public class Principal {
	
	public static String generarPalabra(String linea) {
		String result="";
		if(((linea.charAt(0) == 'L' || linea.charAt(0) == 'l') && linea.charAt(1) == 'l')||((linea.charAt(0) == 'C' || linea.charAt(0) == 'c') && linea.charAt(1) == 'h')) {
			for (int i = 2; i < linea.length(); i++) {
				result+=linea.charAt(i);
			}
			result+=(linea.charAt(0)+String.valueOf(linea.charAt(1))+"a");
			return result;
		}else {
			for (int i = 1; i < linea.length(); i++) {
				result+=linea.charAt(i);
			}
			result+=(linea.charAt(0)+"a");
			return result;		
		}
	}
	
	public static void generarf2(File f, File f2) throws IOException {
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(f2,true);
		PrintWriter pw = new PrintWriter(fw);
		
		String linea=br.readLine();
		while(linea!=null) {
			String[] arr = linea.split(" ");
			for (int i = 0; i < arr.length; i++) {
				String palabra=generarPalabra(arr[i]);
				pw.print(palabra+" ");
			}
			pw.println();
			linea=br.readLine();
		}
		pw.close();
		fw.close();
		br.close();
		fr.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		File f= new File("entrada.txt");
		File f2 = new File("salida.txt");
		if(f2.exists()) {
			f2.delete();
		}
		generarf2(f,f2);
	}

}
