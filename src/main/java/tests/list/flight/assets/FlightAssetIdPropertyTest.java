package tests.list.flight.assets;

import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
import utils.SampleTestCase;
import utils.TestCaseStatus;

@Slf4j
public class FlightAssetIdPropertyTest extends SampleTestCase {

    @Override
    public String getPropertyName() {
        return "/id";
    }

    @Override
    public TestCaseStatus verify(OutputUnit outputUnit) {
        if (!outputUnit.isValid()) {

            log.error(generateErrorMessage(outputUnit, getPropertyName()));
            return TestCaseStatus.FAILED;
        }

        return TestCaseStatus.PASSED;
    }
}



