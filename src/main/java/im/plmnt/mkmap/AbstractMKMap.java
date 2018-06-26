package im.plmnt.mkmap;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class AbstractMKMap<K1, K2, V> implements MKMap<K1, K2, V> {

    @SuppressWarnings(value = "unchecked")
    private Object getKey(V value, Class<? extends Annotation> annotationClass) {
        Field[] declaredFields = value.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(annotationClass)) {
                try {
                    return field.get(value);
                } catch (IllegalAccessException ignored) {}
            }
        }
        return null;
    }

    protected K1 getPrimaryKey(V value) {
        return (K1) getKey(value, PrimaryKey.class);
    }

    protected K2 getSecondaryKey(V value) {
        return (K2) getKey(value, SecondaryKey.class);
    }

}
