package exceptions;

import helpers.Command;

public class AmbiguousRegexPatternException extends CalculatorException {

    public AmbiguousRegexPatternException(Command command, Class<?> first, Class<?> second) {
        super(command, String.format("Ambiguous regex pattern for %s and %s", first.getClass()
                .getName(), second.getClass()
                .getName()));
    }

}
