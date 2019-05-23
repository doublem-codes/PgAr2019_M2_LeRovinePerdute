import java.util.ArrayList;

/**
 * It contains the element of the reader
 *
 */

public class Element {

	private String name;
	private String character = null;


	private ArrayList<Attribute> attributesRoot = new ArrayList<Attribute>();
	private ArrayList<Element> elementsRoot = new ArrayList<Element>();

	private ArrayList<Attribute> attributesHeader = new ArrayList<Attribute>();
	private ArrayList<Element> elementsHeader = new ArrayList<Element>();

	public Element(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public ArrayList<Attribute> getAttributesRoot() {
		return attributesRoot;
	}

	public ArrayList<Element> getElementsRoot() {
		return elementsRoot;
	}

	public ArrayList<Attribute> getAttributesHeader() {
		return attributesHeader;
	}

	public ArrayList<Element> getElementsHeader() {
		return elementsHeader;
	}


}


