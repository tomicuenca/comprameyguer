package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.input.KeyboardInputDTO;
import com.tomicuenca.comprameyguer.dto.output.PeripheralOutputDTO;
import com.tomicuenca.comprameyguer.dto.input.PeripheralInputDTO;
import com.tomicuenca.comprameyguer.entity.KeyboardEntity;
import com.tomicuenca.comprameyguer.entity.PeripheralEntity;
import com.tomicuenca.comprameyguer.mapper.KeyboardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class PeripheralService<T extends PeripheralEntity, R extends PeripheralInputDTO, E extends PeripheralOutputDTO> {
    protected final CrudRepository<T,Long> repository;

    protected PeripheralService(CrudRepository<T, Long> repository) {
        this.repository = repository;
    }

    protected abstract E entityToOutputDTO(T entity);

    protected abstract T inputDTOToEntity(R input);

    public E getItem(Long id){
        try {
            return repository.findById(id)
                    .map(this::entityToOutputDTO)
                    .orElse(null);
        }catch (Exception e){
            log.error("An error ocurred trying to retrieve the item: " + e);
        }
        return null;
    }

    public List<String> getAllItemModels(){
        try{
            List<T> peripheralList = new ArrayList<>();
            repository.findAll().forEach(peripheralList::add);
            return peripheralList.stream().map(PeripheralEntity::getModel).toList();
        }catch (Exception e){
            log.error("An error ocurred trying to retrieve the items: " + e);
            return List.of("An error ocurred trying to retrieve the items");
        }
    }

    public String saveItem(R input){
        try{
            T entity = this.inputDTOToEntity(input);
            repository.save(entity);
            return "Item saved successfully";
        }catch (Exception e){
            log.error("An error ocurred trying to save the item: " + e);
            return "An error ocurred trying to save the item";
        }
    }

    public String sellItem(Long id){
        try {
            Optional<T> opt = repository.findById(id);
            if(opt.isPresent()){
                T entity = opt.get();
                if(entity.getStock() > 0) {
                    entity.setStock(entity.getStock() - 1);
                    repository.save(entity);
                    return String.format("Item sold successfully. New stock: %s", entity.getStock());
                }
                else{
                    return "This item is out of stock";
                }
            }
        }catch (Exception e){
            log.error("An error ocurred trying to sell the item: " + e);
            return "An error ocurred trying to sell the item";
        }
        return "Item does not exist";
    }

}
