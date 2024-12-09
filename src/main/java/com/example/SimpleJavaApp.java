package com.example;
import java.util.*;
import java.util.InputMismatchException;
import java.lang.Math;

import static java.lang.Math.*;

class SimpleJavaApp {
    private final Scanner scanner;

    // Constructor to initialize the scanner
    public SimpleJavaApp(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleJavaApp app = new SimpleJavaApp(scanner);

        // Call the calculator functions
        app.basicOperations();
    }

    public void basicOperations() {
        System.out.println("===== Basic Operations =====");
        System.out.print("Enter the first number: ");
        int num1 = getIntegerInput("");
        System.out.print("Enter the second number: ");
        int num2 = getIntegerInput("");

        System.out.println("Addition: " + add(num1, num2));
        System.out.println("Subtraction: " + subtract(num1, num2));
        System.out.println("Multiplication: " + multiply(num1, num2));
        System.out.println("Division: " + divide(num1, num2));
        System.out.println("Modulus: " + modulus(num1, num2));
        System.out.println("Exponentiation: " + exponentiate(num1, num2));
        System.out.println("Square Root of first number: " + sqrt(num1));

        // Extra functions
        System.out.println("Factorial of first number: " + factorial(num1));
        System.out.println("Power of first number raised to second number: " + Math.pow(num1, num2));
        System.out.println("Logarithm (base 10) of first number: " + Math.log10(num1));
        System.out.println("Sine of first number: " + sine(num1));
        System.out.println("Cosine of first number: " + cosine(num1));
        System.out.println("Tangent of first number: " + tangent(num1));
        System.out.println("Convert first number from degrees to radians: " + toRadians(num1));
        System.out.println("Convert first number from radians to degrees: " + toDegrees(num1));

        // Additional methods
        System.out.println("Natural Logarithm of first number: " + logBaseE(num1));
        System.out.println("Round off first number to nearest integer: " + roundOff(num1));
        System.out.println("Ceiling of first number: " + ceilValue(num1));
        System.out.println("Floor of first number: " + floorValue(num1));
        System.out.println("Cube root of first number: " + cubeRoot(num1));
        System.out.println("Random number between 1 and 100: " + randomInRange(1, 100));
        System.out.println("Max of first and second numbers: " + maxOfTwo(num1, num2));
        System.out.println("Min of first and second numbers: " + minOfTwo(num1, num2));

        // Financial operations
        System.out.println("Simple Interest on first number at 5% for 1 year: " + simpleInterest(num1, 5, 1));
        System.out.println("Compound Interest on first number at 5% for 1 year: " + compoundInterest(num1, 5, 1));

        // Hyperbolic functions
        System.out.println("Hyperbolic Sine of first number: " + sinh(num1));
        System.out.println("Hyperbolic Cosine of first number: " + cosh(num1));
        System.out.println("Hyperbolic Tangent of first number: " + tanh(num1));

        // Logarithm base 2
        System.out.println("Logarithm base 2 of first number: " + logarithmBase2(num1));

        // Unit conversions
        System.out.println("Convert first number from meters to kilometers: " + metersToKilometers(num1));
        System.out.println("Convert first number from kilograms to pounds: " + kilogramsToPounds(num1));

        // Additional methods
        System.out.println("Area of Circle with radius first number: " + areaOfCircle(num1));
        System.out.println("Area of Rectangle with length and width: " + areaOfRectangle(num1, num2));
        System.out.println("Area of Triangle with base and height: " + areaOfTriangle(num1, num2));
        System.out.println("Volume of Sphere with radius: " + volumeOfSphere(num1));
        System.out.println("Volume of Cylinder with radius and height: " + volumeOfCylinder(num1, num2));
        System.out.println("Volume of Cone with radius and height: " + volumeOfCone(num1, num2));
        System.out.println("Perimeter of Circle with radius: " + perimeterOfCircle(num1));
        System.out.println("Perimeter of Rectangle with length and width: " + perimeterOfRectangle(num1, num2));

        // Financial calculations
        System.out.println("Monthly Loan Payment for principal, rate, months: " + monthlyLoanPayment(num1, 5, 12));
        System.out.println("Future Value of Investment: " + futureValueOfInvestment(num1, 5, 1));
        System.out.println("Net Present Value of Cash Flows: " + netPresentValue(new double[]{1000, 1200, 1300}, 5));

        // Temperature conversions
        System.out.println("Celsius to Fahrenheit: " + celsiusToFahrenheit(num1));
        System.out.println("Fahrenheit to Celsius: " + fahrenheitToCelsius(num1));
        System.out.println("Celsius to Kelvin: " + celsiusToKelvin(num1));
        System.out.println("Kelvin to Celsius: " + kelvinToCelsius(num1));

        // Distance conversions
        System.out.println("Kilometers to Miles: " + kilometersToMiles(num1));
        System.out.println("Miles to Kilometers: " + milesToKilometers(num1));
        System.out.println("Inches to Centimeters: " + inchesToCentimeters(num1));
        System.out.println("Centimeters to Inches: " + centimetersToInches(num1));

        // Weight conversions
        System.out.println("Pounds to Kilograms: " + poundsToKilograms(num1));
        System.out.println("Kilograms to Grams: " + kilogramsToGrams(num1));

        // Speed conversions
        System.out.println("Kmph to Mph: " + kmphToMph(num1));
        System.out.println("Mph to Kmph: " + mphToKmph(num1));

        // Time conversions
        System.out.println("Hours to Minutes: " + hoursToMinutes(num1));
        System.out.println("Minutes to Hours: " + minutesToHours(num1));
        System.out.println("Days to Hours: " + daysToHours(num1));
        System.out.println("Hours to Days: " + hoursToDays(num1));

        // Modular Arithmetic
        System.out.println("Power Modulo: " + powerModulo(2, 3, 5));

        // Statistics
        System.out.println("Mean of numbers: " + mean(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Variance of numbers: " + variance(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Standard Deviation of numbers: " + standardDeviation(new int[]{1, 2, 3, 4, 5}));
    }

    public int getIntegerInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    // Basic Operations
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
    public double divide(int a, int b) { return b == 0 ? 0 : (double) a / b; }
    public int modulus(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a % b;
    }
    public double exponentiate(int a, int b) { return Math.pow(a, b); }
    public double sqrt(int a) { return Math.sqrt(a); }

    // Advanced Operations
    public double logBaseE(int a) { return a <= 0 ? -1 : Math.log(a); }
    public double roundOff(int a) { return Math.round(a); }
    public double ceilValue(int a) { return Math.ceil(a); }
    public double floorValue(int a) { return Math.floor(a); }
    public double cubeRoot(int a) { return Math.cbrt(a); }
    public int randomInRange(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public double maxOfTwo(int a, int b) { return Math.max(a, b); }
    public double minOfTwo(int a, int b) { return Math.min(a, b); }
    public double factorial(int a) { return a == 0 ? 1 : a * factorial(a - 1); }

    // Financial Functions
    public double simpleInterest(double principal, double rate, double time) {
        double interest = principal * rate * time / 100;
        return Math.round(interest * 100.0) / 100.0;  // Round to 2 decimal places
    }

    public double compoundInterest(double principal, double rate, double time) {
        double interest = principal * Math.pow(1 + rate / 100, time) - principal;
        return Math.round(interest * 100.0) / 100.0;  // Round to 2 decimal places
    }

    // Trigonometric Functions
    public double sine(int a) {
        return Math.round(Math.sin(Math.toRadians(a)) * 10.0) / 10.0;
    }

    public double cosine(int a) {
        return Math.round(Math.cos(Math.toRadians(a)) * 10.0) / 10.0;
    }

    public double tangent(int a) {
        return Math.round(Math.tan(Math.toRadians(a)) * 10.0) / 10.0;
    }


    public double toRadians(int a) { return Math.toRadians(a); }
    public double toDegrees(int a) { return Math.toDegrees(a); }

    // Area, Volume, and Perimeter Calculations
    public double areaOfCircle(double radius) { return Math.PI * Math.pow(radius, 2); }
    public double areaOfRectangle(double length, double width) { return length * width; }
    public double areaOfTriangle(double base, double height) { return 0.5 * base * height; }
    public double volumeOfSphere(double radius) { return (4.0 / 3) * Math.PI * Math.pow(radius, 3); }
    public double volumeOfCylinder(double radius, double height) { return Math.PI * Math.pow(radius, 2) * height; }
    public double volumeOfCone(double radius, double height) { return (1.0 / 3) * Math.PI * Math.pow(radius, 2) * height; }
    public double perimeterOfCircle(double radius) { return 2 * Math.PI * radius; }
    public double perimeterOfRectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Length and width must be positive values.");
        }
        return 2 * (length + width);
    }


    // Unit conversions
    public double metersToKilometers(double meters) { return meters / 1000; }
    public double kilogramsToPounds(double kilograms) { return kilograms * 2.20462; }

    // Other conversion functions (Temperature, Distance, Weight, Speed)
    public double kilometersToMiles(double kilometers) { return kilometers * 0.621371; }
    public double milesToKilometers(double miles) { return miles / 0.621371; }
    public double inchesToCentimeters(double inches) { return inches * 2.54; }
    public double centimetersToInches(double centimeters) {
        return Math.round((centimeters / 2.54) * 100.0) / 100.0;
    }

    public double poundsToKilograms(double pounds) {
        return Math.round((pounds / 2.20462) * 100.0) / 100.0;
    }

    public double kilogramsToGrams(double kilograms) { return kilograms * 1000; }

    public double celsiusToFahrenheit(double celsius) { return (celsius * 9 / 5) + 32; }
    public double fahrenheitToCelsius(double fahrenheit) { return (fahrenheit - 32) * 5 / 9; }
    public double celsiusToKelvin(double celsius) { return celsius + 273.15; }
    public double kelvinToCelsius(double kelvin) { return kelvin - 273.15; }
    public double kmphToMph(double kmph) { return kmph * 0.621371; }
    public double mphToKmph(double mph) {
        return Math.round((mph / 0.621371) * 100.0) / 100.0;
    }


    // Modular Arithmetic
    public int powerModulo(int base, int exponent, int modulus) { return (int) Math.pow(base, exponent) % modulus; }

    // Statistical Functions
    public double mean(int[] values) { return sum(values) / values.length; }
    public double variance(int[] values) {
        double mean = mean(values);
        double sumOfSquares = 0;
        for (int value : values) {
            sumOfSquares += Math.pow(value - mean, 2);
        }
        return sumOfSquares / values.length;
    }
    public double standardDeviation(int[] values) { return Math.sqrt(variance(values)); }

    public double sum(int[] values) {
        double sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }
    public static double logarithmBase2(double num) {
        return Math.log(num) / Math.log(2);
    }

    public static double monthlyLoanPayment(double principal, double annualRate, int months) {
        if (principal == 0 || months == 0) {
            return 0.0;
        }

        double monthlyRate = annualRate / 100 / 12; // Convert annual rate to monthly rate
        double payment = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);

        return Math.round(payment * 100.0) / 100.0; // Round the result to 2 decimal places
    }


    public static double futureValueOfInvestment(double presentValue, double annualRate, int years) {
        return presentValue * Math.pow(1 + annualRate / 100, years);
    }

    public static double netPresentValue(double[] cashFlows, double discountRate) {
        double npv = 0;
        for (int t = 0; t < cashFlows.length; t++) {
            npv += cashFlows[t] / Math.pow(1 + discountRate / 100, t);
        }
        return npv;
    }

    public static double hoursToMinutes(double hours) {
        return hours * 60;
    }

    public static double minutesToHours(double minutes) {
        return minutes / 60;
    }
    public static double daysToHours(double days) {
        return days * 24;
    }
    public static double hoursToDays(double hours) {
        return hours / 24;
    }
}
