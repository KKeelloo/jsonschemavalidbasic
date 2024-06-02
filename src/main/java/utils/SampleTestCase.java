package utils;

import com.networknt.schema.output.OutputUnit;

public abstract class SampleTestCase {

    public abstract TestCaseStatus verify(OutputUnit outputUnit);

    public String getPropertyName() {
        return "default_name";
    }

    public String description() {
        return String.format("Verify %s of list_datasource_types", getPropertyName());
    }

    protected String generateErrorMessage(OutputUnit outputUnit, String propertyName) {

        if (outputUnit.getErrors() == null) {
            return String.format("Verification failed for property \"%s\" in location %s", propertyName, outputUnit.getInstanceLocation());
        } else {
            return String.format("Verification failed for property \"%s\" with errors %s in location %s", propertyName,
                    outputUnit.getErrors().toString(), outputUnit.getInstanceLocation());
        }
    }

}
