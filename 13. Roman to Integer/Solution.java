import java.util.*;
class Solution {
    //Input is guranteed to be within the range from 1 to 3999
    public int romanToInt(String s) {
      if (s == null || s.length() == 0) {
        return 0;
      }

      HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>();
      romanMap.put('I', 1);
      romanMap.put('V', 5);
      romanMap.put('X', 10);
      romanMap.put('L', 50);
      romanMap.put('C', 100);
      romanMap.put('D', 500);
      romanMap.put('M', 1000);

      int result = romanMap.get(s.charAt(0));

      for (int i = 1; i < s.length(); i++) {
        result += romanMap.get(s.charAt(i));

        if (romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i - 1))) {
          result -= romanMap.get(s.charAt(i - 1)) * 2;
        }
      }

      return result;
    }

    public static void main(String[] args) {
      Solution solution = new Solution();
      System.out.println(solution.romanToInt("I")); //1
      System.out.println(solution.romanToInt("IV")); //4
      System.out.println(solution.romanToInt("V")); //5
      System.out.println(solution.romanToInt("VI")); //6
      System.out.println(solution.romanToInt("IX")); //9
      System.out.println(solution.romanToInt("X")); //10
      System.out.println(solution.romanToInt("XIV")); //14
      System.out.println(solution.romanToInt("XV")); //15
      System.out.println(solution.romanToInt("XIX")); //19
      System.out.println(solution.romanToInt("XXX")); //30
      System.out.println(solution.romanToInt("XXXIX")); //39
      System.out.println(solution.romanToInt("XL")); //40
      System.out.println(solution.romanToInt("L")); //50
      System.out.println(solution.romanToInt("XC")); //90
      System.out.println(solution.romanToInt("C")); //100
      System.out.println(solution.romanToInt("D")); //500
      System.out.println(solution.romanToInt("M")); //1000
    }
}
