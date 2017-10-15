package Ignite;

import model.CallDetail;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;

import java.util.List;

/**
 * Created by Андрей on 15.10.2017.
 */
public class IgniteData {


    Ignite ignite;
    IgniteCache<Integer, CallDetail> callCache;

    /**
     *  Ignite, cache Init
     */
    public IgniteData() {
        ignite = Ignition.start();
        callCache = ignite.getOrCreateCache("SQL_PUBLIC_CALL");
    }

    public void putDataToCache(List<CallDetail> listData){
        for (int i=0; i<listData.size(); i++){
            callCache.put(i, listData.get(i));
        }

    }

}
