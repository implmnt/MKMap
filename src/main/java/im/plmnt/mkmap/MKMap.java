package im.plmnt.mkmap;

public interface MKMap<K1, K2, V> {
    V put(V value);
    V getByPrimaryKey(K1 key);
    V getBySecondaryKey(K2 key);
}
