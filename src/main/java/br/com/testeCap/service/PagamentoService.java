package br.com.testeCap.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.testeCap.domain.Pagamento;
import br.com.testeCap.repository.PagamentoRepository;
import br.com.testeCap.request.PagamentoPostBodyDTO;
import br.com.testeCap.request.PagamentoPutBodyDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PagamentoService {
	
	private final PagamentoRepository pagamentoRepository;
	
	// listar todos os pagamentos
	public List<Pagamento> listAll(){
		return pagamentoRepository.findAll();
	}
	
	// buscar o pagamento pelo ID
	public Pagamento findById(Long id){
		return pagamentoRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pagamento nao encontrado"));
	}
	
	// Salvar o pagamento no banco
	public Pagamento save(PagamentoPostBodyDTO pagamentoPostBodyDTO){
		
		Pagamento pagamento = Pagamento.builder()
				.nomeDestinatario(pagamentoPostBodyDTO.getNomeDestinatario())
				.cpf(pagamentoPostBodyDTO.getCpf())
				.instituicao(pagamentoPostBodyDTO.getInstituicao())
				.chavePix(pagamentoPostBodyDTO.getChavePix())
				.valor(pagamentoPostBodyDTO.getValor())
				.descricao(pagamentoPostBodyDTO.getDescricao())
				.porcentagem(pagamentoPostBodyDTO.getPorcentagem())
				.build();	
		
		return pagamentoRepository.save(pagamento);
	}
	
	// excluir um pagamento do banco
	public void delete(Long id){
		pagamentoRepository.delete(findById(id));
	}
	
	// atualizar um pagamento
	public void update(PagamentoPutBodyDTO pagamentoPutBodyDTO){
		
		Pagamento pagamentoSalvo = findById(pagamentoPutBodyDTO.getId());
		
		Pagamento pagamento = Pagamento.builder()
				.id(pagamentoSalvo.getId())
				.nomeDestinatario(pagamentoPutBodyDTO.getNomeDestinatario())
				.cpf(pagamentoPutBodyDTO.getCpf())
				.instituicao(pagamentoPutBodyDTO.getInstituicao())
				.chavePix(pagamentoPutBodyDTO.getChavePix())
				.valor(pagamentoPutBodyDTO.getValor())
				.descricao(pagamentoPutBodyDTO.getDescricao())
				.porcentagem(pagamentoPutBodyDTO.getPorcentagem())
				.build();	
		
		pagamentoRepository.save(pagamento);
	}
	

}
