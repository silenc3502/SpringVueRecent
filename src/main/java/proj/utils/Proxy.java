package proj.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

@Component("pxy") @Lazy
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String:: valueOf;
        return f.apply(o);
    }
    public int integer(String s){
        Function<String, Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    public Boolean equals(String a, String b){
        BiPredicate<String, String> f = String::equals;
        return f.test(a,b);
    }
    public void print(String s){
        Consumer<String> c = System.out::println;
        c.accept(s);
    }
}