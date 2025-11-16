package com.codesnippet.ecom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.codesnippet.ecom.Entity.Product;
import com.codesnippet.ecom.Repository.ProductRepository;
import com.codesnippet.ecom.Service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService productService;
    private static Product product= null;
    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll");
        product = new Product();
        product.setId(1);
        product.setName("Book");
        product.setDescription("harry potter");
        product.setPrice(200);
    }
    @BeforeEach
    public void initEachTest(){
        System.out.println("BeforeEach");
    }

    @Test
    void addProductShouldAddProductSuccessfully(){
        when(productRepository.save(product)).thenReturn(product);

        Product addedProduct = productService.addProduct(product);

        assertNotNull(addedProduct);
        assertEquals(product.getId(),addedProduct.getId());
        assertEquals(product.getName(),addedProduct.getName());
        assertTrue(product.getId()==1);
    }


    @Test
    void addProductShouldThrowExceptionForInvalidProductName(){
        product.setName("");
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            productService.addProduct(product);
        });
        assertEquals("Invalid Name Of Product",runtimeException.getMessage());
        verify(productRepository, never() ).save(any(Product.class));
    }
    @Test
    public void deleteProductShouldDeleteProductSuccessfully(){
        doNothing().when(productRepository).deleteById(1);//when method not return nothing we should use this line
        productService.deleteProduct(1);
        verify(productRepository, times(1) ).deleteById(1);//it verfity delectProduct method will exe cute one time or not
    }
    @Test
    void testPrivateMethod_validateProductName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateProductName = ProductService.class.getDeclaredMethod("validateProductName", String.class);
        validateProductName.setAccessible(true);
        Boolean book = (Boolean) validateProductName.invoke(productService, "Book");
        assertTrue(book);
    }

    @Test
    void testPrivateMethod_validateProductNameIfNameIsInvalid() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method validateProductName = ProductService.class.getDeclaredMethod("validateProductName", String.class);
        validateProductName.setAccessible(true);
        Boolean book = (Boolean) validateProductName.invoke(productService, "");
        assertFalse(book);
    }

    @AfterAll
    public static void Destroy(){
        System.out.println("AfterAll");
    }
    @AfterEach
    public void cleanup(){
        System.out.println("AfterEach");
    }
}
