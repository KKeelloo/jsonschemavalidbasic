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

import java.util.List;

import static utils.OutputUnitUtils.getOutputUnitsByInstanceLocation;

@Setter
public class ListFlightsTest {

    private final FlightAssetIdPropertyTest flightAssetIdPropertyTest = new FlightAssetIdPropertyTest();
    private final FlightAssetAssetTypePropertyTest flightAssetAssetTypePropertyTest = new FlightAssetAssetTypePropertyTest();
    private final FlightAssetPathPropertyTest flightAssetPathPropertyTest = new FlightAssetPathPropertyTest();
    private final FlightAssetNamePropertyTest flightAssetNamePropertyTest = new FlightAssetNamePropertyTest();
    private final FlightAssetTypePropertyTest flightAssetTypePropertyTest = new FlightAssetTypePropertyTest();
    private final FlightAssetDatasetContainerPropertyTest flightAssetDatasetContainerPropertyTest = new FlightAssetDatasetContainerPropertyTest();
    private final FlightAssetDatasetPropertyTest flightAssetDatasetPropertyTest = new FlightAssetDatasetPropertyTest();
    private final FlightAssetFieldsTypePropertyTest flightAssetFieldsTypePropertyTest = new FlightAssetFieldsTypePropertyTest();
    private List<OutputUnit> validationResult;

    public void test(){
        getOutputUnitsByInstanceLocation(validationResult, "/id").forEach(flightAssetIdPropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/name").forEach(flightAssetNamePropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/path").forEach(flightAssetPathPropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/asset_type").forEach(flightAssetAssetTypePropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/asset_type/type").forEach(flightAssetTypePropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/asset_type/dataset_container").forEach(flightAssetDatasetContainerPropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "/asset_type/dataset").forEach(flightAssetDatasetPropertyTest::verify);
        getOutputUnitsByInstanceLocation(validationResult, "fields/items/type").forEach(flightAssetFieldsTypePropertyTest::verify);
    }
}
