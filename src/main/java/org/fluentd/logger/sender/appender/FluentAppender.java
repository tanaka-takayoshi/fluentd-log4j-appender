package org.fluentd.logger.sender.appender;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.fluentd.logger.FluentLogger;

public class FluentAppender extends AppenderSkeleton {

	private FluentLogger fluentLogger;

	private String tag = "log4j-appender";

	private String host = "localhost";

	private int port = 24224;

	private String label = "label";

	public void setTag(final String tag) {
		this.tag = tag;
	}

	public void setHost(final String host) {
		this.host = host;
	}

	public void setPort(final int port) {
		this.port = port;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	@Override
	public void activateOptions() {
		try {
			fluentLogger = FluentLogger.getLogger(tag, host, port);
		} catch (final RuntimeException e) {
			// addError("Cannot create FluentLogger.", e);
		}
		super.activateOptions();
	}

	@Override
	public void close() {
		try {
			fluentLogger.flush();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean requiresLayout() {
		return false;
	}

	@Override
	protected void append(final LoggingEvent event) {
		final Map<String, Object> messages = new HashMap<String, Object>();
		messages.put("level", event.getLevel().toString());
		messages.put("loggerName", event.getLoggerName());
		messages.put("thread", event.getThreadName());
		messages.put("message", event.getMessage().toString());
		fluentLogger.log(label, messages, event.getTimeStamp() / 1000);
	}

}
