package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class MoneyOneParamAnnotation {

    @ParameterizedTest
    @ValueSource(ints = {1,23,34})
    void constructorShouldSetAmountAndCurrency(int amount){
        Money money=new Money(amount,"USD");
        assertThat(money.getCurrency()).isEqualTo("USD");
        assertThat(money.getAmount()).isEqualTo(amount);
    }

}
