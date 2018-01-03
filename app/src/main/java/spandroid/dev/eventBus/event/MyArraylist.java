package spandroid.dev.eventBus.event;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by webwerks on 11/5/17.
 */

public class MyArraylist<String> extends ArrayList<String> {


    public boolean contains(Object o){
        boolean isCOntains = false;
        Iterator iterator =   iterator();
        while (iterator.hasNext()){
            if(iterator.next().toString().contains(o.toString()))
                isCOntains = true;
        }
        return isCOntains;
    }
}
