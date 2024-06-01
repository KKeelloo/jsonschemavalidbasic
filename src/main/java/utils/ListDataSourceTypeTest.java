package utils;

import com.networknt.schema.output.OutputUnit;
import lombok.Setter;
import tests.list.datasource.types.DataSourceTypeLabelPropertyTest;
import tests.list.datasource.types.DataSourceTypeNamePropertyTest;
import tests.list.datasource.types.DataSourceTypesPropertyTest;
import tests.list.datasource.types.DataSourceTypesRootPropertyTest;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static utils.OutputUnitUtils.getOutputUnitsByInstanceLocation;
import static utils.OutputUnitUtils.getOutputUnitsByInstanceLocationPattern;

@Setter
public class ListDataSourceTypeTest {

    private final DataSourceTypesRootPropertyTest dataSourceTypeSourcePropertyTest = new DataSourceTypesRootPropertyTest();
    private final DataSourceTypesPropertyTest dataSourceTypesPropertyTest = new DataSourceTypesPropertyTest();
    private final DataSourceTypeNamePropertyTest dataSourceTypeNamePropertyTest = new DataSourceTypeNamePropertyTest();
    private final DataSourceTypeLabelPropertyTest dataSourceTypeLabelPropertyTest = new DataSourceTypeLabelPropertyTest();
    private List<OutputUnit> validationResult;

    /**
     * Validate all properties
     */
    public void test() {

        getOutputUnitsByInstanceLocation(validationResult, "/datasource_types").forEach(dataSourceTypeSourcePropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/datasource_types/datasource_types").forEach(dataSourceTypesPropertyTest::verify);

        Pattern dataSourceTypeNamePropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(validationResult, dataSourceTypeNamePropertyPattern).forEach(dataSourceTypeNamePropertyTest::verify);


        Pattern dataSourceTypeLabelPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/label");
        getOutputUnitsByInstanceLocationPattern(validationResult, dataSourceTypeLabelPropertyPattern).forEach(dataSourceTypeLabelPropertyTest::verify);

    }



}
