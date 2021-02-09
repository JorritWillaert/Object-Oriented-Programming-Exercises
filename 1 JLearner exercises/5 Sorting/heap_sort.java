int[] heapAdd(int[] array, int n){
  	while (n != 0 && array[n] > array[(n - 1) / 2]){
    	int child = array[n];
      	array[n] = array[(n - 1) / 2];
      	array[(n - 1) / 2] = child;
      	n = (n - 1) / 2;
    }
    return array;
}
