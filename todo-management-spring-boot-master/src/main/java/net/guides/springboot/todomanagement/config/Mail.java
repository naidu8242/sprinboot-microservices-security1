package net.guides.springboot.todomanagement.config;
 
import java.util.Date;
import java.util.List;
import java.util.Map;
 
public class Mail {
 
    private String mailFrom;
 
    private String mailTo;
 
    private String mailCc;
 
    private String mailBcc;
 
    private String mailSubject;
 
    private String mailContent;
 
    private String contentType;
    
    private String senderName;
 
    private Map<String, String> model;

    
    private List < Object > attachments;
 
    public Mail() {
        contentType = "text/plain";
    }
 
    public String getContentType() {
        return contentType;
    }
 
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
 
    public String getMailBcc() {
        return mailBcc;
    }
 
    public void setMailBcc(String mailBcc) {
        this.mailBcc = mailBcc;
    }
 
    public String getMailCc() {
        return mailCc;
    }
 
    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }
 
    public String getMailFrom() {
        return mailFrom;
    }
 
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }
 
    public String getMailSubject() {
        return mailSubject;
    }
 
    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }
 
    public String getMailTo() {
        return mailTo;
    }
 
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }
 
    public Date getMailSendDate() {
        return new Date();
    }
 
    public String getMailContent() {
        return mailContent;
    }
 
    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }
 
    public List < Object > getAttachments() {
        return attachments;
    }
 
    public void setAttachments(List < Object > attachments) {
        this.attachments = attachments;
    }

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public Map<String, String> getModel() {
		return model;
	}

	public void setModel(Map<String, String> model) {
		this.model = model;
	}
    
}