package com.Halal.Believer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLays {
    @Autowired
    private Dao laysdao;

    public Optional<Product> getProductByBarcode(String barcode) {
        return laysdao.findByBarcode(barcode);
    }

    public List<Product> getAll() {
        return laysdao.findAll();
    }

    public Optional<Product> getById(Long id) {
        return laysdao.findById(id);
    }

    public Product saveLays(Product lays) {
        return laysdao.save(lays);
    }

    public Product updateLays(Long id, Product laysUpdated) {
        Optional<Product> optionalLays = laysdao.findById(id);

        if (optionalLays.isPresent()) {
        	Product lays = optionalLays.get();

            lays.setBrand(laysUpdated.getBrand());
            lays.setCountryOfOrigin(laysUpdated.getCountryOfOrigin());
            lays.setExpiry(laysUpdated.getExpiry());
            lays.setFlavor(laysUpdated.getFlavor());
            lays.setGlutenFree(laysUpdated.isGlutenFree());
            lays.setHalal(laysUpdated.isHalal());
            lays.setIngredients(laysUpdated.getIngredients());
            lays.setManufacturingDate(laysUpdated.getManufacturingDate());
            lays.setNutritionalInformation(laysUpdated.getNutritionalInformation());
            lays.setPackagingType(laysUpdated.getPackagingType());
            lays.setPrice(laysUpdated.getPrice());
            lays.setProductName(laysUpdated.getProductName());
            lays.setVegan(laysUpdated.isVegan());
            lays.setWeight(laysUpdated.getWeight());

            return laysdao.save(lays);
        } else {
            throw new RuntimeException("ID not found: " + id);
        }
    }

    public Optional<Product> voteOnHalalStatus(String barcode, boolean agree, boolean undo) {
        Optional<Product> productOptional = laysdao.findByBarcode(barcode);
        if (productOptional.isPresent()) {
        	Product product = productOptional.get();

            // Update vote count based on agree and undo
            if (undo) {
                if (agree) {
                    product.setAgreeCount(product.getAgreeCount() - 1);
                } else {
                    product.setDisagreeCount(product.getDisagreeCount() - 1);
                }
            } else {
                if (agree) {
                    product.setAgreeCount(product.getAgreeCount() + 1);
                } else {
                    product.setDisagreeCount(product.getDisagreeCount() + 1);
                }
            }

            // Save the updated product
            Product updatedProduct = laysdao.save(product);

            // Return the updated product with the new counts
            return Optional.of(updatedProduct);
        } else {
            return Optional.empty();
        }
    }



    public void deleteLays(Long id) {
        laysdao.deleteById(id);
    }
}