package org.miamato.keywords;

public class KeywordManager {

    private PetApi petApi;
    private StoreApi storeApi;

    public PetApi petApi() {
        if (this.petApi == null) {
            petApi = new PetApi(this);
        }
        return petApi;
    }

    public StoreApi storeApi() {
        if (this.storeApi == null) {
            storeApi = new StoreApi(this);
        }
        return storeApi;
    }


}
