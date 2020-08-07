package proj.utils;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
@Lazy
public class Box<T> {
    private HashMap<String,T> box;
    //put, get(k),get(map), clear

    public Box(){
        box = new HashMap<>();
    }
    public void put(String s,T t) {
        box.put(s, t);
    }
    public T get(String k){
        Function<String,T> f = box::get;
        return f.apply(k);
    }
    public HashMap<String,T> get(){
        return box;
    }
    public int size(){
        Supplier<Integer> s = box::size;
        return s.get();
    }
    public void clear(){
        box.clear();
    }
    public void newbox(){
        box = new HashMap<String,T>();
    }
}