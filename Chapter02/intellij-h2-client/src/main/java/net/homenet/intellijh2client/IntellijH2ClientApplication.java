package net.homenet.intellijh2client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntellijH2ClientApplication implements CommandLineRunner {

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ShopRepository shopRepository;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired
    private ItemRepository itemRepository;

    public static void main(String[] args) {
        SpringApplication.run(IntellijH2ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        shopRepository.save(new Shop("shop name", "shop address"));
        itemRepository.save(new Item("item name", 1000));
    }
}
