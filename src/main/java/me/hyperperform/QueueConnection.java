package me.hyperperform;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import javax.jms.*;
import java.io.Serializable;

/**
 * Created by rohan on 2016/07/23.
 */

@Startup
@Singleton
public class QueueConnection
{
    private Connection connection;
    private Session session;

    private MessageProducer messageProducer;
    private MessageConsumer messageConsumer;

    @PostConstruct
    public void initConnection() throws JMSException
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Connecting to messaging queue");
        System.out.println("-------------------------------------------------");

        System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("hyperperform");

        messageProducer = session.createProducer(queue);
        messageConsumer = session.createConsumer(queue);

        connection.start();
    }

    @PreDestroy
    public void disconnect() throws JMSException
    {
        System.out.println("-------------------------------------------------");
        System.out.println("Disconnecting from messaging queue");
        System.out.println("-------------------------------------------------");

        connection.stop();
        session.close();
        connection.close();
    }

    public void sendObject(Serializable event) throws JMSException
    {
        messageProducer.send(session.createObjectMessage(event));
    }

    public Serializable receive() throws JMSException
    {
        ObjectMessage objectMessage = (ObjectMessage) messageConsumer.receive();
        return objectMessage.getObject();
    }

    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    public MessageConsumer getMessageConsumer() {
        return messageConsumer;
    }

    public Session getSession() {
        return session;
    }
}
