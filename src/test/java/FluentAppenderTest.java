

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

public class FluentAppenderTest {

	private Logger log = Logger.getLogger(getClass());
	
	@Test
	public void test() {
		log.info("Test log message2");
	}

}
