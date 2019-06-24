package sort.collection;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class SortCollection {

	public static void main(String[] args) {
		File fileLoc = new File("F:\\test\\3_v2.11.0_Vocalink\\oracle");
		int fileNmAsLen = fileLoc.list().length;
		String[] fileNms = fileLoc.list();
		List<String> sortedList = new LinkedList<String>();
		for (int i = 0; i < fileNmAsLen; i++) {
			for (int j = i; j < fileNmAsLen; j++) {
				int sortedLstIdx = sortedList.size();
				
				if (fileNms[i].hashCode()>fileNms[j].hashCode()) {
					sortedList.add(fileNms[i]);
				} else if(fileNms[i].hashCode()<fileNms[j].hashCode()){
					sortedList.add(fileNms[j]);
				}
				
			}
			if (sortedList.size() > i) {
				System.out.println(sortedList.get(i));
			}
		}

	}
}
