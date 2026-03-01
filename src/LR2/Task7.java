package LR2;

public class Task7 {
    // Интерфейс
    interface AccountOperations {
        void deposit(double amount);
        void withdraw(double amount);
        double getBalance();
    }

    // Реализация счёта
    static class BankAccount implements AccountOperations {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        @Override
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Внесено: " + amount);
            } else {
                System.out.println("Сумма должна быть больше 0");
            }
        }

        @Override
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Снято: " + amount);
            } else {
                System.out.println("Недостаточно средств");
            }
        }

        @Override
        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
