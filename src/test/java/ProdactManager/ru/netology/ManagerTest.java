package ProdactManager.ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Book book1 = new Book(11,"Шерлок Холмс: Этюд в багровых тонах", 267, "Артур Конан Дойл");
    Book book2 = new Book(22,"На западном фронте без перемен", 276, "Эрих Мария Ремарк");
    Book book3 = new Book(33, "Ночь в Лиссабоне", 288, "Эрих Мария Ремарк");
    Book book4 = new Book(44, "Шерлок Холмс: Знак четырёх", 299, "Артур Конан Дойл");
    Book book5 = new Book(55, "Архив Шерлока Холмса", 299, "Артур Конан Дойл");
    Smartphone phone1 = new Smartphone(111, "OPPO A71", 15999, "OPPO");
    Smartphone phone2 = new Smartphone(222, "Iphone 15", 97999, "Apple");

    @Test
    public void testWhenFoundOneProduct() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("OPPO");
        Product[] expected = {phone1};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testWhenFewProductFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Шерлок");
        Product[] expected = {book1, book4, book5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testWhenFewProductNoFound() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Гоголь");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}