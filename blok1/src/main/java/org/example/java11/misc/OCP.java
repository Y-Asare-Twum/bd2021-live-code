package org.example.java11.misc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;

public class OCP {
    public static void main(String[] args) throws Exception {
        // List<Student> ls = Arrays.asList(new Student("S1", Student.Grade.A), new Student("S2", Student.Grade.A), new Student("S3", Student.Grade.C));
        // Map<Student.Grade, List<String>> grouping =
        //         ls.stream()
        //                 .collect(Collectors.groupingBy(Student::getGrade,
        //                         Collectors.mapping(Student::getName, Collectors.toList())));
        // System.out.println(grouping);
        //
        // Function<Integer, String> i = j -> null;
        //
        // List<Book> books = List.of(new Book("Gone with the wind", "Fiction"), new Book("Bourne Ultimatum", "Thriller"), new Book("The Client", "Thriller"));
        // Reader r = b -> System.out.println("Reading book " + b.getTitle());
        // books.forEach(x -> r.read(x));
        //
        // Path p1 = Paths.get("c:\\temp\\test.txt");
        // Path p2 = Paths.get("report.pdf");
        // System.out.println(p1.resolve(p2));
        //
        // int number = 2;
        //
        // Stream<Integer> sin = Stream.of(1, 2, 3);
        // Consumer<Integer> c1 = System.out::print;
        // Consumer<Integer> c2 = x -> { System.out.println(" * " + number + " = " + number * x); };
        //
        // sin.forEach(c1.andThen(c2));
        //
        // List<String> vals = Arrays.asList("a", "b"); String join = vals.parallelStream().reduce("_", (a, b) -> a.concat(b)); System.out.println(join);
        // List<Integer> names = Arrays.asList(1, 2, 3); //1
        // names.forEach(x -> x = x + 1);
        //
        // House h = new HomeOffice();  //1
        // System.out.println(h.getAddress()); //2

        // var nums = List.of(1, 2, 3, 4).stream();
        // double average = nums.collect(Collectors.averagingInt(j -> j));
        //
        // AA a = () -> {};
        // C c = () -> {};
        //
        // List<Integer> values = Arrays.asList(2, 4, 6, 9); //1
        // Predicate<Integer> check = (Integer i) -> {
        //     System.out.println("Checking"); return i == 4; //2
        // };
        // Predicate even = (i) -> (int) i % 2 == 0;  //3 values.stream().filter(check).filter(even).count(); //4

        // List<String> al = Arrays.asList("aa", "aaa", "b", "cc", "ccc", "ddd", "a");
        // al.stream().count();
        //
        // Path p1 = Paths.get("photos/goa");
        // Path p2 = Paths.get("/index.html");
        // Path p3 = p1.relativize(p2);
        // System.out.println(p3);
        //
        // List<Integer> ls = Arrays.asList(10, 47, 33, 23);
        //
        // Comparator<Integer> comparing = Comparator.comparing((Integer i) -> i);
        //
        // ls.stream().max(comparing).get();
        // ls.stream().allMatch(integer -> integer > 0);

        // IntFunction<IntUnaryOperator> fo = a -> b -> a - b;  //1

        // try (Device d = new Device()) { throw new Exception("test"); }

        // var objects = System.getProperties().keySet();
        // for (var e : System.getProperties().entrySet()) {
        //     Object key = e.getKey();
        // }
        //
        // var listOfWords = List.of("", "");
        //
        // var list2 = new ArrayList<String>();
        // listOfWords.parallelStream().forEach(s -> {if (s.length() == 2) list2.add(s); });
        // listOfWords.stream().filter(s -> s.length() == 2).parallel().collect(Collectors.toList());
        // listOfWords.stream().parallel().filter(s->s.length()==2).collect(Collectors.toList());

        // int value = 0; Supplier<Integer> valueS = () -> value++; //1

        // Path p1 = Paths.get("c:\\a\\b\\c");
        // System.out.println(p1.subpath(1, 2));

        // DoubleStream is = DoubleStream.of(0, 2, 4); //1
        // double sum = is.filter(i -> i % 2 != 0).sum(); //2
        // System.out.println(sum); //3

        // List<String> strings = Arrays.asList("544345435345345", "");
        // for (String listOfWord : strings) {
        //     strings.removeIf(w -> w.length() > 10);
        // }
        //
        // Byte condition = 1;
        // switch (condition) {
        //
        // }

        // var al = new ArrayList<String>();
        // al.addAll(List.of("a", "b"));
        // al.forEach(k -> {
        //     System.out.print(k.length());
        // });

        // List<String> l1 = Arrays.asList("a", "b"); List<String> l2 = Arrays.asList("1", "2");
        // Stream.of(l1, l2).flatMap(Collection::stream).forEach(System.out::println);

        // Optional<String> stro = Optional.of(null);//1

        // List<String> names = Arrays.asList("charles", "chuk", "cynthia", "cho", "cici");
        // int x = names.stream().filter(name -> name.length() > 4).collect(Collectors.counting());
        // System.out.println(x);

        // List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17); //1
        // Stream<Integer> stream = primes.stream();
        // stream.collect(partitioningBy(i -> i < 10, counting())).values().forEach(System.out::print);
        //
        // var books = new ArrayList<>(List.of(new Book("The Outsider", LocalDate.of(2019, 1, 1)), new Book("Becoming", LocalDate.of(2018, 1, 1)), new Book("Uri", LocalDate.of(2017, 1, 1))));
        // Predicate<Book> p = b -> b.getReleaseDate().isAfter(IsoChronology.INSTANCE.date(2018, 1, 1));
        //
        // Map<Boolean, Set<String>> newBooks = // results in Map<..>
        //         books.stream().collect(partitioningBy(p, mapping(Book::getTitle, Collectors.toSet())));
        //
        // Set<String> newBooks2 = // results in Set<..>
        //         books.stream().collect(filtering(p, mapping(Book::getTitle, Collectors.toSet())));
        //
        // Comparator<Book> bookComparator = (o1, o2) -> o1.getReleaseDate().compareTo(o2.getReleaseDate());
        // books.stream().sorted(bookComparator.thenComparing(Book::getTitle));
        //
        // Path p1 = Paths.get("c:\\main\\project\\Starter.java");
        // Path root = p1.getRoot();
        // System.out.println(root);

        // Files.lines(Paths.get("test.txt"), StandardCharsets.UTF_8);

        // Device1.testDevice();

        DoubleStream ds = DoubleStream.of(1.0, 2.0, 3.0);
        DoubleFunction<DoubleUnaryOperator> doubleF = m -> n -> m + n;
        ds.map(doubleF.apply(5.0)).forEach(System.out::println);
    }

    public static void copy1(Path p1, Path p2) throws Exception {
        Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
    }

    public void process(String name, Double value) {
        Map<String, List<Double>> groupedValues = new HashMap<>();
        groupedValues.computeIfAbsent(name, (a) -> new ArrayList<Double>()).add(value);
    }
}

interface Reader {
    default void read(Book b) { }

    void unread(Book b);
}

class Student {
    public static enum Grade {A, B, C, D, F}

    private String name;
    private Grade grade;

    public Student(String name, Grade grade) { this.name = name; this.grade = grade; }

    public String toString() { return name + ":" + grade; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

interface Boiler {
    public void boil();

    private static void log(String msg) { //1
        System.out.println(msg);
    }

    public static void shutdown() { log("shutting down"); }
}

interface Vaporizer extends Boiler {
    public default void vaporize() { boil(); System.out.println("Vaporized!"); }
}

class Reactor implements Vaporizer {
    public void boil() { System.out.println("Boiling..."); }

    public static void main(String[] args) {
        Vaporizer v = new Reactor(); //2
        v.vaporize(); //3
        // Vaporizer.shutdown(); //4
    }
}

class Book {
    private String title;
    private String genre;
    private LocalDate releaseDate;

    public Book(String title, LocalDate releaseDate) { this.title = title; this.releaseDate = releaseDate; }

    public Book(String title, String genre) { this.title = title; this.genre = genre; }    //accessors not shown

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}

interface House {
    public default String getAddress() { return "101 Main Str"; }
}

interface Office {
    public default String getAddress() { return "101 Smart Str"; }
}

class HomeOffice implements House, Office {
    public String getAddress() { return "R No 1, Home"; }
}

interface B {
    default void m1() { }
}

interface BB extends B {
    static void m2() { }

    ;
}

interface C extends BB {
    void m3();
}

interface A {
    static void m1() {}

    ;
}

interface AA extends A {
    void m2();

    private void mp() { }
}

interface AAA extends AA {
    void m3();
}

class Device implements AutoCloseable {
    String header = null;

    public void open() throws IOException { header = "OPENED"; System.out.println("Device Opened"); throw new IOException("Unknown"); }

    public String read() throws IOException { return ""; }

    public void close() { System.out.println("Closing device"); header = null; throw new RuntimeException("rte"); }
}

class Student2 {
    private String name;
    private int marks;      //constructor and getters and setters not shown

    public void addMarks(int m) { this.marks += m; }

    public void debug() { System.out.println(name + ":" + marks); }
}

class Device1 implements AutoCloseable {
    String header = null;

    public void open() { header = "OPENED"; System.out.println("Device Opened"); }

    public String read() throws IOException { throw new IOException("Unknown"); }

    public void writeHeader(String str) throws IOException { System.out.println("Writing : " + str); header = str; }

    public void close() { header = null; System.out.println("Device closed"); }

    public static void testDevice() {
        try (Device1 d = new Device1()) { d.open(); d.writeHeader("TEST"); d.close(); } catch (IOException e) {
            System.out.println("Got Exception");
        }
    }

}

interface IBook {
    public default String getId() { return "ISBN123456"; }
}

interface Encyclopedia extends IBook {    //INSERT CODE HERE
    // private String getId() { return "ISBN123456"; }
}
