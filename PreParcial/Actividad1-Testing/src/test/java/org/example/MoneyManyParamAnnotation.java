package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyManyParamAnnotation {

    @ParameterizedTest
    @CsvSource(value = {
            "13, USD",
            "12, JYP"
    })
    void MoneyManyParamAnnotation(int amount,String currency){
        Money money= new Money(amount, currency);
        assertThat(money.getAmount()).isEqualTo(amount);
        assertThat(money.getCurrency()).isEqualTo(currency);
    }

}
