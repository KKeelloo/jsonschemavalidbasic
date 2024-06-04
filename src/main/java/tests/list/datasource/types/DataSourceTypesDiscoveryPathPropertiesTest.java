package tests.list.datasource.types;

import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
import utils.SampleTestCase;
import utils.TestCaseStatus;

@Slf4j
public class DataSourceTypesDiscoveryPathPropertiesTest extends SampleTestCase {
    @Override
    public String getPropertyName() {
        return "/datasource_types/datasource_types/discovery/pathProperties";
    }

    @Override
    public TestCaseStatus verify(OutputUnit outputUnit) {

        if (!outputUnit.isValid()) {

            log.error(generateErrorMessage(outputUnit, getPropertyName()));
            return TestCaseStatus.FAILED;
        }

        log.info(generateValidMessage(outputUnit, getPropertyName()));
        return TestCaseStatus.PASSED;
    }
}
