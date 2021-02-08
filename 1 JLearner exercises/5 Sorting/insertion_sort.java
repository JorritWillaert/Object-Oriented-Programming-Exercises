void insertionSort(int[] array){
	for (int n = 1; n < array.length; n++){
      	int value = array[n];
    	insert(array, n, value);
    }
}

void insert(int[] array, int n, int value){
	int i = 0;
  	while (array[i] < value){
    	i++;
    }
  	for (int j = n; j > i; j--){
    	array[j] = array[j - 1];
    }
  	array[i] = value;
}
