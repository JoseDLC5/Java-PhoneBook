package sa2;
import java.util.ArrayList;


/**
 * BSFamilyTree creates a tree for specific families. 
 */
@SuppressWarnings("unused")
public class BSFamilyTree {
	private FamilyTreeNode root;

    /**
     * Constructor: constructs an empty BSFamilyTree
     */
    public BSFamilyTree() {
        root = null;
    }

    /**
     * takes in the last name and returns true if there
     * is a FamilyTreeNode with the given last name.
     */
    public boolean doesFamilyExist(String lastName) {
        FamilyTreeNode current = root;
        if(current == null) {
        	return false;
        }
       
        while(current != null) {
        	int comp = lastName.compareToIgnoreCase(current.getLastName());
        	if(comp == 0) {
        		return true;
        	}
        	else if(comp < 0) {
        		current = current.left;
        	}
        	else if(comp > 0) {
        		current = current.right;
        	}
        }
        
        return false;
    }
        
  

    /**
     * Takes in a last name and creates a new instance of
     * FamilyTreeNode and adds it to the BSFamilyTree.
     */
    public void addFamilyTreeNode(String lastName) {
    	if(doesFamilyExist(lastName)) {
    		throw new IllegalArgumentException("Only unique families can be added");
    	}
    	if(root == null) {
    		root = new FamilyTreeNode(lastName);
    		return;
    	}
    	
    	FamilyTreeNode current = root;
    	FamilyTreeNode trail = current;
    	
    	while(current != null) {
    		trail = current;
        	int comp = lastName.compareToIgnoreCase(current.getLastName());
        	if(comp < 0) {
        		current = current.left;
        	}
        	if(comp > 0) {
        		current = current.right;
        	}
        }
    	
    	int comp = lastName.compareToIgnoreCase(trail.getLastName());
    	
    	if(comp < 0) {
    		trail.left = new FamilyTreeNode(lastName);
    	}
    	if(comp > 0) {
    		trail.right = new FamilyTreeNode(lastName);
    	}
    	
    }

    /**
     * Takes a last name and then finds that specific
     * family tree and then returns that FamilyTreeNode
     * If last name is not in tree, throws an exception.
     */
    public FamilyTreeNode getFamilyTreeNode(String lastName) {
    	FamilyTreeNode current = root;
        if(current == null) {
        	throw new IllegalArgumentException("Name not in tree");
        }
       
        while(current != null) {
        	int comp = lastName.compareToIgnoreCase(current.getLastName());
        	if(comp == 0) {
        		return current;
        	}
        	else if(comp < 0) {
        		current = current.left;
        	}
        	else if(comp > 0) {
        		current = current.right;
        	}
        }
        
        throw new IllegalArgumentException("Name not in Tree");
    }

    /**
     * Returns true if the input phone number exists in the BSFamilyTree
     * false otherwise.
     */
    public boolean doesNumberExist(String phoneNumber) {
        return doesNumberExistHelper(phoneNumber, root);
    }
    
    private boolean doesNumberExistHelper(String phoneNumber, FamilyTreeNode current) {
    	if(current == null) {
    		return false;
    	}
    	if(current.doesNumberExist(phoneNumber)) {
    		return true;
    	}
    	else {
    		return doesNumberExistHelper(phoneNumber, current.left) || doesNumberExistHelper(phoneNumber,current.right);
    	}
    }

    /**
     * Returns the string representation of the BSFamilyTree
     */
    private StringBuilder toString(FamilyTreeNode current, int i) {
		StringBuilder r = new StringBuilder() ;
		for (int j=0; j<i; j++) {
			r.append("  ");
		}
		
		if (current==null) {
			r.append("null\n");
		} else {
			r.append(current.toString()+"\n");
			r.append(toString(current.left,i+1));
			r.append(toString(current.right,i+1));
			
		}
		return r;
		
	}
	public String toString() {	
		return this.toString(root, 0).toString();
	}
	
    
    public static void main(String[] args) {
    	BSFamilyTree a = new BSFamilyTree();
    	
    	//Normal
    	a.addFamilyTreeNode("Adams");
    	//a.addFamilyTreeNode("Abams");
    	a.addFamilyTreeNode("Axams");
    	
    	
    	//Error Tested
    	//a.addFamilyTreeNode("Adams");
    	
    	//True Tested
    	//System.out.println(a.doesFamilyExist("Adams"));
    	
    	//False Tested
    	//System.out.println(a.doesFamilyExist("Alex"));
    	
    	//Normal Tested
    	//a.getFamilyTreeNode("Adams").addFamilyMember("Adams", "John", "1111111111");
    	//a.getFamilyTreeNode("Abams").addFamilyMember("Abams", "John", "1111111111");
    	//a.getFamilyTreeNode("Axams").addFamilyMember("Axams", "John", "2111111111");
    	
    	
    	//Error Tested
    	//a.getFamilyTreeNode("Bill");
    	
    	//True Tested
    	//System.out.println(a.doesNumberExist("2111111111"));
    	
    	//False Tested
    	//System.out.println(a.doesNumberExist("1222222222"));
    	
    	
    	
    	System.out.println(a);
    }

}

