package Services;

import java.util.Properties;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

public class EmailService {

    private static String _host = "imap.gmail.com";
    private static String _port = "993";

    /* Use to clean INBOX folder */
    public static void clean(String user, String password, String folder)
    {
        Properties properties = new Properties();

        properties.put("mail.imap.host", _host);
        properties.put("mail.imap.port", _port);

        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port", String.valueOf(_port));

        Session session = Session.getDefaultInstance(properties);

        try {
            Store store = session.getStore("imap");
            store.connect(user, password);

            Folder folderInbox = store.getFolder(folder);
            folderInbox.open(Folder.READ_WRITE);

            Message[] arrayMessages = folderInbox.getMessages();

            for (int i = 0; i < arrayMessages.length; i++) {
                Message message = arrayMessages[i];
                String subject = message.getSubject();
                message.setFlag(Flags.Flag.DELETED, true);
            }

            boolean expunge = true;
            folderInbox.close(expunge);

            store.close();

        } catch (NoSuchProviderException ex) {
            System.out.println("No provider.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store.");
            ex.printStackTrace();
        }
    }
}