package im.plmnt.mkmap;

import java.util.HashMap;
import java.util.Map;

public class HashBasedMKMap<K1, K2, V> extends AbstractMKMap<K1, K2, V> {

    private Map<K1, V> primary = new HashMap<K1, V>();
    private Map<K2, V> secondary = new HashMap<K2, V>();

    public V put(V value) {
        V v = primary.put(getPrimaryKey(value), value);
        if (v != null) {
            secondary.remove(getSecondaryKey(v));
        }
        return secondary.put(getSecondaryKey(value), value);
    }

    public V getByPrimaryKey(K1 key) {
        return primary.get(key);
    }

    public V getBySecondaryKey(K2 key) {
        return secondary.get(key);
    }
}
