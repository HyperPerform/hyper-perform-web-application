package me.hyperperform.esper;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by rohan on 2016/07/29.
 */
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "hyperperform")
})
public class EventsMessageListener  implements MessageListener
{
    public void onMessage(Message message)
    {
        try
        {
            if (message instanceof ObjectMessage)
                System.out.println(((ObjectMessage) message).getObject());
        }

        catch (JMSException j)
        {
            System.out.println("Failed to retrieve event from queue");
        }
    }
}
