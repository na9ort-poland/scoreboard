package org.techideas.entity;

public record Team (
        String name,
        Integer score
) {
    public Team(String name) {
        this(name, 0);
    }
}
