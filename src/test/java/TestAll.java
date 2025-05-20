/**
 * Application de JUnit Suites pour lancer une suite de tests
 * dan une seule classe
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({VoitureTest.class, ServiceTest.class})
public class TestAll {


}
