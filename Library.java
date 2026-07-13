import java.util.*;

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed = false; //default state

    public Book (String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle () {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public boolean getIsBorrowed() {
        return isBorrowed;
    }
    public void setIsBorrowed (boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "{ title: \"" + title + 
            "\", author: \"" + author + 
            "\", isbn: \"" + isbn + 
            "\", isBorrowed: " + isBorrowed + 
            " }";
    }
}

class Member {
    private String name;
    private String memberId;
    private HashMap<String, Book> borrowedBooks = new HashMap<String, Book>();
    
    public Member (String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public boolean hasBorrowedBook(String isbn) {
        return borrowedBooks.containsKey(isbn);
    }

    public Collection<Book> getBorrowedBooks() {
        return borrowedBooks.values();
    }

    public void borrowBooks (Book borrowedBooks) {
        this.borrowedBooks.put(borrowedBooks.getIsbn(), borrowedBooks);
    }

    public void returnBooks(Book borrowedBooks) {
        this.borrowedBooks.remove(borrowedBooks.getIsbn());
    }
}

public class Library {
    private HashMap<String, Book> books = new HashMap<String, Book>();
    private HashMap<String, Member> members = new HashMap<String, Member>();
    

    public String addBooks(Book book) {
        books.put(book.getIsbn(), book);
        return "Book added successfully";
    }

    public String registerMember(Member member) {
        boolean isExisting = members.containsKey(member.getMemberId());
        if (isExisting) {
            return "Member already existing";
        }
        members.put(member.getMemberId(), member);
        return "Member registered successfully";
    }

    public String borrowBookByISBN(String memberId, String bookISBN) {
        Member member = members.get(memberId);

        if (member != null) {
            Book book = books.get(bookISBN);
            if (book != null) {
                if (!book.getIsBorrowed()) {
                    Member borrower = members.get(memberId);
                    int countOfBooks = borrower.getBorrowedBooks().size();
                    if (countOfBooks >= 3) {
                        return "Cannot borrow more than three books";
                    }
                    borrower.borrowBooks(book); // add book to list of users borrowed book
                    book.setIsBorrowed(true); // mark book as borrowed
                    return "Book successfully borrowed";
                } else {
                    return "Book taken already";
                }
            } else {
                return "Book not in stock";
            }
        }
        return "Not a member of the library";
    }

    public String returnBookByISBN (String memberId, String bookISBN) {
        Member member = members.get(memberId);

        if (member != null) {
            if (member.hasBorrowedBook(bookISBN)) {
                Book book = books.get(bookISBN);
                member.returnBooks(book); //remove book from users list
                book.setIsBorrowed(false); //release book
                return "Book successfully returned";
            } else {
                return "This member did not borrow this book";
            }

        }
        return "Not a member of the library";
    }

    public Collection<Book> displayBorrowedBooksByAMember(String memberId) {
        Member member = members.get(memberId);

        if (member == null) {
            return new ArrayList<Book>();
        }

        return member.getBorrowedBooks();
    }

    public List<Book> displayAllAvailableBooks () {
        List<Book> availableBooks = new ArrayList<Book>();
        for (Book book: books.values()) {
            if (!book.getIsBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}