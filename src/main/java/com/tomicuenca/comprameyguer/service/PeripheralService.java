package com.tomicuenca.comprameyguer.service;

import com.tomicuenca.comprameyguer.dto.input.PeripheralInputDTO;
import com.tomicuenca.comprameyguer.dto.output.PeripheralOutputDTO;
import com.tomicuenca.comprameyguer.entity.PeripheralEntity;
import com.tomicuenca.comprameyguer.enums.CurrencyEnum;
import com.tomicuenca.comprameyguer.service.external.ConversionRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class PeripheralService<T extends PeripheralEntity, R extends PeripheralInputDTO, E extends PeripheralOutputDTO> {

    protected final CrudRepository<T, Long> repository;
    protected final ConversionRateService conversionRateService;

    protected PeripheralService(CrudRepository<T, Long> repository, ConversionRateService conversionRateService) {
        this.repository = repository;
        this.conversionRateService = conversionRateService;
    }


    protected abstract E entityToOutputDTO(T entity);

    protected abstract T inputDTOToEntity(R input);

    protected abstract T partialInputDTOToEntity(R input, T entity);

    public E getItem(Long id) {
        try {
            return repository.findById(id)
                    .map(this::entityToOutputDTO)
                    .orElse(null);
        } catch (Exception e) {
            log.error("An error ocurred trying to retrieve the item: " + e);
        }
        return null;
    }

    public E getItemInLocalCurrency(Long id) {
        log.info(conversionRateService.getConversionRate().toString());

        try {
            Double official = conversionRateService.getConversionRate().getOfficial().getSellValue();
            E entity = repository.findById(id)
                    .map(this::entityToOutputDTO)
                    .orElse(null);
            if (entity != null && entity.getImported()) {
                entity.setCurrency(CurrencyEnum.ARS);
                entity.setPrice(entity.getPrice() * official);
            }
            return entity;
        } catch (Exception e) {
            log.error("An error ocurred trying to retrieve the item: " + e);
        }
        return null;
    }

    public List<String> getAllItemModels() {
        try {
            List<T> peripheralList = new ArrayList<>();
            repository.findAll().forEach(peripheralList::add);
            return peripheralList.stream().map(PeripheralEntity::getModel).toList();
        } catch (Exception e) {
            log.error("An error ocurred trying to retrieve the items: " + e);
            return List.of("An error ocurred trying to retrieve the items");
        }
    }

    public String saveItem(R input) {
        try {
            T entity = this.inputDTOToEntity(input);
            repository.save(entity);
            return "Item saved successfully";
        } catch (Exception e) {
            log.error("An error ocurred trying to save the item: " + e);
            return "An error ocurred trying to save the item";
        }
    }

    public String sellItem(Long id) {
        try {
            Optional<T> opt = repository.findById(id);
            if (opt.isPresent()) {
                T entity = opt.get();
                if (entity.getStock() > 0) {
                    entity.setStock(entity.getStock() - 1);
                    repository.save(entity);
                    return String.format("Item sold successfully. New stock: %s", entity.getStock());
                } else {
                    return "This item is out of stock";
                }
            }
        } catch (Exception e) {
            log.error("An error ocurred trying to sell the item: " + e);
            return "An error ocurred trying to sell the item";
        }
        return "Item does not exist";
    }

    public String updateItem(Long id, R input) {
        try {
            Optional<T> opt = repository.findById(id);
            if (opt.isPresent()) {
                T entity = this.partialInputDTOToEntity(input, opt.get());
                repository.save(entity);
                return "Item updated successfully";
            }
        } catch (Exception e) {
            log.error("An error ocurred trying to update the item: " + e);
            return "An error ocurred trying to update the item";
        }
        return "Item does not exist";

    }

    public String deleteItem(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            log.error("An error ocurred trying to delete the item: " + e);
            return "An error ocurred trying to delete the item";
        }
        return "Item does not exist";

    }

}
