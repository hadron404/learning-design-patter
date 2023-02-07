package org.example.real1.application.constant;

import org.example.real1.application.domain.Order;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public interface EnumConverter {
    Order.OrderState getCode();

    static <E extends Enum<?> & EnumConverter> Optional<E> codeOf(Class<E> enumClass, Order.OrderState value) {
        return Arrays.stream(enumClass.getEnumConstants())
			.filter(e -> Objects.equals(e.getCode().value(), value.value()))
			.findAny();
    }
}
