package app.core.sessions;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SessionContext {
	
	@Autowired
	private ApplicationContext ctx;
	private Map<String, Session> sessions = new ConcurrentHashMap<String, Session>();
	private Timer timer = new Timer();
	@Value("${session.remove.expired.period:20}")
	private int removeExpiredSessionsPeriod;
	
	private boolean isSessionExpired(Session session) {
		long now = System.currentTimeMillis();
		long lasAcccessed = session.getLastAccessed();
		long maxInactiveInterval = session.getMaxInactiveInterval();
		return now - lasAcccessed > maxInactiveInterval;
	}
	
	@PostConstruct
	private void init() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//System.out.println("removing expired sessions");
				for (String token : sessions.keySet()) {
					Session session = sessions.get(token);
					if (isSessionExpired(session)) {
						invalidate(session);
					}
				}
			}
			
		};
		timer.schedule(task,3000, TimeUnit.SECONDS.toMillis(removeExpiredSessionsPeriod));
		System.out.println("session removal thread started");
	}
	
	@PreDestroy
	private void destroy() {
		timer.cancel();
		System.out.println("session removal thread stopped");
	}
	
	public Session createSession(String email) {
		Session session = getSessionByEmail(email);
		if (session != null) {
			session.resetLastAccessed();
			return session;
		}
		session = ctx.getBean(Session.class);
		sessions.put(session.token, session);
		return session;
	}
	
	public void invalidate(Session session) {
		sessions.remove(session.token);
	}
	
	public Session getSession(String token) {
		Session session = sessions.get(token);
		if (session != null) {
			if (!isSessionExpired(session)) {
				session.resetLastAccessed();
				return session;
			} else {
				invalidate(session);
				return null;
			}
		} else {
			return null;
		}
	}
	
	private Session getSessionByEmail(String email) {
		Iterator<Entry<String, Session>> iterator = sessions.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Session> entry =  iterator.next();
			if (entry.getValue().getAttribute("email")!= null && entry.getValue().getAttribute("email").equals(email)) {
				return entry.getValue();
			}
		}
		return null;
	}
}
