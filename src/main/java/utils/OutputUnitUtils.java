package utils;

import com.networknt.schema.output.OutputUnit;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OutputUnitUtils {

    public static List<OutputUnit> getOutputUnitsByInstanceLocationPattern(List<OutputUnit> validationResult, Pattern pattern) {
        return validationResult.stream()
                .filter(i -> pattern.matcher(i.getInstanceLocation()).matches())
                .collect(Collectors.toList());
    }

    public static List<OutputUnit> getOutputUnitsByInstanceLocationSubString(List<OutputUnit> validationResult, String subString) {
        return validationResult.stream()
                .filter(i -> i.getInstanceLocation().contains(subString))
                .collect(Collectors.toList());
    }

    public static List<OutputUnit> getOutputUnitsByInstanceLocation(List<OutputUnit> validationResult, String string) {
        return validationResult.stream()
                .filter(i -> i.getInstanceLocation().equals(string))
                .collect(Collectors.toList());
    }
}

