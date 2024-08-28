import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(12, "Хлеб", 50);
    Product product2 = new Product(555, "Ластик", 20);
    Product product3 = new Product(12, "Пальто", 8_000);

    @Test
    public void shouldRemoveByIdAnExistingProduct() {

        repo.add(product1);
        repo.add(product2);

        repo.remove(555);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowNotFoundException() {

        ShopRepository repo = new ShopRepository();

        repo.add(product1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(555);
        });
    }

    @Test
    public void shouldAddProduct() {

        ShopRepository repo = new ShopRepository();

        repo.add(product1);

        Product[] expected = {product1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {

        repo.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.add(product3);
        });
    }
}