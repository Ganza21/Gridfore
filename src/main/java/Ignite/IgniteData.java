package Ignite;

import model.CallDetail;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
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

    /* Не стал плодить одинаковый код и делать все sql запросы, если успею сделаю все выводы и добавлю вторую ноду */


    Ignite ignite;
    IgniteCache<Integer, CallDetail> callCache;


    /**
     *  Ignite, config index, cache Init
     */
    public IgniteData() {
        ignite = Ignition.start();
        ignite.addCacheConfiguration(new CacheConfiguration("SQL_PUBLIC_CALL").setIndexedTypes(Integer.class, CallDetail.class));
        callCache = ignite.getOrCreateCache("SQL_PUBLIC_CALL");
    }

    /**
     * Put data to cache :)
     * @param listData
     */
    public void putDataToCache(List<CallDetail> listData){
        for (int i=0; i<listData.size(); i++){
            callCache.put(i, listData.get(i));
        }
    }

    // TODO:  avoid duplication of code
    /**
     *
     * @return List result with sum volume
     * @throws FileNotFoundException
     */
    public List<?> getSumVolumeFromCache() throws FileNotFoundException {
        SqlFieldsQuery query = new SqlFieldsQuery("SELECT sum(volume) FROM CallDetail");

        List<?> result = callCache.query(query).getAll();

        return result;
    }

    /**
     * Write to file sum volume
     * @param result
     * @param path
     * @throws FileNotFoundException
     */
    public void writeToFileSumVolume(List<?> result, String path) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path));
        result.forEach(pw::println);
        pw.close();
    }

    /**
     * Get count entry from cache
     * @return List result with count charge
     * @throws FileNotFoundException
     */
    public List<?> getCountEntryFromCache() throws FileNotFoundException {
        SqlFieldsQuery query = new SqlFieldsQuery("SELECT COUNT(charge) FROM CallDetail");

        List<?> result = callCache.query(query).getAll();

        return result;
    }

    /**
     * Write to file avg charge
     * @param result
     * @param path1
     * @throws FileNotFoundException
     */
    public void writeToFileAvgCharge(List<?> result, String path1) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream(path1));
        result.forEach(pw :: println);
        pw.close();
    }

    /**
     * Close Ignite node
     */
    public void closeIgnite(){
        ignite.close();
    }
}
