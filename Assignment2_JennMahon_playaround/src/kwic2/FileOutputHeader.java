package kwic2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileOutputHeader extends OutputDecorator {

	private String header;

	public FileOutputHeader() {
		super(null);
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public void output(Alphabatizer aSorter) {

		// output.output(aSorter);

		// write footer here
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("./kwic_output.txt")));
			pw.write(header + "\n");

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		super.output(aSorter);

	}

}
