import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.io.Resources;
import com.networknt.schema.*;
import com.networknt.schema.output.OutputUnit;
import utils.ListDataSourceTypeTest;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;


public class JsonVerifyCheck {

    public static void main(String[] args) throws IOException {

        // to print errors in english
        Locale.setDefault(Locale.ENGLISH);

        URL datasourceTypesURL = Resources.getResource("schemas/datasource_types.schema.json");
        String dataSourceTypesString = Resources.toString(datasourceTypesURL, StandardCharsets.UTF_8);

        URL testdatasourceTypesURL = Resources.getResource("test_datasource_2.json");
        String testdataSourceTypesString = Resources.toString(testdatasourceTypesURL, StandardCharsets.UTF_8);

        List<OutputUnit> validationResult = networkntCheckAndReturnDetails(dataSourceTypesString, testdataSourceTypesString);


        System.out.println(validationResult);

        ListDataSourceTypeTest dataSourceTypeTest = new ListDataSourceTypeTest();
        dataSourceTypeTest.setValidationResult(validationResult);
        dataSourceTypeTest.test();
    }

    private static List<OutputUnit> networkntCheckAndReturnDetails(String dataSourceTypesString, String testdataSourceTypesString) throws JsonProcessingException {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        config.setPathType(PathType.JSON_POINTER);
        //config.setApplyDefaultsStrategy(new ApplyDefaultsStrategy(true, true, true) );
        JsonSchema schema = jsonSchemaFactory.getSchema(dataSourceTypesString, config);
        OutputUnit outputUnit = schema.validate(testdataSourceTypesString, InputFormat.JSON, OutputFormat.LIST, executionContext -> {
            // By default since Draft 2019-09 the format keyword only generates annotations and not assertions
            executionContext.getExecutionConfig().setFormatAssertionsEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionFilter(keyword -> true);
        });
        return outputUnit.getDetails();
    }
}
