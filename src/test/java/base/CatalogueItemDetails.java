package base;

import java.util.Arrays;
import java.util.List;

public enum CatalogueItemDetails {

    ADULT_MALE_AMAZON_PARROT("EST-18", "AV-CB-01", "Adult Male Amazon Parrot", "$193.50"),
    MALE_PUPPY_POODLE("EST-8", "K9-PO-02", "Male Puppy Poodle", "$18.50");

    private final String itemId;
    private final String productID;
    private final String description;
    private final String price;

    CatalogueItemDetails(String itemId,String productID, String description, String price) {
        this.itemId = itemId;
        this.productID = productID;
        this.description = description;
        this.price = price;
    }

    public List<String> getItemsAsList(){
    	List<String> items = Arrays.asList(itemId, productID, description, price);
    	return items;
    }
    
	public String getItemId() {
		return itemId;
	}

	public String getProductID() {
		return productID;
	}

	public String getDescription() {
		return description;
	}

	public String getPrice() {
		return price;
	}

}

