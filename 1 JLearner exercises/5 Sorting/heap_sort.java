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
