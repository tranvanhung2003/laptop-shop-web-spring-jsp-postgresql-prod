package com.tvhung.laptop_shop.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
    AVATAR("avatar"),
    PRODUCT("product");

    private final String folderName;
}
