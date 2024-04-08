public class HashableObject implements Hashable{
    
    private String key;
    // other members of the object
    public HashableObject(String s){
        key = new String(s);
    }
    public String key(){
        return key;
    }



}