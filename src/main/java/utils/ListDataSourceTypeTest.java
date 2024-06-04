package utils;

import com.networknt.schema.output.OutputUnit;
import lombok.Setter;
import tests.list.datasource.types.*;

import java.util.List;
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
    private final DataSourceTypesActionsArraysNameTest dataSourceTypesActionsArraysNameTest = new DataSourceTypesActionsArraysNameTest();
    private final DataSourceTypesActionsArraysDescriptionTest dataSourceTypesActionsArraysDescriptionTest = new DataSourceTypesActionsArraysDescriptionTest();
    private final DataSourceTypesActionsArraysPropertiesTest dataSourceTypesActionsArraysPropertiesTest = new DataSourceTypesActionsArraysPropertiesTest();
    private final DataSourceTypesActionsArraysPropertiesInputTest dataSourceTypesActionsArraysPropertiesInputTest = new DataSourceTypesActionsArraysPropertiesInputTest();
    private final DataSourceTypesActionsArraysPropertiesOutputTest dataSourceTypesActionsArraysPropertiesOutputTest = new DataSourceTypesActionsArraysPropertiesOutputTest();
    private final DataSourceTypesDiscoveryPropertyTest dataSourceTypesDiscoveryPropertyTest = new DataSourceTypesDiscoveryPropertyTest();
    private final DataSourceTypesDiscoveryAssetTypesTest dataSourceTypesDiscoveryAssetTypesTest = new DataSourceTypesDiscoveryAssetTypesTest();
    private final DataSourceTypesDiscoveryAssetTypesArraysLabelTest dataSourceTypesDiscoveryAssetTypesArraysLabelTest = new DataSourceTypesDiscoveryAssetTypesArraysLabelTest();
    private final DataSourceTypesDiscoveryAssetTypesArraysNameTest dataSourceTypesDiscoveryAssetTypesArraysNameTest = new DataSourceTypesDiscoveryAssetTypesArraysNameTest();
    private final DataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersTest dataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersTest = new DataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersTest();
    private final DataSourceTypesDiscoveryPathPropertiesTest dataSourceTypesDiscoveryPathPropertiesTest = new DataSourceTypesDiscoveryPathPropertiesTest();
    private final DataSourceTypesDiscoveryPathPropertiesArraysPropertyNameTest dataSourceTypesDiscoveryPathPropertiesArraysPropertyNameTest = new DataSourceTypesDiscoveryPathPropertiesArraysPropertyNameTest();
    private final DataSourceTypesDiscoveryPathPropertiesArraysSegmentsTest dataSourceTypesDiscoveryPathPropertiesArraysSegmentsTest = new DataSourceTypesDiscoveryPathPropertiesArraysSegmentsTest();
    private final DataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesTest dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesTest = new DataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesTest();
    private final DataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatableTest dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatableTest = new DataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatableTest();
    private final DataSourceTypesDiscoveryTopLevelFiltersTest dataSourceTypesDiscoveryTopLevelFiltersTest = new DataSourceTypesDiscoveryTopLevelFiltersTest();

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

        // verify properties in /datasource_types/datasource_types/d/actions arrays

        Pattern dataSourceTypesActionsArraysNamePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/actions/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesActionsArraysNamePattern)
                .forEach(dataSourceTypesActionsArraysNameTest::verify);

        Pattern dataSourceTypesActionsArraysDescriptionPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/actions/\\d+/description");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesActionsArraysDescriptionPattern)
                .forEach(dataSourceTypesActionsArraysDescriptionTest::verify);

        Pattern dataSourceTypesActionsArraysPropertiesPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/actions/\\d+/properties");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesActionsArraysPropertiesPattern).
                forEach(dataSourceTypesActionsArraysPropertiesTest::verify);

        Pattern dataSourceTypesActionsArraysPropertiesInputPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/actions/\\d+/properties/input");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesActionsArraysPropertiesInputPattern).
                forEach(dataSourceTypesActionsArraysPropertiesInputTest::verify);

        Pattern dataSourceTypesActionsArraysPropertiesOutputPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/actions/\\d+/properties/output");
        for (OutputUnit outputUnit : getOutputUnitsByInstanceLocationPattern(dataSourceTypesActionsArraysPropertiesOutputPattern)) {
            dataSourceTypesActionsArraysPropertiesOutputTest.verify(outputUnit);
        }

        // verify properties in /datasource_types/datasource_types/d/discovery

        Pattern dataSourceTypesDiscoveryPropertyPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPropertyPattern)
                .forEach(dataSourceTypesDiscoveryPropertyTest::verify);

        Pattern dataSourceTypesDiscoveryAssetTypesPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/assetTypes");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryAssetTypesPattern)
                .forEach(dataSourceTypesDiscoveryAssetTypesTest::verify);

        Pattern dataSourceTypesDiscoveryAssetTypesArraysLabelPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/assetTypes/\\d+/label");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryAssetTypesArraysLabelPattern)
                .forEach(dataSourceTypesDiscoveryAssetTypesArraysLabelTest::verify);

        Pattern dataSourceTypesDiscoveryAssetTypesArraysNamePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/assetTypes/\\d+/name");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryAssetTypesArraysNamePattern)
                .forEach(dataSourceTypesDiscoveryAssetTypesArraysNameTest::verify);

        Pattern dataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/assetTypes/\\d+/nextLevelFilters");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersPattern)
                .forEach(dataSourceTypesDiscoveryAssetTypesArraysNextLevelFiltersTest::verify);

        Pattern dataSourceTypesDiscoveryPathPropertiesPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/pathProperties");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPathPropertiesPattern)
                .forEach(dataSourceTypesDiscoveryPathPropertiesTest::verify);

        Pattern dataSourceTypesDiscoveryPathPropertiesArraysPropertyNamePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/pathProperties/\\d+/propertyName");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPathPropertiesArraysPropertyNamePattern)
                .forEach(dataSourceTypesDiscoveryPathPropertiesArraysPropertyNameTest::verify);

        Pattern dataSourceTypesDiscoveryPathPropertiesArraysSegmentsPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/pathProperties/\\d+/segments");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsPattern)
                .forEach(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsTest::verify);

        Pattern dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/pathProperties/\\d+/segments/\\d+/assetTypes");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesPattern)
                .forEach(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysAssetTypesTest::verify);

        Pattern dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatablePattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/pathProperties/\\d+/segments/\\d+/repeatable");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatablePattern)
                .forEach(dataSourceTypesDiscoveryPathPropertiesArraysSegmentsArraysRepeatableTest::verify);

        Pattern dataSourceTypesDiscoveryTopLevelFiltersPattern = Pattern.compile("/datasource_types/datasource_types/\\d+/discovery/topLevelFilters");
        getOutputUnitsByInstanceLocationPattern(dataSourceTypesDiscoveryTopLevelFiltersPattern)
                .forEach(dataSourceTypesDiscoveryTopLevelFiltersTest::verify);
    }
}
