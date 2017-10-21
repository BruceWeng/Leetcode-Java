import java.util.*;
// There are 1000 buckets, one and only one of them contains poison, the rest
// are filled with water. They all look the same. If a pig drinks that poison
// it will die within 15 minutes. What is the minimum amount of pigs you need
// to figure out which bucket contains the poison within one hour.

// Pigs are allowed to drink water any amount of bucket of water at one time,
// and not allow to drink water in the following n minutes. Ex: Pigs allow to
// drink at minute 0, 15, 30...and not allow a drink other bucket during the
// period. Numbers of pigs is the dimension of size (minutesToTest/minutesToDie)
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
         int pigs = 1;
         while (Math.pow((minutesToTest/minutesToDie + 1), pigs) < buckets) {
           pigs += 1;
         }

         return pigs;
    }

    public static void main(String[] args) {
      Solution sol = new Solution();
      System.out.println(sol.poorPigs(1000, 15, 60) == 5);
    }
}
