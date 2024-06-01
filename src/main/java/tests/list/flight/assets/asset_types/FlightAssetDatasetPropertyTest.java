package tests.list.flight.assets.asset_types;

import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
import utils.SampleTestCase;
import utils.TestCaseStatus;

@Slf4j

public class FlightAssetDatasetPropertyTest extends SampleTestCase {
    private static final String propertyName = "asset_type/dataset";

    @Override
    public TestCaseStatus verify(OutputUnit outputUnit) {
        if (!outputUnit.isValid()) {

            log.error(generateErrorMessage(outputUnit, propertyName));
            return TestCaseStatus.FAILED;
        }

        return TestCaseStatus.PASSED;
    }
}
