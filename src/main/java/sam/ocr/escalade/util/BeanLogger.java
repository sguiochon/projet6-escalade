package sam.ocr.escalade.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

/**
 * A simple implementation of a <tt>BeanPostProcessor</tt> that logs every bean
 * created by Spring. This logger allows you to see what beans have been setup.
 * <p>
 */
@Component
public class BeanLogger implements BeanPostProcessor {

    protected Logger logger;
    protected boolean enabled = false;

    public BeanLogger() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        // Nothing to do. Must return the bean or we lose it!
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (!enabled)
            return bean; // Must return the bean or we lose it!

        // Display the bean. If it is Ordered, print its order also. Several MVC
        // classes are chained by Order and it is often useful to see what order
        // they are configured to run.
        if (bean instanceof Ordered) {
            String order = (bean instanceof Ordered) ? String
                    .valueOf(((Ordered) bean).getOrder()) : "unknown";
            logger.info(bean.getClass().getName() + " - Order: " + order);
        } else {
            logger.info(bean.getClass().getName());
        }

        // Since we are concerned with exception-resolvers, lets print extra
        // info about this one. It delegates in turn to all the default
        // resolvers - see "Going Deeper" in the Blog for more details.
        if (bean instanceof HandlerExceptionResolverComposite) {
            logger.info("   resolvers: "
                    + ((HandlerExceptionResolverComposite) bean)
                    .getExceptionResolvers());
        }

        // Must return the bean or we lose it!
        return bean;
    }

}
