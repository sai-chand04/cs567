package com.example;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleJavaAppTest {
    Scanner scanner = Mockito.mock(Scanner.class);
    SimpleJavaApp app = new SimpleJavaApp(scanner);

    // ============================================================================
    //                         PROPERTY-BASED TESTS (RANDOMLY GENERATED)
    // ============================================================================

    @Property
    public void testAddition(@ForAll int a, @ForAll int b) {
        System.out.println("Testing addition with a = " + a + ", b = " + b);
        Assertions.assertEquals(a + b, app.add(a, b), "Addition failed for inputs: " + a + " and " + b);
    }

    @Property
    public void testSubtract(@ForAll int a, @ForAll int b) {
        Assertions.assertEquals(a - b, app.subtract(a, b), "Subtraction failed for inputs: " + a + " and " + b);
    }

    @Property
    public void testMultiply(@ForAll int a, @ForAll int b) {
        Assertions.assertEquals(a * b, app.multiply(a, b), "Multiplication failed for inputs: " + a + " and " + b);
    }

    @Property
    public void testDivide(@ForAll int a, @ForAll int b) {
        if (b == 0) {
            return;
        }
        double result = app.divide(a, b);
        Assertions.assertEquals((double) a / b, result);
    }
    @Property
    public void testModulo(@ForAll int a, @ForAll int b) {
        if (b == 0) {
            return;
        }
        int expected = a % b;
        Assertions.assertEquals(expected, app.modulus(a, b), "Modulo failed for inputs: " + a + " and " + b);
    }


    @Property
    public void testExponentiate(@ForAll int base, @ForAll int exponent) {
        double result = app.exponentiate(base, exponent);
        double expected = Math.pow(base, exponent);
        Assertions.assertEquals(expected, result, "Exponentiation failed for base: " + base + " and exponent: " + exponent);
    }


    @Property
    public void testSqrt(@ForAll int number) {
        if (number < 0) {
            Assertions.assertTrue(Double.isNaN(app.sqrt(number)), "Square root failed for negative number: " + number);
        } else {
            double expected = Math.sqrt(number);
            Assertions.assertEquals(expected, app.sqrt(number), "Square root failed for: " + number);
        }
    }

    @Property
    public void testCubeRoot(@ForAll int number) {
        double expected = Math.cbrt(number);
        Assertions.assertEquals(expected, app.cubeRoot(number), "Cube root failed for: " + number);
    }

    // ============================================================================
    //                         MANUAL TESTS (UNIT TESTS WITH PREDEFINED INPUTS)
    // ============================================================================

    @Test
    public void testMainMethod() {
        String userInput = "10\n5";

        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        SimpleJavaApp app = Mockito.spy(new SimpleJavaApp(scanner));

        SimpleJavaApp.main(new String[]{});

        String output = outContent.toString();

        // Basic Operations
        Assertions.assertTrue(output.contains("Addition: 15"), "Output should contain Addition: 15");
        Assertions.assertTrue(output.contains("Subtraction: 5"), "Output should contain Subtraction: 5");
        Assertions.assertTrue(output.contains("Multiplication: 50"), "Output should contain Multiplication: 50");
        Assertions.assertTrue(output.contains("Division: 2.0"), "Output should contain Division: 2.0");
        Assertions.assertTrue(output.contains("Modulus: 0"), "Output should contain Modulus: 0");
        Assertions.assertTrue(output.contains("Exponentiation: 100000.0"), "Output should contain Exponentiation: 100000.0");

        // Extra functions
        Assertions.assertTrue(output.contains("Factorial of first number: 3628800.0"), "Output should contain Factorial of first number: 3628800.0");
        Assertions.assertTrue(output.contains("Power of first number raised to second number: 100000.0"), "Output should contain Power of first number raised to second number");
        Assertions.assertTrue(output.contains("Logarithm (base 10) of first number: 1.0"), "Output should contain Logarithm base 10");
        Assertions.assertTrue(output.contains("Sine of first number: 0.2"), "Output should contain Sine");
        Assertions.assertTrue(output.contains("Cosine of first number: 1.0"), "Output should contain Cosine");
        Assertions.assertTrue(output.contains("Tangent of first number: 0.2"), "Output should contain Tangent");
        Assertions.assertTrue(output.contains("Convert first number from degrees to radians: 0.17453292519943295"), "Output should contain Radians");
        Assertions.assertTrue(output.contains("Convert first number from radians to degrees: 572.9577951308232"), "Output should contain Degrees");

        // Additional methods
        Assertions.assertTrue(output.contains("Natural Logarithm of first number: 2.302585092994046"), "Output should contain Natural Logarithm");
        Assertions.assertTrue(output.contains("Round off first number to nearest integer: 10.0"), "Output should contain Rounded value");
        Assertions.assertTrue(output.contains("Ceiling of first number: 10.0"), "Output should contain Ceiling value");
        Assertions.assertTrue(output.contains("Floor of first number: 10.0"), "Output should contain Floor value");
        Assertions.assertTrue(output.contains("Cube root of first number: 2.154434690031884"), "Output should contain Cube Root");
        Assertions.assertTrue(output.contains("Random number between 1 and 100: "), "Output should contain Random number");
        Assertions.assertTrue(output.contains("Max of first and second numbers: 10.0"), "Output should contain Max value");
        Assertions.assertTrue(output.contains("Min of first and second numbers: 5.0"), "Output should contain Min value");

        // Financial operations
        Assertions.assertTrue(output.contains("Simple Interest on first number at 5% for 1 year: 0.5"), "Output should contain Simple Interest");
        Assertions.assertTrue(output.contains("Compound Interest on first number at 5% for 1 year: 0.5"), "Output should contain Compound Interest");

        // Hyperbolic functions
        Assertions.assertTrue(output.contains("Hyperbolic Sine of first number: 11013.232874703393"), "Output should contain Hyperbolic Sine");
        Assertions.assertTrue(output.contains("Hyperbolic Cosine of first number: 11013.232920103324"), "Output should contain Hyperbolic Cosine");
        Assertions.assertTrue(output.contains("Hyperbolic Tangent of first number: 0.9999999958776927"), "Output should contain Hyperbolic Tangent");

        // Logarithm base 2
        Assertions.assertTrue(output.contains("Logarithm base 2 of first number: 3.3219280948873626"), "Output should contain Logarithm base 2");

        // Unit conversions
        Assertions.assertTrue(output.contains("Convert first number from meters to kilometers: 0.01"), "Output should contain Meters to Kilometers");
        Assertions.assertTrue(output.contains("Convert first number from kilograms to pounds: 22.0462"), "Output should contain Kilograms to Pounds");

        // Area and volume calculations
        Assertions.assertTrue(output.contains("Area of Circle with radius first number: 314.1592653589793"), "Output should contain Area of Circle");
        Assertions.assertTrue(output.contains("Area of Rectangle with length and width: 50.0"), "Output should contain Area of Rectangle");
        Assertions.assertTrue(output.contains("Area of Triangle with base and height: 25.0"), "Output should contain Area of Triangle");
        Assertions.assertTrue(output.contains("Volume of Sphere with radius: 4188.790204786391"), "Output should contain Volume of Sphere");
        Assertions.assertTrue(output.contains("Volume of Cylinder with radius and height: 1570.7963267948967"), "Output should contain Volume of Cylinder");
        Assertions.assertTrue(output.contains("Volume of Cone with radius and height: 523.5987755982989"), "Output should contain Volume of Cone");
        Assertions.assertTrue(output.contains("Perimeter of Circle with radius: 62.83185307179586"), "Output should contain Perimeter of Circle");
        Assertions.assertTrue(output.contains("Perimeter of Rectangle with length and width: 30.0"), "Output should contain Perimeter of Rectangle");

        // Financial calculations
        Assertions.assertTrue(output.contains("Monthly Loan Payment for principal, rate, months: 0.86"), "Output should contain Monthly Loan Payment");
        Assertions.assertTrue(output.contains("Future Value of Investment: 10.5"), "Output should contain Future Value of Investment");
        Assertions.assertTrue(output.contains("Net Present Value of Cash Flows: 3321.995464852608"), "Output should contain Net Present Value");

        // Temperature conversions
        Assertions.assertTrue(output.contains("Celsius to Fahrenheit: 50.0"), "Output should contain Celsius to Fahrenheit");
        Assertions.assertTrue(output.contains("Fahrenheit to Celsius: -12.222222222222221"), "Output should contain Fahrenheit to Celsius");
        Assertions.assertTrue(output.contains("Celsius to Kelvin: 283.15"), "Output should contain Celsius to Kelvin");
        Assertions.assertTrue(output.contains("Kelvin to Celsius: -263.15"), "Output should contain Kelvin to Celsius");

        // Distance conversions
        Assertions.assertTrue(output.contains("Kilometers to Miles: 6.21371"), "Output should contain Kilometers to Miles");
        Assertions.assertTrue(output.contains("Miles to Kilometers: 16.09344"), "Output should contain Miles to Kilometers");
        Assertions.assertTrue(output.contains("Inches to Centimeters: 25.4"), "Output should contain Inches to Centimeters");
        Assertions.assertTrue(output.contains("Centimeters to Inches: 3.94"), "Output should contain Centimeters to Inches");

        // Weight conversions
        Assertions.assertTrue(output.contains("Pounds to Kilograms: 4.54"), "Output should contain Pounds to Kilograms");
        Assertions.assertTrue(output.contains("Kilograms to Grams: 10000.0"), "Output should contain Kilograms to Grams");

        // Speed conversions
        Assertions.assertTrue(output.contains("Kmph to Mph: 6.21371"), "Output should contain Kmph to Mph");
        Assertions.assertTrue(output.contains("Mph to Kmph: 16.09"), "Output should contain Mph to Kmph");

        // Time conversions
        Assertions.assertTrue(output.contains("Hours to Minutes: 600.0"), "Output should contain Hours to Minutes");
        Assertions.assertTrue(output.contains("Minutes to Hours: 0.16666666666666666"), "Output should contain Minutes to Hours");
        Assertions.assertTrue(output.contains("Days to Hours: 240.0"), "Output should contain Days to Hours");
        Assertions.assertTrue(output.contains("Hours to Days: 0.4166666666666667"), "Output should contain Hours to Days");

        // Modular Arithmetic
        Assertions.assertTrue(output.contains("Power Modulo: 3"), "Output should contain Power Modulo");

        // Statistics
        Assertions.assertTrue(output.contains("Mean of numbers: 3.0"), "Output should contain Mean");
        Assertions.assertTrue(output.contains("Variance of numbers: 2.0"), "Output should contain Variance");
        Assertions.assertTrue(output.contains("Standard Deviation of numbers: 1.4142135623730951"), "Output should contain Standard Deviation");



        // Reset System.out and System.in to their original streams
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    public void testGetIntegerInput() {
        Mockito.when(scanner.nextInt()).thenReturn(5);
        int result = app.getIntegerInput("Enter a number: ");
        Assertions.assertEquals(5, result);
        Mockito.verify(scanner).nextInt();
        Mockito.when(scanner.nextInt()).thenThrow(new InputMismatchException()).thenReturn(10);
        result = app.getIntegerInput("Enter a number: ");
        Assertions.assertEquals(10, result);
        Mockito.verify(scanner, Mockito.times(3)).nextInt();
    }

    @Test
    public void testDivide() {
        Assertions.assertEquals(1.6666666666666667, app.divide(5, 3));
        Assertions.assertEquals(0.0, app.divide(5, 0));
        Assertions.assertEquals(0.25, app.divide(1, 4));
        Assertions.assertEquals(1.6666666666666667, app.divide(-5, -3));
        Assertions.assertEquals(0.0, app.divide(0, 0));
    }

    @Test
    public void testModulo() {
        Assertions.assertEquals(1, app.modulus(5, 2));
        Assertions.assertEquals(1, app.modulus(5, -2));
        Assertions.assertEquals(-1, app.modulus(-5, 2));
        Assertions.assertEquals(0, app.modulus(0, 5));

        try {
            app.modulus(5, 0);
            Assertions.fail("Should throw an ArithmeticException when dividing by zero");
        } catch (ArithmeticException e) {
            // Arithmetic Exception
        }
    }


    @Test
    public void testLogBaseE() {
        Assertions.assertEquals(0.0, app.logBaseE(1));
        Assertions.assertEquals(Math.log(10), app.logBaseE(10));
        Assertions.assertEquals(Math.log(100), app.logBaseE(100));
        Assertions.assertEquals(-1.0, app.logBaseE(0));
        Assertions.assertEquals(-1.0, app.logBaseE(-5));
    }

    @Test
    public void testRoundOff() {
        Assertions.assertEquals(5.0, app.roundOff(5), 0.0);
        Assertions.assertEquals(3.0, app.roundOff(3), 0.0);
        Assertions.assertEquals(0.0, app.roundOff(0), 0.0);
        Assertions.assertEquals(-3.0, app.roundOff(-3), 0.0);
    }

    @Test
    public void testCeilValue() {
        Assertions.assertEquals(5.0, app.ceilValue(5), 0.0);
        Assertions.assertEquals(3.0, app.ceilValue(3), 0.0);
        Assertions.assertEquals(0.0, app.ceilValue(0), 0.0);
        Assertions.assertEquals(-3.0, app.ceilValue(-3), 0.0);
    }

    @Test
    public void testFloorValue() {
        Assertions.assertEquals(5.0, app.floorValue(5), 0.0);
        Assertions.assertEquals(3.0, app.floorValue(3), 0.0);
        Assertions.assertEquals(0.0, app.floorValue(0), 0.0);
        Assertions.assertEquals(-3.0, app.floorValue(-3), 0.0);
    }


    @Test
    public void testRandomInRange() {
        for (int i = 0; i < 100; i++) {
            double result = app.randomInRange(1, 10);
            Assertions.assertTrue(result >= 1 && result <= 10, "Result out of range: " + result);
        }
    }


    @Test
    public void testMaxOfTwo() {
        Assertions.assertEquals(5.0, app.maxOfTwo(5, 3));
        Assertions.assertEquals(10.0, app.maxOfTwo(5, 10));
        Assertions.assertEquals(7.0, app.maxOfTwo(7, 7));
        Assertions.assertEquals(-1.0, app.maxOfTwo(-3, -1));
    }

    @Test
    public void testMinOfTwo() {
        Assertions.assertEquals(3.0, app.minOfTwo(5, 3));
        Assertions.assertEquals(5.0, app.minOfTwo(5, 10));
        Assertions.assertEquals(7.0, app.minOfTwo(7, 7));
        Assertions.assertEquals(-3.0, app.minOfTwo(-3, -1));
    }

    @Test
    public void testFactorial() {
        Assertions.assertEquals(1.0, app.factorial(0));
        Assertions.assertEquals(1.0, app.factorial(1));
        Assertions.assertEquals(2.0, app.factorial(2));
        Assertions.assertEquals(6.0, app.factorial(3));
        Assertions.assertEquals(120.0, app.factorial(5));
    }

    @Test
    public void testSimpleInterest() {
        Assertions.assertEquals(100.0, app.simpleInterest(1000, 5, 2));
        Assertions.assertEquals(0.0, app.simpleInterest(1000, 0, 2));
        Assertions.assertEquals(500.0, app.simpleInterest(1000, 10, 5));
        Assertions.assertEquals(0.0, app.simpleInterest(0, 10, 5));
    }

    @Test
    public void testCompoundInterest() {
        Assertions.assertEquals(102.5, app.compoundInterest(1000, 5, 2));
        Assertions.assertEquals(0.0, app.compoundInterest(1000, 0, 5));
        Assertions.assertEquals(0.0, app.compoundInterest(0, 5, 5));
        Assertions.assertEquals(1000.0, app.compoundInterest(1000, 100, 1));
        Assertions.assertEquals(130501.26, app.compoundInterest(1000, 5, 100));
        Assertions.assertEquals(-102.5, app.compoundInterest(-1000, 5, 2));
    }

    @Test
    public void testSine() {
        Assertions.assertEquals(0.0, app.sine(0));
        Assertions.assertEquals(1.0, app.sine(90));
        Assertions.assertEquals(0.0, app.sine(180));
        Assertions.assertEquals(-1.0, app.sine(270));
        Assertions.assertEquals(0.0, app.sine(360));
    }

    @Test
    public void testCosine() {
        Assertions.assertEquals(1.0, app.cosine(0));
        Assertions.assertEquals(0.0, app.cosine(90));
        Assertions.assertEquals(-1.0, app.cosine(180));
        Assertions.assertEquals(0.0, app.cosine(270));
        Assertions.assertEquals(1.0, app.cosine(360));
    }

    @Test
    public void testTangent() {
        Assertions.assertEquals(0.0, app.tangent(0));
        Assertions.assertEquals(1.0, app.tangent(45));
        Assertions.assertEquals(0.0, app.tangent(180));
        Assertions.assertEquals(-1.0, app.tangent(135));
        Assertions.assertEquals(0.0, app.tangent(360));
    }


    @Test
    public void testToRadians() {
        Assertions.assertEquals(0.0, app.toRadians(0));
        Assertions.assertEquals(Math.PI / 2, app.toRadians(90));
        Assertions.assertEquals(Math.PI, app.toRadians(180));
        Assertions.assertEquals(3 * Math.PI / 2, app.toRadians(270));
        Assertions.assertEquals(2 * Math.PI, app.toRadians(360));
    }

    @Test
    public void testToDegrees() {
        Assertions.assertEquals(0.0, app.toDegrees(0));
        Assertions.assertEquals(57.29577951308232, app.toDegrees((int) (Math.PI / 2)));
        Assertions.assertEquals(171.88733853924697, app.toDegrees((int) Math.PI));
        Assertions.assertEquals(229.1831180523293, app.toDegrees((int) (3 * Math.PI / 2)));
        Assertions.assertEquals(343.77467707849394, app.toDegrees((int) (2 * Math.PI)));
    }

    @Test
    public void testAreaOfCircle() {
        Assertions.assertEquals(78.53981633974483, app.areaOfCircle(5));
        Assertions.assertEquals(0.0, app.areaOfCircle(0));
        Assertions.assertEquals(3.141592653589793, app.areaOfCircle(1));
    }

    @Test
    public void testAreaOfRectangle() {
        Assertions.assertEquals(20.0, app.areaOfRectangle(5, 4));
        Assertions.assertEquals(0.0, app.areaOfRectangle(0, 4));
        Assertions.assertEquals(0.0, app.areaOfRectangle(5, 0));
    }

    @Test
    public void testAreaOfTriangle() {
        Assertions.assertEquals(10.0, app.areaOfTriangle(5, 4));
        Assertions.assertEquals(0.0, app.areaOfTriangle(0, 4));
        Assertions.assertEquals(0.0, app.areaOfTriangle(5, 0));
    }

    @Test
    public void testVolumeOfSphere() {
        Assertions.assertEquals(523.5987755982989, app.volumeOfSphere(5));
        Assertions.assertEquals(0.0, app.volumeOfSphere(0));
    }

    @Test
    public void testVolumeOfCylinder() {
        Assertions.assertEquals(785.3981633974483, app.volumeOfCylinder(5, 10));
        Assertions.assertEquals(0.0, app.volumeOfCylinder(0, 10));
        Assertions.assertEquals(0.0, app.volumeOfCylinder(5, 0));
    }

    @Test
    public void testVolumeOfCone() {
        Assertions.assertEquals(261.79938779914943, app.volumeOfCone(5, 10));
        Assertions.assertEquals(0.0, app.volumeOfCone(0, 10));
        Assertions.assertEquals(0.0, app.volumeOfCone(5, 0));
    }

    @Test
    public void testPerimeterOfCircle() {
        Assertions.assertEquals(31.41592653589793, app.perimeterOfCircle(5));
        Assertions.assertEquals(0.0, app.perimeterOfCircle(0));
    }

    @Test
    public void testPerimeterOfRectangle() {
        Assertions.assertEquals(18.0, app.perimeterOfRectangle(5, 4));
        Assertions.assertEquals(10.0, app.perimeterOfRectangle(3, 2));
        Assertions.assertEquals(20.0, app.perimeterOfRectangle(7, 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> app.perimeterOfRectangle(0, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> app.perimeterOfRectangle(5, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> app.perimeterOfRectangle(-5, 4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> app.perimeterOfRectangle(5, -4));
        Assertions.assertThrows(IllegalArgumentException.class, () -> app.perimeterOfRectangle(-5, -4));
    }

    @Test
    public void testMetersToKilometers() {
        Assertions.assertEquals(5.0, app.metersToKilometers(5000));
        Assertions.assertEquals(0.0, app.metersToKilometers(0));
    }

    @Test
    public void testKilogramsToPounds() {
        Assertions.assertEquals(11.0231, app.kilogramsToPounds(5));
        Assertions.assertEquals(0.0, app.kilogramsToPounds(0));
    }

    @Test
    public void testKilometersToMiles() {
        Assertions.assertEquals(3.106855, app.kilometersToMiles(5));
        Assertions.assertEquals(0.0, app.kilometersToMiles(0));
    }

    @Test
    public void testMilesToKilometers() {
        Assertions.assertEquals(8.046722489462816, app.milesToKilometers(5));
        Assertions.assertEquals(0.0, app.milesToKilometers(0));
    }

    @Test
    public void testInchesToCentimeters() {
        Assertions.assertEquals(12.7, app.inchesToCentimeters(5));
        Assertions.assertEquals(0.0, app.inchesToCentimeters(0));
    }

    @Test
    public void testCentimetersToInches() {
        Assertions.assertEquals(1.97, app.centimetersToInches(5.0));
        Assertions.assertEquals(3.94, app.centimetersToInches(10.0));
        Assertions.assertEquals(0.0, app.centimetersToInches(0.0));
        Assertions.assertEquals(39.37, app.centimetersToInches(100.0));
        Assertions.assertEquals(78.74, app.centimetersToInches(200.0));
    }

    @Test
    public void testPoundsToKilograms() {
        Assertions.assertEquals(0.45, app.poundsToKilograms(1.0));
        Assertions.assertEquals(2.27, app.poundsToKilograms(5.0));
        Assertions.assertEquals(45.36, app.poundsToKilograms(100.0));
        Assertions.assertEquals(113.4, app.poundsToKilograms(250.0));
        Assertions.assertEquals(226.8, app.poundsToKilograms(500.0));
    }

    @Test
    public void testKilogramsToGrams() {
        Assertions.assertEquals(5000.0, app.kilogramsToGrams(5));
        Assertions.assertEquals(0.0, app.kilogramsToGrams(0));
    }

    @Test
    public void testCelsiusToFahrenheit() {
        Assertions.assertEquals(41.0, app.celsiusToFahrenheit(5));
        Assertions.assertEquals(32.0, app.celsiusToFahrenheit(0));
    }

    @Test
    public void testFahrenheitToCelsius() {
        Assertions.assertEquals(-15.0, app.fahrenheitToCelsius(5));
        Assertions.assertEquals(0.0, app.fahrenheitToCelsius(32));
    }

    @Test
    public void testCelsiusToKelvin() {
        Assertions.assertEquals(278.15, app.celsiusToKelvin(5));
        Assertions.assertEquals(273.15, app.celsiusToKelvin(0));
    }

    @Test
    public void testKelvinToCelsius() {
        Assertions.assertEquals(-268.15, app.kelvinToCelsius(5));
        Assertions.assertEquals(0.0, app.kelvinToCelsius(273.15));
    }

    @Test
    public void testKmphToMph() {
        Assertions.assertEquals(3.106855, app.kmphToMph(5));
        Assertions.assertEquals(0.0, app.kmphToMph(0));
    }

    @Test
    public void testMphToKmph() {
        Assertions.assertEquals(8.05, app.mphToKmph(5));
        Assertions.assertEquals(0.0, app.mphToKmph(0));
    }

    @Test
    public void testPowerModulo() {
        Assertions.assertEquals(3, app.powerModulo(2, 3, 5));
        Assertions.assertEquals(4, app.powerModulo(3, 4, 7));
        Assertions.assertEquals(1, app.powerModulo(5, 0, 3));
        Assertions.assertEquals(9, app.powerModulo(7, 2, 10));
        Assertions.assertEquals(4, app.powerModulo(10, 3, 6));
        Assertions.assertEquals(0, app.powerModulo(10, 5, 2));
        Assertions.assertEquals(3, app.powerModulo(3, 3, 4));
        Assertions.assertEquals(1, app.powerModulo(4, 2, 3));
        Assertions.assertEquals(0, app.powerModulo(0, 5, 3));
    }

    @Test
    public void testMean() {
        int[] values = {1, 2, 3, 4, 5};
        Assertions.assertEquals(3.0, app.mean(values));
    }

    @Test
    public void testVariance() {
        int[] values = {1, 2, 3, 4, 5};
        Assertions.assertEquals(2.0, app.variance(values));
    }

    @Test
    public void testStandardDeviation() {
        int[] values = {1, 2, 3, 4, 5};
        Assertions.assertEquals(1.4142135623730951, app.standardDeviation(values));
    }

    @Test
    public void testSum() {
        int[] values = {1, 2, 3, 4, 5};
        Assertions.assertEquals(15.0, app.sum(values));
    }

    @Test
    public void testLogarithmBase2() {
        Assertions.assertEquals(3.0, app.logarithmBase2(8));
        Assertions.assertEquals(0.0, app.logarithmBase2(1));
    }

    @Test
    public void testMonthlyLoanPayment() {
        Assertions.assertEquals(85.61, app.monthlyLoanPayment(1000, 5, 12));
        Assertions.assertEquals(0.0, app.monthlyLoanPayment(0, 5, 12));
        Assertions.assertEquals(0.0, app.monthlyLoanPayment(1000, 5, 0));
        Assertions.assertEquals(92.63, app.monthlyLoanPayment(1000, 20, 12));
        Assertions.assertEquals(89.84, app.monthlyLoanPayment(5000, 3, 60));
        Assertions.assertEquals(1004.17, app.monthlyLoanPayment(1000, 5, 1));
    }


    @Test
    public void testFutureValueOfInvestment() {
        Assertions.assertEquals(1276.2815625000003, app.futureValueOfInvestment(1000, 5, 5));
    }

    @Test
    public void testNetPresentValue() {
        double[] cashFlows = {1000, 2000, 3000};
        Assertions.assertEquals(5625.850340136054, app.netPresentValue(cashFlows, 5));
    }

    @Test
    public void testHoursToMinutes() {
        Assertions.assertEquals(120.0, app.hoursToMinutes(2));
    }

    @Test
    public void testMinutesToHours() {
        Assertions.assertEquals(2.0, app.minutesToHours(120));
    }

    @Test
    public void testDaysToHours() {
        Assertions.assertEquals(48.0, app.daysToHours(2));
    }

    @Test
    public void testHoursToDays() {
        Assertions.assertEquals(2.0, app.hoursToDays(48));
    }
}


