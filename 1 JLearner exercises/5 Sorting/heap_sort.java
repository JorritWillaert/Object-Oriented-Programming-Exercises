int[] heapSort(int[] array){
	int[] heap = new int[array.length];
  	heap[0] = array[0];
  	for (int i = 1; i < array.length; i++){
    	heapAdd(array, i);
    }
  	int[] sorted_array = new int[array.length];
  for (int i = array.length; i > 0; i--){
  		sorted_array[i - 1] = heapRemove(array, i);
  }
  return sorted_array;
}

int heapRemove(int[] array, int n){
  	int root = array[0];
  	array[0] = array[n - 1];
  	int i = 0;
  	int left_child = array[1];
  	int right_child = array[2];
	while (i <= (n - 1) / 2 && (array[i] < left_child || array[i] < right_child)){
    	int parent = array[i];
      	left_child = array[2 * i + 1];
      	boolean right_OK = false;
      	if (2 * i + 2 < n){
      		right_OK = true;
            right_child = array[2 * i + 2];
        }
      	if (right_OK == false || left_child > right_child){
        	swap(array, i, 2 * i + 1);
          	i = 2 * i + 1;
        } else {
        	swap(array, i, 2 * i + 2);
          	i = 2 * i + 2;
        }
    }
    return root;
}

void swap(int[] array, int parent, int child){
	int child_value = array[child];
    array[child] = array[parent];
    array[parent] = child_value;
}

void heapAdd(int[] array, int n){
  	while (n != 0 && array[n] > array[(n - 1) / 2]){
    	swap(array, (n - 1) / 2, n);
      	n = (n - 1) / 2;
    }
}
