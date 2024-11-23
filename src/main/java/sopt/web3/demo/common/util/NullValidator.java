package sopt.web3.demo.common.util;

public class NullValidator {
    public static void valid(Object object){
        if (object == null){
            throw new NullPointerException();
        }
    }
}
