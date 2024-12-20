
  package com.Halal.Believer;
  
  import java.util.List; import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
  
  
  @RestController
  
  @RequestMapping("/api/lays")
   public class Controller {
  
  @Autowired 
  private ServiceLays laysService;
  
  
  @GetMapping("/scan/{barcode}")
  public ResponseEntity<Product> getProductByBarcode(@PathVariable String barcode) {
      Optional<Product> product = laysService.getProductByBarcode(barcode);

      if (product.isPresent()) {
          return ResponseEntity.ok(product.get());
      } else {
          return ResponseEntity.notFound().build();
      }
  }

  @PostMapping("/{barcode}/vote")
  public ResponseEntity<Product> voteOnHalalStatus(
          @PathVariable String barcode,
          @RequestParam boolean agree,
          @RequestParam boolean undo) {
      System.out.println("Received vote for barcode: " + barcode + ", agree: " + agree + ", undo: " + undo);
      Optional<Product> updatedProduct = laysService.voteOnHalalStatus(barcode, agree, undo);
      if (updatedProduct.isPresent()) {
          System.out.println("Updated product: " + updatedProduct.get());
          Product product = updatedProduct.get();
          return ResponseEntity.ok(product);  // Return the updated product with new counts
      } else {
          System.out.println("Product not found for barcode: " + barcode);
          return ResponseEntity.notFound().build();
      }
  }

  
  @PostMapping 
  public Product postLays(@RequestBody Product lays) { return
  laysService.saveLays(lays);
  
  
  }
  
  
  @DeleteMapping("/{id}") 
  public ResponseEntity<Object> deleteLa(@PathVariable  Long id) {
  
  laysService.deleteLays(id);
  
  return ResponseEntity.noContent().build(); }
  
  @GetMapping
  public List<Product> findAllLays() {
  
  return laysService.getAll();
  
  }
  
  @GetMapping("/{id}") 
  public ResponseEntity<Product> findByIdLays(@PathVariable  Long id) {
  
  Optional<Product> lal= laysService.getById(id);
  
  if(lal.isPresent()) {
  
  return ResponseEntity.ok(lal.get()); }
  
  else {return ResponseEntity.notFound().build();}
  
  
  }
  
  @PutMapping("/{id}") 
  public ResponseEntity<Product> layUpdate(@PathVariable Long  id, @RequestBody Product lay) { 
	  
	  try { 
		  Product updatedLays = laysService.updateLays(id, lay);  
  
  return ResponseEntity.ok(lay);  
  
  } catch (RuntimeException e) {
	  // TODO: handle exception return
	  System.err.println("Error updating product: " + e.getMessage());
  return ResponseEntity.notFound().build(); }
  
  
  
  
  }
  
  
  }
 