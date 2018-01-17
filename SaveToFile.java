
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveToFile {

	String path = "";
	PrintWriter pWriter=createFile(path);

	PrintWriter createFile(String path) {
		this.path=path;
		try
		{
			File file = new File(path);
			PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
			return pWriter;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	void printToFile(String x, PrintWriter pWriter) {
		this.pWriter=pWriter;

		pWriter.println(x);
	}

	void addSpace() {
		this.pWriter.println();
	}
}
