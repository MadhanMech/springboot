package com.codesnippet.ecom.Controller;

import com.codesnippet.ecom.Entity.ErrorResponse;
import com.codesnippet.ecom.Entity.Product;
import com.codesnippet.ecom.Service.ProductService;
import com.codesnippet.ecom.exceptions.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product/v1")
public class ProductController {
	@Autowired
	ProductService productService;
//Tranditional Way Exception Handling
	//In traditional code duplication will happen
//	@GetMapping("/getProductById/{productId}")
//	public ResponseEntity<?> getBookById(@PathVariable("productId") Integer productId) {
//		try {
//			Product product = productService.findById(productId)
//					.orElseThrow(() -> new ProductNotFoundException("Product not founds with id: " + productId));
//			return ResponseEntity.ok(product);
//		} catch (ProductNotFoundException e) {
//			ErrorResponse error=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Product Not Found At "+productId);
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//            
//		}
//
//	}
	
	
// Exception Handler Method 

	
	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<?> getBookById(@PathVariable("productId") Integer productId) {
		//when use ExceptionHandler annotation dont't need try catch also ,annotation will automatically handle exception inside that controller
//		try {
//			Product product = productService.findById(productId)
//					.orElseThrow(() -> new ProductNotFoundException("Product not founds with id: " + productId));
//			return ResponseEntity.ok(product);
//		} catch (ProductNotFoundException e) {
//			return handleProductNotFoundException(e,productId);
//            
//		}
//	
		
			Product product = productService.findById(productId)
					.orElseThrow(() -> new ProductNotFoundException("Product not founds with id: " + productId));
			return ResponseEntity.ok(product);
		
	
	}

	

	@GetMapping("/getProductByName/{name}")
	public ResponseEntity<?> getProductByName(@PathVariable String name) {
		Product product = productService.findByName(name)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + name));
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) throws InterruptedException {
		// print
		Product createdProduct = productService.addProduct(product);
		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}
	
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<?>handleProductNotFoundException(ProductNotFoundException e){
//		ErrorResponse error=new ErrorResponse(LocalDateTime.now(),e.getMessage(),"Product Not Found At ");
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
//		
//	}

}
