package org.example.functional_lambda.basic_interface;

import java.util.function.Supplier;

public class SupplierExample {
    // 입력 파라미터는 없고 리턴 타입만 존재
    // 지정된 정보를 확인하거나 조회
    public static String executeSupplier(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String version = "java upgrade book";
        SupplierExample.executeSupplier(() -> {
            return version;
        });
    }
}
