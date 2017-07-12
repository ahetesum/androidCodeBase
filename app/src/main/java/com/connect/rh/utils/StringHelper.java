package com.connect.rh.utils;

/**
 * Created by Ali on 4/30/2017.
 */

public class StringHelper
{
    /**
     * @Desc
     *
     */

    public static String toTitleCase(String input) {
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;

        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            }

            titleCase.append(c);
        }

        return titleCase.toString();
    }

    public static String toCamelCase(String input)
    {
        return  toTitleCase(input.toLowerCase());
    }
}
