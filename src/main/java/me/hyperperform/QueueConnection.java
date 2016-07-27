package me.hyperperform;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.Serializable;

/**
 * Created by rohan on 2016/07/23.
 */

public class QueueConnection
{
    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    // @Resource(lookup = "java:/jms/queue/hyperperform")
    // private Destination destination;

    private Connection connection;
    private Session session;

    private MessageProducer messageProducer;
    private MessageConsumer messageConsumer;

    @PostConstruct
    public void initConnection() throws Exception
    {
       System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        // System.out.println("-------------------------------------------------");
        // System.out.println("Connecting to messaging queue");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("hyperperform");   

        messageProducer = session.createProducer(destination);
        messageConsumer = session.createConsumer(destination);

        // System.out.println("ConnectionFactory: " + connectionFactory);
        // System.out.println("Destination: " + destination);
        // System.out.println("Connection: " + connection);
        // System.out.println("Session: " + session);
        // System.out.println("MessageProducer: " + messageProducer);
        // System.out.println("MessageConsumer: " + messageConsumer);
        // System.out.println("-------------------------------------------------");


        connection.start();
    }

    @PreDestroy
    public void disconnect() throws JMSException
    {
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
