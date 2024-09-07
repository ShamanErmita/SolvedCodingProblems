import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        // Initialize the result list to store all possible combinations
        List<String> result = new ArrayList<>();

        // Returns empty result list if the input digits string is null or empty
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Map to store the a telephone keypad
        Map<Character,String> digitToLetters = new HashMap<>();
        
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), result, digitToLetters);

        return result;
    }

    // Function that generates all the combinations
    private void backtrack(String digits, int index,StringBuilder combination,List<String> result,Map<Character,String> digitToLetters){
        /*
        If the current index is equal to the input digits length,
        it means we found a combination, so we add it to the result
        */
        if(index == digits.length()){
            result.add(combination.toString());
        }
        else{
             // Get the letters corresponding to the current digit
            String letters = digitToLetters.get(digits.charAt(index));
            int numberOfLetters = letters.length();

            // Iterate through each letter that the current digit can represent
            for(int i =0; i < numberOfLetters; i++){
                // Append the current letter to the combination
                combination.append(letters.charAt(i));

                // Recursively call the function for the next digit
                backtrack(digits, index+1, combination, result, digitToLetters);

                // Remove the last character to backtrack and test another possibility
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }
}