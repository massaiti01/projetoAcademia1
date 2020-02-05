package br.com.projetoAcademia.dao;

import br.com.projetoAcademia.model.Pessoa;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailDAOImpl {

    public Boolean EnviarEmail(Object object) {
        Pessoa pessoa = (Pessoa) object;
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtpout.secureserver.net");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("contato@dataprojects.com.br",
                        "DataM2nmxsee");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("contato@dataprojects.com.br"));
            //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse("contato@dataprojects.com.br");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Usuario Acabou de se Cadastrar");//Assunto
            message.setText("Usuario:" + pessoa.getNomePessoa() + " acabou de se cadastrar com o Email:" + pessoa.getEmailPessoa());
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
