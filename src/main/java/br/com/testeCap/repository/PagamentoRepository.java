package br.com.testeCap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.testeCap.domain.Pagamento;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
	// repositorio do banco usando jpa para persistencia dos dados no banco
	
}
