package br.com.N2020.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.N2020.model.SegmentoModel;

@Repository
public interface SegmentoRepository extends JpaRepository<SegmentoModel, Long>{

}
