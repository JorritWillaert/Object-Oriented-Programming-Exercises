boolean sortedVersionOfArray(int[] array, int[] sorted_array){
	if (array.length != sorted_array.length){
    	return false;
    }
  	if (isSorted(sorted_array) == false){ //JLearner does not allow to use the more convenient notation 'if (!isSorted(sorted_array))'
    	return false;
    }
  	if (permutationOfOtherArray(array, sorted_array) == false){ //JLearner does not allow to use the more convenient notation 'if (!isSorted(sorted_array))'
    	return false;
    }
  	return true;
}

boolean permutationOfOtherArray(int[] array1, int[] array2){
	if (array1.length != array2.length){
    	return false;
    }
  	for (int i = 0; i < array1.length; i++){
      	int value = array1[i];
    	if ((numberOfOccurences(array1, value) != numberOfOccurences(array2, value))){
        	return false;
        }
    }
  	return true;
}

int numberOfOccurences(int[] array, int value){
  	int count = 0;
	for (int i = 0; i < array.length; i++){
    	if (array[i] == value){
        	count++;
        }
    }
  	return count;
}

boolean isSorted(int[] array){
  	if (array.length == 1){
    return true;
    }
	for (int i = 1; i < array.length; i++){
    	if (array[i - 1] > array[i]){
        	return false;
        }
    }
  	return true;
}
