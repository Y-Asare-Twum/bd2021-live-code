package org.example.java11.slides.h12;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AuthorUtil {
    public String showAuthorOnClass(Class c) {
        if (c.isAnnotationPresent(Author.class)) {
            Author a = (Author) c.getAnnotation(Author.class);
            return a.value();
        }

        // pattern matching for instanceof (java 16)
        // if (c.getAnnotation(Author.class) instanceof Author a) {
        //     return a.value();
        // }

        return null;
    }

    public List<String> showAuthorsOnMethods(Class c) {
        List<String> result = new ArrayList<>();
        for (Method m : c.getMethods()) {
            if (m.isAnnotationPresent(Author.class)) {
                result.add(m.getAnnotation(Author.class).value());
            }
        }
        return result;
    }
}
