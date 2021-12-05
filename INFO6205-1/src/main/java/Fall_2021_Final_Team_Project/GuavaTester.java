package Fall_2021_Final_Team_Project;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GuavaTester {
    public static void main(String args[]) {

        GuavaTester tester = new GuavaTester();
        Multimap<String,String> multimap = tester.getMultimap();

       /* List<String> lowerList = (List<String>)multimap.get("lower");
        System.out.println("Initial lower case list");
        System.out.println(lowerList.toString());

        lowerList.add("f");
        System.out.println("Modified lower case list");
        System.out.println(lowerList.toString());

        List<String> upperList = (List<String>)multimap.get("upper");
        System.out.println("Initial upper case list");
        System.out.println(upperList.toString());

        upperList.remove("D");
        System.out.println("Modified upper case list");
        System.out.println(upperList.toString());*/

        System.out.println( "Size : " +  multimap.size() );

        System.out.println("Before D operation");
        Map<String, Collection<String>> map = multimap.asMap();
        System.out.println("Multimap as a map");

        for (Map.Entry<String,  Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value =  multimap.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println("Keys of Multimap");
        Set<String> keys =  multimap.keySet();

        for(String key:keys) {
            System.out.println(key);
        }

        List<String> upperList = (List<String>)multimap.get("upperD");
        if(!upperList.isEmpty()){

            System.out.println("Initial upper case list");
            System.out.println(upperList.toString());

           // upperList.remove("D");
            System.out.println("Modified upper case list");
            multimap.asMap().remove("upperD");
            upperList = (List<String>)multimap.get("upperD");
            System.out.println(upperList.toString());
        }


        map = multimap.asMap();
        System.out.println("Multimap as a map");

        for (Map.Entry<String,  Collection<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            Collection<String> value =  multimap.get(key);
            System.out.println(key + ":" + value);
        }

        System.out.println("Keys of Multimap");
        keys =  multimap.keySet();

        for(String key:keys) {
            System.out.println(key);
        }

        System.out.println("Values of Multimap");
        Collection<String> values = multimap.values();

        System.out.println(values);
        System.out.println( "Size : " +  multimap.size() );
    }

    private Multimap<String,String> getMultimap() {

        //Map<String, List<String>>
        // lower -> a, b, c, d, e
        // upper -> A, B, C, D

        Multimap<String,String> multimap = ArrayListMultimap.create();

        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lowerd", "d");
        multimap.put("lowere", "e");

        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upperD", "D");
        multimap.put("upperD", "D");
        multimap.put("upperD", "D");

        return multimap;
    }
}