import com.fasterxml.jackson.core.JsonProcessingException;
import com.networknt.schema.*;
import com.networknt.schema.output.OutputUnit;
import com.networknt.schema.serialization.JsonMapperFactory;
//import io.vertx.core.json.JsonObject;
//import io.vertx.json.schema.*;
import com.google.common.io.Resources;
//import io.vertx.json.schema.JsonSchema;
//import io.vertx.json.schema.OutputFormat;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Set;

//import static io.vertx.json.schema.OutputFormat.Basic;

public class JsonVerifyCheck {
    private static final String id = "https://localhost/";
    public static void main(String[] args) throws URISyntaxException, IOException {

        URL datasourceTypesURL = Resources.getResource("schemas/datasource_types.schema.json");
        String dataSourceTypesString = Resources.toString(datasourceTypesURL, StandardCharsets.UTF_8);

        URL testdatasourceTypesURL = Resources.getResource("test_datasource.json");
        String testdataSourceTypesString = Resources.toString(testdatasourceTypesURL, StandardCharsets.UTF_8);

        networkntCheck(dataSourceTypesString, testdataSourceTypesString);

    }

//    private void vertxCheck(String dataSourceTypesString, String testdataSourceTypesString){
//        JsonSchema dataSourceTypes =  JsonSchema.of(new JsonObject(dataSourceTypesString));
//        OutputUnit result = Validator.create(dataSourceTypes,
//                        new JsonSchemaOptions().setBaseUri(id).setDraft(Draft.DRAFT202012).setOutputFormat(Basic))
//                .validate(new JsonObject(testdataSourceTypesString));
//        System.out.println(result.toJson().encodePrettily());
//    }

    private static void networkntCheck(String dataSourceTypesString, String testdataSourceTypesString) throws JsonProcessingException {
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V202012);
        SchemaValidatorsConfig config = new SchemaValidatorsConfig();
        config.setPathType(PathType.JSON_POINTER);
        //config.setApplyDefaultsStrategy(new ApplyDefaultsStrategy(true, true, true) );
        JsonSchema schema = jsonSchemaFactory.getSchema(dataSourceTypesString,config);
        OutputUnit outputUnit  = schema.validate(testdataSourceTypesString, InputFormat.JSON, OutputFormat.LIST, executionContext -> {
            // By default since Draft 2019-09 the format keyword only generates annotations and not assertions
            executionContext.getExecutionConfig().setFormatAssertionsEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionEnabled(true);
            executionContext.getExecutionConfig().setAnnotationCollectionFilter(keyword -> true);
        });
        System.out.println(outputUnit);
    }
}