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
class TypoTest {

    @Autowired
    private ObjectMapper objectMapper;

    public static Stream<Typo> getTestTypo() {
        final var comment = new Comment().setId(1L);
        final var typo = new Typo();
        new Account().setId("ID")
            .addTypo(typo
                .setId(1L)
                .addComment(comment))
            .addComment(comment);
        return Stream.of(typo);
    }

    @ParameterizedTest
    @MethodSource("getTestTypo")
    public void isNotRecursionCallForJackson(final Typo typo) throws Exception {
        assertThat(objectMapper.writeValueAsString(typo)).hasToString(objectMapper.writeValueAsString(typo));
    }

    @ParameterizedTest
    @MethodSource("getTestTypo")
    public void isNotRecursionCallForToString(final Typo typo) {
        assertThat(typo).hasToString(typo.toString());
    }

    @Test
    public void equalsIfIdsEquals() {
        assertThat(new Typo().setId(1L)).isEqualTo(new Typo().setId(1L));
    }

    @Test
    public void notEqualsIfIdsNotEquals() {
        assertThat(new Typo().setId(1L)).isNotEqualTo(new Typo().setId(2L));
    }

    @Test
    public void notEqualsIfOneIdNull() {
        assertThat(new Typo().setId(1L)).isNotEqualTo(new Typo());
    }
}
