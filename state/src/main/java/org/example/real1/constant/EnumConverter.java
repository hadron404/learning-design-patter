package org.example.real1.constant;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public interface EnumConverter {
    Integer getCode();

    static <E extends Enum<?> & EnumConverter> Optional<E> codeOf(Class<E> enumClass, Integer value) {
        return Arrays.stream(enumClass.getEnumConstants()).filter(e -> Objects.equals(e.getCode(), value)).findAny();
    }
}
