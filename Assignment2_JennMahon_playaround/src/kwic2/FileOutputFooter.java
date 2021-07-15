package kwic2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileOutputFooter extends OutputDecorator {

	private String footer;

	public FileOutputFooter() {
		super(null);
	}

	public void setOutput(Output output) {
		this.output = output;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	@Override
	public void output(Alphabatizer aSorter) {
		super.output(aSorter);
		// write footer here
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(new File("./kwic_output.txt"), true));
			pw.write(footer + "\n");

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
