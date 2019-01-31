package com.patterns.factories;

public class MainV1 {

    public static void main(String[] args) {
        MainV1 v1 = new MainV1();
        v1.paySalaries("id1");
    }

    private void paySalaries(String id) {
        Payroll p = new Payroll();
        p.paySalary(id);
    }

    public class Payroll {
        public void paySalary(String employeeId){
            Employee emp;
            String type = DB.type(employeeId);
            if(type.equals("salaried")){
                emp = new SalariedEmployee();
            }
            else {
                emp = new HourlyEmployee();
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

    public class SalariedEmployee extends Employee {
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

    public class HourlyEmployee extends Employee {
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
