package ProdactManager.ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RepositoryTest {

    Book book1 = new Book(11,"Шерлок Холмс: Этюд в багровых тонах", 267, "Артур Конан Дойл");
    Book book2 = new Book(22,"На западном фронте без перемен", 276, "Эрих Мария Ремарк");
    Book book3 = new Book(33, "Ночь в Лиссабоне", 288, "Эрих Мария Ремарк");
    Book book4 = new Book(44, "Шерлок Холмс: Знак четырёх", 299, "Артур Конан Дойл");
    Book book5 = new Book(55, "Архив Шерлока Холмса", 299, "Артур Конан Дойл");
    Smartphone phone1 = new Smartphone(111, "OPPO A71", 15999, "OPPO");
    Smartphone phone2 = new Smartphone(222, "Iphone 15", 97999, "Apple");

    @Test
    public void testRemoveOneProduct() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(book5);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(44);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, book5, phone1, phone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveManyProduct() {
        Repository repo = new Repository();

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(book4);
        repo.add(book5);
        repo.add(phone1);
        repo.add(phone2);
        repo.removeById(11);
        repo.removeById(111);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3, book4, book5, phone2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
