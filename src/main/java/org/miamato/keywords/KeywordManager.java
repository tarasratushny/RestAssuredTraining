package org.miamato.keywords;

public class KeywordManager {

    private PetApi petApi;

    public PetApi petApi(){
        if(this.petApi == null)
            petApi = new PetApi(this);
        return petApi;
    }
}
