package tests.list.flight.assets;

import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
import utils.SampleTestCase;
import utils.TestCaseStatus;

@Slf4j
public class FlightAssetPathPropertyTest extends SampleTestCase {
    private static final String propertyName = "path";

    @Override
    public TestCaseStatus verify(OutputUnit outputUnit) {
        if (!outputUnit.isValid()) {

            log.error(generateErrorMessage(outputUnit, propertyName));
            return TestCaseStatus.FAILED;
        }

        return TestCaseStatus.PASSED;
    }
}
