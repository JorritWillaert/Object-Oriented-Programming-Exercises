class TreeNode{
	TreeNode firstChild;
  	TreeNode nextSibling;
  	int value;
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
