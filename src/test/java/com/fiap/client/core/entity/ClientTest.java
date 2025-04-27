//package com.fiap.client.core.entity;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.Collections;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
//
//class ClientTest {
//
//    @Test
//    void shloudCreateClient() {
//        Client client = new Client("Client Name", LocalDate.now(), "99999999999", Collections.emptyList());
//        assertThat(client.getName()).isEqualTo("Client Name");
//    }
//
//    @Test
//    void shloudReturnErrorCPFNull() {
//        var exception = catchThrowable(() -> new Client(null, "Client Name", LocalDate.now(), "99999999999", Collections.emptyList()));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("CPF cannot be null");
//    }
//
//    @Test
//    void shloudReturnCpfInvalid() {
//        var exception = catchThrowable(() -> new Client("123", "Client Name", LocalDate.now(), "99999999999", Collections.emptyList()));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("CPF must be between 5 and 20 characters");
//    }
//
//    @Test
//    void shloudReturnNameNull() {
//        var exception = catchThrowable(() -> new Client("123456", null, LocalDate.now(), "99999999999", Collections.emptyList()));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Name cannot be null");
//    }
//
//    @Test
//    void shloudReturnNameInvalid() {
//        var exception = catchThrowable(() -> new Client("123456", "", LocalDate.now(), "99999999999", Collections.emptyList()));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Name must be between 3 and 50 characters");
//    }
//
//    @Test
//    void shloudReturnBirthDateNull() {
//        var exception = catchThrowable(() -> new Client("123456", "Client Name", null, "Client Description", Collections.emptyList()));
//        assertThat(exception)
//                .isInstanceOf(IllegalStateException.class)
//                .hasMessage("Price cannot be null");
//    }
//}
