package hello.core.singleton;

import java.sql.SQLOutput;

public class SingletonService {
    // 로딩할 때 객체 생성하는 것이 가장 편함
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
