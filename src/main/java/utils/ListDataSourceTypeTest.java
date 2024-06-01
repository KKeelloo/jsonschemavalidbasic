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

        getOutputUnitsByInstanceLocation("/datasource_types").forEach(dataSourceTypeSourcePropertyTest::verify);
        getOutputUnitsByInstanceLocation("/datasource_types/datasource_types").forEach(dataSourceTypesPropertyTest::verify);

        Pattern dataSourceTypeNamePropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeNamePropertyPattern).forEach(dataSourceTypeNamePropertyTest::verify);


        Pattern dataSourceTypeLabelPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/label");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeLabelPropertyPattern).forEach(dataSourceTypeLabelPropertyTest::verify);

    }

    private List<OutputUnit> getOutputUnitsByInstanceLocationPattern(Pattern pattern) {

        return validationResult.stream().filter(i -> pattern.matcher(i.getInstanceLocation()).matches()).collect(Collectors.toList());

    }

    private List<OutputUnit> getOutputUnitsByInstanceLocationSubString(String subString) {

        return validationResult.stream().filter(i -> i.getInstanceLocation().contains(subString))
                .collect(Collectors.toList());
    }


    private List<OutputUnit> getOutputUnitsByInstanceLocation(String string) {

        return validationResult.stream().filter(i -> i.getInstanceLocation().equals(string))
                .collect(Collectors.toList());
    }

}
