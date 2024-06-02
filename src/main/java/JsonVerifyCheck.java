import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.io.Resources;
import com.networknt.schema.*;
import com.networknt.schema.output.OutputUnit;
import lombok.extern.slf4j.Slf4j;
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


@Slf4j
public class JsonVerifyCheck {
    public static void main(String[] args) throws IOException {

        // to print errors in english
        Locale.setDefault(Locale.ENGLISH);

        if (args.length >= 2) {

            Path jsonPath = Path.of(args[1]);
            String jsonString = Files.readString(jsonPath);

            TestCaseGroup listFlightsTest = getTestCaseGroup(args[0]);
            if (listFlightsTest == null) {
                System.out.println("Incorrect test case group name");
                return;
            }

            String schemaString = getSchemaString(args[0]);
            List<OutputUnit> validationResult = networkntCheckAndReturnDetails(schemaString, jsonString);
            log.info(args[0] + " validation");
            listFlightsTest.setValidationResult(validationResult);
            listFlightsTest.test();
            log.debug(args[0] + validationResult);
            return;
        }

        //If no arguments passed get files from resources
        String datasourceTypesSchemaString = getSchemaString("DatasourceTypes");
        URL testDatasourceTypesJsonURL = Resources.getResource("test_datasource_invalid.json");
        String testDatasourceTypesJsonString = Resources.toString(testDatasourceTypesJsonURL, StandardCharsets.UTF_8);

        String listFlightsSchemaString = getSchemaString("ListFlights");
        URL listFlightsTestURL = Resources.getResource("test_list_flights_invalid.json");
        String listFlightsTestString = Resources.toString(listFlightsTestURL, StandardCharsets.UTF_8);

        log.info("DatasourceTypes validation");
        List<OutputUnit> dataSourceValidationResult = networkntCheckAndReturnDetails(datasourceTypesSchemaString, testDatasourceTypesJsonString);
        ListDataSourceTypeTest dataSourceTypeTest = new ListDataSourceTypeTest();
        dataSourceTypeTest.setValidationResult(dataSourceValidationResult);
        dataSourceTypeTest.test();
        log.debug("list_datasource_types validation results: " + dataSourceValidationResult);

        log.info("ListFlights validation");
        List<OutputUnit> listFlightsValidationResult = networkntCheckAndReturnDetails(listFlightsSchemaString, listFlightsTestString);
        ListFlightsTest listFlightsTest = new ListFlightsTest();
        listFlightsTest.setValidationResult(listFlightsValidationResult);
        listFlightsTest.test();
        log.debug("ListFlights validation results: " + listFlightsValidationResult);
    }

    private static String getSchemaString(String name) throws IOException {
        switch (name) {
            case "ListFlights":
                URL listFlightsSchemaURL = Resources.getResource("schemas/flight_asset_descriptor.schema.json");
                return Resources.toString(listFlightsSchemaURL, StandardCharsets.UTF_8);
            case "DatasourceTypes":
                URL datasourceTypesSchemaURL = Resources.getResource("schemas/datasource_types.schema.json");
                return Resources.toString(datasourceTypesSchemaURL, StandardCharsets.UTF_8);
            default:
                return null;
        }
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

    private static List<OutputUnit> networkntCheckAndReturnDetails(String validationSchema, String json) throws JsonProcessingException {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        config.setPathType(PathType.JSON_POINTER);
        //config.setApplyDefaultsStrategy(new ApplyDefaultsStrategy(true, true, true) );
        JsonSchema schema = jsonSchemaFactory.getSchema(validationSchema, config);
        OutputUnit outputUnit = schema.validate(json, InputFormat.JSON, OutputFormat.LIST, executionContext -> {
            // By default since Draft 2019-09 the format keyword only generates annotations and not assertions
            executionContext.getExecutionConfig().setFormatAssertionsEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionFilter(keyword -> true);
        });
        return outputUnit.getDetails();
    }
}
