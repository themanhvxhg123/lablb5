package validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validation {

    // ================= PHONE =================

    public static boolean checkPhone(String phone) {

        // Phone chỉ được chứa số
        if (!phone.matches("[0-9]+")) {
            return false;
        }

        // Phone phải có đúng 10 số
        if (phone.length() != 10) {
            return false;
        }

        return true;
    }


    // ================= EMAIL =================

    public static boolean checkEmail(String email) {

        String emailRegex =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email.matches(emailRegex);
    }


    // ================= DATE =================

    public static boolean checkDate(String date) {

        // Check format: dd/MM/yyyy
        String dateRegex =
                "^(0[1-9]|[12][0-9]|3[01])/"
                + "(0[1-9]|1[0-2])/\\d{4}$";

        // Sai format
        if (!date.matches(dateRegex)) {
            return false;
        }

        // Check ngày có tồn tại thật hay không
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Không cho Java tự động sửa ngày sai
        sdf.setLenient(false);

        try {

            sdf.parse(date);

            return true;

        } catch (ParseException e) {

            return false;
        }
    }
}