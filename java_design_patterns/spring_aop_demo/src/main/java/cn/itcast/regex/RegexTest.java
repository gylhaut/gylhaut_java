package cn.itcast.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String regex = "\\d{8}";
        String str = "12345678";
        System.out.println(str.matches(regex));
        find();
    }

    private static void find(){
        String regex ="\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        String str = "today is 2017-06-02, yesterday is 2017-06-01";
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println("find " +matcher.group()+
            "  position: " + matcher.start()+"-"+matcher.end());
        }
    }
}
