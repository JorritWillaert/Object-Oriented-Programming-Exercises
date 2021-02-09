class TreeNode{
	TreeNode firstChild;
  	TreeNode nextSibling;
  	int value;
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
