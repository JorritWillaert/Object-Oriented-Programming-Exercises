class TreeNode{
	TreeNode firstChild;
  	TreeNode nextSibling;
  	int value;
}

boolean validTree(TreeNode node){
  	TreeNode child = node.firstChild;
  	while (child.nextSibling != null){
    	if (leavesLessOrEqual(child, node.value) == false){ //JLearner does not know the more convenient notation 'if !(leavesLessOrEqual(child, child.value)'
        	return false;
        }
      	if (child.firstChild != null){
        	return validTree(child);
        }
      	child = child.nextSibling;
    }
    if (leavesLessOrEqual(child, node.value) == false){ //JLearner does not know the more convenient notation 'if !(leavesLessOrEqual(child, child.value)'
      	return false;
    }
    if (child.firstChild != null){
      	return validTree(child);
    }
  	return true;
}

boolean leavesLessOrEqual(TreeNode node, int value){
	int[] arrayValues = arrayLeafValues(node);
  	for (int i = 0; i < arrayValues.length; i++){
    	if (arrayValues[i] > value){
        	return false;
        }
    }
  	return true;
}

int[] arrayLeafValues(TreeNode node){
	int[] arrayValues = new int[numberOfLeaves(node)];
  	addLeafValues(node, arrayValues, 0);
  	return arrayValues;
}

int addLeafValues(TreeNode node, int[] array, int i){
  	if (node.firstChild == null){
      	array[i] = node.value;
      	i++;
     	return i;
    }
  	TreeNode child = node.firstChild;
	while (child.nextSibling != null){
    	i = addLeafValues(child, array, i++);
      	child = child.nextSibling;
    }
  	i = addLeafValues(child, array, i++);
 	return i;
}

int numberOfLeaves(TreeNode node){
  	int count = 1;
  	if (node.firstChild == null){
     	return 1;
    }
  	TreeNode child = node.firstChild;
	while (child.nextSibling != null){
    	count += numberOfLeaves(child);
      	child = child.nextSibling;
    }
 	return count;
}

TreeNode[] sequenceOfChildren(TreeNode node){
	TreeNode child = node.firstChild;
  	if (child == null){
    	return null;
    }
  	TreeNode[] old_sequence = new TreeNode[1];
  	old_sequence[0] = child;
  	int count = 1;
  	while (child.nextSibling != null){
    	TreeNode[] new_sequence = new TreeNode[old_sequence.length + 1];
      	copy(new_sequence, old_sequence);
      	new_sequence[count] = child.nextSibling;
      	count++;
      	child = child.nextSibling;
      	old_sequence = new_sequence;
    }
  	return old_sequence;
}

void copy(TreeNode[] new_array, TreeNode[] old_array) {
  for (int i = 0; i < old_array.length; i++)
    new_array[i] = old_array[i];
}

int numberOfChilds(TreeNode node){
  	TreeNode child = node.firstChild;
  	if (child == null){
    	return 0;
    }
    int count = 1;
  	while (child.nextSibling != null){
    	count++;
      	child = child.nextSibling;
    }
  	return count;
}
