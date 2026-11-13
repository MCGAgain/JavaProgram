import java.util.*;
import java.text.DecimalFormat;

class Employee implements Comparable<Employee> {
    private String name;
    public Employee (String name) {
        this.name = name;
    }

    public int getSalary() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return getName() + ":" + getSalary();
    }

    public int compareTo(Employee o) {
        if (this.getSalary() != o.getSalary()) return this.getSalary() - o.getSalary();
        else return this.name.compareTo(o.name);
    }

}

class Manager extends Employee {
    private int monthSalary;
    public Manager (String name, int monthSalary) {
        super(name);
        this.monthSalary = monthSalary;
    }

    public int getSalary() {
        return monthSalary;
    }
}

class Salesman extends Employee {
    private int baseSalary, commission;

    public Salesman (String name, int baseSalary, int commission) {
        super(name);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    public int getSalary() {
        return baseSalary + commission;
    }
}

class Worker extends Employee {
    private int day, salaryByDay;

    public Worker (String name, int day, int salaryByDay) {
        super(name);
        this.day = day;
        this.salaryByDay = salaryByDay;
    }

    public int getSalary() {
        return day * salaryByDay;
    }
}

public class Main {
    
    public static void main(String []s) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Employee[] arr = new Employee[n];

        for (int i = 0; i < n; i++) {
            switch (i % 3) {
                case 0:
                    arr[i] = new Manager(sc.next(), sc.nextInt());
                    break;
                case 1:
                    arr[i] = new Salesman(sc.next(), sc.nextInt(), sc.nextInt());
                    break;
                default:
                    arr[i] = new Worker(sc.next(), sc.nextInt(), sc.nextInt());
                    break;
            }
        }
        Arrays.sort(arr);
        for (var p : arr) System.out.println(p.getName() + ":" + p.getSalary());
        Arrays.sort(arr, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                int t = o1.getName().compareTo(o2.getName());
                if (t != 0) return t;
                else return o2.getSalary() - o1.getSalary();
            }
        });
        System.out.println("---");
        for (var p : arr) System.out.println(p.getName() + ":" + p.getSalary());
    }
}