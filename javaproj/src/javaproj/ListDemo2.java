package javaproj;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ListDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       List<String>  data=Arrays.asList("Hello World","Hi Mary","Welcome");
       Stream<String> ss= data.stream();
       Function<String,Integer> mymap=new Function<String,Integer>(){
		@Override
		public Integer apply(String t) {
			// TODO Auto-generated method stub
			return t.length();
		}    	   
       };
       //Stream<Integer> si= ss.map(mymap);
       Stream<Integer> si= ss.filter(s->s.contains("H")).map(s-> s.length());
       si.forEach(System.out::println);
	}

}
