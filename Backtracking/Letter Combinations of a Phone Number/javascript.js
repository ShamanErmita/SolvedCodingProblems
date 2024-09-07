/**
 * @param {string} digits - A string of digits from '2' to '9'.
 * @return {string[]} - An array of all possible letter combinations that the digits can represent.
 */
var letterCombinations = function(digits) {
    // If the input string is empty, return an empty array
    if (!digits.length) {
        return [];
    }
    
    // Mapping of digits to their corresponding letters
    const digitToLetters = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    };
    
    // Array to store all possible combinations
    const result = [];

    // Function that generates all the combinations
    function backtrack(index, combination) {
        /*
        If the current index is equal to the input digits length,
        it means we found a combination, so we add it to the result
        */
        if (index === digits.length) {
            result.push(combination);
            return;
        }
        
        // Loop through each letter for the current digit
        for (const letter of digitToLetters[digits[index]]) {
            backtrack(index + 1, combination + letter);
        }
    }
    
    // Start the function with index 0 and an empty combination
    backtrack(0, "");
    
    return result;    
};