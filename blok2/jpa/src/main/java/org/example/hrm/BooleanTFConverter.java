package org.example.hrm;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

// @Converter(autoApply = true)
public class BooleanTFConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean value) {
        return value != null ? (value ? "T" : "F") : "";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        boolean result = false;
        switch (dbData) {
            case "T":
                result = true; break;
            case "F":
                result = false; break;
        }
        return result;
    }
}
