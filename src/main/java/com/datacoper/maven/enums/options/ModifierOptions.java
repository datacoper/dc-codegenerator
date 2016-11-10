package com.datacoper.maven.enums.options;

import com.datacoper.maven.util.StringUtil;
import java.lang.reflect.Modifier;

public enum ModifierOptions implements IOptions {
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

    @Override
    public ModifierOptions of(String encapsulation) {
        for (ModifierOptions item : ModifierOptions.values()) {
            if (item.getDescription().equals(encapsulation)) {
                return item;
            }
        }

        throw new RuntimeException(StringUtil.format("Inválid Modifier {0}", encapsulation));
    }

    public static ModifierOptions of(int encapsulation) {
        for (ModifierOptions item : ModifierOptions.values()) {
            if (item.getId() == encapsulation) {
                return item;
            }
        }

        throw new RuntimeException(StringUtil.format("Inválid Modifier {0}", encapsulation));
    }

    @Override
    public String print() {
        StringBuilder toString = new StringBuilder();
        
        for (ModifierOptions encapsulation : ModifierOptions.values()) {
            toString.append(encapsulation.getId())
                    .append(" - ")
                    .append(encapsulation.getDescription())
                    .append("\n");
        }
        
        return toString.append("\n").toString();
    }
    
    public abstract boolean isModifierPresent(int modifier);
}