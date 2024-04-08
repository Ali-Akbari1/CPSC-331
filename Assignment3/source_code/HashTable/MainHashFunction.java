public class MainHashFunction extends HashFunction{
    public int hash(String key, int tableSize) {
        int id = Integer.parseInt(key);
        return id % 8;
    }
}
