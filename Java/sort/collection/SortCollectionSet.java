package collection;

import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class SortCollectionSet {

	public static void main(String[] args) {
		File file = new File("F:\\test\\3_v2.11.0_Vocalink\\oracle");
		System.out.println(file.list());
		Set<String> s = new TreeSet<String>();
		s.addAll(Arrays.asList(file.list()));
		System.out.println(s.iterator().next());
		
	}

}
