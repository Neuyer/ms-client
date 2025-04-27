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
//class DeleteClientUseCaseTest {
//
//    @Mock
//    private ClientGateway clientGateway;
//
//    @InjectMocks
//    private DeleteClientUseCase deleteClientUseCase;
//
//    @Test
//    void shouldDeleteProduct() {
//        var sku = "123456";
//        var product = new Client("123456", "Product Name", BigDecimal.TEN, "Product Description", Category.ELECTRONICS);
//
//        when(clientGateway.findBySku(sku)).thenReturn(Optional.of(product));
//        doNothing().when(clientGateway).deleteBySku(sku);
//
//        deleteClientUseCase.execute(sku);
//
//        verify(clientGateway, times(1)).deleteBySku(sku);
//    }
//
//    @Test
//    void shouldReturnProductNotFound() {
//        var sku = "123456";
//
//        when(clientGateway.findBySku(sku)).thenReturn(Optional.empty());
//
//        var exception = catchThrowable(() -> deleteClientUseCase.execute(sku));
//
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Product not found with SKU: " + sku);
//
//        verify(clientGateway, times(1)).findBySku(sku);
//    }
//}
