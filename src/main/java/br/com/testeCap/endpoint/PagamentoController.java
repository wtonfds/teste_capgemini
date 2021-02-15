package br.com.testeCap.endpoint;

import lombok.RequiredArgsConstructor;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testeCap.domain.Pagamento;
import br.com.testeCap.request.PagamentoPostBodyDTO;
import br.com.testeCap.request.PagamentoPutBodyDTO;
import br.com.testeCap.service.PagamentoService;

@RestController
@RequestMapping("pagamentos")
@RequiredArgsConstructor
public class PagamentoController {
	
	private final PagamentoService pagamentoService;
	
	
	// endpoint para listar todos os pagamentos
	@GetMapping
	public ResponseEntity<List<Pagamento>> List(){
		return ResponseEntity.ok(pagamentoService.listAll());
	}
	
	// endpoint que busca um pagamento pelo ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<Pagamento> findById(@PathVariable long id){
		return ResponseEntity.ok(pagamentoService.findById(id));
	}
	
	// endpoint para salvar
	@PostMapping
	public ResponseEntity<Pagamento> save(@RequestBody PagamentoPostBodyDTO pagamento){
		return new ResponseEntity<>(pagamentoService.save(pagamento), HttpStatus.CREATED);
	}
	
	// endpoint para remover
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable long id){
		pagamentoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//endpoint para atualizar
	@PutMapping
	public ResponseEntity<Void> put(@RequestBody PagamentoPutBodyDTO pagamento){
		pagamentoService.update(pagamento);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
