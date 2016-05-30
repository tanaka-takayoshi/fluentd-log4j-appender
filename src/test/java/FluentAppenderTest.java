
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

public class FluentAppenderTest {

	private final Logger log = Logger.getLogger(getClass());

	@Test
	@Ignore("Bad test, connecting to real fluentd service... :-(")
	public void test() {
		log.info("Test log message2");
	}

}
