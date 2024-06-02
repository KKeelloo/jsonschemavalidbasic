package utils;

import com.networknt.schema.output.OutputUnit;
import lombok.Setter;
import tests.list.flight.assets.FlightAssetIdPropertyTest;
import tests.list.flight.assets.FlightAssetNamePropertyTest;
import tests.list.flight.assets.FlightAssetPathPropertyTest;
import tests.list.flight.assets.FlightAssetAssetTypePropertyTest;
import tests.list.flight.assets.asset_types.FlightAssetDatasetContainerPropertyTest;
import tests.list.flight.assets.asset_types.FlightAssetDatasetPropertyTest;
import tests.list.flight.assets.asset_types.FlightAssetTypePropertyTest;
import tests.list.flight.assets.fields.FlightAssetFieldsTypePropertyTest;

import java.util.ArrayList;
import java.util.List;

import static utils.OutputUnitUtils.getOutputUnitsByInstanceLocation;

@Setter
public class ListFlightsTest {
    private final List<SampleTestCase> testCases = List.of(
            new FlightAssetIdPropertyTest(),
            new FlightAssetAssetTypePropertyTest(),
            new FlightAssetPathPropertyTest(),
            new FlightAssetNamePropertyTest(),
            new FlightAssetTypePropertyTest(),
            new FlightAssetDatasetContainerPropertyTest(),
            new FlightAssetDatasetPropertyTest(),
            new FlightAssetFieldsTypePropertyTest()
    );
    private List<OutputUnit> validationResult;

    public void test() {
        for (SampleTestCase testCase : testCases) {
            getOutputUnitsByInstanceLocation(validationResult, testCase.getPropertyName()).forEach(testCase::verify);
        }
    }
}
