package io.penguinstats.api;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import io.penguinstats.dao.MongoConnection;

@WebListener
public class PenguinStatsContextListener implements ServletContextListener {

	MongoConnection conn = MongoConnection.getInstance();

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		conn.close();
		System.out.println("PenguinStatsContextListener destroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		conn.init();
		System.out.println("PenguinStatsContextListener started");
	}

}
