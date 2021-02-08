int selectionSort(int[] array){
	for (int n = 1; n <= array.length; n++){
    	int max = removeGreatest(array, n);
      	array[n - 1] = max;
    }
}

int removeGreatest(int[] array, int n){
  	int max = 0;
  	int index = 0;
	for (int i = 0; i < n; i++){
    	if (array[i] > max){
        	max = array[i];
          	index = i;
        }
    }
  	for (int j = index; j < n - 1; j++){
    	array[j] = array[j + 1];
    }
  	return max;
}
