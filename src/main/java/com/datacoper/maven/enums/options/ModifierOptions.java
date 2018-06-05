package com.datacoper.maven.enums.options;

import java.lang.reflect.Modifier;

public enum ModifierOptions {
    PRIVATE(1, "Private") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isPrivate(modifier);
        }
    },
    PUBLIC(2, "Public") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isPublic(modifier);
        }
    },
    PROTECTED(3, "Protected") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isProtected(modifier);
        }
    },
    PACKAGE(4, "Package") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isStrict(modifier);
        }
    },
    FINAL(5, "Final") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isFinal(modifier);
        }
    },
    STATIC(6, "Static") {
        @Override
        public boolean isModifierPresent(int modifier) {
            return Modifier.isStatic(modifier);
        }
    };

    private int id;

    private String description;

    private ModifierOptions(int id, String descricao) {
        this.id = id;
        this.description = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public abstract boolean isModifierPresent(int modifier);
}