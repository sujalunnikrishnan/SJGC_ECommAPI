package com.pojo;

public class AddnewProduct_Request 
{
String productName, productAddedBy, productCategory, 
productSubCategory, productDescription, productFor ;
double productPrice;


public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getProductAddedBy() {
	return productAddedBy;
}

public void setProductAddedBy(String productAddedBy) {
	this.productAddedBy = productAddedBy;
}

public String getProductCategory() {
	return productCategory;
}

public void setProductCategory(String productCategory) {
	this.productCategory = productCategory;
}

public String getProductSubCategory() {
	return productSubCategory;
}

public void setProductSubCategory(String productSubCategory) {
	this.productSubCategory = productSubCategory;
}

public String getProductDescription() {
	return productDescription;
}

public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}

public String getProductFor() {
	return productFor;
}

public void setProductFor(String productFor) {
	this.productFor = productFor;
}

public double getProductPrice() {
	return productPrice;
}

public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}


}
