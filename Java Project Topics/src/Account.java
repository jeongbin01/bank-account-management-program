import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password; // 비밀번호 필드 추가

    // 비밀번호를 포함한 생성자
    public Account(String accountNumber, String accountHolder, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = 0.0;
    }

    // 파일에서 계좌 정보 로드
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            accountNumber = br.readLine();
            accountHolder = br.readLine();
            balance = Double.parseDouble(br.readLine());
        } catch (IOException | NumberFormatException e) {
            System.out.println(ConsoleColors.RED + "계좌 정보 로드 중 오류 발생: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    // 파일에 계좌 정보 저장
    public void saveToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(accountNumber + "\n");
            bw.write(accountHolder + "\n");
            bw.write(Double.toString(balance));
        } catch (IOException e) {
            System.out.println(ConsoleColors.RED + "계좌 정보 저장 중 오류 발생: " + e.getMessage() + ConsoleColors.RESET);
        }
    }

    // 비밀번호 확인
    private boolean authenticate(String password) {
        return this.password.equals(password);
    }

    // 입금 메서드
    public void deposit(double amount, String password) {
        if (authenticate(password)) {
            if (amount > 0) {
                balance += amount;
                System.out.printf(ConsoleColors.GREEN + "입금액: %s원" + ConsoleColors.RESET + "%n", formatCurrency(amount));
            } else {
                System.out.println(ConsoleColors.RED + "입금액은 양수여야 합니다." + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED + "인증 실패." + ConsoleColors.RESET);
        }
    }

    // 출금 메서드
    public void withdraw(double amount, String password) {
        if (authenticate(password)) {
            if (amount > 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.printf(ConsoleColors.GREEN + "출금액: %s원" + ConsoleColors.RESET + "%n", formatCurrency(amount));
                } else {
                    System.out.println(ConsoleColors.RED + "잔액이 부족합니다." + ConsoleColors.RESET);
                }
            } else {
                System.out.println(ConsoleColors.RED + "출금액은 양수여야 합니다." + ConsoleColors.RESET);
            }
        } else {
            System.out.println(ConsoleColors.RED + "인증 실패." + ConsoleColors.RESET);
        }
    }

    // 잔액 조회 메서드
    public double getBalance() {
        return balance;
    }

    // 계좌 정보 출력
    public void displayAccountInfo() {
        System.out.println(ConsoleColors.BLUE_BOLD + "계좌번호: " + accountNumber + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE_BOLD + "계좌 소유자: " + accountHolder + ConsoleColors.RESET);
        System.out.printf(ConsoleColors.BLUE_BOLD + "잔액: %s원" + ConsoleColors.RESET + "%n", formatCurrency(balance));
    }

    // 원화 포맷 메서드
    public String formatCurrency(double amount) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.KOREA);
        return formatter.format(amount).replace("₩", "").trim();
    }
}
