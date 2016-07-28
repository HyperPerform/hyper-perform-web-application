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
 * Provides a connection to the messaging queue handled by application server. Queues are looked up using JNDI lookups.
 * This components is only used by message producers, i.e the event listeners.
 */

public class QueueConnection
{
    @Resource(lookup = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    private Connection connection;
    private Session session;

    private MessageProducer messageProducer;

    /**
     * A method that is called when the class has been constructed. It connects to the messaging queue and retrieves the
     * destination queue on which objects will be placed.
     * @throws JMSException
     */
    @PostConstruct
    public void initConnection() throws JMSException
    {
       System.setProperty("org.apache.activemq.SERIALIZABLE_PACKAGES","*");

        connection = connectionFactory.createConnection();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("hyperperform");   

        messageProducer = session.createProducer(destination);
    }

    /**
     * Called when the object is about to be destroyed. This method ensures that existing connections to the messaging
     * queue service are closed.
     * @throws JMSException
     */
    @PreDestroy
    public void disconnect() throws JMSException
    {
        session.close();
        connection.close();
    }

    /**
     * Simple method used to place an object onto the queue.
     * @param event A Serializable object that is to be placed onto the queue.
     * @throws JMSException
     */
    public void sendObject(Serializable event) throws JMSException
    {
        messageProducer.send(session.createObjectMessage(event));
    }

    /**
     * Getter for the MessageProducer object.
     * @return Returns instance of a MessageProducer object
     */
    public MessageProducer getMessageProducer() {
        return messageProducer;
    }

    /**
     * Getter for current session.
     * @return Returns instance of current session.
     */
    public Session getSession() {
        return session;
    }
}
