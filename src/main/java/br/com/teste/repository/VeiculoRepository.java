package br.com.teste.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.teste.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	
	List<Veiculo> findByMarca(String marca);

	List<Veiculo> findByAno(int ano);
	
	@Query("SELECT ve  FROM Veiculo ve WHERE ve.dataCriacao BETWEEN :dataInicio AND :dataFim")
	List<Veiculo> findByDataCriacao(@Param(value = "dataInicio") LocalDate dataInicio,@Param(value = "dataFim") LocalDate dataFim);

	@Query("SELECT SUM(ve.quantidade) FROM Veiculo ve WHERE ve.marca = :marca ")
	Integer findBySumMarca(@Param(value = "marca") String marca);

	@Query("SELECT SUM(ve.quantidade) FROM Veiculo ve WHERE ve.ano = :ano ")
	Integer findBySumVeiculosAno(@Param(value= "ano") int ano);
	
	
	
	
}
