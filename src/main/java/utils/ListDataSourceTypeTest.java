package utils;

import lombok.Setter;
import tests.list.datasource.types.*;

import java.util.regex.Pattern;

@Setter
public class ListDataSourceTypeTest extends TestCaseGroup {

    private final DataSourceTypesRootPropertyTest dataSourceTypeSourcePropertyTest = new DataSourceTypesRootPropertyTest();
    private final DataSourceTypesPropertyTest dataSourceTypesPropertyTest = new DataSourceTypesPropertyTest();
    private final DataSourceTypesNamePropertyTest dataSourceTypeNamePropertyTest = new DataSourceTypesNamePropertyTest();
    private final DataSourceTypesLabelPropertyTest dataSourceTypeLabelPropertyTest = new DataSourceTypesLabelPropertyTest();
    private final AllowedAsSourcePropertyTest allowedAsSourcePropertyTest = new AllowedAsSourcePropertyTest();
    private final AllowedAsTargetPropertyTest allowedAsTargetPropertyTest = new AllowedAsTargetPropertyTest();
    private final DataSourceTypesPropertiesArraysNameTest dataSourceTypesPropertiesArraysNameTest = new DataSourceTypesPropertiesArraysNameTest();
    private final DataSourceTypesPropertiesArraysLabelTest dataSourceTypesPropertiesArraysLabelTest = new DataSourceTypesPropertiesArraysLabelTest();
    private final DataSourceTypesPropertiesArraysTypeTest dataSourceTypesPropertiesArraysTypeTest = new DataSourceTypesPropertiesArraysTypeTest();
    private final DataSourceTypesPropertiesArraysDescriptionTest dataSourceTypesPropertiesArraysDescriptionTest = new DataSourceTypesPropertiesArraysDescriptionTest();
    private final DataSourceTypesPropertiesArraysRequiredTest dataSourceTypesPropertiesArraysRequiredTest = new DataSourceTypesPropertiesArraysRequiredTest();
    private final DataSourceTypesPropertiesArraysGroupTest dataSourceTypesPropertiesArraysGroupTest = new DataSourceTypesPropertiesArraysGroupTest();
    private final DataSourceTypesPropertiesArraysMaskedTest dataSourceTypesPropertiesArraysCredentialsTest = new DataSourceTypesPropertiesArraysMaskedTest();
    private final DataSourceTypesPropertiesArraysDefaultValuesTest dataSourceTypesPropertiesArraysDefaultValuesTest = new DataSourceTypesPropertiesArraysDefaultValuesTest();
    private final DataSourceTypesStatusPropertyTest dataSourceTypesStatusPropertyTest = new DataSourceTypesStatusPropertyTest();
    private final DataSourceTypesDescriptionPropertyTest dataSourceTypesDescriptionPropertyTest = new DataSourceTypesDescriptionPropertyTest();

    /**
     * Validate all properties
     */
    @Override
    public void test() {

        // verify root objects
        getOutputUnitsByInstanceLocation("/datasource_types").forEach(dataSourceTypeSourcePropertyTest::verify);
        getOutputUnitsByInstanceLocation("/datasource_types/datasource_types").forEach(dataSourceTypesPropertyTest::verify);


        // verify properties in /datasource_types/datasource_types arrays
        Pattern dataSourceTypeAssowedAsTargetPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/allowed_as_source");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeAssowedAsTargetPropertyPattern).forEach(allowedAsSourcePropertyTest::verify);

        Pattern dataSourceTypeAssowedAsSourcePropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/allowed_as_taget");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeAssowedAsSourcePropertyPattern).forEach(allowedAsTargetPropertyTest::verify);

        Pattern dataSourceTypeNamePropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeNamePropertyPattern).forEach(dataSourceTypeNamePropertyTest::verify);

        Pattern dataSourceTypeLabelPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/label");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeLabelPropertyPattern).forEach(dataSourceTypeLabelPropertyTest::verify);

        Pattern dataSourceTypeStatusPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/status");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeStatusPropertyPattern).forEach(dataSourceTypesStatusPropertyTest::verify);

        Pattern dataSourceTypeDescriptionPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/description");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypeDescriptionPropertyPattern).forEach(dataSourceTypesDescriptionPropertyTest::verify);


        // verify properties in /datasource_types/datasource_types/d/properties arrays - connection, filter, source, target
        Pattern dataSourceTypesPropertiesArraysNamePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysNamePattern)
                .forEach(dataSourceTypesPropertiesArraysNameTest::verify);

        Pattern dataSourceTypesPropertiesArraysLabelPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/label");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysLabelPattern)
                .forEach(dataSourceTypesPropertiesArraysLabelTest::verify);

        Pattern dataSourceTypesPropertiesArraysTypePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/type");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysTypePattern)
                .forEach(dataSourceTypesPropertiesArraysTypeTest::verify);

        Pattern dataSourceTypesPropertiesArraysDescriptionPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/description");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysDescriptionPattern)
                .forEach(dataSourceTypesPropertiesArraysDescriptionTest::verify);

        Pattern dataSourceTypesPropertiesArraysRequiredPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/required");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysRequiredPattern)
                .forEach(dataSourceTypesPropertiesArraysRequiredTest::verify);

        Pattern dataSourceTypesPropertiesArraysGroupPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/group");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysGroupPattern)
                .forEach(dataSourceTypesPropertiesArraysGroupTest::verify);

        Pattern dataSourceTypesPropertiesArraysCredentailsPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/masked");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysCredentailsPattern)
                .forEach(dataSourceTypesPropertiesArraysCredentialsTest::verify);

        Pattern dataSourceTypesPropertiesArraysDefaultValuesPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/properties/(connection|filter|target|source)/\\d+/default_value");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesPropertiesArraysDefaultValuesPattern)
                .forEach(dataSourceTypesPropertiesArraysDefaultValuesTest::verify);

    }

}
