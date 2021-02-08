int number_of_zeros(int[] array){
  int count = 0;
  for (int i = 0; i < array.length; i++)
    if (array[i] == 0){
    	count += 1;
    }
  return count;
}
