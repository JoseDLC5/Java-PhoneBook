package sa2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings("unused")
public class PhoneBook {
	public Map<Character, BSFamilyTree> directory;

	/**
     	* Creates a new phone book with an empty directory.
     	*/
	public PhoneBook() {
		directory = new HashMap<Character, BSFamilyTree>();
		
		BSFamilyTree a = new BSFamilyTree();
		BSFamilyTree b = new BSFamilyTree();
		BSFamilyTree c = new BSFamilyTree();
		BSFamilyTree d = new BSFamilyTree();
		BSFamilyTree e = new BSFamilyTree();
		BSFamilyTree f = new BSFamilyTree();
		BSFamilyTree g = new BSFamilyTree();
		BSFamilyTree h = new BSFamilyTree();
		BSFamilyTree i = new BSFamilyTree();
		BSFamilyTree j = new BSFamilyTree();
		BSFamilyTree k = new BSFamilyTree();
		BSFamilyTree l = new BSFamilyTree();
		BSFamilyTree m = new BSFamilyTree();
		BSFamilyTree n = new BSFamilyTree();
		BSFamilyTree o = new BSFamilyTree();
		BSFamilyTree p = new BSFamilyTree();
		BSFamilyTree q = new BSFamilyTree();
		BSFamilyTree r = new BSFamilyTree();
		BSFamilyTree s = new BSFamilyTree();
		BSFamilyTree t = new BSFamilyTree();
		BSFamilyTree u = new BSFamilyTree();
		BSFamilyTree v = new BSFamilyTree();
		BSFamilyTree w = new BSFamilyTree();
		BSFamilyTree x = new BSFamilyTree();
		BSFamilyTree y = new BSFamilyTree();
		BSFamilyTree z = new BSFamilyTree();
		
		directory.put('A', a);
		directory.put('B', b);
		directory.put('C', c);
		directory.put('D', d);
		directory.put('E', e);
		directory.put('F', f);
		directory.put('G', g);
		directory.put('H', h);
		directory.put('I', i);
		directory.put('J', j);
		directory.put('K', k);
		directory.put('L', l);
		directory.put('M', m);
		directory.put('N', n);
		directory.put('O', o);
		directory.put('P', p);
		directory.put('Q', q);
		directory.put('R', r);
		directory.put('S', s);
		directory.put('T', t);
		directory.put('U', u);
		directory.put('V', v);
		directory.put('W', w);
		directory.put('X', x);
		directory.put('Y', y);
		directory.put('Z', z);
		
		
	}

	/*
	 * Returns the instance of BSFamilyTree at the indicated letter
	 * Must accept lowercase letters as well as uppercase letters
	 */
	public BSFamilyTree getFamilyTree(char letter) {
		char key  = Character.toUpperCase(letter);
		
		if(!Character.isLetter(key)) {
			throw new IllegalArgumentException("Non-letter character");
		}
		
		return directory.get(key);
	}

	/*
	 * Adds a FamilyTreeNode to the PhoneBook
	 */
	public void addFamily(String lastName) {
		BSFamilyTree tree = getFamilyTree(lastName.charAt(0));
		
		tree.addFamilyTreeNode(lastName);
	}

	/*
	 * Adds a Person to the PhoneBook
	 * If a FamilyTreeNode with the given last name doesn't currently exist, create the FamilyTreeNode
	 */
	public void addPerson(String lastName, String firstName, String phoneNumber) {
		for(Entry<Character, BSFamilyTree> entry : directory.entrySet()) {
			if(entry.getValue().doesNumberExist(phoneNumber)) {
				throw new IllegalArgumentException("Phone Number is already in phonebook");
			}
		}
		
		Person person = new Person(lastName,firstName,phoneNumber);
		
		BSFamilyTree tree = directory.get(lastName.charAt(0));
		
		if(tree.doesFamilyExist(lastName)) {
			tree.getFamilyTreeNode(lastName).addFamilyMember(person);
			return;
		}
		else {
			tree.addFamilyTreeNode(lastName);
			tree.getFamilyTreeNode(lastName).addFamilyMember(person);
		}
	}

	/*
	 * Finds the phone number of a person
	 * Returns 'Does not exist.' if not found.
	 */
	public String getPhoneNumber(String lastName, String firstName) {
		BSFamilyTree tree = directory.get(lastName.charAt(0));
		
		if(tree.doesFamilyExist(lastName)) {
			FamilyTreeNode node = tree.getFamilyTreeNode(lastName);
			if(node.doesFamilyMemberExist(lastName, firstName)) {
				String number = node.getPhoneNumberOfFamilyMember(lastName, firstName);
				return number;
			}
			else {
				return "Does not exist.";
			}	
		}
		else {
			return "Does not exist.";
		}
	}

    	/**
     	* String representation of PhoneBook
     	*/
	public String toString() {
		StringBuilder s = new StringBuilder();
		Set<Entry<Character, BSFamilyTree>> set = directory.entrySet();
		
		for(Entry<Character, BSFamilyTree> entry : set) {
			s.append(entry.getKey());
			s.append("\n");
			s.append(entry.getValue());
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		PhoneBook pb = new PhoneBook();
		
		pb.getFamilyTree('<');
	}
}
