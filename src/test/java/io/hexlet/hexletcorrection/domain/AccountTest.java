package io.hexlet.hexletcorrection.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

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
