package utils;

import com.networknt.schema.output.OutputUnit;
import lombok.Setter;

import java.util.List;

@Setter
public abstract class TestCaseGroup {
    protected List<OutputUnit> validationResult;

    public abstract void test();
}
