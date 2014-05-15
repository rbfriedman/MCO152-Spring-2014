package friedman.flicker;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownloadFlickerFeedThreadTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		/*Step 1 - instantiate feedThread*/
		//Take 1
		FlickerFeedFrame frame=null;
		/*
		 * We don't want to have to create a whole app.
		 * so we use mockito.
		 * allow us to get past a NPE, but any method called 
		 * from the mockito object retuens default vals
		 */
		//verifies that load images is called
		//Take 2
		frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);
		
		//verification that load images has never been called
		VerificationMode never = Mockito.never();
		Mockito.verify(frame,never).loadImages(Mockito.any(FlickerFeed.class));
		/*Step 2 - run thread*/
		//We don't want this thread to execute a new thread(thread.start())
		thread.run();
		
		VerificationMode once = Mockito.timeout(1);
		
		
		Mockito.verify(frame,once).loadImages(Mockito.any(FlickerFeed.class));
		
		//Dependency Injection
		
	}

}
