int[] merge(int[] array1, int[] array2){
	int[] merged_array = new int[array1.length + array2.length];
  	int index1 = 0;
  	int index2 = 0;
  	for (int i = 0; i < array1.length + array2.length; i++){
      if (index1 == array1.length){
      	fillInRest(merged_array, index1 + index2, index2, array2);
      } else if (index2 == array2.length){
      	fillInRest(merged_array, index1 + index2, index1, array1);
      } else {
            if (array1[index1] < array2[index2]){
                merged_array[index1 + index2] = array1[index1];
                index1++;
            } else {
            	merged_array[index1 + index2] = array2[index2];
                index2++;
            }
      }
    }
  return merged_array;
}

void fillInRest(int[] merged_array, int n, int index, int[] array){
	for (int i = n; i < merged_array.length; i++){
    	merged_array[i] = array[index];
      	index++;
    }
}
