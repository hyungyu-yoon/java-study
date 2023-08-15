package ch06.sec15;

public class Single {
    private static Single instance = new Single();
    
    private Single() {}
    
    public static Single getInstance() {
        return instance;
    } 
}