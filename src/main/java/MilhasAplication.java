import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.milhas.model.Cliente;
import br.com.milhas.repository.ClienteRepository;

@SpringBootApplication
public class MilhasAplication {
	
	public static void main(String[] args) {
		SpringApplication.run(br.com.milhas.MilhasAplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(ClienteRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 9)
									.mapToObj(i -> {
											Cliente c = new Cliente();
											c.setNome("Cliente :" + i);
											c.setCpf("1239839774" + i);
											c.setEmail("cliente"+ i +"@gmail.com");
											c.setTelefone("21-98310055" + i );
											return c;
										})
									.map(v -> repository.save(v))
									.forEach(System.out::println);
		};
	}

}
