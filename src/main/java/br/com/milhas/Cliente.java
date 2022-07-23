package br.com.milhas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Cliente {
	@Id
	@GeneratedValue(Strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String Nome;
	private String cpf;
	private String Email;
	private String Telefone;
}
