package br.com.roseai.sistemaloja.repository;

import br.com.roseai.sistemaloja.entity.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends MongoRepository<Sale, String> {
}
