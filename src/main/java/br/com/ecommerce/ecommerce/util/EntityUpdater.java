package br.com.ecommerce.ecommerce.util;

import java.lang.reflect.Field;

public class EntityUpdater {

    public static void updateFields(Object target, Object source) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            try {
                // Torna o campo acessível, mesmo se for privado
                field.setAccessible(true);

                // Obtém o valor do campo na instância de source
                Object value = field.get(source);

                // Se o valor não for nulo, atualiza o campo na instância de target
                if (value != null) {
                    field.set(target, value);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace(); // Trate a exceção de acordo com suas necessidades
            }
        }
    }

}
