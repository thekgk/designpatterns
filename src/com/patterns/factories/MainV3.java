package com.patterns.factories;

public class MainV3 {

    public static void main(String[] args) {
        MainV3 v3 = new MainV3();
        v3.paySalaries("id1");
    }

    private void paySalaries(String id) {
        Payroll p = new Payroll(new IndiaEmployeeFactory());
        p.paySalary(id);
    }

    public class Payroll {
        private EmployeeFactory factory;

        public Payroll(EmployeeFactory factory) {
            this.factory = factory;
        }

        public void paySalary(String employeeId){
            String type = DB.type(employeeId);
            Employee emp = factory.make(type);
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
        Employee make(String type);
        String[] getTypes();
    }

    public class IndiaEmployeeFactory implements EmployeeFactory {
        @Override
        public Employee make(String type) {
            if(type.equals("salaried")) return new IndiaSalariedEmployee();
            if(type.equals("hourly")) return new IndiaHourlyEmployee();
            throw new UnsupportedOperationException();
        }

        @Override
        public String[] getTypes() {
            return new String[] {"salaried", "hourly"};
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
