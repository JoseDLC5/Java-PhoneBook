package sa2;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeNode {
	private String lastName;
	private List<Person> members;
	public FamilyTreeNode left;
	public FamilyTreeNode right;

	/**
     	* Constructor: instantializes a new FamilyTreeNode
     	* given a lastName
     	*/
	public FamilyTreeNode(String lastName) {
		this.lastName = lastName;
		members = new ArrayList<Person>();
		left = null;
		right = null;
	}

	/**
     	* Returns the last name of the FamilyTreeNode
     	*/
	public String getLastName() {
		return lastName;
	}

	/**
     	* Returns the arraylist of members in the FamilyTreeNode
     	*/
	public List<Person> getMembers() {
		return members;
	}

	/*
	 * Returns true if there is an instance of Person in the FamilyTreeNode that has
	 * the same first and last name provided Return false otherwise
	 */
	public boolean doesFamilyMemberExist(String lastName, String firstName) {
        	Boolean ans = false;
        	for (Person person : members) {
        		if(person.getFirstName() == firstName && person.getLastName() == lastName) {
        			ans = true;
        		}
        	}
        	return ans;
	}

	/**
	 * Returns true if there is an instance of Person in the FamilyTreeNode whose
	 * phone number matches the one provided Returns false otherwise
	 */
	public boolean doesNumberExist(String phoneNumber) {
		Boolean ans = false;
    	for (Person person : members) {
    		if(person.getPhoneNumber() == phoneNumber) {
    			ans = true;
    		}
    	}
    	return ans;
	}

	/*
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(String lastName, String firstName, String phoneNumber) {
		if(doesNumberExist(phoneNumber) || doesFamilyMemberExist(lastName,firstName)) {
			throw new IllegalArgumentException("Only unique names or numbers can be added");
		}
		if(lastName != this.lastName) {
			throw new IllegalArgumentException("Person does not have the same last name");
		}
		
		Person temp = new Person(lastName, firstName, phoneNumber);
		
		members.add(temp);
	}

	/**
	 * Adds a Person to this FamilyTreeNode
	 * Throw an exception if the last name provided does not match the last name of the FamilyTreeNode
	 */
	public void addFamilyMember(Person person) {
		if(doesNumberExist(person.getPhoneNumber()) || doesFamilyMemberExist(person.getLastName(),person.getFirstName())) {
			throw new IllegalArgumentException("Only unique names or numbers can be added");
		}
		if(person.getLastName() != lastName) {
			throw new IllegalArgumentException("Person does not have the same last name");
		}
		members.add(person);
	}

	/*
	 * Returns the phone number of the person in the family with the given phone
	 * number Returns "Does not exist." if not found
	 */
	public String getPhoneNumberOfFamilyMember(String lastName, String firstName) {
		String ans = "Does not exist.";
    	for (Person person : members) {
    		if(person.getFirstName() == firstName && person.getLastName() == lastName) {
    			ans = person.getPhoneNumber();
    			break;
    		}
    	}
    	return ans;
	}

	/*
	 * toString method Ex: [] [John Smith (5551234567), May Smith (5551234568),
	 * April Smith (5551234569), August Smith (5551234570)]
	 */
	public String toString() {
		StringBuilder r = new StringBuilder();
		
		r.append("[");
		
		for(Person person: members) {
			r.append(person.getFirstName());
			r.append(" ");
			r.append(person.getLastName());
			r.append(" ");
			r.append("(");
			r.append(person.getPhoneNumber());
			r.append("), ");
		}
		
		if(r.length() >= 2)
		{
			r.delete(r.length()-2,r.length());
		}
		
		r.append("]");
		
		
		
		return r.toString();
	}
	
	public static void main(String[] args) {
		FamilyTreeNode node = new FamilyTreeNode("Adams");
		
		
		//Tested
		//System.out.println(node.getLastName());
		
		//Tested
		//System.out.println(node.getMembers());
		
		//true case Tested
		//System.out.println(node.doesFamilyMemberExist("Adams", "Tessa"));
		
		//false case Tested
		//System.out.println(node.doesFamilyMemberExist("Adams", "Gram"));
		
		//True case Tested
		//System.out.println(node.doesNumberExist("1234567890"));
		
		//False case Tested
		//System.out.println(node.doesNumberExist(""));
		
		//Normal Tested
		//node.addFamilyMember(person);
		
		//Error
		//node.addFamilyMember(person2);
		
		//Normal Tested
		//node.addFamilyMember("Adams", "Tim", "3333333333");
		
		//Error Tested
		//node.addFamilyMember(lastName, firstName, phoneNumber);
		
		//Normal Tested
		//System.out.println(node.getPhoneNumberOfFamilyMember("Adams", "Tim"));
		
		//Error Tested
		//System.out.println(node.getPhoneNumberOfFamilyMember("Adams", "Tima"));
		
		System.out.println(node);
	}
}
