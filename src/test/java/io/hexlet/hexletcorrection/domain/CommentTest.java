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
class CommentTest {

    @Autowired
    private ObjectMapper objectMapper;

    public static Stream<Comment> getTestComment() {
        final var comment = new Comment().setId(1L);
        new Account().setId("ID")
            .addTypo(new Typo()
                .setId(1L)
                .addComment(comment))
            .addComment(comment);
        return Stream.of(comment);
    }

    @ParameterizedTest
    @MethodSource("getTestComment")
    public void isNotRecursionCallForJackson(final Comment comment) throws Exception {
        assertThat(objectMapper.writeValueAsString(comment)).hasToString(objectMapper.writeValueAsString(comment));
    }

    @ParameterizedTest
    @MethodSource("getTestComment")
    public void isNotRecursionCallForToString(final Comment comment) {
        assertThat(comment).hasToString(comment.toString());
    }

    @Test
    public void equalsIfIdsEquals() {
        assertThat(new Comment().setId(1L)).isEqualTo(new Comment().setId(1L));
    }

    @Test
    public void notEqualsIfIdsNotEquals() {
        assertThat(new Comment().setId(1L)).isNotEqualTo(new Comment().setId(2L));
    }

    @Test
    public void notEqualsIfOneIdNull() {
        assertThat(new Comment().setId(1L)).isNotEqualTo(new Comment());
    }
}
