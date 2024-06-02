package tests.list.datasource.types;

import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
import utils.SampleTestCase;
import utils.TestCaseStatus;

@Slf4j
public class AllowedAsTargetPropertyTest extends SampleTestCase {

    private static final String propertyName = "datasource_types/datasource_types/allowed_as_target";

    @Override
    public TestCaseStatus verify(OutputUnit outputUnit) {

        if (!outputUnit.isValid()) {

            log.error(generateErrorMessage(outputUnit, propertyName));
            return TestCaseStatus.FAILED;
        }

        log.info(generateValidMessage(outputUnit, propertyName));
        return TestCaseStatus.PASSED;
    }
}