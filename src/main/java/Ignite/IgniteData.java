package Ignite;

import model.CallDetail;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
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
        ignite.addCacheConfiguration(new CacheConfiguration("SQL_PUBLIC_CALL").setIndexedTypes(Integer.class, CallDetail.class));
        callCache = ignite.getOrCreateCache("SQL_PUBLIC_CALL");

    }

    public void putDataToCache(List<CallDetail> listData){
        for (int i=0; i<listData.size(); i++){
            callCache.put(i, listData.get(i));
        }

    }

    /**
     * This
     * @throws FileNotFoundException
     */
    public List<?> getSumVolumeFromCache() throws FileNotFoundException {
        SqlFieldsQuery query = new SqlFieldsQuery("SELECT sum(volume) FROM CallDetail");

        List<?> result = callCache.query(query).getAll();

        return result;

    }

    public void writeToFileSumVolume(List<?> result, String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path));
        result.forEach(pw::println);
        pw.close();
    }
    public void closeIgnite(){
        ignite.close();
    }
}
