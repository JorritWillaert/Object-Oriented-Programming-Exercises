int[] replace_by_negation(int[] array) {
    int[] neg_array = new int[array.length];
    for (int i = 0; i < array.length; i++)
		neg_array[i] = - array[i];
    return neg_array;
}
