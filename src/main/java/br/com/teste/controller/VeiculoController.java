package br.com.teste.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.teste.entity.FiltroVeiculo;
import br.com.teste.entity.Veiculo;
import br.com.teste.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {


    private VeiculoService veiculoService;
 
    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }
    
    @PostMapping
    public ResponseEntity<Veiculo> salvar(@Valid @RequestBody Veiculo veiculo){
    	veiculo = this.veiculoService.salvar(veiculo);
    	return ResponseEntity.ok(veiculo);
    }
	
    @GetMapping
    ResponseEntity<List<Veiculo>> buscarTodos(){
    	List<Veiculo> ve = this.veiculoService.buscarTodos();
    	return ResponseEntity.ok(ve);
    }
    
    @GetMapping("/{id}")
    ResponseEntity<Veiculo> buscarPorId(@PathVariable("id") Long id){
    	 Veiculo veiculo = this.veiculoService.buscarPorId(id);
    	return ResponseEntity.ok(veiculo);
    }
    
    @PutMapping("/{id}")
    ResponseEntity<Veiculo> atualizar(@PathVariable("id") Long id, @Valid @RequestBody Veiculo veiculo){
    	veiculo = this.veiculoService.atualizar(veiculo, id);
    	return ResponseEntity.ok(veiculo);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id){
    	this.veiculoService.delete(id);
		return ResponseEntity.noContent().build();
    }
	
    @GetMapping("/busca-por-marca")
    ResponseEntity<List<Veiculo>> buscarVeiculosPorMarca(@RequestBody Veiculo veiculo){
    	List<Veiculo> ve = this.veiculoService.buscarVeiculosPorMarca(veiculo.getMarca());
    	return ResponseEntity.ok(ve);
    }
    
    @GetMapping("/busca-por-ano")
    ResponseEntity<List<Veiculo>> buscarVeiculosPorAno(@RequestBody Veiculo veiculo){
    	List<Veiculo> ve = this.veiculoService.buscarVeiculosPorAno(veiculo.getAno());
    	return ResponseEntity.ok(ve);
    }
    
    @GetMapping("/busca-data-inicio-fim")
    ResponseEntity<List<Veiculo>> buscarVeiculosPorAno(@RequestBody FiltroVeiculo filtroVeiculo){
    	List<Veiculo> ve = this.veiculoService.buscarDataInicioDataFim(filtroVeiculo.getDataInicio(), filtroVeiculo.getDataFim());
    	return ResponseEntity.ok(ve);
    }
    
    @GetMapping("/quantidade-veiculo-marca")
    ResponseEntity<Integer> quantidadeVeiculosPormarca(@RequestBody Veiculo veiculo){
    	Integer ve = this.veiculoService.buscarQuantidadeVeiculosPorMarca(veiculo.getMarca());
    	return ResponseEntity.ok(ve);
    }
    
    @GetMapping("/busca-por-ano-retorna-quantidade")
    ResponseEntity<Integer> retornaQuantidadeVeiculosPorAno(@RequestBody Veiculo veiculo){
    	Integer ve = this.veiculoService.retornaQuantidadeVeiculosPorAno(veiculo.getAno());
    	return ResponseEntity.ok(ve);
    }
    
    
}
