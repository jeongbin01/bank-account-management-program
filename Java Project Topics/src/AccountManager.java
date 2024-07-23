import java.util.*;

public class AccountManager {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println(ConsoleColors.PURPLE_BOLD + "\n은행 계좌 관리자:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "1. 새 계좌 만들기" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "2. 계좌 선택" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "3. 종료" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "옵션을 선택하세요: " + ConsoleColors.RESET);
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 소비

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    selectAccount();
                    break;
                case 3:
                    running = false;
                    System.out.println(ConsoleColors.GREEN + "종료합니다..." + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "잘못된 옵션입니다. 다시 시도하세요." + ConsoleColors.RESET);
                    break;
            }
        }

        scanner.close();
    }

    private static void createAccount() {
        System.out.print(ConsoleColors.YELLOW + "계좌번호를 입력하세요: " + ConsoleColors.RESET);
        String accountNumber = scanner.nextLine();
        System.out.print(ConsoleColors.YELLOW + "계좌 소유자 이름을 입력하세요: " + ConsoleColors.RESET);
        String accountHolder = scanner.nextLine();
        System.out.print(ConsoleColors.YELLOW + "비밀번호를 입력하세요: " + ConsoleColors.RESET);
        String password = scanner.nextLine();
        
        Account account = new Account(accountNumber, accountHolder, password);
        accounts.put(accountNumber, account);
        System.out.println(ConsoleColors.GREEN + "계좌가 성공적으로 생성되었습니다." + ConsoleColors.RESET);
    }

    private static void selectAccount() {
        System.out.print(ConsoleColors.YELLOW + "계좌번호를 입력하세요: " + ConsoleColors.RESET);
        String accountNumber = scanner.nextLine();
        
        Account account = accounts.get(accountNumber);
        if (account == null) {
            System.out.println(ConsoleColors.RED + "계좌를 찾을 수 없습니다." + ConsoleColors.RESET);
            return;
        }

        boolean managing = true;
        while (managing) {
            System.out.println(ConsoleColors.PURPLE_BOLD + "\n계좌 메뉴:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "1. 입금" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "2. 출금" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "3. 잔액 확인" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "4. 계좌 정보 보기" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.CYAN + "5. 메인 메뉴로 돌아가기" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.YELLOW + "옵션을 선택하세요: " + ConsoleColors.RESET);
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // 개행 문자 소비

            switch (choice) {
                case 1:
                    System.out.print(ConsoleColors.YELLOW + "입금할 금액을 입력하세요: " + ConsoleColors.RESET);
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();  // 개행 문자 소비
                    System.out.print(ConsoleColors.YELLOW + "비밀번호를 입력하세요: " + ConsoleColors.RESET);
                    String depositPassword = scanner.nextLine();
                    account.deposit(depositAmount, depositPassword);
                    break;
                
                case 2:
                    System.out.print(ConsoleColors.YELLOW + "출금할 금액을 입력하세요: " + ConsoleColors.RESET);
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();  // 개행 문자 소비
                    System.out.print(ConsoleColors.YELLOW + "비밀번호를 입력하세요: " + ConsoleColors.RESET);
                    String withdrawPassword = scanner.nextLine();
                    account.withdraw(withdrawAmount, withdrawPassword);
                    break;
                
                case 3:
                    System.out.printf(ConsoleColors.BLUE_BOLD + "현재 잔액: %s원" + ConsoleColors.RESET + "%n", account.formatCurrency(account.getBalance()));
                    break;
                
                case 4:
                    account.displayAccountInfo();
                    break;
                
                case 5:
                    managing = false;
                    break;
                
                default:
                    System.out.println(ConsoleColors.RED + "잘못된 옵션입니다. 다시 시도하세요." + ConsoleColors.RESET);
                    break;
            }
        }
    }
}
