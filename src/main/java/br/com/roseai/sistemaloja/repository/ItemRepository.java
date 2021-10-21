package br.com.roseai.sistemaloja.repository;

import br.com.roseai.sistemaloja.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item,String> {
}
