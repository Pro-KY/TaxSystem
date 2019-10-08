package ua.training.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SentDateTag extends TagSupport {
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int doStartTag() {
        JspWriter jspWriter = pageContext.getOut();

        try {
            Date date=new Date(timestamp.getTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd (HH:mm)", Locale.getDefault());
            String dateString = format.format(date);
            jspWriter.println(dateString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
