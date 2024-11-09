package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(
					Product.builder()
					.id(UUID.randomUUID().toString())
					.name("PC")
					.price(6500)
					.quantity(15)
					.build()
			);
			productRepository.save(
					Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Printer")
					.price(1500)
					.quantity(9)
					.build()
			);
			productRepository.save(
					Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Smart Phone")
					.price(4500)
					.quantity(12)
					.build()
			);

			productRepository.findAll()
					.forEach(product -> {
						System.out.println("=====================");
						System.out.println(product.toString());
						System.out.println("=====================");
					});
		};
	}
}
