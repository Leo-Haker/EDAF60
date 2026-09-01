package seminarie1;

import java.util.Scanner;

public class Uppgift2 {
    public static void main(String[] args) {
        new Uppgift2().run();
    }

    public void run() {
        Database db = new DatabaseImpl();
        PaymentSystem ps = new PaymentSystemImpl();
        Program p = new Program(db, ps);
        p.process();

    }

    interface Database {
        boolean addEmployee(int employeeId, String name, double salary, String accountNumber);

        boolean setSalary(int employeeId, double salary);

        double getSalary(int employeeId);

        String getAccountNumber(int employeeId);
    }

    interface PaymentSystem {
        void transfer(String fromAccount, String toAccount, double amount);
    }

    abstract class Command {
        public abstract void execute();
    }

    public class Add extends Command {
        Database db;
        int employeeId;
        String name;
        double salary;
        String accountNumber;

        public Add(Database db, int employeeId, String name, double salary, String accountNumber) {
            this.db = db;
            this.employeeId = employeeId;
            this.name = name;
            this.salary = salary;
            this.accountNumber = accountNumber;
        }

        @Override
        public void execute() {
            db.addEmployee(employeeId, name, salary, accountNumber);
        }
    }

    public class Pay extends Command {
        PaymentSystem ps;
        String fromAccount;
        String toAccount;
        double amount;

        Pay(PaymentSystem ps, String fromAccount, String toAccount, double amount) {
            this.ps = ps;
            this.fromAccount = fromAccount;
            this.toAccount = toAccount;
            this.amount = amount;
        }

        @Override
        public void execute() {
            ps.transfer(fromAccount, toAccount, amount);
        }
    }

    public class Salary extends Command {
        Database db;
        int employeeId;
        double salary;

        public Salary(Database db, int employeeId, double salary) {
            this.db = db;
            this.employeeId = employeeId;
            this.salary = salary;
        }

        @Override
        public void execute() {
            db.setSalary(employeeId, salary);
        }
    }

    public class CommandParser {
        private Database db;
        private PaymentSystem ps;

        public CommandParser(Database db, PaymentSystem ps) {
            this.db = db;
            this.ps = ps;
        }

        public Command parse(String s) {
            String[] parts = s.split(",");

            String type = parts[0];

            switch (type) {
                case "add":
                    int id = Integer.parseInt(parts[1]);
                    String name = parts[2];
                    double salary = Double.parseDouble(parts[3]);
                    String accountNumber = parts[4];
                    return new Add(null, id, name, salary, accountNumber);

                case "pay":
                    String formAccount = parts[1];
                    String toAccount = parts[2];
                    double amount = Double.parseDouble(parts[3]);
                    return new Pay(null, formAccount, toAccount, amount);

                case "salary":
                    int employeeId = Integer.parseInt(parts[1]);
                    double newSalary = Double.parseDouble(parts[2]);
                    return new Salary(db, employeeId, newSalary);

                default:
                    throw new IllegalArgumentException("Unknown Command");
            }

        }

    }

    public class Program {
        private Database db;
        private PaymentSystem ps;

        public Program(Database db, PaymentSystem ps) {
            this.db = db;
            this.ps = ps;
        }

        public void process() {
            Scanner scanner = new Scanner(System.in);
            CommandParser parser = new CommandParser(db, ps);

            while (scanner.hasNext()) {
                String input = scanner.nextLine();

                Command command = parser.parse(input);
                if (command != null) {
                    command.execute();
                }
            }
            scanner.close();
        }
    }
}