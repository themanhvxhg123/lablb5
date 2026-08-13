package checkformat;

import validation.Validation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("====== Validate Program ======");


        // =====================================================
        // CHECK PHONE
        // =====================================================

        String phone;

        while (true) {

            System.out.print("Phone number: ");

            phone = scanner.nextLine().trim();

            boolean isError = false;

            StringBuilder errorMsg = new StringBuilder();


            // Check phone chỉ chứa số
            if (!phone.matches("[0-9]+")) {

                errorMsg.append(
                        "Phone number must be number\n"
                );

                isError = true;
            }


            // Check phone phải có 10 số
            if (phone.length() != 10) {

                errorMsg.append(
                        "Phone number must be 10 digits\n"
                );

                isError = true;
            }


            // Gọi Validation để kiểm tra tổng thể
            if (!Validation.checkPhone(phone)) {

                isError = true;
            }


            // Nếu có lỗi thì nhập lại
            if (isError) {

                System.out.print(errorMsg.toString());

            } else {

                break;
            }
        }

       


        // =====================================================
        // CHECK EMAIL
        // =====================================================

        String email;

        while (true) {

            System.out.print("Email: ");

            email = scanner.nextLine().trim();


            if (Validation.checkEmail(email)) {

                break;

            } else {

                System.out.println(
                        "Email must is correct format"
                );
            }
        }

     


        // =====================================================
        // CHECK DATE
        // =====================================================

        String date;

        while (true) {

            System.out.print("Date (dd/MM/yyyy): ");

            date = scanner.nextLine().trim();


            if (Validation.checkDate(date)) {

                break;

            } else {

                System.out.println(
                        "Date must be correct format or date does not exist!"
                );
            }
        }

      


        // =====================================================
        // END
        // =====================================================

        scanner.close();

        System.out.println("Chương trình kết thúc.");
    }
}