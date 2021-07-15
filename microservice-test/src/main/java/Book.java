import java.util.*;

public class Book {
    // Member Variables
    private int yearPublished;
    private String title;
    private double price;
    public static Map<Integer, Book> library;

    //static init method
    static {
        if(library == null || library.isEmpty()) {
            library = new HashMap<>();
            loadBooks();
        }
    }

    //load books
    public static void loadBooks() {
        Book b1 = new Book("Moby Dick", 1851, 15.20);
        Book b2 = new Book("The Terrible Privacy of Maxwell Sim", 2010, 13.14);
        Book b3 = new Book("Still Life With Woodpecker", 1980, 11.05);
        Book b4 = new Book("Sleeping Murder", 1976, 10.24);
        Book b5 = new Book("Three Men in a Boat", 1889, 12.87);
        Book b6 = new Book("The Time Machine", 1895, 10.43);
        Book b7 = new Book("The Caves of Steel", 1954, 8.12);
        Book b8 = new Book("Idle Thoughts of an Idle Fellow", 1886, 7.32);
        Book b9 = new Book("A Christmas Carol", 1843, 4.23);
        Book b10 = new Book("A Tale of Two Cities", 1859, 6.32);
        Book b11 = new Book("Great Expectations", 1861, 13.21);

        library.put(1, b1);
        library.put(2, b2);
        library.put(3, b3);
        library.put(4, b4);
        library.put(5, b5);
        library.put(6, b6);
        library.put(7, b7);
        library.put(8, b8);
        library.put(9, b9);
        library.put(10, b10);
        library.put(11, b1);
    }

    public boolean tenPercent(){
        if (yearPublished > 2000){
            return true; 
        }else {
            return false;
        }
    }

    // Constructor
    public Book(String t, int year, double p) {
        this.title = t; //avoid confusion therefore used this keyword
        this.yearPublished = year;
        this.price = p;

    }
      
    public static void main(String[] args) {
      
      Book book;
      List<Book> order = new ArrayList<>();
      Scanner input = new Scanner(System.in);
      do {
          System.out.println("Books in Library:");
          for(Map.Entry<Integer ,Book> bookEntry : library.entrySet()) {
              System.out.println(bookEntry.getKey() + "\t" + bookEntry.getValue().title + "\t" +
                      bookEntry.getValue().price);
          }
          System.out.println("Enter the book which you want to add in your bucket or enter -1 to checkout.");

          int id = input.nextInt();

          if(id == -1) {
              break;
          }

          if(library.keySet().contains(id)) {
              order.add(library.get(id));
          } else {
              System.out.println("Please enter valid id.");
              continue;
          }

      } while (true);
      if(! order.isEmpty()) {
          double totalAmount = 0;
          double discount = 0;
          for (Book orderedBook : order) {
              totalAmount += orderedBook.price;
              if (orderedBook.yearPublished >= 2000 && discount == 0) {
                  discount += 10;
              }
          }

          if (totalAmount >= 30) {
              System.out.println("Your total amount is greater than 30 so You get a discount of 5%.");
              discount += 5.0;
          }

          totalAmount = totalAmount - ((totalAmount) * (discount / 100.0));
          System.out.println("You ordered:");
          order.stream()
                  .forEach(b1 -> System.out.println(b1.title));
          System.out.println("Your order amount : " + totalAmount);
      }
    }
}


