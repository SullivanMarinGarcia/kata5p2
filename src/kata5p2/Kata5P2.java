package kata5p2;

import kata5p2.view.*;
import java.io.IOException;
import java.util.List;
import kata5p2.model.*;

public class Kata5P2 {

    public static void main(String[] args) throws IOException {
       MailListReaderBD database = new MailListReaderBD();
       MailHistogramBuilder.build(database.read());
       HistogramDisplay display = new HistogramDisplay(MailHistogramBuilder.build(database.read()));
        display.execute();
    }
}