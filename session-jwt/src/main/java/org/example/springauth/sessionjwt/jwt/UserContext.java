package org.example.springauth.sessionjwt.jwt;

public class UserContext {
    private static final ThreadLocal<String> USER = new ThreadLocal<>();

    public static void add(String username) {
        USER.set(username);
    }

    public static void remove() {
        USER.remove();
    }

    public static String getCurrentUsername() {
        return USER.get();
    }
}
