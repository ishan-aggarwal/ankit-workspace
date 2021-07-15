package kwic2;

import java.io.IOException;

public class MasterControl {

	public void start() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		System.out.println("Process Started...");

		ReadProperties readProperties = new ReadProperties("config.properties");
		LineStorage lineStorage = new LineStorage();
		
		Object input = Class.forName(readProperties.getProperties().getProperty("input").trim()).newInstance();
		if(input instanceof FileInput){
			((FileInput) input).readInput(lineStorage);
		} else if(input instanceof ConsoleInput){
			((ConsoleInput) input).readInput(lineStorage);
		}
		
		Object aShifter = Class.forName(readProperties.getProperties().getProperty("circshfit").trim()).newInstance();
		
		if(aShifter instanceof StopWordShift){
			((StopWordShift) aShifter).shiftALine(lineStorage, readProperties.getProperties().getProperty("stopwords"));
		} else if(aShifter instanceof NoStopWordShift){
			((NoStopWordShift) aShifter).shiftALine(lineStorage, readProperties.getProperties().getProperty("stopwords"));
		}
		
		Object cShifter = Class.forName(readProperties.getProperties().getProperty("sort").trim()).newInstance();
		if(cShifter instanceof NonCaseSensitive){
			((NonCaseSensitive) cShifter).sortByAlpha((CircularShifter) aShifter);
		} else if(cShifter instanceof CaseSensitive){
			((CaseSensitive) cShifter).sortByAlpha((CircularShifter) aShifter);
		}
		
		Object output = Class.forName(readProperties.getProperties().getProperty("output").trim()).newInstance();
		if(output instanceof FileOutput){
			((FileOutput) output).outputToFile((Alphabatizer) cShifter);
		} else if(output instanceof ConsoleOutput){
			((ConsoleOutput) output).outputToFile((Alphabatizer) cShifter);
		}
		System.out.println("Process Ended...");
	}

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {

		MasterControl MasterControl = new MasterControl();
		MasterControl.start();
	}
}
