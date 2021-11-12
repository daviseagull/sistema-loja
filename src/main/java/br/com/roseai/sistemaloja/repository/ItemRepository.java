package br.com.roseai.sistemaloja.repository;

import br.com.roseai.sistemaloja.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {

    List<Item> findAllByActiveIsTrue();
}
