from typing import List

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        # If the input is empty, return an empty list
        if not digits:
            return []
        
        # Mapping of digits to their corresponding letters
        digit_to_letters = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz',
        }

        # Function that generates all the combinations
        def backtrack(index, combination):

            #If the current index is equal to the input digits length,
            #it means we found a combination, so we add it to the result
            if index == len(digits):
                result.append(combination[:])
                return
            
            # Loop through each letter for the current digit
            for letter in digit_to_letters[digits[index]]:
                backtrack(index + 1, combination + letter)

        # List to store all possible combinations
        result = []

        # Start the function with index 0 and an empty combination
        backtrack(0, "")

        return result