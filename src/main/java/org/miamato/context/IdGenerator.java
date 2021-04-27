package org.miamato.context;

import java.util.concurrent.ThreadLocalRandom;

public class IdGenerator {

    public static int generateId() {
        int id = ThreadLocalRandom.current().nextInt(1,30000);
        return id;
    }
}
