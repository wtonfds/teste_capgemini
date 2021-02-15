package br.com.testeCap.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import br.com.testeCap.domain.Pagamento;

@DataJpaTest
@DisplayName("testes para a interface PagamentoRepository")
class PagamentoRepositoryTest {

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Test
	@DisplayName("teste de persistencia de pagamento quando for bem sucedido")
	void save_persistPagamento() {
		Pagamento pagamento = createPagamento();
		Pagamento savedPagamento = this.pagamentoRepository.save(pagamento);
		
		Assertions.assertThat(savedPagamento).isNotNull();
		Assertions.assertThat(savedPagamento.getId()).isNotNull();
		
		Assertions.assertThat(savedPagamento.getNomeDestinatario()).isEqualTo(pagamento.getNomeDestinatario());
		Assertions.assertThat(savedPagamento.getCpf()).isEqualTo(pagamento.getCpf());
		Assertions.assertThat(savedPagamento.getInstituicao()).isEqualTo(pagamento.getInstituicao());
		Assertions.assertThat(savedPagamento.getChavePix()).isEqualTo(pagamento.getChavePix());
		Assertions.assertThat(savedPagamento.getValor()).isEqualTo(pagamento.getValor());
		Assertions.assertThat(savedPagamento.getDescricao()).isEqualTo(pagamento.getDescricao());
		Assertions.assertThat(savedPagamento.getPorcentagem()).isEqualTo(pagamento.getPorcentagem());
		
	}
	
	@Test
	@DisplayName("teste de remocao de pagamento quando for bem sucedido")
	void delete_removePagamento() {
		Pagamento pagamento = createPagamento();
		Pagamento savedPagamento = this.pagamentoRepository.save(pagamento);
		
		this.pagamentoRepository.delete(savedPagamento);
		
		Optional<Pagamento> pagamentoOptional = this.pagamentoRepository.findById(savedPagamento.getId());
		
		Assertions.assertThat(pagamentoOptional).isEmpty();
	}
	
	private Pagamento createPagamento(){
		return Pagamento.builder()
				.nomeDestinatario("teste unitario")
				.cpf("00000000000")
				.instituicao("teste unitario")
				.chavePix("00000000000")
				.valor(0.0)
				.descricao("teste unitario")
				.porcentagem(100.0)
				.build();
	}

}
