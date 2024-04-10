package org.example;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
    @Test
    void constructorShouldSetAmountAndCurrency() {
        Money money= new Money(12,"USD");

        assertThat(money.getCurrency()).isEqualTo("USD");
        assertThat(money.getAmount()).isEqualTo(12);

        money=new Money(14,"GBP");
        assertThat(money.getCurrency()).isEqualTo("GBP");
    }



}