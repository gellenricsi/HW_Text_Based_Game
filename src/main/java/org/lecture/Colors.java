package org.lecture;

public class Colors {
        // Predefined color codes for easy use
        public static String red = colors.RED.get();
        public static String light_red = colors.LIGHT_RED.get();
        public static String green = colors.GREEN.get();
        public static String light_green = colors.LIGHT_GREEN.get();
        public static String blue = colors.BLUE.get();
        public static String light_blue = colors.LIGHT_BLUE.get();
        public static String yellow = colors.YELLOW.get();
        public static String bold = colors.BOLD.get();
        public static String reset = colors.RESET.get();
    /**
     * The {@code colors} enum defines ANSI escape codes for colors and text formatting options.
     */
    public enum colors {

        //Color codes
        RESET("\u001B[0m"),  //Reset

        RED("\u001B[31m"),  //Rot
        LIGHT_RED("\u001B[91m"),  //Light Rot
        GREEN("\u001B[32m"),  //Grün
        LIGHT_GREEN("\u001B[92m"),  //Light Grün
        YELLOW("\u001B[33m"),  //Gelb
        BLUE("\u001B[34m"),  //Blau
        LIGHT_BLUE("\u001B[94m"),  //Light Blau
        BOLD("\u001B[1m");  //Bold

        private final String code;

        colors(String code) {
            this.code = code;
        }

        public String get() {
            return code;
        }
    }
}
