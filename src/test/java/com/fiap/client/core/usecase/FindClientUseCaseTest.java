//package com.fiap.client.core.usecase;
//
//import com.fiap.client.core.entity.Client;
//import com.fiap.client.core.gateway.ClientGateway;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class FindClientUseCaseTest {
//
//    @Mock
//    private ClientGateway clientGateway;
//
//    @InjectMocks
//    private FindClientUseCase findClientUseCase;
//
//    @Test
//    void shouldFindProduct() {
//        var sku = "123456";
//
//        var product = new Client("idProduct", sku, "Product Name", BigDecimal.TEN, "Product Description", Category.ELECTRONICS);
//        when(clientGateway.findBySku(sku)).thenReturn(Optional.of(product));
//
//        findClientUseCase.execute(sku);
//
//        verify(clientGateway, times(1)).findBySku(sku);
//        assertThat(product.getSku()).isEqualTo(sku);
//        assertThat(product.getName()).isEqualTo("Product Name");
//        assertThat(product.getPrice()).isEqualTo(BigDecimal.TEN);
//        assertThat(product.getDescription()).isEqualTo("Product Description");
//        assertThat(product.getCategory()).isEqualTo(Category.ELECTRONICS);
//    }
//
//
//    @Test
//    void shouldReturnProductNotFound() {
//        var sku = "123456";
//
//        when(clientGateway.findBySku(sku)).thenReturn(Optional.empty());
//
//        var exception = catchThrowable(() -> findClientUseCase.execute(sku));
//
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Product not found with SKU: " + sku);
//
//        verify(clientGateway, times(1)).findBySku(sku);
//    }
//}
