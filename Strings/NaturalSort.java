import java.util.ArrayList;
import java.util.List;

public class NaturalSort {
    private static List<Integer> extractNumericParts(String str) {
        List<Integer> numericParts = new ArrayList<>();
        String[] parts = str.split("\\D+");
        for (String part : parts) {
            if (!part.isEmpty()) {
                numericParts.add(Integer.parseInt(part));
            }
        }
        return numericParts;
    }

    public static List<String> naturalSort(List<String> strings) {
        strings.sort((s1, s2) -> {
            List<Integer> nums1 = extractNumericParts(s1);
            List<Integer> nums2 = extractNumericParts(s2);

            int size = Math.min(nums1.size(), nums2.size());
            for (int i = 0; i < size; i++) {
                int compare = Integer.compare(nums1.get(i), nums2.get(i));
                if (compare != 0) return compare;
            }
            return s1.compareTo(s2);
        });
        return strings;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("file1.txt");
        strings.add("file10.txt");
        strings.add("file2.txt");
        strings.add("file20.txt");
        strings.add("file3.txt");

        List<String> sortedStrings = naturalSort(strings);

        for (String str : sortedStrings) {
            System.out.println(str);
        }
    }
}
