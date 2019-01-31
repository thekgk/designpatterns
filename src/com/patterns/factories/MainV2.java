package com.patterns.factories;

public class MainV2 {

    public static void main(String[] args) {
        MainV2 v2 = new MainV2();
        v2.paySalaries("id1");
    }

    private void paySalaries(String id) {
        Payroll p = new Payroll();
        p.paySalary(id);
    }

    public class Payroll {
        private EmployeeFactory factory = new IndiaEmployeeFactory();
        public void paySalary(String employeeId){
            Employee emp;
            String type = DB.type(employeeId);
            if(type.equals("salaried")){
                emp = factory.makeSalaried();
            }
            else {
                emp = factory.makeHourly();
            }
            pay(emp.calculateSalary());
        }

        private void pay(double salary) {
            System.out.println("Paid salary " + salary);
        }
    }

    public abstract class Employee {
        public int id;
        public abstract String getType();
        public abstract double calculateSalary();
    }

    public interface EmployeeFactory{
        Employee makeSalaried();
        Employee makeHourly();
    }

    public class IndiaEmployeeFactory implements EmployeeFactory {
        @Override
        public Employee makeSalaried() {
            return new IndiaSalariedEmployee();
        }

        @Override
        public Employee makeHourly() {
            return new IndiaHourlyEmployee();
        }
    }

    public class IndiaSalariedEmployee extends Employee {
        private double monthlySalary;

        @Override
        public String getType() {
            return "salaried";
        }

        @Override
        public double calculateSalary(){
            return monthlySalary;
        }
    }

    public class IndiaHourlyEmployee extends Employee {
        private double hourlySalary;
        private double numberOfHoursWorked;

        @Override
        public String getType() {
            return "hourly";
        }
        @Override
        public double calculateSalary(){
            return hourlySalary * numberOfHoursWorked;
        }
    }
}
