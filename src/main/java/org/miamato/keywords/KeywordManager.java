package org.miamato.keywords;

public class KeywordManager {

    public PetApi petApi;

    public KeywordManager petApi(){
        if(this.petApi == null)
            petApi = new PetApi(this);
        return this;
    }
}
