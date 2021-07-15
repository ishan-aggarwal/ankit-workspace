package kwic2;

import java.lang.reflect.InvocationTargetException;

public class MasterControl {

	public void start() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
		System.out.println("Process Started...");
		ClassLoaderUtil classLoaderUtil = new ClassLoaderUtil();

		ReadProperties readProperties = new ReadProperties("config.properties");
		LineStorage lineStorage = new LineStorage();

		Input input = (Input) classLoaderUtil.getInstance(readProperties.getProperties().getProperty("input"));
		input.readInput(lineStorage);

		CircularShifter circularShifter = (CircularShifter) classLoaderUtil.getInstance(readProperties.getProperties().getProperty("circshfit"));
		circularShifter.shiftALine(lineStorage, readProperties.getProperties().getProperty("stopwords"));

		Alphabatizer alphabatizer = (Alphabatizer) classLoaderUtil.getInstance(readProperties.getProperties().getProperty("sort"));
		alphabatizer.sortByAlpha(circularShifter);

		// kwic2.FileOutputHeader
		FileOutputHeader fileOutputHeader = (FileOutputHeader)  classLoaderUtil.getInstance(readProperties.getProperties().getProperty("fileheader"));
		FileOutputFooter fileOutputFooter = (FileOutputFooter) classLoaderUtil.getInstance(readProperties.getProperties().getProperty("filefooter"));
		String headerText = readProperties.getProperties().getProperty("headercopy");
		String footerText = readProperties.getProperties().getProperty("footercopy");

		fileOutputHeader.setHeader(headerText);
		fileOutputFooter.setFooter(footerText);

		Output output = (Output) classLoaderUtil.getInstance(readProperties.getProperties().getProperty("output"));
		if (output instanceof FileOutput) {
			// ((FileOutput) output).output((Alphabatizer) cShifter);
			fileOutputHeader.setOutput(output);
			fileOutputFooter.setOutput(fileOutputHeader);
			fileOutputFooter.output(alphabatizer);
		} else if (output instanceof ConsoleOutput) {
			output.output(alphabatizer);
		}
		System.out.println("Process Ended...");
	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
		MasterControl MasterControl = new MasterControl();
		MasterControl.start();
	}
}
