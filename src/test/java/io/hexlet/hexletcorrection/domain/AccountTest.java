package io.hexlet.hexletcorrection.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class AccountTest {

    @Autowired
    private ObjectMapper objectMapper;

    public static Stream<Account> getTestAccount() {
        final var comment = new Comment().setId(1L);
        return Stream.of(new Account()
            .setId("ID")
            .addTypo(new Typo()
                .setId(1L)
                .addComment(comment))
            .addComment(comment));
    }

    @ParameterizedTest
    @MethodSource("getTestAccount")
    public void isNotRecursionCallForJackson(final Account account) throws Exception {
        assertThat(objectMapper.writeValueAsString(account)).hasToString(objectMapper.writeValueAsString(account));
    }

    @ParameterizedTest
    @MethodSource("getTestAccount")
    public void isNotRecursionCallForToString(final Account account) {
        assertThat(account).hasToString(account.toString());
    }

    @Test
    public void equalsIfIdsEquals() {
        assertThat(new Account().setId("1L")).isEqualTo(new Account().setId("1L"));
    }

    @Test
    public void notEqualsIfIdsNotEquals() {
        assertThat(new Account().setId("1L")).isNotEqualTo(new Account().setId("2L"));
    }

    @Test
    public void notEqualsIfOneIdNull() {
        assertThat(new Account().setId("1L")).isNotEqualTo(new Account());
    }
}
