package br.com.teste.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.teste.entity.Veiculo;
import br.com.teste.repository.VeiculoRepository;

@Service
public class VeiculoService {

	   private VeiculoRepository veiculoRepository;
	   
	    public VeiculoService(VeiculoRepository veiculoRepository) {
	        this.veiculoRepository = veiculoRepository;
	    }
	    
	    public Veiculo salvar(Veiculo veiculo) {
	    	veiculo = this.veiculoRepository.save(veiculo);
	    	return veiculo;
	    }
	    
	    public List<Veiculo> buscarTodos(){
	    	return this.veiculoRepository.findAll();
	    }
	    
	    public Veiculo atualizar(Veiculo veiculo, long id){
	    	Veiculo ve = this.veiculoRepository.findById(id).get();
	    	
	    	ve.setAno(veiculo.getAno());
	    	ve.setDescricao(veiculo.getDescricao());
	    	ve.setMarca(veiculo.getMarca());
	    	ve.setNome(veiculo.getNome());
	    	ve.setQuantidade(veiculo.getQuantidade());
	    	
	    	ve = this.veiculoRepository.save(ve);
	    	return ve;
	    }
	    
	    
	    public void delete(Long id){
	    	Optional<Veiculo> veiculo = this.veiculoRepository.findById(id);
	    	if(!veiculo.isPresent()) {
	    		throw new RuntimeException("Veiculo não encontrado!");
	    	}
	    	this.veiculoRepository.delete(veiculo.get());
	    }
	    
	    public Veiculo buscarPorId(Long id){
	    	Optional<Veiculo> veiculo = this.veiculoRepository.findById(id);
	    	if(!veiculo.isPresent()) {
	    		throw new RuntimeException("Veiculo não encontrado!");
	    	}
	    	return veiculo.get();
	    }

		public List<Veiculo> buscarVeiculosPorMarca(String marca) {
			List<Veiculo> veiculos = this.veiculoRepository.findByMarca(marca);
			return veiculos;
		}

		public List<Veiculo> buscarVeiculosPorAno(int ano) {
			List<Veiculo> veiculos = this.veiculoRepository.findByAno(ano);
			return veiculos;
		}

		public List<Veiculo> buscarDataInicioDataFim(LocalDate dataInicio, LocalDate dataFim) {
			List<Veiculo> veiculos = this.veiculoRepository.findByDataCriacao(dataInicio,dataFim);
			return veiculos;
		}

		public Integer buscarQuantidadeVeiculosPorMarca(String marca) {
			Integer quantidade = this.veiculoRepository.findBySumMarca(marca);
			return quantidade;
		}

		public Integer retornaQuantidadeVeiculosPorAno(int ano) {
			Integer quantidade = this.veiculoRepository.findBySumVeiculosAno(ano);
			return quantidade;
		}
	    
}
