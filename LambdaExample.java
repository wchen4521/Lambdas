import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * LambdaExample class represents a a simple lambda expression and a Lambda Block to find the minimum, maximum, average
 * and median of numbers.
 *
 * How to run:
 * 1. Run the program.
 * 2. Then the program will display the minimum, maximum, average and median of numbers.
 *
 * Example:
 *
 * Output:
 * Min Value: 1.8
 * Max Value: 95.97
 * Average Value: 42.21999999999999
 * Median Value: 36.545
 */
public class LambdaExample {
    /**
     * main process
     * @param args
     */
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Collections.addAll(numbers, 17.64, 55.56, 36.93, 55.96, 20.23, 41.74, 1.8, 95.97, 81.89, 36.16, 34.41, 87.9, 13.74, 11.15);

        // Lambda expressions for minimum, maximum, and average
        double minValue = findValue(numbers, (a, b) -> a < b ? a : b);
        double maxValue = findValue(numbers, (a, b) -> a > b ? a : b);
        double aveValue = calculateAverage(numbers);

        // Print results for minimum, maximum, and average
        System.out.println("Min Value: " + minValue);
        System.out.println("Max Value: " + maxValue);
        System.out.println("Average Value: " + aveValue);

        // Lambda block for median calculation
        Collections.sort(numbers);
        Double midValue = findMedian(numbers, (list) -> {
            int size = list.size();
            if (size % 2 == 0) {
                int mid1 = size / 2 - 1;
                int mid2 = size / 2;
                return (list.get(mid1) + list.get(mid2)) / 2.0;
            } else {
                int mid = size / 2;
                return list.get(mid).doubleValue();
            }
        });

        // Print result for median
        System.out.println("Median Value: " + midValue);
    } //end main()

    /**
     * Finds the minimum or maximum value in a list using a Lambda expression.
     *
     * @param list   The list of numbers to find the value from.
     * @param finder The Lambda expression defining the logic for finding the value.
     * @return The minimum or maximum value in the list.
     */
    private static Double findValue(List<Double> list, ValueFinder finder) {
        if (list.isEmpty()) {
            return null;
        }

        Double result = list.get(0);
        for (Double value : list) {
            result = finder.find(result, value);
        }

        return result;
    } //end findValue

    /**
     * Calculates the average value of a list of numbers.
     *
     * @param list The list of numbers to calculate the average from.
     * @return The average value of the list.
     */
    private static Double calculateAverage(List<Double> list) {
        if (list.isEmpty()) {
            return null;
        }

        double sum = 0;
        for (Double value : list) {
            sum += value;
        }

        return sum / list.size();
    } //end calculateAverage

    /**
     * Finds the median value of a sorted list using a Lambda block.
     *
     * @param list   The sorted list of numbers to find the median from.
     * @param finder The Lambda block defining the logic for finding the median.
     * @return The median value of the list.
     */
    private static Double findMedian(List<Double> list, MedianFinder finder) {
        if (list.isEmpty()) {
            return null;
        }

        return finder.find(list);
    } //end findMedian

    /**
     * Functional interface for Lambda expressions to find the minimum or maximum value.
     */
    private interface ValueFinder {
        Double find(Double a, Double b);
    } //end interface ValueFinder

    /**
     * Functional interface for Lambda block to find the median value.
     */
    private interface MedianFinder {
        Double find(List<Double> list);
    } //end interface MedianFinder
} //end class LambdaExample
