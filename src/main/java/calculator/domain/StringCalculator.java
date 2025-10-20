package calculator.domain;

// 입력 문자열을 파싱 -> 검증 -> 합산하는 전체 흐름 제어의 역할
public class StringCalculator {

    private final InputParser parser;
    private final Validator validator;

    public StringCalculator() {

        this.parser = new InputParser();
        this.validator = new Validator();
    }

    public int calculate(String input) {

        if(input == null || input.isBlank()) {
            return 0;
        }

        String [] tokens = parser.parse(input);

        int sum = 0;
        for(String token : tokens) {
            int number = validator.parsePositiveInt(token);
            sum += number;
        }
        return sum;
    }
}
