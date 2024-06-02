import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.io.Resources;
import com.networknt.schema.*;
import com.networknt.schema.output.OutputUnit;
import utils.ListDataSourceTypeTest;
import utils.ListFlightsTest;
import utils.TestCaseGroup;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;


public class JsonVerifyCheck {
    public static void main(String[] args) throws IOException {

        // to print errors in english
        Locale.setDefault(Locale.ENGLISH);

        if (args.length >= 3) {
            Path schemaPath = Path.of(args[1]);
            System.out.println(schemaPath.toAbsolutePath());
            String schemaString = Files.readString(schemaPath);

            Path jsonPath = Path.of(args[2]);
            String jsonString = Files.readString(jsonPath);

            List<OutputUnit> validationResult = networkntCheckAndReturnDetails(schemaString, jsonString);

            TestCaseGroup listFlightsTest = getTestCaseGroup(args[0]);
            if (listFlightsTest == null) {
                System.out.println("Incorrect test case group name");
                return;
            }
            listFlightsTest.setValidationResult(validationResult);
            listFlightsTest.test();
            return;
        }

        //If no arguments passed get files from resources
        URL datasourceTypesSchemaURL = Resources.getResource("schemas/datasource_types.schema.json");
        String datasourceTypesSchemaString = Resources.toString(datasourceTypesSchemaURL, StandardCharsets.UTF_8);

        URL testDatasourceTypesJsonURL = Resources.getResource("test_datasource_invalid.json");
        String testDatasourceTypesJsonString = Resources.toString(testDatasourceTypesJsonURL, StandardCharsets.UTF_8);

        URL listFlightsSchemaURL = Resources.getResource("schemas/flight_asset_descriptor.schema.json");
        String listFlightsSchemaString = Resources.toString(listFlightsSchemaURL, StandardCharsets.UTF_8);

        URL listFlightsTestURL = Resources.getResource("test_list_flights_invalid.json");
        String listFlightsTestString = Resources.toString(listFlightsTestURL, StandardCharsets.UTF_8);

        ListDataSourceTypeTest dataSourceTypeTest = new ListDataSourceTypeTest();
        dataSourceTypeTest.setValidationResult(validationResult);
        dataSourceTypeTest.test();

        ListFlightsTest listFlightsTest = new ListFlightsTest();
        listFlightsTest.setValidationResult(listFlightsValidationResult);
        listFlightsTest.test();
    }

    private static TestCaseGroup getTestCaseGroup(String name) {
        switch (name) {
            case "ListFlights":
                return new ListFlightsTest();
            case "DatasourceTypes":
                return new ListDataSourceTypeTest();
            default:
                return null;
        }
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
