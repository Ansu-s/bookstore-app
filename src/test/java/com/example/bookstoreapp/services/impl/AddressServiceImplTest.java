package com.example.bookstoreapp.services.impl;

import com.example.bookstoreapp.BookstoreAppApplication;
import com.example.bookstoreapp.entities.AddressEntity;
import com.example.bookstoreapp.models.Address;
import com.example.bookstoreapp.repositories.AddressRepository;
import com.example.bookstoreapp.services.UserSessionService;
import com.example.bookstoreapp.utils.IdGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(BookstoreAppApplication.class)
class AddressServiceImplTest {

    @InjectMocks
    AddressServiceImpl addressService;
    @Mock
    AddressRepository addressRepository;
    @Mock
    UserSessionService userSessionService;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        Address addedAddress = new Address(1L, 11L, "House-1", "Building-1", "BBSR", "Odisha", "India", "751024");


        Mockito.when(IdGenerator.getLongId()).thenReturn(5L);
        addedAddress.setId(IdGenerator.getLongId());

        Mockito.when(userSessionService.getUserId()).thenReturn(5625L);
        addedAddress.setUserId(userSessionService.getUserId());


        AddressEntity addressEntity = addedAddress.toEntity();
        addressEntity = addressRepository.save(addressEntity);
        Address addressFromEntity = addedAddress.fromEntity(addressEntity);

        Assertions.assertEquals("BBSR", addressFromEntity.getCity());


    }

    @Test
    void updateAddress() {
    }

    @Test
    void findById() {
    }

    @Test
    void findUserAddress() {
    }

    @Test
    void removeAddressById() {
    }
}