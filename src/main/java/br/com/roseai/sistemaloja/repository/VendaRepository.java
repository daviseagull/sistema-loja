package br.com.roseai.sistemaloja.repository;

import br.com.roseai.sistemaloja.entity.Venda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String> {
}
