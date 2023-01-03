package kata5p2.view;


import java.util.List;
import kata5p2.model.Mail;
import kata5p2.model.Histogram;

public class MailHistogramBuilder {

    public static Histogram<String> build(List<Mail> lista){
        Histogram<String> histogram = new Histogram<>();

        for (Mail mail : lista) {
            histogram.increment(mail.getDomain());
        }

        return histogram;
    }
}