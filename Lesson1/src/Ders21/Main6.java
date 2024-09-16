package Ders21;

import java.math.BigInteger;
import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        List<Integer> layer = new ArrayList<>(List.of(1, 1, 1, 1, 2));
        System.out.println(findMinGeneration2(layer));
    }

//    public static long getMaxProfit(List<Integer> pnl, int k) {
//        System.out.println(pnl);
//        long negativeCount = pnl.stream()
//                .filter(n -> n < 0)
//                .count();
//         if(negativeCount<k){
//             return -1;
//         }
//
//        long positiveSum = 0;
//        List<Integer> negativeNumbers = new ArrayList<>();
//
//        for (int num : pnl) {
//            if (num >= 0) {
//                positiveSum += num;
//            } else {
//                negativeNumbers.add(num);
//            }
//        }
//
//        Collections.sort(negativeNumbers, Collections.reverseOrder());
//
//
//        long smallestNegativeSum = 0;
//        for (int i = 0; i < k && i < negativeNumbers.size(); i++) {
//            smallestNegativeSum += negativeNumbers.get(i);
//        }
//   long profit=positiveSum + smallestNegativeSum;
//        if(profit>=0){
//            return profit;
//        }else {
//            return -1;
//        }
//
//    }
//public static long getMaxProfit(List<Integer> pnl, int k) {
//    System.out.println(pnl);
//    long negativeCount = pnl.stream()
//            .filter(n -> n < 0)
//            .count();
//
//    if (negativeCount < k) {
//        return -1;
//    }
//
//    long positiveSum = 0;
//    List<Integer> negativeNumbers = new ArrayList<>();
//
//    for (int num : pnl) {
//        if (num >= 0) {
//            positiveSum += num;
//        } else {
//            negativeNumbers.add(num);
//        }
//    }
//
//    Collections.sort(negativeNumbers, Collections.reverseOrder());
//    System.out.println(negativeNumbers);
//    long smallestNegativeSum = 0;
//    for (int i = 0; i < k && i < negativeNumbers.size(); i++) {
//        smallestNegativeSum += negativeNumbers.get(i);
//    }
//    System.out.println(smallestNegativeSum);
//
//    long profit = positiveSum + smallestNegativeSum;
//
//    return profit >= 0 ? profit : -1;
//}
//}


//
//
//
//public static long getMaxProfit(List<Integer> pnl, int k) {
//    System.out.println(pnl);
//
//    // Convert list to BigInteger list for safe calculations
//    List<BigInteger> bigPnl = new ArrayList<>();
//    for (int num : pnl) {
//        bigPnl.add(BigInteger.valueOf(num));
//    }
//
//    // Count negatives
//    long negativeCount = bigPnl.stream()
//            .filter(n -> n.signum() < 0)
//            .count();
//
//    if (negativeCount < k) {
//        return -1;
//    }
//
//    // Separate positives and negatives
//    BigInteger positiveSum = BigInteger.ZERO;
//    List<BigInteger> negativeNumbers = new ArrayList<>();
//
//    for (BigInteger num : bigPnl) {
//        if (num.signum() >= 0) {
//            positiveSum = positiveSum.add(num);
//        } else {
//            negativeNumbers.add(num);
//        }
//    }
//
//    // Sort negatives in reverse order
//    Collections.sort(negativeNumbers, Collections.reverseOrder());
//
//    // Sum the k smallest negatives
//    BigInteger smallestNegativeSum = BigInteger.ZERO;
//    for (int i = 0; i < k && i < negativeNumbers.size(); i++) {
//        smallestNegativeSum = smallestNegativeSum.add(negativeNumbers.get(i));
//    }
//
//    // Calculate profit
//    BigInteger profit = positiveSum.add(smallestNegativeSum);
//
//    // Convert profit to long
//    long profitLong = profit.signum() >= 0 ? profit.longValue() : -1;
//
//    return profitLong;
//}


    public static long findMinGeneration(List<Integer> layer) {
        OptionalInt maxIndex = java.util.stream.IntStream.range(0, layer.size())
                .reduce((i, j) -> layer.get(i) >= layer.get(j) ? i : j);

        if (maxIndex.isPresent()) {
            int index = maxIndex.getAsInt();
            int max = layer.get(index);


            int evenCount = 0;
            int oddCount = 0;

            for (int num : layer) {
                if (num % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            System.out.println(evenCount);
            System.out.println(oddCount);
            if (evenCount > oddCount && max % 2 == 1) {
                max++;
            } else if (oddCount > evenCount && max % 2 == 0) {
                max++;
            }


            int index2 = 0;
            int generation = 1;
            System.out.println(generation);
            while (index2 < layer.size() && layer.get(index2) != max) {

                if (generation % 2 == 0) {
                    if (layer.get(index2) + 2 <= max) {
                        layer.set(index2, layer.get(index2) + 2);
                        generation++;
                    } else {
                        generation++;
                    }

                } else {
                    if (max - layer.get(index2) == 2) {
                        generation++;
                    } else {
                        layer.set(index2, layer.get(index2) + 1);
                        generation++;
                    }
                }
                if (layer.get(index2) == max) {
                    index2++;
                    if (index2 == index) {
                        index2++;
                    }
                }

                System.out.println(layer);
                System.out.println(generation);
            }
            return --generation;


        } else {
            throw new IllegalStateException("Unexpected state: max index is not present");
        }

    }

    public static long findMinGeneration2(List<Integer> layer) {
        int maxValue = layer.stream().mapToInt(Integer::intValue).max().orElseThrow();

        long minGenerations = Long.MAX_VALUE;

        // Check target values from maxValue up to maxValue + 2
        for (int target = maxValue; target <= maxValue + 2; target++) {
            int finalTarget = target;
            long totalDeficit = layer.stream().mapToLong(neurons -> finalTarget - neurons).sum();
            long generations = calculateGenerations(totalDeficit);
            minGenerations = Math.min(minGenerations, generations);
        }

        return minGenerations;
    }

    private static long calculateGenerations(long deficit) {
        // Calculate the minimum number of generations required
        // For each generation, we can either add 2 (if even) or 1 (if odd)
        long evenGenerations = deficit / 2;
        long remainder = deficit % 2;

        // If there's a remainder, we need one more generation
        if (remainder == 0) {
            return evenGenerations * 2;
        } else {
            return evenGenerations * 2 + 1;
        }
    }
}
