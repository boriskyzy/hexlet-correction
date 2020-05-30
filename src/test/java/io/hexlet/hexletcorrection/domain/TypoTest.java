package io.hexlet.hexletcorrection.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TypoTest {

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
