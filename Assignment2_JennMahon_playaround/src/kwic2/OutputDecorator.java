package kwic2;

public class OutputDecorator implements Output {

	protected Output output;

	public OutputDecorator(Output output) {
		this.output = output;
	}

	@Override
	public void output(Alphabatizer aSorter) {
		output.output(aSorter);
	}
}
