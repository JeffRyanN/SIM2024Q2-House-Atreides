package application.Controller;

import application.Entity.SellerEntity;

public class SellerController {
	
	private SellerEntity seller = new SellerEntity();
	
	public int getViewCount() {
		return seller.viewCount();
	}
	
	public int getShortListCount() {
		return seller.shortlistCount();
	}

}
