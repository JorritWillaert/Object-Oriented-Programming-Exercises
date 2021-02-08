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
