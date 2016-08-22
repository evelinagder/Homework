package task1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountCommas implements Runnable {
	
	File file;
	
	CountCommas(File file){
		this.file=file;
		
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is reading file. ");
		try(FileReader fr = new FileReader(file)) {
			int simvol = fr.read();
			int commas = 0;
			while(simvol != -1){
				char bukva = (char) simvol;
				if(bukva == ','){
					commas++;
				}
				simvol = fr.read();
			}
			System.out.println("Commas "+commas);
		} catch (IOException e) {
			System.out.println("Error reading file");
		}

	}
}
