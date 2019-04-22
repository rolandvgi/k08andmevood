import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Kodus{
  public static void main(String[] arg) throws IOException{
     PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
     Files.readAllLines(Paths.get("kodanik.txt")).stream()
     .filter(s -> Double.parseDouble(s.split(",")[1]) >= 180)
     .sorted(Comparator.comparing(s -> s.split(",")[0]))
     .map(s -> "Kodanik " + s.split(",")[0] + " ja tema pikkus on: " +
     s.split(",")[1]+"cm").
     collect(Collectors.toList()).forEach(pw::println);
     pw.println ("\n Nendest lühemad semud on:");

    Files.readAllLines(Paths.get("kodanik.txt")).stream()
     .filter(s2 -> Double.parseDouble(s2.split(",")[1]) < 180)
     .sorted(Comparator.comparing(s2 -> s2.split(",")[0]))
     .map(s -> s.split(",")[0] + " pikkusega: " +
     s.split(",")[1]+"cm").
     collect(Collectors.toList()).forEach(pw::println);

     pw.close();
      }
  }
