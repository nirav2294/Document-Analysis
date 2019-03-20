import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Utility {
   public static void run(Counter<String, String> words) throws FileNotFoundException{
      Scanner CharCount_data = new Scanner(System.in);
      System.out.println("Give the name of a file for analysis:");
      String fileName = CharCount_data.next();
      Scanner input = new Scanner(new File("/Users/nirav/Downloads" + fileName));
      input.useDelimiter("\\W+");

      while (input.hasNext()) {
         String word = input.next();
         String keyWord = Utility.dropS(word);
         words.put(keyWord, word);
      }

      for (String word : words.keySet())
         if (words.getCount(word) >= 10)
            System.out.println(word +":\t" + words.get(word));

      input.close();
      CharCount_data.close();
   }
   
   static String dropS(String word) {
      String ans = word.toLowerCase();
      if (ans.endsWith("s"))
         return ans.substring(0, ans.length() - 1);
      return ans;
   }
}