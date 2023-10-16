package run;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static List<Book> books = new ArrayList<>();



    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.println("**************************JAVA-HACKATHON-05-BASIC-MENU**************************");
            System.out.println("1. Nhập số sách và nhập thông tin sách");
            System.out.println("2. Hiển thị thông tin các sách");
            System.out.println("3. Sắp xếp sách theo lợi nhuận giảm dần");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Tìm kiếm sách theo tên sách");
            System.out.println("6. Thay đổi trạng thái của sách theo mã sách");
            System.out.println("7. Thoát");
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBook();
                    break;
                case 3:
                    sortBooksInDescendingOrderByInterest();
                    break;
                case 4:
                    deleteBookById();
                    break;
                case 5:
                    searchBooksByBookName();
                    break;
                case 6:
                    changeBookStatusByBookId();
                    break;
                case 7:
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Vui lòng nhập từ 1-7");

            }
        } while (true);
    }

    private static void addBook() {
        System.out.println("Nhập số lượng sách thêm mới");
        int numberBookOfBookToAdd = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberBookOfBookToAdd; i++) {
            Book newBook = new Book();
            newBook.inputData();
            books.add(newBook);
        }
        System.out.println("Đã hoàn tất việc thêm sách");
    }


    private static void showBook() {
        System.out.println("**************************BOOK-INDEX**************************");
        if (!books.isEmpty()) {
            for (Book book : books) {
                book.displayData();
            }
        } else {
            System.out.println("Danh sách hiện tại đang trống");
        }
    }

    private static void sortBooksInDescendingOrderByInterest() {
            books.sort(Book::compareTo);
        System.out.println("Đã hoàn tất sắp xếp theo thứ tự");
    }

    private static void deleteBookById() {
        System.out.println("Nhập mã sách muốn xóa :");
        int bookDeleteId = Integer.parseInt(sc.nextLine());
        Book bookToDelete = new Book();
        for (Book book : books) {
            if(book.getBookId() == bookDeleteId) {
                bookToDelete = book;
                break;
            }
        }
        if (bookToDelete != null) {
            books.remove(bookToDelete);
            System.out.println("Sách đã được xóa thành công!");
        } else {
            System.err.println("Không tìm thấy mã sách vừa nhập!");
        }

    }

    private static void searchBooksByBookName() {
        System.out.println("Nhập vào tên sách để tiìm kiếm");
        String bookName = sc.nextLine();
        boolean isNothingMAtched = true;
        for (Book book : books) {
            if (book.getBookName().toLowerCase().contains(bookName.trim().toLowerCase())) {
                isNothingMAtched = false;
                book.displayData();
            }
        }
        if (isNothingMAtched) {
            System.err.println("Không tìm thấy kết quả phù hợp:");
        }
    }


    private static void changeBookStatusByBookId() {
        System.out.print("Nhập vào mã sách để thay đổi trạng thái: ");
        int bookIdToChangeStatus = Integer.parseInt(sc.nextLine());

        for (Book book : books) {
            if (book.getBookId() == bookIdToChangeStatus) {
                if (book.isBookStatus()) {
                    book.setBookStatus(false);
                    System.out.println("Trạng thái của mã sách đã đổi thành " + book.isBookStatus());
                } else {
                    book.setBookStatus(true);
                    System.out.println("Trạng thái của mã sách đã đổi thành " + book.isBookStatus());

                }
            }

        }
    }

}
