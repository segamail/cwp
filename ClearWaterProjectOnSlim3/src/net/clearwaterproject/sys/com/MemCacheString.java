package net.clearwaterproject.sys.com;

/*
 * いらないかも。
 */
public class MemCacheString {
    
    /*
     * Cache用KeyのStringデータ保持用
     */
    private String ckString = null;
    
    

    

    public String getCacheKey(){
        return ckString.substring(0);
    }
    
}
