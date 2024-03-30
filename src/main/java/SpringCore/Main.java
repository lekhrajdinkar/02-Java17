package SpringCore;

import SpringCore.bean.Store;
import java8.Collection.MyList2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    static Logger log = LoggerFactory.getLogger(Main.class);
    Store store;
    public static void main(String... s){

        Main m = new Main();
        log.info(m.store.item1.toString());

    }
}
