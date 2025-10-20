package calculator.domain;

import calculator.exception.CalculatorException;

//입력된 문자열을 검증하고, 유효한 양의 정수로 변환
public class Validator {

    public int parsePositiveInt(String token) {
        try {
            int number = Integer.parseInt(token);
            if(number < 0) {
                // 음수 입력은 허용 안함
                throw new CalculatorException("음수는 허용되지 않습니다: " + token);
            }
            return number;
        } catch(NumberFormatException e) {
            //숫자 변환 실패
            throw new CalculatorException("유효하지 않는 숫자 형식입니다: " + token);
        }
    }
}
