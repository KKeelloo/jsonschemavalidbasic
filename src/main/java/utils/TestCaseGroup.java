package utils;

import com.networknt.schema.output.OutputUnit;
import lombok.Setter;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Setter
public abstract class TestCaseGroup {
    protected List<OutputUnit> validationResult;

    public abstract void test();

    protected List<OutputUnit> getOutputUnitsByInstanceLocationPattern(Pattern pattern) {

        return validationResult.stream().filter(i -> pattern.matcher(i.getInstanceLocation()).matches()).collect(Collectors.toList());

    }

    protected List<OutputUnit> getOutputUnitsByInstanceLocationSubString(String subString) {

        return validationResult.stream().filter(i -> i.getInstanceLocation().contains(subString))
                .collect(Collectors.toList());
    }

    protected List<OutputUnit> getOutputUnitsByInstanceLocation(String string) {

        return validationResult.stream().filter(i -> i.getInstanceLocation().equals(string))
                .collect(Collectors.toList());
    }
}
