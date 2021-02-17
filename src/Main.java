public class Main {

    public static void main(String[] args) {
        String phoneNumber = "+7 (926)172 18 4 8 ";
        String arrayOutResult[] = CorrectPhoneNumber(phoneNumber);
        System.out.println(arrayOutResult[0]);
        System.out.println(arrayOutResult[1]);

    }

    public static String[] CorrectPhoneNumber(String phoneNumber) {
        boolean countRegion = true;
        boolean countDigitNumber = true;
        int countCorrection = 0;
        String strcountRegion = "Изменен регион с +7 на 8";
        String strcountCorrection = "В номере убраны пробелы и/или скобки";
        String arrayOut[] = {"", ""};
        if (phoneNumber.isEmpty() == true) {
            arrayOut[0] = "Номер не введен!";
            arrayOut[1] = "";
            return arrayOut;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.charAt(i) == '(' || phoneNumber.charAt(i) == ')' || phoneNumber.charAt(i) == ' ') {
                phoneNumber = phoneNumber.replace("(", "");
                phoneNumber = phoneNumber.replace(")", "");
                phoneNumber = phoneNumber.replace(" ", "");
                countCorrection++;
            }
        }
        if (phoneNumber.charAt(0) == '+' && phoneNumber.charAt(1) == '7') {
            phoneNumber = phoneNumber.replace("+7", "8");
            countRegion = false;
        }
        if (phoneNumber.length() != 11) {
            countDigitNumber = false;

        }
        if (countDigitNumber && countRegion && countCorrection == 0) {
            arrayOut[0] = phoneNumber;
            arrayOut[1] = "Не было изменений в номере";
        }
        if (countDigitNumber && countCorrection == 0 && !countRegion) {
            arrayOut[0] = phoneNumber;
            arrayOut[1] = strcountRegion;
        }
        if (countDigitNumber && countCorrection != 0 && countRegion) {
            arrayOut[0] = phoneNumber;
            arrayOut[1] = strcountCorrection;
        }

        if (countDigitNumber && countCorrection != 0 && !countRegion) {
            arrayOut[0] = phoneNumber;
            arrayOut[1] = strcountCorrection + "; " + strcountRegion;
        }
        if (!countDigitNumber) {
            arrayOut[0] = "Номер некорректен";
            arrayOut[1] = "В номере не 11 символов";
        }
        return arrayOut;
    }
}