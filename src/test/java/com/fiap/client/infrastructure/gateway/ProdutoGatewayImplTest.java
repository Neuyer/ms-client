//package com.fiap.client.infrastructure.gateway;
//
//import com.fiap.client.core.entity.Client;
//import com.fiap.client.infrastructure.repository.ClientRepository;
//import com.fiap.client.infrastructure.repository.model.ClientModel;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class ProdutoGatewayImplTest {
//
//    @Mock
//    private ClientRepository clientRepository;
//
//    @InjectMocks
//    private ClientGatewayImpl productGateway;
//
//    @Test
//    void shouldProductBySku() {
//        String sku = "12345";
//        var productModel = ClientModel.builder()
//                .id("1")
//                .sku(sku)
//                .name("Test Product")
//                .price(BigDecimal.valueOf(10.0))
//                .description("Test Description")
//                .category(Category.CLOTHING)
//                .build();
//
//        when(clientRepository.findBySku(sku)).thenReturn(Optional.of(productModel));
//        var productOpt = productGateway.findBySku(sku);
//
//        assertTrue(productOpt.isPresent());
//
//        var product = productOpt.get();
//        assertThat(product).isInstanceOf(Client.class);
//        assertThat(product.getId()).isEqualTo(productModel.getId());
//        assertThat(product.getSku()).isEqualTo(sku);
//        assertThat(product.getName()).isEqualTo(productModel.getName());
//        assertThat(product.getPrice()).isEqualTo(productModel.getPrice());
//        assertThat(product.getDescription()).isEqualTo(productModel.getDescription());
//        assertThat(product.getCategory()).isEqualTo(productModel.getCategory());
//    }
//
//    @Test
//    void shouldFindAllProducts() {
//        var productModel1 = ClientModel.builder()
//                .id("1")
//                .sku("12345")
//                .name("Test Product")
//                .price(BigDecimal.valueOf(10.0))
//                .description("Test Description")
//                .category(Category.CLOTHING)
//                .build();
//
//        var productModel2 = ClientModel.builder()
//                .id("2")
//                .sku("67890")
//                .name("Test Product 2")
//                .price(BigDecimal.valueOf(10.0))
//                .description("Test Description 2")
//                .category(Category.CLOTHING)
//                .build();
//
//
//        when(clientRepository.findAll()).thenReturn(List.of(productModel1, productModel2));
//        var products = productGateway.findAll();
//
//        assertThat(products).hasSize(2);
//    }
//
//    @Test
//    void shouldSaveProduct() {
//        var productModel = ClientModel.builder()
//                .id("1")
//                .sku("12345")
//                .name("Test Product")
//                .price(BigDecimal.valueOf(10.0))
//                .description("Test Description")
//                .category(Category.CLOTHING)
//                .build();
//
//        var productEntity = new Client(
//                "1",
//                "12345",
//                "Test Product",
//                BigDecimal.valueOf(10.0),
//                "Test Description",
//                Category.CLOTHING
//        );
//
//        when(clientRepository.save(productModel)).thenReturn(productModel);
//        productGateway.save(productEntity);
//
//        verify(clientRepository, times(1)).save(productModel);
//    }
//
//    @Test
//    void shouldDeleteProductBySku() {
//        String sku = "12345";
//        doNothing().when(clientRepository).deleteBySku(sku);
//        productGateway.deleteBySku(sku);
//        verify(clientRepository, times(1)).deleteBySku(sku);
//    }
//}
