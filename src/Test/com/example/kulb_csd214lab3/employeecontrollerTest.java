package com.example.kulb_csd214lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class employeecontrollerTest {

    @Test
    void calculatesalary() {
        employeecontroller x = new employeecontroller();

        assertEquals(x.calculatesalary(4000.00), 48000);

    }
}