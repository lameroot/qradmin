package com.qr.qradmin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    private final static Logger logger = LoggerFactory.getLogger(SessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        logger.trace("Session with id: [{}] created",event.getSession().getId());
        event.getSession().setMaxInactiveInterval(5*60);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        logger.trace("Session with id: [{}] is destroyed", event.getSession().getId());
    }
}
