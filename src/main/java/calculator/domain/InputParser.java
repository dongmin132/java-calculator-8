package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 입력 문자열을 분석하여 구분자와 숫자 문자열을 분리하는 역할
public class InputParser {

    // "//[구분자]\n[숫자...]" 형태의 커스텀 구분자 패턴
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public String[] parse(String input) {

        if (input.contains("\\n")) {
            input = input.replace("\\n", "\n");
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        // 커스텀 구분자 존재 시
        if(matcher.matches()) {
            String customDelimiter = matcher.group(1);  // 구분자
            String numbers = matcher.group(2);          //숫자 부분

            return numbers.split(Pattern.quote(customDelimiter));
        }

        // 기본 구분자(, :) 사용
        return input.split(Delimiter.DEFAULT_DELIMITERS);
    }
}
